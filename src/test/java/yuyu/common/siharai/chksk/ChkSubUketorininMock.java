package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubUketorinin}のモッククラスです。<br />
 */
public class ChkSubUketorininMock extends ChkSubUketorinin {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SeikyuusyaKbn pSeikyuusyaKbn, String pSeikyusya, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pSeikyuusyaKbn, pSeikyusya, pSiKykKihon, pChkKekkaBeanList);
    }

}
