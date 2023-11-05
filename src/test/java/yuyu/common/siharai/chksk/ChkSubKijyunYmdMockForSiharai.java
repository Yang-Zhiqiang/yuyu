package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubKijyunYmd}のモッククラスです。<br />
 */
public class ChkSubKijyunYmdMockForSiharai extends ChkSubKijyunYmd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pSyoruiUketukeYmd, BizDate pHanteiKijyunYmd, BizDate pHubiKanryouYmd,
        String pSkno, String pSyono, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pSyoruiUketukeYmd, pHanteiKijyunYmd, pHubiKanryouYmd, pSkno, pSyono, pSiKykKihon, pChkKekkaBeanList);

    }
}
