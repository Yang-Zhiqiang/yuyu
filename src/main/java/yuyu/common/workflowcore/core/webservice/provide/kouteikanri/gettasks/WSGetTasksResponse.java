package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * タスク一覧取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTasksResponse extends WSCommonResponse {

    private String[] sGyoumukeys_;


    @JSONHint(name=IWSGetTasksIOKey.OUT.sS_GYOUMUKEYSS)
    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    @JSONHint(name=IWSGetTasksIOKey.OUT.sS_GYOUMUKEYSS)
    public void setGyoumukeys(String[] psGyoumukeys) {
        sGyoumukeys_ = psGyoumukeys;
    }

}
