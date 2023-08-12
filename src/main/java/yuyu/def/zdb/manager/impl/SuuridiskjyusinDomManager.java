package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_NennkinRatedRnDao;
import yuyu.def.db.dao.ZT_NennkinRatepkisovRnDao;
import yuyu.def.db.dao.ZT_RatedRnDao;
import yuyu.def.db.dao.ZT_Ratep2RnDao;
import yuyu.def.db.dao.ZT_RatepRnDao;
import yuyu.def.db.dao.ZT_Ratev2RnDao;
import yuyu.def.db.dao.ZT_RatevRnDao;
import yuyu.def.db.dao.ZT_RatewRnDao;
import yuyu.def.db.dao.ZT_RisaHitSyouhnyouRated2RnDao;
import yuyu.def.db.dao.ZT_RisaHitSyouhnyouRatedRnDao;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.db.entity.ZT_RatepRn;
import yuyu.def.db.entity.ZT_Ratev2Rn;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRatedRn;


/**
 * SuuridiskjyusinDomマネージャー<br />
 * Suuridiskjyusinにおける、DB操作を提供する。<br />
 */
class SuuridiskjyusinDomManager {


    @Inject
    private ZT_NennkinRatedRnDao nennkinRatedRnDao;


    @Inject
    private ZT_NennkinRatepkisovRnDao nennkinRatepkisovRnDao;


    @Inject
    private ZT_RatedRnDao ratedRnDao;


    @Inject
    private ZT_RatepRnDao ratepRnDao;


    @Inject
    private ZT_RatevRnDao ratevRnDao;


    @Inject
    private ZT_RisaHitSyouhnyouRatedRnDao risaHitSyouhnyouRatedRnDao;


    @Inject
    private ZT_Ratep2RnDao ratep2RnDao;


    @Inject
    private ZT_Ratev2RnDao ratev2RnDao;


    @Inject
    private ZT_RatewRnDao ratewRnDao;


    @Inject
    private ZT_RisaHitSyouhnyouRated2RnDao risaHitSyouhnyouRated2RnDao;


    ExDBResults<ZT_RatepRn> getAllRatepRn(){
        return ratepRnDao.selectAllZT_RatepRn();
    }



    ZT_RatepRn getRatepRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn) {

        return ratepRnDao.getRatepRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn);
    }


    ExDBResults<ZT_RatevRn> getAllRatevRn(){
        return ratevRnDao.selectAllZT_RatevRn();
    }



    ZT_RatevRn getRatevRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn) {

        return ratevRnDao.getRatevRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn);
    }


    ExDBResults<ZT_RatedRn> getAllRatedRn(){
        return ratedRnDao.selectAllZT_RatedRn();
    }



    ZT_RatedRn getRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {

        return ratedRnDao.getRatedRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrndnendo, pZrnnaiteikakuteikbn);
    }


    ExDBResults<ZT_NennkinRatepkisovRn> getAllNennkinRatepkisovRn(){
        return nennkinRatepkisovRnDao.selectAllZT_NennkinRatepkisovRn();
    }



    ZT_NennkinRatepkisovRn getNennkinRatepkisovRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn) {

        return nennkinRatepkisovRnDao.getNennkinRatepkisovRn(pZrnnenkinkbn, pZrnnenkinsyu, pZrnnenkinkigousedaikbn, pZrnnknshry, pZrnnkkaisigoyoteiriritukbn
            , pZrnnenkinjimutesuuryoukbn);
    }


    ExDBResults<ZT_NennkinRatedRn> getAllNennkinRatedRn(){
        return nennkinRatedRnDao.selectAllZT_NennkinRatedRn();
    }



    ZT_NennkinRatedRn getNennkinRatedRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn, String pZrndnendo, String pZrnnaiteikakuteikbn) {

        return nennkinRatedRnDao.getNennkinRatedRn(pZrnnenkinkbn, pZrnnenkinsyu, pZrnnenkinkigousedaikbn, pZrnnknshry, pZrnnkkaisigoyoteiriritukbn
            , pZrnnenkinjimutesuuryoukbn, pZrndnendo, pZrnnaiteikakuteikbn);
    }



    ExDBResults<ZT_RisaHitSyouhnyouRatedRn> getAllRisaHitSyouhnyouRatedRn(){
        return risaHitSyouhnyouRatedRnDao.selectAllZT_RisaHitSyouhnyouRatedRn();
    }



    ZT_RisaHitSyouhnyouRatedRn getRisaHitSyouhnyouRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {

        return risaHitSyouhnyouRatedRnDao.getRisaHitSyouhnyouRatedRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrndnendo, pZrnnaiteikakuteikbn);
    }


    ExDBResults<ZT_Ratep2Rn> getAllRatep2Rn(){
        return ratep2RnDao.selectAllZT_Ratep2Rn();
    }



    ZT_Ratep2Rn getRatep2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrnryouritukbn) {

        return ratep2RnDao.getRatep2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn, pZrnryouritukbn);
    }


    ExDBResults<ZT_Ratev2Rn> getAllRatev2Rn(){
        return ratev2RnDao.selectAllZT_Ratev2Rn();
    }



    ZT_Ratev2Rn getRatev2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {

        return ratev2RnDao.getRatev2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn);
    }


    ExDBResults<ZT_RisaHitSyouhnyouRated2Rn> getAllRisaHitSyouhnyouRated2Rn(){
        return risaHitSyouhnyouRated2RnDao.selectAllZT_RisaHitSyouhnyouRated2Rn();
    }



    ZT_RisaHitSyouhnyouRated2Rn getRisaHitSyouhnyouRated2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrndnendo
        , String pZrnnaiteikakuteikbn) {

        return risaHitSyouhnyouRated2RnDao.getRisaHitSyouhnyouRated2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn, pZrndnendo
            , pZrnnaiteikakuteikbn);
    }


    ExDBResults<ZT_RatewRn> getAllRatewRn(){
        return ratewRnDao.selectAllZT_RatewRn();
    }



    ZT_RatewRn getRatewRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {

        return ratewRnDao.getRatewRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn);
    }

}
