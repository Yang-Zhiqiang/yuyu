package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.def.biz.configuration.YuyuBizConfig;

/**
 * 業務共通 組織判定ユーティリティ
 */
public class BzHanteiSosikiUtil {

    private static final Logger logger = LoggerFactory.getLogger(BzHanteiSosikiUtil.class);

    public BzHanteiSosikiUtil() {
        super();
    }

    public static Boolean isCallcenterKeySosikicd(String pSosikiCd) {

        logger.debug("▽ 組織判定ユーティリティ　コールセンター組織判定（組織コード指定） 開始");

        if (BizUtil.isBlank(pSosikiCd)) {

            logger.debug("△ 組織判定ユーティリティ　コールセンター組織判定（組織コード指定） 終了");

            return false;
        }

        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 組織コード＝" + pSosikiCd);
        logger.debug("｜ △ ");

        if(YuyuBizConfig.getInstance().getHanteiyouCallcentersosikicdList().contains(pSosikiCd)) {
            logger.debug("△ 組織判定ユーティリティ　コールセンター組織判定（組織コード指定） 終了");

            return true;
        }
        else {
            logger.debug("△ 組織判定ユーティリティ　コールセンター組織判定（組織コード指定）終了");

            return false;
        }

    }

}
