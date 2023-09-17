package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）新契約本社用伝票リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSkHonsyaDenpyouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzSkHonsyaDenpyouListDataSourceBean() {
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

    private String irTekiyoucdkari;

    public String getIrTekiyoucdkari() {
        return irTekiyoucdkari;
    }

    public void setIrTekiyoucdkari(String pIrTekiyoucdkari) {
        irTekiyoucdkari = pIrTekiyoucdkari;
    }

    private BizCurrency irDengkkari;

    public BizCurrency getIrDengkkari() {
        return irDengkkari;
    }

    public void setIrDengkkari(BizCurrency pIrDengkkari) {
        irDengkkari = pIrDengkkari;
    }

    private BizNumber irKensuukari;

    public BizNumber getIrKensuukari() {
        return irKensuukari;
    }

    public void setIrKensuukari(BizNumber pIrKensuukari) {
        irKensuukari = pIrKensuukari;
    }

    private String irTekiyoukari;

    public String getIrTekiyoukari() {
        return irTekiyoukari;
    }

    public void setIrTekiyoukari(String pIrTekiyoukari) {
        irTekiyoukari = pIrTekiyoukari;
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

    private String irTekiyoucdkasi;

    public String getIrTekiyoucdkasi() {
        return irTekiyoucdkasi;
    }

    public void setIrTekiyoucdkasi(String pIrTekiyoucdkasi) {
        irTekiyoucdkasi = pIrTekiyoucdkasi;
    }

    private BizCurrency irDengkkasi;

    public BizCurrency getIrDengkkasi() {
        return irDengkkasi;
    }

    public void setIrDengkkasi(BizCurrency pIrDengkkasi) {
        irDengkkasi = pIrDengkkasi;
    }

    private BizNumber irKensuukasi;

    public BizNumber getIrKensuukasi() {
        return irKensuukasi;
    }

    public void setIrKensuukasi(BizNumber pIrKensuukasi) {
        irKensuukasi = pIrKensuukasi;
    }

    private String irTekiyoukasi;

    public String getIrTekiyoukasi() {
        return irTekiyoukasi;
    }

    public void setIrTekiyoukasi(String pIrTekiyoukasi) {
        irTekiyoukasi = pIrTekiyoukasi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
