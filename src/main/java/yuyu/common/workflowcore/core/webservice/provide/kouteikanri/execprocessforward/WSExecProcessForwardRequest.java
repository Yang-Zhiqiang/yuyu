package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程遷移サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessForwardRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessForward";

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_LOCKKEY)
    private String sLockkey_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_RULE_SERVICEURL)
    private String ruleServiceUrl_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_RIREKI_TASKNAME)
    private String rirekiTaskName_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_EXTINFO)
    private String sExtinfo_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_RULE_CONDITIONNAME)
    private String sRuleConditionName_;

    @FormParam(IWSExecProcessForwardIOKey.IN.sS_RULE_CONDITION)
    private String sRuleCondition_;

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return sLockkey_;
    }

    public void setLockkey(String psLockkey) {
        sLockkey_ = psLockkey;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_EXTINFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RULE_SERVICEURL)
    public String getRuleServiceUrl() {
        return ruleServiceUrl_;
    }

    public void setRuleServiceUrl(String ruleServiceUrl) {
        this.ruleServiceUrl_ = ruleServiceUrl;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RIREKI_TASKNAME)
    public String getRirekiTaskName() {
        return rirekiTaskName_;
    }

    public void setRirekiTaskName(String rirekiTaskName) {
        this.rirekiTaskName_ = rirekiTaskName;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RULE_CONDITIONNAME)
    public String getRuleConditionName() {
        return sRuleConditionName_;
    }

    public void setRuleConditionName(String psRuleConditionName) {
        sRuleConditionName_ = psRuleConditionName;
    }

    @JSONHint(name=IWSExecProcessForwardIOKey.IN.sS_RULE_CONDITION)
    public String getRuleCondition() {
        return sRuleCondition_;
    }

    public void setRuleCondition(String psRuleCondition) {
        sRuleCondition_ = psRuleCondition;
    }
}
