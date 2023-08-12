package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_DsHanyouKokyakuTuutiRnDao;
import yuyu.def.db.dao.ZT_DsHanyouKokyakuTuutiTyDao;
import yuyu.def.db.dao.ZT_DsKariPasswordTuutiRnDao;
import yuyu.def.db.dao.ZT_DsKariPasswordTuutiTyDao;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;


/**
 * DirectServiceDomマネージャー<br />
 * DirectServiceにおける、DB操作を提供する。<br />
 */
class DirectServiceDomManager {

    @Inject
    private ZT_DsHanyouKokyakuTuutiRnDao dsHanyouKokyakuTuutiRnDao;

    @Inject
    private ZT_DsHanyouKokyakuTuutiTyDao dsHanyouKokyakuTuutiTyDao;

    @Inject
    private ZT_DsKariPasswordTuutiRnDao dsKariPasswordTuutiRnDao;

    @Inject
    private ZT_DsKariPasswordTuutiTyDao dsKariPasswordTuutiTyDao;

    ExDBResults<ZT_DsKariPasswordTuutiTy> getAllDsKariPasswordTuutiTy(){
        return dsKariPasswordTuutiTyDao.selectAllZT_DsKariPasswordTuutiTy();
    }


    ZT_DsKariPasswordTuutiTy getDsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {

        return dsKariPasswordTuutiTyDao.getDsKariPasswordTuutiTy(pZtykrpasswordtuutikey);
    }

    ExDBResults<ZT_DsKariPasswordTuutiRn> getAllDsKariPasswordTuutiRn(){
        return dsKariPasswordTuutiRnDao.selectAllZT_DsKariPasswordTuutiRn();
    }


    ZT_DsKariPasswordTuutiRn getDsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {

        return dsKariPasswordTuutiRnDao.getDsKariPasswordTuutiRn(pZrnkrpasswordtuutikey);
    }

    ExDBResults<ZT_DsHanyouKokyakuTuutiRn> getAllDsHanyouKokyakuTuutiRn(){
        return dsHanyouKokyakuTuutiRnDao.selectAllZT_DsHanyouKokyakuTuutiRn();
    }

    ZT_DsHanyouKokyakuTuutiRn getDsHanyouKokyakuTuutiRn(String pZrndshanyoukokatetuutikey, String pZrndskokno, String pZrndstuutikbn) {

        return dsHanyouKokyakuTuutiRnDao.getDsHanyouKokyakuTuutiRn(pZrndshanyoukokatetuutikey, pZrndskokno, pZrndstuutikbn);
    }

    ExDBResults<ZT_DsHanyouKokyakuTuutiTy> getAllDsHanyouKokyakuTuutiTy(){
        return dsHanyouKokyakuTuutiTyDao.selectAllZT_DsHanyouKokyakuTuutiTy();
    }

    ZT_DsHanyouKokyakuTuutiTy getDsHanyouKokyakuTuutiTy(String pZtydshanyoukokatetuutikey, String pZtydskokno, String pZtydstuutikbn) {

        return dsHanyouKokyakuTuutiTyDao.getDsHanyouKokyakuTuutiTy(pZtydshanyoukokatetuutikey, pZtydskokno, pZtydstuutikbn);
    }

}
