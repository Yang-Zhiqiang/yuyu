package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）前納精算金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouseisankinMeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhZennouseisankinMeisaiListDataSourceBean() {
    }

    private String irBkncd;

    public String getIrBkncd() {
        return irBkncd;
    }

    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }

    private String irHknsyruilevel;

    public String getIrHknsyruilevel() {
        return irHknsyruilevel;
    }

    public void setIrHknsyruilevel(String pIrHknsyruilevel) {
        irHknsyruilevel = pIrHknsyruilevel;
    }

    private String irBknkktiymd;

    public String getIrBknkktiymd() {
        return irBknkktiymd;
    }

    public void setIrBknkktiymd(String pIrBknkktiymd) {
        irBknkktiymd = pIrBknkktiymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizCurrency irYenseisankin;

    public BizCurrency getIrYenseisankin() {
        return irYenseisankin;
    }

    public void setIrYenseisankin(BizCurrency pIrYenseisankin) {
        irYenseisankin = pIrYenseisankin;
    }

    private String irBknkktinnd;

    public String getIrBknkktinnd() {
        return irBknkktinnd;
    }

    public void setIrBknkktinnd(String pIrBknkktinnd) {
        irBknkktinnd = pIrBknkktinnd;
    }

    private String irBknkktiym;

    public String getIrBknkktiym() {
        return irBknkktiym;
    }

    public void setIrBknkktiym(String pIrBknkktiym) {
        irBknkktiym = pIrBknkktiym;
    }

    private BizNumber irSeisankinkensuugoukei;

    public BizNumber getIrSeisankinkensuugoukei() {
        return irSeisankinkensuugoukei;
    }

    public void setIrSeisankinkensuugoukei(BizNumber pIrSeisankinkensuugoukei) {
        irSeisankinkensuugoukei = pIrSeisankinkensuugoukei;
    }

    private BizCurrency irSeisankingakugoukei;

    public BizCurrency getIrSeisankingakugoukei() {
        return irSeisankingakugoukei;
    }

    public void setIrSeisankingakugoukei(BizCurrency pIrSeisankingakugoukei) {
        irSeisankingakugoukei = pIrSeisankingakugoukei;
    }

    private C_UmuKbn irGoukeiumukbn;

    public C_UmuKbn getIrGoukeiumukbn() {
        return irGoukeiumukbn;
    }

    public void setIrGoukeiumukbn(C_UmuKbn pIrGoukeiumukbn) {
        irGoukeiumukbn = pIrGoukeiumukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
