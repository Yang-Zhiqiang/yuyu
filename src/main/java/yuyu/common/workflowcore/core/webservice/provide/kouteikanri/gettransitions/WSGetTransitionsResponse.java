package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 分岐先取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTransitionsResponse extends WSCommonResponse {

    private String[] sDestnodes_;

    @JSONHint(name=IWSGetTransitionsIOKey.OUT.sS_DESTNODESS)
    public String[] getDestnodes() {
        return sDestnodes_;
    }

    public void setDestnodes(String[] psDestnodes) {
        sDestnodes_ = psDestnodes;
    }

}
