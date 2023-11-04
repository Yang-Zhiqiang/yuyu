package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_KouzokujkKbn;

/**
 * {@link CheckYoteiKykYmd}のモッククラスです。<br />
 */
public class CheckYoteiKykYmdMockForSinkeiyaku extends CheckYoteiKykYmd{

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP) {

        if (caller == SeihowebMosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ 予定契約日チェック 開始");

                pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

                logger.debug("△ 予定契約日チェック 終了");
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                logger.debug("▽ 予定契約日チェック 開始");

                logger.debug("△ 予定契約日チェック 終了");
                return;
            }
        }

        super.exec(pMP);
    }
}
