package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBytesSerializer;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfImageEncryptor;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfPDFUtils;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse.ImageInfoBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsImpl;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.report.EncryptKeyGenerator;

/**
 * ID指定イメージ取得サービスメインクラス
 */
public class WSGetImageByIdImpl implements WSGetImageById {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTargetImagePropsImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private IwfImageEncryptor encryptor;


    public WSGetImageByIdImpl() {
        super();
    }

    public WSGetImageByIdResponse validate(WSGetImageByIdRequest request)
        throws Exception {
        WSGetImageByIdResponse oResponse = new WSGetImageByIdResponse();

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
            return oResponse;
        }

        if (sImageIds == null ||
            sImageIds.length == 0) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージＩＤ配列");
            return oResponse;
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSGetImageByIdRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetImageByIdResponse executeBizMain(
        WSGetImageByIdRequest request) throws Exception {


        WSGetImageByIdResponse oWSResponse = new WSGetImageByIdResponse();

        oWSResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<ImageInfoBean> imageInfos = new ArrayList<ImageInfoBean>();
        ImageInfoBean imageInfoBean = new ImageInfoBean();

        try {
            oWfCon.open();

            List<WT_TorikomiKanri> kanriList = iwfCoreDomManager.getTorikomiKanrisByImageIds(sImageIds);
            Iterator<WT_TorikomiKanri> itrkanri = kanriList.iterator();
            WT_TorikomiKanri kanri = null;

            while(itrkanri.hasNext()){
                kanri = itrkanri.next();

                String sImageId_kanri = kanri.getIwfImageId();
                String sTorikomiSyoruiCd_kanri = kanri.getTorikomiSyoruiCd();

                List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd_kanri);
                Iterator<WM_TorikomiSyorui> itrsyorui = syoruiList.iterator();
                WM_TorikomiSyorui syorui = null;

                String sFlowId_syorui = null;
                if(itrsyorui.hasNext()){
                    while(itrsyorui.hasNext()){
                        syorui = itrsyorui.next();

                        sFlowId_syorui = syorui.getFlowId();
                    }
                } else {
                    IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3052);
                    return oWSResponse;
                }

                List<WT_Page> pageList = iwfCoreDomManager.getPages(sImageId_kanri);
                Iterator<WT_Page> itrpage = pageList.iterator();
                WT_Page page = null;

                ArrayList<byte[]> oBytes = new ArrayList<byte[]>();
                String sSyoruiToutyakuTime = "";

                if(itrpage.hasNext()){
                    while(itrpage.hasNext()){
                        page = itrpage.next();

                        String sImageId = page.getIwfImageId();
                        String sPageId = page.getPageId();

                        if(StringUtils.isEmpty(sSyoruiToutyakuTime)){
                            sSyoruiToutyakuTime = page.getSyoruittykymdtime();
                        }

                        WT_PDFHozon wT_PDFHozon = iwfCoreDomManager.getPDFHozon(sImageId, sPageId);

                        byte[] pdf = wT_PDFHozon.getPdfData();
                        if(C_YesNoKbn.YES.eq(syorui.getAngoukaKbn())){
                            String encryptKey = null;
                            if(C_AngoukaHousikiKbn.PACKAGE.eq(syorui.getAngoukaHousikiKbn())){
                                encryptKey = sImageId;
                            }else{
                                try {
                                    encryptKey = SWAKInjector.getInstance(EncryptKeyGenerator.class).gerenateKey();
                                } catch(Exception e) {
                                    LOGGER.debug("EncryptKeyGeneratorの実装またはバインドがされていません。");
                                    throw e;
                                }
                            }
                            encryptor.setKey(encryptKey);
                            pdf = encryptor.decode(pdf);
                        }
                        if(C_YesNoKbn.YES.eq(syorui.getZipHozonKbn())){
                            pdf = IwfBytesSerializer.unzip(pdf);
                        }

                        oBytes.add(pdf);
                    }
                }

                byte[] oPDFImage = null;
                if(!oBytes.isEmpty()){
                    oPDFImage = IwfPDFUtils.concatPDF(oBytes);
                }

                List<WT_TorikomiRelation> torikomiRelations = iwfCoreDomManager.getTorikomiRelationsByImageId(sImageId_kanri);

                for (WT_TorikomiRelation torikomiRelation : torikomiRelations) {
                    String sGyoumuKey = torikomiRelation.getGyoumuKey();

                    String sTokenId = "";
                    WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId_syorui, sGyoumuKey);
                    if (null == wT_GyoumuKey) {
                        LOGGER.warn("該当の業務キーとフローIDの組み合わせは存在しません。[gyoumukey = " + sGyoumuKey + " flowId = "
                            + sFlowId_syorui + "]");
                    } else {
                        sTokenId = wT_GyoumuKey.getTokenId();
                    }

                    if (StringUtils.isEmpty(sTokenId)) {
                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3050);
                        return oWSResponse;
                    }

                    IWorkflowProcessDef oProcess;
                    try {
                        oProcess = oWfCon.getProcessDef(sFlowId_syorui);
                    } catch (WorkflowRuntimeException e) {
                        iwfCoreDomManager.clear();
                        if (oWfCon.isOpen()) {
                            oWfCon.close();
                        }

                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3051);

                        return oWSResponse;
                    }

                    String sKengenumu = IwfCommonLogic.getKengenUmu(iwfCoreDomManager,sAccountId,sTorikomiSyoruiCd_kanri).getValue();

                    imageInfoBean = new ImageInfoBean();

                    imageInfoBean.setImageid(sImageId_kanri);
                    imageInfoBean.setGyoumukey(sGyoumuKey);
                    imageInfoBean.setTorikomisyoruicd(sTorikomiSyoruiCd_kanri);
                    imageInfoBean.setSyoruitoutyakutime(sSyoruiToutyakuTime);
                    imageInfoBean.setKengenumu(sKengenumu);
                    imageInfoBean.setPdfimage(oPDFImage);

                    imageInfos.add(imageInfoBean);
                }
            }

            oWSResponse.setImageinfolist(imageInfos);

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "ID指定イメージ取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ID指定イメージ取得");
        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oWSResponse;
    }

    public WSGetImageByIdResponse getStubResult(
        WSGetImageByIdRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSGetImageByIdRequest request, WSGetImageByIdResponse response) throws Exception {
        LOGGER.debug("│終了開始・・・");
    }

    public WSGetImageByIdResponse getBootErrResponse() {
        WSGetImageByIdResponse res = new WSGetImageByIdResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
