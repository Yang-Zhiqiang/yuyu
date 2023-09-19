package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo;

import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetProcessInfoResponse extends WSCommonResponse {



    private ArrayList<String> oNodenames_;

    private ArrayList<String[]> oWaritategroupids_;

    private ArrayList<String> oWariateuserid_;

    @JSONHint(name=IWSGetProcessInfoIOKey.OUT.sO_NODENAMES)
    public ArrayList<String> getNodenames() {
        return oNodenames_;
    }

    public void setNodenames(ArrayList<String> poNodenames) {
        oNodenames_ = poNodenames;
    }

    @JSONHint(name=IWSGetProcessInfoIOKey.OUT.sO_WARITATEGROUPIDS)
    public ArrayList<String[]> getWaritategroupids() {
        return oWaritategroupids_;
    }

    public void setWaritategroupids(ArrayList<String[]> poWaritategroupids) {
        oWaritategroupids_ = poWaritategroupids;
    }

    @JSONHint(name=IWSGetProcessInfoIOKey.OUT.sO_WARIATEUSERID)
    public ArrayList<String> getWariateuserid() {
        return oWariateuserid_;
    }

    public void setWariateuserid(ArrayList<String> poWariateuserid) {
        oWariateuserid_ = poWariateuserid;
    }

}
