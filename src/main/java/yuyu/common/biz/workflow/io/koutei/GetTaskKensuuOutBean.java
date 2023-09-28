package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuResponse;

/**
 * タスク件数照会サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetTaskKensuuOutBean extends WSGetTaskKensuuResponse {

    private List<TaskSummaryBean> oTaskSummaryBeanList;

    public List<TaskSummaryBean> getTaskSummaryBeanList() {
        return oTaskSummaryBeanList;
    }

    public void setTaskSummaryBeanList(List<TaskSummaryBean> poTaskSummaryBeanList) {
        oTaskSummaryBeanList = poTaskSummaryBeanList;
    }
}
