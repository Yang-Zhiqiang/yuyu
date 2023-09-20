package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * ワークフロー呼出Utility の処理結果共通クラスです。<br />
 */
public class WorkListResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKekkaStatus;

    public String getSyorikekkaStatus() {
        return syoriKekkaStatus;
    }

    public void setSyorikekkaStatus(String pSyoriKekkaStatus) {
        syoriKekkaStatus = pSyoriKekkaStatus;
    }

    private String syousaiMessageCd;

    public String getSyousaiMessageCd() {
        return syousaiMessageCd;
    }

    public void setSyousaiMessageCd(String pSyousaiMessageCd) {
        syousaiMessageCd = pSyousaiMessageCd;
    }

    private String syousaiMessage;

    public String getSyousaiMessage() {
        return syousaiMessage;
    }

    public void setSyousaiMessage(String pSyousaiMessage) {
        syousaiMessage = pSyousaiMessage;
    }

}
