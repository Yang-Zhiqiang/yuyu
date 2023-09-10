package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）削除契約明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSakujokeiyakumeisailistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkSakujokeiyakumeisailistDataSourceBean() {
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
    }


    private String irOyadrtencd;


    public String getIrOyadrtencd() {
        return irOyadrtencd;
    }


    public void setIrOyadrtencd(String pIrOyadrtencd) {
        irOyadrtencd = pIrOyadrtencd;
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


    private String irKnjyymd;


    public String getIrKnjyymd() {
        return irKnjyymd;
    }


    public void setIrKnjyymd(String pIrKnjyymd) {
        irKnjyymd = pIrKnjyymd;
    }


    private String irNyknsyoriymd;


    public String getIrNyknsyoriymd() {
        return irNyknsyoriymd;
    }


    public void setIrNyknsyoriymd(String pIrNyknsyoriymd) {
        irNyknsyoriymd = pIrNyknsyoriymd;
    }


    private String irKouzano;


    public String getIrKouzano() {
        return irKouzano;
    }


    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }


    private String irHrkmirnincd;


    public String getIrHrkmirnincd() {
        return irHrkmirnincd;
    }


    public void setIrHrkmirnincd(String pIrHrkmirnincd) {
        irHrkmirnincd = pIrHrkmirnincd;
    }


    private BizNumber irKensuugoukei;


    public BizNumber getIrKensuugoukei() {
        return irKensuugoukei;
    }


    public void setIrKensuugoukei(BizNumber pIrKensuugoukei) {
        irKensuugoukei = pIrKensuugoukei;
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
