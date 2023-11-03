package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanVHeijyun}のモッククラスです<br />
 */
public class KeisanVHeijyunMockForHozen extends KeisanVHeijyun{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(KeisanVHeijyunBean pKeisanVHeijyunBean){

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanWHeijyunTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKeisanVHeijyunBean);

    }

    @Override
    public BizCurrency getV() {

        if (caller == KeisanWHeijyunTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(22);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(22, BizCurrencyTypes.DOLLAR);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizCurrency.valueOf(100);
            }
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(22);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(33);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(22, BizCurrencyTypes.DOLLAR);
            }
        }

        return super.getV();
    }

    @Override
    public BizCurrency getKiharaikomiP() {

        if (caller == KeisanWHeijyunTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(33);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(33, BizCurrencyTypes.DOLLAR);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizCurrency.valueOf(44);
            }
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(22);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(33);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(22, BizCurrencyTypes.DOLLAR);
            }
        }

        return super.getV();
    }

    @Override
    public BizDateYM getTumitateYM() {

        if (caller == KeisanWHeijyunTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizDateYM.valueOf(201804);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizDateYM.valueOf(201805);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizDateYM.valueOf(201806);
            }
        }
        return super.getTumitateYM();
    }

}
