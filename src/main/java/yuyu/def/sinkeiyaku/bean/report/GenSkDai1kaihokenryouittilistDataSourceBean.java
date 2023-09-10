package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）第１回保険料一致リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkDai1kaihokenryouittilistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkDai1kaihokenryouittilistDataSourceBean() {
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
    }


    private String irJigyouhiutiwakecd;


    public String getIrJigyouhiutiwakecd() {
        return irJigyouhiutiwakecd;
    }


    public void setIrJigyouhiutiwakecd(String pIrJigyouhiutiwakecd) {
        irJigyouhiutiwakecd = pIrJigyouhiutiwakecd;
    }


    private String irDrtennmkj;


    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }


    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }


    private String irRyosyuymd;


    public String getIrRyosyuymd() {
        return irRyosyuymd;
    }


    public void setIrRyosyuymd(String pIrRyosyuymd) {
        irRyosyuymd = pIrRyosyuymd;
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


    private BizCurrency irDai1kaip;


    public BizCurrency getIrDai1kaip() {
        return irDai1kaip;
    }


    public void setIrDai1kaip(BizCurrency pIrDai1kaip) {
        irDai1kaip = pIrDai1kaip;
    }


    private BizCurrency irHrkmtsry;


    public BizCurrency getIrHrkmtsry() {
        return irHrkmtsry;
    }


    public void setIrHrkmtsry(BizCurrency pIrHrkmtsry) {
        irHrkmtsry = pIrHrkmtsry;
    }


    private String irNyknrnrkhyouymd;


    public String getIrNyknrnrkhyouymd() {
        return irNyknrnrkhyouymd;
    }


    public void setIrNyknrnrkhyouymd(String pIrNyknrnrkhyouymd) {
        irNyknrnrkhyouymd = pIrNyknrnrkhyouymd;
    }


    private String irSeiritujk;


    public String getIrSeiritujk() {
        return irSeiritujk;
    }


    public void setIrSeiritujk(String pIrSeiritujk) {
        irSeiritujk = pIrSeiritujk;
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


    private BizCurrency irDai1kaipgoukei;


    public BizCurrency getIrDai1kaipgoukei() {
        return irDai1kaipgoukei;
    }


    public void setIrDai1kaipgoukei(BizCurrency pIrDai1kaipgoukei) {
        irDai1kaipgoukei = pIrDai1kaipgoukei;
    }


    private BizCurrency irHrkmtsrygoukei;


    public BizCurrency getIrHrkmtsrygoukei() {
        return irHrkmtsrygoukei;
    }


    public void setIrHrkmtsrygoukei(BizCurrency pIrHrkmtsrygoukei) {
        irHrkmtsrygoukei = pIrHrkmtsrygoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
