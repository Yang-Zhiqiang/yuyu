package yuyu.common.biz.workflow.io.image;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;

/**
 * イメージ登録領域削除サービスの入力Bean
 */
@SuppressWarnings("serial")
public class DeleteImageSpaceInBean extends WSExecProcessCancelRequest {

    private List<Map<String, String>> extInfo_;

    public List<Map<String, String>> getExtInfo() {
        return extInfo_;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo_ = pExtInfo;
    }

    @Override
    @Deprecated
    public void setExtinfo(String psExtInfo) {
    }

    @Override
    @Deprecated
    public void setFlowid(String psFlowId) {
    }
}
