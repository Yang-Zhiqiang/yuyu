package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * イメージ登録サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSPutImageRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "PutImage";

    @FormParam(IWSPutImageIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSPutImageIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSPutImageIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSPutImageIOKey.IN.sS_SYORUICD)
    private String sSyoruicd_;

    @FormParam(IWSPutImageIOKey.IN.sS_SYORUITOUTYAKUTIME)
    private String sSyoruitoutyakutime_;

    @FormParam(IWSPutImageIOKey.IN.sS_TOUROKUTIME)
    private String sTourokutime_;

    @FormParam(IWSPutImageIOKey.IN.sS_IMAGEDATASTR)
    private String sImagedatastr_;

    @FormParam(IWSPutImageIOKey.IN.sS_EXT_INFO)
    private String sExtinfo_;

    @JSONHint(name=IWSPutImageIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_SYORUICD)
    public String getSyoruicd() {
        return sSyoruicd_;
    }

    public void setSyoruicd(String psSyoruicd) {
        sSyoruicd_ = psSyoruicd;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_SYORUITOUTYAKUTIME)
    public String getSyoruitoutyakutime() {
        return sSyoruitoutyakutime_;
    }

    public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
        sSyoruitoutyakutime_ = psSyoruitoutyakutime;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_TOUROKUTIME)
    public String getTourokutime() {
        return sTourokutime_;
    }

    public void setTourokutime(String psTourokutime) {
        sTourokutime_ = psTourokutime;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_IMAGEDATASTR)
    public String getImagedatastr() {
        return sImagedatastr_;
    }

    public void setImagedatastr(String psImagedatastr) {
        sImagedatastr_ = psImagedatastr;
    }

    @JSONHint(name=IWSPutImageIOKey.IN.sS_EXT_INFO)
    public String getExtinfo() {
        return sExtinfo_;
    }

    public void setExtinfo(String psExtinfo) {
        sExtinfo_ = psExtinfo;
    }

}
