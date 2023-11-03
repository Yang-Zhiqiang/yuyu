package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiTest_exec;

/**
 * 指数連動積増型年金積立金状態判定のモッククラスです。<br />
 */
public class HanteiKhSisuurendoTmttknJyoutaiMockForDirect extends HanteiKhSisuurendoTmttknJyoutai {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {
        if (caller == DsDataMaintenanceHanteiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }
        return super.execChokuzenOutouymTmttknHantei(pHanteiTmttknJyoutaiBean);
    }
}
