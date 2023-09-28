package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;

/**
 * 実行可能タスク情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class ExecutableTaskInfoBean implements Serializable {

    private String flowId_;

    private String sNodeName_;

    private String sTaskCountKojin_;

    private String sTaskCountKyouyuu_;

    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        flowId_ = pFlowId;
    }

    public String getNodeName() {
        return sNodeName_;
    }

    public void setNodeName(String pNodeName) {
        sNodeName_ = pNodeName;
    }

    public String getTaskCountKojin() {
        return sTaskCountKojin_;
    }

    public void setTaskCountKojin(String pTaskCountKojin) {
        sTaskCountKojin_ = pTaskCountKojin;
    }

    public String getTaskCountKyouyuu() {
        return sTaskCountKyouyuu_;
    }

    public void setTaskcountKyouyuu(String pTaskCountKyouyuu) {
        sTaskCountKyouyuu_ = pTaskCountKyouyuu;
    }


}
