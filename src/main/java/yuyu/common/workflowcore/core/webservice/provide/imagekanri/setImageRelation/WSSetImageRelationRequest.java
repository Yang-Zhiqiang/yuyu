package yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.IWSGetQrCodeImagesIOKey;

/**
 * イメージ関連設定サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSSetImageRelationRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "SetImageRelation";

    @FormParam(IWSSetImageRelationIOKey.IN.sS_IMAGEID)
    private String sImageid_;

    @FormParam(IWSGetQrCodeImagesIOKey.IN.sS_GYOUMUKEYSS)
    private String[] sGyoumukeys_;

    @FormParam(IWSSetImageRelationIOKey.IN.sS_SYORI_KBN)
    private String sSyorikbn_;

    @JSONHint(name = IWSSetImageRelationIOKey.IN.sS_IMAGEID)
    public String getImageid() {
        return sImageid_;
    }

    public void setImageid(String psImageid) {
        sImageid_ = psImageid;
    }

    @JSONHint(name = IWSSetImageRelationIOKey.IN.sS_GYOUMUKEYSS)
    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    public void setGyoumukeys(String[] psGyoumukeys) {
        sGyoumukeys_ = psGyoumukeys;
    }

    @JSONHint(name = IWSSetImageRelationIOKey.IN.sS_SYORI_KBN)
    public String getSyorikbn() {
        return sSyorikbn_;
    }

    public void setSyorikbn(String psSyorikbn) {
        sSyorikbn_ = psSyorikbn;
    }
}
