package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * {@link BzGetDrate}のモッククラスです。<br />
 */
public class BzGetDrateMockForHozen extends BzGetDrate {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public BzGetDrateMockForHozen() {
        super();
    }

    @Override
    public BzGetDrateBean exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        int pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        int pHknkkn,
        int pHrkkkn,
        String pDnendo,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn,
        C_DRateGetKbn pDRateGetKbn,
        int pKeikanensuu) {

        BzGetDrateBean bzGetDrateBean = SWAKInjector.getInstance(BzGetDrateBean.class);

        HashMap<Integer, BizNumber> drate = new HashMap<>();

        HashMap<Integer, BizNumber> shisaDrate = new HashMap<>();

        HashMap<Integer, BizNumber> risaDrate = new HashMap<>();

        HashMap<Integer, BizNumber> hisaDrate = new HashMap<>();

        HashMap<Integer, BizNumber> dyouVrate = new HashMap<>();

        HashMap<Integer, BizNumber> kikenSrate = new HashMap<>();

        if (KeisanDTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);
                return bzGetDrateBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(1.1354));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(2.1354));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(3.1354));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(4.1354));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(5.1354));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(6.1354));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);

                drate.put(0, BizNumber.valueOf(0.00041));
                bzGetDrateBean.setDrate(drate);

                shisaDrate.put(0, BizNumber.valueOf(0.02589));
                bzGetDrateBean.setShisaDrate(shisaDrate);

                risaDrate.put(0, BizNumber.valueOf(0.02577));
                bzGetDrateBean.setRisaDrate(risaDrate);

                hisaDrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setHisaDrate(hisaDrate);

                dyouVrate.put(0, BizNumber.valueOf(0));
                bzGetDrateBean.setDyouVrate(dyouVrate);

                kikenSrate.put(0, BizNumber.valueOf(0.00035));
                bzGetDrateBean.setKikenSrate(kikenSrate);
                return bzGetDrateBean;
            }
        }

        return super.exec(pSyouhnCd, pRyouritusdNo, pYoteiriritu, pHrkkaisuu, pHhknsei, pHhknnen, pHknkknsmnkbn,
            pHknkkn, pHrkkkn, pDnendo, pNaiteikakuteikbn, pDRateGetKbn, pKeikanensuu);
    }

}