package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * ダイレクトサービス ダイレクトサービス共通 契約基本情報Bean<br/>
 */
public class KeiyakuKihonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_AisyoumeiKbn aisyoumeiKbn;

    private String syouhnNm;

    private BizDate kykYmd;

    private C_Tuukasyu kykTuukasyu;

    private BizDate sakuseiKijyunYmd;

    private String yakkanBunsyoNo;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public C_AisyoumeiKbn getAisyoumeiKbn() {
        return aisyoumeiKbn;
    }

    public void setAisyoumeiKbn(C_AisyoumeiKbn pAisyoumeiKbn) {
        aisyoumeiKbn = pAisyoumeiKbn;
    }

    public String getSyouhnNm() {
        return syouhnNm;
    }

    public void setSyouhnNm(String pSyouhnNm) {
        syouhnNm = pSyouhnNm;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public BizDate getSakuseiKijyunYmd() {
        return sakuseiKijyunYmd;
    }

    public void setSakuseiKijyunYmd(BizDate pSakuseiKijyunYmd) {
        sakuseiKijyunYmd = pSakuseiKijyunYmd;
    }

    public String getYakkanBunsyoNo() {
        return yakkanBunsyoNo;
    }

    public void setYakkanBunsyoNo(String pYakkanBunsyoNo) {
        yakkanBunsyoNo = pYakkanBunsyoNo;
    }

}
