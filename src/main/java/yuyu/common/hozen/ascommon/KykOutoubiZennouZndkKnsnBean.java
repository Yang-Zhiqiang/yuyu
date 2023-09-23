package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 契約応当日前納残高（換算通貨）Beanクラス
 */
public class KykOutoubiZennouZndkKnsnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kykOutoubi;

    private BizCurrency zennouZndkKnsnTk;

    private BizCurrency jyuutoumaeZennouZndkKnsnTk;

    private BizCurrency znnurrttkyZnnuzndkTuk;

    private BizCurrency znnurrttkyjytmaeZnnuzndkTuk;

    private BizNumber zennouZndkKnsnKawaseRate;

    private C_UmuKbn getKawaseRateUmuKbn;

    public BizDate getKykOutoubi() {
        return kykOutoubi;
    }

    public void setKykOutoubi(BizDate pKykOutoubi) {
        kykOutoubi = pKykOutoubi;
    }

    public BizCurrency getZennouZndkKnsnTk() {
        return zennouZndkKnsnTk;
    }

    public void setZennouZndkKnsnTk(BizCurrency pZennouZndkKnsnTk) {
        zennouZndkKnsnTk = pZennouZndkKnsnTk;
    }

    public BizCurrency getJyuutoumaeZennouZndkKnsnTk() {
        return jyuutoumaeZennouZndkKnsnTk;
    }

    public void setJyuutoumaeZennouZndkKnsnTk(BizCurrency pJyuutoumaeZennouZndkKnsnTk) {
        jyuutoumaeZennouZndkKnsnTk = pJyuutoumaeZennouZndkKnsnTk;
    }

    public BizCurrency getZnnurrttkyZnnuzndkTuk() {
        return znnurrttkyZnnuzndkTuk;
    }

    public void setZnnurrttkyZnnuzndkTuk(BizCurrency pZnnurrttkyZnnuzndkTuk) {
        znnurrttkyZnnuzndkTuk = pZnnurrttkyZnnuzndkTuk;
    }

    public BizCurrency getZnnurrttkyjytmaeZnnuzndkTuk() {
        return znnurrttkyjytmaeZnnuzndkTuk;
    }

    public void setZnnurrttkyjytmaeZnnuzndkTuk(BizCurrency pZnnurrttkyjytmaeZnnuzndkTuk) {
        znnurrttkyjytmaeZnnuzndkTuk = pZnnurrttkyjytmaeZnnuzndkTuk;
    }

    public BizNumber getZennouZndkKnsnKawaseRate() {
        return zennouZndkKnsnKawaseRate;
    }

    public void setZennouZndkKnsnKawaseRate(BizNumber pZennouZndkKnsnKawaseRate) {
        zennouZndkKnsnKawaseRate = pZennouZndkKnsnKawaseRate;
    }

    public C_UmuKbn getGetKawaseRateUmuKbn() {
        return getKawaseRateUmuKbn;
    }

    public void setGetKawaseRateUmuKbn(C_UmuKbn pGetKawaseRateUmuKbn) {
        getKawaseRateUmuKbn = pGetKawaseRateUmuKbn;
    }
}
