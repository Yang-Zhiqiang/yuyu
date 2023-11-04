package yuyu.common.siharai.chksk;

import java.util.List;

/**
 * {@link ChkSubMRFKouzaTratki}のモッククラスです。<br />
 */
public class ChkSubMRFKouzaTratkiMock extends ChkSubMRFKouzaTratki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pOyadrtenCd, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pOyadrtenCd, pChkKekkaBeanLst);

    }

}
