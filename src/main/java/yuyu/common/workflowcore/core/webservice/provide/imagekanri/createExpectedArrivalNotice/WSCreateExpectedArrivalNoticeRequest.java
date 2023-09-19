package yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 到着予定通知作成サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSCreateExpectedArrivalNoticeRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "CreateExpectedArrivalNotice";


    @FormParam(IWSCreateExpectedArrivalNoticeIOKey.IN.sS_ARRIVEKEY)
    private String sArrivekey_;

    @FormParam(IWSCreateExpectedArrivalNoticeIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSCreateExpectedArrivalNoticeIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSCreateExpectedArrivalNoticeIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @FormParam(IWSCreateExpectedArrivalNoticeIOKey.IN.sS_SUBSYSTEMID)
    private String sSubsystemid_;


    @JSONHint(name=IWSCreateExpectedArrivalNoticeIOKey.IN.sS_ARRIVEKEY)
    public String getArrivekey() {
        return sArrivekey_;
    }

    public void setArrivekey(String psArrivekey) {
        sArrivekey_ = psArrivekey;
    }

    @JSONHint(name=IWSCreateExpectedArrivalNoticeIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSCreateExpectedArrivalNoticeIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSCreateExpectedArrivalNoticeIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psSyoruicd) {
        sTorikomisyoruicd_ = psSyoruicd;
    }

    @JSONHint(name=IWSCreateExpectedArrivalNoticeIOKey.IN.sS_SUBSYSTEMID)
    public String getSubsystemid() {
        return sSubsystemid_;
    }

    public void setSubsystemid(String psSubsystemid) {
        sSubsystemid_ = psSubsystemid;
    }
}
