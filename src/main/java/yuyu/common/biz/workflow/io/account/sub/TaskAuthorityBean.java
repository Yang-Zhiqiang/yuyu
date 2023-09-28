package yuyu.common.biz.workflow.io.account.sub;

import java.io.Serializable;

/**
 * タスク権限Bean
 */
@SuppressWarnings("serial")
public class TaskAuthorityBean implements Serializable {


    private String sflowid_;

    private String sTaskname_;

    private String[] oRolecds_;


    public String getFlowid() {
        return sflowid_;
    }

    public void setFlowid(String psFlowid) {
        sflowid_ = psFlowid;
    }

    public String getTaskname() {
        return sTaskname_;
    }

    public void setTaskname(String psTaskname) {
        sTaskname_ = psTaskname;
    }

    public String[] getRolecds() {
        return oRolecds_;
    }

    public void setRolecds(String[] psRolecds) {
        oRolecds_ = psRolecds;
    }

}
