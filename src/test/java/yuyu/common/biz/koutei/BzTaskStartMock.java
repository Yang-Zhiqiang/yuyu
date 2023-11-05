package yuyu.common.biz.koutei;

import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExecTest_exec;
import yuyu.def.classification.C_TskStartKekkaKbn;


/**
 * {@link BzTaskStart}のモッククラスです。<br />
 */
public class BzTaskStartMock extends BzTaskStart {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public  C_TskStartKekkaKbn exec(String pKouteiKanriId,
        String pJimuTetuzukiCd, String pTaskId, String pKouteiLockKey, String pUserId) {
        if (caller == BzProcessForwardTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_TskStartKekkaKbn.SEIJYOU;
        }
        else if (caller == SkProcessForwardMoschkExecTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_TskStartKekkaKbn.SEIJYOU;
        }

        return super.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey, pUserId);

    }

    @Override
    public  C_TskStartKekkaKbn exec(String pKouteiKanriId,
        String pJimuTetuzukiCd, String pTaskId, String pKouteiLockKey) {

        return super.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
    }
}