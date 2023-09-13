package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;
import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import yuyu.def.db.dao.MT_SousaRirekiDao;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.direct.sorter.SortMT_SousaRireki;


/**
 * SousaRirekiInfoDomマネージャー<br />
 * SousaRirekiInfoにおける、DB操作を提供する。<br />
 */
class SousaRirekiInfoDomManager {

    @Inject
    private MT_SousaRirekiDao sousaRirekiDao;

    List<MT_SousaRireki> getAllSousaRireki(){
        SortMT_SousaRireki sortMT_SousaRireki = new SortMT_SousaRireki();
        return sortMT_SousaRireki.OrderMT_SousaRirekiByPkAsc(sousaRirekiDao.selectAll());
    }

    MT_SousaRireki getSousaRireki(String pTtdksikibetuid) {

        return sousaRirekiDao.getSousaRireki(pTtdksikibetuid);
    }

}
