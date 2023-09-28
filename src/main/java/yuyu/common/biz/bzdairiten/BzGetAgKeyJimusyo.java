package yuyu.common.biz.bzdairiten;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Dairiten;

/**
 * 業務共通 代理店 代理店コード取得（親代理店、事務所指定）クラス
 */
public class BzGetAgKeyJimusyo {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetAgKeyJimusyo() {
        super();
    }

    public String exec(String pOyadrtenCd, String pDrtenjimCd) {

        logger.debug("▽ 代理店コード取得（親代理店、事務所指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 親代理店コード＝    " + pOyadrtenCd);
        logger.debug("｜ ｜ 代理店事務所コード＝" + pDrtenjimCd);
        logger.debug("｜ △ ");

        String drtenCd = "";

        if (BizUtil.isBlank(pOyadrtenCd)) {

            logger.debug("△ 代理店コード取得（親代理店、事務所指定） 終了");

            return drtenCd;
        }
        else if (BizUtil.isBlank(pDrtenjimCd)) {

            logger.debug("△ 代理店コード取得（親代理店、事務所指定） 終了");

            return drtenCd;
        }

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByOyadrtencdDrtenjimcd(pOyadrtenCd, pDrtenjimCd);

        if (dairitenList.size() == 0) {

            logger.debug("｜ 指定した親代理店コードおよび代理店事務所コードの代理店コードが存在しません。");
            logger.debug("△ 代理店コード取得（親代理店、事務所指定） 終了");

            return drtenCd;
        }

        drtenCd = dairitenList.get(0).getDrtencd();

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 代理店コード＝      " + drtenCd);
        logger.debug("｜ △ ");
        logger.debug("△ 代理店コード取得（親代理店、事務所指定） 終了");

        return drtenCd;
    }
}
