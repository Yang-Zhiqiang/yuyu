package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.biz.sorter.SortBV_HjybruikeigakuData;
import yuyu.def.biz.sorter.SortBV_SiharaiTyousyo;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.dao.BV_HjybruikeigakuDataDao;
import yuyu.def.db.dao.BV_SiharaiTyousyoDao;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.entity.BV_SiharaiTyousyo;


/**
 * ViewDomマネージャー<br />
 * Viewにおける、DB操作を提供する。<br />
 */
class ViewDomManager {

    @Inject
    private BV_SiharaiTyousyoDao siharaiTyousyoDao;

    @Inject
    private BV_HjybruikeigakuDataDao hjybruikeigakuDataDao;

    List<BV_SiharaiTyousyo> getAllSiharaiTyousyo(){
        SortBV_SiharaiTyousyo sortBV_SiharaiTyousyo = new SortBV_SiharaiTyousyo();
        return sortBV_SiharaiTyousyo.OrderBV_SiharaiTyousyoByPkAsc(siharaiTyousyoDao.selectAll());
    }

    BV_SiharaiTyousyo getSiharaiTyousyo(String pSubSystemId, String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {

        return siharaiTyousyoDao.getSiharaiTyousyo(pSubSystemId, pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    ExDBResults<BV_SiharaiTyousyo> getSiharaiTyousyosByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BV_SiharaiTyousyo> exDBResults = siharaiTyousyoDao.getSiharaiTyousyosByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BV_HjybruikeigakuData> getAllHjybruikeigakuData(){
        SortBV_HjybruikeigakuData sortBV_HjybruikeigakuData = new SortBV_HjybruikeigakuData();
        return sortBV_HjybruikeigakuData.OrderBV_HjybruikeigakuDataByPkAsc(hjybruikeigakuDataDao.selectAll());
    }

    BV_HjybruikeigakuData getHjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {

        return hjybruikeigakuDataDao.getHjybruikeigakuData(pHjybtantositucd, pKanjyoukmkcd);
    }

}
