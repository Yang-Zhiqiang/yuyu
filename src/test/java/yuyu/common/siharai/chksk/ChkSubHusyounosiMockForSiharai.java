package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link ChkSubHusyounosi}のモッククラスです。<br />
 */
public class ChkSubHusyounosiMockForSiharai extends ChkSubHusyounosi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(List<String> pByoumeiTourokuNoLst, C_GeninKbn pGeninKbn, C_UmuKbn pSateiKakHusyouSiKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pByoumeiTourokuNoLst, pGeninKbn, pSateiKakHusyouSiKbn, pChkKekkaBeanLst);
    }
}
