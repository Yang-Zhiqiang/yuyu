package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 分岐先取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTransitionsRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTransitions";

    @FormParam(IWSGetTransitionsIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTransitionsIOKey.IN.sS_NODENAME)
    private String sNodename_;

    @JSONHint(name=IWSGetTransitionsIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTransitionsIOKey.IN.sS_NODENAME)
    public String getNodename() {
        return sNodename_;
    }

    public void setNodename(String psNodename) {
        sNodename_ = psNodename;
    }

}
