package yuyu.common.biz.koutei;

/**
 * {@link SetWariateHukaInfo}のモッククラスです。<br />
 */
public class SetWariateHukaInfoMockForBiz extends SetWariateHukaInfo {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pKouteiKanriId, String pSubSystemId, String pJimuTetuzukiCd, String pCurrentTaskId,
        String pNextTaskId) {
        if(caller == BzProcessForwardTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);
            }
        }
        super.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);
    }
}