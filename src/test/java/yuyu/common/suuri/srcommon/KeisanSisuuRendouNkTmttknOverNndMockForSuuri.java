package yuyu.common.suuri.srcommon;

import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * {@link KeisanSisuuRendouNkTmttknOverNnd}のモッククラスです。<br />
 */
public class KeisanSisuuRendouNkTmttknOverNndMockForSuuri extends KeisanSisuuRendouNkTmttknOverNnd {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public C_ErrorKbn exec(
        BizDate     pKykYmd,
        int         pHknkkn,
        C_UmuKbn    pTeikishrtkykhukaUmu,
        C_Tuukasyu  pTuukasyu,
        BizDate     pCalcKijyunYmd,
        BizDateYM   pCalcKijyunYm,
        BizDateYM   pCalcStartYm,
        BizNumber   pTumitateRiritu,
        BizCurrency pTeirituTmttKngk,
        BizCurrency pSisuuRendouTmttKngk) {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else {
                return C_ErrorKbn.OK;
            }

        }
        return super.exec(pKykYmd, pHknkkn, pTeikishrtkykhukaUmu, pTuukasyu, pCalcKijyunYmd, pCalcKijyunYm, pCalcStartYm,  pTumitateRiritu, pTeirituTmttKngk,
            pSisuuRendouTmttKngk);
    }


    @Override
    public BizCurrency getTeiritutmttkngk() {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5);
            }
            else {
                return BizCurrency.valueOf(5);
            }
        }

        return super.getTeiritutmttkngk();
    }


}
