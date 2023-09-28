package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 代理店 募集人情報取得（行員コード指定）クラス
 */
public class BzGetBsInfoKouin {

    @Inject
    private static Logger logger;

    public BzGetBsInfoKouin() {
        super();
    }

    public BzGetBsInfoBean exec(String pKinyuuCd, String pKouinCd) {

        logger.debug("▽ 募集人情報取得（行員コード指定） 開始");

        if (BizUtil.isBlank(pKinyuuCd)) {

            logger.debug("△ 募集人情報取得（行員コード指定） 終了");

            return null;
        }
        else if (BizUtil.isBlank(pKouinCd)) {

            logger.debug("△ 募集人情報取得（行員コード指定） 終了");

            return null;
        }

        BzGetBsKeyKouin bzGetBsKeyKouin = SWAKInjector.getInstance(BzGetBsKeyKouin.class);

        String bosyuuCd = bzGetBsKeyKouin.exec(pKinyuuCd, pKouinCd);

        if (BizUtil.isBlank(bosyuuCd)) {

            logger.debug("△ 募集人情報取得（行員コード指定） 終了");

            return null;
        }

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        logger.debug("△ 募集人情報取得（行員コード指定） 終了");

        return bzGetBsInfoBean;
    }
}
