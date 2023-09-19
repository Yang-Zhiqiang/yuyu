package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 対象イメージ取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTargetImagesRequest extends WSCommonRequest {


    public static final String sSERVICE_NAME= "GetTargetImages";

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_SYORUITOUTYAKUYMDFROM)
    private String sSyoruitoutyakuymdfrom_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_SYORUITOUTYAKUYMDTO)
    private String sSyoruitoutyakuymdto_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_SYZKDAIBUNRUIID)
    private String sSyzkdaibunruiid_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_SYZKSYOUBUNRUIID)
    private String sSyzksyoubunruiid_;

    @FormParam(IWSGetTargetImagesIOKey.IN.sS_KOUTEIJYOUTAI)
    private String sKouteijyoutai_;

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psTorikomisyoruicd) {
        sTorikomisyoruicd_ = psTorikomisyoruicd;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_SYORUITOUTYAKUYMDFROM)
    public String getSyoruitoutyakuymdfrom() {
        return sSyoruitoutyakuymdfrom_;
    }

    public void setSyoruitoutyakuymdfrom(String psSyoruitoutyakuymdfrom) {
        sSyoruitoutyakuymdfrom_ = psSyoruitoutyakuymdfrom;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_SYORUITOUTYAKUYMDTO)
    public String getSyoruitoutyakuymdto() {
        return sSyoruitoutyakuymdto_;
    }

    public void setSyoruitoutyakuymdto(String psSyoruitoutyakuymdto) {
        sSyoruitoutyakuymdto_ = psSyoruitoutyakuymdto;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_SYZKDAIBUNRUIID)
    public String getSyzkdaibunruiid() {
        return sSyzkdaibunruiid_;
    }

    public void setSyzkdaibunruiid(String psSyzkdaibunruiid) {
        sSyzkdaibunruiid_ = psSyzkdaibunruiid;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_SYZKSYOUBUNRUIID)
    public String getSyzksyoubunruiid() {
        return sSyzksyoubunruiid_;
    }

    public void setSyzksyoubunruiid(String psSyzksyoubunruiid) {
        sSyzksyoubunruiid_ = psSyzksyoubunruiid;
    }

    @JSONHint(name=IWSGetTargetImagesIOKey.IN.sS_KOUTEIJYOUTAI)
    public String getKouteijyoutai() {
        return sKouteijyoutai_;
    }

    public void setKouteijyoutai(String psKouteijyoutai) {
        sKouteijyoutai_ = psKouteijyoutai;
    }

}
