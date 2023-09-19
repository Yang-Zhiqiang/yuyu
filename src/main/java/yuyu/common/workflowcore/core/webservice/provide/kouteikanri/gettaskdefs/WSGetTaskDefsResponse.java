package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs;

import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * タスク定義取得のOutBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskDefsResponse extends WSCommonResponse {

    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String, String>[] oTaskdefs_;

    @JSONHint(name=IWSGetTaskDefsIOKey.OUT.sO_TASKDEFS)
    public Map<String, String>[] getTaskdefs() {
        return oTaskdefs_;
    }

    public void setTaskdefs(Map<String, String>[] poTaskdefs) {
        oTaskdefs_ = poTaskdefs;
    }

}
