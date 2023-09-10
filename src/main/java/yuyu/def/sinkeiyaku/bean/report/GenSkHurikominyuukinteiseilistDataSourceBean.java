package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）振込入金訂正データリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHurikominyuukinteiseilistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkHurikominyuukinteiseilistDataSourceBean() {
    }


    private String irBankcd;


    public String getIrBankcd() {
        return irBankcd;
    }


    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }


    private String irSitencd;


    public String getIrSitencd() {
        return irSitencd;
    }


    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }


    private C_YokinKbn irYokinkbn;


    public C_YokinKbn getIrYokinkbn() {
        return irYokinkbn;
    }


    public void setIrYokinkbn(C_YokinKbn pIrYokinkbn) {
        irYokinkbn = pIrYokinkbn;
    }


    private String irKouzano;


    public String getIrKouzano() {
        return irKouzano;
    }


    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }


    private String irHrkmirninnm48;


    public String getIrHrkmirninnm48() {
        return irHrkmirninnm48;
    }


    public void setIrHrkmirninnm48(String pIrHrkmirninnm48) {
        irHrkmirninnm48 = pIrHrkmirninnm48;
    }


    private BizCurrency irNyknkkngk;


    public BizCurrency getIrNyknkkngk() {
        return irNyknkkngk;
    }


    public void setIrNyknkkngk(BizCurrency pIrNyknkkngk) {
        irNyknkkngk = pIrNyknkkngk;
    }


    private String irKsnymd;


    public String getIrKsnymd() {
        return irKsnymd;
    }


    public void setIrKsnymd(String pIrKsnymd) {
        irKsnymd = pIrKsnymd;
    }


    private String irKnjyymd;


    public String getIrKnjyymd() {
        return irKnjyymd;
    }


    public void setIrKnjyymd(String pIrKnjyymd) {
        irKnjyymd = pIrKnjyymd;
    }


    private String irIribaraikbn;


    public String getIrIribaraikbn() {
        return irIribaraikbn;
    }


    public void setIrIribaraikbn(String pIrIribaraikbn) {
        irIribaraikbn = pIrIribaraikbn;
    }


    private String irTrhkkbn;


    public String getIrTrhkkbn() {
        return irTrhkkbn;
    }


    public void setIrTrhkkbn(String pIrTrhkkbn) {
        irTrhkkbn = pIrTrhkkbn;
    }


    private String irHrkmirnincd;


    public String getIrHrkmirnincd() {
        return irHrkmirnincd;
    }


    public void setIrHrkmirnincd(String pIrHrkmirnincd) {
        irHrkmirnincd = pIrHrkmirnincd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
