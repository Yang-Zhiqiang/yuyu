package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;

/**
 * （共通）補助簿リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHojyobolistDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHojyobolistDetailBean() {
    }

    private String irDensyskbnval;

    public String getIrDensyskbnval() {
        return irDensyskbnval;
    }

    public void setIrDensyskbnval(String pIrDensyskbnval) {
        irDensyskbnval = pIrDensyskbnval;
    }

    private String irDenym;

    public String getIrDenym() {
        return irDenym;
    }

    public void setIrDenym(String pIrDenym) {
        irDenym = pIrDenym;
    }

    private String irKanjyoukmknm;

    public String getIrKanjyoukmknm() {
        return irKanjyoukmknm;
    }

    public void setIrKanjyoukmknm(String pIrKanjyoukmknm) {
        irKanjyoukmknm = pIrKanjyoukmknm;
    }

    private String irKanjyoukmkcd;

    public String getIrKanjyoukmkcd() {
        return irKanjyoukmkcd;
    }

    public void setIrKanjyoukmkcd(String pIrKanjyoukmkcd) {
        irKanjyoukmkcd = pIrKanjyoukmkcd;
    }

    private String irSeg;

    public String getIrSeg() {
        return irSeg;
    }

    public void setIrSeg(String pIrSeg) {
        irSeg = pIrSeg;
    }

    private BizCurrency irZengetumatuzndkkari;

    public BizCurrency getIrZengetumatuzndkkari() {
        return irZengetumatuzndkkari;
    }

    public void setIrZengetumatuzndkkari(BizCurrency pIrZengetumatuzndkkari) {
        irZengetumatuzndkkari = pIrZengetumatuzndkkari;
    }

    private BizCurrency irZengetumatuzndkkasi;

    public BizCurrency getIrZengetumatuzndkkasi() {
        return irZengetumatuzndkkasi;
    }

    public void setIrZengetumatuzndkkasi(BizCurrency pIrZengetumatuzndkkasi) {
        irZengetumatuzndkkasi = pIrZengetumatuzndkkasi;
    }

    private BizCurrency irTougetugoukeikari;

    public BizCurrency getIrTougetugoukeikari() {
        return irTougetugoukeikari;
    }

    public void setIrTougetugoukeikari(BizCurrency pIrTougetugoukeikari) {
        irTougetugoukeikari = pIrTougetugoukeikari;
    }

    private BizCurrency irTougetugoukeikasi;

    public BizCurrency getIrTougetugoukeikasi() {
        return irTougetugoukeikasi;
    }

    public void setIrTougetugoukeikasi(BizCurrency pIrTougetugoukeikasi) {
        irTougetugoukeikasi = pIrTougetugoukeikasi;
    }

    private BizCurrency irTougetumatuzndkkari;

    public BizCurrency getIrTougetumatuzndkkari() {
        return irTougetumatuzndkkari;
    }

    public void setIrTougetumatuzndkkari(BizCurrency pIrTougetumatuzndkkari) {
        irTougetumatuzndkkari = pIrTougetumatuzndkkari;
    }

    private BizCurrency irTougetumatuzndkkasi;

    public BizCurrency getIrTougetumatuzndkkasi() {
        return irTougetumatuzndkkasi;
    }

    public void setIrTougetumatuzndkkasi(BizCurrency pIrTougetumatuzndkkasi) {
        irTougetumatuzndkkasi = pIrTougetumatuzndkkasi;
    }

    private BizCurrency irSshkzndkkari;

    public BizCurrency getIrSshkzndkkari() {
        return irSshkzndkkari;
    }

    public void setIrSshkzndkkari(BizCurrency pIrSshkzndkkari) {
        irSshkzndkkari = pIrSshkzndkkari;
    }

    private BizCurrency irSshkzndkkasi;

    public BizCurrency getIrSshkzndkkasi() {
        return irSshkzndkkasi;
    }

    public void setIrSshkzndkkasi(BizCurrency pIrSshkzndkkasi) {
        irSshkzndkkasi = pIrSshkzndkkasi;
    }

    private String irDenymd;

    public String getIrDenymd() {
        return irDenymd;
    }

    public void setIrDenymd(String pIrDenymd) {
        irDenymd = pIrDenymd;
    }

    private BizCurrency irKarikatagk;

    public BizCurrency getIrKarikatagk() {
        return irKarikatagk;
    }

    public void setIrKarikatagk(BizCurrency pIrKarikatagk) {
        irKarikatagk = pIrKarikatagk;
    }

    private BizCurrency irKasikatagk;

    public BizCurrency getIrKasikatagk() {
        return irKasikatagk;
    }

    public void setIrKasikatagk(BizCurrency pIrKasikatagk) {
        irKasikatagk = pIrKasikatagk;
    }

    private C_DensysKbn irDensyskbn;

    public C_DensysKbn getIrDensyskbn() {
        return irDensyskbn;
    }

    public void setIrDensyskbn(C_DensysKbn pIrDensyskbn) {
        irDensyskbn = pIrDensyskbn;
    }

    private C_Segcd irSeg1cd;

    public C_Segcd getIrSeg1cd() {
        return irSeg1cd;
    }

    public void setIrSeg1cd(C_Segcd pIrSeg1cd) {
        irSeg1cd = pIrSeg1cd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
