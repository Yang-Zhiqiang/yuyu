package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）不備通知長文用帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHubituutityoubunDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkHubituutityoubunDataSourceBean() {
    }


    private String irSkhubikoumoku;


    public String getIrSkhubikoumoku() {
        return irSkhubikoumoku;
    }


    public void setIrSkhubikoumoku(String pIrSkhubikoumoku) {
        irSkhubikoumoku = pIrSkhubikoumoku;
    }


    private String irSkhubinaiyou;


    public String getIrSkhubinaiyou() {
        return irSkhubinaiyou;
    }


    public void setIrSkhubinaiyou(String pIrSkhubinaiyou) {
        irSkhubinaiyou = pIrSkhubinaiyou;
    }


    private String irSkseibisijinaiyou;


    public String getIrSkseibisijinaiyou() {
        return irSkseibisijinaiyou;
    }


    public void setIrSkseibisijinaiyou(String pIrSkseibisijinaiyou) {
        irSkseibisijinaiyou = pIrSkseibisijinaiyou;
    }


    private String irSkrenrakujikou;


    public String getIrSkrenrakujikou() {
        return irSkrenrakujikou;
    }


    public void setIrSkrenrakujikou(String pIrSkrenrakujikou) {
        irSkrenrakujikou = pIrSkrenrakujikou;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
