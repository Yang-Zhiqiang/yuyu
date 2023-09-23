package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * 契約保全 契約保全共通 一括入金契約状態チェック
 */
public class CheckIkktNyuknKykjyuti {

    @Inject
    private static Logger logger;

    public CheckIkktNyuknKykjyuti() {
        super();
    }

    public C_Kykjyoutai exec(BizDate pKijyunymd, BizDateYM pUpdateJkipjytym) {

        logger.debug("▽ 一括入金契約状態チェック 開始");

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.BLNK;

        BizDateYM hanteiKijyunym = pKijyunymd.getBizDateYM().addMonths(2);

        if (BizDateUtil.compareYm(hanteiKijyunym, pUpdateJkipjytym) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYm(hanteiKijyunym, pUpdateJkipjytym) == BizDateUtil.COMPARE_EQUAL) {

            kykjyoutai = C_Kykjyoutai.IKKATUNK;
        }
        else {
            kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        }

        logger.debug("△ 一括入金契約状態チェック 終了");

        return kykjyoutai;

    }

}
