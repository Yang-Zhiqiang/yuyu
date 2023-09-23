package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 契約応当日前納残高Beanクラス
 */
public class KykOutoubiZennouZndkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kykOutoubi;

    private BizCurrency zennouZndk;

    private BizCurrency jyuutoumaeZennouZndk;

    public void setKykOutoubi(BizDate pKykOutoubi) {
        this.kykOutoubi = pKykOutoubi;
    }

    public BizDate getKykOutoubi() {
        return this.kykOutoubi;
    }

    public void setZennouZndk(BizCurrency pZennouZndk) {
        this.zennouZndk = pZennouZndk;
    }

    public BizCurrency getZennouZndk() {
        return this.zennouZndk;
    }

    public void setJyuutoumaeZennouZndk(BizCurrency pJyuutoumaeZennouZndk) {
        this.jyuutoumaeZennouZndk = pJyuutoumaeZennouZndk;
    }

    public BizCurrency getJyuutoumaeZennouZndk() {
        return this.jyuutoumaeZennouZndk;
    }

}
