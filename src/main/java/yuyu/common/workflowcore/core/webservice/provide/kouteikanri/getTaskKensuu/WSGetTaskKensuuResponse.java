package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu;


import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * タスク件数照会サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskKensuuResponse extends WSCommonResponse {


    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String,String>[] taskSummaryMaps_;

    @JSONHint(name=IWSGetTaskKensuuIOKey.OUT.sO_TASKSUMMARYMAPS)
    public Map<String,String>[] getTaskSummaryMaps() {
        return taskSummaryMaps_;
    }

    public void setTaskSummaryMaps(Map<String,String>[] summaryMaps) {
        taskSummaryMaps_ = summaryMaps;
    }

}
