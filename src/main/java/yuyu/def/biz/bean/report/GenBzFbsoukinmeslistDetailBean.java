package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;

/**
 * （共通）ＦＢ送金明細リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinmeslistDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinmeslistDetailBean() {
    }

    private String irDensyskbnval;

    public String getIrDensyskbnval() {
        return irDensyskbnval;
    }

    public void setIrDensyskbnval(String pIrDensyskbnval) {
        irDensyskbnval = pIrDensyskbnval;
    }

    private String irDensyorikbnval;

    public String getIrDensyorikbnval() {
        return irDensyorikbnval;
    }

    public void setIrDensyorikbnval(String pIrDensyorikbnval) {
        irDensyorikbnval = pIrDensyorikbnval;
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

    private String irYokinsyurui;

    public String getIrYokinsyurui() {
        return irYokinsyurui;
    }

    public void setIrYokinsyurui(String pIrYokinsyurui) {
        irYokinsyurui = pIrYokinsyurui;
    }

    private String irKouzano;

    public String getIrKouzano() {
        return irKouzano;
    }

    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }

    private String irYokinsyanm;

    public String getIrYokinsyanm() {
        return irYokinsyanm;
    }

    public void setIrYokinsyanm(String pIrYokinsyanm) {
        irYokinsyanm = pIrYokinsyanm;
    }

    private C_DensysKbn irDensyskbn;

    public C_DensysKbn getIrDensyskbn() {
        return irDensyskbn;
    }

    public void setIrDensyskbn(C_DensysKbn pIrDensyskbn) {
        irDensyskbn = pIrDensyskbn;
    }

    private C_DensyoriKbn irDensyorikbn;

    public C_DensyoriKbn getIrDensyorikbn() {
        return irDensyorikbn;
    }

    public void setIrDensyorikbn(C_DensyoriKbn pIrDensyorikbn) {
        irDensyorikbn = pIrDensyorikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
