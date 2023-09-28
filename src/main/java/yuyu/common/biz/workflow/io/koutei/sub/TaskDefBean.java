package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;

/**
 * タスク定義情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class TaskDefBean implements Serializable {

    private String flowId_;

    private String flowName_;

    private String taskName_;

    private String taskLocalName_;

    private String taskKengen_;


    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        flowId_ = pFlowId;
    }

    public String getFlowName() {
        return flowName_;
    }

    public void setFlowName(String pFlowName) {
        flowName_ = pFlowName;
    }

    public String getTaskName() {
        return taskName_;
    }

    public void setTaskName(String pTaskName) {
        this.taskName_ = pTaskName;
    }

    public String getTaskLocalName() {
        return taskLocalName_;
    }

    public void setTaskLocalName(String pTaskLocalName) {
        this.taskLocalName_ = pTaskLocalName;
    }

    public String getTaskKengen() {
        return taskKengen_;
    }

    public void setTaskKengen(String pTaskKengen) {
        this.taskKengen_ = pTaskKengen;
    }

}
