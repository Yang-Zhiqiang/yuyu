package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.KeisanHrrtksnHrkPGkgk;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanHrrtksnHrkPGkgk}のモッククラスです。<br />
 */
public class KeisanHrrtksnHrkPGkgkMock extends KeisanHrrtksnHrkPGkgk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public C_ErrorKbn exec(String pSyono) {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN1) {

            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN2) {

            return C_ErrorKbn.ERROR;
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pSyono);
    }

    @Override
    public boolean getKeisanKahi() {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN1) {

            return true;
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN2) {

            return false;
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return true;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return false;
            }
        }

        return super.getKeisanKahi();
    }

    @Override
    public BizCurrency getKihrkmP() {
        if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(2000);
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN2) {

            return BizCurrency.valueOf(0);
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000001);
            }if (TESTPATTERN2.equals(SYORIPTN)) {
                return null;
            }
        }

        return super.getKihrkmP();
    }

    @Override
    public BizCurrency getHrkmPSgkHknkkn() {
        if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(2000);
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(20000001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return null;
            }
        }

        return super.getHrkmPSgkHknkkn();
    }
}
