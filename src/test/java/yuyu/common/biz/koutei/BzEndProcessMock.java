package yuyu.common.biz.koutei;

import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link BzEndProcess}のモッククラスです。<br />
 */
public class BzEndProcessMock extends BzEndProcess {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pSyuKouteiKanriId, String pSyuJimuTetuzukiCd, String pKouteiLockKey,
        C_YouhiKbn pSyuKouteiEndYouhiKbn) {

        if (caller == BzProcessForwardTest_exec.class) {
            return;
        }

        super.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey, pSyuKouteiEndYouhiKbn);

    }
}