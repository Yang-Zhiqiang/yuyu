package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanGaikaP}のモッククラスです<br />
 */
public class KeisanGaikaPMockForHozen extends KeisanGaikaP{

    private BizCurrency pkyktuuka;

    @Override
    public BizCurrency getP() {

        if (caller == KeisanMsyMkeiPTest_exec.class) {
            return  pkyktuuka;
        }

        if (caller == KeisanKihrkPRuikeigkTest_exec.class) {
            return  pkyktuuka;
        }
        return super.getP();
    }

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizCurrency pPYen, C_Tuukasyu pTuukasyu, BizDateYM pHrkkigetu, BizDate pKykymd, BizDate pFstpryosyu){

        if (caller == KeisanMsyMkeiPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pkyktuuka = BizCurrency.valueOf(10100 ,BizCurrencyTypes.DOLLAR);
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanKihrkPRuikeigkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.ERROR;
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {
                pkyktuuka = BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR);
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pPYen, pTuukasyu, pHrkkigetu, pKykymd, pFstpryosyu);
    }

}
