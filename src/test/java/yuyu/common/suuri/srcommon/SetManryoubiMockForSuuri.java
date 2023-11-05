package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.def.classification.C_KknsmnKbn;

/**
 * {@link SetManryoubi}のモッククラスです。<br />
 */
public class SetManryoubiMockForSuuri extends SetManryoubi{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public BizDate exec(BizDate pKykYmd, int pHhknNen, int pKikan, C_KknsmnKbn pKknsmnKbn) {
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20190101);
            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {
                return null;
            }

        }

        return super.exec(pKykYmd, pHhknNen, pKikan, pKknsmnKbn);

    }

}
