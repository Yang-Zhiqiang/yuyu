package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KeisanWHyojyunTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_WRateGetKbn;

/**
 * {@link BzGetWrate}のモッククラスです。<br />
 */
public class BzGetWrateMockForHozen extends BzGetWrate {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetWrateBean exec(String pSyouhnCd, String pRyouritusdNo, BizNumber pYoteiriritu, C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei, int pHhknnen, C_HknkknsmnKbn pHknkknsmnkbn, int pHknkkn, int pHrkkkn, C_Kykjyoutai pKykJyoutai,
        C_Tuukasyu pTuukasyu, int pDai1hknkkn, C_WRateGetKbn pWRateGetKbn, int pKeikanensuu) {

        if (caller == KeisanWHyojyunTest_exec.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetWrateBean bzGetWrateBean = new BzGetWrateBean();
                bzGetWrateBean.setErrorKbn(C_ErrorKbn.ERROR);
                bzGetWrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);

                return bzGetWrateBean;

            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetWrateBean bzGetWrateBean = new BzGetWrateBean();
                bzGetWrateBean.setErrorKbn(C_ErrorKbn.OK);
                HashMap<Integer, BizNumber> wrateMap = new HashMap<Integer, BizNumber>();
                wrateMap.put(0, BizNumber.valueOf(1.23));
                wrateMap.put(1, BizNumber.valueOf(1.79));
                bzGetWrateBean.setWrate(wrateMap);

                return bzGetWrateBean;
            }
        }

        return super.exec(  pSyouhnCd, pRyouritusdNo, pYoteiriritu, pHrkkaisuu, pHhknsei, pHhknnen, pHknkknsmnkbn,
            pHknkkn, pHrkkkn, pKykJyoutai, pTuukasyu, pDai1hknkkn, pWRateGetKbn, pKeikanensuu);
    }
}
