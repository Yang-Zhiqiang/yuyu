package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage;

import iwf.callback.arriveimage.imageTerminator.WSImageTerminator;
import iwf.callback.arriveimage.imageTerminator.WSImageTerminatorRequest;
import iwf.callback.arriveimage.imageTerminator.WSImageTerminatorResponse;
import iwf.callback.arriveimage.toutyakuYoteiNotFound.WSToutyakuYoteiNotFound;
import iwf.callback.arriveimage.toutyakuYoteiNotFound.WSToutyakuYoteiNotFoundRequest;
import iwf.callback.arriveimage.toutyakuYoteiNotFound.WSToutyakuYoteiNotFoundResponse;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBytesSerializer;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfImageEncryptor;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfPDFUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.common.workflowcore.iwfcommon.pga.PdfPage;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.report.EncryptKeyGenerator;

import com.lowagie.text.pdf.PdfReader;

/**
 * 到着イメージ登録サービスのプロバイダークラスです。
 */
public class WSPutArrivalImageImpl implements WSPutArrivalImage {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private IwfImageEncryptor encryptor;

    @Inject
    WSToutyakuYoteiNotFound toutyakuYoteiNotFoundService;

    @Inject
    WSImageTerminator imageTerminatorService;

    WT_ImageArriveNotice arriveNoticeInfo = null;

    final static Logger LOGGER = LoggerFactory.getLogger(WSPutArrivalImageImpl.class);

    @Inject
    private UniqueKeyGenerator generator;

    public WSPutArrivalImageImpl() {
        super();
    }

    public void initialize(WSPutArrivalImageRequest request) throws Exception {

        LOGGER.debug("│初期化処理開始・・・");
    }

    public WSPutArrivalImageResponse validate(
        WSPutArrivalImageRequest request) throws Exception {

        WSPutArrivalImageResponse oResponse = new WSPutArrivalImageResponse();

        String sArrivekey = request.getArrivekey();
        String sImagedatastr = request.getImagedatastr();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sArrivekey, "到着キー", 50)) {
            return oResponse;
        } else if (!sArrivekey.equals(sArrivekey.trim())) {
            LOGGER.debug(IwfMessageUtil.getMessage(IwfMessageCd.IWF0011, sArrivekey));
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着イメージ登録");
            return oResponse;
        }

        if (StringUtils.isEmpty(sImagedatastr)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージデータ");
            return oResponse;
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSPutArrivalImageRequest.sSERVICE_NAME;
    }

    @Override
    public WSPutArrivalImageResponse executeBizMain(
        WSPutArrivalImageRequest request) throws Exception {

        WSPutArrivalImageResponse oResponse = new WSPutArrivalImageResponse();

        String sArrivekey = request.getArrivekey();


        try {

            String sImageid = generator.generateUniqueKey();

            oResponse = doBizMain(sArrivekey, sImageid, request, oResponse);

            if (!C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                doTerminate(sArrivekey, sImageid, arriveNoticeInfo, oResponse);
            }

        } catch (Exception e) {
            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
        }

        return oResponse;
    }

    @Transactional
    public WSPutArrivalImageResponse doBizMain(String sArrivekey, String sImageid,
        WSPutArrivalImageRequest request, WSPutArrivalImageResponse oResponse)
            throws Exception {

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sImagedatastr = request.getImagedatastr();

        WT_ImageArriveNotice arriveNotice;

        byte[] btDatas = IwfBase64Urls.decode(sImagedatastr);
        if (null == btDatas) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3090, sImagedatastr);

            return oResponse;
        }

        try {

            arriveNotice = iwfCoreDomManager.getImageArriveNotice(sArrivekey);
            if (null == arriveNotice) {
                WSToutyakuYoteiNotFoundRequest notFoundRequest = new WSToutyakuYoteiNotFoundRequest();
                notFoundRequest.setToutyakuKey(sArrivekey);
                WSToutyakuYoteiNotFoundResponse notFoundResponse = toutyakuYoteiNotFoundService.exec(notFoundRequest);

                if (C_ResultCdKbn.NG.toString().equals(notFoundResponse.getKekkastatus())) {

                    if ("IWFCB20".equals(notFoundResponse.getSyousaimsgcd())) {
                        IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWFCB20);
                        oResponse.setCberrmsg(notFoundResponse.getCberrmsg());
                    } else {
                        IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWFCB21);
                    }

                    iwfCoreDomManager.clear();

                    return oResponse;
                }

                arriveNotice = new WT_ImageArriveNotice();
                arriveNotice.setArriveKey(notFoundResponse.getToutyakuKey());
                arriveNotice.setGyoumuKey(notFoundResponse.getAppKey());
                arriveNotice.setFlowId(notFoundResponse.getFlowid());
                arriveNotice.setTorikomiSyoruiCd(notFoundResponse.getSyoruicd());
                arriveNotice.setSubSystemId(notFoundResponse.getSubsystemid());
            }

            WT_TorikomiKanri torikomikanriBean = new WT_TorikomiKanri();
            torikomikanriBean.setIwfImageId(sImageid);
            torikomikanriBean.setTorikomiSyoruiCd(arriveNotice.getTorikomiSyoruiCd());
            torikomikanriBean.setTourokuTime(IwfDateUtils.getSysDate());
            torikomikanriBean.setKousinTime(IwfDateUtils.getSysDate());
            iwfCoreDomManager.insert(torikomikanriBean);

            WT_TorikomiRelation torikomiRelationBean = new WT_TorikomiRelation();
            torikomiRelationBean.setIwfImageId(sImageid);
            torikomiRelationBean.setGyoumuKey(arriveNotice.getGyoumuKey());
            iwfCoreDomManager.insert(torikomiRelationBean);

            WM_TorikomiSyorui syorui = iwfCoreDomManager.getTorikomiSyorui(arriveNotice.getTorikomiSyoruiCd());


            PdfPage[] oBeans = IwfPDFUtils.split(new PdfReader(btDatas));

            int iPages = 1;
            for (PdfPage page : oBeans) {

                LOGGER.debug(iPages + "ページ目取り込み");
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
                itPdfhozon.setKousinTime(IwfDateUtils.getSysDate());
                iwfCoreDomManager.insert(itPdfhozon);

                WT_Page itPage = new WT_Page();
                itPage.setIwfImageId(sImageid);
                itPage.setSyoruittykymdtime(IwfDateUtils.getSysDate());
                itPage.setPageno(iPages);
                iPages++;
                itPage.setKousinTime(IwfDateUtils.getSysDate());
                itPage.setPageId(sPageid);
                iwfCoreDomManager.insert(itPage);
            }
            arriveNoticeInfo = arriveNotice;

            IwfEditMessageUtil.setMsgResultOK(oResponse, "到着イメージ登録");

        } catch (Exception e) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着イメージ登録");

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
        }

        return oResponse;
    }

    private WSPutArrivalImageResponse doTerminate(String sArrivekey, String sImageid,
        WT_ImageArriveNotice arriveNotice, WSPutArrivalImageResponse oResponse) throws Exception{

        WSImageTerminatorRequest terminatorRequest = new WSImageTerminatorRequest();
        terminatorRequest.setToutyakuKey(sArrivekey);
        terminatorRequest.setAppKey(arriveNotice.getGyoumuKey());
        terminatorRequest.setSyoruicd(arriveNotice.getTorikomiSyoruiCd());
        terminatorRequest.setFlowid(arriveNotice.getFlowId());
        terminatorRequest.setSubsystemid(arriveNotice.getSubSystemId());
        terminatorRequest.setImageid(sImageid);

        WSImageTerminatorResponse terminatorResult = new WSImageTerminatorResponse();
        try {
            terminatorResult = imageTerminatorService.terminate(terminatorRequest);
        } catch (Exception e) {
            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
        }

        if (C_ResultCdKbn.NG.toString().equals(terminatorResult.getKekkastatus())) {

            if ("IWFCB30".equals(terminatorResult.getSyousaimsgcd())) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWFCB30);
                oResponse.setCberrmsg(terminatorResult.getCberrmsg());
            } else {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWFCB31);
            }
        }

        return oResponse;
    }

    public WSPutArrivalImageResponse getStubResult(
        WSPutArrivalImageRequest request) throws Exception {
        return null;
    }

    public WSPutArrivalImageResponse getBootErrResponse() {
        WSPutArrivalImageResponse res = new WSPutArrivalImageResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}