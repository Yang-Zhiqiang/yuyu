package yuyu.def.siharai.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.dao.JT_OutaiDao;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.siharai.sorter.SortJT_Outai;


/**
 * OutaiDomマネージャー<br />
 * Outaiにおける、DB操作を提供する。<br />
 */
class OutaiDomManager {

    @Inject
    private JT_OutaiDao outaiDao;

    List<JT_Outai> getAllOutai(){
        SortJT_Outai sortJT_Outai = new SortJT_Outai();
        return sortJT_Outai.OrderJT_OutaiByPkAsc(outaiDao.selectAll());
    }

    JT_Outai getOutai(String pSyono, Integer pRenno) {

        return outaiDao.getOutai(pSyono, pRenno);
    }

    Integer getOutaiMaxRennoBySyono(String pSyono) {

        return outaiDao.getOutaiMaxRennoBySyono(pSyono);
    }

}
