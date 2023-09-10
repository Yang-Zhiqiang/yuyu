package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）仮受（普保Ｐ過金）１ヵ月超経過リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKariukehuhopkakinDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenSkKariukehuhopkakinDataSourceBean() {
    }

    private String irMosno;

    public String getIrMosno() {
        return irMosno;
    }

    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }

    private String irSuitouymdseireki;

    public String getIrSuitouymdseireki() {
        return irSuitouymdseireki;
    }

    public void setIrSuitouymdseireki(String pIrSuitouymdseireki) {
        irSuitouymdseireki = pIrSuitouymdseireki;
    }

    private String irHnknriyuukbn;

    public String getIrHnknriyuukbn() {
        return irHnknriyuukbn;
    }

    public void setIrHnknriyuukbn(String pIrHnknriyuukbn) {
        irHnknriyuukbn = pIrHnknriyuukbn;
    }

    private BizCurrency irHnkngkkngk;

    public BizCurrency getIrHnkngkkngk() {
        return irHnkngkkngk;
    }

    public void setIrHnkngkkngk(BizCurrency pIrHnkngkkngk) {
        irHnkngkkngk = pIrHnkngkkngk;
    }

    private String irDrtennmkj;

    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }

    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }

    private String irAatukaikojincd;

    public String getIrAatukaikojincd() {
        return irAatukaikojincd;
    }

    public void setIrAatukaikojincd(String pIrAatukaikojincd) {
        irAatukaikojincd = pIrAatukaikojincd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
