package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;

public class CommonGetExecutableTasks {

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
