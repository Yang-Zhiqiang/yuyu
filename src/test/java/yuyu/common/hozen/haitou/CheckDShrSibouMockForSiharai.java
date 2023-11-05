package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.haitou.CheckDShrSibou;
import yuyu.common.siharai.chksk.ChkSubDTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link CheckDShrSibou}のモッククラスです。<br />
 */
public class CheckDShrSibouMockForSiharai extends CheckDShrSibou {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_UmuKbn getDHuseigouUmu() {

        if (ChkSubDTest_exec.class == caller  ) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }
        return super.getDHuseigouUmu();
    }

    @Override
    public C_UmuKbn getMihaneiDUmu() {

        if (ChkSubDTest_exec.class == caller  ) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }

        return super.getMihaneiDUmu();
    }

    @Override
    public C_UmuKbn getDShrYmdUmu() {

        if (ChkSubDTest_exec.class == caller  ) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_UmuKbn.NONE;
            }
        }

        return super.getDShrYmdUmu();
    }

    @Override
    public C_ErrorKbn checkDShr(String pSyoNo, BizDate pCalcKijyunYmd, BizDate pSyoriYmd) {

        if (ChkSubDTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {


                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {


                return C_ErrorKbn.OK;
            }
        }
        return super.checkDShr(pSyoNo, pCalcKijyunYmd, pSyoriYmd);
    }

}
