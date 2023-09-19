package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess;

import javax.annotation.Generated;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程ロックサービスのレスポンスBeanです。<br/>
 */
@Generated("このソースは全てツールから吐き出されています。")
@SuppressWarnings("serial")
public class WSLockProcessResponse extends WSCommonResponse {

    private String sGyoumukey_;

    @JSONHint(name=IWSLockProcessIOKey.OUT.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

}
