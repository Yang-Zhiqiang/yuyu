package yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程履歴・JBPMデータ削除サービスの入力Bean
 */
@SuppressWarnings("serial")
public class DeleteProcessAndJBPMRecordBean extends WSCommonRequest {

    @FormParam(IWSDeleteProcessAndJBPMRecordIOKey.IN.sS_FLOWID)
    private String flowId;

    @FormParam(IWSDeleteProcessAndJBPMRecordIOKey.IN.sS_GYOUMUKEY)
    private String gyoumuKey;

    @JSONHint(name=IWSDeleteProcessAndJBPMRecordIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return gyoumuKey;
    }

    public void setGyoumukey(String psGyoumukey) {
        this.gyoumuKey = psGyoumukey;
    }

    @JSONHint(name=IWSDeleteProcessAndJBPMRecordIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return flowId;
    }

    public void setFlowid(String pFlowId) {
        this.flowId = pFlowId;
    }
}
