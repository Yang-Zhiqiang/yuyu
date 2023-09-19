package yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク権限情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskAuthInfoRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTaskAuthInfo";

    @FormParam(IWSGetTaskAuthInfoIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTaskAuthInfoIOKey.IN.sS_TASKNAME)
    private String sTaskname_;

    @JSONHint(name=IWSGetTaskAuthInfoIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTaskAuthInfoIOKey.IN.sS_TASKNAME)
    public String getTaskname() {
        return sTaskname_;
    }

    public void setTaskname(String psTaskname) {
        sTaskname_ = psTaskname;
    }

}
