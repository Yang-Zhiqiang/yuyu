package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）支払遅延利息内訳リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzTienrskutiwakelistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzTienrskutiwakelistDataSourceBean() {
    }

    private String irHuridenatesakinm;

    public String getIrHuridenatesakinm() {
        return irHuridenatesakinm;
    }

    public void setIrHuridenatesakinm(String pIrHuridenatesakinm) {
        irHuridenatesakinm = pIrHuridenatesakinm;
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

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
