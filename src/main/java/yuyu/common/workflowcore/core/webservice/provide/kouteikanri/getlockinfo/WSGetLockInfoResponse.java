package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo;

import java.util.Map;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDecodeType;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfNeedsDecode;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 工程ロック情報取得のレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetLockInfoResponse extends WSCommonResponse {

    @IwfNeedsDecode(IwfDecodeType.BASE64)
    private Map<String,String>[] oLockInfoMaps_;

    public WSGetLockInfoResponse() {
    }

    @JSONHint(name=IWSGetLockInfoIOKey.OUT.sO_LOCKINFOMAPS)
    public Map<String,String>[] getLockInfomaps() {
        return oLockInfoMaps_;
    }

    public void setLockInfomaps(Map<String,String>[] poLockInfomaps) {
        oLockInfoMaps_ = poLockInfomaps;
    }

}
