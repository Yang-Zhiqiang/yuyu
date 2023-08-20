package yuyu.def.suuri.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （数理）配当金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrHaitoukinMeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenSrHaitoukinMeisaiListDataSourceBean() {
    }

    private String irKbnkeirisegcd;

    public String getIrKbnkeirisegcd() {
        return irKbnkeirisegcd;
    }

    public void setIrKbnkeirisegcd(String pIrKbnkeirisegcd) {
        irKbnkeirisegcd = pIrKbnkeirisegcd;
    }

    private String irSeg;

    public String getIrSeg() {
        return irSeg;
    }

    public void setIrSeg(String pIrSeg) {
        irSeg = pIrSeg;
    }

    private String irHknsyurui;

    public String getIrHknsyurui() {
        return irHknsyurui;
    }

    public void setIrHknsyurui(String pIrHknsyurui) {
        irHknsyurui = pIrHknsyurui;
    }

    private String irSyukeiyakusyuruicd;

    public String getIrSyukeiyakusyuruicd() {
        return irSyukeiyakusyuruicd;
    }

    public void setIrSyukeiyakusyuruicd(String pIrSyukeiyakusyuruicd) {
        irSyukeiyakusyuruicd = pIrSyukeiyakusyuruicd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
