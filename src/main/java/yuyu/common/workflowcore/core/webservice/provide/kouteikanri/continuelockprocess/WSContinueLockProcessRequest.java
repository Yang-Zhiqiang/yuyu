package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程ロックサービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSContinueLockProcessRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "LockProcess";

    @FormParam(IWSContinueLockProcessIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSContinueLockProcessIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSContinueLockProcessIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSContinueLockProcessIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @JSONHint(name=IWSContinueLockProcessIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSContinueLockProcessIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSContinueLockProcessIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSContinueLockProcessIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

}
