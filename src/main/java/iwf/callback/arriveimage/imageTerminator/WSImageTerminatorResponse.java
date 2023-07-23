package iwf.callback.arriveimage.imageTerminator;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * イメージ到着後処理のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSImageTerminatorResponse extends WSCommonResponse {

    private String sCberrmsg_;

    @JSONHint(name=IWSImageteminatorIOKey.OUT.sS_CBERRMSG)
    public String getCberrmsg() {
        return sCberrmsg_;
    }

    public void setCberrmsg(String psCberrmsg) {
        sCberrmsg_ = psCberrmsg;
    }
}
