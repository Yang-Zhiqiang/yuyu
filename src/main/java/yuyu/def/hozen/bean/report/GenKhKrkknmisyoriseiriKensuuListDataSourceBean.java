package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）仮受金整理未処理件数リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKrkknmisyoriseiriKensuuListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKrkknmisyoriseiriKensuuListDataSourceBean() {
    }

    private Integer irKzhurikensuu;

    public Integer getIrKzhurikensuu() {
        return irKzhurikensuu;
    }

    public void setIrKzhurikensuu(Integer pIrKzhurikensuu) {
        irKzhurikensuu = pIrKzhurikensuu;
    }

    private Integer irKzhurikensuutyouki;

    public Integer getIrKzhurikensuutyouki() {
        return irKzhurikensuutyouki;
    }

    public void setIrKzhurikensuutyouki(Integer pIrKzhurikensuutyouki) {
        irKzhurikensuutyouki = pIrKzhurikensuutyouki;
    }

    private Integer irGoukeikensuu;

    public Integer getIrGoukeikensuu() {
        return irGoukeikensuu;
    }

    public void setIrGoukeikensuu(Integer pIrGoukeikensuu) {
        irGoukeikensuu = pIrGoukeikensuu;
    }

    private Integer irGoukeikensuutyouki;

    public Integer getIrGoukeikensuutyouki() {
        return irGoukeikensuutyouki;
    }

    public void setIrGoukeikensuutyouki(Integer pIrGoukeikensuutyouki) {
        irGoukeikensuutyouki = pIrGoukeikensuutyouki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
