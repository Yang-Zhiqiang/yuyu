package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai;

import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程履歴詳細取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiRirekiSyousaiResponse extends WSCommonResponse {

    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String,String>[] oRirekimaps_;

    public WSGetKouteiRirekiSyousaiResponse() {
    }
    @JSONHint(name=IWSGetKouteiRirekiSyousaiIOKey.OUT.sO_RIREKIMAPS)
    public Map<String,String>[] getRirekimaps() {
        return oRirekimaps_;
    }

    public void setRirekimaps(Map<String,String>[] poRirekimaps) {
        oRirekimaps_ = poRirekimaps;
    }

}
