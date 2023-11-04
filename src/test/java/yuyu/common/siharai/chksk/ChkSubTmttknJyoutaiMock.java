package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

/**
 * {@link ChkSubTmttknJyoutai}のモッククラスです。<br />
 */
public class ChkSubTmttknJyoutaiMock extends ChkSubTmttknJyoutai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Inject
    private static Logger logger;
    @Override
    public void exec(BizDate pHanteikijyunymd,
        String pSyono,
        BizDate pKykymd,
        BizDate pTmttknitenymd,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 積立金状態チェック 開始");

        if ( CheckSbSkNaiyouTest_exec.class == caller && TESTPATTERN1.equals(SYORIPTN)) {

            return ;
        }

        super.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);;
        logger.debug("△ 積立金状態チェック 終了");
    }
}
