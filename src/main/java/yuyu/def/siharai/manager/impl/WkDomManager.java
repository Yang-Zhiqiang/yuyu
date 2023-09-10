package yuyu.def.siharai.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.dao.JW_HubiKaisyouDetailWkDao;
import yuyu.def.db.dao.JW_HubiWkDao;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.entity.JW_HubiWk;
import yuyu.def.siharai.sorter.SortJW_HubiKaisyouDetailWk;
import yuyu.def.siharai.sorter.SortJW_HubiWk;


/**
 * WkDomマネージャー<br />
 * Wkにおける、DB操作を提供する。<br />
 */
class WkDomManager {

    @Inject
    private JW_HubiKaisyouDetailWkDao hubiKaisyouDetailWkDao;

    @Inject
    private JW_HubiWkDao hubiWkDao;

    List<JW_HubiWk> getAllHubiWk(){
        SortJW_HubiWk sortJW_HubiWk = new SortJW_HubiWk();
        return sortJW_HubiWk.OrderJW_HubiWkByPkAsc(hubiWkDao.selectAll());
    }

    JW_HubiWk getHubiWk(String pKouteikanriid) {

        return hubiWkDao.getHubiWk(pKouteikanriid);
    }

    List<JW_HubiKaisyouDetailWk> getAllHubiKaisyouDetailWk(){
        SortJW_HubiKaisyouDetailWk sortJW_HubiKaisyouDetailWk = new SortJW_HubiKaisyouDetailWk();
        return sortJW_HubiKaisyouDetailWk.OrderJW_HubiKaisyouDetailWkByPkAsc(hubiKaisyouDetailWkDao.selectAll());
    }

    JW_HubiKaisyouDetailWk getHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {

        return hubiKaisyouDetailWkDao.getHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }

    List<JW_HubiKaisyouDetailWk> getHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid) {

        return hubiKaisyouDetailWkDao.getHubiKaisyouDetailWksByKouteikanriid(pKouteikanriid);
    }

}
