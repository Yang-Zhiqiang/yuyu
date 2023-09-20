package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 取消対象工程リスト取得 の処理結果クラスです。<br />
 */
public class GetTasksForCancelResultBean extends WorkListResultBean{

    public GetTasksForCancelResultBean() {
    }

    private List<TaskForCancelBean> taskForCancelBeanList = new ArrayList<TaskForCancelBean>();

    public List<TaskForCancelBean> getTaskForCancelBeanList() {
        return taskForCancelBeanList;
    }

    public void setTaskForCancelBeanList(List<TaskForCancelBean> pTaskForCancelBeanList) {
        taskForCancelBeanList = pTaskForCancelBeanList;
    }
}
