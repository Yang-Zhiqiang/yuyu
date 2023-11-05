package yuyu.common.biz.koutei;


/**
 * {@link BzForceProcessForward}のモッククラスです。<br />
 */
public class BzForceProcessForwardMockForBiz extends BzForceProcessForward {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public  void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pDestnodeId, String pKouteiLockKey) {
        if(caller == BzForceTaskStartTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        if(caller == BzEndProcessTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return ;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return ;
            }
        }
        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pDestnodeId,  pKouteiLockKey);
    }
}