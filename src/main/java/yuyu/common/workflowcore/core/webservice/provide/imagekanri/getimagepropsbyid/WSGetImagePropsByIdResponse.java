package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * ID指定イメージプロパティサービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetImagePropsByIdResponse extends WSCommonResponse {

    private ArrayList<ImagePropsBean> oImagepropslist_;

    @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sO_IMAGEPROPSLIST)
    public ArrayList<ImagePropsBean> getImagepropslist() {
        return oImagepropslist_;
    }

    public void setImagepropslist(ArrayList<ImagePropsBean> poImagepropslist) {
        oImagepropslist_ = poImagepropslist;
    }

    public static class ImagePropsBean implements Serializable {

        private String sImageid_;

        private String sGyoumukey_;

        private String sTorikomisyoruicd_;

        private String sSyoruitoutyakutime_;

        private String sKouteijyoutai_;

        private String sKengenumu_;

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_IMAGEID)
        public String getImageid() {
            return sImageid_;
        }

        public void setImageid(String psImageid) {
            sImageid_ = psImageid;
        }

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_GYOUMUKEY)
        public String getGyoumukey() {
            return sGyoumukey_;
        }

        public void setGyoumukey(String psGyoumukey) {
            sGyoumukey_ = psGyoumukey;
        }

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_TORIKOMISYORUICD)
        public String getTorikomisyoruicd() {
            return sTorikomisyoruicd_;
        }

        public void setTorikomisyoruicd(String psTorikomisyoruicd) {
            sTorikomisyoruicd_ = psTorikomisyoruicd;
        }

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_SYORUITOUTYAKUTIME)
        public String getSyoruitoutyakutime() {
            return sSyoruitoutyakutime_;
        }

        public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
            sSyoruitoutyakutime_ = psSyoruitoutyakutime;
        }

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_KOUTEIJYOUTAI)
        public String getKouteijyoutai() {
            return sKouteijyoutai_;
        }

        public void setKouteijyoutai(String psKouteijyoutai) {
            sKouteijyoutai_ = psKouteijyoutai;
        }

        @JSONHint(name=IWSGetImagePropsByIdIOKey.OUT.sS_KENGENUMU)
        public String getKengenumu() {
            return sKengenumu_;
        }

        public void setKengenumu(String psKengenumu) {
            sKengenumu_ = psKengenumu;
        }
    }

}
