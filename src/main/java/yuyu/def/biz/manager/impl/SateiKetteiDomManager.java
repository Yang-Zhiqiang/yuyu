package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.sorter.SortBM_HutanpoBui;
import yuyu.def.biz.sorter.SortBM_LincKaisyacd;
import yuyu.def.biz.sorter.SortBM_Syokugyou;
import yuyu.def.biz.sorter.SortBM_Syoubyou;
import yuyu.def.db.dao.BM_HutanpoBuiDao;
import yuyu.def.db.dao.BM_LincKaisyacdDao;
import yuyu.def.db.dao.BM_SyokugyouDao;
import yuyu.def.db.dao.BM_SyoubyouDao;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.entity.BM_Syoubyou;


/**
 * SateiKetteiDomマネージャー<br />
 * SateiKetteiにおける、DB操作を提供する。<br />
 */
class SateiKetteiDomManager {

    @Inject
    private BM_HutanpoBuiDao hutanpoBuiDao;

    @Inject
    private BM_SyokugyouDao syokugyouDao;

    @Inject
    private BM_SyoubyouDao syoubyouDao;

    @Inject
    private BM_LincKaisyacdDao lincKaisyacdDao;

    List<BM_HutanpoBui> getAllHutanpoBui(){
        SortBM_HutanpoBui sortBM_HutanpoBui = new SortBM_HutanpoBui();
        return sortBM_HutanpoBui.OrderBM_HutanpoBuiByPkAsc(hutanpoBuiDao.selectAll());
    }

    BM_HutanpoBui getHutanpoBui(String pHtnpbuicd) {

        return hutanpoBuiDao.getHutanpoBui(pHtnpbuicd);
    }

    List<BM_Syoubyou> getAllSyoubyou(){
        SortBM_Syoubyou sortBM_Syoubyou = new SortBM_Syoubyou();
        return sortBM_Syoubyou.OrderBM_SyoubyouByPkAsc(syoubyouDao.selectAll());
    }

    BM_Syoubyou getSyoubyou(String pSyoubyoucd) {

        return syoubyouDao.getSyoubyou(pSyoubyoucd);
    }

    List<BM_Syoubyou> getSyoubyousBySyoubyoucdSyoubyounm(String pSyoubyoucd, String pSyoubyounm) {
        return syoubyouDao.getSyoubyousBySyoubyoucdSyoubyounm(pSyoubyoucd, pSyoubyounm);
    }

    List<BM_Syokugyou> getAllSyokugyou(){
        SortBM_Syokugyou sortBM_Syokugyou = new SortBM_Syokugyou();
        return sortBM_Syokugyou.OrderBM_SyokugyouByPkAsc(syokugyouDao.selectAll());
    }

    BM_Syokugyou getSyokugyou(String pSyokugyoucd) {

        return syokugyouDao.getSyokugyou(pSyokugyoucd);
    }

    List<BM_Syokugyou> getSyokugyousBySyokugyoucdSyokugyounm(String pSyokugyoucd, String pSyokugyounm) {
        return syokugyouDao.getSyokugyousBySyokugyoucdSyokugyounm(pSyokugyoucd, pSyokugyounm);
    }
    List<BM_LincKaisyacd> getAllLincKaisyacd(){
        SortBM_LincKaisyacd sortBM_LincKaisyacd = new SortBM_LincKaisyacd();
        return sortBM_LincKaisyacd.OrderBM_LincKaisyacdByPkAsc(lincKaisyacdDao.selectAll());
    }

    BM_LincKaisyacd getLincKaisyacd(String pLinckaisyacdnum) {

        return lincKaisyacdDao.getLincKaisyacd(pLinckaisyacdnum);
    }

}
