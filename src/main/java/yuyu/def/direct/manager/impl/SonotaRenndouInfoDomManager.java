package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.dao.MT_DsKouzokuJimuKakuninDao;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.direct.sorter.SortMT_DsKouzokuJimuKakunin;


/**
 * SonotaRenndouInfoDomマネージャー<br />
 * SonotaRenndouInfoにおける、DB操作を提供する。<br />
 */
class SonotaRenndouInfoDomManager {

    @Inject
    private MT_DsKouzokuJimuKakuninDao dsKouzokuJimuKakuninDao;

    List<MT_DsKouzokuJimuKakunin> getAllDsKouzokuJimuKakunin(){
        SortMT_DsKouzokuJimuKakunin sortMT_DsKouzokuJimuKakunin = new SortMT_DsKouzokuJimuKakunin();
        return sortMT_DsKouzokuJimuKakunin.OrderMT_DsKouzokuJimuKakuninByPkAsc(dsKouzokuJimuKakuninDao.selectAll());
    }

    MT_DsKouzokuJimuKakunin getDsKouzokuJimuKakunin(BizDate pHasseiymd, C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn, String pSyono) {

        return dsKouzokuJimuKakuninDao.getDsKouzokuJimuKakunin(pHasseiymd, pDskzkjmkknhsjykbn, pSyono);
    }

    ExDBResults<MT_DsKouzokuJimuKakunin> getDsKouzokuJimuKakuninsByHasseiymd(BizDate pHasseiymd) {

        return dsKouzokuJimuKakuninDao.getDsKouzokuJimuKakuninsByHasseiymd(pHasseiymd);
    }

}
