package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;

/**
 * 工程ロック情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class LockInfoBean implements Serializable {

    private String gyoumukey_;

    private String flowId_;

    private String nodeName_;

    private String accountId_;

    private String lockKey_;

    private String lockTime_;


    public String getGyoumukey() {
        return gyoumukey_;
    }

    public void setGyoumukey(String pGyoumukey) {
        gyoumukey_ = pGyoumukey;
    }

    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        flowId_ = pFlowId;
    }

    public String getNodeName() {
        return nodeName_;
    }

    public void setNodeName(String pNodeName) {
        nodeName_ = pNodeName;
    }

    public String getAccountId() {
        return accountId_;
    }

    public void setAccountId(String pAccountId) {
        accountId_ = pAccountId;
    }

    public String getLockKey() {
        return lockKey_;
    }

    public void setLockKey(String pLockKey) {
        lockKey_ = pLockKey;
    }

    public String getLockTime() {
        return lockTime_;
    }

    public void setLockTime(String pLockTime) {
        lockTime_ = pLockTime;
    }

}
