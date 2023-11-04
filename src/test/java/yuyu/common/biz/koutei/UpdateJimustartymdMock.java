package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.common.sinkeiyaku.syoruitoutyaku.SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch;

/**
 * {@link UpdateJimustartymd}のモッククラスです。<br />
 */
public class UpdateJimustartymdMock extends UpdateJimustartymd {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pJimuTetuzukiCd, String pKouteiKanriId, String pKouteiLockKey, String pJimuStartYmd) {
        if (caller == BzProcessForwardTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return ;
        }
        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }
        else if (caller == SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class) {
            return;
        }


        super.exec(pJimuTetuzukiCd, pKouteiKanriId, pKouteiLockKey,  pJimuStartYmd);

    }
}