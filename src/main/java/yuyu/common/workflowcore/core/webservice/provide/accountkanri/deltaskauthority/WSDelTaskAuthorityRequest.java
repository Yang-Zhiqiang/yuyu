package yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク権限削除サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSDelTaskAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "DelTaskAuthority";

    @FormParam(IWSDelTaskAuthorityIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSDelTaskAuthorityIOKey.IN.sS_MAPLISTXML)
    private String sMaplistXml_;


    @JSONHint(name=IWSDelTaskAuthorityIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSDelTaskAuthorityIOKey.IN.sS_MAPLISTXML)
    public String getMaplistXml() {
        return sMaplistXml_;
    }

    public void setMaplistXml(String psMaplistXml) {
        sMaplistXml_ = psMaplistXml;
    }

}
