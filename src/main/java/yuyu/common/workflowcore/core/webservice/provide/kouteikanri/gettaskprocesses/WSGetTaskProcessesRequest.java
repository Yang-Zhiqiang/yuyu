package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク内工程情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskProcessesRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTaskProcesses";

    @FormParam(IWSGetTaskProcessesIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTaskProcessesIOKey.IN.sS_NODENAME)
    private String sNodename_;

    @JSONHint(name=IWSGetTaskProcessesIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTaskProcessesIOKey.IN.sS_NODENAME)
    public String getNodename() {
        return sNodename_;
    }

    public void setNodename(String psNodename) {
        sNodename_ = psNodename;
    }

}
