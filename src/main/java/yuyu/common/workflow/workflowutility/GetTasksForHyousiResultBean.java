package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 取込用表紙作成対象リスト取得 の処理結果クラスです。<br />
 */
public class GetTasksForHyousiResultBean extends WorkListResultBean{

    public GetTasksForHyousiResultBean() {
    }

    private List<TaskSummaryForHyousiBean> taskSummaryBeanList = new ArrayList<TaskSummaryForHyousiBean>();

    public List<TaskSummaryForHyousiBean> getTaskSummaryForHyousiBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryForHyousiBeanList(List<TaskSummaryForHyousiBean> pTaskSummaryForHyousiBeanList) {
        taskSummaryBeanList = pTaskSummaryForHyousiBeanList;
    }
}
