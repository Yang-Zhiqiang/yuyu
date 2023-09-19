package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 到着イメージ登録サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSPutArrivalImageRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "PutArrivalImage";


    @FormParam(IWSPutArrivalImageIOKey.IN.sS_ARRIVEKEY)
    private String sArrivekey_;

    @FormParam(IWSPutArrivalImageIOKey.IN.sS_IMAGEDATASTR)
    private String sImagedatastr_;


    @JSONHint(name=IWSPutArrivalImageIOKey.IN.sS_ARRIVEKEY)
    public String getArrivekey() {
        return sArrivekey_;
    }

    public void setArrivekey(String psArrivekey) {
        sArrivekey_ = psArrivekey;
    }

    @JSONHint(name=IWSPutArrivalImageIOKey.IN.sS_IMAGEDATASTR)
    public String getImagedatastr() {
        return sImagedatastr_;
    }

    public void setImagedatastr(String psImagedatastr) {
        sImagedatastr_ = psImagedatastr;
    }
}
