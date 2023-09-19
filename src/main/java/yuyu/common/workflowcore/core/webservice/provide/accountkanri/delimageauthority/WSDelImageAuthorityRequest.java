package yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority;

import javax.annotation.Generated;
import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * イメージ権限削除サービスのリクエストBeanです。<br/>
 */
@Generated("このソースは全てツールから吐き出されています。")
@SuppressWarnings("serial")
public class WSDelImageAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "DelImageAuthority";

    @FormParam(IWSDelImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    private String sImageauthid_;

    @FormParam(IWSDelImageAuthorityIOKey.IN.sS_IMAGEAUTHIDS)
    private String[] sImageauthids_;

    @JSONHint(name=IWSDelImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    public String getImageauthid() {
        return sImageauthid_;
    }

    public void setImageauthid(String psImageauthid) {
        sImageauthid_ = psImageauthid;
    }

    @JSONHint(name=IWSDelImageAuthorityIOKey.IN.sS_IMAGEAUTHIDS)
    public String[] getImageauthids() {
        return sImageauthids_;
    }

    public void setImageauthids(String[] psImageauthids) {
        sImageauthids_ = psImageauthids;
    }

}
