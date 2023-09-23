package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * 契約保全 契約保全共通 単月保険料充当額計算
 */
public class KeisanPJyuutougk {

    private BizCurrency pJyuutougk;

    private BizNumber yoteiSinkeiyakuhiRitu;

    private BizNumber yoteiIjihiRitu;

    private BizNumber yoteiSyuukinhiRitu;

    private BizNumber kougakuWaribikiRitu;

    @Inject
    private static Logger logger;

    public KeisanPJyuutougk() {
        super();
    }

    public BizCurrency getPJyuutougk() {
        return pJyuutougk;
    }

    public BizNumber getYoteiSinkeiyakuhiRitu() {
        return yoteiSinkeiyakuhiRitu;
    }

    public BizNumber getYoteiIjihiRitu() {
        return yoteiIjihiRitu;
    }

    public BizNumber getYoteiSyuukinhiRitu() {
        return yoteiSyuukinhiRitu;
    }

    public BizNumber getKougakuWaribikiRitu() {
        return kougakuWaribikiRitu;
    }

    public C_ErrorKbn exec(BizCurrency pPkyktuuka,
        BizCurrency pPYen,
        int pHhknnen,
        int pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        BizDate pKykymd,
        BizDateYM pCalckijyunym) {

        logger.debug("▽ 単月保険料充当額計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;

        if (pPkyktuuka == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pPYen == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pHrkkknsmnkbn == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pKykymd == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pCalckijyunym == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 単月保険料充当額計算 終了");

            return kekkakbn;
        }

        int keikamon = 0;
        int keikanensuu = 0;

        if (BizDateUtil.compareYm(pCalckijyunym, pKykymd.getBizDateYM()) >= BizDateUtil.COMPARE_EQUAL) {

            keikamon = BizDateUtil.calcDifferenceMonths(pCalckijyunym, pKykymd.getBizDateYM());
            keikanensuu = keikamon / 12;
        }
        else {

            logger.debug("△ 単月保険料充当額計算 終了");

            return C_ErrorKbn.ERROR;
        }

        int hrkkkn = 0;

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pHrkkknsmnkbn)) {
            hrkkkn = pHrkkkn - pHhknnen;
        }
        else {
            hrkkkn = pHrkkkn;
        }

        BizNumber yoteiSinkeiyakuhiRituTemp = BizNumber.ZERO;

        if (keikanensuu < 10) {
            yoteiSinkeiyakuhiRituTemp = BizNumber.valueOf(0.0008).multiply(hrkkkn - 15);

            if (yoteiSinkeiyakuhiRituTemp.compareTo(BizNumber.ZERO) < 0) {

                yoteiSinkeiyakuhiRituTemp = BizNumber.ZERO;
            }
            yoteiSinkeiyakuhiRituTemp = BizNumber.valueOf(0.0315).add(BizNumber.valueOf(0.0045).multiply(hrkkkn - 10))
                .add(yoteiSinkeiyakuhiRituTemp);

            if (yoteiSinkeiyakuhiRituTemp.compareTo(BizNumber.valueOf(0.15)) > 0) {
                yoteiSinkeiyakuhiRituTemp = BizNumber.valueOf(0.15);
            }

        }

        BizNumber yoteiIjihiRituTemp = BizNumber.valueOf(0.02).add(BizNumber.valueOf(0.001).multiply(hrkkkn - 10));

        if (yoteiIjihiRituTemp.compareTo(BizNumber.valueOf(0.035)) > 0) {

            yoteiIjihiRituTemp = BizNumber.valueOf(0.035);
        }

        BizNumber yoteiSyuukinhiRituTemp = BizNumber.valueOf(0.015);

        BizNumber kougakuWaribikiRituTemp = BizNumber.ZERO;
        if (pPYen.compareTo(BizCurrency.valueOf(15000, BizCurrencyTypes.YEN)) < 0) {
            kougakuWaribikiRituTemp = BizNumber.ZERO;
        }
        else if (pPYen.compareTo(BizCurrency.valueOf(30000, BizCurrencyTypes.YEN)) < 0) {
            kougakuWaribikiRituTemp = BizNumber.valueOf(0.005);
        }
        else {
            kougakuWaribikiRituTemp = BizNumber.valueOf(0.01);
        }

        BizNumber jyuturt = BizNumber.ONE.subtract(yoteiSinkeiyakuhiRituTemp.add(yoteiIjihiRituTemp)
            .add(yoteiSyuukinhiRituTemp).subtract(kougakuWaribikiRituTemp));
        BizCurrency pJyuutougkTemp = pPkyktuuka.multiply(jyuturt);

        pJyuutougk = pJyuutougkTemp;
        yoteiSinkeiyakuhiRitu = yoteiSinkeiyakuhiRituTemp;
        yoteiIjihiRitu = yoteiIjihiRituTemp;
        yoteiSyuukinhiRitu = yoteiSyuukinhiRituTemp;
        kougakuWaribikiRitu = kougakuWaribikiRituTemp;

        logger.debug("△ 単月保険料充当額計算 終了");

        return kekkakbn;
    }
}
