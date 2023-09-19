package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice;

import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 到着予定通知取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetExpectedArrivalNoticeResponse extends WSCommonResponse {

    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String,String>[] oNoticeMaps_;

    public WSGetExpectedArrivalNoticeResponse() {
    }

    @JSONHint(name = IWSGetExpectedArrivalNoticeIOKey.OUT.sO_NOTICEMAPS)
    public Map<String, String>[] getNoticemaps() {
        return oNoticeMaps_;
    }

    public void setNoticemaps(Map<String, String>[] poNoticemaps) {
        oNoticeMaps_ = poNoticemaps;
    }
}
