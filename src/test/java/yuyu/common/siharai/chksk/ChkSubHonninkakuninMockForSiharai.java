package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * {@link ChkSubHonninkakunin}のモッククラスです。<br />
 */
public class ChkSubHonninkakuninMockForSiharai extends ChkSubHonninkakunin {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SiHonninKakninKekkaKbn pSiHonninKakninKekkaKbn,
        C_SUketoriHouhouKbn pSUketoriHouhouKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;

            }
        }

        super.exec(pSiHonninKakninKekkaKbn, pSUketoriHouhouKbn, pChkKekkaBeanLst);
    }
}
