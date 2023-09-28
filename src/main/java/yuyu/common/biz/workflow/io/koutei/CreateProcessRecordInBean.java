package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest;

/**
 * 工程履歴作成サービスの入力Bean
 */
@SuppressWarnings("serial")
public class CreateProcessRecordInBean extends WSCreateProcessRecordRequest {

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

}
