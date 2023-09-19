package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程遷移（バッチ用）サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessForwardBeanForBatch extends WSCommonRequest {

    private String gyoumuKey;

    private String flowId;

    private Object ruleCondition;

    private String ruleConditionName;

    private String extInfo;

    private String rirekiTaskName;

    private String rirekiTaskMessage;

    private String lockConfirmKbn;

    private String lockKey;

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return gyoumuKey;
    }

    public void setGyoumukey(String psGyoumukey) {
        this.gyoumuKey = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return flowId;
    }

    public void setFlowid(String pFlowId) {
        this.flowId = pFlowId;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_CONDITION)
    public Object getRuleCondition() {
        return ruleCondition;
    }

    public void setRuleCondition(Object pRuleCondition) {
        this.ruleCondition = pRuleCondition;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RULE_CONDITIONNAME)
    public String getRuleConditionName() {
        return ruleConditionName;
    }

    public void setRuleConditionName(String pRuleConditionName) {
        this.ruleConditionName = pRuleConditionName;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String pExtInfo) {
        extInfo = pExtInfo;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_RIREKI_TASKNAME)
    public String getRirekiTaskName() {
        return rirekiTaskName;
    }

    public void setRirekiTaskName(String pRirekiTaskName) {
        this.rirekiTaskName = pRirekiTaskName;
    }

    public String getRirekiTaskMessage() {
        return rirekiTaskMessage;
    }

    public void setRirekiTaskMessage(String pRirekiTaskName) {
        this.rirekiTaskMessage = pRirekiTaskName;
    }

    public String getLockConfirmKbn() {
        return lockConfirmKbn;
    }

    public void setLockConfirmKbn(String pLockConfirmKbn) {
        this.lockConfirmKbn = pLockConfirmKbn;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return lockKey;
    }

    public void setLockkey(String pLockkey) {
        this.lockKey = pLockkey;
    }

    @Override
    @Deprecated
    public void setRequestid(String psRequestid) {
    }

}
