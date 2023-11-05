package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 充当回数計算のモッククラスです。<br />
 */
public class JtKaisukeisanMockForHozen extends JtKaisukeisan {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";
    public static final String TESTPATTERN5 = "5";
    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(int pIJtNensuu,
        int pIJtGesuu,
        C_Hrkkaisuu pIHhrkkaisuu) {
        if (KeisanMsyMkeiPTest_exec.class == caller) {
            return;
        }
        super.exec(pIJtNensuu, pIJtGesuu, pIHhrkkaisuu);
    }

    @Override
    public int getJyutoukaisuu() {

        if (caller == KeisanMsyMkeiPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return 0;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return 1;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return 3;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return 1;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return 1;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {

                return 1;
            }
        }

        if (caller == KeisanKihrkPRuikeigkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return 0;
            }

        }
        if (caller == KeisanKihrkPRuikeigkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return 1;
            }

        }
        if (caller == KeisanKihrkPRuikeigkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN3)) {
                return 3;
            }

        }

        return super.getJyutoukaisuu();
    }
    @Override
    public int getHasuutuki() {

        if (caller == KeisanMsyMkeiPTest_exec.class) {

            if (TESTPATTERN4.equals(SYORIPTN)) {

                return 1;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {

                return 0;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return -1;
            }
        }
        return super.getHasuutuki();
    }


}
