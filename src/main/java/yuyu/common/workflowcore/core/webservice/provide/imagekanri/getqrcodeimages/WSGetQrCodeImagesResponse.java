package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages;

import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * ＱＲイメージコード取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetQrCodeImagesResponse extends WSCommonResponse {

    private String[] sImgids_;

    private ArrayList<byte[]> oQrimgbinaries_;

    @JSONHint(name=IWSGetQrCodeImagesIOKey.OUT.sS_IMGIDSS)
    public String[] getImgids() {
        return sImgids_;
    }

    public void setImgids(String[] psImgids) {
        sImgids_ = psImgids;
    }

    @JSONHint(name=IWSGetQrCodeImagesIOKey.OUT.sO_QRIMGBINARIES)
    public ArrayList<byte[]> getQrimgbinaries() {
        return oQrimgbinaries_;
    }

    public void setQrimgbinaries(ArrayList<byte[]> poQrimgbinaries) {
        oQrimgbinaries_ = poQrimgbinaries;
    }

}
