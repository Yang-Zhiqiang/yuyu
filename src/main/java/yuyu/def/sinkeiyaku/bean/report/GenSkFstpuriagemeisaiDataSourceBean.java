package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）初回保険料クレジットカード扱売上請求明細票帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkFstpuriagemeisaiDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkFstpuriagemeisaiDataSourceBean() {
    }


    private Integer irRenno;


    public Integer getIrRenno() {
        return irRenno;
    }


    public void setIrRenno(Integer pIrRenno) {
        irRenno = pIrRenno;
    }


    private String irCardbrand;


    public String getIrCardbrand() {
        return irCardbrand;
    }


    public void setIrCardbrand(String pIrCardbrand) {
        irCardbrand = pIrCardbrand;
    }


    private String irDatasousinymd;


    public String getIrDatasousinymd() {
        return irDatasousinymd;
    }


    public void setIrDatasousinymd(String pIrDatasousinymd) {
        irDatasousinymd = pIrDatasousinymd;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private BizCurrency irRsgaku;


    public BizCurrency getIrRsgaku() {
        return irRsgaku;
    }


    public void setIrRsgaku(BizCurrency pIrRsgaku) {
        irRsgaku = pIrRsgaku;
    }


    private String irRyosyuymd;


    public String getIrRyosyuymd() {
        return irRyosyuymd;
    }


    public void setIrRyosyuymd(String pIrRyosyuymd) {
        irRyosyuymd = pIrRyosyuymd;
    }


    private String irHknsyurui;


    public String getIrHknsyurui() {
        return irHknsyurui;
    }


    public void setIrHknsyurui(String pIrHknsyurui) {
        irHknsyurui = pIrHknsyurui;
    }


    private String irKykymd;


    public String getIrKykymd() {
        return irKykymd;
    }


    public void setIrKykymd(String pIrKykymd) {
        irKykymd = pIrKykymd;
    }


    private String irSeirituymd;


    public String getIrSeirituymd() {
        return irSeirituymd;
    }


    public void setIrSeirituymd(String pIrSeirituymd) {
        irSeirituymd = pIrSeirituymd;
    }


    private String irCreditkessaiyouno;


    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }


    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
    }


    private BizNumber irKensuugoukei;


    public BizNumber getIrKensuugoukei() {
        return irKensuugoukei;
    }


    public void setIrKensuugoukei(BizNumber pIrKensuugoukei) {
        irKensuugoukei = pIrKensuugoukei;
    }


    private BizCurrency irGoukeikingk;


    public BizCurrency getIrGoukeikingk() {
        return irGoukeikingk;
    }


    public void setIrGoukeikingk(BizCurrency pIrGoukeikingk) {
        irGoukeikingk = pIrGoukeikingk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
