package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 処理残件数Bean の処理結果クラスです。<br />
 */
public class CountOfTaskSummaryByTaskBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }


    private String dispUserNm;

    public String getDispUserNm() {
        return dispUserNm;
    }

    public void setDispUserNm(String pDispUserNm) {
        dispUserNm = pDispUserNm;
    }


    private BizNumber countOfprocessStartToday;

    public BizNumber getCountOfprocessStartToday() {
        return countOfprocessStartToday;
    }

    public void setCountOfprocessStartToday(BizNumber pCountOfprocessStartToday) {
        countOfprocessStartToday = pCountOfprocessStartToday;
    }


    private BizNumber countOfprocessLeftToday;

    public BizNumber getCountOfprocessLeftToday() {
        return countOfprocessLeftToday;
    }

    public void setCountOfprocessLeftToday(BizNumber pCountOfprocessLeftToday) {
        countOfprocessLeftToday = pCountOfprocessLeftToday;
    }


    private BizNumber countOfprocessFinToday;

    public BizNumber getCountOfprocessFinToday() {
        return countOfprocessFinToday;
    }

    public void setCountOfprocessFinToday(BizNumber pCountOfprocessFinToday) {
        countOfprocessFinToday = pCountOfprocessFinToday;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }
}
