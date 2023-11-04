package yuyu.common.sinkeiyaku.koutei;

import yuyu.common.sinkeiyaku.syoruitoutyaku.SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo;


/**
 * {@link SkProcessCreate}のモッククラスです。<br />
 */
public class SkProcessCreateMockForSinkeiyaku extends SkProcessCreate {

    public static final String TESTPATTERN1 = "1";
    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String exec(SkProcessCreateInBean pSkProcessCreateInBean) {
        if (caller == SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "2001";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "3001";
            }
        }
        return super.exec(pSkProcessCreateInBean);
    }
}