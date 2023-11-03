package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KeisanSPTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link BzGetPrate}のモッククラスです。<br />
 */
public class BzGetPrateMockForHozen extends BzGetPrate2 {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;


    @Override
    public BzGetPrateBean exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        int pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        int pHknkkn,
        int pHrkkkn,
        C_Kykjyoutai pKykjyoutai,
        C_Tuukasyu pKeiyakuTuukasyu,
        int pDai1hknkkn,
        C_RyourituKbn pRyourituKbn) {

        if (caller == KeisanSPTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                prateGetResultBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);

                return prateGetResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.OK);
                prateGetResultBean.setPrate(BizNumber.valueOf(0.001111));
                prateGetResultBean.setPsRate(BizNumber.valueOf(0));

                return prateGetResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.OK);
                prateGetResultBean.setPrate(BizNumber.valueOf(999.999999));
                prateGetResultBean.setPsRate(BizNumber.valueOf(999.999801));

                return prateGetResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.OK);
                prateGetResultBean.setPrate(BizNumber.valueOf(0.001111));
                prateGetResultBean.setPsRate(BizNumber.valueOf(0.1234));

                return prateGetResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.OK);
                prateGetResultBean.setPrate(BizNumber.valueOf(0.111));
                prateGetResultBean.setPsRate(BizNumber.valueOf(999.999801));

                return prateGetResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                BzGetPrateBean prateGetResultBean = new BzGetPrateBean();

                prateGetResultBean.setErrorKbn(C_ErrorKbn.OK);
                prateGetResultBean.setPrate(BizNumber.valueOf(0));
                prateGetResultBean.setPsRate(BizNumber.valueOf(0));

                return prateGetResultBean;
            }
        }
        return super.exec(pSyouhnCd, pRyouritusdNo, pYoteiriritu, pHrkkaisuu, pHhknsei, pHhknnen, pHknkknsmnkbn,
            pHknkkn, pHrkkkn, pKykjyoutai, pKeiyakuTuukasyu, pDai1hknkkn, pRyourituKbn);
    }
}
