package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）申込書類送付状況リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMossyoruijyoukyoulistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkMossyoruijyoukyoulistDataSourceBean() {
    }


    private String irMostokusokuumu;


    public String getIrMostokusokuumu() {
        return irMostokusokuumu;
    }


    public void setIrMostokusokuumu(String pIrMostokusokuumu) {
        irMostokusokuumu = pIrMostokusokuumu;
    }


    private String irDrtennmkj;


    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }


    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }


    private String irKnjyymd;


    public String getIrKnjyymd() {
        return irKnjyymd;
    }


    public void setIrKnjyymd(String pIrKnjyymd) {
        irKnjyymd = pIrKnjyymd;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irHrkmirninnm;


    public String getIrHrkmirninnm() {
        return irHrkmirninnm;
    }


    public void setIrHrkmirninnm(String pIrHrkmirninnm) {
        irHrkmirninnm = pIrHrkmirninnm;
    }


    private String irBanknmkj;


    public String getIrBanknmkj() {
        return irBanknmkj;
    }


    public void setIrBanknmkj(String pIrBanknmkj) {
        irBanknmkj = pIrBanknmkj;
    }


    private String irSitennmkj;


    public String getIrSitennmkj() {
        return irSitennmkj;
    }


    public void setIrSitennmkj(String pIrSitennmkj) {
        irSitennmkj = pIrSitennmkj;
    }


    private BizCurrency irHrkmgk;


    public BizCurrency getIrHrkmgk() {
        return irHrkmgk;
    }


    public void setIrHrkmgk(BizCurrency pIrHrkmgk) {
        irHrkmgk = pIrHrkmgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
