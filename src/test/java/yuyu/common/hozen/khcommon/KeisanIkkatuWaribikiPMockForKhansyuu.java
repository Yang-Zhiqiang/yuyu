package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_ErrorKbn;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * 一括割引Ｐ計算のモッククラスです。<br />
 */
public class KeisanIkkatuWaribikiPMockForKhansyuu extends KeisanIkkatuWaribikiP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency p;

    private BizCurrency iktwaribikikgk;

    @Override
    public BizCurrency getP() {

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {
            return p;
        }
        if (caller == KeisanIkkatuPGkTest_exec.class) {
            return p;
        }

        return super.getP();
    }

    @Override
    public BizCurrency getIktwaribikikgk() {

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {
            return iktwaribikikgk;
        }

        if (caller == KeisanIkkatuPGkTest_exec.class) {
            return iktwaribikikgk;
        }
        return super.getIktwaribikikgk();

    }

    @Override
    public C_ErrorKbn exec(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiRiritu,
        int pIktTukisuu, BizCurrency pWaribikimaep) {

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
                p = BizCurrency.valueOf(0);
                iktwaribikikgk = BizCurrency.valueOf(0);
                return errorKbn;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(300);
                iktwaribikikgk = BizCurrency.valueOf(300);
                return errorKbn;

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(800);
                iktwaribikikgk = BizCurrency.valueOf(800);
                return errorKbn;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(1000);
                iktwaribikikgk = BizCurrency.valueOf(1000);
                return errorKbn;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(1100);
                iktwaribikikgk = BizCurrency.valueOf(1100);
                return errorKbn;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(8001);
                iktwaribikikgk = BizCurrency.valueOf(201);
                return errorKbn;
            }
        }

        if (caller == KeisanIkkatuPGkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(20001, BizCurrencyTypes.DOLLAR);
                iktwaribikikgk = BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR);
                return errorKbn;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(120000);
                iktwaribikikgk = BizCurrency.valueOf(400);
                return errorKbn;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(119999);
                iktwaribikikgk = BizCurrency.valueOf(400);
                return errorKbn;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                p = BizCurrency.valueOf(119999);
                iktwaribikikgk = BizCurrency.valueOf(400);
                return errorKbn;
            }
        }
        return super.exec(pSyouhncd, pRyouritusdno, pYoteiRiritu, pIktTukisuu, pWaribikimaep);
    }
}
