package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HknKknKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算Beanクラス
 */
public class CalcHkShrKngkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency kihons;

    private BizCurrency kaiyakuhenreiknGk;

    private BizCurrency tmttKnGk;

    private BizCurrency hokenryoustGk;

    private BizCurrency sibousGk;

    private BizCurrency saigaisGk;

    private BizCurrency hokenknGk;

    private C_HknKknKbn hknKknKbn;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    private BizCurrency sbymdKaiyakuhenreiknGk;

    private BizCurrency sbymdTmttKnGk;

    private BizCurrency pruikei;

    public CalcHkShrKngkBean() {

        kihons = BizCurrency.valueOf(0);
        kaiyakuhenreiknGk = BizCurrency.valueOf(0);
        tmttKnGk = BizCurrency.valueOf(0);
        hokenryoustGk = BizCurrency.valueOf(0);
        sibousGk = BizCurrency.valueOf(0);
        saigaisGk = BizCurrency.valueOf(0);
        hokenknGk = BizCurrency.valueOf(0);
        hknKknKbn = C_HknKknKbn.BLNK;
        teirituTmttkngk = BizCurrency.valueOf(0);
        sisuurendouTmttkngk = BizCurrency.valueOf(0);
        sbymdKaiyakuhenreiknGk = BizCurrency.valueOf(0);
        sbymdTmttKnGk = BizCurrency.valueOf(0);
        pruikei = BizCurrency.valueOf(0);
    }

    public BizCurrency getKihons() {
        return kihons;
    }

    public void setKihons(BizCurrency pKihons) {
        this.kihons = pKihons;
    }

    public BizCurrency getKaiyakuhenreiknGk() {
        return kaiyakuhenreiknGk;
    }

    public void setKaiyakuhenreiknGk(BizCurrency pKaiyakuhenreiknGk) {
        this.kaiyakuhenreiknGk = pKaiyakuhenreiknGk;
    }

    public BizCurrency getTmttKnGk() {
        return tmttKnGk;
    }

    public void setTmttKnGk(BizCurrency pTmttKnGk) {
        this.tmttKnGk = pTmttKnGk;
    }

    public BizCurrency getHokenryoustGk() {
        return hokenryoustGk;
    }

    public void setHokenryoustGk(BizCurrency pHokenryoustGk) {
        this.hokenryoustGk = pHokenryoustGk;
    }

    public BizCurrency getSibousGk() {
        return sibousGk;
    }

    public void setSibousGk(BizCurrency pSibousGk) {
        this.sibousGk = pSibousGk;
    }

    public BizCurrency getSaigaisGk() {
        return saigaisGk;
    }

    public void setSaigaisGk(BizCurrency pSaigaisGk) {
        this.saigaisGk = pSaigaisGk;
    }

    public BizCurrency getHokenknGk() {
        return hokenknGk;
    }

    public void setHokenknGk(BizCurrency pHokenknGk) {
        this.hokenknGk = pHokenknGk;
    }

    public C_HknKknKbn getHknKknKbn() {
        return hknKknKbn;
    }

    public void setHknKknKbn(C_HknKknKbn pHknKknKbn) {
        this.hknKknKbn = pHknKknKbn;
    }

    public BizCurrency getTeirituTmttkngk() {
        return teirituTmttkngk;
    }

    public void setTeirituTmttkngk(BizCurrency pTeirituTmttkngk) {
        this.teirituTmttkngk = pTeirituTmttkngk;
    }

    public BizCurrency getSisuurendouTmttkngk() {
        return sisuurendouTmttkngk;
    }

    public void setSisuurendouTmttkngk(BizCurrency pSisuurendouTmttkngk) {
        this.sisuurendouTmttkngk = pSisuurendouTmttkngk;
    }

    public BizCurrency getSbymdKaiyakuhenreiknGk() {
        return sbymdKaiyakuhenreiknGk;
    }

    public void setSbymdKaiyakuhenreiknGk(BizCurrency sbymdKaiyakuhenreiknGk) {
        this.sbymdKaiyakuhenreiknGk = sbymdKaiyakuhenreiknGk;
    }

    public BizCurrency getSbymdTmttKnGk() {
        return sbymdTmttKnGk;
    }

    public void setSbymdTmttKnGk(BizCurrency sbymdTmttKnGk) {
        this.sbymdTmttKnGk = sbymdTmttKnGk;
    }

    public BizCurrency getPruikei() {
        return pruikei;
    }

    public void setPruikei(BizCurrency pruikei) {
        this.pruikei = pruikei;
    }

}
