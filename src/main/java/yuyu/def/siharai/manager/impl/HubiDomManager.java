package yuyu.def.siharai.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.JT_SiHubiDao;
import yuyu.def.db.dao.JT_SiHubiDetailDao;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.def.siharai.result.bean.SiHubisSiHubiDetailsBySyonoBean;
import yuyu.def.siharai.sorter.SortJT_SiHubi;


/**
 * HubiDomマネージャー<br />
 * Hubiにおける、DB操作を提供する。<br />
 */
class HubiDomManager {


    @Inject
    private JT_SiHubiDao siHubiDao;


    @Inject
    private JT_SiHubiDetailDao siHubiDetailDao;


    List<JT_SiHubi> getAllSiHubi(){
        SortJT_SiHubi sortJT_SiHubi = new SortJT_SiHubi();
        return sortJT_SiHubi.OrderJT_SiHubiByPkAsc(siHubiDao.selectAll());
    }


    JT_SiHubi getSiHubi(String pHubisikibetukey) {

        return siHubiDao.getSiHubi(pHubisikibetukey);
    }


    JT_SiHubi getSiHubiByHubisikibetukeyHasinymd(String pHubisikibetukey, BizDate pHasinymd) {

        return siHubiDao.getSiHubiByHubisikibetukeyHasinymd(pHubisikibetukey, pHasinymd);
    }


    List<JT_SiHubi> getSiHubisBySyono(String pSyono) {

        return siHubiDao.getSiHubisBySyono(pSyono);
    }


    List<SiHubisSiHubiDetailsBySyonoBean> getSiHubisSiHubiDetailsBySyono(String pSyono) {

        return siHubiDao.getSiHubisSiHubiDetailsBySyono(pSyono);
    }


    ExDBResults<HubiTourokuInfosByHasinymdBean> getHubiTourokuInfosByHasinymd(BizDate pHasinymd) {

        return siHubiDao.getHubiTourokuInfosByHasinymd(pHasinymd);
    }


    Integer getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(String pHubisikibetukey) {

        return siHubiDetailDao.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(pHubisikibetukey);
    }

}
