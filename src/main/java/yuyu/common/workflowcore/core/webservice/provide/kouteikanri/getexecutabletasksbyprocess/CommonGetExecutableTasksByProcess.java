package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess;

public class CommonGetExecutableTasksByProcess {

    public static class WSTaskCount{

        private long kojin;
        private long kyouyuu;

        public long getKojin() {
            return kojin;
        }

        public void setKojin(long pKojin) {
            kojin = pKojin;
        }

        public long getKyouyuu() {
            return kyouyuu;
        }

        public void setKyouyuu(long pKyouyuu) {
            kyouyuu = pKyouyuu;
        }

    }

    public static class TaskInfo {

        private String sFlowid_;
        private String sNodename_;

        public String getFlowid() {
            return sFlowid_;
        }

        public void setFlowid(String psFlowid) {
            sFlowid_ = psFlowid;
        }

        public String getNodename() {
            return sNodename_;
        }

        public void setNodename(String psNodename) {
            sNodename_ = psNodename;
        }

        public String getName() {
            return sFlowid_ + "-" + sNodename_;
        }
    }

    public static class TaskCount {

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

    public static class TableRecord {

        private String flowid;

        private String nodename;

        private String taskcountkojin;

        private String taskcountkyouyuu;

        public String getFlowid() {
            return flowid;
        }

        public void setFlowid(String flowid) {
            this.flowid = flowid;
        }

        public String getNodename() {
            return nodename;
        }

        public void setNodename(String nodename) {
            this.nodename = nodename;
        }

        public String getTaskcountkojin() {
            return taskcountkojin;
        }

        public void setTaskcountkojin(String taskcountkojin) {
            this.taskcountkojin = taskcountkojin;
        }

        public String getTaskcountkyouyuu() {
            return taskcountkyouyuu;
        }

        public void setTaskcountkyouyuu(String taskcountkyouyuu) {
            this.taskcountkyouyuu = taskcountkyouyuu;
        }
    }
}
