package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.dao.MT_DsTourokuUkKanriDao;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.direct.sorter.SortMT_DsTourokuUkKanri;


/**
 * TourokujyouknrInfoDomマネージャー<br />
 * TourokujyouknrInfoにおける、DB操作を提供する。<br />
 */
class TourokujyouknrInfoDomManager {

    @Inject
    private MT_DsTourokuUkKanriDao dsTourokuUkKanriDao;

    List<MT_DsTourokuUkKanri> getAllDsTourokuUkKanri(){
        SortMT_DsTourokuUkKanri sortMT_DsTourokuUkKanri = new SortMT_DsTourokuUkKanri();
        return sortMT_DsTourokuUkKanri.OrderMT_DsTourokuUkKanriByPkAsc(dsTourokuUkKanriDao.selectAll());
    }

    MT_DsTourokuUkKanri getDsTourokuUkKanri(String pSyono, C_DsTtdksyubetuKbn pDsttdksyubetukbn, Integer pDatarenno) {

        return dsTourokuUkKanriDao.getDsTourokuUkKanri(pSyono, pDsttdksyubetukbn, pDatarenno);
    }

}
