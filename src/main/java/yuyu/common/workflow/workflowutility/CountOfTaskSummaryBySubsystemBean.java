package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;


/**
 * 処理残件数Bean の処理結果クラスです。<br />
 */
public class CountOfTaskSummaryBySubsystemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }


    private String jimutetuzukiNm;

    public String getJimutetuzukiNm() {
        return jimutetuzukiNm;
    }

    public void setJimutetuzukiNm(String pJimutetuzukiNm) {
        jimutetuzukiNm = pJimutetuzukiNm;
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

    private boolean taskFinByActorFlg;

    public boolean isTaskFinByActorFlg() {
        return taskFinByActorFlg;
    }

    public void setTaskFinByActorFlg(boolean taskFinByActorFlg) {
        this.taskFinByActorFlg = taskFinByActorFlg;
    }


}
