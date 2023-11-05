package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.def.classification.C_KouteiLockKekkaKbn;


/**
 * {@link BzLockProcessMockForBiz}のモッククラスです。<br />
 */
public class BzLockProcessMockForBiz extends BzLockProcess {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public  BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd) {
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();
        if(caller == BzProcessCreateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

                return bzLockProcessOutBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

                return bzLockProcessOutBean;
            }
        }
        if(caller == BzCommonLockProcessTest_lockProcess.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
                return bzLockProcessOutBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");
                return bzLockProcessOutBean;
            }
        }
        else if(caller == BzCommonLockProcessTest_continueLockProcess.class){
            if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");
                return bzLockProcessOutBean;
            }
        }
        else if(caller == BzCommonLockProcessTest_unlockProcess.class){
            if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("kouteiLockKeyTest");
                return bzLockProcessOutBean;
            }
        }

        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

                return bzLockProcessOutBean;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
                bzLockProcessOutBean.setKouteiLockKey("testKouteiLockKey");

                return bzLockProcessOutBean;

            }
        }
        return super.exec(pKouteiKanriId, pJimuTetuzukiCd);
    }
}