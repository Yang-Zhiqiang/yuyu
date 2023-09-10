package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）新契約有効性反映確認結果リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkYuukouhaneikakuninkekkalistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenSkYuukouhaneikakuninkekkalistDataSourceBean() {
    }

    private String irMosno;

    public String getIrMosno() {
        return irMosno;
    }

    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }

    private String irCreditkessaiyouno;

    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }

    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
    }

    private C_MossyoumetuKbn irMossyoumetukbn;

    public C_MossyoumetuKbn getIrMossyoumetukbn() {
        return irMossyoumetukbn;
    }

    public void setIrMossyoumetukbn(C_MossyoumetuKbn pIrMossyoumetukbn) {
        irMossyoumetukbn = pIrMossyoumetukbn;
    }

    private C_CreditTrkjkKbn irCredittrkjkkbn;

    public C_CreditTrkjkKbn getIrCredittrkjkkbn() {
        return irCredittrkjkkbn;
    }

    public void setIrCredittrkjkkbn(C_CreditTrkjkKbn pIrCredittrkjkkbn) {
        irCredittrkjkkbn = pIrCredittrkjkkbn;
    }

    private C_CreditYuukoukakKbn irCredityuukoukakkbn;

    public C_CreditYuukoukakKbn getIrCredityuukoukakkbn() {
        return irCredityuukoukakkbn;
    }

    public void setIrCredityuukoukakkbn(C_CreditYuukoukakKbn pIrCredityuukoukakkbn) {
        irCredityuukoukakkbn = pIrCredityuukoukakkbn;
    }

    private C_Dbhanei irDbhanei;

    public C_Dbhanei getIrDbhanei() {
        return irDbhanei;
    }

    public void setIrDbhanei(C_Dbhanei pIrDbhanei) {
        irDbhanei = pIrDbhanei;
    }

    private String irCredittrkhaneierrriyuu;

    public String getIrCredittrkhaneierrriyuu() {
        return irCredittrkhaneierrriyuu;
    }

    public void setIrCredittrkhaneierrriyuu(String pIrCredittrkhaneierrriyuu) {
        irCredittrkhaneierrriyuu = pIrCredittrkhaneierrriyuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
