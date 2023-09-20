package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程ワークリスト一覧表示用リスト取得（新契約以外） の処理結果クラスです。<br />
 */
public class GetTasksForWorkListResultBean extends WorkListResultBean{

    public GetTasksForWorkListResultBean() {
    }

    private List<TaskSummaryForWorkListBean> taskSummaryBeanList = new ArrayList<TaskSummaryForWorkListBean>();

    public List<TaskSummaryForWorkListBean> getTaskSummaryForWorkListBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryForWorkListBeanList(List<TaskSummaryForWorkListBean> pTaskSummaryForWorkListBeanList) {
        taskSummaryBeanList = pTaskSummaryForWorkListBeanList;
    }
}
