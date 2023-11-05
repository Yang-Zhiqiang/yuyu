package yuyu.common.biz.koutei;

import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;

/**
 * {@link BzUnlockProcess}のモッククラスです。<br />
 */
public class BzUnlockProcessMockForSinkeiyaku extends BzUnlockProcess {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return ;
            }
        }
        if (caller == SkProcessCreateTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                return ;
            }
        }
        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

}