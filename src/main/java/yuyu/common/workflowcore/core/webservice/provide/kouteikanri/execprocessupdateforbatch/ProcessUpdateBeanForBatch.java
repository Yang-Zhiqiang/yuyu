package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程情報更新（バッチ用）サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessUpdateBeanForBatch extends WSCommonRequest {

    private String gyoumuKey;

    private String flowId;

    private String lockKey;

    private String extInfo;

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return gyoumuKey;
    }

    public void setGyoumukey(String psGyoumukey) {
        this.gyoumuKey = psGyoumukey;
    }

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return flowId;
    }

    public void setFlowid(String pFlowId) {
        this.flowId = pFlowId;
    }

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return lockKey;
    }

    public void setLockkey(String pLockkey) {
        this.lockKey = pLockkey;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String pExtInfo) {
        extInfo = pExtInfo;
    }
}
