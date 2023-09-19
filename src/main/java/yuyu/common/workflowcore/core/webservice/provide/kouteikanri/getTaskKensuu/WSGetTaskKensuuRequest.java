package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * タスク件数照会サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskKensuuRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "GetTaskKensuu";


    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_WARIATEUMU)
    private String sWariateumu_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKENDUMU)
    private String sTaskendumu_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKID)
    private String sTaskid_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKCREATETIME_FROM)
    private String sTaskcreatetimefrom_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKCREATETIME_TO)
    private String sTaskcreatetimeto_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKSTARTTIME_FROM)
    private String sTaskstarttimefrom_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKSTARTTIME_TO)
    private String sTaskstarttimeto_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKENDTIME_FROM)
    private String sTaskendtimefrom_;

    @FormParam(IWSGetTaskKensuuIOKey.IN.sS_TASKENDTIME_TO)
    private String sTaskendtimeto_;

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_WARIATEUMU)
    public String getWariateumu() {
        return sWariateumu_;
    }

    public void setWariateumu(String psWariateumu) {
        sWariateumu_ = psWariateumu;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKENDUMU)
    public String getTaskendumu() {
        return sTaskendumu_;
    }

    public void setTaskendumu(String psTaskendumu) {
        sTaskendumu_ = psTaskendumu;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKID)
    public String getTaskid() {
        return sTaskid_;
    }

    public void setTaskid(String psTaskid) {
        sTaskid_ = psTaskid;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKCREATETIME_FROM)
    public String getTaskcreatetimefrom() {
        return sTaskcreatetimefrom_;
    }

    public void setTaskcreatetimefrom(String psTaskcreatetimefrom) {
        sTaskcreatetimefrom_ = psTaskcreatetimefrom;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKCREATETIME_TO)
    public String getTaskcreatetimeto() {
        return sTaskcreatetimeto_;
    }

    public void setTaskcreatetimeto(String psTaskcreatetimeto) {
        sTaskcreatetimeto_ = psTaskcreatetimeto;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKSTARTTIME_FROM)
    public String getTaskstarttimefrom() {
        return sTaskstarttimefrom_;
    }

    public void setTaskstarttimefrom(String psTaskstarttimefrom) {
        sTaskstarttimefrom_ = psTaskstarttimefrom;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKSTARTTIME_TO)
    public String getTaskstarttimeto() {
        return sTaskstarttimeto_;
    }

    public void setTaskstarttimeto(String psTaskstarttimeto) {
        sTaskstarttimeto_ = psTaskstarttimeto;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKENDTIME_FROM)
    public String getTaskendtimefrom() {
        return sTaskendtimefrom_;
    }

    public void setTaskendtimefrom(String psTaskendtimefrom) {
        sTaskendtimefrom_ = psTaskendtimefrom;
    }

    @JSONHint(name = IWSGetTaskKensuuIOKey.IN.sS_TASKENDTIME_TO)
    public String getTaskendtimeto() {
        return sTaskendtimeto_;
    }

    public void setTaskendtimeto(String psTaskendtimeto) {
        sTaskendtimeto_ = psTaskendtimeto;
    }
}
