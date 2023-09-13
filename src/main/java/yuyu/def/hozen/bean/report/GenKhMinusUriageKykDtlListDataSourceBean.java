package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）マイナス売上契約明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMinusUriageKykDtlListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhMinusUriageKykDtlListDataSourceBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizDate irUriageymd;

    public BizDate getIrUriageymd() {
        return irUriageymd;
    }

    public void setIrUriageymd(BizDate pIrUriageymd) {
        irUriageymd = pIrUriageymd;
    }

    private String irCreditkessaiyouno;

    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }

    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
    }

    private BizDateYM irJyuutouym;

    public BizDateYM getIrJyuutouym() {
        return irJyuutouym;
    }

    public void setIrJyuutouym(BizDateYM pIrJyuutouym) {
        irJyuutouym = pIrJyuutouym;
    }

    private BizCurrency irCredituriagegk;

    public BizCurrency getIrCredituriagegk() {
        return irCredituriagegk;
    }

    public void setIrCredituriagegk(BizCurrency pIrCredituriagegk) {
        irCredituriagegk = pIrCredituriagegk;
    }

    private String irKinounm;

    public String getIrKinounm() {
        return irKinounm;
    }

    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
