package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）マイナンバー帳票抽出リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMynumberTyuusyutuListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzMynumberTyuusyutuListDataSourceBean() {
    }

    private String irScanreadymd;

    public String getIrScanreadymd() {
        return irScanreadymd;
    }

    public void setIrScanreadymd(String pIrScanreadymd) {
        irScanreadymd = pIrScanreadymd;
    }

    private String irTourokutime;

    public String getIrTourokutime() {
        return irTourokutime;
    }

    public void setIrTourokutime(String pIrTourokutime) {
        irTourokutime = pIrTourokutime;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irSeikyuusyanmkj;

    public String getIrSeikyuusyanmkj() {
        return irSeikyuusyanmkj;
    }

    public void setIrSeikyuusyanmkj(String pIrSeikyuusyanmkj) {
        irSeikyuusyanmkj = pIrSeikyuusyanmkj;
    }

    private String irGyoumunm;

    public String getIrGyoumunm() {
        return irGyoumunm;
    }

    public void setIrGyoumunm(String pIrGyoumunm) {
        irGyoumunm = pIrGyoumunm;
    }

    private String irMaisuu;

    public String getIrMaisuu() {
        return irMaisuu;
    }

    public void setIrMaisuu(String pIrMaisuu) {
        irMaisuu = pIrMaisuu;
    }

    private String irBikou1;

    public String getIrBikou1() {
        return irBikou1;
    }

    public void setIrBikou1(String pIrBikou1) {
        irBikou1 = pIrBikou1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
