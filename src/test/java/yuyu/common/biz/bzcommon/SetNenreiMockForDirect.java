package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;

/**
 * {@link SetNenrei}のモッククラスです。<br />
 */
public class SetNenreiMockForDirect extends SetNenrei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 43;
            }
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 43;
            }
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 60;
            }
        }
        return super.exec(pKijyunYmd, pBirthday);
    }


}