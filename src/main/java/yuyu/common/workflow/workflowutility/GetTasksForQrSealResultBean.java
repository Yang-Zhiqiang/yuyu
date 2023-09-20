package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * ＱＲシール用紙作成用案件存在チェック の処理結果クラスです。<br />
 */
public class GetTasksForQrSealResultBean extends WorkListResultBean{

    public GetTasksForQrSealResultBean() {
    }

    private List<TaskSummaryForQrSealBean> taskSummaryBeanList = new ArrayList<TaskSummaryForQrSealBean>();

    public List<TaskSummaryForQrSealBean> getTaskSummaryForQrSealBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryForQrSealBeanList(List<TaskSummaryForQrSealBean> pTaskSummaryForQrSealBeanList) {
        taskSummaryBeanList = pTaskSummaryForQrSealBeanList;
    }
}
