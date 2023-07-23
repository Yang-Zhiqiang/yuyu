package iwf.callback.arriveimage.toutyakuYoteiNotFound;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 到着予定未存在時のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSToutyakuYoteiNotFoundRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "ToutyakuYoteiNotFound";

    @FormParam(IWSToutyakuYoteiNotFoundIOKey.IN.sS_TOUTYAKUKEY)
    private String sToutyakuKey_;

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.IN.sS_TOUTYAKUKEY)
    public String getToutyakuKey() {
        return sToutyakuKey_;
    }

    public void setToutyakuKey(String psToutyakuKey) {
        sToutyakuKey_ = psToutyakuKey;
    }
}
