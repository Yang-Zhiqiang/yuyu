package yuyu.common.hozen.khcommon;

import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;

/**
 * クレジットカード決済用番号表示編集{@link CreditKessaiyouNoHensyuu}のモッククラスです<br />
 */
public class CreditKessaiyouNoHensyuuMockForHozen extends CreditKessaiyouNoHensyuu{

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String exec(String pCreditcardKessaiyouNo) {

        if (caller == SetHaraikomiInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "12345678912345678987654321";
            }
        }

        return super.exec(pCreditcardKessaiyouNo);
    }
}
