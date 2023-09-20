package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * タスク担当者名取得 の処理結果クラスです。<br />
 */
public class GetTaskTantoInfoListResultBean extends WorkListResultBean{

    public GetTaskTantoInfoListResultBean() {
    }

    private List<TaskTantoInfoBean> taskTantoInfoBeanList = new ArrayList<TaskTantoInfoBean>();

    public List<TaskTantoInfoBean> getTaskTantoInfoBeanList() {
        return taskTantoInfoBeanList;
    }

    public void setTaskTantoInfoBeanList(List<TaskTantoInfoBean> pTaskTantoInfoBeanList) {
        taskTantoInfoBeanList = pTaskTantoInfoBeanList;
    }
}
