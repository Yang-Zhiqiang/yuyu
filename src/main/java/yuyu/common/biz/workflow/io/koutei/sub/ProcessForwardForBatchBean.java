package yuyu.common.biz.workflow.io.koutei.sub;

import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.IWSExecProcessForwardIOKey;

/**
 * 工程遷移サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessForwardForBatchBean extends WSCommonRequest {

    private String gyoumuKey;

    private String flowId;

    private Object ruleCondition;

    private List<Map<String, String>> extInfo;

    private String rirekiTaskName;

    private String rirekiTaskMessage;

    private String lockConfirmKbn;

    private String lockKey;

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return gyoumuKey;
    }

    public void setGyoumukey(String psGyoumukey) {
        this.gyoumuKey = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return flowId;
    }

    public void setFlowid(String pFlowId) {
        this.flowId = pFlowId;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RULE_CONDITION)
    public Object getRuleCondition() {
        return ruleCondition;
    }

    public void setRuleCondition(Object pRuleCondition) {
        this.ruleCondition = pRuleCondition;
    }

    public List<Map<String, String>> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo = pExtInfo;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RIREKI_TASKNAME)
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

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_LOCKKEY)
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
