package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanIkkatuNyuukinGk}のモッククラスです。<br />
 */
public class KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku extends KeisanTukiIkkatuNyuukinGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";
    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int count = 0;


    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }

            if(TESTPATTERN4.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }

            if(TESTPATTERN2.equals(SYORIPTN)){

                return C_ErrorKbn.ERROR;
            }

            if(TESTPATTERN3.equals(SYORIPTN)){

                if (count == 0) {

                    count++;
                    return C_ErrorKbn.OK;
                }
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class)
        {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == CheckNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKeisanIkkatuNyuukinGkBean, pIktwaribikiFuyouFlg);
    }

    @Override
    public BizCurrency getIktnyknkgk() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return BizCurrency.valueOf(new BigDecimal("14"), BizCurrencyTypes.DOLLAR);
            }

            if(TESTPATTERN4.equals(SYORIPTN)){

                if (count < 2) {

                    count++;
                    return BizCurrency.valueOf(new BigDecimal("14"), BizCurrencyTypes.DOLLAR);
                }
                return BizCurrency.valueOf(new BigDecimal("15"), BizCurrencyTypes.DOLLAR);
            }
        }

        else if (caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333.35);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(-1);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1200000);
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333.35);
            }
        }

        if (caller == CheckNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(300);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR);
            }
        }

        return super.getIktnyknkgk();
    }

    @Override
    public BizDate getRyosyuKwsRateKjYmd() {
        if (caller == CheckNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN)) {
                return BizDate.valueOf(20201217);
            }
        }

        return super.getRyosyuKwsRateKjYmd();
    }

    @Override
    public BizNumber getRyosyuKwsRate() {
        if (caller == CheckNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN)) {
                return BizNumber.valueOf(12.22);
            }
        }

        return super.getRyosyuKwsRate();
    }

}
