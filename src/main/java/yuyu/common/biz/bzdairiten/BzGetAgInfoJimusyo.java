package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 代理店 代理店情報取得（親代理店、事務所指定）クラス
 */
public class BzGetAgInfoJimusyo {

    @Inject
    private static Logger logger;

    public BzGetAgInfoJimusyo() {
        super();
    }

    public List<BzGetAgInfoBean> exec(String pOyadrtenCd, String pDrtenjimCd) {

        logger.debug("▽ 代理店情報取得（親代理店、事務所指定） 開始");

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = new ArrayList<>();

        if (BizUtil.isBlank(pOyadrtenCd)) {

            logger.debug("△ 代理店情報取得（親代理店、事務所指定） 終了");

            return bzGetAgInfoBeanList;
        }
        else if (BizUtil.isBlank(pDrtenjimCd)) {

            logger.debug("△ 代理店情報取得（親代理店、事務所指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BzGetAgKeyJimusyo bzGetAgKeyJimusyo = SWAKInjector.getInstance(BzGetAgKeyJimusyo.class);

        String drtenCd = bzGetAgKeyJimusyo.exec(pOyadrtenCd, pDrtenjimCd);

        if (BizUtil.isBlank(drtenCd)) {

            logger.debug("△ 代理店情報取得（親代理店、事務所指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        logger.debug("△ 代理店情報取得（親代理店、事務所指定） 終了");

        return bzGetAgInfoBeanList;
    }
}
