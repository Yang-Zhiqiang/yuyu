package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.IWSExecProcessForwardIOKey;

/**
 * 工程情報更新サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessUpdateRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessUpdate";

    @FormParam(IWSExecProcessUpdateIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecProcessUpdateIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecProcessUpdateIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessUpdateIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;


    @FormParam(IWSExecProcessForwardIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;
    @JSONHint(name=IWSExecProcessUpdateIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessUpdateIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecProcessUpdateIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessUpdateIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSExecProcessUpdateIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
