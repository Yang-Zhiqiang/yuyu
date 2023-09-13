package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.dao.MW_DsMailHaisinRirekiWkDao;
import yuyu.def.db.dao.MW_DsNeugokiHanteiKekkaWkDao;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.direct.sorter.SortMW_DsMailHaisinRirekiWk;
import yuyu.def.direct.sorter.SortMW_DsNeugokiHanteiKekkaWk;

/**
 * DirectWkInfoDommanagerDomマネージャー<br />
 * DirectWkInfoDommanagerにおける、DB操作を提供する。<br />
 */
class DirectWkInfoDommanager {

    @Inject
    private MW_DsMailHaisinRirekiWkDao dsMailHaisinRirekiWkDao;

    @Inject
    private MW_DsNeugokiHanteiKekkaWkDao dsNeugokiHanteiKekkaWkDao;

    List<MW_DsNeugokiHanteiKekkaWk> getAllDsNeugokiHanteiKekkaWk(){
        SortMW_DsNeugokiHanteiKekkaWk sortMW_DsNeugokiHanteiKekkaWk = new SortMW_DsNeugokiHanteiKekkaWk();
        return sortMW_DsNeugokiHanteiKekkaWk.OrderMW_DsNeugokiHanteiKekkaWkByPkAsc(dsNeugokiHanteiKekkaWkDao.selectAll());
    }

    MW_DsNeugokiHanteiKekkaWk getDsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono) {

        return dsNeugokiHanteiKekkaWkDao.getDsNeugokiHanteiKekkaWk(pDsdatasakuseiymd, pSyono);
    }

    List<MW_DsMailHaisinRirekiWk> getAllDsMailHaisinRirekiWk(){
        SortMW_DsMailHaisinRirekiWk sortMW_DsMailHaisinRirekiWk = new SortMW_DsMailHaisinRirekiWk();
        return sortMW_DsMailHaisinRirekiWk.OrderMW_DsMailHaisinRirekiWkByPkAsc(dsMailHaisinRirekiWkDao.selectAll());
    }

    MW_DsMailHaisinRirekiWk getDsMailHaisinRirekiWk(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailhaisinrenban) {

        return dsMailHaisinRirekiWkDao.getDsMailHaisinRirekiWk(pDsdatasakuseiymd, pDskokno, pDsmailhaisinrenban);
    }

}
