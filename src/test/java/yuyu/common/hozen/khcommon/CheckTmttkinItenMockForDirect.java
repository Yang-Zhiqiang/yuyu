package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.DsTumitatekinItenCheckTest_checkTumitatekinIten;
import yuyu.def.classification.C_ChkkekkaKbn;

/**
 * {@link CheckTmttkinIten}のモッククラスです<br />
 */
public class CheckTmttkinItenMockForDirect extends CheckTmttkinIten {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ChkkekkaKbn exec(String pKinouBunrui, String pGamenBunrui, CheckTmttkinItenBean pCheckTmttkinItenBean) {

        if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN) || TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN8.equals(SYORIPTN)) {
                return C_ChkkekkaKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ChkkekkaKbn.SEIJYOU;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ChkkekkaKbn.WARNING;
            }
        }
        return super.exec(pKinouBunrui, pGamenBunrui, pCheckTmttkinItenBean);
    }

    @Override
    public String getErrorMessageCode() {

        if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return "4001";
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return "3001";
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return "3002";
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return "3003";
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                return "3004";
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {

                return "4003";
            }
        }

        return super.getErrorMessageCode();
    }
}
