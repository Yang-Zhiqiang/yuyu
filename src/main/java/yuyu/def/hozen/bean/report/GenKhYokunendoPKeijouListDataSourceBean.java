package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）翌年度保険料計上リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYokunendoPKeijouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhYokunendoPKeijouListDataSourceBean() {
    }

    private String irKbnkeiribetugoukei;

    public String getIrKbnkeiribetugoukei() {
        return irKbnkeiribetugoukei;
    }

    public void setIrKbnkeiribetugoukei(String pIrKbnkeiribetugoukei) {
        irKbnkeiribetugoukei = pIrKbnkeiribetugoukei;
    }

    private String irHrkkaisuubetugoukei;

    public String getIrHrkkaisuubetugoukei() {
        return irHrkkaisuubetugoukei;
    }

    public void setIrHrkkaisuubetugoukei(String pIrHrkkaisuubetugoukei) {
        irHrkkaisuubetugoukei = pIrHrkkaisuubetugoukei;
    }

    private String irKbnkeiri;

    public String getIrKbnkeiri() {
        return irKbnkeiri;
    }

    public void setIrKbnkeiri(String pIrKbnkeiri) {
        irKbnkeiri = pIrKbnkeiri;
    }

    private C_Hrkkaisuu irHrkkaisuu;

    public C_Hrkkaisuu getIrHrkkaisuu() {
        return irHrkkaisuu;
    }

    public void setIrHrkkaisuu(C_Hrkkaisuu pIrHrkkaisuu) {
        irHrkkaisuu = pIrHrkkaisuu;
    }

    private BizDateY irKeiyakunendo;

    public BizDateY getIrKeiyakunendo() {
        return irKeiyakunendo;
    }

    public void setIrKeiyakunendo(BizDateY pIrKeiyakunendo) {
        irKeiyakunendo = pIrKeiyakunendo;
    }

    private Integer irHoyuukensuu;

    public Integer getIrHoyuukensuu() {
        return irHoyuukensuu;
    }

    public void setIrHoyuukensuu(Integer pIrHoyuukensuu) {
        irHoyuukensuu = pIrHoyuukensuu;
    }

    private BizCurrency irIkthriyknndp;

    public BizCurrency getIrIkthriyknndp() {
        return irIkthriyknndp;
    }

    public void setIrIkthriyknndp(BizCurrency pIrIkthriyknndp) {
        irIkthriyknndp = pIrIkthriyknndp;
    }

    private BizCurrency irKjtmaeyknndp;

    public BizCurrency getIrKjtmaeyknndp() {
        return irKjtmaeyknndp;
    }

    public void setIrKjtmaeyknndp(BizCurrency pIrKjtmaeyknndp) {
        irKjtmaeyknndp = pIrKjtmaeyknndp;
    }

    private BizCurrency irYknndpgoukei;

    public BizCurrency getIrYknndpgoukei() {
        return irYknndpgoukei;
    }

    public void setIrYknndpgoukei(BizCurrency pIrYknndpgoukei) {
        irYknndpgoukei = pIrYknndpgoukei;
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
