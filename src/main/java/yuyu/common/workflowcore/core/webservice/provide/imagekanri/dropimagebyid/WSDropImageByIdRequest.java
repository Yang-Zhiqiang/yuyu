package yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ID指定イメージ削除サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSDropImageByIdRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "DropImageById";

    @FormParam(IWSDropImageByIdIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSDropImageByIdIOKey.IN.sS_IMAGEIDSS)
    private String[] sImageids_;

    @FormParam(IWSDropImageByIdIOKey.IN.sS_EXT_INFO)
    private String sExtinfo_;

    @JSONHint(name=IWSDropImageByIdIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSDropImageByIdIOKey.IN.sS_IMAGEIDSS)
    public String[] getImageids() {
        return sImageids_;
    }

    public void setImageids(String[] psImageids) {
        sImageids_ = psImageids;
    }

    @JSONHint(name=IWSDropImageByIdIOKey.IN.sS_EXT_INFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
