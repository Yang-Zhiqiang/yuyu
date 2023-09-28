package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_DairitenSyougou;

/**
 * 業務共通 代理店 代理店法人商号取得クラス
 */
public class BzGetAgHoujinsyougou {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetAgHoujinsyougou() {
        super();
    }

    public String exec(String pDrtenCd) {

        logger.debug("▽ 代理店法人商号取得 開始");

        String kanjiHoujinSyougou = "";

        if (BizUtil.isBlank(pDrtenCd)) {
            logger.debug("△ 代理店法人商号取得 終了");
            return kanjiHoujinSyougou;
        }

        BM_DairitenSyougou bMDairitenSyougou = bizDomManager.getDairitenSyougou(pDrtenCd);
        if (bMDairitenSyougou == null) {
            logger.debug("△ 代理店法人商号取得 終了");
            return kanjiHoujinSyougou;
        }

        kanjiHoujinSyougou = bMDairitenSyougou.getKanjihoujinsyougou();

        logger.debug("△ 代理店法人商号取得 終了");
        return kanjiHoujinSyougou;
    }
}
