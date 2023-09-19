package yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 権限削除サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSDelAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "DelAuthority";

    @FormParam(IWSDelAuthorityIOKey.IN.sS_AUTHID)
    private String sAuthid_;

    @JSONHint(name=IWSDelAuthorityIOKey.IN.sS_AUTHID)
    public String getAuthid() {
        return sAuthid_;
    }

    public void setAuthid(String psAuthid) {
        sAuthid_ = psAuthid;
    }

}
