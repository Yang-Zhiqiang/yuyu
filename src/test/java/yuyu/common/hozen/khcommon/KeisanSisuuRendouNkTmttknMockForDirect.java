package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.direct.dscommon.DsTeirituTumitatekinKeisanTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link KeisanSisuuRendouNkTmttkn}のモッククラスです。<br />
 */
public class KeisanSisuuRendouNkTmttknMockForDirect extends KeisanSisuuRendouNkTmttkn {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    private BizCurrency teirituTmttkngk;

    private static int callIndex = 0;

    @Override
    public C_ErrorKbn exec(
        BizDate pKykymd,
        int pHknkkn,
        C_UmuKbn pTeikishrtkykhukaumu,
        C_Tuukasyu pTuukasyu,
        BizDate pCalckijyunYmd,
        BizDateYM pCalcKijyunYm,
        BizDateYM pCalcStartYm,
        BizNumber pTumitateRiritu,
        BizCurrency pTeirituTmttKngk,
        BizCurrency pSisuuRendouTmttKngk) {

        if (caller == DsTeirituTumitatekinKeisanTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKykymd, pHknkkn, pTeikishrtkykhukaumu, pTuukasyu, pCalckijyunYmd,
            pCalcKijyunYm, pCalcStartYm, pTumitateRiritu, pTeirituTmttKngk, pSisuuRendouTmttKngk);
    }

    @Override
    public BizCurrency getTeiritutmttkngk() {

        if (caller == DsTeirituTumitatekinKeisanTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                teirituTmttkngk = BizCurrency.valueOf(2000);
                return teirituTmttkngk;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (callIndex == 0) {
                    callIndex++;
                    teirituTmttkngk = BizCurrency.valueOf(10000000);
                    return teirituTmttkngk;
                }
                if (callIndex == 1) {
                    callIndex++;
                    teirituTmttkngk = BizCurrency.valueOf(20000000);
                    return teirituTmttkngk;
                }
                if (callIndex == 2) {
                    callIndex++;
                    teirituTmttkngk = BizCurrency.valueOf(30000000);
                    return teirituTmttkngk;
                }
            }
        }
        return super.getTeiritutmttkngk();
    }
}
