package yuyu.common.biz.koutei;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_1;
import yuyu.common.sinkeiyaku.syoruitoutyaku.SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch;

/**
 * {@link BzUnlockProcess}のモッククラスです。<br />
 */
public class BzUnlockProcessMock extends BzUnlockProcess {

    @Inject
    private static Logger logger;

    @Inject
    private BzCommonLockProcessBean bzCommonLockProcessBean;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {
        if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class) {
            super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
            return;
        }

        if (caller == SkProcessUpdateTest_exec_1.class) {
            logger.debug("▽ 業務共通工程ロック解除 開始");
            super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
            logger.debug("▽ 業務共通工程ロック解除 終了");
            return;
        }

        if (caller == BzCommonLockProcessTest_unlockProcess.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                bzCommonLockProcessBean.setKouteiLockKey("");
                bzCommonLockProcessBean.setLockTsyuJimuTetuzukiCd("");
                bzCommonLockProcessBean.setLockTsyuKouteiKanriId("");
            }

            return ;
        }

        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return ;
        }

        if (caller == SkProcessCreateTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return ;
        }

        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

}