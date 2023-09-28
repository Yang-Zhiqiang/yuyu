package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 代理店 募集人情報取得（募集人登録番号指定）クラス
 */
public class BzGetBsInfoBstrkno {

    @Inject
    private static Logger logger;

    public BzGetBsInfoBstrkno() {
        super();
    }

    public BzGetBsInfoBean exec(String pBosyuutrkno) {

        logger.debug("▽ 募集人情報取得（募集人登録番号指定） 開始");

        if (BizUtil.isBlank(pBosyuutrkno)) {
            logger.debug("△ 募集人情報取得（募集人登録番号指定） 終了");
            return null;
        }

        BzGetBsKeyBstrkno bzGetBsKeyBstrkno = SWAKInjector.getInstance(BzGetBsKeyBstrkno.class);

        String bosyuuCd = bzGetBsKeyBstrkno.exec(pBosyuutrkno);
        if (BizUtil.isBlank(bosyuuCd)) {
            logger.debug("△ 募集人情報取得（募集人登録番号指定） 終了");
            return null;
        }

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);
        logger.debug("△ 募集人情報取得（募集人登録番号指定） 終了");
        return bzGetBsInfoBean;
    }
}
