package yuyu.def.hozen.bean.report;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）証券作成契約明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSyoukenmeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhSyoukenmeisaiListDataSourceBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private C_SinsaihkKbn irSinsaihkkbn;

    public C_SinsaihkKbn getIrSinsaihkkbn() {
        return irSinsaihkkbn;
    }

    public void setIrSinsaihkkbn(C_SinsaihkKbn pIrSinsaihkkbn) {
        irSinsaihkkbn = pIrSinsaihkkbn;
    }

    private C_SyoukensaihkKbn irSyoukensaihkkbn;

    public C_SyoukensaihkKbn getIrSyoukensaihkkbn() {
        return irSyoukensaihkkbn;
    }

    public void setIrSyoukensaihkkbn(C_SyoukensaihkKbn pIrSyoukensaihkkbn) {
        irSyoukensaihkkbn = pIrSyoukensaihkkbn;
    }

    private String irSyokensakuseiymdwareki;

    public String getIrSyokensakuseiymdwareki() {
        return irSyokensakuseiymdwareki;
    }

    public void setIrSyokensakuseiymdwareki(String pIrSyokensakuseiymdwareki) {
        irSyokensakuseiymdwareki = pIrSyokensakuseiymdwareki;
    }

    private C_HassouKbn irHassoukbn;

    public C_HassouKbn getIrHassoukbn() {
        return irHassoukbn;
    }

    public void setIrHassoukbn(C_HassouKbn pIrHassoukbn) {
        irHassoukbn = pIrHassoukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
