package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程ロック情報取得のリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetLockInfoRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetLockInfo";

    @FormParam(IWSGetLockInfoIOKey.IN.sS_FLOWID)
    private String[] sFlowid_;

    @FormParam(IWSGetLockInfoIOKey.IN.sS_GYOUMUKEY)
    private String[] sGyoumukey_;

    @JSONHint(name=IWSGetLockInfoIOKey.IN.sS_FLOWID)
    public String[] getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String[] psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetLockInfoIOKey.IN.sS_GYOUMUKEY)
    public String[] getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String[] psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }
}
