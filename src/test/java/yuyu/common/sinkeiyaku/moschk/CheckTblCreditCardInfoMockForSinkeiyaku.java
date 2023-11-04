package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * {@link CheckTblCreditCardInfo}のモッククラスです。<br />
 */
public class CheckTblCreditCardInfoMockForSinkeiyaku extends CheckTblCreditCardInfo{

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
                    logger.debug("▽ クレジットカード情報テーブルチェック 開始");
                    logger.debug("△ クレジットカード情報テーブルチェック 終了");
                }
            }
            return;
        }

        super.exec(pMp);
    }

}
