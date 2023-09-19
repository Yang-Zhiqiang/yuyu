package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 強制工程アンロックサービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSForceUnlockProcessRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ForceUnlockProcess";

    @FormParam(IWSForceUnlockProcessIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSForceUnlockProcessIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @JSONHint(name=IWSForceUnlockProcessIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSForceUnlockProcessIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

}
