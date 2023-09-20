package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;

/**
 * 事務用コード入力工程リスト取得 の処理結果クラスです。<br />
 */
public class GetTasksForJimuyouCdResultBean extends WorkListResultBean{

    public GetTasksForJimuyouCdResultBean() {
    }

    private LockGyoumuKeyBean lockGyoumuKeyBean = SWAKInjector.getInstance(LockGyoumuKeyBean.class);

    public LockGyoumuKeyBean getLockGyoumuKeyBean() {
        return lockGyoumuKeyBean;
    }

    public void setLockGyoumuKeyBean(LockGyoumuKeyBean pLockGyoumuKeyBean) {
        lockGyoumuKeyBean = pLockGyoumuKeyBean;
    }

    private List<TaskSummaryForJimuyouCdBean> taskSummaryBeanList = new ArrayList<TaskSummaryForJimuyouCdBean>();

    public List<TaskSummaryForJimuyouCdBean> getTaskSummaryForJimuyouCdBeanList() {
        return taskSummaryBeanList;
    }

    public void setTaskSummaryForJimuyouCdBeanList(List<TaskSummaryForJimuyouCdBean> pTaskSummaryForJimuyouCdBeanList) {
        taskSummaryBeanList = pTaskSummaryForJimuyouCdBeanList;
    }
}
