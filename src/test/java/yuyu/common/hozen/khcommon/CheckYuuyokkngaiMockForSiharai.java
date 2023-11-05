package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.chksk.ChkSubPHrkmYuuyokknTest_exec;

/**
 * {@link CheckYuuyokkngai}のモッククラスです。<br />
 */
public class CheckYuuyokkngaiMockForSiharai extends CheckYuuyokkngai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(String pSyono, BizDate pDate) {

        if (caller == ChkSubPHrkmYuuyokknTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return false;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
        }

        return super.exec(pSyono, pDate);
    }
}
