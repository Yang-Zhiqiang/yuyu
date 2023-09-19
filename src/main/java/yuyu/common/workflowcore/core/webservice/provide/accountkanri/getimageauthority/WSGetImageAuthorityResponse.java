package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.IWSGetTaskAuthInfoIOKey;

/**
 * イメージ権限削除サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetImageAuthorityResponse extends WSCommonResponse {

    private String[] sTorikomiSyoruiCd_;

    @JSONHint(name = IWSGetTaskAuthInfoIOKey.OUT.sS_AUTHIDSS)
    public String[] getTorikomiSyoruiCds() {
        return sTorikomiSyoruiCd_;
    }

    @JSONHint(name = IWSGetTaskAuthInfoIOKey.OUT.sS_AUTHIDSS)
    public void setTorikomiSyoruiCds(String[] psAuthids) {
        sTorikomiSyoruiCd_ = psAuthids;
    }
}
