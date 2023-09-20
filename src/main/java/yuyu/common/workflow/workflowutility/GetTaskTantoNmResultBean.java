package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * タスク担当者名取得 の処理結果クラスです。<br />
 */
public class GetTaskTantoNmResultBean extends WorkListResultBean{

    public GetTaskTantoNmResultBean() {
    }

    private List<TaskTantoNmBean> taskTantoNmBeanList = new ArrayList<TaskTantoNmBean>();

    public List<TaskTantoNmBean> getTaskTantoNmBeanList() {
        return taskTantoNmBeanList;
    }

    public void setTaskTantoNmBeanList(List<TaskTantoNmBean> pTaskTantoNmBeanList) {
        taskTantoNmBeanList = pTaskTantoNmBeanList;
    }
}
