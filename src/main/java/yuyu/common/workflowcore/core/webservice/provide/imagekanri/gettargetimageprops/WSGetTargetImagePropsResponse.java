package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 対象イメージプロパティ取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTargetImagePropsResponse extends WSCommonResponse {

    private ArrayList<ImagePropsBean> oImagepropslist_;

    @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sO_IMAGEPROPSLIST)
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

        private String sTourokutime_;

        private String sSyoruitoutyakutime_;

        private String sKouteijyoutai_;

        private String sKengenumu_;

        private String sTourokuaccountid_;

        private String sPagecount_;


        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_IMAGEID)
        public String getImageid() {
            return sImageid_;
        }

        public void setImageid(String psImageid) {
            sImageid_ = psImageid;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_GYOUMUKEY)
        public String getGyoumukey() {
            return sGyoumukey_;
        }

        public void setGyoumukey(String psGyoumukey) {
            sGyoumukey_ = psGyoumukey;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_TORIKOMISYORUICD)
        public String getTorikomisyoruicd() {
            return sTorikomisyoruicd_;
        }

        public void setTorikomisyoruicd(String psTorikomisyoruicd) {
            sTorikomisyoruicd_ = psTorikomisyoruicd;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_TOUROKUTIME)
        public String getTourokutime() {
            return sTourokutime_;
        }

        public void setTourokutime(String psTourokutime) {
            sTourokutime_ = psTourokutime;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_SYORUITOUTYAKUTIME)
        public String getSyoruitoutyakutime() {
            return sSyoruitoutyakutime_;
        }

        public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
            sSyoruitoutyakutime_ = psSyoruitoutyakutime;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_KOUTEIJYOUTAI)
        public String getKouteijyoutai() {
            return sKouteijyoutai_;
        }

        public void setKouteijyoutai(String psKouteijyoutai) {
            sKouteijyoutai_ = psKouteijyoutai;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_KENGENUMU)
        public String getKengenumu() {
            return sKengenumu_;
        }

        public void setKengenumu(String psKengenumu) {
            sKengenumu_ = psKengenumu;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_TOUROKUACCOUNTID)
        public String getTourokuaccountid() {
            return sTourokuaccountid_;
        }

        public void setTourokuaccountid(String psTourokuaccountid) {
            sTourokuaccountid_ = psTourokuaccountid;
        }

        @JSONHint(name=IWSGetTargetImagePropsIOKey.OUT.sS_PAGECOUNT)
        public String getPagecount() {
            return sPagecount_;
        }

        public void setPagecount(String psPagecount) {
            sPagecount_ = psPagecount;
        }
    }

}
