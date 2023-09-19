package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 件数サマリ作成サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSCreateTaskSummaryRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecTaskSummary";

    @FormParam(IWSCreateTaskSummaryIOKey.IN.sS_FLOWIDS)
    private String[] sFlowids_;

    @JSONHint(name=IWSCreateTaskSummaryIOKey.IN.sS_FLOWIDS)
    public String[] getSFlowids() {
        return sFlowids_;
    }

    public void setSFlowids(String[] psFlowids) {
        sFlowids_ = psFlowids;
    }
}
