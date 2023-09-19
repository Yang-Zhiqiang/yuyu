package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク一覧取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTasksRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTasks";

    @FormParam(IWSGetTasksIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTasksIOKey.IN.sS_NODENAME)
    private String sNodename_;

    @FormParam(IWSGetTasksIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetTasksIOKey.IN.sS_TASKKBN)
    private String sTaskkbn_;

    @JSONHint(name=IWSGetTasksIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTasksIOKey.IN.sS_NODENAME)
    public String getNodename() {
        return sNodename_;
    }

    public void setNodename(String psNodename) {
        sNodename_ = psNodename;
    }

    @JSONHint(name=IWSGetTasksIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetTasksIOKey.IN.sS_TASKKBN)
    public String getTaskkbn() {
        return sTaskkbn_;
    }

    public void setTaskkbn(String psTaskkbn) {
        sTaskkbn_ = psTaskkbn;
    }

}
