package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程情報更新（バッチ用）サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessUpdateForBatchResponse extends WSCommonResponse {

    private String sErrGyoumukey_;

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.OUT.sS_ERRGYOUMUKEY)
    public String getErrGyoumukey() {
        return sErrGyoumukey_;
    }

    public void setErrGyoumukey(String psErrGyoumukey_) {
        sErrGyoumukey_ = psErrGyoumukey_;
    }
}