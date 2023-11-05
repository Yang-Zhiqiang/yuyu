package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 同時申込チェック{@link CheckDoujiMos}のモッククラスです。<br />
 */
public class CheckDoujiMosMockForSinkeiyaku extends CheckDoujiMos{
    @Inject
    private static Logger logger;
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp, List<String> pSkDoujiMosMosNoLstRAY, List<String> pSkDoujiMosMosNoLstPAL) {

        if (caller == NayoseTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("▽ 同時申込チェック 開始");
                }


                if (logger.isDebugEnabled()) {
                    logger.debug("△ 同時申込チェック 終了");
                }
                return;
            }
        }
        super.exec(pMp, pSkDoujiMosMosNoLstRAY, pSkDoujiMosMosNoLstPAL);

    }
}
