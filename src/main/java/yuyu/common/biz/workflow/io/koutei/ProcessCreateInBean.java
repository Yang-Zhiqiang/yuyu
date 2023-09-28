package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;

/**
 * 工程作成サービスの入力Bean
 */
@SuppressWarnings("serial")
public class ProcessCreateInBean extends WSExecProcessCreateRequest {

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
