package yuyu.common.biz.koutei;

import java.util.List;

import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukinTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHanteiTest_exec;

/**
 * {@link BzProcessForwardForBatch}のモッククラスです。<br />
 */
public class BzProcessForwardForBatchMock extends BzProcessForwardForBatch{

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(List<BzProcessForwardForBatchInBean> pBzProcessForwardForBatchInBeanLst) {

        if (caller == SkProcessForwardHurikomiNyuukinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else {

            super.exec(pBzProcessForwardForBatchInBeanLst);
        }

        return;
    }
}
