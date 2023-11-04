package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * {@link DsTeirituTumitatekinKeisan}のモッククラスです。<br />
 */
public class DsTeirituTumitatekinKeisanMockForDirect extends DsTeirituTumitatekinKeisan {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn keisanNkGnsGk(String pSyono, BizDate pCalckijyunYmd, IT_KykSyouhn pKykSyouhn,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.keisanNkGnsGk(pSyono, pCalckijyunYmd, pKykSyouhn, pKykSonotaTkyk);

    }

    @Override
    public BizCurrency getNkGnsGk() {

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1034567890);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123);
            }
        }
        return super.getNkGnsGk();
    }

}
