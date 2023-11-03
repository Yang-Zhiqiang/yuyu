package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.sicommon.CalcHkKngkHijynbrKojinNkTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkItijibrKojinNkTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkItijibrSysnTest_exec;
import yuyu.common.siharai.sicommon.GetSibouymdWTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanW}のモッククラスです。<br />
 */
public class KeisanWMockForSiharai extends KeisanW {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
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
        }
        if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
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
        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
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
        return super.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);
    }

    @Override
    public BizCurrency getW() {

        if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000001000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000006L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000007000006L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000006000006L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000002000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000002000005L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.YEN);
            }
        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000002000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000002000005L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000022200007L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000022200007L, BizCurrencyTypes.YEN);
            }
        }
        return super.getW();
    }

    @Override
    public BizCurrency getV() {

        if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000001000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000004000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000002L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000007000008L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000009000009L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000003000003L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000003000007L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000003000003L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000003000007L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000033300002L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000033300002L, BizCurrencyTypes.YEN);
            }
        }
        return super.getV();
    }

    @Override
    public BizCurrency getPruikei() {

        if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000001000005L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000004000005L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000001L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000007000009L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000007000007L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        return super.getPruikei();
    }

    @Override
    public BizCurrency getTeirituTmttkngk() {

        if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000000, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000000, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000000, BizCurrencyTypes.YEN);
            }
        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
            }
        }
        return super.getTeirituTmttkngk();
    }

    @Override
    public BizCurrency getSisuurendouTmttkngk() {

        if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12000000, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2300000, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3400000, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3400000, BizCurrencyTypes.YEN);
            }
        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1230000, BizCurrencyTypes.YEN);
            }
        }
        return super.getSisuurendouTmttkngk();
    }

}