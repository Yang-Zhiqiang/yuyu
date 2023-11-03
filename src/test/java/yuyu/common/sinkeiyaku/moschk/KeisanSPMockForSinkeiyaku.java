package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanSP}のモッククラスです。<br />
 */
public class KeisanSPMockForSinkeiyaku extends KeisanSP {

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
    public void exec(MosnaiCheckParam pMP) {

        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return;
            }
        }
        super.exec(pMP);
    }

    @Override
    public C_ErrorKbn getiErrorKbn() {
        if (caller == SetSPTest_exec.class) {

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
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        return super.getiErrorKbn();
    }

    @Override
    public BizCurrency getFstphrkgk() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(102);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getFstphrkgk();
    }

    @Override
    public BizCurrency getHyouteiP() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(87);
            }

            return BizCurrency.valueOf(80);
        }
        return super.getHyouteiP();
    }

    @Override
    public BizCurrency getSeitoufstpkei() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(101);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getSeitoufstpkei();
    }

    @Override
    public BizCurrency getHeijyunp() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(15000, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(30000, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(90001, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizCurrency.valueOf(179986, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return BizCurrency.valueOf(30000.5, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN6.equals(SYORIPTN) ) {

                return BizCurrency.valueOf(14999.9, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN7.equals(SYORIPTN) ) {

                return BizCurrency.valueOf(29998.6, BizCurrencyTypes.YEN);
            }
        }
        return super.getHeijyunp();
    }

    @Override
    public BizCurrency getHeijyunpryoumasinasi() {
        if (caller == SetSPTest_exec.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(103);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getHeijyunpryoumasinasi();
    }

    @Override
    public BizCurrency getIkkatup() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(104);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getIkkatup();
    }

    @Override
    public BizCurrency getZennoup() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(105);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getZennoup();
    }

    @Override
    public BizCurrency getZennoujyuutoup() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(106);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getZennoujyuutoup();
    }

    @Override
    public BizCurrency getPharaikomisougaku() {
        if (caller == SetSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(108);
            }

            return BizCurrency.valueOf(100);
        }
        return super.getPharaikomisougaku();
    }

}