package yuyu.common.hozen.khcommon;

import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;

/**
 * 指数連動積増型年金積立金状態判定のモッククラスです。<br />
 */
public class HanteiKhSisuurendoTmttknJyoutaiMockForHozen extends HanteiKhSisuurendoTmttknJyoutai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            switch (SYORIPTN) {
                case TESTPATTERN1: return true;
                case TESTPATTERN2: return false;
                default: break;
            }
        }

        if (caller == CheckKaiyakuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        if (caller == SetHosyouTest_exec.class) {
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
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        return super.execKijunymdgoTmttknHantei(pHanteiTmttknJyoutaiBean);
    }
}
