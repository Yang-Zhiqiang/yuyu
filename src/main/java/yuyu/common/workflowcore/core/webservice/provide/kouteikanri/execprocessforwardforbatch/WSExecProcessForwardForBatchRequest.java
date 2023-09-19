package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

import java.util.List;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程遷移（バッチ用）サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessForwardForBatchRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessForwardForBatch";

    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_SERVICEURL)
    private String ruleServiceUrl_;

    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_RIREKI_SAKUSEI_YOUHI)
    private String rirekiYouhi_;

    private List<ProcessForwardBeanForBatch> processForwardForBatchBeanList;

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_SERVICEURL)
    public String getRuleServiceUrl() {
        return ruleServiceUrl_;
    }

    public void setRuleServiceUrl(String ruleServiceUrl) {
        this.ruleServiceUrl_ = ruleServiceUrl;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RIREKI_SAKUSEI_YOUHI)
    public String getRirekiYouhi() {
        return rirekiYouhi_;
    }

    public void setRirekiYouhi(String psRirekiYouhi) {
        this.rirekiYouhi_ = psRirekiYouhi;
    }

    public List<ProcessForwardBeanForBatch> getProcessForwardForBatchBeanList() {
        return processForwardForBatchBeanList;
    }

    public void setProcessForwardForBatchBeanList(List<ProcessForwardBeanForBatch> pProcessForwardForBatchBeanList) {
        processForwardForBatchBeanList = pProcessForwardForBatchBeanList;
    }
}
