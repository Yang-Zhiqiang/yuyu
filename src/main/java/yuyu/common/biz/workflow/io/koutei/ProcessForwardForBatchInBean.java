package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessForwardForBatchBean;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.IWSExecProcessForwardForBatchIOKey;

/**
 * 工程遷移(バッチ用)サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessForwardForBatchInBean extends WSCommonRequest {


    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_ACCOUNTID)
    private String accountId;

    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_SERVICEURL)
    private String ruleServiceUrl;

    @FormParam(IWSExecProcessForwardForBatchIOKey.IN.sS_RIREKI_SAKUSEI_YOUHI)
    private String rirekiYouhi = "0";

    private List<ProcessForwardForBatchBean> processForwardForBatchBeanList;


    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_ACCOUNTID)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountid(String pAccountId) {
        accountId = pAccountId;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_SERVICEURL)
    public String getRuleServiceUrl() {
        return ruleServiceUrl;
    }

    public void setRuleServiceUrl(String ruleServiceUrl) {
        this.ruleServiceUrl = ruleServiceUrl;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RIREKI_SAKUSEI_YOUHI)
    public String getRirekiYouhi() {
        return rirekiYouhi;
    }

    public void setRirekiYouhi(String psRirekiYouhi) {
        this.rirekiYouhi = psRirekiYouhi;
    }

    public List<ProcessForwardForBatchBean> getProcessForwardForBatchBeanList() {
        return processForwardForBatchBeanList;
    }

    public void setProcessForwardForBatchBeanList(List<ProcessForwardForBatchBean> pProcessForwardForBatchBeanList) {
        processForwardForBatchBeanList = pProcessForwardForBatchBeanList;
    }

    @Deprecated
    public void setProcessCreateInBeanList(List<ProcessForwardForBatchBean> pProcessForwardForBatchBeanList) {
    }
}
