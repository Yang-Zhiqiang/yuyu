package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 案内収納共通 契約応当日前納残高Beanクラス
 */
public class KykOutoubiZennouZndkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kykOutoubi;

    private BizCurrency zennouZndk;

    private BizCurrency jyuutoumaeZennouZndk;

    private BizCurrency znnurrttkyZnnuzndk;

    private BizCurrency znnurrttkyjytmaeZnnuzndk;

    public BizDate getKykOutoubi() {
        return kykOutoubi;
    }

    public void setKykOutoubi(BizDate pKykOutoubi) {
        kykOutoubi = pKykOutoubi;
    }

    public BizCurrency getZennouZndk() {
        return zennouZndk;
    }

    public void setZennouZndk(BizCurrency pZennouZndk) {
        zennouZndk = pZennouZndk;
    }

    public BizCurrency getJyuutoumaeZennouZndk() {
        return jyuutoumaeZennouZndk;
    }

    public void setJyuutoumaeZennouZndk(BizCurrency pJyuutoumaeZennouZndk) {
        jyuutoumaeZennouZndk = pJyuutoumaeZennouZndk;
    }

    public BizCurrency getZnnurrttkyZnnuzndk() {
        return znnurrttkyZnnuzndk;
    }

    public void setZnnurrttkyZnnuzndk(BizCurrency pZnnurrttkyZnnuzndk) {
        znnurrttkyZnnuzndk = pZnnurrttkyZnnuzndk;
    }

    public BizCurrency getZnnurrttkyjytmaeZnnuzndk() {
        return znnurrttkyjytmaeZnnuzndk;
    }

    public void setZnnurrttkyjytmaeZnnuzndk(BizCurrency pZnnurrttkyjytmaeZnnuzndk) {
        znnurrttkyjytmaeZnnuzndk = pZnnurrttkyjytmaeZnnuzndk;
    }
}
