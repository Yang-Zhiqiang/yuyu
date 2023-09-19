package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 一括工程開始サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSIkkatuProcessCreateRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "IkkatuProcessCreate";

    @FormParam(IWSIkkatuProcessCreateIOKey.IN.sS_MAPLISTXML)
    private String sMaplistXml_;

    @JSONHint(name=IWSIkkatuProcessCreateIOKey.IN.sS_MAPLISTXML)
    public String getMaplistXml() {
        return sMaplistXml_;
    }

    public void setMaplistXml(String psMaplistXml) {
        sMaplistXml_ = psMaplistXml;
    }

}
