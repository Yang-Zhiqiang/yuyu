package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 年金年額計算クラスのモッククラスです<br />
 */
public class KeisanNkNengkMock extends KeisanNkNengk {

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



    private int flg = 0;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(
        C_Nenkinsyu pNksyu,
        String      pRyouritusdNo,
        C_Tuukasyu  pTuukasyu,
        int         pShrkkn,
        int         pNkShrStartNen,
        C_Seibetu   pSeibetu,
        BizCurrency pNkGns
        ){

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN1.equals(SYORIPTN))) {

            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN2.equals(SYORIPTN))) {

            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN3.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.ERROR;
            }
            else if (flg == 2) {
                flg = 0;
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN5.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.OK;
            }
            else if (flg == 2) {
                flg = 0;
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN4.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.OK;
            }
            else if (flg == 2) {
                flg = 0;
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN9.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.ERROR;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.OK;
            }
            else if (flg == 2) {
                flg = 3;
                return C_ErrorKbn.OK;
            }
            else if (flg == 3) {
                flg = 0;
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN6.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.ERROR;
            }
            else if (flg == 2) {
                flg = 3;
                return C_ErrorKbn.OK;
            }
            else if (flg == 3) {
                flg = 0;
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN7.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.OK;
            }
            else if (flg == 2) {
                flg = 3;
                return C_ErrorKbn.ERROR;
            }
            else if (flg == 3) {
                flg = 0;
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN8.equals(SYORIPTN))) {

            if (flg == 0) {

                flg = 1;
                return C_ErrorKbn.OK;
            }
            else if (flg == 1) {
                flg = 2;
                return C_ErrorKbn.OK;
            }
            else if (flg == 2) {
                flg = 3;
                return C_ErrorKbn.OK;
            }
            else if (flg == 3) {
                flg = 0;
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pNksyu, pRyouritusdNo, pTuukasyu, pShrkkn, pNkShrStartNen, pSeibetu, pNkGns);

    }

    @Override
    public BizCurrency getNkNengk() {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN1.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN2.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN3.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN4.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN6.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (TESTPATTERN7.equals(SYORIPTN)) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (TESTPATTERN8.equals(SYORIPTN)) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN9.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1000,  BizCurrencyTypes.YEN);
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN10.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1234567899,  BizCurrencyTypes.YEN);
        }

        return super.getNkNengk();
    }

    @Override
    public int getHsykkn() {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN1.equals(SYORIPTN))) {

            return 2;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN2.equals(SYORIPTN))) {

            return 2;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN3.equals(SYORIPTN))) {

            return 2;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN4.equals(SYORIPTN))) {

            return 2;
        }

        return super.getHsykkn();
    }

    @Override
    public BizCurrency getNkNengkBigk() {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN1.equals(SYORIPTN))) {

            return BizCurrency.valueOf(2);
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class &&
            (TESTPATTERN10.equals(SYORIPTN))) {

            return BizCurrency.valueOf(1234567890);
        }

        return super.getNkNengkBigk();
    }
}
