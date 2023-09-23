package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 通貨換算結果保険料Bean
 */
public class TuukaKnsnKekkaPBean {

    private BizCurrency rskingaku;

    private BizDate ryosyuKwsRateKjYmd;

    private BizNumber ryosyuKwsRate;

    public void setRskingaku(BizCurrency pRskingaku) {
        this.rskingaku = pRskingaku;
    }

    public BizCurrency getRskingaku() {
        return rskingaku;
    }

    public void setRyosyuKwsRateKjYmd(BizDate pRyosyuKwsRateKjYmd) {
        this.ryosyuKwsRateKjYmd = pRyosyuKwsRateKjYmd;
    }

    public BizDate getRyosyuKwsRateKjYmd() {
        return ryosyuKwsRateKjYmd;
    }

    public BizNumber getRyosyuKwsRate() {
        return ryosyuKwsRate;
    }

    public void setRyosyuKwsRate(BizNumber pRyosyuKwsRate) {
        this.ryosyuKwsRate = pRyosyuKwsRate;
    }
}
