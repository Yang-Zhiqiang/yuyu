package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HuridenYouHassouKbn;

/**
 * 振替伝票ページ情報クラス。<br />
 */
public class FurikaeDenpyouPage {

    private String systemKbn;

    private String torihikiNo;

    private int pageNo;

    private String torihikiYmdGengoKbn;

    private int torihikiNen;

    private int torihikiTsuki;

    private int torihikiBi;

    private String kjTantoukaNm;

    private String kjTantoukaCd;

    private String kjSystemNm;

    private BizCurrency kasiKurikosiGk;

    private BizCurrency kariKurikosiGk;

    private String[] kjKasiKanjoukamokuNms;

    private String[] kjKariKanjoukamokuNms;

    private BizCurrency[] kasiGks;

    private BizCurrency[] kariGks;

    private String[] kasiTekiyouKms;

    private String[] kariTekiyouKms;

    private String[] kjKasiTekiyouKms;

    private String[] kjKariTekiyouKms;

    private BizCurrency kasiGoukeiGk;

    private BizCurrency kariGoukeiGk;

    private String kjKariKurikosiGkHyjKm;

    private String kjKasiKurikosiGkHyjKm;

    private C_HuridenYouHassouKbn huridenYouHassouKbn;

    private boolean goukeiFlg;

    public FurikaeDenpyouPage() {

    }

    public String getSystemKbn() {
        return systemKbn;
    }

    public void setSystemkbn(String pSystemKbn) {
        systemKbn = pSystemKbn;
    }

    public String getTorihikiNo() {
        return torihikiNo;
    }

    public void setTorihikiNo(String pTorihikiNo) {
        torihikiNo = pTorihikiNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pPageNo) {
        pageNo = pPageNo;
    }

    public String getTorihikiYmdGengoKbn() {
        return torihikiYmdGengoKbn;
    }

    public void setTorihikiYmdGengoKbn(String pTorihikiYmdGengoKbn) {
        torihikiYmdGengoKbn = pTorihikiYmdGengoKbn;
    }

    public int getTorihikiNen() {
        return torihikiNen;
    }

    public void setTorihikiNen(int pTorihikiNen) {
        torihikiNen = pTorihikiNen;
    }

    public int getTorihikiTsuki() {
        return torihikiTsuki;
    }

    public void setTorihikiTsuki(int pTorihikiTsuki) {
        torihikiTsuki = pTorihikiTsuki;
    }

    public int getTorihikiBi() {
        return torihikiBi;
    }

    public void setTorihikiBi(int pTorihikiBi) {
        torihikiBi = pTorihikiBi;
    }

    public String getKjTantoukaNm() {
        return kjTantoukaNm;
    }

    public void setKjTantoukaNm(String pKjTantoukaNm) {
        kjTantoukaNm = pKjTantoukaNm;
    }

    public String getKjTantoukaCd() {
        return kjTantoukaCd;
    }

    public void setKjTantoukaCd(String pKjTantoukaCd) {
        kjTantoukaCd = pKjTantoukaCd;
    }

    public String getKjSystemNm() {
        return kjSystemNm;
    }

    public void setKjSystemNm(String pKjSystemNm) {
        kjSystemNm = pKjSystemNm;
    }

    public BizCurrency getKasiKurikosiGk() {
        return kasiKurikosiGk;
    }

    public void setKasiKurikosiGk(BizCurrency pKasiKurikosiGk) {
        kasiKurikosiGk = pKasiKurikosiGk;
    }

    public BizCurrency getKariKurikosiGk() {
        return kariKurikosiGk;
    }

    public void setKariKurikosiGk(BizCurrency pKariKurikosiGk) {
        kariKurikosiGk = pKariKurikosiGk;
    }

    public String[] getKjKasiKanjoukamokuNms() {
        return kjKasiKanjoukamokuNms;
    }

    public void setKjKasiKanjoukamokuNms(String[] pKjKasiKanjoukamokuNms) {
        kjKasiKanjoukamokuNms = pKjKasiKanjoukamokuNms;
    }

    public String[] getKjKariKanjoukamokuNms() {
        return kjKariKanjoukamokuNms;
    }

    public void setKjKariKanjoukamokuNms(String[] pKjKariKanjoukamokuNms) {
        kjKariKanjoukamokuNms = pKjKariKanjoukamokuNms;
    }

    public BizCurrency[] getKasiGks() {
        return kasiGks;
    }

    public void setKasiGks(BizCurrency[] pKasiGks) {
        kasiGks = pKasiGks;
    }

    public BizCurrency[] getKariGks() {
        return kariGks;
    }

    public void setKariGks(BizCurrency[] pKariGks) {
        kariGks = pKariGks;
    }

    public String[] getKasiTekiyouKms() {
        return kasiTekiyouKms;
    }

    public void setKasiTekiyouKms(String[] pKasiTekiyouKms) {
        kasiTekiyouKms = pKasiTekiyouKms;
    }

    public String[] getKariTekiyouKms() {
        return kariTekiyouKms;
    }

    public void setKaritekiyouKms(String[] pKariTekiyouKms) {
        kariTekiyouKms = pKariTekiyouKms;
    }

    public String[] getKjKasiTekiyouKms() {
        return kjKasiTekiyouKms;
    }

    public void setKjKasiTekiyouKms(String[] pKjKasiTekiyouKms) {
        kjKasiTekiyouKms = pKjKasiTekiyouKms;
    }

    public String[] getKjKariTekiyouKms() {
        return kjKariTekiyouKms;
    }

    public void setKjKariTekiyouKms(String[] pKjKariTekiyouKms) {
        kjKariTekiyouKms = pKjKariTekiyouKms;
    }

    public BizCurrency getKasiGoukeiGk() {
        return kasiGoukeiGk;
    }

    public void setKasiGoukeiGk(BizCurrency pKasiGoukeiGk) {
        kasiGoukeiGk = pKasiGoukeiGk;
    }

    public BizCurrency getKariGoukeiGk() {
        return kariGoukeiGk;
    }

    public void setKariGoukeiGk(BizCurrency pKariGoukeiGk) {
        kariGoukeiGk = pKariGoukeiGk;
    }

    public String getKjKariKurikosiGkHyjKm() {
        return kjKariKurikosiGkHyjKm;
    }

    public void setKjKariKurikosiGkHyjKm(String pKjKariKurikosiGkHyjKm) {
        kjKariKurikosiGkHyjKm = pKjKariKurikosiGkHyjKm;
    }

    public String getKjKasiKurikosiGkHyjKm() {
        return kjKasiKurikosiGkHyjKm;
    }

    public void setKjKasiKurikosiGkHyjKm(String pKjKasiKurikosiGkHyjKm) {
        kjKasiKurikosiGkHyjKm = pKjKasiKurikosiGkHyjKm;
    }

    public C_HuridenYouHassouKbn getHuridenYouHassouKbn() {
        return huridenYouHassouKbn;
    }

    public void setHuridenYouHassouKbn(C_HuridenYouHassouKbn pHuridenYouHassouKbn) {
        huridenYouHassouKbn = pHuridenYouHassouKbn;
    }

    public boolean isGoukeiFlg() {
        return goukeiFlg;
    }

    public void setGoukeiFlg(boolean pGoukeiFlg) {
        goukeiFlg = pGoukeiFlg;
    }

}
