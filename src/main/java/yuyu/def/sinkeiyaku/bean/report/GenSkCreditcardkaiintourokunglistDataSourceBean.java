package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Dbhanei;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）クレジットカード会員登録ＮＧリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkCreditcardkaiintourokunglistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkCreditcardkaiintourokunglistDataSourceBean() {
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


    private String irCreditqrerrorcd;


    public String getIrCreditqrerrorcd() {
        return irCreditqrerrorcd;
    }


    public void setIrCreditqrerrorcd(String pIrCreditqrerrorcd) {
        irCreditqrerrorcd = pIrCreditqrerrorcd;
    }


    private String irBluegateerrorcd;


    public String getIrBluegateerrorcd() {
        return irBluegateerrorcd;
    }


    public void setIrBluegateerrorcd(String pIrBluegateerrorcd) {
        irBluegateerrorcd = pIrBluegateerrorcd;
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
