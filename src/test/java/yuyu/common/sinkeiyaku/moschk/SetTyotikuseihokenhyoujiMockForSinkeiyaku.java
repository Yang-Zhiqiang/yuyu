package yuyu.common.sinkeiyaku.moschk;

import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 貯蓄性保険表示設定クラス{@link SetTyotikuseihokenhyouji}のモッククラスです<br />
 */
public class SetTyotikuseihokenhyoujiMockForSinkeiyaku extends SetTyotikuseihokenhyouji {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn hanteiTyotikuseihoken(HanteiTyotikuseihokenBean pHanteiTyotikuseihokenBean) {

        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.hanteiTyotikuseihoken(pHanteiTyotikuseihokenBean);

    }

    @Override
    public C_UmuKbn getHouteityotkhknhyj() {

        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
        }
        return super.getHouteityotkhknhyj();
    }

    @Override
    public C_UmuKbn getTyotkhknhyj() {
        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            if(TESTPATTERN3.equals(SYORIPTN) ){
                return C_UmuKbn.ARI;
            }

        }
        return super.getTyotkhknhyj();
    }
}
