package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link KeisanSisuuRendouNkTmttkn}のモッククラスです。<br />
 */
public class KeisanSisuuRendouNkTmttknMock extends KeisanSisuuRendouNkTmttkn {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    private BizCurrency tmttkngkkei;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    @Override
    public C_ErrorKbn exec(
        BizDate pKykymd,
        int pHknkkn,
        C_UmuKbn pTeikishrtkykhukaumu,
        C_Tuukasyu  pTuukasyu,
        BizDate   pCalckijyunYmd,
        BizDateYM   pCalcKijyunYm,
        BizDateYM   pCalcStartYm,
        BizNumber   pTumitateRiritu,
        BizCurrency pTeirituTmttKngk,
        BizCurrency pSisuuRendouTmttKngk) {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == WSuiihyouNenkin3Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            tmttkngkkei = BizCurrency.valueOf(3000);
            teirituTmttkngk = BizCurrency.valueOf(2000);
            sisuurendouTmttkngk = BizCurrency.valueOf(1000);

            return C_ErrorKbn.OK;
        }
        return super.exec(pKykymd, pHknkkn, pTeikishrtkykhukaumu, pTuukasyu, pCalckijyunYmd, pCalcKijyunYm, pCalcStartYm, pTumitateRiritu, pTeirituTmttKngk, pSisuuRendouTmttKngk);
    }

    @Override
    public BizCurrency getTmttkngkkei() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3698.45, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(389966, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000.00, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000.00, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(25000);
            }
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return tmttkngkkei;
        }
        return super.getTmttkngkkei();
    }

    @Override
    public BizCurrency getTeiritutmttkngk() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(333355, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(333355, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(5);
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(25000);
            }
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return teirituTmttkngk;
        }

        return super.getTeiritutmttkngk();
    }

    @Override
    public BizCurrency getSisuurendoutmttkngk() {

        if (caller == KeisanWItijiTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4444.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(444455, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4444.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4444.55, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(444455, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(10);
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(25000);
            }
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuurendouTmttkngk;
        }

        return super.getSisuurendoutmttkngk();
    }

}
