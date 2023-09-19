package yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 到着予定通知作成サービスのプロバイダークラスです。
 */
public class WSCreateExpectedArrivalNoticeImpl implements WSCreateExpectedArrivalNotice {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSCreateExpectedArrivalNoticeImpl.class);

    public WSCreateExpectedArrivalNoticeImpl() {
        super();
    }


    public void initialize(WSCreateExpectedArrivalNoticeRequest request) throws Exception {

        LOGGER.debug("│初期化処理開始・・・");
    }

    public WSCreateExpectedArrivalNoticeResponse validate(
        WSCreateExpectedArrivalNoticeRequest request) throws Exception {

        WSCreateExpectedArrivalNoticeResponse oResponse = new WSCreateExpectedArrivalNoticeResponse();


        String sArrivekey = request.getArrivekey();
        String sGyoumukey = request.getGyoumukey();
        String sTorikomisyoruicd = request.getTorikomisyoruicd();
        String sFlowid = request.getFlowid();
        String sSubsystemid = request.getSubsystemid();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sArrivekey, "到着キー", 50)) {
            return oResponse;
        } else if (!sArrivekey.equals(sArrivekey.trim())) {
            LOGGER.debug(IwfMessageUtil.getMessage(IwfMessageCd.IWF0011, sArrivekey));
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着予定通知作成");
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumukey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sTorikomisyoruicd, "取込書類コード", 30)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowid, "フローID", 19)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sSubsystemid, "サブシステムID", 50)) {
            return oResponse;
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSCreateExpectedArrivalNoticeRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSCreateExpectedArrivalNoticeResponse executeBizMain(
        WSCreateExpectedArrivalNoticeRequest request) throws Exception {

        WSCreateExpectedArrivalNoticeResponse oResponse = new WSCreateExpectedArrivalNoticeResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sArrivekey = request.getArrivekey();
        String sFlowid = request.getFlowid();
        String sGyoumukey = request.getGyoumukey();
        String sTorikomisyoruicd = request.getTorikomisyoruicd();
        String sSubsystemid = request.getSubsystemid();

        try {

            WT_ImageArriveNotice arriveNotice = iwfCoreDomManager.getImageArriveNotice(sArrivekey);
            if (null != arriveNotice) {
                LOGGER.debug("到着予定通知情報も登録しました。");
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3080);

                return oResponse;
            }

            WT_ImageArriveNotice arriveNoticeInfo = new WT_ImageArriveNotice();
            arriveNoticeInfo.setArriveKey(sArrivekey);
            arriveNoticeInfo.setGyoumuKey(sGyoumukey);
            arriveNoticeInfo.setTorikomiSyoruiCd(sTorikomisyoruicd);
            arriveNoticeInfo.setFlowId(sFlowid);
            arriveNoticeInfo.setSubSystemId(sSubsystemid);
            iwfCoreDomManager.insert(arriveNoticeInfo);

            IwfEditMessageUtil.setMsgResultOK(oResponse, "到着予定通知作成サービスが正常終了しました。");

        } catch (Exception e) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着予定通知作成");

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
        }

        return oResponse;
    }

    public WSCreateExpectedArrivalNoticeResponse getStubResult(
        WSCreateExpectedArrivalNoticeRequest request) throws Exception {

        return null;
    }

    public WSCreateExpectedArrivalNoticeResponse getBootErrResponse() {
        WSCreateExpectedArrivalNoticeResponse res = new WSCreateExpectedArrivalNoticeResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}