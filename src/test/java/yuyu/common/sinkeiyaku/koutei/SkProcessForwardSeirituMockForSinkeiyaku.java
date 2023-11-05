package yuyu.common.sinkeiyaku.koutei;

/**
 * {@link SkProcessForwardSeiritu}のモッククラスです。<br />
 */
public class SkProcessForwardSeirituMockForSinkeiyaku extends SkProcessForwardSeiritu {

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

        super.exec(pSkProcessForwardInBean);
    }
}