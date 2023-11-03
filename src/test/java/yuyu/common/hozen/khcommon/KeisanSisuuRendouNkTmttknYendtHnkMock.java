package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_ErrorKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * {@link KeisanSisuuRendouNkTmttknYendtHnk}のモッククラスです<br />
 */
public class KeisanSisuuRendouNkTmttknYendtHnkMock extends KeisanSisuuRendouNkTmttknYendtHnk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public C_ErrorKbn exec(
        BizDate      pCalckijyunYmd,
        BizDateYM    pCalcKijyunYm,
        BizDate      pYendthnkYmd,
        BizDateYM    pYendthnkYm,
        BizDate      pKykYmd,
        Integer      pHknkkn,
        BizCurrency  pKihons,
        BizNumber    pTumitateRiritu) {

        if (caller == KeisanWItijiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        return C_ErrorKbn.ERROR;
    }

    @Override
    public int getKeikanensu() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return Integer.valueOf(11);
            }
        }

        return super.getKeikanensu();
    }

    @Override
    public int getKeikatukisu() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return Integer.valueOf(12);
            }
        }

        return super.getKeikatukisu();
    }

    @Override
    public BizCurrency getTumitategk() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(999999999);
            }
        }

        return super.getTumitategk();
    }

}
