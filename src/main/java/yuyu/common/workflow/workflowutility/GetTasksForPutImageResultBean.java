package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * イメージ取込対象リスト取得 の処理結果クラスです。<br />
 */
public class GetTasksForPutImageResultBean extends WorkListResultBean{

    public GetTasksForPutImageResultBean() {
    }

    private List<TaskSummaryForPutImageBean> taskSummaryBeanList = new ArrayList<TaskSummaryForPutImageBean>();

    public List<TaskSummaryForPutImageBean> getTaskSummaryBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryBeanList(List<TaskSummaryForPutImageBean> pTaskSummaryBeanList) {
        taskSummaryBeanList = pTaskSummaryBeanList;
    }
}
