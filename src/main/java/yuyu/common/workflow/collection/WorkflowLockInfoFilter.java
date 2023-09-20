package yuyu.common.workflow.collection;

import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;

import com.google.common.base.Predicate;

/**
 * イメージワークフロー工程ロック情報抽出処理です。<br/>
 */
public class WorkflowLockInfoFilter implements Predicate<LockInfoBean> {

    private String targetGyoumuKey = null;

    public void setTargetGyoumuKey(String pGyoumuKey) {
        targetGyoumuKey = pGyoumuKey;
    }
    public String getTargetGyoumuKey() {
        return targetGyoumuKey;
    }

    @Override
    public boolean apply(LockInfoBean lockInfo) {
        if (targetGyoumuKey.equals(lockInfo.getGyoumukey())) {
            return true;
        }
        return false;
    }
}
