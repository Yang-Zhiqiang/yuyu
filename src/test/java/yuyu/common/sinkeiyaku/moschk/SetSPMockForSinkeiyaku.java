package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * {@link SetSP}のモッククラスです。<br />
 */
public class SetSPMockForSinkeiyaku extends SetSP {

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
                    logger.debug("▽ SP設定 開始");
                    logger.debug("△ SP設定 終了");
                }
            }
            return;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ SP設定 開始");

                HT_MosSyouhn mosSyouhn1 = pMP.getDataSyoriControl().getMosSyouhns().get(0);
                mosSyouhn1.setSeitoukihons(BizCurrency.valueOf(1234567));

                logger.debug("△ SP設定 終了");
                return;
            }
        }

        if (caller == SeihowebMosnaiCheckTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ SP設定 開始");

                pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

                logger.debug("△ SP設定 終了");
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                logger.debug("▽ SP設定 開始");

                logger.debug("△ SP設定 終了");
                return;
            }
        }

        super.exec(pMP);
    }

}
