package yuyu.common.biz.koutei;

import yuyu.common.biz.bzcommon.CheckKinouModeKengenTest_checkWorklistKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckKinouModeKengenTest_hanteiWorklistKinouModeId;
import yuyu.common.siharai.sicommon.SiKinouModeSetteiTest_exec;

/**
 * {@link BzWorkflowInfo}のモッククラスです。<br />
 */
@SuppressWarnings("serial")
public class BzWorkflowInfoMock extends BzWorkflowInfo{
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;


    @Override
    public String getTaskId() {

        if(caller == CheckKinouModeKengenTest_checkWorklistKinouModeKengen.class && TESTPATTERN1.equals(SYORIPTN)) {
            return "input";
        }

        else if(caller == CheckKinouModeKengenTest_hanteiWorklistKinouModeId.class && TESTPATTERN1.equals(SYORIPTN))
        {
            return "input";
        }
        else if (caller == SiKinouModeSetteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return "SDR001";
        }

        return super.getTaskId();
    }

}




