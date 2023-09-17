package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）外貨ＦＢ送金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbSoukinMeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbSoukinMeisaiListDataSourceBean() {
    }

    private C_Tantositucd irTantousitucd;

    public C_Tantositucd getIrTantousitucd() {
        return irTantousitucd;
    }

    public void setIrTantousitucd(C_Tantositucd pIrTantousitucd) {
        irTantousitucd = pIrTantousitucd;
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private C_ShrhousiteiKbn irShrhousiteikbn;

    public C_ShrhousiteiKbn getIrShrhousiteikbn() {
        return irShrhousiteikbn;
    }

    public void setIrShrhousiteikbn(C_ShrhousiteiKbn pIrShrhousiteikbn) {
        irShrhousiteikbn = pIrShrhousiteikbn;
    }

    private String irHrkmsiteiymd;

    public String getIrHrkmsiteiymd() {
        return irHrkmsiteiymd;
    }

    public void setIrHrkmsiteiymd(String pIrHrkmsiteiymd) {
        irHrkmsiteiymd = pIrHrkmsiteiymd;
    }

    private C_Gkgyoumucd irGkgyoumucd;

    public C_Gkgyoumucd getIrGkgyoumucd() {
        return irGkgyoumucd;
    }

    public void setIrGkgyoumucd(C_Gkgyoumucd pIrGkgyoumucd) {
        irGkgyoumucd = pIrGkgyoumucd;
    }

    private String irGkkokyakucd;

    public String getIrGkkokyakucd() {
        return irGkkokyakucd;
    }

    public void setIrGkkokyakucd(String pIrGkkokyakucd) {
        irGkkokyakucd = pIrGkkokyakucd;
    }

    private String irBankcd;

    public String getIrBankcd() {
        return irBankcd;
    }

    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }

    private String irBanknmej;

    public String getIrBanknmej() {
        return irBanknmej;
    }

    public void setIrBanknmej(String pIrBanknmej) {
        irBanknmej = pIrBanknmej;
    }

    private String irSitencd;

    public String getIrSitencd() {
        return irSitencd;
    }

    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }

    private String irSitennmej;

    public String getIrSitennmej() {
        return irSitennmej;
    }

    public void setIrSitennmej(String pIrSitennmej) {
        irSitennmej = pIrSitennmej;
    }

    private String irKouzano;

    public String getIrKouzano() {
        return irKouzano;
    }

    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }

    private String irKzmeiginmej;

    public String getIrKzmeiginmej() {
        return irKzmeiginmej;
    }

    public void setIrKzmeiginmej(String pIrKzmeiginmej) {
        irKzmeiginmej = pIrKzmeiginmej;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private C_Tuukasyu irShrtuukasyu;

    public C_Tuukasyu getIrShrtuukasyu() {
        return irShrtuukasyu;
    }

    public void setIrShrtuukasyu(C_Tuukasyu pIrShrtuukasyu) {
        irShrtuukasyu = pIrShrtuukasyu;
    }

    private BizCurrency irSoukingk;

    public BizCurrency getIrSoukingk() {
        return irSoukingk;
    }

    public void setIrSoukingk(BizCurrency pIrSoukingk) {
        irSoukingk = pIrSoukingk;
    }

    private BizCurrency irSoukingkkei;

    public BizCurrency getIrSoukingkkei() {
        return irSoukingkkei;
    }

    public void setIrSoukingkkei(BizCurrency pIrSoukingkkei) {
        irSoukingkkei = pIrSoukingkkei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
