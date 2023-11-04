package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubHasanTousan}のモッククラスです。<br />
 */
public class ChkSubHasanTousanMock extends ChkSubHasanTousan {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanList.add(chkKekkaBean);
                return;
            }
        }

        super.exec(pSiKykKihon, pChkKekkaBeanList);

    }

}
