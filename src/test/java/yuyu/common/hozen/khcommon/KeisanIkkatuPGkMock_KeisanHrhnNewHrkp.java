package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.ascommon.KeisanHrhnNewHrkpTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 一括払P計算{@link KeisanIkkatuPGk}のモッククラスです。<br />
 */
public class KeisanIkkatuPGkMock_KeisanHrhnNewHrkp extends KeisanIkkatuPGk {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency getIkkatuP() {

        if (caller == KeisanHrhnNewHrkpTest_exec.class) {
            return BizCurrency.valueOf(80);
        }

        return super.getIkkatuP();
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuPGkBean pKeisanIkkatuPGkBean, boolean pIktwaribikifuyouFlg) {
        if (caller == KeisanHrhnNewHrkpTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        return super.exec(pKeisanIkkatuPGkBean, pIktwaribikifuyouFlg);
    }

}
