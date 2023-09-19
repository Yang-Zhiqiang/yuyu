package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク開始サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecTaskStartRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecTaskStart";

    @FormParam(IWSExecTaskStartIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecTaskStartIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecTaskStartIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecTaskStartIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSExecTaskStartIOKey.IN.sS_TASKNAME)
    private String sTaskname_;

    @FormParam(IWSExecTaskStartIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;


    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_TASKNAME)
    public String getTaskname() {
        return sTaskname_;
    }

    public void setTaskname(String psTaskname) {
        sTaskname_ = psTaskname;
    }

    @JSONHint(name=IWSExecTaskStartIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
