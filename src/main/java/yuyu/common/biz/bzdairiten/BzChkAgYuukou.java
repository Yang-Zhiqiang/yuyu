package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Dairiten;

/**
 * 業務共通 代理店 代理店有効性チェッククラス
 */
public class BzChkAgYuukou {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzChkAgYuukou() {
        super();
    }

    public Boolean exec(String pDrtenCd, BizDate pKijyunYmd) {

        logger.debug("▽ 代理店有効性チェック 開始");

        if (BizUtil.isBlank(pDrtenCd)) {

            logger.debug("△ 代理店有効性チェック 終了");

            return false;
        }
        else if (pKijyunYmd == null) {

            logger.debug("△ 代理店有効性チェック 終了");

            return false;
        }

        BM_Dairiten dairiten = bizDomManager.getDairiten(pDrtenCd);

        if (dairiten == null) {

            logger.debug("△ 代理店有効性チェック 終了");

            return false;
        }

        BizDate dairitenKouryokuKaisiYmd = dairiten.getDairitenkouryokukaisiymd();

        BizDate dairitenKouryokuSyuuryouYmd = dairiten.getDairitenkouryokusyuuryouymd();

        if (dairitenKouryokuKaisiYmd == null) {

            logger.debug("△ 代理店有効性チェック 終了");

            return false;
        }
        else if (dairitenKouryokuSyuuryouYmd == null) {

            dairitenKouryokuSyuuryouYmd = BizDate.MAX_VALID_DATE;
        }

        if (((BizDateUtil.compareYmd(dairitenKouryokuKaisiYmd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER) ||
            (BizDateUtil.compareYmd(dairitenKouryokuKaisiYmd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL)) &&
            ((BizDateUtil.compareYmd(pKijyunYmd, dairitenKouryokuSyuuryouYmd) == BizDateUtil.COMPARE_LESSER) ||
                (BizDateUtil.compareYmd(pKijyunYmd, dairitenKouryokuSyuuryouYmd) == BizDateUtil.COMPARE_EQUAL))) {

            logger.debug("△ 代理店有効性チェック 終了");

            return true;
        }

        logger.debug("△ 代理店有効性チェック 終了");

        return false;
    }
}
