package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.IWSExecProcessUpdateForBatchIOKey;

/**
 * 工程情報更新（バッチ用）サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessUpdateForBatchInBean extends WSCommonRequest {

    @FormParam(IWSExecProcessUpdateForBatchIOKey.IN.sS_ACCOUNTID)
    private String accountid;

    @FormParam(IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKCONFIRMKBN)
    private String lockConfirmKbn;

    private List<ProcessUpdateForBatchBean> processUpdateForBatchBeanList;

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String pAccountid) {
        accountid = pAccountid;
    }

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKCONFIRMKBN)
    public String getLockConfirmKbn() {
        return lockConfirmKbn;
    }

    public void setLockConfirmKbn(String pLockConfirmKbn) {
        this.lockConfirmKbn = pLockConfirmKbn;
    }

    public List<ProcessUpdateForBatchBean> getProcessUpdateForBatchBeanList() {
        return processUpdateForBatchBeanList;
    }

    public void setProcessUpdateForBatchBeanList(List<ProcessUpdateForBatchBean> pProcessUpdateForBatchBeanList) {
        processUpdateForBatchBeanList = pProcessUpdateForBatchBeanList;
    }
}
