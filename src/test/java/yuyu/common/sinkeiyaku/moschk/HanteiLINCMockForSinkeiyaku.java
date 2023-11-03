package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * {@link HanteiKykKakunin}のモッククラスです。<br />
 */
public class HanteiLINCMockForSinkeiyaku extends HanteiLINC {
    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP) {

        if (caller == MosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("▽ LINC該当判定 開始");
                    logger.debug("△ LINC該当判定 終了");
                }
            }
            return;
        }
        super.exec(pMP);
    }

}
