package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 工程履歴Bean の処理結果クラスです。<br />
 */
public class ProcessHistoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String processYmdTime;

    public String getProcessYmdTime() {
        return processYmdTime;
    }

    public void setProcessYmdTime(String pProcessYmdTime) {
        processYmdTime = pProcessYmdTime;
    }

    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }


    private String dispTaskNm;

    public String getDispTaskNm() {
        return dispTaskNm;
    }

    public void setDispTaskNm(String pDispTaskNm) {
        dispTaskNm = pDispTaskNm;
    }

    private String processResult;

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String pProcessResult) {
        processResult = pProcessResult;
    }

    private String tantouId;

    public String getTantouId() {
        return tantouId;
    }

    public void setTantouId(String pTantouId) {
        tantouId = pTantouId;
    }


    private String tantouNm;

    public String getTantouNm() {
        return tantouNm;
    }

    public void setTantouNm(String pTantouNm) {
        tantouNm = pTantouNm;
    }

    private String historyMessage;

    public String getHistoryMessage() {
        return historyMessage;
    }

    public void setHistoryMessage(String pHistoryMessage) {
        historyMessage = pHistoryMessage;
    }
}
