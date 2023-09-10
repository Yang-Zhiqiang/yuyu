package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）クレカＱＲ登録未反映リスト（申込入力未了分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkCreditqrtrkmihaneilistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenSkCreditqrtrkmihaneilistDataSourceBean() {
    }

    private String irCreditqrtrkymd;

    public String getIrCreditqrtrkymd() {
        return irCreditqrtrkymd;
    }

    public void setIrCreditqrtrkymd(String pIrCreditqrtrkymd) {
        irCreditqrtrkymd = pIrCreditqrtrkymd;
    }

    private String irDatajyusinymd;

    public String getIrDatajyusinymd() {
        return irDatajyusinymd;
    }

    public void setIrDatajyusinymd(String pIrDatajyusinymd) {
        irDatajyusinymd = pIrDatajyusinymd;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
