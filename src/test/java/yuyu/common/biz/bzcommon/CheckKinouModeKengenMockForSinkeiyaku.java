package yuyu.common.biz.bzcommon;

import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;

/**
 * {@link CheckKinouModeKengen}のモッククラスです。<br />
 */
public class CheckKinouModeKengenMockForSinkeiyaku extends CheckKinouModeKengen {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean checkKengenByKinouModeIdByUserId(String pUserId, String pKinouId, String pKinouModeId) {

        if (caller == SkProcessForwardTeiseiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }
        else {
            return super.checkKengenByKinouModeIdByUserId(pUserId, pKinouId, pKinouModeId);
        }
        return false;
    }
}
