package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ID指定イメージ取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetImageByIdRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetImageById";

    @FormParam(IWSGetImageByIdIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetImageByIdIOKey.IN.sS_IMAGEIDSS)
    private String[] sImageids_;

    @JSONHint(name=IWSGetImageByIdIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetImageByIdIOKey.IN.sS_IMAGEIDSS)
    public String[] getImageids() {
        return sImageids_;
    }

    public void setImageids(String[] psImageids) {
        sImageids_ = psImageids;
    }

}
