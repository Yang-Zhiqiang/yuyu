package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.ascommon.KeisanRsgakuTest_exec1;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 一括入金額計算のモッククラスです。<br />
 */
public class KeisanTukiIkkatuNyuukinGkMockForKhansyuu extends KeisanTukiIkkatuNyuukinGk {

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
    public BizCurrency getIktwaribikikgk() {
        if (caller == KykHenkoujiZnnJytTrksKsnTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
            }
        }
        else if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(500);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(500);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(500);
            }
        }

        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000,BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getIktwaribikikgk();
    }

    @Override
    public BizCurrency getWrbktkyokknp() {
        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000);
            }
        }
        return super.getWrbktkyokknp();
    }

    @Override
    public Integer getWrbktkyokkntksu() {
        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 1;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 1;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 1;
            }
        }
        return super.getWrbktkyokkntksu();
    }

    @Override
    public BizCurrency getWrbktkyukkngip() {
        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000);
            }
        }
        return super.getWrbktkyukkngip();
    }

    @Override
    public Integer getWrbktkyukkngitksu() {
        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 1;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 0;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 2;
            }
        }
        return super.getWrbktkyukkngitksu();
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        if (caller == KykHenkoujiZnnJytTrksKsnTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pKeisanIkkatuNyuukinGkBean, pIktwaribikiFuyouFlg);
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, BizDate pRyosyuYmd,
        BizDateYM pJyuutouYm) {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pKeisanIkkatuNyuukinGkBean, pRyosyuYmd, pJyuutouYm);
    }

    @Override
    public BizCurrency getIktnyknkgk() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(5000);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(5000);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(5000);
            }
        }

        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getIktnyknkgk();
    }

    @Override
    public BizDate getRyosyuKwsRateKjYmd() {
        if (caller == KeisanRsgakuTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20201221);
            }
        }
        return super.getRyosyuKwsRateKjYmd();
    }

    @Override
    public BizNumber getRyosyuKwsRate() {
        if (caller == KeisanRsgakuTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(102);
            }
        }
        return super.getRyosyuKwsRate();
    }

}
