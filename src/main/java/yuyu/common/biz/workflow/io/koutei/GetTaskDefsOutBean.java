package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.biz.workflow.io.koutei.sub.TaskDefBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsResponse;

/**
 * タスク定義取得サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetTaskDefsOutBean extends WSGetTaskDefsResponse {

    private List<TaskDefBean> oTaskDefBeanList_ = null;


    public List<TaskDefBean> getTaskDefBeanList() {
        return oTaskDefBeanList_;
    }

    public void setTaskDefBeanList(List<TaskDefBean> pTaskDefBeanList) {
        oTaskDefBeanList_ = pTaskDefBeanList;
    }

    @Override
    @Deprecated
    public Map<String, String>[] getTaskdefs() {
        return null;
    }

}
