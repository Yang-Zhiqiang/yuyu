package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）売上請求結果エラーリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhUriageSeikyuuKekkaErrorListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhUriageSeikyuuKekkaErrorListDataSourceBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irCreditkessaiyouno;

    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }

    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
    }

    private BizDate irUriageymd;

    public BizDate getIrUriageymd() {
        return irUriageymd;
    }

    public void setIrUriageymd(BizDate pIrUriageymd) {
        irUriageymd = pIrUriageymd;
    }

    private BizCurrency irCredituriagegk;

    public BizCurrency getIrCredituriagegk() {
        return irCredituriagegk;
    }

    public void setIrCredituriagegk(BizCurrency pIrCredituriagegk) {
        irCredituriagegk = pIrCredituriagegk;
    }

    private C_CreditUriageNgJiyuuKbn irCredituriagengjiyuu;

    public C_CreditUriageNgJiyuuKbn getIrCredituriagengjiyuu() {
        return irCredituriagengjiyuu;
    }

    public void setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn pIrCredituriagengjiyuu) {
        irCredituriagengjiyuu = pIrCredituriagengjiyuu;
    }

    private String irErrorcd;

    public String getIrErrorcd() {
        return irErrorcd;
    }

    public void setIrErrorcd(String pIrErrorcd) {
        irErrorcd = pIrErrorcd;
    }

    private C_AuthoriKbn irAuthorikbn;

    public C_AuthoriKbn getIrAuthorikbn() {
        return irAuthorikbn;
    }

    public void setIrAuthorikbn(C_AuthoriKbn pIrAuthorikbn) {
        irAuthorikbn = pIrAuthorikbn;
    }

    private String irKinounm;

    public String getIrKinounm() {
        return irKinounm;
    }

    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }

    private C_CreditUriageSeikyuuKbn irCredituriageseikyuukbn;

    public C_CreditUriageSeikyuuKbn getIrCredituriageseikyuukbn() {
        return irCredituriageseikyuukbn;
    }

    public void setIrCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn pIrCredituriageseikyuukbn) {
        irCredituriageseikyuukbn = pIrCredituriageseikyuukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
