package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link SiCalcKihrkmpstgk}のモッククラスです。<br />
 */
public class SiCalcKihrkmpstgkMockForSiharai extends SiCalcKihrkmpstgk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(SiCalcKihrkmpstgkBean pSiCalcKihrkmpstgkBean) {
        if (caller == CalcHkKngkHijynbrSysnTest_exec.class) {
            if(SYORIPTN.equals(TESTPATTERN1) || SYORIPTN.equals(TESTPATTERN2) || SYORIPTN.equals(TESTPATTERN3)){
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pSiCalcKihrkmpstgkBean);
    }

    @Override
    public BizCurrency getKiHrkmpstGk() {
        if (SYORIPTN.equals(TESTPATTERN1) || SYORIPTN.equals(TESTPATTERN2) || SYORIPTN.equals(TESTPATTERN3)) {
            return BizCurrency.valueOf(1003);
        }
        return super.getKiHrkmpstGk();
    }
}
