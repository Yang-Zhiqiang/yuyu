package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses;

import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * タスク内工程情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTaskProcessesResponse extends WSCommonResponse {

    private ArrayList<String> oGyoumukeys_;

    @JSONHint(name=IWSGetTaskProcessesIOKey.OUT.sO_GYOUMUKEYS)
    public ArrayList<String> getGyoumukeys() {
        return oGyoumukeys_;
    }

    public void setGyoumukeys(ArrayList<String> poGyoumukeys) {
        oGyoumukeys_ = poGyoumukeys;
    }

}
