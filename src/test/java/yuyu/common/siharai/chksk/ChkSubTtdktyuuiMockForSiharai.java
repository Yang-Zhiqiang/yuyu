package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubTtdktyuui}のモッククラスです。<br />
 */
public class ChkSubTtdktyuuiMockForSiharai extends ChkSubTtdktyuui {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pSiKykKihon, pChkKekaBeanList);
    }
}
