package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_LincJyusinRnDao;
import yuyu.def.db.dao.ZT_LincJyusinTrDao;
import yuyu.def.db.entity.ZT_LincJyusinRn;
import yuyu.def.db.entity.ZT_LincJyusinTr;

/**
 * SinkeiyakuLincJyusinDomマネージャー<br />
 * SinkeiyakuLincJyusinにおける、DB操作を提供する。<br />
 */
class SinkeiyakuLincJyusinDomManager {

    @Inject
    private ZT_LincJyusinRnDao lincJyusinRnDao;

    @Inject
    private ZT_LincJyusinTrDao lincJyusinTrDao;

    ExDBResults<ZT_LincJyusinRn> getAllLincJyusinRn(){
        return lincJyusinRnDao.selectAllZT_LincJyusinRn();
    }

    ZT_LincJyusinRn getLincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {

        return lincJyusinRnDao.getLincJyusinRn(pZrnsyoriymd, pZrnrenno10);
    }

    ExDBResults<ZT_LincJyusinTr> getAllLincJyusinTr(){
        return lincJyusinTrDao.selectAllZT_LincJyusinTr();
    }

    ZT_LincJyusinTr getLincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {

        return lincJyusinTrDao.getLincJyusinTr(pZtrsyoriymd, pZtrrenno10);
    }

}
