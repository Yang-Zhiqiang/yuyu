package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * ID指定イメージ取得削除サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetImageByIdResponse extends WSCommonResponse {

    private ArrayList<ImageInfoBean> oImageinfolist_;

    @JSONHint(name=IWSGetImageByIdIOKey.OUT.sO_IMAGEINFOLIST)
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

        private String sKengenumu_;

        private byte[] opdfimage_;

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sS_IMAGEID)
        public String getImageid() {
            return sImageid_;
        }

        public void setImageid(String psImageid) {
            sImageid_ = psImageid;
        }

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sS_GYOUMUKEY)
        public String getGyoumukey() {
            return sGyoumukey_;
        }

        public void setGyoumukey(String psGyoumukey) {
            sGyoumukey_ = psGyoumukey;
        }

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sS_TORIKOMISYORUICD)
        public String getTorikomisyoruicd() {
            return sTorikomisyoruicd_;
        }

        public void setTorikomisyoruicd(String psTorikomisyoruicd) {
            sTorikomisyoruicd_ = psTorikomisyoruicd;
        }

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sS_SYORUITOUTYAKUTIME)
        public String getSyoruitoutyakutime() {
            return sSyoruitoutyakutime_;
        }

        public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
            sSyoruitoutyakutime_ = psSyoruitoutyakutime;
        }

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sS_KENGENUMU)
        public String getKengenumu() {
            return sKengenumu_;
        }

        public void setKengenumu(String psKengenumu) {
            sKengenumu_ = psKengenumu;
        }

        @JSONHint(name=IWSGetImageByIdIOKey.OUT.sO_PDFIMAGE)
        public byte[] getPdfimage() {
            return opdfimage_;
        }

        public void setPdfimage(byte[] poPDFimage) {
            opdfimage_ = poPDFimage;
        }
    }

}
