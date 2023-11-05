package yuyu.common.biz.koutei;

import yuyu.def.classification.C_KouteiLockKekkaKbn;

/**
 * {@link BzLockProcessMock}のモッククラスです。<br />
 */
public class BzContinueLockProcessMockForBiz extends BzContinueLockProcess {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_KouteiLockKekkaKbn exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        C_KouteiLockKekkaKbn kouteiLockKekkaKbn;
        if(caller == BzCommonLockProcessTest_continueLockProcess.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.SUCCESS;
                return kouteiLockKekkaKbn;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.FAILURE_CHILD;
                return kouteiLockKekkaKbn;
            }
        }
        return super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }
}
