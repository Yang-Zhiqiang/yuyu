package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanGaikaP}のモッククラスです<br />
 */
public class KeisanGaikaPMock extends KeisanGaikaP{

    private BizCurrency pkyktuuka;

    private BizNumber kawaserate;

    @Override
    public BizCurrency getP() {

        if (caller == KeisanMsyMkeiPTest_exec.class) {
            return  pkyktuuka;
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            return  pkyktuuka;
        }
        return super.getP();
    }

    @Override
    public BizNumber getKawaseRate() {
        if (caller == KeisanVHeijyunTest_exec.class) {
            return  kawaserate;
        }
        return super.getKawaseRate();
    }

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizCurrency pPYen, C_Tuukasyu pTuukasyu, BizDateYM pHrkkigetu, BizDate pKykymd, BizDate pFstpryosyu){

        if (caller == KeisanMsyMkeiPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pkyktuuka = BizCurrency.valueOf(10100);
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pkyktuuka = BizCurrency.valueOf(1111);
                kawaserate = BizNumber.valueOf(2.222);
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pPYen, pTuukasyu, pHrkkigetu, pKykymd, pFstpryosyu);
    }

    @Override
    public C_ErrorKbn execKawaseSitei(BizCurrency pPYen,
        C_Tuukasyu pTuukasyu,
        BizNumber pKawaserate) {

        if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pkyktuuka = BizCurrency.valueOf(1111);
                kawaserate = BizNumber.valueOf(2.222);
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.execKawaseSitei(pPYen, pTuukasyu, pKawaserate);
    }
}
