package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.HV_MosSyoruiMitoutyakuListDao;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.sinkeiyaku.sorter.SortHV_MosSyoruiMitoutyakuList;


/**
 * ViewDomマネージャー<br />
 * Viewにおける、DB操作を提供する。<br />
 */
class ViewDomManager {

    @Inject
    private HV_MosSyoruiMitoutyakuListDao mosSyoruiMitoutyakuListDao;

    List<HV_MosSyoruiMitoutyakuList> getAllMosSyoruiMitoutyakuList(){
        SortHV_MosSyoruiMitoutyakuList sortHV_MosSyoruiMitoutyakuList = new SortHV_MosSyoruiMitoutyakuList();
        return sortHV_MosSyoruiMitoutyakuList.OrderHV_MosSyoruiMitoutyakuListByPkAsc(mosSyoruiMitoutyakuListDao.selectAll());
    }

    HV_MosSyoruiMitoutyakuList getMosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno) {

        return mosSyoruiMitoutyakuListDao.getMosSyoruiMitoutyakuList(pSyoriYmd, pItirenno);
    }

    ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate pKnjyymd) {

        return mosSyoruiMitoutyakuListDao.getMosSyoruiMitoutyakuListsByKnjyymdLe(pKnjyymd);
    }

}
