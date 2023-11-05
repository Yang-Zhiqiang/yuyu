package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanGaikakanzan}のモッククラスです。<br />
 */
public class KeisanGaikakanzanMockForDirect extends KeisanGaikakanzan {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public BizCurrency exec(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {


        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (SYORIPTN == TESTPATTERN1) {

                return BizCurrency.valueOf(1234);
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (SYORIPTN == TESTPATTERN1) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(60000000, BizCurrencyTypes.YEN);
                }
            }
            else if (SYORIPTN == TESTPATTERN2) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return null;
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(60000000, BizCurrencyTypes.YEN);
                }
            }
            else if (SYORIPTN == TESTPATTERN3) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return null;
                }
            }
            return BizCurrency.valueOf(70000000, BizCurrencyTypes.YEN);
        }

        return super.exec(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency execDivide(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        if (caller == DsGetKeiyakuSyousaiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
            }else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

}
