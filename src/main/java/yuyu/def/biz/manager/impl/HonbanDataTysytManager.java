package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.sorter.SortBM_TestSyonokanri;
import yuyu.def.biz.sorter.SortBT_TestKykData;
import yuyu.def.db.dao.BM_TestSyonokanriDao;
import yuyu.def.db.dao.BT_TestKykDataDao;
import yuyu.def.db.entity.BM_TestSyonokanri;
import yuyu.def.db.entity.BT_TestKykData;


/**
 * HonbanDataTysytManagerDomマネージャー<br />
 * HonbanDataTysytManagerにおける、DB操作を提供する。<br />
 */
class HonbanDataTysytManager {

    @Inject
    private BM_TestSyonokanriDao testSyonokanriDao;

    @Inject
    private BT_TestKykDataDao testKykDataDao;

    List<BM_TestSyonokanri> getAllTestSyonokanri(){
        SortBM_TestSyonokanri sortBM_TestSyonokanri = new SortBM_TestSyonokanri();
        return sortBM_TestSyonokanri.OrderBM_TestSyonokanriByPkAsc(testSyonokanriDao.selectAll());
    }

    BM_TestSyonokanri getTestSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno) {

        return testSyonokanriDao.getTestSyonokanri(pSeirekinen2keta, pBosyuusosikicd, pSyonorenno);
    }

    List<BT_TestKykData> getAllTestKykData(){
        SortBT_TestKykData sortBT_TestKykData = new SortBT_TestKykData();
        return sortBT_TestKykData.OrderBT_TestKykDataByPkAsc(testKykDataDao.selectAll());
    }

    BT_TestKykData getTestKykData(String pUniqueId) {

        return testKykDataDao.getTestKykData(pUniqueId);
    }

}
