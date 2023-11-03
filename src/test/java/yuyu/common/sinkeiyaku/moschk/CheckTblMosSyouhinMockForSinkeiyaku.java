package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;

/**
 * {@link CheckTblMosSyouhin}のモッククラスです。<br />
 */
public class CheckTblMosSyouhinMockForSinkeiyaku extends CheckTblMosSyouhin{

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP) {

        if (caller == MosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("▽ 申込商品テーブルチェック 開始");
                    logger.debug("△ 申込商品テーブルチェック 終了");
                }
            }
            return;
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                return;
            }
        }
        if (caller == SeihowebMosnaiCheckTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ 申込商品テーブルチェック 開始");

                pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

                logger.debug("△ 申込商品テーブルチェック 終了");
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                logger.debug("▽ 申込商品テーブルチェック 開始");

                logger.debug("△ 申込商品テーブルチェック 終了");
                return;
            }

        }

        super.exec(pMP);
    }
}
