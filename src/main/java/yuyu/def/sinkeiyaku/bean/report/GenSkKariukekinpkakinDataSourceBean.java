package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）仮受金（Ｐ過金）明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKariukekinpkakinDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkKariukekinpkakinDataSourceBean() {
    }


    private C_Tuukasyu irTuukasyu;


    public C_Tuukasyu getIrTuukasyu() {
        return irTuukasyu;
    }


    public void setIrTuukasyu(C_Tuukasyu pIrTuukasyu) {
        irTuukasyu = pIrTuukasyu;
    }


    private String irSyuukeitani;


    public String getIrSyuukeitani() {
        return irSyuukeitani;
    }


    public void setIrSyuukeitani(String pIrSyuukeitani) {
        irSyuukeitani = pIrSyuukeitani;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irKyknmkn;


    public String getIrKyknmkn() {
        return irKyknmkn;
    }


    public void setIrKyknmkn(String pIrKyknmkn) {
        irKyknmkn = pIrKyknmkn;
    }


    private String irRyosyuymd;


    public String getIrRyosyuymd() {
        return irRyosyuymd;
    }


    public void setIrRyosyuymd(String pIrRyosyuymd) {
        irRyosyuymd = pIrRyosyuymd;
    }


    private String irSuitouymd;


    public String getIrSuitouymd() {
        return irSuitouymd;
    }


    public void setIrSuitouymd(String pIrSuitouymd) {
        irSuitouymd = pIrSuitouymd;
    }


    private BizCurrency irPkakingkyen;


    public BizCurrency getIrPkakingkyen() {
        return irPkakingkyen;
    }


    public void setIrPkakingkyen(BizCurrency pIrPkakingkyen) {
        irPkakingkyen = pIrPkakingkyen;
    }


    private BizCurrency irPkakingk;


    public BizCurrency getIrPkakingk() {
        return irPkakingk;
    }


    public void setIrPkakingk(BizCurrency pIrPkakingk) {
        irPkakingk = pIrPkakingk;
    }


    private BizNumber irKensuugoukei;


    public BizNumber getIrKensuugoukei() {
        return irKensuugoukei;
    }


    public void setIrKensuugoukei(BizNumber pIrKensuugoukei) {
        irKensuugoukei = pIrKensuugoukei;
    }


    private BizCurrency irKingakugoukeiyen;


    public BizCurrency getIrKingakugoukeiyen() {
        return irKingakugoukeiyen;
    }


    public void setIrKingakugoukeiyen(BizCurrency pIrKingakugoukeiyen) {
        irKingakugoukeiyen = pIrKingakugoukeiyen;
    }


    private BizCurrency irKingakugoukei;


    public BizCurrency getIrKingakugoukei() {
        return irKingakugoukei;
    }


    public void setIrKingakugoukei(BizCurrency pIrKingakugoukei) {
        irKingakugoukei = pIrKingakugoukei;
    }


    private BizNumber irYenkansantkykwsrate;


    public BizNumber getIrYenkansantkykwsrate() {
        return irYenkansantkykwsrate;
    }


    public void setIrYenkansantkykwsrate(BizNumber pIrYenkansantkykwsrate) {
        irYenkansantkykwsrate = pIrYenkansantkykwsrate;
    }


    private BizCurrency irYenkansanpkakingkgoukei;


    public BizCurrency getIrYenkansanpkakingkgoukei() {
        return irYenkansanpkakingkgoukei;
    }


    public void setIrYenkansanpkakingkgoukei(BizCurrency pIrYenkansanpkakingkgoukei) {
        irYenkansanpkakingkgoukei = pIrYenkansanpkakingkgoukei;
    }


    private BizCurrency irKawasesasoneki;


    public BizCurrency getIrKawasesasoneki() {
        return irKawasesasoneki;
    }


    public void setIrKawasesasoneki(BizCurrency pIrKawasesasoneki) {
        irKawasesasoneki = pIrKawasesasoneki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
