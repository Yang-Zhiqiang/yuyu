package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Bosyuunin;

/**
 * 業務共通 代理店 募集人変額保険資格有効性チェッククラス
 */
public class BzChkBsYuukouHengaku {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzChkBsYuukouHengaku() {
        super();
    }

    public Boolean exec(String pBosyuuCd, BizDate pKijyunYmd) {

        logger.debug("▽ 募集人変額保険資格有効性チェック 開始");

        if (BizUtil.isBlank(pBosyuuCd)) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return false;
        }
        else if (pKijyunYmd == null) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return false;
        }

        BzChkBsYuukou bzChkBsYuukou = SWAKInjector.getInstance(BzChkBsYuukou.class);

        Boolean chkYuuRlt = bzChkBsYuukou.exec(pBosyuuCd, pKijyunYmd);

        if (!chkYuuRlt) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return false;
        }

        BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin(pBosyuuCd);

        if (bosyuunin == null) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return false;
        }

        BizDate hngkhknskktrkYmd = bosyuunin.getHngkhknskktrkymd();

        BizDate hngkhknskktrkmsuYmd = bosyuunin.getHngkhknskktrkmsuymd();

        if (hngkhknskktrkYmd == null) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return false;
        }
        else if (hngkhknskktrkmsuYmd == null) {

            hngkhknskktrkmsuYmd = BizDate.MAX_VALID_DATE;
        }

        if (((BizDateUtil.compareYmd(hngkhknskktrkYmd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER) ||
            (BizDateUtil.compareYmd(hngkhknskktrkYmd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL)) &&
            ((BizDateUtil.compareYmd(pKijyunYmd, hngkhknskktrkmsuYmd) == BizDateUtil.COMPARE_LESSER))) {

            logger.debug("△ 募集人変額保険資格有効性チェック 終了");

            return true;
        }

        logger.debug("△ 募集人変額保険資格有効性チェック 終了");

        return false;
    }
}
