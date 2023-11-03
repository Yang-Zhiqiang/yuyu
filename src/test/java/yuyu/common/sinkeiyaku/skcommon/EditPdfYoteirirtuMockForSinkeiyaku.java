package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.sinkeiyaku.moschk.CheckHokenRyouYuukouKigenTest_exec;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link EditPdfYoteirirtu}のモッククラスです。<br />
 */
public class EditPdfYoteirirtuMockForSinkeiyaku extends EditPdfYoteirirtu {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    @Inject
    private static Logger logger;

    @Override
    public void exec(MosnaiCheckParam pMosnaiCheckParam,
        BizNumber pMosymdyoteiriritu, BizNumber pKykymdyoteiriritu,
        C_UmuKbn  pYoteirirituUmuKbn,
        BizNumber pMosymdtumitateriritu,
        BizNumber pKykymdtumitateriritu,
        BizNumber pMosymdloadinghnkgtmttrrt, BizNumber pKykymdloadinghnkgtmttrrt,
        C_UmuKbn  pTumitaterirituUmuKbn,
        BizNumber pMosymdtmttknzoukaritujygn,
        BizNumber pKykymdtmttknzoukaritujygn,
        C_UmuKbn pTmttknzoukaritujygnUmuKbn,
        BizNumber pMosymdsetteibairitu,
        BizNumber pKykymdsetteibairitu,
        C_UmuKbn pSetteibairitUmuKbn,
        BizNumber pMosymdrendouritu,
        BizNumber pKykymdrendouritu,
        C_UmuKbn pRendourituhendouumu) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ 予定利率変更連絡票PDF作成 開始");

                logger.debug("△ 予定利率変更連絡票PDF作成 終了");

                return;
            }
        }

        super.exec(pMosnaiCheckParam, pMosymdyoteiriritu, pKykymdyoteiriritu, pYoteirirituUmuKbn,
            pMosymdtumitateriritu, pKykymdtumitateriritu, pMosymdloadinghnkgtmttrrt, pKykymdloadinghnkgtmttrrt, pTumitaterirituUmuKbn, pMosymdtmttknzoukaritujygn,
            pKykymdtmttknzoukaritujygn, pTmttknzoukaritujygnUmuKbn, pMosymdsetteibairitu, pKykymdsetteibairitu,
            pSetteibairitUmuKbn, pMosymdrendouritu, pKykymdrendouritu, pRendourituhendouumu);
    }
}
