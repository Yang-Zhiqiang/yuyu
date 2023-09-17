package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.biz.sorter.SortBT_KijituTouraiHonbanKensyou;
import yuyu.def.biz.sorter.SortBT_KijituTuriHnbnKnsouTut;
import yuyu.def.biz.sorter.SortBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.dao.BT_KijituTouraiHonbanKensyouDao;
import yuyu.def.db.dao.BT_KijituTuriHnbnKnsouTutDao;
import yuyu.def.db.dao.BT_KijituTuriHnbnKnsouTutJkDao;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;


/**
 * SystemHonbanKsDomマネージャー<br />
 * SystemHonbanKsにおける、DB操作を提供する。<br />
 */
class SystemHonbanKsDomManager {

    @Inject
    private BT_KijituTouraiHonbanKensyouDao kijituTouraiHonbanKensyouDao;

    @Inject
    private BT_KijituTuriHnbnKnsouTutDao kijituTuriHnbnKnsouTutDao;

    @Inject
    private BT_KijituTuriHnbnKnsouTutJkDao kijituTuriHnbnKnsouTutJkDao;

    List<BT_KijituTuriHnbnKnsouTut> getAllKijituTuriHnbnKnsouTut(){
        SortBT_KijituTuriHnbnKnsouTut sortBT_KijituTuriHnbnKnsouTut = new SortBT_KijituTuriHnbnKnsouTut();
        return sortBT_KijituTuriHnbnKnsouTut.OrderBT_KijituTuriHnbnKnsouTutByPkAsc(kijituTuriHnbnKnsouTutDao.selectAll());
    }

    BT_KijituTuriHnbnKnsouTut getKijituTuriHnbnKnsouTut(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno) {

        return kijituTuriHnbnKnsouTutDao.getKijituTuriHnbnKnsouTut(pSyoriYmd, pSubSystemId, pTysytno);
    }

    List<BT_KijituTuriHnbnKnsouTutJk> getAllKijituTuriHnbnKnsouTutJk(){
        SortBT_KijituTuriHnbnKnsouTutJk sortBT_KijituTuriHnbnKnsouTutJk = new SortBT_KijituTuriHnbnKnsouTutJk();
        return sortBT_KijituTuriHnbnKnsouTutJk.OrderBT_KijituTuriHnbnKnsouTutJkByPkAsc(kijituTuriHnbnKnsouTutJkDao.selectAll());
    }

    BT_KijituTuriHnbnKnsouTutJk getKijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {

        return kijituTuriHnbnKnsouTutJkDao.getKijituTuriHnbnKnsouTutJk(pSubSystemId, pTysytno);
    }

    List<BT_KijituTouraiHonbanKensyou> getAllKijituTouraiHonbanKensyou(){
        SortBT_KijituTouraiHonbanKensyou sortBT_KijituTouraiHonbanKensyou = new SortBT_KijituTouraiHonbanKensyou();
        return sortBT_KijituTouraiHonbanKensyou.OrderBT_KijituTouraiHonbanKensyouByPkAsc(kijituTouraiHonbanKensyouDao.selectAll());
    }

    BT_KijituTouraiHonbanKensyou getKijituTouraiHonbanKensyou(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno, String pDatakanrino) {

        return kijituTouraiHonbanKensyouDao.getKijituTouraiHonbanKensyou(pSyoriYmd, pSubSystemId, pTysytno, pDatakanrino);
    }

}
