package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ＱＲイメージコード取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetQrCodeImagesRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetQrCodeImages";

    @FormParam(IWSGetQrCodeImagesIOKey.IN.sS_GYOUMUKEYSS)
    private String[] sGyoumukeys_;

    @FormParam(IWSGetQrCodeImagesIOKey.IN.sS_SYORUICDSS)
    private String[] sSyoruicds_;

    @JSONHint(name=IWSGetQrCodeImagesIOKey.IN.sS_GYOUMUKEYSS)
    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    public void setGyoumukeys(String[] psGyoumukeys) {
        sGyoumukeys_ = psGyoumukeys;
    }

    @JSONHint(name=IWSGetQrCodeImagesIOKey.IN.sS_SYORUICDSS)
    public String[] getSyoruicds() {
        return sSyoruicds_;
    }

    public void setSyoruicds(String[] psSyoruicds) {
        sSyoruicds_ = psSyoruicds;
    }

}
