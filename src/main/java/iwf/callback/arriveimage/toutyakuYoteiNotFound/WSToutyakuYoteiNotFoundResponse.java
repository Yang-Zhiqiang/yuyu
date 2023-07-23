package iwf.callback.arriveimage.toutyakuYoteiNotFound;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 到着予定未存在時処理のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSToutyakuYoteiNotFoundResponse extends WSCommonResponse {

    private String oToutyakuKey_;

    private String oAppKey_;

    private String oSyoruicd_;

    private String oFlowid_;

    private String oSubsystemid_;

    private String sCberrmsg_;

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_SYORUICD)
    public String getToutyakuKey() {
        return oToutyakuKey_;
    }

    public void setToutyakuKey(String poToutyakuKey) {
        oToutyakuKey_ = poToutyakuKey;
    }

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_APPKEY)
    public String getAppKey() {
        return oAppKey_;
    }

    public void setAppKey(String poAppKey) {
        oAppKey_ = poAppKey;
    }

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_SYORUICD)
    public String getSyoruicd() {
        return oSyoruicd_;
    }

    public void setSyoruicd(String poSyoruicd) {
        oSyoruicd_ = poSyoruicd;
    }

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_FLOWID)
    public String getFlowid() {
        return oFlowid_;
    }

    public void setFlowid(String poFlowid) {
        oFlowid_ = poFlowid;
    }

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_SUBSYSTEMID)
    public String getSubsystemid() {
        return oSubsystemid_;
    }

    public void setSubsystemid(String poSubsystemid) {
        oSubsystemid_ = poSubsystemid;
    }

    @JSONHint(name = IWSToutyakuYoteiNotFoundIOKey.OUT.sO_CBERRMSG)
    public String getCberrmsg() {
        return sCberrmsg_;
    }

    public void setCberrmsg(String poCberrmsg) {
        this.sCberrmsg_ = poCberrmsg;
    }
}
