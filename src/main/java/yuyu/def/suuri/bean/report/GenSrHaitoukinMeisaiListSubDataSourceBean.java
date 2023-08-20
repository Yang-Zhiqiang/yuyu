package yuyu.def.suuri.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （数理）配当金明細リストサブ帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrHaitoukinMeisaiListSubDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSrHaitoukinMeisaiListSubDataSourceBean() {
    }


    private Integer irKensuu;


    public Integer getIrKensuu() {
        return irKensuu;
    }


    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }


    private BizCurrency irHsys;


    public BizCurrency getIrHsys() {
        return irHsys;
    }


    public void setIrHsys(BizCurrency pIrHsys) {
        irHsys = pIrHsys;
    }


    private BizCurrency irZennendokurikosid;


    public BizCurrency getIrZennendokurikosid() {
        return irZennendokurikosid;
    }


    public void setIrZennendokurikosid(BizCurrency pIrZennendokurikosid) {
        irZennendokurikosid = pIrZennendokurikosid;
    }


    private BizCurrency irHaitoursk;


    public BizCurrency getIrHaitoursk() {
        return irHaitoursk;
    }


    public void setIrHaitoursk(BizCurrency pIrHaitoursk) {
        irHaitoursk = pIrHaitoursk;
    }


    private BizCurrency irTounendod;


    public BizCurrency getIrTounendod() {
        return irTounendod;
    }


    public void setIrTounendod(BizCurrency pIrTounendod) {
        irTounendod = pIrTounendod;
    }


    private BizCurrency irTounendomatud;


    public BizCurrency getIrTounendomatud() {
        return irTounendomatud;
    }


    public void setIrTounendomatud(BizCurrency pIrTounendomatud) {
        irTounendomatud = pIrTounendomatud;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
