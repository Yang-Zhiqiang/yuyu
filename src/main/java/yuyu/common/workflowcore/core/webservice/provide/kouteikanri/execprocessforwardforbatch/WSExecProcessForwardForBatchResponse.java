package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程遷移（バッチ用）サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessForwardForBatchResponse extends WSCommonResponse {

    private String sKouteisyuuryouflg_;

    private String sAutocreateflowid_;

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.OUT.sS_KOUTEISYUURYOUFLG)
    public String getKouteisyuuryouflg() {
        return sKouteisyuuryouflg_;
    }

    public void setKouteisyuuryouflg(String psKouteiSyuuryouFlg) {
        sKouteisyuuryouflg_ = psKouteiSyuuryouFlg;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.OUT.sS_AUTOCREATEFLOWID)
    public String getAutocreateflowid() {
        return sAutocreateflowid_;
    }

    public void setAutocreateflowid(String pAutocreateflowid) {
        sAutocreateflowid_ = pAutocreateflowid;
    }

}
