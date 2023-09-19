package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程履歴詳細取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiRirekiSyousaiRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetKouteiRirekiSyousai";

    @FormParam(IWSGetKouteiRirekiSyousaiIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetKouteiRirekiSyousaiIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSGetKouteiRirekiSyousaiIOKey.IN.sS_RIREKIKBN)
    private String sRirekikbn_;

    @JSONHint(name=IWSGetKouteiRirekiSyousaiIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetKouteiRirekiSyousaiIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSGetKouteiRirekiSyousaiIOKey.IN.sS_RIREKIKBN)
    public String getRirekikbn() {
        return sRirekikbn_;
    }

    public void setRirekikbn(String psRirekikbn) {
        sRirekikbn_ = psRirekikbn;
    }

}
