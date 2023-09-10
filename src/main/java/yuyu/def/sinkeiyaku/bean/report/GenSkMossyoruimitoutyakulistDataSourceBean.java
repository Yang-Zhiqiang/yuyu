package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）申込書類未到着期間経過リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMossyoruimitoutyakulistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkMossyoruimitoutyakulistDataSourceBean() {
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
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


    private BizCurrency irNyknkkngk;


    public BizCurrency getIrNyknkkngk() {
        return irNyknkkngk;
    }


    public void setIrNyknkkngk(BizCurrency pIrNyknkkngk) {
        irNyknkkngk = pIrNyknkkngk;
    }


    private String irNyknrnrkhyouymd;


    public String getIrNyknrnrkhyouymd() {
        return irNyknrnrkhyouymd;
    }


    public void setIrNyknrnrkhyouymd(String pIrNyknrnrkhyouymd) {
        irNyknrnrkhyouymd = pIrNyknrnrkhyouymd;
    }


    private BizNumber irKensuugoukei5;


    public BizNumber getIrKensuugoukei5() {
        return irKensuugoukei5;
    }


    public void setIrKensuugoukei5(BizNumber pIrKensuugoukei5) {
        irKensuugoukei5 = pIrKensuugoukei5;
    }


    private BizCurrency irKingakugoukei;


    public BizCurrency getIrKingakugoukei() {
        return irKingakugoukei;
    }


    public void setIrKingakugoukei(BizCurrency pIrKingakugoukei) {
        irKingakugoukei = pIrKingakugoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
