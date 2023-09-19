package yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 権限更新サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSUpdAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "UpdAuthority";

    @FormParam(IWSUpdAuthorityIOKey.IN.sS_AUTHID)
    private String sAuthid_;

    @FormParam(IWSUpdAuthorityIOKey.IN.sS_AUTHNAME)
    private String sAuthname_;

    @JSONHint(name=IWSUpdAuthorityIOKey.IN.sS_AUTHID)
    public String getAuthid() {
        return sAuthid_;
    }

    public void setAuthid(String psAuthid) {
        sAuthid_ = psAuthid;
    }

    @JSONHint(name=IWSUpdAuthorityIOKey.IN.sS_AUTHNAME)
    public String getAuthname() {
        return sAuthname_;
    }

    public void setAuthname(String psAuthname) {
        sAuthname_ = psAuthname;
    }
}
