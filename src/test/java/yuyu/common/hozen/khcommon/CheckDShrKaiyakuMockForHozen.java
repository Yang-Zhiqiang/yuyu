package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.hozen.haitou.CheckDShrKaiyaku;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link CheckDShrKaiyaku}のモッククラスです。<br />
 */
public class CheckDShrKaiyakuMockForHozen extends CheckDShrKaiyaku{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public C_ErrorKbn checkDShr(String pSyono, BizDate pCalcKijyunYmd,BizDateYM  pJkipjytYm,
        C_YouhiKbn pPMinyuuCheckYouhi, BizDate pSyoriYmd) {

        if (caller == CheckKaiyakuTest_exec.class ) {
            if(TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }
            if(TESTPATTERN5.equals(SYORIPTN)){

                return C_ErrorKbn.ERROR;
            }
        }

        return super.checkDShr(pSyono, pCalcKijyunYmd, pJkipjytYm, pPMinyuuCheckYouhi, pSyoriYmd);
    }

    @Override
    public C_UmuKbn getDHuseigouUmu() {

        if (caller == CheckKaiyakuTest_exec.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }

            if (TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }

        return super.getDHuseigouUmu();
    }

    @Override
    public C_UmuKbn getMihaneiDUmu() {

        if (caller == CheckKaiyakuTest_exec.class) {

            if ( TESTPATTERN2.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }

            if (TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }

        return super.getMihaneiDUmu();
    }

    @Override
    public C_UmuKbn getDShrYmdUmu() {

        if (caller == CheckKaiyakuTest_exec.class ) {

            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }

        return super.getDShrYmdUmu();
    }

}
