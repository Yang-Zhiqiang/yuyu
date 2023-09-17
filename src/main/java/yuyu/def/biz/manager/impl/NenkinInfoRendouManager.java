package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.biz.sorter.SortBT_NenkinInfoRendou;
import yuyu.def.db.dao.BT_NenkinInfoRendouDao;
import yuyu.def.db.entity.BT_NenkinInfoRendou;


/**
 * NenkinInfoRendouManagerDomマネージャー<br />
 * NenkinInfoRendouManagerにおける、DB操作を提供する。<br />
 */
class NenkinInfoRendouManager {

    @Inject
    private BT_NenkinInfoRendouDao nenkinInfoRendouDao;

    List<BT_NenkinInfoRendou> getAllNenkinInfoRendou(){
        SortBT_NenkinInfoRendou sortBT_NenkinInfoRendou = new SortBT_NenkinInfoRendou();
        return sortBT_NenkinInfoRendou.OrderBT_NenkinInfoRendouByPkAsc(nenkinInfoRendouDao.selectAll());
    }

    BT_NenkinInfoRendou getNenkinInfoRendou(BizDate pSyoriYmd, String pSyono, Integer pRenno) {

        return nenkinInfoRendouDao.getNenkinInfoRendou(pSyoriYmd, pSyono, pRenno);
    }

    ExDBUpdatableResults<BT_NenkinInfoRendou> getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBUpdatableResults<BT_NenkinInfoRendou> exDBResults = nenkinInfoRendouDao.getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

}
