package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.sorter.SortBM_RecoveryFilter;
import yuyu.def.biz.sorter.SortBT_SkipKey;
import yuyu.def.db.dao.BM_RecoveryFilterDao;
import yuyu.def.db.dao.BT_SkipKeyDao;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;


/**
 * MaintenanceBatchRecoveryDomマネージャー<br />
 * MaintenanceBatchRecoveryにおける、DB操作を提供する。<br />
 */
class MaintenanceBatchRecoveryDomManager {

    @Inject
    private BM_RecoveryFilterDao recoveryFilterDao;

    @Inject
    private BT_SkipKeyDao skipKeyDao;

    List<BT_SkipKey> getAllSkipKey(){
        SortBT_SkipKey sortBT_SkipKey = new SortBT_SkipKey();
        return sortBT_SkipKey.OrderBT_SkipKeyByPkAsc(skipKeyDao.selectAll());
    }

    BT_SkipKey getSkipKey(String pRecoverysikibetukey) {

        return skipKeyDao.getSkipKey(pRecoverysikibetukey);
    }

    List<BM_RecoveryFilter> getAllRecoveryFilter(){
        SortBM_RecoveryFilter sortBM_RecoveryFilter = new SortBM_RecoveryFilter();
        return sortBM_RecoveryFilter.OrderBM_RecoveryFilterByPkAsc(recoveryFilterDao.selectAll());
    }

    BM_RecoveryFilter getRecoveryFilter(String pRecoveryfilterid) {

        return recoveryFilterDao.getRecoveryFilter(pRecoveryfilterid);
    }

}
