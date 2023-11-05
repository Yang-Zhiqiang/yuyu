package yuyu.common.hozen.khcommon;

import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.siharai.chksk.ChkSubTmttknJyoutaiTest_exec;

/**
 * 指数連動積増型年金積立金状態判定のモッククラスです。<br />
 */
public class HanteiKhSisuurendoTmttknJyoutaiMock extends HanteiKhSisuurendoTmttknJyoutai {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        if (caller == CheckKaiyakuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }
        else if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }

            return super.execChokuzenOutouymTmttknHantei(pHanteiTmttknJyoutaiBean);
        }
        else if (caller == ChkSubTmttknJyoutaiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            switch (SYORIPTN) {
                case TESTPATTERN1: return true;
                case TESTPATTERN2: return false;
                default: break;
            }
        }
        else if (caller == DsDataMaintenanceHanteiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        return super.execChokuzenOutouymTmttknHantei(pHanteiTmttknJyoutaiBean);
    }
    @Override
    public boolean execKijunymdgoTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        if (caller == CheckKaiyakuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        return super.execKijunymdgoTmttknHantei(pHanteiTmttknJyoutaiBean);
    }
}
