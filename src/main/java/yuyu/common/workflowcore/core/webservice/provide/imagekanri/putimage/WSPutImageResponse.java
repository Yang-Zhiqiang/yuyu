package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * イメージ登録サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSPutImageResponse extends WSCommonResponse {

    private String sImgid_;

    @JSONHint(name=IWSPutImageIOKey.OUT.sS_IMGID)
    public String getImgid() {
        return sImgid_;
    }

    public void setImgid(String psImgid) {
        sImgid_ = psImgid;
    }

}
