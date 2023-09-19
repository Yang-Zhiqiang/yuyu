package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.IWSGetExpectedArrivalNoticeIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 到着予定通知取得サービスのプロバイダークラスです。
 */
public class WSGetExpectedArrivalNoticeImpl implements WSGetExpectedArrivalNotice {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetExpectedArrivalNoticeImpl.class);

    public WSGetExpectedArrivalNoticeImpl() {
        super();
    }


    public void initialize(WSGetExpectedArrivalNoticeRequest request) throws Exception {

        LOGGER.debug("│初期化処理開始・・・");
    }

    public WSGetExpectedArrivalNoticeResponse validate(
        WSGetExpectedArrivalNoticeRequest request) throws Exception {

        WSGetExpectedArrivalNoticeResponse oResponse = new WSGetExpectedArrivalNoticeResponse();

        String sArrivekey = request.getArrivekey();

        if (StringUtils.isEmpty(sArrivekey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "到着キー");
            return oResponse;
        } else if (!sArrivekey.equals(sArrivekey.trim())) {
            LOGGER.debug(IwfMessageUtil.getMessage(IwfMessageCd.IWF0011, sArrivekey));
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着予定通知取得");
            return oResponse;
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSGetExpectedArrivalNoticeRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetExpectedArrivalNoticeResponse executeBizMain(
        WSGetExpectedArrivalNoticeRequest request) throws Exception {

        WSGetExpectedArrivalNoticeResponse oResponse = new WSGetExpectedArrivalNoticeResponse();

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

            List<WT_ImageArriveNotice> arriveNotices = iwfCoreDomManager.getImageArriveNoticeByCond(sArrivekey,
                sFlowid, sGyoumukey, sTorikomisyoruicd, sSubsystemid);
            if (null == arriveNotices || 0 == arriveNotices.size()) {
                LOGGER.debug("到着予定通知情報が取得できませんでした。");
                IwfEditMessageUtil.setMsgResultWARN(oResponse, IwfMessageCd.IWF3081);

                return oResponse;
            }

            List<Map<String, String>> oNoticeMaps = new ArrayList<Map<String, String>>();

            for (WT_ImageArriveNotice notice : arriveNotices) {
                String arrivekey = notice.getArriveKey();
                String flowId = notice.getFlowId();
                String gyoumukey = notice.getGyoumuKey();
                String torikomisyoruicd = notice.getTorikomiSyoruiCd();
                String subsystemid = notice.getSubSystemId();

                Map<String, String> oNoticeMap = new HashMap<String, String>();
                oNoticeMap.put(MapKey.sS_ARRIVEKEY, arrivekey);
                oNoticeMap.put(MapKey.sS_FLOWID, flowId);
                oNoticeMap.put(MapKey.sS_GYOUMUKEY, gyoumukey);
                oNoticeMap.put(MapKey.sS_TORIKOMISYORUICD, torikomisyoruicd);
                oNoticeMap.put(MapKey.sS_SUBSYSTEMID, subsystemid);

                oNoticeMaps.add(oNoticeMap);
            }

            oResponse.setNoticemaps(oNoticeMaps.toArray(new Map[] {}));

            IwfEditMessageUtil.setMsgResultOK(oResponse, "到着予定通知取得");

        } catch (Exception e) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "到着予定通知取得");

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
        }

        return oResponse;
    }

    public WSGetExpectedArrivalNoticeResponse getStubResult(
        WSGetExpectedArrivalNoticeRequest request) throws Exception {

        return null;
    }

    public WSGetExpectedArrivalNoticeResponse getBootErrResponse() {
        WSGetExpectedArrivalNoticeResponse res = new WSGetExpectedArrivalNoticeResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}