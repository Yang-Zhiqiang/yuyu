package yuyu.def.direct.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （ダイレクト）仮パスワード通知作成中断リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsKaripwtuutiTyuudanListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenDsKaripwtuutiTyuudanListDataSourceBean() {
    }

    private String irDskokno;

    public String getIrDskokno() {
        return irDskokno;
    }

    public void setIrDskokno(String pIrDskokno) {
        irDskokno = pIrDskokno;
    }

    private String irDskokyakunmkj;

    public String getIrDskokyakunmkj() {
        return irDskokyakunmkj;
    }

    public void setIrDskokyakunmkj(String pIrDskokyakunmkj) {
        irDskokyakunmkj = pIrDskokyakunmkj;
    }

    private C_DsKrHnnKakCdTtTydnJyKbn irDskrhnnkakcdtttydnjykbn;

    public C_DsKrHnnKakCdTtTydnJyKbn getIrDskrhnnkakcdtttydnjykbn() {
        return irDskrhnnkakcdtttydnjykbn;
    }

    public void setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn pIrDskrhnnkakcdtttydnjykbn) {
        irDskrhnnkakcdtttydnjykbn = pIrDskrhnnkakcdtttydnjykbn;
    }

    private String irMemo;

    public String getIrMemo() {
        return irMemo;
    }

    public void setIrMemo(String pIrMemo) {
        irMemo = pIrMemo;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
