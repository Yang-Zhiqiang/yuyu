package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanVHeijyun}のモッククラスです<br />
 */
public class KeisanVHeijyunMockForDirect extends KeisanVHeijyun{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(KeisanVHeijyunBean pKeisanVHeijyunBean){

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKeisanVHeijyunBean);

    }

    @Override
    public BizCurrency getV() {

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return null;
            }
        }

        return super.getV();
    }

    @Override
    public BizCurrency getKiharaikomiP() {
        return super.getKiharaikomiP();
    }

    @Override
    public BizDateYM getTumitateYM() {
        return super.getTumitateYM();
    }

}
