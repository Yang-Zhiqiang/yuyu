package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 代理店 代理店情報取得（金融機関指定）クラス
 */
public class BzGetAgInfoKinyuuKikan {

    @Inject
    private static Logger logger;

    public BzGetAgInfoKinyuuKikan() {
        super();
    }

    public List<BzGetAgInfoBean> exec(String pKinyuuCd, String pKinyuusitenCd) {

        logger.debug("▽ 代理店情報取得（金融機関指定） 開始");

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = new ArrayList<>();

        if (BizUtil.isBlank(pKinyuuCd)) {

            logger.debug("△ 代理店情報取得（金融機関指定） 終了");

            return bzGetAgInfoBeanList;
        }
        else if (BizUtil.isBlank(pKinyuusitenCd)) {

            logger.debug("△ 代理店情報取得（金融機関指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BzGetAgKeyKinyuuKikan bzGetAgKeyKinyuuKikan = SWAKInjector.getInstance(BzGetAgKeyKinyuuKikan.class);

        String drtenCd = bzGetAgKeyKinyuuKikan.exec(pKinyuuCd, pKinyuusitenCd);

        if (BizUtil.isBlank(drtenCd)) {

            logger.debug("△ 代理店情報取得（金融機関指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        logger.debug("△ 代理店情報取得（金融機関指定） 終了");

        return bzGetAgInfoBeanList;
    }
}
