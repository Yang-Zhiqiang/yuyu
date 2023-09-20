package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * ロック中工程リスト取得 の処理結果クラスです。<br />
 */
public class GetLockedTaskListResultBean extends WorkListResultBean{

    public GetLockedTaskListResultBean() {
    }

    private List<LockedTaskSummaryBean> lockedTaskSummaryBeanList = new ArrayList<LockedTaskSummaryBean>();

    public List<LockedTaskSummaryBean> getLockedTaskSummaryBeanList() {
        return lockedTaskSummaryBeanList;
    }

    public void setLockedTaskSummaryBeanList(List<LockedTaskSummaryBean> pLockedTaskSummaryBeanList) {
        lockedTaskSummaryBeanList = pLockedTaskSummaryBeanList;
    }
}
