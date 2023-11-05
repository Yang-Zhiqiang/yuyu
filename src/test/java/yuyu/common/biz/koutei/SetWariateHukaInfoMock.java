package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;

/**
 * {@link SetWariateHukaInfo}のモッククラスです。<br />
 */
public class SetWariateHukaInfoMock extends SetWariateHukaInfo {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pKouteiKanriId, String pSubSystemId, String pJimuTetuzukiCd, String pCurrentTaskId,
        String pNextTaskId) {
        if (caller == BzProcessForwardTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return ;
        }
        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return ;
        }

        super.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

    }
}