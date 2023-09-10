package yuyu.def.siharai.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （支払）円貨支払留意事項説明文書編集帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiEditEnkaryuuiDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenSiEditEnkaryuuiDataSourceBean() {
    }

    private C_Tuukasyu irTuukasyu;

    public C_Tuukasyu getIrTuukasyu() {
        return irTuukasyu;
    }

    public void setIrTuukasyu(C_Tuukasyu pIrTuukasyu) {
        irTuukasyu = pIrTuukasyu;
    }

    private String irKyuuhuname;

    public String getIrKyuuhuname() {
        return irKyuuhuname;
    }

    public void setIrKyuuhuname(String pIrKyuuhuname) {
        irKyuuhuname = pIrKyuuhuname;
    }

    private BizCurrency irKyhkg;

    public BizCurrency getIrKyhkg() {
        return irKyhkg;
    }

    public void setIrKyhkg(BizCurrency pIrKyhkg) {
        irKyhkg = pIrKyhkg;
    }

    private String irShrdetailbikou;

    public String getIrShrdetailbikou() {
        return irShrdetailbikou;
    }

    public void setIrShrdetailbikou(String pIrShrdetailbikou) {
        irShrdetailbikou = pIrShrdetailbikou;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
