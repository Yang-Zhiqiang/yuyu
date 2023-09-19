package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程属性取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetProcessAttributeResponse extends WSCommonResponse {

    private String sJsonstrings_;

    @JSONHint(name=IWSGetProcessAttributeIOKey.OUT.sS_JSONSTRINGS)
    public String getJsonstrings() {
        return sJsonstrings_;
    }

    public void setJsonstrings(String psJsonstrings) {
        sJsonstrings_ = psJsonstrings;
    }
}
