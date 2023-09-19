package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程中断サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessCancelRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessCancel";

    @FormParam(IWSExecProcessCancelIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecProcessCancelIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecProcessCancelIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessCancelIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSExecProcessCancelIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;

    @JSONHint(name=IWSExecProcessCancelIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessCancelIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecProcessCancelIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessCancelIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSExecProcessCancelIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
