package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;

/**
 * 業務共通 代理店判定ユーティリティ
 */
public class BzHanteiAgUtil {

    private static final Logger logger = LoggerFactory.getLogger(BzHanteiAgUtil.class);

    public BzHanteiAgUtil() {
        super();
    }

    public static Boolean isAgMrfkouzatoriatukaiKeyOyadrten(String pOyadrtenCd) {

        logger.debug("▽ 代理店判定ユーティリティ　ＭＲＦ口座取扱あり代理店判定（親代理店コード指定） 開始");

        if (BizUtil.isBlank(pOyadrtenCd)) {

            logger.debug("△ 代理店判定ユーティリティ　ＭＲＦ口座取扱あり代理店判定（親代理店コード指定） 終了");

            return false;
        }

        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 親代理店コード＝" + pOyadrtenCd);
        logger.debug("｜ △ ");


        if(YuyuBizConfig.getInstance().getMrfkouzatoriatukaiOyadrtencdList().contains(pOyadrtenCd)) {
            logger.debug("△ 代理店判定ユーティリティ　ＭＲＦ口座取扱あり代理店判定（親代理店コード指定） 終了");

            return true;
        }
        else {
            logger.debug("△ 代理店判定ユーティリティ　ＭＲＦ口座取扱あり代理店判定（親代理店コード指定）終了");

            return false;
        }

    }

}
