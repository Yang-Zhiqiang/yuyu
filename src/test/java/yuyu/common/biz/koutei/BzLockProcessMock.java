package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_1;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_2;
import yuyu.common.sinkeiyaku.syoruitoutyaku.SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch;
import yuyu.def.classification.C_KouteiLockKekkaKbn;


/**
 * {@link BzLockProcessMock}のモッククラスです。<br />
 */
public class BzLockProcessMock extends BzLockProcess {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public  BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd) {
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();
        if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;

        }
        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == BzProcessCreateTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == BzProcessCreateTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessUpdateTest_exec_1.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessUpdateTest_exec_1.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessUpdateTest_exec_2.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessUpdateTest_exec_2.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class
            && TESTPATTERN3.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class
            && TESTPATTERN4.equals(SYORIPTN)) {
            super.exec(pKouteiKanriId, pJimuTetuzukiCd);
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

            return bzLockProcessOutBean;
        }
        else if (caller == BzCommonLockProcessTest_lockProcess.class &&  TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            return bzLockProcessOutBean;
        }
        else if (caller == BzCommonLockProcessTest_lockProcess.class &&  TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");
            return bzLockProcessOutBean;
        }
        else if (caller == BzCommonLockProcessTest_continueLockProcess.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");
            return bzLockProcessOutBean;
        }
        else if (caller == BzCommonLockProcessTest_unlockProcess.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("kouteiLockKeyTest");
            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class
            && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("10");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class
            && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("10");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class
            && TESTPATTERN1.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("LOCK_TEST_KEY");

            return bzLockProcessOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class
            && TESTPATTERN2.equals(SYORIPTN)) {
            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey("LOCK_TEST_KEY");

            return bzLockProcessOutBean;
        }

        return super.exec(pKouteiKanriId, pJimuTetuzukiCd);

    }

    @Override
    public BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        if (caller == SkProcessForwardHubiTourokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return bzLockProcessOutBean;
        }

        return super.exec(pKouteiKanriId, pJimuTetuzukiCd,pKouteiLockKey);

    }
}