package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

/**
 * {@link ChkSubPHrkmYuuyokkn}のモッククラスです。<br />
 */
public class ChkSubPHrkmYuuyokknMock extends ChkSubPHrkmYuuyokkn {

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, String pSyono, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 保険料払込猶予期間チェック 開始");

        if ( CheckSbSkNaiyouTest_exec.class == caller && TESTPATTERN1.equals(SYORIPTN)) {

            return ;
        }

        super.exec(pHanteiKijyunYmd, pSyono, pChkKekkaBeanLst);
        logger.debug("△ 保険料払込猶予期間チェック 終了");
    }
}
