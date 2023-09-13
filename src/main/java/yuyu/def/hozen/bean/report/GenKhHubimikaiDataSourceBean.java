package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）不備未解消リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHubimikaiDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhHubimikaiDataSourceBean() {
    }

    private Integer irRenno;

    public Integer getIrRenno() {
        return irRenno;
    }

    public void setIrRenno(Integer pIrRenno) {
        irRenno = pIrRenno;
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

    private String irSksreadymd;

    public String getIrSksreadymd() {
        return irSksreadymd;
    }

    public void setIrSksreadymd(String pIrSksreadymd) {
        irSksreadymd = pIrSksreadymd;
    }

    private String irHassinsaki;

    public String getIrHassinsaki() {
        return irHassinsaki;
    }

    public void setIrHassinsaki(String pIrHassinsaki) {
        irHassinsaki = pIrHassinsaki;
    }

    private C_UmuKbn irGenponhnkykumu;

    public C_UmuKbn getIrGenponhnkykumu() {
        return irGenponhnkykumu;
    }

    public void setIrGenponhnkykumu(C_UmuKbn pIrGenponhnkykumu) {
        irGenponhnkykumu = pIrGenponhnkykumu;
    }

    private String irTrksyanm;

    public String getIrTrksyanm() {
        return irTrksyanm;
    }

    public void setIrTrksyanm(String pIrTrksyanm) {
        irTrksyanm = pIrTrksyanm;
    }

    private String irSyouninsyanm;

    public String getIrSyouninsyanm() {
        return irSyouninsyanm;
    }

    public void setIrSyouninsyanm(String pIrSyouninsyanm) {
        irSyouninsyanm = pIrSyouninsyanm;
    }

    private Integer irHassinkaisuu;

    public Integer getIrHassinkaisuu() {
        return irHassinkaisuu;
    }

    public void setIrHassinkaisuu(Integer pIrHassinkaisuu) {
        irHassinkaisuu = pIrHassinkaisuu;
    }

    private String irFsthubihasinymd;

    public String getIrFsthubihasinymd() {
        return irFsthubihasinymd;
    }

    public void setIrFsthubihasinymd(String pIrFsthubihasinymd) {
        irFsthubihasinymd = pIrFsthubihasinymd;
    }

    private String irLasthubihasinymd;

    public String getIrLasthubihasinymd() {
        return irLasthubihasinymd;
    }

    public void setIrLasthubihasinymd(String pIrLasthubihasinymd) {
        irLasthubihasinymd = pIrLasthubihasinymd;
    }

    private C_UmuKbn irTyoukihubiumu;

    public C_UmuKbn getIrTyoukihubiumu() {
        return irTyoukihubiumu;
    }

    public void setIrTyoukihubiumu(C_UmuKbn pIrTyoukihubiumu) {
        irTyoukihubiumu = pIrTyoukihubiumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
