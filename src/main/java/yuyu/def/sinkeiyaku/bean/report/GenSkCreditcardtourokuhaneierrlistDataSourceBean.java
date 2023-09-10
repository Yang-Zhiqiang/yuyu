package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）クレジットカード登録反映エラーリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkCreditcardtourokuhaneierrlistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkCreditcardtourokuhaneierrlistDataSourceBean() {
    }


    private C_CreditTrkhouKbn irCredittrkhoukbn;


    public C_CreditTrkhouKbn getIrCredittrkhoukbn() {
        return irCredittrkhoukbn;
    }


    public void setIrCredittrkhoukbn(C_CreditTrkhouKbn pIrCredittrkhoukbn) {
        irCredittrkhoukbn = pIrCredittrkhoukbn;
    }


    private String irSosikicd;


    public String getIrSosikicd() {
        return irSosikicd;
    }


    public void setIrSosikicd(String pIrSosikicd) {
        irSosikicd = pIrSosikicd;
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
