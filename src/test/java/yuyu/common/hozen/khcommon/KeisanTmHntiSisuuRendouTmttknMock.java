package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanTmHntiSisuuRendouTmttkn}のモッククラスです。<br />
 */
public class KeisanTmHntiSisuuRendouTmttknMock extends KeisanTmHntiSisuuRendouTmttkn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static int flag = 0;

    @Override
    public C_ErrorKbn exec(
        String      pSyouhnCd,
        C_Tuukasyu  pTuukasyu,
        BizNumber   pTmmsHanteiYmdSisuu,
        BizNumber   pTykzenTmmsHanteiYmdSisuu,
        BizNumber   pSetteiBairitu,
        BizNumber   pTmttknZoukarituJygn,
        BizCurrency pSisuuRendouTmttKngk,
        BizNumber   pRendouRitu) {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                if (BizCurrency.valueOf(35000).equals(pSisuuRendouTmttKngk)) {

                    return C_ErrorKbn.ERROR;
                }
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                //                if (BizCurrency.valueOf(45000).equals(pSisuuRendouTmttKngk)) {
                //
                //                    return C_ErrorKbn.ERROR;
                //                }
                if (flag == 1) {
                    flag = 0;
                    return C_ErrorKbn.ERROR;
                }
                flag++;
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                //                if (BizCurrency.valueOf(55000).equals(pSisuuRendouTmttKngk)) {
                //                    return C_ErrorKbn.ERROR;
                //                }
                if (flag == 2) {
                    flag = 0;
                    return C_ErrorKbn.ERROR;
                }
                flag++;
                return C_ErrorKbn.OK;
            }
        }
        if (caller == WSuiihyouNenkin3Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(
            pSyouhnCd,
            pTuukasyu,
            pTmmsHanteiYmdSisuu,
            pTykzenTmmsHanteiYmdSisuu,
            pSetteiBairitu,
            pTmttknZoukarituJygn,
            pSisuuRendouTmttKngk,
            pRendouRitu);
    }

    @Override
    public BizCurrency getSisuurendoutmttkngk() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(10000);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }

        }
        return super.getSisuurendoutmttkngk();
    }

    @Override
    public BizNumber getSisuuUpRitu() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(30.5);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(60.5);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(60.5);
            }

        }
        return super.getSisuuUpRitu();
    }

    @Override
    public BizNumber getTmttknZoukaRitu() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(60.5);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(60.5);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(60.5);
            }
        }
        return super.getTmttknZoukaRitu();
    }
}
