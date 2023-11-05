package yuyu.common.biz.koutei;

import yuyu.def.classification.C_KouteiLockKekkaKbn;

/**
 * {@link BzLockProcessMock}のモッククラスです。<br />
 */
public class BzContinueLockProcessMock extends BzContinueLockProcess {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_KouteiLockKekkaKbn exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey)
    {
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn;
        if (caller == BzCommonLockProcessTest_continueLockProcess.class && TESTPATTERN1.equals(SYORIPTN)) {
            kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.SUCCESS;
            return kouteiLockKekkaKbn;
        }
        else if (caller == BzCommonLockProcessTest_continueLockProcess.class && TESTPATTERN2.equals(SYORIPTN)) {
            kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.FAILURE_CHILD;
            return kouteiLockKekkaKbn;

        }else {
            return super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        }

    }
}
