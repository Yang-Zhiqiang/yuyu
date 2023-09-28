package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;

/**
 * タスクサマリ定義情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class TaskSummaryByActorBean implements Serializable {

    private String flowId;

    private String flowName;

    private String taskName;

    private String taskLocalName;

    private String userId;

    private String taskCount;


    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String pFlowName) {
        flowName = pFlowName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String pTaskName) {
        this.taskName = pTaskName;
    }

    public String getTaskLocalName() {
        return taskLocalName;
    }

    public void setTaskLocalName(String pTaskLocalName) {
        this.taskLocalName = pTaskLocalName;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String pTaskCount) {
        this.taskCount = pTaskCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }
}
