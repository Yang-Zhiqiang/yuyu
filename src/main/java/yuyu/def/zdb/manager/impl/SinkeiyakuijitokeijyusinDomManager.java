package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_IjiToukeiIdouInfoRnDao;
import yuyu.def.db.dao.ZT_IjiToukeiIdouInfoTrDao;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;


/**
 * SinkeiyakuijitokeijyusinDomマネージャー<br />
 * Sinkeiyakuijitokeijyusinにおける、DB操作を提供する。<br />
 */
class SinkeiyakuijitokeijyusinDomManager {

    @Inject
    private ZT_IjiToukeiIdouInfoRnDao ijiToukeiIdouInfoRnDao;

    @Inject
    private ZT_IjiToukeiIdouInfoTrDao ijiToukeiIdouInfoTrDao;

    ExDBResults<ZT_IjiToukeiIdouInfoRn> getAllIjiToukeiIdouInfoRn(){
        return ijiToukeiIdouInfoRnDao.selectAllZT_IjiToukeiIdouInfoRn();
    }


    ZT_IjiToukeiIdouInfoRn getIjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {

        return ijiToukeiIdouInfoRnDao.getIjiToukeiIdouInfoRn(pZrnsyono, pZrnkykmfksnctr);
    }

    ExDBResults<ZT_IjiToukeiIdouInfoTr> getAllIjiToukeiIdouInfoTr(){
        return ijiToukeiIdouInfoTrDao.selectAllZT_IjiToukeiIdouInfoTr();
    }


    ZT_IjiToukeiIdouInfoTr getIjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {

        return ijiToukeiIdouInfoTrDao.getIjiToukeiIdouInfoTr(pZtrsyono, pZtrkykmfksnctr);
    }

}
