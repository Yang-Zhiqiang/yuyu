package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest;

/**
 * 工程情報更新サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessUpdateInBean extends WSExecProcessUpdateRequest {

    private List<Map<String, String>> extInfo_;

    public List<Map<String, String>> getExtInfo() {
        return extInfo_;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo_ = pExtInfo;
    }

    @Deprecated
    public void setExtinfo(String psExtInfo) {
    }

}
