package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）契約変更請求書明細帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKhSeikyuusyoDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKhSeikyuusyoDataSourceBean() {
    }

    private String irSyouhnnm;

    public String getIrSyouhnnm() {
        return irSyouhnnm;
    }

    public void setIrSyouhnnm(String pIrSyouhnnm) {
        irSyouhnnm = pIrSyouhnnm;
    }

    private C_KihonssyuruiKbn irKihonssyuruikbn;

    public C_KihonssyuruiKbn getIrKihonssyuruikbn() {
        return irKihonssyuruikbn;
    }

    public void setIrKihonssyuruikbn(C_KihonssyuruiKbn pIrKihonssyuruikbn) {
        irKihonssyuruikbn = pIrKihonssyuruikbn;
    }

    private BizCurrency irKihons;

    public BizCurrency getIrKihons() {
        return irKihons;
    }

    public void setIrKihons(BizCurrency pIrKihons) {
        irKihons = pIrKihons;
    }

    private C_KykhnkKbn irKykhnkkbn;

    public C_KykhnkKbn getIrKykhnkkbn() {
        return irKykhnkkbn;
    }

    public void setIrKykhnkkbn(C_KykhnkKbn pIrKykhnkkbn) {
        irKykhnkkbn = pIrKykhnkkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
