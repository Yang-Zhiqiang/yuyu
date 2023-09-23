package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金必要経費計算Beanクラス
 */
public class CalcHkHtykeihiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency htykeihi;

    private BizCurrency yenhtykeihi;

    private BizCurrency itjknhtykeihi;

    private BizCurrency yenitjknhtykeihi;

    private BizCurrency nkhtykeihi;

    private BizCurrency yennkhtykeihi;

    private BizCurrency shrkykhtykeihi;

    public CalcHkHtykeihiBean() {
        htykeihi = BizCurrency.valueOf(0);
        yenhtykeihi = BizCurrency.valueOf(0);
        itjknhtykeihi = BizCurrency.valueOf(0);
        yenitjknhtykeihi = BizCurrency.valueOf(0);
        nkhtykeihi = BizCurrency.valueOf(0);
        yennkhtykeihi = BizCurrency.valueOf(0);
        shrkykhtykeihi = BizCurrency.valueOf(0);
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        this.htykeihi = pHtykeihi;
    }

    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        this.yenhtykeihi = pYenhtykeihi;
    }

    public BizCurrency getItjknhtykeihi() {
        return itjknhtykeihi;
    }

    public void setItjknhtykeihi(BizCurrency pItjknhtykeihi) {
        this.itjknhtykeihi = pItjknhtykeihi;
    }

    public BizCurrency getYenitjknhtykeihi() {
        return yenitjknhtykeihi;
    }

    public void setYenitjknhtykeihi(BizCurrency pYenitjknhtykeihi) {
        this.yenitjknhtykeihi = pYenitjknhtykeihi;
    }

    public BizCurrency getNkhtykeihi() {
        return nkhtykeihi;
    }

    public void setNkhtykeihi(BizCurrency pNkhtykeihi) {
        this.nkhtykeihi = pNkhtykeihi;
    }

    public BizCurrency getYennkhtykeihi() {
        return yennkhtykeihi;
    }

    public void setYennkhtykeihi(BizCurrency pYennkhtykeihi) {
        this.yennkhtykeihi = pYennkhtykeihi;
    }

    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        this.shrkykhtykeihi = pShrkykhtykeihi;
    }

}
