package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）未経過Ｐ返金リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMikeikapHenkinListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhMikeikapHenkinListDataSourceBean() {
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

    private String irMikeikapkktiymd;

    public String getIrMikeikapkktiymd() {
        return irMikeikapkktiymd;
    }

    public void setIrMikeikapkktiymd(String pIrMikeikapkktiymd) {
        irMikeikapkktiymd = pIrMikeikapkktiymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizCurrency irMikeikap;

    public BizCurrency getIrMikeikap() {
        return irMikeikap;
    }

    public void setIrMikeikap(BizCurrency pIrMikeikap) {
        irMikeikap = pIrMikeikap;
    }

    private String irMikeikapkktinnd;

    public String getIrMikeikapkktinnd() {
        return irMikeikapkktinnd;
    }

    public void setIrMikeikapkktinnd(String pIrMikeikapkktinnd) {
        irMikeikapkktinnd = pIrMikeikapkktinnd;
    }

    private String irMikeikapkktiym;

    public String getIrMikeikapkktiym() {
        return irMikeikapkktiym;
    }

    public void setIrMikeikapkktiym(String pIrMikeikapkktiym) {
        irMikeikapkktiym = pIrMikeikapkktiym;
    }

    private BizNumber irHenkinkensuugoukei;

    public BizNumber getIrHenkinkensuugoukei() {
        return irHenkinkensuugoukei;
    }

    public void setIrHenkinkensuugoukei(BizNumber pIrHenkinkensuugoukei) {
        irHenkinkensuugoukei = pIrHenkinkensuugoukei;
    }

    private BizCurrency irHenkingakugoukei;

    public BizCurrency getIrHenkingakugoukei() {
        return irHenkingakugoukei;
    }

    public void setIrHenkingakugoukei(BizCurrency pIrHenkingakugoukei) {
        irHenkingakugoukei = pIrHenkingakugoukei;
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
