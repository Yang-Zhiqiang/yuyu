package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 振替伝票仕訳明細情報クラス。<br />
 */
public class FurikaeDenpyouSiwakeMeisai {

    private String denKanjoKamokuCd;

    private String denKanjoKamokuNm;

    private String suitouBumonCd;

    private String tekiyouCd;

    private BizCurrency kinGk;

    private String tekiyouKm;

    private String kjTekiyouKm;

    public FurikaeDenpyouSiwakeMeisai () {

    }

    public String getDenKanjoKamokuCd() {
        return denKanjoKamokuCd;
    }
    public void setDenKanjoKamokuCd(String pDenKanjoKamokuCd) {
        denKanjoKamokuCd = pDenKanjoKamokuCd;
    }
    public String getDenKanjoKamokuNm() {
        return denKanjoKamokuNm;
    }
    public void setDenKanjoKamokuNm(String pDenKanjoKamokuNm) {
        denKanjoKamokuNm = pDenKanjoKamokuNm;
    }
    public String getSuitouBumonCd() {
        return suitouBumonCd;
    }
    public void setSuitouBumonCd(String pSuitouBumonCd) {
        suitouBumonCd = pSuitouBumonCd;
    }
    public String getTekiyouCd() {
        return tekiyouCd;
    }
    public void setTekiyouCd(String pTekiyouCd) {
        tekiyouCd = pTekiyouCd;
    }
    public BizCurrency getKinGk() {
        return kinGk;
    }
    public void setKinGk(BizCurrency pKinGk) {
        kinGk = pKinGk;
    }
    public String getTekiyouKm() {
        return tekiyouKm;
    }
    public void setTekiyouKm(String pTekiyouKm) {
        tekiyouKm = pTekiyouKm;
    }
    public String getKjTekiyouKm() {
        return kjTekiyouKm;
    }
    public void setKjTekiyouKm(String pkjTekiyouKm) {
        kjTekiyouKm = pkjTekiyouKm;
    }
}
