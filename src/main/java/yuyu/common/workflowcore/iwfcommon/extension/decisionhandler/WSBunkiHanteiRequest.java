package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ファイルレイアウトのBeanです。<br/>
 * このソースは全てツールから吐き出されています。<br />
 * 編集する必要がある場合は、別クラスとして新規作成してください。
 */
@SuppressWarnings("serial")
public class WSBunkiHanteiRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "BunkiHantei";

    @FormParam(IWSBunkiHanteiIOKey.IN.sS_RULE)
    private String sRule_;

    @FormParam(IWSBunkiHanteiIOKey.IN.sS_RULECONDITIONNAME)
    private String sRuleConditionName_;

    @FormParam(IWSBunkiHanteiIOKey.IN.sS_RULECONDITION)
    private String sRuleCondition_;

    @JSONHint(name=IWSBunkiHanteiIOKey.IN.sS_RULE)
    public String getRule() {
        return sRule_;
    }

    public void setRule(String psRule) {
        sRule_ = psRule;
    }

    @JSONHint(name=IWSBunkiHanteiIOKey.IN.sS_RULECONDITIONNAME)
    public String getRuleConditionName() {
        return sRuleConditionName_;
    }

    public void setRuleConditionName(String psRuleConditionName) {
        sRuleConditionName_ = psRuleConditionName;
    }

    @JSONHint(name=IWSBunkiHanteiIOKey.IN.sS_RULECONDITION)
    public String getRuleCondition() {
        return sRuleCondition_;
    }

    public void setRuleCondition(String psRuleCondition) {
        sRuleCondition_ = psRuleCondition;
    }
}
