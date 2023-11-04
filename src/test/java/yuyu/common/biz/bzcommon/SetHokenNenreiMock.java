package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;


/**
 * {@link SetHokenNenrei}のモッククラスです。<br />
 */
public class SetHokenNenreiMock extends SetHokenNenrei {

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