package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;

/**
 * {@link SetDenSimebi}のモッククラスです。<br />
 */
public class SetDenSimebiMockForSinkeiyaku extends SetDenSimebi {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public BizDate exec(BizDate pSyoribi){

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20160414");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20160319");
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf("20160412");
            }
            else {
                return super.exec(pSyoribi);
            }
        }

        return super.exec(pSyoribi);
    }
}