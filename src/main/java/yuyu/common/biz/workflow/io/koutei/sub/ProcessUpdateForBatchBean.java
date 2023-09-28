package yuyu.common.biz.workflow.io.koutei.sub;

import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.IWSExecProcessUpdateForBatchIOKey;

/**
 * 工程情報更新（バッチ用）サービスのBean
 */
@SuppressWarnings("serial")
public class ProcessUpdateForBatchBean extends WSCommonRequest {

    private String gyoumuKey;

    private String flowId;

    private String lockKey;

    private List<Map<String, String>> extInfo;

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

    public List<Map<String, String>> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo = pExtInfo;
    }

    @JSONHint(name=IWSExecProcessUpdateForBatchIOKey.IN.sS_LOCKKEY)
    public String getLockkey() {
        return lockKey;
    }

    public void setLockkey(String pLockkey) {
        this.lockKey = pLockkey;
    }
}