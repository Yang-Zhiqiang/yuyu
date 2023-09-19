package yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ORイメージコード出力サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSOutputQrCodeImagesRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "OutputQrCodeImages";

    @FormParam(IWSOutputQrCodeImagesIOKey.IN.sS_GYOUMUKEYSS)
    private String[] sGyoumukeys_;

    @FormParam(IWSOutputQrCodeImagesIOKey.IN.sS_SYORUICDSS)
    private String[] sSyoruicds_;

    @FormParam(IWSOutputQrCodeImagesIOKey.IN.sS_OUTPUTPATH)
    private String sOutputpath_;

    @JSONHint(name=IWSOutputQrCodeImagesIOKey.IN.sS_GYOUMUKEYSS)
    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    public void setGyoumukeys(String[] psGyoumukeys) {
        sGyoumukeys_ = psGyoumukeys;
    }

    @JSONHint(name=IWSOutputQrCodeImagesIOKey.IN.sS_SYORUICDSS)
    public String[] getSyoruicds() {
        return sSyoruicds_;
    }

    public void setSyoruicds(String[] psSyoruicds) {
        sSyoruicds_ = psSyoruicds;
    }

    @JSONHint(name=IWSOutputQrCodeImagesIOKey.IN.sS_OUTPUTPATH)
    public String getOutputpath() {
        return sOutputpath_;
    }

    public void setOutputpath(String psOutputpath) {
        sOutputpath_ = psOutputpath;
    }

}
