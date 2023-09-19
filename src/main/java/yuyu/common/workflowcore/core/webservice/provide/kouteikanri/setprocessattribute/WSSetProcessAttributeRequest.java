package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程属性設定サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSSetProcessAttributeRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "SetProcessAttribute";

    @FormParam(IWSSetProcessAttributeIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSSetProcessAttributeIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSSetProcessAttributeIOKey.IN.sS_JSONDATA)
    private String sJsondata_;

    @FormParam(IWSSetProcessAttributeIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @JSONHint(name=IWSSetProcessAttributeIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSSetProcessAttributeIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSSetProcessAttributeIOKey.IN.sS_JSONDATA)
    public String getJsondata() {
        return sJsondata_;
    }

    public void setJsondata(String psJsondata) {
        sJsondata_ = psJsondata;
    }

    @JSONHint(name=IWSSetProcessAttributeIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

}
