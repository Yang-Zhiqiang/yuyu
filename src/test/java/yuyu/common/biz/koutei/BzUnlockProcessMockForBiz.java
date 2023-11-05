package yuyu.common.biz.koutei;

import javax.inject.Inject;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;

/**
 * {@link BzUnlockProcess}のモッククラスです。<br />
 */
public class BzUnlockProcessMockForBiz extends BzUnlockProcess {

    @Inject
    private BzCommonLockProcessBean bzCommonLockProcessBean;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {
        if (caller == BzLockProcessTest_exec.class) {
            super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        }
        if (caller == BzCommonLockProcessTest_unlockProcess.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                bzCommonLockProcessBean.setKouteiLockKey("");
                bzCommonLockProcessBean.setLockTsyuJimuTetuzukiCd("");
                bzCommonLockProcessBean.setLockTsyuKouteiKanriId("");
            }
            return ;
        }

        if (caller == SyoruitoutyakuOperateProcessTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }
}