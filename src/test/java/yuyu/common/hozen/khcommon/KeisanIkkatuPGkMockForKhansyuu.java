package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 一括払P計算{@link KeisanIkkatuPGk}のモッククラスです。<br />
 */
public class KeisanIkkatuPGkMockForKhansyuu extends KeisanIkkatuPGk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public BizCurrency getIkkatuP() {
        if (caller == EditSeihowebIdouRirekiTblTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }

        return super.getIkkatuP();
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuPGkBean pKeisanIkkatuPGkBean, boolean pIktwaribikifuyouFlg) {
        if (caller == EditSeihowebIdouRirekiTblTest_exec.class) {
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

        return super.exec(pKeisanIkkatuPGkBean, pIktwaribikifuyouFlg);
    }
}
