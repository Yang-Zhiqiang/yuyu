package yuyu.common.biz.bzdairiten;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.dba4bzgetdairitenitakusyouhn.BzGetDairitenItakuSyouhnDao;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;

/**
 * 業務共通 代理店 代理店委託商品情報取得
 */
public class BzGetDairitenItakuSyouhn {

    @Inject
    private BzGetDairitenItakuSyouhnDao bzGetDairitenItakuSyouhnDao;

    @Inject
    private static Logger logger;

    public BzGetDairitenItakuSyouhn() {
        super();
    }

    public BzGetDairitenItakuSyouhnBean exec(String pDrtenCd, C_DrtSyouhinSikibetuKbn pSyouhinSikibetuKbn,
        String pHrkhouhouKbn, String pPlannmKbn, BizDate pkijyunYmd) {

        logger.debug("▽ 代理店委託商品情報取得 開始");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhn = SWAKInjector
            .getInstance(BzGetDairitenItakuSyouhnBean.class);

        if (BizUtil.isBlank(pDrtenCd) || pSyouhinSikibetuKbn == null ||
            BizUtil.isBlank(pHrkhouhouKbn) || BizUtil.isBlank(pPlannmKbn) || pkijyunYmd == null ) {

            logger.debug("△ 代理店委託商品情報取得 終了");

            return bzGetDairitenItakuSyouhn;
        }

        List<BT_DairitenItakuSyouhn> dairitenItakuSyouhnLst =
            bzGetDairitenItakuSyouhnDao.getDairitenItakuSyouhnsByDrtencdItems(
                pDrtenCd, pSyouhinSikibetuKbn.getValue(), pHrkhouhouKbn, pPlannmKbn);

        if (dairitenItakuSyouhnLst == null || dairitenItakuSyouhnLst.size() == 0) {

            bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.TORIATUKAINASI);

            logger.debug("△ 代理店委託商品情報取得 終了");

            return bzGetDairitenItakuSyouhn;
        }

        for (BT_DairitenItakuSyouhn dairitenItakuSyouhn : dairitenItakuSyouhnLst) {

            bzGetDairitenItakuSyouhn.setDairitenCd(dairitenItakuSyouhn.getDrtencd());
            bzGetDairitenItakuSyouhn.setDrtsyouhinsikibetuKbn(
                C_DrtSyouhinSikibetuKbn.valueOf(dairitenItakuSyouhn.getDrtsyouhinsikibetukbnstr()));
            bzGetDairitenItakuSyouhn.setDrthrkhouhouKbn(dairitenItakuSyouhn.getDrthrkhouhoukbn());
            bzGetDairitenItakuSyouhn.setDrtplannmKbn(dairitenItakuSyouhn.getDrtplannmkbn());
            bzGetDairitenItakuSyouhn.setItakuhknhnbkaisiYmd(dairitenItakuSyouhn.getItakuhknhnbkaisiymd());
            bzGetDairitenItakuSyouhn.setItakuhknhnbsyuuryouYmd(dairitenItakuSyouhn.getItakuhknhnbsyuuryouymd());

            BizDate itakuhknhnbkaisiYmd = dairitenItakuSyouhn.getItakuhknhnbkaisiymd();
            BizDate itakuhknhnbsyuuryouYmd = dairitenItakuSyouhn.getItakuhknhnbsyuuryouymd();

            if (itakuhknhnbsyuuryouYmd == null) {
                itakuhknhnbsyuuryouYmd = BizDate.MAX_VALID_DATE;
            }
            if (BizDateUtil.compareYmd(pkijyunYmd, itakuhknhnbkaisiYmd) == BizDateUtil.COMPARE_LESSER) {

                bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.HANBAIKAISIMAE);
                break;
            }
            else if (BizDateUtil.compareYmd(itakuhknhnbkaisiYmd, pkijyunYmd) != BizDateUtil.COMPARE_GREATER
                && BizDateUtil.compareYmd(pkijyunYmd, itakuhknhnbsyuuryouYmd) != BizDateUtil.COMPARE_GREATER) {

                bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.HANBAITYUU);
                break;

            }
            else {
                bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.HANBAIKYUUSI);
            }
        }

        logger.debug("△ 代理店委託商品情報取得 終了");
        return bzGetDairitenItakuSyouhn;

    }
}
