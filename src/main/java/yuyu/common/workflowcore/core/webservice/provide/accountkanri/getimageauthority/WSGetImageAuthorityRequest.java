package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority;

import javax.annotation.Generated;
import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * イメージ権限削除サービスのリクエストBeanです。<br/>
 */
@Generated("このソースは全てツールから吐き出されています。")
@SuppressWarnings("serial")
public class WSGetImageAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetImageAuthority";

    @FormParam(IWSGetImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    private String sImageauthid_;

    @JSONHint(name=IWSGetImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    public String getImageauthid() {
        return sImageauthid_;
    }

    public void setImageauthid(String psImageauthid) {
        sImageauthid_ = psImageauthid;
    }
}
