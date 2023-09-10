package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.dao.HT_SouseirituKihonDao;
import yuyu.def.db.entity.HT_SouseirituKihon;
import yuyu.def.sinkeiyaku.sorter.SortHT_SouseirituKihon;


/**
 * SouseirituInfoDomマネージャー<br />
 * SouseirituInfoにおける、DB操作を提供する。<br />
 */
class SouseirituInfoDomManager {

    @Inject
    private HT_SouseirituKihonDao souseirituKihonDao;

    List<HT_SouseirituKihon> getAllSouseirituKihon(){
        SortHT_SouseirituKihon sortHT_SouseirituKihon = new SortHT_SouseirituKihon();
        return sortHT_SouseirituKihon.OrderHT_SouseirituKihonByPkAsc(souseirituKihonDao.selectAll());
    }

    HT_SouseirituKihon getSouseirituKihon(String pSyono) {

        return souseirituKihonDao.getSouseirituKihon(pSyono);
    }

}
