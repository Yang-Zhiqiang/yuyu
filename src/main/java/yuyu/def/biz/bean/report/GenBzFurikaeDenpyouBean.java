package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振替伝票帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFurikaeDenpyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFurikaeDenpyouBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irDensyskbnval;

    public String getIrDensyskbnval() {
        return irDensyskbnval;
    }

    public void setIrDensyskbnval(String pIrDensyskbnval) {
        irDensyskbnval = pIrDensyskbnval;
    }

    private String irDenkihyouymd;

    public String getIrDenkihyouymd() {
        return irDenkihyouymd;
    }

    public void setIrDenkihyouymd(String pIrDenkihyouymd) {
        irDenkihyouymd = pIrDenkihyouymd;
    }

    private String irDenymd;

    public String getIrDenymd() {
        return irDenymd;
    }

    public void setIrDenymd(String pIrDenymd) {
        irDenymd = pIrDenymd;
    }

    private String irDensyorikbnval;

    public String getIrDensyorikbnval() {
        return irDensyorikbnval;
    }

    public void setIrDensyorikbnval(String pIrDensyorikbnval) {
        irDensyorikbnval = pIrDensyorikbnval;
    }

    private String irHuridenpyouno;

    public String getIrHuridenpyouno() {
        return irHuridenpyouno;
    }

    public void setIrHuridenpyouno(String pIrHuridenpyouno) {
        irHuridenpyouno = pIrHuridenpyouno;
    }

    private String irTorihikisakikbnval;

    public String getIrTorihikisakikbnval() {
        return irTorihikisakikbnval;
    }

    public void setIrTorihikisakikbnval(String pIrTorihikisakikbnval) {
        irTorihikisakikbnval = pIrTorihikisakikbnval;
    }

    private String irTorihikisakicd;

    public String getIrTorihikisakicd() {
        return irTorihikisakicd;
    }

    public void setIrTorihikisakicd(String pIrTorihikisakicd) {
        irTorihikisakicd = pIrTorihikisakicd;
    }

    private String irKanjyoukmkcdkari;

    public String getIrKanjyoukmkcdkari() {
        return irKanjyoukmkcdkari;
    }

    public void setIrKanjyoukmkcdkari(String pIrKanjyoukmkcdkari) {
        irKanjyoukmkcdkari = pIrKanjyoukmkcdkari;
    }

    private String irKarikanjyoukmknm;

    public String getIrKarikanjyoukmknm() {
        return irKarikanjyoukmknm;
    }

    public void setIrKarikanjyoukmknm(String pIrKarikanjyoukmknm) {
        irKarikanjyoukmknm = pIrKarikanjyoukmknm;
    }

    private String irKarihojyokmknm;

    public String getIrKarihojyokmknm() {
        return irKarihojyokmknm;
    }

    public void setIrKarihojyokmknm(String pIrKarihojyokmknm) {
        irKarihojyokmknm = pIrKarihojyokmknm;
    }

    private BizCurrency irKarikatagk;

    public BizCurrency getIrKarikatagk() {
        return irKarikatagk;
    }

    public void setIrKarikatagk(BizCurrency pIrKarikatagk) {
        irKarikatagk = pIrKarikatagk;
    }

    private String irSeg1cdkari;

    public String getIrSeg1cdkari() {
        return irSeg1cdkari;
    }

    public void setIrSeg1cdkari(String pIrSeg1cdkari) {
        irSeg1cdkari = pIrSeg1cdkari;
    }

    private String irKanjyoukmkcdkasi;

    public String getIrKanjyoukmkcdkasi() {
        return irKanjyoukmkcdkasi;
    }

    public void setIrKanjyoukmkcdkasi(String pIrKanjyoukmkcdkasi) {
        irKanjyoukmkcdkasi = pIrKanjyoukmkcdkasi;
    }

    private String irKasikanjyoukmknm;

    public String getIrKasikanjyoukmknm() {
        return irKasikanjyoukmknm;
    }

    public void setIrKasikanjyoukmknm(String pIrKasikanjyoukmknm) {
        irKasikanjyoukmknm = pIrKasikanjyoukmknm;
    }

    private String irKasihojyokmknm;

    public String getIrKasihojyokmknm() {
        return irKasihojyokmknm;
    }

    public void setIrKasihojyokmknm(String pIrKasihojyokmknm) {
        irKasihojyokmknm = pIrKasihojyokmknm;
    }

    private BizCurrency irKasikatagk;

    public BizCurrency getIrKasikatagk() {
        return irKasikatagk;
    }

    public void setIrKasikatagk(BizCurrency pIrKasikatagk) {
        irKasikatagk = pIrKasikatagk;
    }

    private String irSeg1cdkasi;

    public String getIrSeg1cdkasi() {
        return irSeg1cdkasi;
    }

    public void setIrSeg1cdkasi(String pIrSeg1cdkasi) {
        irSeg1cdkasi = pIrSeg1cdkasi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
