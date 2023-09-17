package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.sorter.SortBT_SystemRenkei;
import yuyu.def.db.dao.BT_SystemRenkeiDao;
import yuyu.def.db.entity.BT_SystemRenkei;


/**
 * SystemRenkeiDomマネージャー<br />
 * SystemRenkeiにおける、DB操作を提供する。<br />
 */
class SystemRenkeiDomManager {

    @Inject
    private BT_SystemRenkeiDao systemRenkeiDao;

    List<BT_SystemRenkei> getAllSystemRenkei(){
        SortBT_SystemRenkei sortBT_SystemRenkei = new SortBT_SystemRenkei();
        return sortBT_SystemRenkei.OrderBT_SystemRenkeiByPkAsc(systemRenkeiDao.selectAll());
    }

    BT_SystemRenkei getSystemRenkei(String pInterfaceid) {

        return systemRenkeiDao.getSystemRenkei(pInterfaceid);
    }

}
