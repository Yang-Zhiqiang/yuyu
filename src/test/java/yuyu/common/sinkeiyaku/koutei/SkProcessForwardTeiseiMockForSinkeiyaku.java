package yuyu.common.sinkeiyaku.koutei;

/**
 * {@link SkProcessForwardTeisei}のモッククラスです。<br />
 */
public class SkProcessForwardTeiseiMockForSinkeiyaku extends SkProcessForwardTeisei {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
            }
        }
        if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
            }
        }

        else {
            super.exec(pSkProcessForwardInBean);
        }
    }
}