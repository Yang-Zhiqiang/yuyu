package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 単一タスク取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetSomeTaskRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetSomeTask";
    @FormParam(IWSGetSomeTaskIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetSomeTaskIOKey.IN.sS_NODENAME)
    private String sNodename_;

    @FormParam(IWSGetSomeTaskIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetSomeTaskIOKey.IN.sS_TASKKBN)
    private String sTaskkbn_;

    @JSONHint(name=IWSGetSomeTaskIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetSomeTaskIOKey.IN.sS_NODENAME)
    public String getNodename() {
        return sNodename_;
    }

    public void setNodename(String psNodename) {
        sNodename_ = psNodename;
    }

    @JSONHint(name=IWSGetSomeTaskIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetSomeTaskIOKey.IN.sS_TASKKBN)
    public String getTaskkbn() {
        return sTaskkbn_;
    }

    public void setTaskkbn(String psTaskkbn) {
        sTaskkbn_ = psTaskkbn;
    }

}
