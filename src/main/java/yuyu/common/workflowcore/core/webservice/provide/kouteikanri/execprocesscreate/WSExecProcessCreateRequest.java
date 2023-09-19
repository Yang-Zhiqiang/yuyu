package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程開始サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessCreateRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessCreate";

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_PROCESSGROUP)
    private String sProcessgroup_;

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;

    @FormParam(IWSExecProcessCreateIOKey.IN.sS_RIREKI_TASKNAME)
    private String rirekiTaskName_;

    @JSONHint(name=IWSExecProcessCreateIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessCreateIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecProcessCreateIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessCreateIOKey.IN.sS_PROCESSGROUP)
    public String getProcessgroup() {
        return sProcessgroup_;
    }

    public void setProcessgroup(String psProcessgroup) {
        sProcessgroup_ = psProcessgroup;
    }

    @JSONHint(name=IWSExecProcessCreateIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

    public String getRirekiTaskName() {
        return rirekiTaskName_;
    }

    public void setRirekiTaskName(String rirekiTaskName) {
        this.rirekiTaskName_ = rirekiTaskName;
    }

}
