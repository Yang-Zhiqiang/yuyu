package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;


/**
 * {@link SetHutuuSibouS}のモッククラスです。<br />
 */
public class SetHutuuSibouSMockForSinkeiyaku extends SetHutuuSibouS {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency exec(MosnaiCheckParam pMp) {
        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizCurrency.valueOf(20000000, BizCurrencyTypes.YEN);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(20000001, BizCurrencyTypes.YEN);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(19999999, BizCurrencyTypes.YEN);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR);
            }
        }
        else if (caller == CheckNnknTokuyakuTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizCurrency.valueOf(1);
            }
        }
        else if (caller == HanteiKykKakuninTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizCurrency.valueOf(55000000);
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(55000001);
            }
            if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(55000004);
            }
        }
        return super.exec(pMp);


    }
}
