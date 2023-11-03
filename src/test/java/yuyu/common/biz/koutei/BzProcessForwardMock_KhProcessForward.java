package yuyu.common.biz.koutei;

import yuyu.common.hozen.koutei.KhProcessForwardTest_exec;

/**
 * {@link BzProcessForward}のモッククラスです。<br />
 */
public class BzProcessForwardMock_KhProcessForward extends BzProcessForward {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BzProcessForwardInBean pBzProcessForwardInBean) {

        if (caller == KhProcessForwardTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
        }
        else {

            super.exec(pBzProcessForwardInBean);
        }

        return;
    }
}
