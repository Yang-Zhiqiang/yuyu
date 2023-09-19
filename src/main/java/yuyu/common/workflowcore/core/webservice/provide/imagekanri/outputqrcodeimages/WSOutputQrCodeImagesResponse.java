package yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * QRイメージコード出力サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSOutputQrCodeImagesResponse extends WSCommonResponse {


    private String[] sImgids_;

    private String[] sFilenames_;

    @JSONHint(name=IWSOutputQrCodeImagesIOKey.OUT.sS_IMGIDSS)
    public String[] getImgids() {
        return sImgids_;
    }

    public void setImgids(String[] psImgids) {
        sImgids_ = psImgids;
    }

    @JSONHint(name=IWSOutputQrCodeImagesIOKey.OUT.sS_FILENAMESS)
    public String[] getFilenames() {
        return sFilenames_;
    }

    public void setFilenames(String[] psFilenames) {
        sFilenames_ = psFilenames;
    }

}
