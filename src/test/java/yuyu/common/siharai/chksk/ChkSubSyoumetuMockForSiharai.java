package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubSyoumetu}のモッククラスです。<br />
 */
public class ChkSubSyoumetuMockForSiharai extends ChkSubSyoumetu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SaisateiKbn pSaisateiKbn, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pSaisateiKbn, pSiKykKihon, pChkKekkaBeanLst);
    }
}
