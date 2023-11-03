package yuyu.common.biz.bzcommon;

import yuyu.common.hozen.khcommon.CheckKzhuriKouzaTest_execA1;
import yuyu.common.hozen.khcommon.CheckKzhuriKouzaTest_execA2;
import yuyu.common.siharai.chksk.ChkSubSksInfoTest_exec;
import yuyu.def.classification.C_Tuukasyu;

/**
 *
 */
public class CheckKouzaNoMock extends CheckKouzaNo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean isCheckOK(String pKouzaNo, C_Tuukasyu pTuukasyu) {

        if (ChkSubSksInfoTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return false;

            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;

            }
        }
        else if (CheckKzhuriKouzaTest_execA1.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return false;
            }
        }
        else if (CheckKzhuriKouzaTest_execA2.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return false;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return true;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return true;
            }
        }

        return super.isCheckOK(pKouzaNo, pTuukasyu);
    }

    @Override
    public boolean isKyoyouKeta(String pKouzaNo, C_Tuukasyu pTuukasyu) {

        if (ChkSubSksInfoTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return false;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;

            }
        }
        else if (CheckKzhuriKouzaTest_execA1.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return false;
            }
        }
        else if (CheckKzhuriKouzaTest_execA2.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return false;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return true;
            }
        }

        return super.isKyoyouKeta(pKouzaNo, pTuukasyu);
    }

}
