package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）名義変更請求書明細帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMhSeikyuusyoDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhMhSeikyuusyoDataSourceBean() {
    }

    private String irSbhkuktnmkj;

    public String getIrSbhkuktnmkj() {
        return irSbhkuktnmkj;
    }

    public void setIrSbhkuktnmkj(String pIrSbhkuktnmkj) {
        irSbhkuktnmkj = pIrSbhkuktnmkj;
    }

    private BizNumber irBnwari;

    public BizNumber getIrBnwari() {
        return irBnwari;
    }

    public void setIrBnwari(BizNumber pIrBnwari) {
        irBnwari = pIrBnwari;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
