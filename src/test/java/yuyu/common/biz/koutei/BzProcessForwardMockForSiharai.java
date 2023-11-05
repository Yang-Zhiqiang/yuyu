package yuyu.common.biz.koutei;

import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;

/**
 * {@link BzOutputProcessRecord}のモッククラスです。<br />
 */
public class BzProcessForwardMockForSiharai extends BzProcessForward {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BzProcessForwardInBean pBzProcessForwardInBean) {

        if (caller == SiProcessForwardTest_exec.class) {
            return;
        }

        super.exec(pBzProcessForwardInBean);
    }
}
