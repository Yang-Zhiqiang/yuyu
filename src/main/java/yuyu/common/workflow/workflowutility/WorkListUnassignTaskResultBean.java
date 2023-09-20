package yuyu.common.workflow.workflowutility;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;

/**
 * ワークフロー呼出Utility の処理結果共通クラスです。<br />
 */
public class WorkListUnassignTaskResultBean extends WorkListResultBean{

    public WorkListUnassignTaskResultBean() {
    }

    private String errorApiName;

    public String getErrorApiName() {
        return errorApiName;
    }

    public void setErrorApiName(String pErrorApiName) {
        errorApiName = pErrorApiName;
    }

    private LockProcessInBean lockProcessInBean = SWAKInjector.getInstance(LockProcessInBean.class);

    public LockProcessInBean getLockProcessInBean() {
        return lockProcessInBean;
    }

    public void setLockProcessInBean(LockProcessInBean pLockProcessInBean) {
        lockProcessInBean = pLockProcessInBean;
    }

}
