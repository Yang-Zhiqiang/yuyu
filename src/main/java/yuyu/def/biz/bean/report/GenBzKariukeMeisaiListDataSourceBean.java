package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）仮受計上明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKariukeMeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzKariukeMeisaiListDataSourceBean() {
    }

    private C_Tantositucd irTantousitucd;

    public C_Tantositucd getIrTantousitucd() {
        return irTantousitucd;
    }

    public void setIrTantousitucd(C_Tantositucd pIrTantousitucd) {
        irTantousitucd = pIrTantousitucd;
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private String irSyoricd;

    public String getIrSyoricd() {
        return irSyoricd;
    }

    public void setIrSyoricd(String pIrSyoricd) {
        irSyoricd = pIrSyoricd;
    }

    private String irSyorinm;

    public String getIrSyorinm() {
        return irSyorinm;
    }

    public void setIrSyorinm(String pIrSyorinm) {
        irSyorinm = pIrSyorinm;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irDenrenno;

    public String getIrDenrenno() {
        return irDenrenno;
    }

    public void setIrDenrenno(String pIrDenrenno) {
        irDenrenno = pIrDenrenno;
    }

    private Integer irEdano;

    public Integer getIrEdano() {
        return irEdano;
    }

    public void setIrEdano(Integer pIrEdano) {
        irEdano = pIrEdano;
    }

    private BizCurrency irDengk;

    public BizCurrency getIrDengk() {
        return irDengk;
    }

    public void setIrDengk(BizCurrency pIrDengk) {
        irDengk = pIrDengk;
    }

    private C_Tuukasyu irShrtuukasyu;

    public C_Tuukasyu getIrShrtuukasyu() {
        return irShrtuukasyu;
    }

    public void setIrShrtuukasyu(C_Tuukasyu pIrShrtuukasyu) {
        irShrtuukasyu = pIrShrtuukasyu;
    }

    private BizCurrency irSiharaigk;

    public BizCurrency getIrSiharaigk() {
        return irSiharaigk;
    }

    public void setIrSiharaigk(BizCurrency pIrSiharaigk) {
        irSiharaigk = pIrSiharaigk;
    }

    private String irKanjyoukmkcd;

    public String getIrKanjyoukmkcd() {
        return irKanjyoukmkcd;
    }

    public void setIrKanjyoukmkcd(String pIrKanjyoukmkcd) {
        irKanjyoukmkcd = pIrKanjyoukmkcd;
    }

    private String irKanjyoukmknm;

    public String getIrKanjyoukmknm() {
        return irKanjyoukmknm;
    }

    public void setIrKanjyoukmknm(String pIrKanjyoukmknm) {
        irKanjyoukmknm = pIrKanjyoukmknm;
    }

    private BizCurrency irSikinidoumeisaigk;

    public BizCurrency getIrSikinidoumeisaigk() {
        return irSikinidoumeisaigk;
    }

    public void setIrSikinidoumeisaigk(BizCurrency pIrSikinidoumeisaigk) {
        irSikinidoumeisaigk = pIrSikinidoumeisaigk;
    }

    private C_Tuukasyu irKyktuukasyu;

    public C_Tuukasyu getIrKyktuukasyu() {
        return irKyktuukasyu;
    }

    public void setIrKyktuukasyu(C_Tuukasyu pIrKyktuukasyu) {
        irKyktuukasyu = pIrKyktuukasyu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
