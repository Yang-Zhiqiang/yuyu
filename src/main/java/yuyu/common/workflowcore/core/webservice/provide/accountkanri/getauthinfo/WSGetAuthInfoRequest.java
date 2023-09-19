package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 権限情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetAuthInfoRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetAuthInfo";

    @FormParam(IWSGetAuthInfoIOKey.IN.sS_AUTHID)
    private String sAuthid_;

    @FormParam(IWSGetAuthInfoIOKey.IN.sS_AUTHNAME)
    private String sAuthname_;

    @FormParam(IWSGetAuthInfoIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetAuthInfoIOKey.IN.sS_NODEID)
    private String sNodeid_;

    @FormParam(IWSGetAuthInfoIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @JSONHint(name=IWSGetAuthInfoIOKey.IN.sS_AUTHID)
    public String getAuthid() {
        return sAuthid_;
    }

    public void setAuthid(String psAuthid) {
        sAuthid_ = psAuthid;
    }

    @JSONHint(name=IWSGetAuthInfoIOKey.IN.sS_AUTHNAME)
    public String getAuthname() {
        return sAuthname_;
    }

    public void setAuthname(String psAuthname) {
        sAuthname_ = psAuthname;
    }

    @JSONHint(name=IWSGetAuthInfoIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetAuthInfoIOKey.IN.sS_NODEID)
    public String getNodeid() {
        return sNodeid_;
    }

    public void setNodeid(String psNodeid) {
        sNodeid_ = psNodeid;
    }

    @JSONHint(name=IWSGetAuthInfoIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psTorikomisyoruicd) {
        sTorikomisyoruicd_ = psTorikomisyoruicd;
    }
}
