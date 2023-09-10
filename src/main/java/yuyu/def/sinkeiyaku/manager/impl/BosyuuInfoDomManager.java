package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.HT_BosKihonDao;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.sinkeiyaku.result.bean.BosKihonInfosByKakutyoujobcdItemsBean;
import yuyu.def.sinkeiyaku.sorter.SortHT_BosKihon;


/**
 * BosyuuInfoDomマネージャー<br />
 * BosyuuInfoにおける、DB操作を提供する。<br />
 */
class BosyuuInfoDomManager {

    @Inject
    private HT_BosKihonDao bosKihonDao;

    List<HT_BosKihon> getAllBosKihon(){
        SortHT_BosKihon sortHT_BosKihon = new SortHT_BosKihon();
        return sortHT_BosKihon.OrderHT_BosKihonByPkAsc(bosKihonDao.selectAll());
    }

    HT_BosKihon getBosKihon(String pMosno) {

        return bosKihonDao.getBosKihon(pMosno);
    }

    ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> getBosKihonInfosByKakutyoujobcdItems(String pKakutyoujobcd, C_MosUketukeKbn pMosuketukekbn, C_MosTourokuJyoukyouKbn pMostourokujyoukyoukbn, C_UmuKbn pPplessdatasousinumukbn) {

        ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> exDBResults = bosKihonDao.getBosKihonInfosByKakutyoujobcdItems(pMosuketukekbn, pMostourokujyoukyoukbn, pPplessdatasousinumukbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
