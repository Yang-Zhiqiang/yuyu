package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.dao.IT_AnsyuKihonDao;
import yuyu.def.db.dao.IT_AnsyuRirekiDao;
import yuyu.def.db.dao.IT_BAK_AnsyuKihonDao;
import yuyu.def.db.dao.IT_HrkmNyknDataHznDao;
import yuyu.def.db.dao.IT_HsgbnktAnnaihouhoukanriDao;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_HrkmNyknDataHzn;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import yuyu.def.hozen.sorter.SortIT_AnsyuKihon;
import yuyu.def.hozen.sorter.SortIT_BAK_AnsyuKihon;
import yuyu.def.hozen.sorter.SortIT_HrkmNyknDataHzn;
import yuyu.def.hozen.sorter.SortIT_HsgbnktAnnaihouhoukanri;

/**
 * AnsyuDomマネージャー<br />
 * Ansyuにおける、DB操作を提供する。<br />
 */
class AnsyuDomManager {

    @Inject
    private IT_AnsyuKihonDao ansyuKihonDao;

    @Inject
    private IT_AnsyuRirekiDao ansyuRirekiDao;

    @Inject
    private IT_BAK_AnsyuKihonDao bAK_AnsyuKihonDao;

    @Inject
    private IT_HrkmNyknDataHznDao hrkmNyknDataHznDao;

    @Inject
    private IT_HsgbnktAnnaihouhoukanriDao hsgbnktAnnaihouhoukanriDao;

    List<IT_AnsyuKihon> getAllAnsyuKihon() {
        SortIT_AnsyuKihon sortIT_AnsyuKihon = new SortIT_AnsyuKihon();
        return sortIT_AnsyuKihon.OrderIT_AnsyuKihonByPkAsc(ansyuKihonDao.selectAll());
    }

    IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        return ansyuKihonDao.getAnsyuKihon(pSyono);
    }

    List<IT_BAK_AnsyuKihon> getAllBAKAnsyuKihon() {
        SortIT_BAK_AnsyuKihon sortIT_BAK_AnsyuKihon = new SortIT_BAK_AnsyuKihon();
        return sortIT_BAK_AnsyuKihon.OrderIT_BAK_AnsyuKihonByPkAsc(bAK_AnsyuKihonDao.selectAll());
    }

    IT_BAK_AnsyuKihon getBAKAnsyuKihon(String pSyono, String pTrkssikibetukey) {

        return bAK_AnsyuKihonDao.getBAKAnsyuKihon(pSyono, pTrkssikibetukey);
    }

    List<IT_HrkmNyknDataHzn> getAllHrkmNyknDataHzn() {
        SortIT_HrkmNyknDataHzn sortIT_HrkmNyknDataHzn = new SortIT_HrkmNyknDataHzn();
        return sortIT_HrkmNyknDataHzn.OrderIT_HrkmNyknDataHznByPkAsc(hrkmNyknDataHznDao.selectAll());
    }

    IT_HrkmNyknDataHzn getHrkmNyknDataHzn(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {

        return hrkmNyknDataHznDao.getHrkmNyknDataHzn(pDensyskbn, pSyoriYmd, pItirenno);
    }

    List<IT_HsgbnktAnnaihouhoukanri> getAllHsgbnktAnnaihouhoukanri() {
        SortIT_HsgbnktAnnaihouhoukanri sortIT_HsgbnktAnnaihouhoukanri = new SortIT_HsgbnktAnnaihouhoukanri();
        return sortIT_HsgbnktAnnaihouhoukanri.OrderIT_HsgbnktAnnaihouhoukanriByPkAsc(hsgbnktAnnaihouhoukanriDao
            .selectAll());
    }

    IT_HsgbnktAnnaihouhoukanri getHsgbnktAnnaihouhoukanri(String pSyono, BizDate pHsgymd) {

        return hsgbnktAnnaihouhoukanriDao.getHsgbnktAnnaihouhoukanri(pSyono, pHsgymd);
    }

}
