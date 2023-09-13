package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）災害特伸契約保有リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSaigaitokusinKykhoyuuListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhSaigaitokusinKykhoyuuListDataSourceBean() {
    }

    private String irSyono11keta;

    public String getIrSyono11keta() {
        return irSyono11keta;
    }

    public void setIrSyono11keta(String pIrSyono11keta) {
        irSyono11keta = pIrSyono11keta;
    }

    private Integer irMisyuukaisuu;

    public Integer getIrMisyuukaisuu() {
        return irMisyuukaisuu;
    }

    public void setIrMisyuukaisuu(Integer pIrMisyuukaisuu) {
        irMisyuukaisuu = pIrMisyuukaisuu;
    }

    private BizDateYM irMisyukaisiym;

    public BizDateYM getIrMisyukaisiym() {
        return irMisyukaisiym;
    }

    public void setIrMisyukaisiym(BizDateYM pIrMisyukaisiym) {
        irMisyukaisiym = pIrMisyukaisiym;
    }

    private BizDate irTksnhasseiymd;

    public BizDate getIrTksnhasseiymd() {
        return irTksnhasseiymd;
    }

    public void setIrTksnhasseiymd(BizDate pIrTksnhasseiymd) {
        irTksnhasseiymd = pIrTksnhasseiymd;
    }

    private BizDate irTksnendymd;

    public BizDate getIrTksnendymd() {
        return irTksnendymd;
    }

    public void setIrTksnendymd(BizDate pIrTksnendymd) {
        irTksnendymd = pIrTksnendymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
