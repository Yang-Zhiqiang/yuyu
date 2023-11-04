package yuyu.common.hozen.khcommon;

import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKyoutuuInfoTest_exec;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;

/**
 * {@link CheckKaiyaku}のモッククラスです<br />
 */
public class CheckKaiyakuMockForHozen extends CheckKaiyaku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_KaiyakuchkkekkaKbn exec(String pKinouBunrui, String pGamenBunrui, CheckKaiyakuBean pCheckKaiyakuBean) {

        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
        }

        if (caller == KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
        }

        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
        }

        if (caller == KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
        }

        if (caller == KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_KaiyakuchkkekkaKbn.ERROR;
            }
        }
        return super.exec(pKinouBunrui, pGamenBunrui, pCheckKaiyakuBean);

    }

}
