package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.KeisanHrrtksnHrkPGkgk;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanHrrtksnHrkPGkgk}のモッククラスです。<br />
 */
public class KeisanHrrtksnHrkPGkgkMockForHozen extends KeisanHrrtksnHrkPGkgk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public C_ErrorKbn exec(String pSyono) {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class ) {
            if (SYORIPTN == TESTPATTERN1) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyono);
    }

    @Override
    public boolean getKeisanKahi() {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class ) {
            if (SYORIPTN == TESTPATTERN1) {
                return true;
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return false;
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return false;
            }
        }

        return super.getKeisanKahi();
    }

    @Override
    public BizCurrency getKihrkmP() {
        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {

            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(2000);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(0);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
        }

        return super.getKihrkmP();
    }

    @Override
    public BizCurrency getHrkmPSgkHknkkn() {
        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(2000);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
        }

        return super.getHrkmPSgkHknkkn();
    }
}
