package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.def.classification.C_SeikyuuSyubetu;

/**
 * {@link ChkSubHansya}のモッククラスです。<br />
 */
public class ChkSubHansyaMockForSiharai extends ChkSubHansya {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu, BzSakuinTsnSyoukaiKekkaBean pBzSakuinTsnSyoukaiKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pSeikyuuSyubetu, pBzSakuinTsnSyoukaiKekkaBean, pChkKekkaBeanLst);
    }
}
