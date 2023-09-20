package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程状況照会用リスト取得 の処理結果クラスです。<br />
 */
public class GetTasksForKouteiStatusResultBean extends WorkListResultBean{

    public GetTasksForKouteiStatusResultBean() {
    }

    private List<TaskSummaryForKouteiStatusBean> taskSummaryBeanList = new ArrayList<TaskSummaryForKouteiStatusBean>();

    public List<TaskSummaryForKouteiStatusBean> getTaskSummaryForKouteiStatusBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryForKouteiStatusBeanList(List<TaskSummaryForKouteiStatusBean> pTaskSummaryForKouteiStatusBeanList) {
        taskSummaryBeanList = pTaskSummaryForKouteiStatusBeanList;
    }
}
