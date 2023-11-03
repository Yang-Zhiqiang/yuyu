package yuyu.common.biz.koutei;

import java.util.List;

import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukinTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHanteiTest_exec;

/**
 * {@link BzProcessForwardForBatch}のモッククラスです。<br />
 */
public class BzProcessForwardForBatchMockForSinkeiyaku extends BzProcessForwardForBatch{

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(List<BzProcessForwardForBatchInBean> pBzProcessForwardForBatchInBeanLst) {

        if (caller == SkProcessForwardHurikomiNyuukinTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        super.exec(pBzProcessForwardForBatchInBeanLst);
    }
}
