package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_AuthoriKekkaRnDao;
import yuyu.def.db.dao.ZT_AuthoriKekkaTrDao;
import yuyu.def.db.dao.ZT_KzhuriSyuunouKekkaRnDao;
import yuyu.def.db.dao.ZT_KzhuriSyuunouKekkaTrDao;
import yuyu.def.db.dao.ZT_UriageKekkaRnDao;
import yuyu.def.db.dao.ZT_UriageKekkaTrDao;
import yuyu.def.db.dao.ZT_YuukouKakKekkaFRnDao;
import yuyu.def.db.dao.ZT_YuukouKakKekkaFTrDao;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.entity.ZT_UriageKekkaRn;
import yuyu.def.db.entity.ZT_UriageKekkaTr;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;


/**
 * HozenkydiskjyusinDomマネージャー<br />
 * Hozenkydiskjyusin（契約保全（共有ディスク方式（受信）））における、DB操作を提供する。<br />
 */
class HozenkydiskjyusinDomManager {

    @Inject
    private ZT_AuthoriKekkaRnDao authoriKekkaRnDao;

    @Inject
    private ZT_AuthoriKekkaTrDao authoriKekkaTrDao;

    @Inject
    private ZT_KzhuriSyuunouKekkaRnDao kzhuriSyuunouKekkaRnDao;

    @Inject
    private ZT_KzhuriSyuunouKekkaTrDao kzhuriSyuunouKekkaTrDao;

    @Inject
    private ZT_UriageKekkaRnDao uriageKekkaRnDao;

    @Inject
    private ZT_UriageKekkaTrDao uriageKekkaTrDao;

    @Inject
    private ZT_YuukouKakKekkaFRnDao yuukouKakKekkaFRnDao;

    @Inject
    private ZT_YuukouKakKekkaFTrDao yuukouKakKekkaFTrDao;

    ExDBResults<ZT_KzhuriSyuunouKekkaRn> getAllKzhuriSyuunouKekkaRn(){
        return kzhuriSyuunouKekkaRnDao.selectAllZT_KzhuriSyuunouKekkaRn();
    }


    ZT_KzhuriSyuunouKekkaRn getKzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {

        return kzhuriSyuunouKekkaRnDao.getKzhuriSyuunouKekkaRn(pZrnsyono, pZrnjyuutouym);
    }

    ExDBResults<ZT_KzhuriSyuunouKekkaTr> getAllKzhuriSyuunouKekkaTr(){
        return kzhuriSyuunouKekkaTrDao.selectAllZT_KzhuriSyuunouKekkaTr();
    }


    ZT_KzhuriSyuunouKekkaTr getKzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {

        return kzhuriSyuunouKekkaTrDao.getKzhuriSyuunouKekkaTr(pZtrsyono, pZtrjyuutouym);
    }

    ExDBResults<ZT_UriageKekkaTr> getAllUriageKekkaTr(){
        return uriageKekkaTrDao.selectAllZT_UriageKekkaTr();
    }


    ZT_UriageKekkaTr getUriageKekkaTr(String pZtrsyono, String pZtrcreditkessaiyouno, String pZtruriageymd6keta, String pZtrrecordno, Long pZtrseikyuukngk) {

        return uriageKekkaTrDao.getUriageKekkaTr(pZtrsyono, pZtrcreditkessaiyouno, pZtruriageymd6keta, pZtrrecordno, pZtrseikyuukngk);
    }

    ExDBResults<ZT_UriageKekkaRn> getAllUriageKekkaRn(){
        return uriageKekkaRnDao.selectAllZT_UriageKekkaRn();
    }


    ZT_UriageKekkaRn getUriageKekkaRn(String pZrnsyono, String pZrncreditkessaiyouno, String pZrnuriageymd6keta, String pZrnrecordno, Long pZrnseikyuukngk) {

        return uriageKekkaRnDao.getUriageKekkaRn(pZrnsyono, pZrncreditkessaiyouno, pZrnuriageymd6keta, pZrnrecordno, pZrnseikyuukngk);
    }

    ExDBResults<ZT_YuukouKakKekkaFRn> getAllYuukouKakKekkaFRn(){
        return yuukouKakKekkaFRnDao.selectAllZT_YuukouKakKekkaFRn();
    }


    ZT_YuukouKakKekkaFRn getYuukouKakKekkaFRn(String pZrncreditkessaiyouno) {

        return yuukouKakKekkaFRnDao.getYuukouKakKekkaFRn(pZrncreditkessaiyouno);
    }

    ExDBResults<ZT_YuukouKakKekkaFTr> getAllYuukouKakKekkaFTr(){
        return yuukouKakKekkaFTrDao.selectAllZT_YuukouKakKekkaFTr();
    }


    ZT_YuukouKakKekkaFTr getYuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {

        return yuukouKakKekkaFTrDao.getYuukouKakKekkaFTr(pZtrcreditkessaiyouno);
    }

    ExDBResults<ZT_AuthoriKekkaRn> getAllAuthoriKekkaRn(){
        return authoriKekkaRnDao.selectAllZT_AuthoriKekkaRn();
    }


    ZT_AuthoriKekkaRn getAuthoriKekkaRn(String pZrnrenno7, String pZrncreditkessaiyouno, String pZrndatajyusinymd) {

        return authoriKekkaRnDao.getAuthoriKekkaRn(pZrnrenno7, pZrncreditkessaiyouno, pZrndatajyusinymd);
    }

    ExDBResults<ZT_AuthoriKekkaTr> getAllAuthoriKekkaTr(){
        return authoriKekkaTrDao.selectAllZT_AuthoriKekkaTr();
    }


    ZT_AuthoriKekkaTr getAuthoriKekkaTr(String pZtrrenno7, String pZtrcreditkessaiyouno, String pZtrdatajyusinymd) {

        return authoriKekkaTrDao.getAuthoriKekkaTr(pZtrrenno7, pZtrcreditkessaiyouno, pZtrdatajyusinymd);
    }

}
