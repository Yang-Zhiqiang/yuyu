package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）初回保険料売上請求エラーリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkFsturiagekekkaerrorlistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkFsturiagekekkaerrorlistDataSourceBean() {
    }


    private String irCreditkessaiyouno;


    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }


    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
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


    private String irSeikyuuerrorriyuu;


    public String getIrSeikyuuerrorriyuu() {
        return irSeikyuuerrorriyuu;
    }


    public void setIrSeikyuuerrorriyuu(String pIrSeikyuuerrorriyuu) {
        irSeikyuuerrorriyuu = pIrSeikyuuerrorriyuu;
    }


    private String irUriageseikyuuerrcd;


    public String getIrUriageseikyuuerrcd() {
        return irUriageseikyuuerrcd;
    }


    public void setIrUriageseikyuuerrcd(String pIrUriageseikyuuerrcd) {
        irUriageseikyuuerrcd = pIrUriageseikyuuerrcd;
    }


    private BizNumber irKensuugoukei;


    public BizNumber getIrKensuugoukei() {
        return irKensuugoukei;
    }


    public void setIrKensuugoukei(BizNumber pIrKensuugoukei) {
        irKensuugoukei = pIrKensuugoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
