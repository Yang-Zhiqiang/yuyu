package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoResponse;

/**
 * 工程ロック情報取得サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetLockInfoOutBean extends WSGetLockInfoResponse {

    private List<LockInfoBean> oLockInfoBeanList;

    public List<LockInfoBean> getLockInfoBeanList() {
        return oLockInfoBeanList;
    }

    public void setLockInfoBeanList(List<LockInfoBean> poLockInfoBeanList) {
        oLockInfoBeanList = poLockInfoBeanList;
    }
}
