package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）入金内容不備契約明細帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMiseirijiyuuNyuukinhubiDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkMiseirijiyuuNyuukinhubiDataSourceBean() {
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
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


    private String irSknnkaisiymd;


    public String getIrSknnkaisiymd() {
        return irSknnkaisiymd;
    }


    public void setIrSknnkaisiymd(String pIrSknnkaisiymd) {
        irSknnkaisiymd = pIrSknnkaisiymd;
    }


    private String irKykymd;


    public String getIrKykymd() {
        return irKykymd;
    }


    public void setIrKykymd(String pIrKykymd) {
        irKykymd = pIrKykymd;
    }


    private String irRyosyuymd;


    public String getIrRyosyuymd() {
        return irRyosyuymd;
    }


    public void setIrRyosyuymd(String pIrRyosyuymd) {
        irRyosyuymd = pIrRyosyuymd;
    }


    private String irNyuukinjoutaikbn;


    public String getIrNyuukinjoutaikbn() {
        return irNyuukinjoutaikbn;
    }


    public void setIrNyuukinjoutaikbn(String pIrNyuukinjoutaikbn) {
        irNyuukinjoutaikbn = pIrNyuukinjoutaikbn;
    }


    private BizCurrency irRsgakuyen;


    public BizCurrency getIrRsgakuyen() {
        return irRsgakuyen;
    }


    public void setIrRsgakuyen(BizCurrency pIrRsgakuyen) {
        irRsgakuyen = pIrRsgakuyen;
    }


    private BizCurrency irRsgaku;


    public BizCurrency getIrRsgaku() {
        return irRsgaku;
    }


    public void setIrRsgaku(BizCurrency pIrRsgaku) {
        irRsgaku = pIrRsgaku;
    }


    private BizNumber irMiseirijiyuukensuusyoukei;


    public BizNumber getIrMiseirijiyuukensuusyoukei() {
        return irMiseirijiyuukensuusyoukei;
    }


    public void setIrMiseirijiyuukensuusyoukei(BizNumber pIrMiseirijiyuukensuusyoukei) {
        irMiseirijiyuukensuusyoukei = pIrMiseirijiyuukensuusyoukei;
    }


    private BizCurrency irMiseirijiyuukngkskeiyen;


    public BizCurrency getIrMiseirijiyuukngkskeiyen() {
        return irMiseirijiyuukngkskeiyen;
    }


    public void setIrMiseirijiyuukngkskeiyen(BizCurrency pIrMiseirijiyuukngkskeiyen) {
        irMiseirijiyuukngkskeiyen = pIrMiseirijiyuukngkskeiyen;
    }


    private BizCurrency irMiseirijiyuukngksyoukei;


    public BizCurrency getIrMiseirijiyuukngksyoukei() {
        return irMiseirijiyuukngksyoukei;
    }


    public void setIrMiseirijiyuukngksyoukei(BizCurrency pIrMiseirijiyuukngksyoukei) {
        irMiseirijiyuukngksyoukei = pIrMiseirijiyuukngksyoukei;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
