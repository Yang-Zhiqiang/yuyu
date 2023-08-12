package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_SmbcSkMeisaiRendouRnDao;
import yuyu.def.db.dao.ZT_SmbcSkMeisaiRendouTyDao;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;


/**
 * SinkeiyakuetcDomマネージャー<br />
 * Sinkeiyakuetcにおける、DB操作を提供する。<br />
 */
class SinkeiyakuetcDomManager {

    @Inject
    private ZT_SmbcSkMeisaiRendouRnDao smbcSkMeisaiRendouRnDao;

    @Inject
    private ZT_SmbcSkMeisaiRendouTyDao smbcSkMeisaiRendouTyDao;

    ExDBResults<ZT_SmbcSkMeisaiRendouTy> getAllSmbcSkMeisaiRendouTy(){
        return smbcSkMeisaiRendouTyDao.selectAllZT_SmbcSkMeisaiRendouTy();
    }


    ZT_SmbcSkMeisaiRendouTy getSmbcSkMeisaiRendouTy(String pZtysmbcdatakbn, String pZtysmbcdatasakuseiymd, String pZtysmbchknkaisyacd, String pZtysmbcuktkkanriid) {

        return smbcSkMeisaiRendouTyDao.getSmbcSkMeisaiRendouTy(pZtysmbcdatakbn, pZtysmbcdatasakuseiymd, pZtysmbchknkaisyacd, pZtysmbcuktkkanriid);
    }

    ExDBResults<ZT_SmbcSkMeisaiRendouRn> getAllSmbcSkMeisaiRendouRn(){
        return smbcSkMeisaiRendouRnDao.selectAllZT_SmbcSkMeisaiRendouRn();
    }


    ZT_SmbcSkMeisaiRendouRn getSmbcSkMeisaiRendouRn(String pZrnsmbcdatakbn, String pZrnsmbcdatasakuseiymd, String pZrnsmbchknkaisyacd, String pZrnsmbcuktkkanriid) {

        return smbcSkMeisaiRendouRnDao.getSmbcSkMeisaiRendouRn(pZrnsmbcdatakbn, pZrnsmbcdatasakuseiymd, pZrnsmbchknkaisyacd, pZrnsmbcuktkkanriid);
    }

}
