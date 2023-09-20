package yuyu.common.workflow.workflowutility;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;

import com.google.common.collect.Lists;

/**
 * 事務用コード登録 の処理結果クラスです。<br />
 */
public class PutJimuyouCdResultBean extends WorkListResultBean{

    public PutJimuyouCdResultBean() {
    }

    private String errorApiName;

    public String getErrorApiName() {
        return errorApiName;
    }

    public void setErrorApiName(String pErrorApiName) {
        errorApiName = pErrorApiName;
    }

    private LockGyoumuKeyBean lockGyoumuKeyBean = SWAKInjector.getInstance(LockGyoumuKeyBean.class);

    public LockGyoumuKeyBean getLockGyoumuKeyBean() {
        return lockGyoumuKeyBean;
    }

    public void setLockGyoumuKeyBean(LockGyoumuKeyBean pLockGyoumuKeyBean) {
        lockGyoumuKeyBean = pLockGyoumuKeyBean;
    }

    private List<LockProcessInBean> lockProcessInBean = Lists.newArrayList();

    public List<LockProcessInBean> getLockProcessInBeanList() {
        return lockProcessInBean;
    }

    public void setLockProcessInBeanList(List<LockProcessInBean> pLockProcessInBean) {
        lockProcessInBean = pLockProcessInBean;
    }
}
