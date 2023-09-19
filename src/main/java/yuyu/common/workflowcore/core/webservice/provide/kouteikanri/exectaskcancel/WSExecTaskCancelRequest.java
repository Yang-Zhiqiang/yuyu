package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク取消サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecTaskCancelRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecTaskCancel";

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_RIREKIACCOUNTID)
    private String sRirekiaccountid_;

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSExecTaskCancelIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_RIREKIACCOUNTID)
    public String getRirekiaccountid() {
        return sRirekiaccountid_;
    }

    public void setRirekiaccountid(String psRirekiaccountid) {
        sRirekiaccountid_ = psRirekiaccountid;
    }

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSExecTaskCancelIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
