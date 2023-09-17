package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_ShrtysyKakuninyouRiyuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）汎用支払調書帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHanyouTyousyolistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzHanyouTyousyolistDataSourceBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irShrymd;

    public String getIrShrymd() {
        return irShrymd;
    }

    public void setIrShrymd(String pIrShrymd) {
        irShrymd = pIrShrymd;
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

    private String irUktnm;

    public String getIrUktnm() {
        return irUktnm;
    }

    public void setIrUktnm(String pIrUktnm) {
        irUktnm = pIrUktnm;
    }

    private BizCurrency irHokenkingakuetc;

    public BizCurrency getIrHokenkingakuetc() {
        return irHokenkingakuetc;
    }

    public void setIrHokenkingakuetc(BizCurrency pIrHokenkingakuetc) {
        irHokenkingakuetc = pIrHokenkingakuetc;
    }

    private BizCurrency irShkshgk;

    public BizCurrency getIrShkshgk() {
        return irShkshgk;
    }

    public void setIrShkshgk(BizCurrency pIrShkshgk) {
        irShkshgk = pIrShkshgk;
    }

    private C_ShrtysyKakuninyouRiyuKbn irShrtyousyokakyouriyukbn;

    public C_ShrtysyKakuninyouRiyuKbn getIrShrtyousyokakyouriyukbn() {
        return irShrtyousyokakyouriyukbn;
    }

    public void setIrShrtyousyokakyouriyukbn(C_ShrtysyKakuninyouRiyuKbn pIrShrtyousyokakyouriyukbn) {
        irShrtyousyokakyouriyukbn = pIrShrtyousyokakyouriyukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
