package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBytesSerializer;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfImageEncryptor;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfPDFUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.common.workflowcore.iwfcommon.pga.PdfPage;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.report.EncryptKeyGenerator;

import com.lowagie.text.pdf.PdfReader;

/**
 * イメージ登録サービスのプロバイダークラスです。
 */
public class WSPutImageImpl implements WSPutImage {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSPutImageImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private IwfImageEncryptor encryptor;

    @Inject
    private UniqueKeyGenerator generator;

    public static final String sJIMUTETUZUKI_MITEI      =   "__TETUZUKI_MITEI__";

    public WSPutImageImpl() {
        super();
    }


    public void initialize(WSPutImageRequest request) throws Exception {

        LOGGER.debug("│初期化処理開始・・・");

    }

    public WSPutImageResponse validate(
        WSPutImageRequest request) throws Exception {

        WSPutImageResponse oResponse = new WSPutImageResponse();

        String sGyoumukey = request.getGyoumukey();
        String sAccountId = request.getAccountid();
        String sFlowid = request.getFlowid();
        String sSyoruicd = request.getSyoruicd();
        String sImagedatastr = request.getImagedatastr();
        String sSyoruitoutyakutime = request.getSyoruitoutyakutime();
        String sTourokutime = request.getTourokutime();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sSyoruicd, "取込書類コード", 30)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowid, "フローＩＤ", 19)) {
            return oResponse;
        }
        if(StringUtils.isEmpty(sImagedatastr)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージデータ");
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sGyoumukey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sSyoruitoutyakutime, "書類到着日時", 17)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sTourokutime, "登録日時", 17)) {
            return oResponse;
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSPutImageRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSPutImageResponse executeBizMain(
        WSPutImageRequest request) throws Exception {

        WSPutImageResponse oResponse = new WSPutImageResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sAccountId = request.getAccountid();
        String sFlowid = request.getFlowid();
        String sGyoumukey = request.getGyoumukey();
        String sSyoruicd = request.getSyoruicd();
        String sSyoruitoutyakutime = request.getSyoruitoutyakutime();
        String sTourokutime = request.getTourokutime();
        String sImagedatastr = request.getImagedatastr();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);
        byte[] oExtinfo = null;
        if (request.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(request.getExtinfo()).getBytes("UTF-8");
        }
        byte[] btDatas= null;

        String sTokenId = null;

        String sImageid = generator.generateUniqueKey();


        btDatas = IwfBase64Urls.decode(sImagedatastr);

        if(btDatas == null) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3090, sImagedatastr);

            return oResponse;

        }

        if (StringUtils.isEmpty(sTourokutime)) {
            sTourokutime = IwfDateUtils.getSysDate();
        }
        if (StringUtils.isEmpty(sSyoruitoutyakutime)) {
            sSyoruitoutyakutime = IwfDateUtils.getSysDate();
        }

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();
        oWfCon.open();

        try {


            if (sFlowid != null) {
                try {
                    oWfCon.getProcessDef(sFlowid);
                } catch (WorkflowRuntimeException e) {
                    iwfCoreDomManager.clear();
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3091);

                    return oResponse;
                }
            }
            else{
                sFlowid = sJIMUTETUZUKI_MITEI;
            }

            List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sSyoruicd);

            if(syoruiList.size() == 0) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3092);
                return oResponse;

            }

            LOGGER.debug(" 取込管理TBLへの登録します。");
            WT_TorikomiKanri torikomikanriBean = new WT_TorikomiKanri();
            torikomikanriBean.setIwfImageId(sImageid);
            torikomikanriBean.setTorikomiSyoruiCd(sSyoruicd);
            torikomikanriBean.setTourokuId(sAccountId);
            torikomikanriBean.setTourokuTime(sTourokutime);
            torikomikanriBean.setKousinsyaId(sAccountId);
            torikomikanriBean.setKousinTime(IwfDateUtils.getSysDate());
            setExtParams(torikomikanriBean, extParamMap);
            iwfCoreDomManager.insert(torikomikanriBean);

            WT_TorikomiRelation torikomiRelationBean = new WT_TorikomiRelation();
            torikomiRelationBean.setIwfImageId(sImageid);
            torikomiRelationBean.setGyoumuKey(sGyoumukey);
            iwfCoreDomManager.insert(torikomiRelationBean);

            torikomikanriBean.setTorikomiRelation(Arrays.asList(torikomiRelationBean));

            WM_TorikomiSyorui syorui = iwfCoreDomManager.getTorikomiSyorui(sSyoruicd);

            PdfPage[] oBeans = IwfPDFUtils.split(new PdfReader(btDatas));

            int iPages = 1;
            for(PdfPage page : oBeans){

                LOGGER.debug( iPages + "ページ目取り込み");
                String sPageid = generator.generateUniqueKey();

                byte[] pdf = page.getS_pdfdata();
                if(C_YesNoKbn.YES.eq(syorui.getZipHozonKbn())){
                    pdf = IwfBytesSerializer.zip(pdf);
                }

                if(C_YesNoKbn.YES.eq(syorui.getAngoukaKbn())){
                    String encryptKey = null;
                    if(C_AngoukaHousikiKbn.PACKAGE.eq(syorui.getAngoukaHousikiKbn())){
                        encryptKey=sImageid;
                    }else{
                        try {
                            encryptKey = SWAKInjector.getInstance(EncryptKeyGenerator.class).gerenateKey();
                        } catch(Exception e) {
                            LOGGER.debug("EncryptKeyGeneratorの実装またはバインドがされていません。");
                            throw e;
                        }
                    }
                    encryptor.setKey(encryptKey);
                    pdf = encryptor.encode(pdf);
                }

                WT_PDFHozon itPdfhozon = new WT_PDFHozon();
                itPdfhozon.setPdfData(pdf);
                itPdfhozon.setIwfImageId(sImageid);
                itPdfhozon.setPageId(sPageid);
                itPdfhozon.setKousinsyaId(sAccountId);
                itPdfhozon.setKousinTime(IwfDateUtils.getSysDate());
                iwfCoreDomManager.insert(itPdfhozon);

                WT_Page itPage = new WT_Page();
                itPage.setIwfImageId(sImageid);
                itPage.setSyoruittykymdtime(sSyoruitoutyakutime);
                itPage.setPageno(iPages);
                itPage.setTorikomiSousasyaId(sAccountId);
                iPages++;
                itPage.setKousinsyaId(sAccountId);
                itPage.setKousinTime(IwfDateUtils.getSysDate());
                itPage.setPageId(sPageid);
                iwfCoreDomManager.insert(itPage);

            }

            LOGGER.debug("工程履歴を登録します。");
            if (sGyoumukey != null) {

                WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowid, sGyoumukey);
                if (null != gyoumuKey) {
                    sTokenId = gyoumuKey.getTokenId();
                }
                else {
                    iwfCoreDomManager.clear();
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3093);

                    return oResponse;
                }

                IWorkflowToken token;
                try {
                    IWorkflowProcessDef def = oWfCon.getProcessDef(sFlowid);
                    token = def.getToken(sTokenId);

                } catch (WorkflowRuntimeException e) {
                    iwfCoreDomManager.clear();
                    if (oWfCon.isOpen()) {
                        oWfCon.close();
                    }
                    LOGGER.error("トークンを取得できませんでした。[Flowid="+ sFlowid + ", TokenId=" + sTokenId + "]");
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ登録");

                    return oResponse;
                }

                String sNodeName;
                String sNodeId;
                if (token == null) {
                    sNodeName = "";
                    sNodeId = "";
                } else {
                    sNodeName = token.getNodeName();
                    sNodeId = token.getNodeId();
                }

                IwfCommonLogic.createKouteiRireki(
                    sFlowid,
                    gyoumuKey.getTokenId(),
                    sGyoumukey,
                    sNodeId,
                    sNodeName,
                    C_IwfSyoriKbn.PUTIMAGE,
                    sAccountId,
                    C_RirekiKbn.SYSTEM,
                    oExtinfo,
                    iwfCoreDomManager);

                WT_KouteiSummary summary = IwfCommonLogic.updateKouteiSummaryTime(sGyoumukey, iwfCoreDomManager);
                torikomiRelationBean.setKouteiSummary(summary);
            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "イメージ登録");
            oResponse.setImgid(sImageid);

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ登録");

        } finally {
            if (oWfCon.isOpen()) {
                oWfCon.close();
            }
        }
        return oResponse;
    }

    @SuppressWarnings("deprecation")
    private void setExtParams(WT_TorikomiKanri entity, Map<String, WSExtParam> extParamMap) {

        if (null == extParamMap) {
            return;
        }

        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM1)) {
            entity.setExtParam1(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM1).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM2)) {
            entity.setExtParam2(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM2).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM3)) {
            entity.setExtParam3(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM3).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM4)) {
            entity.setExtParam4(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM4).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM5)) {
            entity.setExtParam5(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM5).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM6)) {
            entity.setExtParam6(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM6).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM7)) {
            entity.setExtParam7(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM7).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM8)) {
            entity.setExtParam8(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM8).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM9)) {
            entity.setExtParam9(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM9).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM10)) {
            entity.setExtParam10(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM10).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM11)) {
            entity.setExtParam11(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM11).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM12)) {
            entity.setExtParam12(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM12).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM13)) {
            entity.setExtParam13(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM13).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM14)) {
            entity.setExtParam14(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM14).getValue());
        }
        if (null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM15)) {
            entity.setExtParam15(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM15).getValue());
        }
    }

    public WSPutImageResponse getStubResult(
        WSPutImageRequest request) throws Exception {

        return null;
    }

    public WSPutImageResponse getBootErrResponse() {
        WSPutImageResponse res = new WSPutImageResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
