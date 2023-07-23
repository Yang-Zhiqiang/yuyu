package iwf.callback.arriveimage.imageTerminator;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * イメージ到着後処理のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSImageTerminatorRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "ImageTerminator";

    @FormParam(IWSImageteminatorIOKey.IN.sS_TOUTYAKUKEY)
    private String sToutyakuKey_;

    @FormParam(IWSImageteminatorIOKey.IN.sS_APPKEY)
    private String sAppKey_;

    @FormParam(IWSImageteminatorIOKey.IN.sS_SYORUICD)
    private String sSyoruicd_;

    @FormParam(IWSImageteminatorIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSImageteminatorIOKey.IN.sS_SUBSYSTEMID)
    private String sSubsystemid_;

    @FormParam(IWSImageteminatorIOKey.IN.sS_IMAGEID)
    private String sImageid_;

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_TOUTYAKUKEY)
    public String getToutyakuKey() {
        return sToutyakuKey_;
    }

    public void setToutyakuKey(String psToutyakuKey) {
        sToutyakuKey_ = psToutyakuKey;
    }

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_APPKEY)
    public String getAppKey() {
        return sAppKey_;
    }

    public void setAppKey(String psAppKey) {
        sAppKey_ = psAppKey;
    }

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_SYORUICD)
    public String getSyoruicd() {
        return sSyoruicd_;
    }

    public void setSyoruicd(String psSyoruicd) {
        sSyoruicd_ = psSyoruicd;
    }

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_SUBSYSTEMID)
    public String getSubsystemid() {
        return sSubsystemid_;
    }

    public void setSubsystemid(String psSubsystemid) {
        sSubsystemid_ = psSubsystemid;
    }

    @JSONHint(name = IWSImageteminatorIOKey.IN.sS_IMAGEID)
    public String getImageid() {
        return sImageid_;
    }

    public void setImageid(String psImageid) {
        sImageid_ = psImageid;
    }
}
