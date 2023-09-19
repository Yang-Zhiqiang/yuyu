package yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * タスク権限情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskAuthInfoResponse extends WSCommonResponse {

    private String[] sAuthids_;

    @JSONHint(name=IWSGetTaskAuthInfoIOKey.OUT.sS_AUTHIDSS)
    public String[] getAuthids() {
        return sAuthids_;
    }

    @JSONHint(name=IWSGetTaskAuthInfoIOKey.OUT.sS_AUTHIDSS)
    public void setAuthids(String[] psAuthids) {
        sAuthids_ = psAuthids;
    }
}