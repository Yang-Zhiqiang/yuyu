package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ID指定イメージプロパティサービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetImagePropsByIdRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetImagePropsById";

    @FormParam(IWSGetImagePropsByIdIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetImagePropsByIdIOKey.IN.sS_IMAGEIDSS)
    private String[] sImageids_;

    @JSONHint(name=IWSGetImagePropsByIdIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetImagePropsByIdIOKey.IN.sS_IMAGEIDSS)
    public String[] getImageids() {
        return sImageids_;
    }

    public void setImageids(String[] psImageids) {
        sImageids_ = psImageids;
    }

}
