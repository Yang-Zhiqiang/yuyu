package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 前納入金額計算のモッククラスです。<br />
 */
public class KeisanZennouNyuukinGkMock extends KeisanZennouNyuukinGk {

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
    public C_ErrorKbn execKeisanZennouNyuukinGk(BizDate pKykYmd, BizCurrency pHrkp, BizDate pRyosyuYmd, BizDateYM pJyutouYm,
        Integer pJyutouNensuu) {

        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }

        return super.execKeisanZennouNyuukinGk(pKykYmd, pHrkp, pRyosyuYmd, pJyutouYm, pJyutouNensuu);
    }

    @Override
    public BizCurrency getZennouNyuukinGk() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(new BigDecimal("11"));
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            if (count == 0) {

                count ++;
                return BizCurrency.valueOf(new BigDecimal("1230"));
            }
            return BizCurrency.valueOf(new BigDecimal("1530"));
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(new BigDecimal("1000000001000"));
        }

        if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(4444.45);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return null;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN4.equals(SYORIPTN)) {

            return BizCurrency.valueOf(0);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN5.equals(SYORIPTN)) {

            return BizCurrency.valueOf(-1);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN6.equals(SYORIPTN)) {

            return BizCurrency.valueOf(1200000);
        }

        return super.getZennouNyuukinGk();
    }

    @Override
    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate pKijyunymd, BizCurrency pZennouHrkp,
        Integer pZennouKikan) {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            if (count == 0) {

                count ++;
                return C_ErrorKbn.OK;
            }

            return C_ErrorKbn.ERROR;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN4.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN5.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class) &&
            TESTPATTERN6.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
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
