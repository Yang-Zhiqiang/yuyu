package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * {@link CheckYakkanJyuryouHouhou}のモッククラスです。<br />
 */
public class CheckYakkanJyuryouHouhouMockForSinkeiyaku extends CheckYakkanJyuryouHouhou {

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp) {
        if (caller == MosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("▽ 約款受領方法チェック 開始");
                    logger.debug("△ 約款受領方法チェック 終了");
                }
            }
            return;
        }

        super.exec(pMp);
    }

}
