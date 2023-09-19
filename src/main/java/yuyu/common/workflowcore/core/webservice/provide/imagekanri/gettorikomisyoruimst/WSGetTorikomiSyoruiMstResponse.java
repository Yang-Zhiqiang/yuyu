package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 取込書類マスタ情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetTorikomiSyoruiMstResponse extends WSCommonResponse {

    private ArrayList<TorikomiSyoruiBean> oTorikomisyoruilist_;

    @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sO_TORIKOMISYORUILIST)
    public ArrayList<TorikomiSyoruiBean> getTorikomisyoruilist() {
        return oTorikomisyoruilist_;
    }

    public void setTorikomisyoruilist(ArrayList<TorikomiSyoruiBean> poTorikomisyoruilist) {
        oTorikomisyoruilist_ = poTorikomisyoruilist;
    }

    public static class TorikomiSyoruiBean implements Serializable {

        private String sTorikomisyoruicd_;

        private String sTorikomisyoruinm_;

        private String sTorikomisyoruiryaku_;

        private String sSyzkdaibunruiid_;

        private String sSyzksyoubunruiid_;

        private String sZiphozonkbn_;

        private String sKouteiseigyoumukbn_;

        private String sFlowid_;

        private String sNodeid_;

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_TORIKOMISYORUICD)
        public String getTorikomisyoruicd() {
            return sTorikomisyoruicd_;
        }

        public void setTorikomisyoruicd(String psTorikomisyoruicd) {
            sTorikomisyoruicd_ = psTorikomisyoruicd;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_TORIKOMISYORUINM)
        public String getTorikomisyoruinm() {
            return sTorikomisyoruinm_;
        }

        public void setTorikomisyoruinm(String psTorikomisyoruinm) {
            sTorikomisyoruinm_ = psTorikomisyoruinm;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_TORIKOMISYORUIRYAKU)
        public String getTorikomisyoruiryaku() {
            return sTorikomisyoruiryaku_;
        }

        public void setTorikomisyoruiryaku(String psTorikomisyoruiryaku) {
            sTorikomisyoruiryaku_ = psTorikomisyoruiryaku;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_SYZKDAIBUNRUIID)
        public String getSyzkdaibunruiid() {
            return sSyzkdaibunruiid_;
        }

        public void setSyzkdaibunruiid(String psSyzkdaibunruiid) {
            sSyzkdaibunruiid_ = psSyzkdaibunruiid;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_SYZKSYOUBUNRUIID)
        public String getSyzksyoubunruiid() {
            return sSyzksyoubunruiid_;
        }

        public void setSyzksyoubunruiid(String psSyzksyoubunruiid) {
            sSyzksyoubunruiid_ = psSyzksyoubunruiid;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_ZIPHOZONKBN)
        public String getZiphozonkbn() {
            return sZiphozonkbn_;
        }

        public void setZiphozonkbn(String psZiphozonkbn) {
            sZiphozonkbn_ = psZiphozonkbn;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_KOUTEISEIGYOUMUKBN)
        public String getKouteiseigyoumukbn() {
            return sKouteiseigyoumukbn_;
        }

        public void setKouteiseigyoumukbn(String psKouteiseigyoumukbn) {
            sKouteiseigyoumukbn_ = psKouteiseigyoumukbn;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_FLOWID)
        public String getFlowid() {
            return sFlowid_;
        }

        public void setFlowid(String psFlowid) {
            sFlowid_ = psFlowid;
        }

        @JSONHint(name=IWSGetTorikomiSyoruiMstIOKey.OUT.sS_NODEID)
        public String getNodeid() {
            return sNodeid_;
        }

        public void setNodeid(String psNodeid) {
            sNodeid_ = psNodeid;
        }
    }

}
