package yuyu.def.siharai.bean.report;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （支払）前納精算金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiZennouseisankinMeisaiListDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSiZennouseisankinMeisaiListDataSourceBean() {
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


    private String irZennouseisankin;


    public String getIrZennouseisankin() {
        return irZennouseisankin;
    }


    public void setIrZennouseisankin(String pIrZennouseisankin) {
        irZennouseisankin = pIrZennouseisankin;
    }


    private String irGoukeibkncd;


    public String getIrGoukeibkncd() {
        return irGoukeibkncd;
    }


    public void setIrGoukeibkncd(String pIrGoukeibkncd) {
        irGoukeibkncd = pIrGoukeibkncd;
    }


    private String irGoukeihknsyruilevel;


    public String getIrGoukeihknsyruilevel() {
        return irGoukeihknsyruilevel;
    }


    public void setIrGoukeihknsyruilevel(String pIrGoukeihknsyruilevel) {
        irGoukeihknsyruilevel = pIrGoukeihknsyruilevel;
    }


    private String irGoukeibknkktinnd;


    public String getIrGoukeibknkktinnd() {
        return irGoukeibknkktinnd;
    }


    public void setIrGoukeibknkktinnd(String pIrGoukeibknkktinnd) {
        irGoukeibknkktinnd = pIrGoukeibknkktinnd;
    }


    private String irGoukeibknkktiym;


    public String getIrGoukeibknkktiym() {
        return irGoukeibknkktiym;
    }


    public void setIrGoukeibknkktiym(String pIrGoukeibknkktiym) {
        irGoukeibknkktiym = pIrGoukeibknkktiym;
    }


    private BizNumber irGoukeikensuu1;


    public BizNumber getIrGoukeikensuu1() {
        return irGoukeikensuu1;
    }


    public void setIrGoukeikensuu1(BizNumber pIrGoukeikensuu1) {
        irGoukeikensuu1 = pIrGoukeikensuu1;
    }


    private String irGoukeiseisankin;


    public String getIrGoukeiseisankin() {
        return irGoukeiseisankin;
    }


    public void setIrGoukeiseisankin(String pIrGoukeiseisankin) {
        irGoukeiseisankin = pIrGoukeiseisankin;
    }


    private C_UmuKbn irGoukeiumukbn;


    public C_UmuKbn getIrGoukeiumukbn() {
        return irGoukeiumukbn;
    }


    public void setIrGoukeiumukbn(C_UmuKbn pIrGoukeiumukbn) {
        irGoukeiumukbn = pIrGoukeiumukbn;
    }


    private Integer irPageno;


    public Integer getIrPageno() {
        return irPageno;
    }


    public void setIrPageno(Integer pIrPageno) {
        irPageno = pIrPageno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
