package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）ＦＢ送金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbSoukinMeisaiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzFbSoukinMeisaiListDataSourceBean() {
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

    private String irSoukinhukabank;

    public String getIrSoukinhukabank() {
        return irSoukinhukabank;
    }

    public void setIrSoukinhukabank(String pIrSoukinhukabank) {
        irSoukinhukabank = pIrSoukinhukabank;
    }

    private C_Gyoumucd irGyoumucd;

    public C_Gyoumucd getIrGyoumucd() {
        return irGyoumucd;
    }

    public void setIrGyoumucd(C_Gyoumucd pIrGyoumucd) {
        irGyoumucd = pIrGyoumucd;
    }

    private String irSyoricd;

    public String getIrSyoricd() {
        return irSyoricd;
    }

    public void setIrSyoricd(String pIrSyoricd) {
        irSyoricd = pIrSyoricd;
    }

    private String irSyorinm;

    public String getIrSyorinm() {
        return irSyorinm;
    }

    public void setIrSyorinm(String pIrSyorinm) {
        irSyorinm = pIrSyorinm;
    }

    private String irSyorisosikicd;

    public String getIrSyorisosikicd() {
        return irSyorisosikicd;
    }

    public void setIrSyorisosikicd(String pIrSyorisosikicd) {
        irSyorisosikicd = pIrSyorisosikicd;
    }

    private String irKokyakucd;

    public String getIrKokyakucd() {
        return irKokyakucd;
    }

    public void setIrKokyakucd(String pIrKokyakucd) {
        irKokyakucd = pIrKokyakucd;
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

    private String irKznmkn;

    public String getIrKznmkn() {
        return irKznmkn;
    }

    public void setIrKznmkn(String pIrKznmkn) {
        irKznmkn = pIrKznmkn;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
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
