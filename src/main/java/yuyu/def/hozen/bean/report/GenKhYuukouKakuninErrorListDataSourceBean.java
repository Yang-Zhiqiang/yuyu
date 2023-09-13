package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）有効確認エラーリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYuukouKakuninErrorListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhYuukouKakuninErrorListDataSourceBean() {
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

    private String irCredityuukoukakym;

    public String getIrCredityuukoukakym() {
        return irCredityuukoukakym;
    }

    public void setIrCredityuukoukakym(String pIrCredityuukoukakym) {
        irCredityuukoukakym = pIrCredityuukoukakym;
    }

    private C_Yuukoukakkekka irCredityuukoukakkekka;

    public C_Yuukoukakkekka getIrCredityuukoukakkekka() {
        return irCredityuukoukakkekka;
    }

    public void setIrCredityuukoukakkekka(C_Yuukoukakkekka pIrCredityuukoukakkekka) {
        irCredityuukoukakkekka = pIrCredityuukoukakkekka;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
