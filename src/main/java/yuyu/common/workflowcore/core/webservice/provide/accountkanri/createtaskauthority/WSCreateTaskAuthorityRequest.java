package yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク権限追加サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSCreateTaskAuthorityRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "CreateTaskAuthority";

    @FormParam(IWSCreateTaskAuthorityIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSCreateTaskAuthorityIOKey.IN.sS_MAPLISTXML)
    private String sMaplistXml_;


    @JSONHint(name=IWSCreateTaskAuthorityIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSCreateTaskAuthorityIOKey.IN.sS_MAPLISTXML)
    public String getMaplistXml() {
        return sMaplistXml_;
    }

    public void setMaplistXml(String psMaplistXml) {
        sMaplistXml_ = psMaplistXml;
    }

}
