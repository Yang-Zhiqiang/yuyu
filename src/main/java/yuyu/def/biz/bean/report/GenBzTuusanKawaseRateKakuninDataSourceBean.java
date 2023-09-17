package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）通算判定用為替レート確認書帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzTuusanKawaseRateKakuninDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzTuusanKawaseRateKakuninDataSourceBean() {
    }

    private BizDate irZennendogseigyouymd;

    public BizDate getIrZennendogseigyouymd() {
        return irZennendogseigyouymd;
    }

    public void setIrZennendogseigyouymd(BizDate pIrZennendogseigyouymd) {
        irZennendogseigyouymd = pIrZennendogseigyouymd;
    }

    private BizNumber irKwsrate1;

    public BizNumber getIrKwsrate1() {
        return irKwsrate1;
    }

    public void setIrKwsrate1(BizNumber pIrKwsrate1) {
        irKwsrate1 = pIrKwsrate1;
    }

    private BizNumber irKwsrate2;

    public BizNumber getIrKwsrate2() {
        return irKwsrate2;
    }

    public void setIrKwsrate2(BizNumber pIrKwsrate2) {
        irKwsrate2 = pIrKwsrate2;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
