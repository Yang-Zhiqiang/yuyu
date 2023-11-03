package yuyu.common.sinkeiyaku.koutei;

/**
 * {@link SkProcessForwardMoschkExec}のモッククラスです。<br />
 */
public class SkProcessForwardMoschkExecMockForSinkeiyaku extends SkProcessForwardMoschkExec {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        if (caller == SkProcessForwardHenkinNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardHubiKaisyouTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardHubiTourokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKyouseiHandTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }

        }
        if (caller == SkProcessForwardKeiyakuKakuninKekkaTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }

        }
        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }

        if (caller == SkProcessForwardKankyouSateiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKeiyakuKakuninIraiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardMousikomiTenkenTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardSeirituHoryuuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardNyuukinNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardTokuninTest_exec.class) {
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