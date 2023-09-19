package yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 権限更新サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSUpdImageAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "UpdImageAuthority";

    @FormParam(IWSUpdImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    private String sImageauthid_;

    @FormParam(IWSUpdImageAuthorityIOKey.IN.sS_TORIKOMISYORUICDSS)
    private String[] sTorikomisyoruicds_;

    @JSONHint(name=IWSUpdImageAuthorityIOKey.IN.sS_IMAGEAUTHID)
    public String getImageauthid() {
        return sImageauthid_;
    }

    public void setImageauthid(String psAuthid) {
        sImageauthid_ = psAuthid;
    }

    @JSONHint(name=IWSUpdImageAuthorityIOKey.IN.sS_TORIKOMISYORUICDSS)
    public String[] getTorikomisyoruicds() {
        return sTorikomisyoruicds_;
    }

    public void setTorikomisyoruicds(String[] psTorikomisyoruicds) {
        sTorikomisyoruicds_ = psTorikomisyoruicds;
    }
}
