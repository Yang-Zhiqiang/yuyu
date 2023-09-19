package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程ロックサービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSLockProcessRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "LockProcess";

    @FormParam(IWSLockProcessIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSLockProcessIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSLockProcessIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSLockProcessIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @JSONHint(name=IWSLockProcessIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSLockProcessIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSLockProcessIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSLockProcessIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

}
