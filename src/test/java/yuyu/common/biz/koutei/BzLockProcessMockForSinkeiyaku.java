package yuyu.common.biz.koutei;

import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenkenTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.def.classification.C_KouteiLockKekkaKbn;


/**
 * {@link BzLockProcessMock}のモッククラスです。<br />
 */
public class BzLockProcessMockForSinkeiyaku extends BzLockProcess {

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

        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("10");

                return bzLockProcessOutBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
                bzLockProcessOutBean.setKouteiLockKey("10");

                return bzLockProcessOutBean;
            }
        }
        if (caller == SkProcessCreateTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
                bzLockProcessOutBean.setKouteiLockKey("LOCK_TEST_KEY");

                return bzLockProcessOutBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
                bzLockProcessOutBean.setKouteiLockKey("LOCK_TEST_KEY");

                return bzLockProcessOutBean;
            }
        }
        return super.exec(pKouteiKanriId, pJimuTetuzukiCd);
    }

    @Override
    public BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        if (caller == SkProcessForwardHubiTourokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzLockProcessOutBean;
            }
        }

        if (caller == SkProcessForwardMousikomiTenkenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzLockProcessOutBean;
            }
        }

        return super.exec(pKouteiKanriId, pJimuTetuzukiCd,pKouteiLockKey);

    }
}