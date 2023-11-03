package yuyu.common.sinkeiyaku.koutei;

/**
 * {@link SkProcessForwardKetteiHoryuuHubiOnline}のモッククラスです。<br />
 */
public class SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku extends SkProcessForwardKetteiHoryuuHubiOnline {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        if (caller == SkProcessForwardMoschkExecTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        super.exec(pSkProcessForwardInBean);
    }
}