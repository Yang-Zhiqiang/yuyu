package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest;

/**
 * 工程遷移サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessForwardInBean extends WSExecProcessForwardRequest {

    private List<Map<String, String>> extInfo_;

    private Object condition_;

    public List<Map<String, String>> getExtInfo() {
        return extInfo_;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo_ = pExtInfo;
    }

    @Override
    @Deprecated
    public void setExtinfo(String psExtInfo) {
    }

    public Object getCondition() {
        return condition_;
    }

    public void setCondition(Object pCondition) {
        condition_ = pCondition;
    }

    @Override
    @Deprecated
    public void setRuleCondition(String pRuleCondition) {
    }

}
