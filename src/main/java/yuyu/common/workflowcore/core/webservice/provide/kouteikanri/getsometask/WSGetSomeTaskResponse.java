package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 単一タスク取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetSomeTaskResponse extends WSCommonResponse {

    private String sGyoumukey_;

    @JSONHint(name=IWSGetSomeTaskIOKey.OUT.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

}
