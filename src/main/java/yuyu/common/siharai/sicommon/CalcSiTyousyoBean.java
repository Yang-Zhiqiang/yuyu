package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払調書金額計算Beanクラス
 */
public class CalcSiTyousyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn outUm;

    private BizCurrency hokenkingaku;

    private BizCurrency warimasihokenkingaku;

    private BizCurrency miharaihaitou;

    private BizCurrency kasitukikingaku;

    private BizCurrency miharaikomip;

    private BizCurrency zennouptou;

    private BizCurrency sasihikis;

    private BizCurrency kibaraikomip;


    CalcSiTyousyoBean(){
        hokenkingaku = BizCurrency.valueOf(0);
        warimasihokenkingaku = BizCurrency.valueOf(0);
        miharaihaitou = BizCurrency.valueOf(0);
        kasitukikingaku = BizCurrency.valueOf(0);
        miharaikomip = BizCurrency.valueOf(0);
        zennouptou = BizCurrency.valueOf(0);
        sasihikis = BizCurrency.valueOf(0);
        kibaraikomip = BizCurrency.valueOf(0);
    }

    public C_UmuKbn getOutUm() {
        return outUm;
    }

    public void setOutUm(C_UmuKbn outUm) {
        this.outUm = outUm;
    }

    public BizCurrency getHokenkingaku() {
        return hokenkingaku;
    }

    public void setHokenkingaku(BizCurrency hokenkingaku) {
        this.hokenkingaku = hokenkingaku;
    }

    public BizCurrency getWarimasihokenkingaku() {
        return warimasihokenkingaku;
    }

    public void setWarimasihokenkingaku(BizCurrency warimasihokenkingaku) {
        this.warimasihokenkingaku = warimasihokenkingaku;
    }

    public BizCurrency getMiharaihaitou() {
        return miharaihaitou;
    }

    public void setMiharaihaitou(BizCurrency miharaihaitou) {
        this.miharaihaitou = miharaihaitou;
    }

    public BizCurrency getKasitukikingaku() {
        return kasitukikingaku;
    }

    public void setKasitukikingaku(BizCurrency kasitukikingaku) {
        this.kasitukikingaku = kasitukikingaku;
    }

    public BizCurrency getMiharaikomip() {
        return miharaikomip;
    }

    public void setMiharaikomip(BizCurrency miharaikomip) {
        this.miharaikomip = miharaikomip;
    }

    public BizCurrency getZennouptou() {
        return zennouptou;
    }

    public void setZennouptou(BizCurrency zennouptou) {
        this.zennouptou = zennouptou;
    }

    public BizCurrency getSasihikis() {
        return sasihikis;
    }

    public void setSasihikis(BizCurrency sasihikis) {
        this.sasihikis = sasihikis;
    }

    public BizCurrency getKibaraikomip() {
        return kibaraikomip;
    }

    public void setKibaraikomip(BizCurrency kibaraikomip) {
        this.kibaraikomip = kibaraikomip;
    }

}
