package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_OnlineLincSousinRnDao;
import yuyu.def.db.dao.ZT_OnlineLincSousinTyDao;
import yuyu.def.db.dao.ZT_YakansyoriLincSousinRnDao;
import yuyu.def.db.dao.ZT_YakansyoriLincSousinTyDao;
import yuyu.def.db.entity.ZT_OnlineLincSousinRn;
import yuyu.def.db.entity.ZT_OnlineLincSousinTy;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinRn;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinTy;

/**
 * SinkeiyakuLincSosinDomマネージャー<br />
 * SinkeiyakuLincSosinにおける、DB操作を提供する。<br />
 */
class SinkeiyakuLincSosinDomManager {

    @Inject
    private ZT_OnlineLincSousinRnDao onlineLincSousinRnDao;

    @Inject
    private ZT_OnlineLincSousinTyDao onlineLincSousinTyDao;

    @Inject
    private ZT_YakansyoriLincSousinRnDao yakansyoriLincSousinRnDao;

    @Inject
    private ZT_YakansyoriLincSousinTyDao yakansyoriLincSousinTyDao;

    ExDBResults<ZT_OnlineLincSousinTy> getAllOnlineLincSousinTy(){
        return onlineLincSousinTyDao.selectAllZT_OnlineLincSousinTy();
    }

    ZT_OnlineLincSousinTy getOnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {

        return onlineLincSousinTyDao.getOnlineLincSousinTy(pZtyrecordsyubetukbn, pZtykykkanrino);
    }

    ExDBResults<ZT_OnlineLincSousinRn> getAllOnlineLincSousinRn(){
        return onlineLincSousinRnDao.selectAllZT_OnlineLincSousinRn();
    }

    ZT_OnlineLincSousinRn getOnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {

        return onlineLincSousinRnDao.getOnlineLincSousinRn(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }

    ExDBResults<ZT_YakansyoriLincSousinTy> getAllYakansyoriLincSousinTy(){
        return yakansyoriLincSousinTyDao.selectAllZT_YakansyoriLincSousinTy();
    }

    ZT_YakansyoriLincSousinTy getYakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {

        return yakansyoriLincSousinTyDao.getYakansyoriLincSousinTy(pZtyrecordsyubetukbn, pZtykykkanrino);
    }

    ExDBResults<ZT_YakansyoriLincSousinRn> getAllYakansyoriLincSousinRn(){
        return yakansyoriLincSousinRnDao.selectAllZT_YakansyoriLincSousinRn();
    }

    ZT_YakansyoriLincSousinRn getYakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {

        return yakansyoriLincSousinRnDao.getYakansyoriLincSousinRn(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }

}
