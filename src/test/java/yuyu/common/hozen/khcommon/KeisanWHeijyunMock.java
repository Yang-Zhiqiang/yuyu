package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanWHeijyun}のモッククラスです<br />
 */
public class KeisanWHeijyunMock extends KeisanWHeijyun {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency getW() {

        if (caller == KeisanWTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(21);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getW();
    }

    @Override
    public BizCurrency getV() {
        if (caller == KeisanWTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(22);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(22, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getV();
    }

    @Override
    public BizNumber getKaiyakukjritu() {
        if (caller == KeisanWTest_exec.class) {
            return BizNumber.valueOf(23);

        }
        return super.getKaiyakukjritu();
    }

    @Override
    public BizCurrency getKaiyakukjgk() {
        if (caller == KeisanWTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(24);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(24, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getKaiyakukjgk();
    }

    @Override
    public int getKaiyakukjyouKeikanensuu() {
        if (caller == KeisanWTest_exec.class) {
            return 25;

        }
        return super.getKaiyakukjyouKeikanensuu();
    }

    @Override
    public int getKeikanensuu() {
        if (caller == KeisanWTest_exec.class) {
            return 26;

        }
        return super.getKeikanensuu();
    }

    @Override
    public int getKeikatukisuu() {
        if (caller == KeisanWTest_exec.class) {
            return 27;

        }
        return super.getKeikatukisuu();
    }

    @Override
    public BizCurrency getKaiyakukjMaeW() {
        if (caller == KeisanWTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(28);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(28, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getKaiyakukjMaeW();
    }

    @Override
    public BizCurrency getPruikei() {
        if (caller == KeisanWTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(29);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(29, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getPruikei();
    }

    @Override
    public BizCurrency getPtumitatekinTyoseimae() {
        if (caller == KeisanWTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizCurrency.valueOf(30);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizCurrency.valueOf(30, BizCurrencyTypes.DOLLAR);
            }
        }
        return super.getPtumitatekinTyoseimae();
    }

    @Override
    public BizDateYM getPtumitatekinKeisanYM() {
        if (caller == KeisanWTest_exec.class) {
            return BizDateYM.valueOf(201605);
        }
        return super.getPtumitatekinKeisanYM();
    }

    @Override
    public C_ErrorKbn exec(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == KeisanWTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.ERROR;

            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);
    }

}
