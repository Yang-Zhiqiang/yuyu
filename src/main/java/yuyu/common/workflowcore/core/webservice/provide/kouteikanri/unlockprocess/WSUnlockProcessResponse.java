package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程アンロックサービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSUnlockProcessResponse extends WSCommonResponse {

    private String sGyoumukey_;

    @JSONHint(name=IWSUnlockProcessIOKey.OUT.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

}
