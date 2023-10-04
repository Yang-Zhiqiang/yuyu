package yuyu.batch.hozen.khinterf.khkesikomisks;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 インターフェイス 口振集約Bean
 */
public class KouhuriMergeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String suitouKbn;

    private String kzhurikaeBankCd;

    private BizDate hurikaeYmd;

    private BizDate  denYmd;

    private String taisyakuKbn;

    private String hutuuhokenKamokuCd;

    private BizCurrency dengk;

    private BizDate nkkakusyouNyuuryokuYmd;

    private String kinyuukikankbn;

    public KouhuriMergeBean() {

        suitouKbn = "";

        kzhurikaeBankCd = "";

        taisyakuKbn= "";

        hutuuhokenKamokuCd= "";

        dengk = BizCurrency.optional();

    }

    public String getSuitouKbn() {
        return suitouKbn;
    }

    public void setSuitouKbn(String pSuitouKbn) {
        this.suitouKbn = pSuitouKbn;
    }

    public String getKzhurikaeBankCd() {
        return kzhurikaeBankCd;
    }

    public void setKzhurikaeBankCd(String pKzhurikaeBankCd) {
        this.kzhurikaeBankCd = pKzhurikaeBankCd;
    }

    public BizDate getHurikaeYmd() {
        return hurikaeYmd;
    }

    public void setHurikaeYmd(BizDate pHurikaeYmd) {
        this.hurikaeYmd = pHurikaeYmd;
    }

    public String getTaisyakuKbn() {
        return taisyakuKbn;
    }

    public void setTaisyakuKbn(String pTaisyakuKbn) {
        this.taisyakuKbn = pTaisyakuKbn;
    }

    public String getHutuuhokenKamokuCd() {
        return hutuuhokenKamokuCd;
    }

    public void setHutuuhokenKamokuCd(String pHutuuhokenKamokuCd) {
        this.hutuuhokenKamokuCd = pHutuuhokenKamokuCd;
    }

    public BizCurrency getDengk() {
        return dengk;
    }

    public void setDengk(BizCurrency pDengk) {
        this.dengk = pDengk;
    }

    public BizDate getNkkakusyouNyuuryokuYmd() {
        return nkkakusyouNyuuryokuYmd;
    }

    public void setNkkakusyouNyuuryokuYmd(BizDate pNkkakusyouNyuuryokuYmd) {
        this.nkkakusyouNyuuryokuYmd = pNkkakusyouNyuuryokuYmd;
    }

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        this.denYmd = pDenYmd;
    }

    public String getKinyuukikanKbn() {
        return kinyuukikankbn;
    }

    public void setKinyuukikanKbn(String pKinyuukikanKbn) {
        this.kinyuukikankbn = pKinyuukikanKbn;
    }

}
