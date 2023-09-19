package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 到着イメージ登録サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSPutArrivalImageResponse extends WSCommonResponse {

    private String sCberrmsg_;

    @JSONHint(name=IWSPutArrivalImageIOKey.OUT.sS_CBERRMSG)
    public String getCberrmsg() {
        return sCberrmsg_;
    }

    public void setCberrmsg(String psCberrmsg) {
        sCberrmsg_ = psCberrmsg;
    }
}
