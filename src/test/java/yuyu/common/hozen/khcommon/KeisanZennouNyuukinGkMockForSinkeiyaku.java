package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 前納入金額計算のモッククラスです。<br />
 */
public class KeisanZennouNyuukinGkMockForSinkeiyaku extends KeisanZennouNyuukinGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int count = 0;

    @Override
    public BizCurrency getZennouNyuukinGk() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(new BigDecimal("11"));
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {

                if (count == 0) {

                    count ++;
                    return BizCurrency.valueOf(new BigDecimal("1230"));
                }
                return BizCurrency.valueOf(new BigDecimal("1530"));
            }
        }

        else if (caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4444.45);
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
        }

        return super.getZennouNyuukinGk();
    }

    @Override
    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate pKijyunymd, BizCurrency pZennouHrkp,
        Integer pZennouKikan) {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {

                //            if (count == 0) {
                //
                //                count ++;
                //                return C_ErrorKbn.OK;
                //            }

                return C_ErrorKbn.ERROR;
            }

        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        else if (caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) {

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
        }

        return super.execKeisanSinkeiyakuDoujiZennouNyuukinGk(pKijyunymd, pZennouHrkp, pZennouKikan);
    }

    @Override
    public BizCurrency getZennouGenka() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            return BizCurrency.valueOf(new BigDecimal("10000"));
        }
        return super.getZennouGenka();
    }
}
