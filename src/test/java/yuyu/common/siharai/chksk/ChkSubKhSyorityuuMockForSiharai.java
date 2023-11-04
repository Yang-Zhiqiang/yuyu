package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubKhSyorityuu}のモッククラスです。<br />
 */
public class ChkSubKhSyorityuuMockForSiharai extends ChkSubKhSyorityuu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(JT_SiKykKihon pSiKykKihon, String pKinouId, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
        }

        super.exec(pSiKykKihon, pKinouId, pChkKekkaBeanLst);;
    }
}
