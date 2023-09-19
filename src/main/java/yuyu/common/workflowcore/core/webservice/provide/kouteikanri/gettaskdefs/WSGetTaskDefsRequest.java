package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク定義取得のInBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskDefsRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTaskDefs";

    @FormParam(IWSGetTaskDefsIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetTaskDefsIOKey.IN.sS_FLOWID)
    private String sFlowid_;


    @JSONHint(name=IWSGetTaskDefsIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetTaskDefsIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

}
