package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryResponse;

/**
 * タスク件数サマリ照会サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetTaskSummaryOutBean extends WSGetTaskSummaryResponse {

    private List<TaskSummaryBean> oTaskSummaryBeanList;

    public List<TaskSummaryBean> getTaskSummaryBeanList() {
        return oTaskSummaryBeanList;
    }

    public void setTaskSummaryBeanList(List<TaskSummaryBean> poTaskSummaryBeanList) {
        oTaskSummaryBeanList = poTaskSummaryBeanList;
    }
}
