package yuyu.common.biz.bzcommon;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 共通 通貨換算計算
 */
public class KeisanGaikakanzan {

    private BizCurrency kanzanGaku;

    public KeisanGaikakanzan() {
        super();
    }

    public BizCurrency getKanzanGaku() {
        return kanzanGaku;
    }

    public BizCurrency exec(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        kanzanGaku = BizCurrency.valueOf(0);

        RoundingMode roundingMode = RoundingMode.UNNECESSARY;

        if (C_HasuusyoriKbn.AGE.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.UP;
        }
        else if (C_HasuusyoriKbn.SUTE.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.DOWN;
        }
        else if (C_HasuusyoriKbn.SSYGNY.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.HALF_UP;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukaSyu);

        kanzanGaku = pKingaku.convCurrencyType(currencyType, pKawaseRate).toValidValue(roundingMode);

        return kanzanGaku;
    }
    public BizCurrency execDivide(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        kanzanGaku = BizCurrency.valueOf(0);

        RoundingMode roundingMode = RoundingMode.UNNECESSARY;

        if (C_HasuusyoriKbn.AGE.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.UP;
        }
        else if (C_HasuusyoriKbn.SUTE.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.DOWN;
        }
        else if (C_HasuusyoriKbn.SSYGNY.eq(pHasuuSyoriKbn)) {
            roundingMode = RoundingMode.HALF_UP;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukaSyu);

        int scaleNumber = currencyType.getShiftDigits() - pKingaku.getType().getShiftDigits();

        kanzanGaku =  pKingaku.divide(pKawaseRate, scaleNumber, roundingMode);

        String kanzanGakuStr = kanzanGaku.toString();

        BigDecimal kanzanGakunum = new BigDecimal(kanzanGakuStr);

        kanzanGaku = BizCurrency.valueOf(kanzanGakunum, currencyType);

        return kanzanGaku;
    }
}