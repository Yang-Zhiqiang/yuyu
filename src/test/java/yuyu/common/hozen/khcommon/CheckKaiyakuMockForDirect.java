package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.CheckDsKaiyakuTest_kaiyakukytChk;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;

/**
 * {@link CheckKaiyaku}のモッククラスです<br />
 */
public class CheckKaiyakuMockForDirect extends CheckKaiyaku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_KaiyakuchkkekkaKbn exec(String pKinouBunrui, String pGamenBunrui, CheckKaiyakuBean pCheckKaiyakuBean) {

        if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN6.equals(SYORIPTN) || TESTPATTERN7.equals(SYORIPTN) || TESTPATTERN8.equals(SYORIPTN) || TESTPATTERN9.equals(SYORIPTN) ||
                TESTPATTERN10.equals(SYORIPTN)|| TESTPATTERN11.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
        }
        return super.exec(pKinouBunrui, pGamenBunrui, pCheckKaiyakuBean);
    }

    @Override
    public String getErrorMessageCode() {

        if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "3001";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "3002";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "3003";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "9999";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return "5001";
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return "5002";
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return "5003";
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return "5004";
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                return "5005";
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                return "5006";
            }
        }
        return super.getErrorMessageCode();
    }

}
