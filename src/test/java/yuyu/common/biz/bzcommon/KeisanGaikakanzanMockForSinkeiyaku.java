package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
import yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_execPkakin;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link GetKawaseRate}のモッククラスです。<br />
 */
public class KeisanGaikakanzanMockForSinkeiyaku extends KeisanGaikakanzan {

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

        if (caller == KeisanSPTest_exec.class) {

            if(SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(10,BizCurrencyTypes.DOLLAR);
            }
        }
        else if (caller == CheckSPTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizCurrency.valueOf(11.11, BizCurrencyTypes.DOLLAR);
            }
            if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(11.99, BizCurrencyTypes.DOLLAR);
            }
            if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizCurrency.valueOf(1111);
            }
        }

        if (caller == HenkinTest_exec.class) {

            if(SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(10);
            }
        }
        if (caller == CheckTuusanTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(251);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(250);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(249);
            }
            return BizCurrency.valueOf(100);
        }
        return super.exec(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency execDivide(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        if (caller == KeisanSPTest_exec.class) {

            if(SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(100);
            }

            if(SYORIPTN == TESTPATTERN2){

                return BizCurrency.valueOf(100);
            }
        }

        if (caller == HenkinTest_exec.class || caller == HenkinTest_execPkakin.class) {

            return BizCurrency.valueOf(100);
        }

        if (caller == CheckTblMosSyouhinTest_exec.class) {

            if(SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(100);
            }

            if(SYORIPTN == TESTPATTERN2){

                return BizCurrency.valueOf(20406.00, BizCurrencyTypes.DOLLAR);
            }
        }

        if (caller == CheckTuusanTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(251);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(250);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(249);
            }
            return BizCurrency.valueOf(100);
        }

        return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }
}
