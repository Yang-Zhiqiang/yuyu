package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch;

import java.util.List;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程情報更新（バッチ用）サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSExecProcessUpdateForBatchRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "ExecProcessUpdateForBatch";

    @FormParam(IWSExecProcessUpdateForBatchIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKCONFIRMKBN)
    private String lockConfirmKbn;

    private List<ProcessUpdateBeanForBatch> processUpdateBeanForBatchList;

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKCONFIRMKBN)
    public String getLockConfirmKbn() {
        return lockConfirmKbn;
    }

    public void setLockConfirmKbn(String pLockConfirmKbn) {
        this.lockConfirmKbn = pLockConfirmKbn;
    }

    public List<ProcessUpdateBeanForBatch> getProcessUpdateBeanForBatchList() {
        return processUpdateBeanForBatchList;
    }

    public void setProcessUpdateBeanForBatchList(List<ProcessUpdateBeanForBatch> pProcessUpdateBeanForBatchList) {
        processUpdateBeanForBatchList = pProcessUpdateBeanForBatchList;
    }
}
