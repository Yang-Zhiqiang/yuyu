package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 強制工程遷移のリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecForceProcessForwardRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecForceProcessForward";

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_SRCNODENAME)
    private String sSrcnodename_;

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_DESTNODENAME)
    private String sDestnodename_;

    @FormParam(IWSExecForceProcessForwardIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_SRCNODENAME)
    public String getSrcnodename() {
        return sSrcnodename_;
    }

    public void setSrcnodename(String psSrcnodename) {
        sSrcnodename_ = psSrcnodename;
    }

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_DESTNODENAME)
    public String getDestnodename() {
        return sDestnodename_;
    }

    public void setDestnodename(String psDestnodename) {
        sDestnodename_ = psDestnodename;
    }

    @JSONHint(name=IWSExecForceProcessForwardIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

}
