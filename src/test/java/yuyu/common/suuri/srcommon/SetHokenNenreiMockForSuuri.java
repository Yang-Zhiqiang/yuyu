package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.SetHokenNenrei;


/**
 * {@link SetHokenNenrei}のモッククラスです。<br />
 */
public class SetHokenNenreiMockForSuuri extends SetHokenNenrei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 16;
            }
        }

        return super.exec(pKijyunYmd, pBirthday);

    }

}