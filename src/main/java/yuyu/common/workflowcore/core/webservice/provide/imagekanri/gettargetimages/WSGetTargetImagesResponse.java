package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 対象イメージ取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTargetImagesResponse extends WSCommonResponse {

    private ArrayList<ImageInfoBean> oImageinfolist_;

    @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sO_IMAGEINFOLIST)
    public ArrayList<ImageInfoBean> getImageinfolist() {
        return oImageinfolist_;
    }

    public void setImageinfolist(ArrayList<ImageInfoBean> poImageinfolist) {
        oImageinfolist_ = poImageinfolist;
    }

    public static class ImageInfoBean implements Serializable {

        private String sImageid_;

        private String sGyoumukey_;

        private String sTorikomisyoruicd_;

        private String sSyoruitoutyakutime_;

        private String sKouteijyoutai_;

        private String sKengenumu_;

        private byte[] opdfimage_;

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_IMAGEID)
        public String getImageid() {
            return sImageid_;
        }

        public void setImageid(String psImageid) {
            sImageid_ = psImageid;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_GYOUMUKEY)
        public String getGyoumukey() {
            return sGyoumukey_;
        }

        public void setGyoumukey(String psGyoumukey) {
            sGyoumukey_ = psGyoumukey;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_TORIKOMISYORUICD)
        public String getTorikomisyoruicd() {
            return sTorikomisyoruicd_;
        }

        public void setTorikomisyoruicd(String psTorikomisyoruicd) {
            sTorikomisyoruicd_ = psTorikomisyoruicd;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_SYORUITOUTYAKUTIME)
        public String getSyoruitoutyakutime() {
            return sSyoruitoutyakutime_;
        }

        public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
            sSyoruitoutyakutime_ = psSyoruitoutyakutime;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_KOUTEIJYOUTAI)
        public String getKouteijyoutai() {
            return sKouteijyoutai_;
        }

        public void setKouteijyoutai(String psKouteijyoutai) {
            sKouteijyoutai_ = psKouteijyoutai;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sS_KENGENUMU)
        public String getKengenumu() {
            return sKengenumu_;
        }

        public void setKengenumu(String psKengenumu) {
            sKengenumu_ = psKengenumu;
        }

        @JSONHint(name=IWSGetTargetImagesIOKey.OUT.sO_PDFIMAGE)
        public byte[] getPdfimage() {
            return opdfimage_;
        }

        public void setPdfimage(byte[] poPDFimage) {
            opdfimage_ = poPDFimage;
        }
    }

}
