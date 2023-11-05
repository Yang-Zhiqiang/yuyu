package yuyu.common.biz.koutei;

import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;


/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzForceProcessForwardMockForSinkeiyaku extends BzForceProcessForward {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public  void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pDestnodeId, String pKouteiLockKey) {
        if (caller == SkProcessCreateTest_exec.class) {
            if(TESTPATTERN2.equals(SYORIPTN)){
                return;
            }
        }
        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pDestnodeId,  pKouteiLockKey);
    }
}