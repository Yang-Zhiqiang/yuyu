package yuyu.batch.biz.bzkaikei.bzhojyobolisttblsks;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Kanjyoukmkcd;


/**
 * 帳票出力先無し情報BEANクラスです。<br />
 */
public class TyouhyouOutNasiInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private String hjybTantosituCd;

    public String getHjybTantosituCd() {
        return hjybTantosituCd;
    }

    public void setHjybTantosituCd(String pHjybTantosituCd) {
        hjybTantosituCd = pHjybTantosituCd;
    }

    private C_Kanjyoukmkcd kanjyoukmkCd;

    public C_Kanjyoukmkcd getKanjyoukmkCd() {
        return kanjyoukmkCd;
    }

    public void setKanjyoukmkCd(C_Kanjyoukmkcd pKanjyoukmkCd) {
        kanjyoukmkCd = pKanjyoukmkCd;
    }

    private String busituCd;

    public String getBusituCd() {
        return busituCd;
    }

    public void setBusituCd(String pBusituCd) {
        busituCd = pBusituCd;
    }

    private BizDate denYmd;

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    private BizCurrency karikataGk;

    public BizCurrency getKarikataGk() {
        return karikataGk;
    }

    public void setKarikataGk(BizCurrency pKarikataGk) {
        karikataGk = pKarikataGk;
    }

    private BizCurrency kasikataGk;

    public BizCurrency getKasikataGk() {
        return kasikataGk;
    }

    public void setKasikataGk(BizCurrency pKasikataGk) {
        kasikataGk = pKasikataGk;
    }

    private String syoricd;

    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String huridenatesakicd;

    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }
}
