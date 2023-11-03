package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 前納入金額計算のモッククラスです。<br />
 */
public class KeisanZennouNyuukinGkMockForKhansyuu extends KeisanZennouNyuukinGk {

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

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.execKeisanZennouNyuukinGk(pKykYmd, pHrkp, pRyosyuYmd, pJyutouYm, pJyutouNensuu);
    }

    @Override
    public BizCurrency getZennouNyuukinGk() {

        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(new BigDecimal("1000000001000"));
        }

        return super.getZennouNyuukinGk();
    }

    @Override
    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate pKijyunymd, BizCurrency pZennouHrkp,
        Integer pZennouKikan) {

        return super.execKeisanSinkeiyakuDoujiZennouNyuukinGk(pKijyunymd, pZennouHrkp, pZennouKikan);

    }

    @Override
    public BizCurrency getZennouGenka() {
        return super.getZennouGenka();
    }
}
