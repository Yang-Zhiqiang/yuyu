package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_SntkInfoTourokuTyDao;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;


/**
 * NayosedisksousinDomマネージャー<br />
 * Nayosedisksousinにおける、DB操作を提供する。<br />
 */
class NayosedisksousinDomManager {

    @Inject
    private ZT_SntkInfoTourokuTyDao sntkInfoTourokuTyDao;

    ExDBResults<ZT_SntkInfoTourokuTy> getAllSntkInfoTourokuTy(){
        return sntkInfoTourokuTyDao.selectAllZT_SntkInfoTourokuTy();
    }


}
