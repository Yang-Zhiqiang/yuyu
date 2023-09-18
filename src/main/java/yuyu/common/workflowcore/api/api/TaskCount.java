package yuyu.common.workflowcore.api.api;

/**
 */
public class TaskCount {

    private String flowId;
    private long myTaskCount;
    private long wariatezumiTaskCount;
    private long miwariateTaskCount;

    private String taskName;

    public String getFlowId() {
        return flowId;
    }
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
    public long getMyTaskCount() {
        return myTaskCount;
    }
    public void setMyTaskCount(long myTaskCount) {
        this.myTaskCount = myTaskCount;
    }
    public long getWariatezumiTaskCount() {
        return wariatezumiTaskCount;
    }
    public void setWariatezumiTaskCount(long wariatezumiTaskCount) {
        this.wariatezumiTaskCount = wariatezumiTaskCount;
    }
    public long getMiwariateTaskCount() {
        return miwariateTaskCount;
    }
    public void setMiwariateTaskCount(long miwariateTaskCount) {
        this.miwariateTaskCount = miwariateTaskCount;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
