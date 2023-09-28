package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Bosyuunin;

/**
 * 業務共通 代理店 募集人有効性チェッククラス
 */
public class BzChkBsYuukou {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzChkBsYuukou() {
        super();
    }

    public Boolean exec(String pBosyuuCd, BizDate pKijyunYmd) {

        logger.debug("▽ 募集人有効性チェック 開始");

        if (BizUtil.isBlank(pBosyuuCd)) {

            logger.debug("△ 募集人有効性チェック 終了");

            return false;
        }
        else if (pKijyunYmd == null) {

            logger.debug("△ 募集人有効性チェック 終了");

            return false;
        }

        BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin(pBosyuuCd);

        if (bosyuunin == null) {

            logger.debug("△ 募集人有効性チェック 終了");

            return false;
        }

        BizDate tourokuYmd = bosyuunin.getBosyuunintourokuymd();

        BizDate gyouhaiYmd = bosyuunin.getBosyuuningyouhaiymd();

        if (tourokuYmd == null) {

            logger.debug("△ 募集人有効性チェック 終了");

            return false;
        }
        else if (gyouhaiYmd == null) {

            gyouhaiYmd = BizDate.MAX_VALID_DATE;
        }

        if (((BizDateUtil.compareYmd(tourokuYmd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER) ||
            (BizDateUtil.compareYmd(tourokuYmd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL)) &&
            (BizDateUtil.compareYmd(pKijyunYmd, gyouhaiYmd) == BizDateUtil.COMPARE_LESSER)) {

            logger.debug("△ 募集人有効性チェック 終了");

            return true;
        }

        logger.debug("△ 募集人有効性チェック 終了");

        return false;
    }
}
