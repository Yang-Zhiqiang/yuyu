package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * {@link KeisanPJyuutougk}のモッククラスです。<br />
 */
public class KeisanPJyuutougkMockForHozen extends KeisanPJyuutougk {
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private BizCurrency pJyuutougk;

    private BizNumber yoteiSinkeiyakuhiRitu;

    private BizNumber yoteiIjihiRitu;

    private BizNumber yoteiSyuukinhiRitu;

    private BizNumber kougakuWaribikiRitu;

    @Override
    public C_ErrorKbn exec(BizCurrency pPkyktuuka, BizCurrency pPYen, int pHhknnen, int pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn, BizDate pKykymd, BizDateYM pCalckijyunym) {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pPkyktuuka, pPYen, pHhknnen, pHrkkkn, pHrkkknsmnkbn, pKykymd, pCalckijyunym);
    }

    @Override
    public BizNumber getYoteiSinkeiyakuhiRitu() {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.15);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizNumber.valueOf(0);
            }
        }
        return super.getYoteiSinkeiyakuhiRitu();
    }

    @Override
    public BizNumber getYoteiIjihiRitu() {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.035);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.035);
            }
        }
        return super.getYoteiIjihiRitu();
    }

    @Override
    public BizNumber getYoteiSyuukinhiRitu() {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.015);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.015);
            }
        }
        return super.getYoteiSyuukinhiRitu();
    }

    @Override
    public BizNumber getKougakuWaribikiRitu() {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizNumber.valueOf(0);
            }
        }
        return super.getKougakuWaribikiRitu();
    }

    @Override
    public BizCurrency getPJyuutougk() {
        if (caller == KeisanVHeijyunTangetuTest_exec.class) {

            if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizCurrency.valueOf(95, BizCurrencyTypes.DOLLAR);
            }
            return BizCurrency.valueOf(80, BizCurrencyTypes.DOLLAR);
        }

        return super.getPJyuutougk();
    }
}
