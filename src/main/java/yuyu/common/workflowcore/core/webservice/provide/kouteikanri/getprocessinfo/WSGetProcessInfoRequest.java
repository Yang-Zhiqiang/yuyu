package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetProcessInfoRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetProcessInfo";

    @FormParam(IWSGetProcessInfoIOKey.IN.sS_GYOUMUKEYSS)
    private String[] sGyoumukeys_;

    @FormParam(IWSGetProcessInfoIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetProcessInfoIOKey.IN.sS_IPADDRESS)
    private String sIpaddress_;

    @JSONHint(name=IWSGetProcessInfoIOKey.IN.sS_GYOUMUKEYSS)
    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    public void setGyoumukeys(String[] psGyoumukeys) {
        sGyoumukeys_ = psGyoumukeys;
    }

    @JSONHint(name=IWSGetProcessInfoIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetProcessInfoIOKey.IN.sS_IPADDRESS)
    public String getIpaddress() {
        return sIpaddress_;
    }

    public void setIpaddress(String psIpaddress) {
        sIpaddress_ = psIpaddress;
    }

}
