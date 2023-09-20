package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

/**
 * タスク別処理件数Bean の処理結果クラスです。<br />
 */
public class CountOfTaskBetuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kensuuHokanYmd;

    public BizDate getKensuuHokanYmd() {
        return kensuuHokanYmd;
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        kensuuHokanYmd = pKensuuHokanYmd;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String taskid;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String pTaskid) {
        taskid = pTaskid;
    }

    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String pAccountId) {
        accountId = pAccountId;
    }

    private BizNumber countOfprocessLeftYesterday;

    public BizNumber getCountOfprocessLeftYesterday() {
        return countOfprocessLeftYesterday;
    }

    public void setCountOfprocessLeftYesterday(BizNumber pCountOfprocessLeftYesterday) {
        countOfprocessLeftYesterday = pCountOfprocessLeftYesterday;
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
}
