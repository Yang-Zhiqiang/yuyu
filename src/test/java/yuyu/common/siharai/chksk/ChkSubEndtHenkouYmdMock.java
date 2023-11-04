package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;

/**
 * {@link ChkSubEndtHenkouYmd}のモッククラスです。<br />
 */
public class ChkSubEndtHenkouYmdMock extends ChkSubEndtHenkouYmd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, BizDate pYenHenkoYmd,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.exec(pHanteiKijyunYmd, pYenHenkoYmd, pChkKekkaBeanList);
    }
}
