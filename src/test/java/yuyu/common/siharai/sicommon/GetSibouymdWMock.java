package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetSibouymdW}のモッククラスです。<br />
 *
 */
public class GetSibouymdWMock extends GetSibouymdW {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    private BizCurrency kaiyakuhenreiknGk;

    private BizCurrency tmttKnGk;

    private BizCurrency pruikei;

    @Override
    public BizCurrency getKaiyakuhenreiknGk() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                kaiyakuhenreiknGk = BizCurrency.valueOf(Long.valueOf("7700007000077"), BizCurrencyTypes.AU_DOLLAR);
                return kaiyakuhenreiknGk;
            }
        }
        return super.getKaiyakuhenreiknGk();
    }

    @Override
    public BizCurrency getTmttKnGk() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                tmttKnGk = BizCurrency.valueOf(Long.valueOf("9900009000099"), BizCurrencyTypes.AU_DOLLAR);
                return tmttKnGk;
            }
        }
        return super.getTmttKnGk();
    }

    @Override
    public BizCurrency getPruikei() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                pruikei = BizCurrency.valueOf(Long.valueOf("5500005000055"), BizCurrencyTypes.AU_DOLLAR);
                return pruikei;
            }
        }
        return super.getPruikei();
    }

    @Override
    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pCalcHkShrKngkInputBean);
    }
}
