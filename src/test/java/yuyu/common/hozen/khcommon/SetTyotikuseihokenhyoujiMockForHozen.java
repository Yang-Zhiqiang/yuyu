package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 貯蓄性保険表示設定クラス{@link SetTyotikuseihokenhyouji}のモッククラスです<br />
 */
public class SetTyotikuseihokenhyoujiMockForHozen extends SetTyotikuseihokenhyouji {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(IT_KykKihon pKykKihon) {

        if (caller == EditCommonMonitoringdataTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKykKihon);
    }

    @Override
    public C_UmuKbn getHouteityotkhknhyj() {

        if (caller == EditCommonMonitoringdataTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        return super.getHouteityotkhknhyj();
    }

    @Override
    public C_UmuKbn getTyotkhknhyj() {
        if (caller == EditCommonMonitoringdataTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        return super.getTyotkhknhyj();
    }
}
