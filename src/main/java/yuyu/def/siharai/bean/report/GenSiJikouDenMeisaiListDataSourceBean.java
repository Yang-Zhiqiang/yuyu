package yuyu.def.siharai.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （支払）時効伝票明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiJikouDenMeisaiListDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSiJikouDenMeisaiListDataSourceBean() {
    }


    private String irBkncd;


    public String getIrBkncd() {
        return irBkncd;
    }


    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }


    private String irSyono;


    public String getIrSyono() {
        return irSyono;
    }


    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }


    private String irKasitukekgk;


    public String getIrKasitukekgk() {
        return irKasitukekgk;
    }


    public void setIrKasitukekgk(String pIrKasitukekgk) {
        irKasitukekgk = pIrKasitukekgk;
    }


    private String irTatekaekgk;


    public String getIrTatekaekgk() {
        return irTatekaekgk;
    }


    public void setIrTatekaekgk(String pIrTatekaekgk) {
        irTatekaekgk = pIrTatekaekgk;
    }


    private String irKrkgkstr;


    public String getIrKrkgkstr() {
        return irKrkgkstr;
    }


    public void setIrKrkgkstr(String pIrKrkgkstr) {
        irKrkgkstr = pIrKrkgkstr;
    }


    private String irKaribaraikgk;


    public String getIrKaribaraikgk() {
        return irKaribaraikgk;
    }


    public void setIrKaribaraikgk(String pIrKaribaraikgk) {
        irKaribaraikgk = pIrKaribaraikgk;
    }


    private String irZatusyunyukgk;


    public String getIrZatusyunyukgk() {
        return irZatusyunyukgk;
    }


    public void setIrZatusyunyukgk(String pIrZatusyunyukgk) {
        irZatusyunyukgk = pIrZatusyunyukgk;
    }


    private String irHkgk;


    public String getIrHkgk() {
        return irHkgk;
    }


    public void setIrHkgk(String pIrHkgk) {
        irHkgk = pIrHkgk;
    }


    private String irGoukeihknsyruilevel;


    public String getIrGoukeihknsyruilevel() {
        return irGoukeihknsyruilevel;
    }


    public void setIrGoukeihknsyruilevel(String pIrGoukeihknsyruilevel) {
        irGoukeihknsyruilevel = pIrGoukeihknsyruilevel;
    }


    private String irGoukeibkncd;


    public String getIrGoukeibkncd() {
        return irGoukeibkncd;
    }


    public void setIrGoukeibkncd(String pIrGoukeibkncd) {
        irGoukeibkncd = pIrGoukeibkncd;
    }


    private String irGoukeikasitukekgk;


    public String getIrGoukeikasitukekgk() {
        return irGoukeikasitukekgk;
    }


    public void setIrGoukeikasitukekgk(String pIrGoukeikasitukekgk) {
        irGoukeikasitukekgk = pIrGoukeikasitukekgk;
    }


    private String irGoukeitatekaekgk;


    public String getIrGoukeitatekaekgk() {
        return irGoukeitatekaekgk;
    }


    public void setIrGoukeitatekaekgk(String pIrGoukeitatekaekgk) {
        irGoukeitatekaekgk = pIrGoukeitatekaekgk;
    }


    private String irGoukeikrkgk;


    public String getIrGoukeikrkgk() {
        return irGoukeikrkgk;
    }


    public void setIrGoukeikrkgk(String pIrGoukeikrkgk) {
        irGoukeikrkgk = pIrGoukeikrkgk;
    }


    private String irGoukeikaribaraikgk;


    public String getIrGoukeikaribaraikgk() {
        return irGoukeikaribaraikgk;
    }


    public void setIrGoukeikaribaraikgk(String pIrGoukeikaribaraikgk) {
        irGoukeikaribaraikgk = pIrGoukeikaribaraikgk;
    }


    private String irGoukeizatusyunyukgk;


    public String getIrGoukeizatusyunyukgk() {
        return irGoukeizatusyunyukgk;
    }


    public void setIrGoukeizatusyunyukgk(String pIrGoukeizatusyunyukgk) {
        irGoukeizatusyunyukgk = pIrGoukeizatusyunyukgk;
    }


    private String irGoukeihkgk;


    public String getIrGoukeihkgk() {
        return irGoukeihkgk;
    }


    public void setIrGoukeihkgk(String pIrGoukeihkgk) {
        irGoukeihkgk = pIrGoukeihkgk;
    }


    private C_UmuKbn irGoukeiumukbn;


    public C_UmuKbn getIrGoukeiumukbn() {
        return irGoukeiumukbn;
    }


    public void setIrGoukeiumukbn(C_UmuKbn pIrGoukeiumukbn) {
        irGoukeiumukbn = pIrGoukeiumukbn;
    }


    private C_UmuKbn irSougoukeiumukbn;


    public C_UmuKbn getIrSougoukeiumukbn() {
        return irSougoukeiumukbn;
    }


    public void setIrSougoukeiumukbn(C_UmuKbn pIrSougoukeiumukbn) {
        irSougoukeiumukbn = pIrSougoukeiumukbn;
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
