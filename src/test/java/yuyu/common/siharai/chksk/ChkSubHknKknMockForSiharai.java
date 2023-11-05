package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * {@link ChkSubHknKkn}のモッククラスです。<br />
 */
public class ChkSubHknKknMockForSiharai extends ChkSubHknKkn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, JT_SiKykSyouhn pSiKykSyouhn, List<ChkKekkaBean> pChkKekkaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pSiKykSyouhn, pChkKekkaBeanList);
    }
}
