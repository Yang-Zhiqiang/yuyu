package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程アンロックサービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSUnlockProcessRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "UnlockProcess";

    @FormParam(IWSUnlockProcessIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSUnlockProcessIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSUnlockProcessIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @JSONHint(name=IWSUnlockProcessIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSUnlockProcessIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSUnlockProcessIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

}
