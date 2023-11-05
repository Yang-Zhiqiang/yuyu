package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * {@link BzOutputProcessRecord}のモッククラスです。<br />
 */
public class BzOutputProcessRecordMockForBiz extends BzOutputProcessRecord {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pSyoriComment, String pTaskName,
        C_SyorikekkaKbn pSyorikekkaKbn) {

        if (caller == BzProcessForwardTest_exec.class) {
            return;
        }

        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
    }
}
