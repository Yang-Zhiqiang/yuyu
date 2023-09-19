package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程属性取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetProcessAttributeRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetProcessAttribute";

    @FormParam(IWSGetProcessAttributeIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetProcessAttributeIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @JSONHint(name=IWSGetProcessAttributeIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetProcessAttributeIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

}
