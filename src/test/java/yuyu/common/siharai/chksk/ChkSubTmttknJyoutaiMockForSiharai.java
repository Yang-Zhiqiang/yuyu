package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;

/**
 * {@link ChkSubTmttknJyoutai}のモッククラスです。<br />
 */
public class ChkSubTmttknJyoutaiMockForSiharai extends ChkSubTmttknJyoutai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public void exec(BizDate pHanteikijyunymd,
        String pSyono,
        BizDate pKykymd,
        BizDate pTmttknitenymd,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if ( CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return ;
            }
        }

        super.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
    }
}
