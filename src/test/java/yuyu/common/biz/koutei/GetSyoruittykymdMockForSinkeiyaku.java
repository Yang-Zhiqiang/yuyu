package yuyu.common.biz.koutei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.moschk.HandSateiKetteiHanteiTest_exec;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link GetSyoruittykymd}のモッククラスです。<br />
 */
public class GetSyoruittykymdMockForSinkeiyaku extends GetSyoruittykymd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private String flag = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDate exec(String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCd) {
        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (flag.equals("1")) {
                    flag = "2";
                    return BizDate.valueOf(20160304);
                }
                else if (flag.equals("2")) {
                    flag = "1";
                    return null;
                }

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                if (flag.equals("1")) {
                    flag = "2";
                    return null;
                }
                else if (flag.equals("2")) {
                    flag = "1";
                    return BizDate.valueOf(20160304);
                }
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                if (flag.equals("1")) {
                    flag = "2";
                    return null;
                }
                else if (flag.equals("2")) {
                    flag = "3";
                    return null;
                }
                else if (flag.equals("3")) {
                    flag = "1";
                    return BizDate.valueOf(20160304);
                }
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return null;
            }

        }

        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){
                return null;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                return BizDate.valueOf(20160229);
            }
        }

        if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){
                return BizDate.valueOf(20160302);
            }
        }

        if (caller == SkProcessForwardTeiseiTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                return null;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                return BizDate.valueOf(20160304);
            }
        }
        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){
                return  BizDate.valueOf(20160304);
            }
        }
        return super.exec(pKouteiKanriId, pSyoruiCd);
    }
}