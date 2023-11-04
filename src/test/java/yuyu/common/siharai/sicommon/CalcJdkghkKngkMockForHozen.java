package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusin2Test_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusin3Test_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;

/**
 * {@link CalcJdkghkKngk}のモッククラスです。<br />
 */
public class CalcJdkghkKngkMockForHozen extends CalcJdkghkKngk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency jdkghkKnGk;

    private BizNumber waribikiKikan;

    @Override
    public C_ErrorKbn exec(C_JydkgmbHkKsnKbn pJydkgmbHkKsnKbn, BizCurrency pTkkijyunHokenkngk, BizCurrency pKaiyakuhr,
        BizNumber pYoteiriritu, BizDate pKykymd, BizDate pCalckijyunymd, BizDate pHhknseiymd, Integer pNen,
        C_Hhknsei pHhknsei) {

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }


        if (caller == EditSyoukenTbltest_editTBL.class &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        if (caller == EditSyoukenTblSyuusin3Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                if (pNen == 0) {

                    waribikiKikan = BizNumber.valueOf(11);
                    jdkghkKnGk = BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 5) {

                    waribikiKikan = BizNumber.valueOf(12);
                    jdkghkKnGk = BizCurrency.valueOf(222222, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 10) {

                    waribikiKikan = BizNumber.valueOf(13);
                    jdkghkKnGk = BizCurrency.valueOf(333333, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 15) {

                    waribikiKikan = BizNumber.valueOf(14);
                    jdkghkKnGk = BizCurrency.valueOf(444444, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 20) {

                    waribikiKikan = BizNumber.valueOf(15);
                    jdkghkKnGk = BizCurrency.valueOf(555555, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 25) {

                    waribikiKikan = BizNumber.valueOf(16);
                    jdkghkKnGk = BizCurrency.valueOf(666666, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 30) {

                    waribikiKikan = BizNumber.valueOf(17);
                    jdkghkKnGk = BizCurrency.valueOf(777777, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 35) {

                    waribikiKikan = BizNumber.valueOf(18);
                    jdkghkKnGk = BizCurrency.valueOf(888888, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 40) {

                    waribikiKikan = BizNumber.valueOf(19);
                    jdkghkKnGk = BizCurrency.valueOf(999999, BizCurrencyTypes.DOLLAR);
                }
                else if (pNen == 45) {

                    waribikiKikan = BizNumber.valueOf(20);
                    jdkghkKnGk = BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR);
                }
                else {
                    waribikiKikan = BizNumber.valueOf(4);
                    jdkghkKnGk = BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR);
                }

                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pJydkgmbHkKsnKbn, pTkkijyunHokenkngk, pKaiyakuhr, pYoteiriritu, pKykymd, pCalckijyunymd,
            pHhknseiymd, pNen, pHhknsei);
    }


    @Override
    public CalcJdkghkKngkBean getCalcJdkghkKngkBean() {
        CalcJdkghkKngkBean calcJdkghkKngkBean = SWAKInjector.getInstance(CalcJdkghkKngkBean.class);
        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
            calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(110000));
            return calcJdkghkKngkBean;
        }

        if (caller == EditSyoukenTbltest_editTBL.class &&
            TESTPATTERN1.equals(SYORIPTN)) {
            calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
            calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(110000));
            return calcJdkghkKngkBean;
        }

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
                calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(110000));
                return calcJdkghkKngkBean;
            }
        }

        if (caller == EditSyoukenTblSyuusin3Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
                calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR));
                return calcJdkghkKngkBean;
            }if (TESTPATTERN2.equals(SYORIPTN)) {
                calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
                calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(111111));
                return calcJdkghkKngkBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return calcJdkghkKngkBean;
            }if (TESTPATTERN4.equals(SYORIPTN)) {
                calcJdkghkKngkBean.setWaribikiKikan(waribikiKikan);
                calcJdkghkKngkBean.setJdkghkKnGk(jdkghkKnGk);
                return calcJdkghkKngkBean;
            }
        }
        return super.getCalcJdkghkKngkBean();
    }
}
