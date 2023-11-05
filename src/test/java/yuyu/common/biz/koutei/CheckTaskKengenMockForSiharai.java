package yuyu.common.biz.koutei;

import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;

/**
 * {@link CheckTaskKengen}のモッククラスです。<br />
 */
public class CheckTaskKengenMockForSiharai extends CheckTaskKengen {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(String pUserId, String pJimuTetuzukiCd, String pTaskId) {

        if (caller == SiProcessForwardTest_exec.class) {
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
