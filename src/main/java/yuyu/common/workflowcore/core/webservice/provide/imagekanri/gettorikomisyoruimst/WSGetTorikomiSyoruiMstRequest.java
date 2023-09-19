package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 取込書類マスタ情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTorikomiSyoruiMstRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetTorikomiSyoruiMst";

    @FormParam(IWSGetTorikomiSyoruiMstIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @FormParam(IWSGetTorikomiSyoruiMstIOKey.IN.sS_SYZKDAIBUNRUIID)
    private String sSyzkdaibunruiid_;

    @FormParam(IWSGetTorikomiSyoruiMstIOKey.IN.sS_SYZKSYOUBUNRUIID)
    private String sSyzksyoubunruiid_;

    @FormParam(IWSGetTorikomiSyoruiMstIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTorikomiSyoruiMstIOKey.IN.sS_NODEID)
    private String sNodeid_;

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psTorikomisyoruicd) {
        sTorikomisyoruicd_ = psTorikomisyoruicd;
    }

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.IN.sS_SYZKDAIBUNRUIID)
    public String getSyzkdaibunruiid() {
        return sSyzkdaibunruiid_;
    }

    public void setSyzkdaibunruiid(String psSyzkdaibunruiid) {
        sSyzkdaibunruiid_ = psSyzkdaibunruiid;
    }

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.IN.sS_SYZKSYOUBUNRUIID)
    public String getSyzksyoubunruiid() {
        return sSyzksyoubunruiid_;
    }

    public void setSyzksyoubunruiid(String psSyzksyoubunruiid) {
        sSyzksyoubunruiid_ = psSyzksyoubunruiid;
    }

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.IN.sS_NODEID)
    public String getNodeid() {
        return sNodeid_;
    }

    public void setNodeid(String psNodeid) {
        sNodeid_ = psNodeid;
    }

}

