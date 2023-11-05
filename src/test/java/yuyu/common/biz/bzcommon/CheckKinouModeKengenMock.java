package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import yuyu.common.siharai.sicommon.SiKinouModeSetteiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.infr.kinoumode.KinouMode;

/**
 * {@link CheckKinouModeKengen}のモッククラスです。<br />
 */
public class CheckKinouModeKengenMock extends CheckKinouModeKengen {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;


    @Inject
    private KinouMode kinouMode;

    @Override
    public void checkWorklistKinouModeKengen() {

        if (caller == SiKinouModeSetteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            kinouMode.setKinouMode(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue());
        }
        else {
            super.checkWorklistKinouModeKengen();
        }
    }

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
