package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程履歴作成のInBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSCreateProcessRecordRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "CreateProcessRecord";

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_RIREKIMSG)
    private String sRirekimsg_;

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;

    @FormParam(IWSCreateProcessRecordIOKey.IN.sS_TASKNAME)
    private String sTaskname_;


    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_RIREKIMSG)
    public String getRirekimsg() {
        return sRirekimsg_;
    }

    public void setRirekimsg(String psRirekimsg) {
        sRirekimsg_ = psRirekimsg;
    }

    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

    @JSONHint(name=IWSCreateProcessRecordIOKey.IN.sS_TASKNAME)
    public String getTaskname() {
        return sTaskname_;
    }

    public void setTaskname(String psTaskname) {
        sTaskname_ = psTaskname;
    }

}
