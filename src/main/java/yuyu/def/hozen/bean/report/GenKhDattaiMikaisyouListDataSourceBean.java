package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）脱退未解消リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhDattaiMikaisyouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhDattaiMikaisyouListDataSourceBean() {
    }

    private String irAtesakisosiki;

    public String getIrAtesakisosiki() {
        return irAtesakisosiki;
    }

    public void setIrAtesakisosiki(String pIrAtesakisosiki) {
        irAtesakisosiki = pIrAtesakisosiki;
    }

    private String irTyoukimisyorihyouji;

    public String getIrTyoukimisyorihyouji() {
        return irTyoukimisyorihyouji;
    }

    public void setIrTyoukimisyorihyouji(String pIrTyoukimisyorihyouji) {
        irTyoukimisyorihyouji = pIrTyoukimisyorihyouji;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizDate irSyoriymdbizdate;

    public BizDate getIrSyoriymdbizdate() {
        return irSyoriymdbizdate;
    }

    public void setIrSyoriymdbizdate(BizDate pIrSyoriymdbizdate) {
        irSyoriymdbizdate = pIrSyoriymdbizdate;
    }

    private String irDattaiinputsosiki;

    public String getIrDattaiinputsosiki() {
        return irDattaiinputsosiki;
    }

    public void setIrDattaiinputsosiki(String pIrDattaiinputsosiki) {
        irDattaiinputsosiki = pIrDattaiinputsosiki;
    }

    private String irComment124keta;

    public String getIrComment124keta() {
        return irComment124keta;
    }

    public void setIrComment124keta(String pIrComment124keta) {
        irComment124keta = pIrComment124keta;
    }

    private String irTantnm;

    public String getIrTantnm() {
        return irTantnm;
    }

    public void setIrTantnm(String pIrTantnm) {
        irTantnm = pIrTantnm;
    }

    private C_Dattaikeiro irDattaikeiro;

    public C_Dattaikeiro getIrDattaikeiro() {
        return irDattaikeiro;
    }

    public void setIrDattaikeiro(C_Dattaikeiro pIrDattaikeiro) {
        irDattaikeiro = pIrDattaikeiro;
    }

    private C_DattairiyuuKbn irDattairiyuukbn;

    public C_DattairiyuuKbn getIrDattairiyuukbn() {
        return irDattairiyuukbn;
    }

    public void setIrDattairiyuukbn(C_DattairiyuuKbn pIrDattairiyuukbn) {
        irDattairiyuukbn = pIrDattairiyuukbn;
    }

    private String irSyorisosikicd;

    public String getIrSyorisosikicd() {
        return irSyorisosikicd;
    }

    public void setIrSyorisosikicd(String pIrSyorisosikicd) {
        irSyorisosikicd = pIrSyorisosikicd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
