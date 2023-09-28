package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;

/**
 * 業務共通 代理店 代理店コード取得（金融機関指定）クラス
 */
public class BzGetAgKeyKinyuuKikan {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetAgKeyKinyuuKikan() {
        super();
    }

    public String exec(String pKinyuuCd, String pKinyuusitenCd) {

        logger.debug("▽ 代理店コード取得（金融機関指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 金融機関コード＝    " + pKinyuuCd);
        logger.debug("｜ ｜ 金融機関支店コード＝" + pKinyuusitenCd);
        logger.debug("｜ △ ");

        String drtenCd = "";

        if (BizUtil.isBlank(pKinyuuCd)) {

            logger.debug("△ 代理店コード取得（金融機関指定） 終了");

            return drtenCd;
        }
        else if (BizUtil.isBlank(pKinyuusitenCd)) {

            logger.debug("△ 代理店コード取得（金融機関指定） 終了");

            return drtenCd;
        }

        drtenCd = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd(pKinyuuCd, pKinyuusitenCd);

        if (BizUtil.isBlank(drtenCd)) {

            logger.debug("｜ 指定した金融機関コードおよび金融機関支店コードの代理店コードが存在しません。");
            logger.debug("△ 代理店コード取得（金融機関指定） 終了");

            return "";
        }

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 代理店コード＝      " + drtenCd);
        logger.debug("｜ △ ");
        logger.debug("△ 代理店コード取得（金融機関指定） 終了");

        return drtenCd;
    }
}
