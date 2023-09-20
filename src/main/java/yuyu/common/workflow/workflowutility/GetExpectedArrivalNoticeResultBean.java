package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 到着予定取得 の処理結果クラスです。<br />
 */
public class GetExpectedArrivalNoticeResultBean extends WorkListResultBean{

    public GetExpectedArrivalNoticeResultBean() {
    }

    private String lockingQrCd;

    public String getLockingQrCd() {
        return lockingQrCd;
    }

    public void setLockingQrCd(String pLockingQrCd) {
        lockingQrCd = pLockingQrCd;
    }

    private List<ExpectedArrivalNoticeBean> expectedArrivalNoticeBeanList = new ArrayList<ExpectedArrivalNoticeBean>();

    public List<ExpectedArrivalNoticeBean> getExpectedArrivalNoticeBeanList() {
        return expectedArrivalNoticeBeanList;
    }

    public void setExpectedArrivalNoticeBeanList(List<ExpectedArrivalNoticeBean> pTorikomiSyoruiMstBeanList) {
        expectedArrivalNoticeBeanList = pTorikomiSyoruiMstBeanList;
    }
}
