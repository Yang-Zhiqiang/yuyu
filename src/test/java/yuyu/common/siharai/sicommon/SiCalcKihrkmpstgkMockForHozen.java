package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin3Test_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link SiCalcKihrkmpstgk}のモッククラスです。<br />
 */
public class SiCalcKihrkmpstgkMockForHozen extends SiCalcKihrkmpstgk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(SiCalcKihrkmpstgkBean pSiCalcKihrkmpstgkBean) {
        if (caller == WSuiihyouSyuusin3Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pSiCalcKihrkmpstgkBean);
    }

    @Override
    public BizCurrency getKiHrkmpstGk() {
        return super.getKiHrkmpstGk();
    }
}
