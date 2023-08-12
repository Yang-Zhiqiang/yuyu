package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_KykIdouHaneiKekkaRnDao;
import yuyu.def.db.dao.ZT_KykIdouHaneiKekkaTrDao;
import yuyu.def.db.dao.ZT_SntkInfoHaneiKekkaRnDao;
import yuyu.def.db.dao.ZT_SntkInfoHaneiKekkaTrDao;
import yuyu.def.db.dao.ZT_SntkInfoTourokuRnDao;
import yuyu.def.db.dao.ZT_SntkInfoTourokuTyDao;
import yuyu.def.db.dao.ZT_TjtIdouNaiyouRnDao;
import yuyu.def.db.dao.ZT_TjtIdouNaiyouTyDao;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.entity.ZT_SntkInfoTourokuRn;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouRn;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;


/**
 * BizNayosedisksousinDomマネージャー<br />
 * BizNayosedisksousinにおける、DB操作を提供する。<br />
 */
class BizNayosedisksousinDomManager {

    @Inject
    private ZT_KykIdouHaneiKekkaRnDao kykIdouHaneiKekkaRnDao;

    @Inject
    private ZT_KykIdouHaneiKekkaTrDao kykIdouHaneiKekkaTrDao;

    @Inject
    private ZT_SntkInfoHaneiKekkaRnDao sntkInfoHaneiKekkaRnDao;

    @Inject
    private ZT_SntkInfoHaneiKekkaTrDao sntkInfoHaneiKekkaTrDao;

    @Inject
    private ZT_SntkInfoTourokuRnDao sntkInfoTourokuRnDao;

    @Inject
    private ZT_SntkInfoTourokuTyDao sntkInfoTourokuTyDao;

    @Inject
    private ZT_TjtIdouNaiyouRnDao tjtIdouNaiyouRnDao;

    @Inject
    private ZT_TjtIdouNaiyouTyDao tjtIdouNaiyouTyDao;

    ZT_SntkInfoTourokuTy getSntkInfoTourokuTy(String pZtysntkinfono, String pZtyrenno, String pZtysntkinfotourokusyskbn) {

        return sntkInfoTourokuTyDao.getSntkInfoTourokuTy(pZtysntkinfono, pZtyrenno, pZtysntkinfotourokusyskbn);
    }

    ExDBResults<ZT_SntkInfoTourokuRn> getAllSntkInfoTourokuRn(){
        return sntkInfoTourokuRnDao.selectAllZT_SntkInfoTourokuRn();
    }


    ZT_SntkInfoTourokuRn getSntkInfoTourokuRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {

        return sntkInfoTourokuRnDao.getSntkInfoTourokuRn(pZrnsntkinfono, pZrnrenno, pZrnsntkinfotourokusyskbn);
    }

    ExDBResults<ZT_TjtIdouNaiyouTy> getAllTjtIdouNaiyouTy(){
        return tjtIdouNaiyouTyDao.selectAllZT_TjtIdouNaiyouTy();
    }


    ZT_TjtIdouNaiyouTy getTjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {

        return tjtIdouNaiyouTyDao.getTjtIdouNaiyouTy(pZtyhuho2kyknokbn, pZtyhuho2kykno);
    }

    ExDBResults<ZT_TjtIdouNaiyouRn> getAllTjtIdouNaiyouRn(){
        return tjtIdouNaiyouRnDao.selectAllZT_TjtIdouNaiyouRn();
    }


    ZT_TjtIdouNaiyouRn getTjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {

        return tjtIdouNaiyouRnDao.getTjtIdouNaiyouRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

    ExDBResults<ZT_SntkInfoHaneiKekkaTr> getAllSntkInfoHaneiKekkaTr(){
        return sntkInfoHaneiKekkaTrDao.selectAllZT_SntkInfoHaneiKekkaTr();
    }


    ZT_SntkInfoHaneiKekkaTr getSntkInfoHaneiKekkaTr(String pZtrsntkinfono, Integer pZtrrenno, String pZtrsntkinfotourokusyskbn) {

        return sntkInfoHaneiKekkaTrDao.getSntkInfoHaneiKekkaTr(pZtrsntkinfono, pZtrrenno, pZtrsntkinfotourokusyskbn);
    }

    ExDBResults<ZT_SntkInfoHaneiKekkaRn> getAllSntkInfoHaneiKekkaRn(){
        return sntkInfoHaneiKekkaRnDao.selectAllZT_SntkInfoHaneiKekkaRn();
    }


    ZT_SntkInfoHaneiKekkaRn getSntkInfoHaneiKekkaRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {

        return sntkInfoHaneiKekkaRnDao.getSntkInfoHaneiKekkaRn(pZrnsntkinfono, pZrnrenno, pZrnsntkinfotourokusyskbn);
    }

    ExDBResults<ZT_KykIdouHaneiKekkaTr> getAllKykIdouHaneiKekkaTr(){
        return kykIdouHaneiKekkaTrDao.selectAllZT_KykIdouHaneiKekkaTr();
    }


    ZT_KykIdouHaneiKekkaTr getKykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {

        return kykIdouHaneiKekkaTrDao.getKykIdouHaneiKekkaTr(pZtrhuho2kyknokbn, pZtrhuho2kykno);
    }

    ExDBResults<ZT_KykIdouHaneiKekkaRn> getAllKykIdouHaneiKekkaRn(){
        return kykIdouHaneiKekkaRnDao.selectAllZT_KykIdouHaneiKekkaRn();
    }


    ZT_KykIdouHaneiKekkaRn getKykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {

        return kykIdouHaneiKekkaRnDao.getKykIdouHaneiKekkaRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

}
