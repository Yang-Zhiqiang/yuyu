package yuyu.common.hozen.khcommon;

import yuyu.common.siharai.chksk.ChkSubTmttknJyoutaiTest_exec;

/**
 * {@link HanteiKhSisuurendoTmttknJyoutai}のモッククラスです。<br />
 */
public class HanteiKhSisuurendoTmttknJyoutaiMockForSiharai extends HanteiKhSisuurendoTmttknJyoutai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        if (caller == ChkSubTmttknJyoutaiTest_exec.class) {
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
