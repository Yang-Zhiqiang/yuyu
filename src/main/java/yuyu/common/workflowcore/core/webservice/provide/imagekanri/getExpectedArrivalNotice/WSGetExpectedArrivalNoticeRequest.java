package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 到着予定通知取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetExpectedArrivalNoticeRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetExpectedArrivalNotice";

    @FormParam(IWSGetExpectedArrivalNoticeIOKey.IN.sS_ARRIVEKEY)
    private String sArrivekey_;

    @FormParam(IWSGetExpectedArrivalNoticeIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetExpectedArrivalNoticeIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSGetExpectedArrivalNoticeIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @FormParam(IWSGetExpectedArrivalNoticeIOKey.IN.sS_SUBSYSTEMID)
    private String sSubsystemid_;


    @JSONHint(name=IWSGetExpectedArrivalNoticeIOKey.IN.sS_ARRIVEKEY)
    public String getArrivekey() {
        return sArrivekey_;
    }

    public void setArrivekey(String psArrivekey) {
        sArrivekey_ = psArrivekey;
    }

    @JSONHint(name=IWSGetExpectedArrivalNoticeIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetExpectedArrivalNoticeIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSGetExpectedArrivalNoticeIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psSyoruicd) {
        sTorikomisyoruicd_ = psSyoruicd;
    }

    @JSONHint(name=IWSGetExpectedArrivalNoticeIOKey.IN.sS_SUBSYSTEMID)
    public String getSubsystemid() {
        return sSubsystemid_;
    }

    public void setSubsystemid(String psSubsystemid) {
        sSubsystemid_ = psSubsystemid;
    }
}
