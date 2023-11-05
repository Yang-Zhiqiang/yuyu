package yuyu.common.biz.koutei;

import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;

/**
 * {@link CheckTaskKengen}のモッククラスです。<br />
 */
public class CheckTaskKengenMock extends CheckTaskKengen {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(String pUserId, String pJimuTetuzukiCd, String pTaskId) {

        if (caller == SkProcessForwardTeiseiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        else if (caller == SiProcessForwardTest_exec.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return false;
            }
        }else {
            return super.exec(pUserId, pJimuTetuzukiCd, pTaskId);
        }
        return false;
    }
}
