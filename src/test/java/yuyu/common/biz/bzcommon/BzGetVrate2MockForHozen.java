package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KeisanVTest_exec;
import yuyu.common.hozen.khcommon.KeisanYendtHnkSTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_VRateGetKbn;

/**
 * {@link BzGetVrate2}のモッククラスです。<br />
 */
public class BzGetVrate2MockForHozen extends BzGetVrate2 {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetVrateBean exec(String pSyouhnCd, String pRyouritusdNo, BizNumber pYoteiriritu, C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei, int pHhknnen, C_HknkknsmnKbn pHknkknsmnkbn, int pHknkkn, int pHrkkkn, C_Kykjyoutai pKykjyoutai,
        C_Tuukasyu pTuukasyu, int pDai1hknkkn, C_VRateGetKbn pVRateGetKbn, int pKeikanensuu) {

        if (caller == KeisanVTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();
                bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);
                bzGetVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);

                return bzGetVrateBean;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();
                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

                HashMap<Integer, BizNumber> vrateMap = new HashMap<Integer, BizNumber>();

                switch (pSyouhnCd) {
                    case "ﾕｶ":
                        vrateMap.put(0, BizNumber.valueOf(0));
                        vrateMap.put(1, BizNumber.valueOf(0));
                        break;
                    case "ﾕｱ":
                    case "ﾕｲ":
                    case "ﾕｹ":
                    case "ﾕｺ":
                        vrateMap.put(0, BizNumber.valueOf(0.000003));
                        vrateMap.put(1, BizNumber.valueOf(0.00021));
                        break;
                    case "ﾕA":
                        vrateMap.put(0, BizNumber.valueOf(0.9899));
                        vrateMap.put(1, BizNumber.valueOf(0.9952));
                        break;
                    case "ﾕｳ":
                    case "ﾕｴ":
                        vrateMap.put(0, BizNumber.valueOf(999.999003));
                        vrateMap.put(1, BizNumber.valueOf(999.999999));
                        break;
                    default:
                        vrateMap.put(0, BizNumber.valueOf(1));
                        vrateMap.put(1, BizNumber.valueOf(1));
                        break;
                }

                bzGetVrateBean.setVrate(vrateMap);

                return bzGetVrateBean;

            }
        }
        else if (caller == KeisanYendtHnkSTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                return bzGetVrateBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();

                HashMap<Integer, BizNumber> vrate = new HashMap<>();

                vrate.put(0, BizNumber.valueOf(0.9));
                vrate.put(1, BizNumber.valueOf(2.0994));

                bzGetVrateBean.setVrate(vrate);

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

                return bzGetVrateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();

                HashMap<Integer, BizNumber> vrate = new HashMap<>();

                vrate.put(0, BizNumber.valueOf(0.09));
                vrate.put(1, BizNumber.valueOf(0.14976));

                bzGetVrateBean.setVrate(vrate);

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

                return bzGetVrateBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();

                HashMap<Integer, BizNumber> vrate = new HashMap<>();

                vrate.put(0, BizNumber.valueOf(2));
                vrate.put(1, BizNumber.valueOf(2.40012));

                bzGetVrateBean.setVrate(vrate);

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

                return bzGetVrateBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetVrateBean bzGetVrateBean = new BzGetVrateBean();

                HashMap<Integer, BizNumber> vrate = new HashMap<>();

                vrate.put(0, BizNumber.valueOf(2));
                vrate.put(1, BizNumber.valueOf(2.00012));

                bzGetVrateBean.setVrate(vrate);

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

                return bzGetVrateBean;
            }
        }


        return super.exec(pSyouhnCd, pRyouritusdNo, pYoteiriritu, pHrkkaisuu, pHhknsei, pHhknnen, pHknkknsmnkbn,
            pHknkkn, pHrkkkn, pKykjyoutai, pTuukasyu, pDai1hknkkn, pVRateGetKbn, pKeikanensuu);
    }
}
