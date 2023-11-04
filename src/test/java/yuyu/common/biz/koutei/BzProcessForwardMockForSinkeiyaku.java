package yuyu.common.biz.koutei;

import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHenkinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiKaisyouTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninKekkaTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiOnlineTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKyouseiHandTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExecTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenkenTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardNyuukinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardPaperlessMousikomiTest_kouteiSeni;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardSeirituHoryuuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokuninTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;

/**
 * {@link BzProcessForward}のモッククラスです。<br />
 */
public class BzProcessForwardMockForSinkeiyaku extends BzProcessForward {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BzProcessForwardInBean pBzProcessForwardInBean) {

        if (caller == SkProcessForwardImuSateiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKankyouSateiTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardHenkinNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardHubiTourokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardHubiKaisyouTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKyouseiHandTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardKeiyakuKakuninKekkaTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardMoschkExecTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardMousikomiTenkenTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return;
            }
        }
        if (caller == SkProcessForwardTeiseiTest_exec.class) {

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
        if (caller == SkProcessForwardMousikomiTorikesiTest_exec.class) {

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
        super.exec(pBzProcessForwardInBean);
    }
}
