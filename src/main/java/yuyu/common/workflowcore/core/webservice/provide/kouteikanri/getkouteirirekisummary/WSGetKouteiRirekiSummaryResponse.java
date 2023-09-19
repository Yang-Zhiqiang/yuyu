package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary;

import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程履歴サマリ取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiRirekiSummaryResponse extends WSCommonResponse {

    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String, String>[] oRirekimaps_;

    public WSGetKouteiRirekiSummaryResponse() {
    }

    @JSONHint(name=IWSGetKouteiRirekiSummaryIOKey.OUT.sO_RIREKIMAPS)
    public Map<String, String>[] getRirekimaps() {
        return oRirekimaps_;
    }

    public void setRirekimaps(Map<String, String>[] poRirekimaps) {
        oRirekimaps_ = poRirekimaps;
    }

}
