package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.dao.ZT_FstpUriageSeikyuuKekkaRnDao;
import yuyu.def.db.dao.ZT_FstpUriageSeikyuuKekkaTrDao;
import yuyu.def.db.dao.ZT_HanyouPaperlessMos1TrDao;
import yuyu.def.db.dao.ZT_HanyouPaperlessMos2TrDao;
import yuyu.def.db.dao.ZT_SkCreditTourokukekkaQrRnDao;
import yuyu.def.db.dao.ZT_SkCreditTourokukekkaQrTrDao;
import yuyu.def.db.dao.ZT_SkKouhuriUkTrkkekkaRnDao;
import yuyu.def.db.dao.ZT_SkKouhuriUkTrkkekkaTrDao;
import yuyu.def.db.dao.ZT_SmbcBosRnDao;
import yuyu.def.db.dao.ZT_SmbcBosTrDao;
import yuyu.def.db.dao.ZT_SmbcPaperlessMos1TrDao;
import yuyu.def.db.dao.ZT_SmbcPaperlessMos2TrDao;
import yuyu.def.db.dao.ZT_TiginSinkinBosRnDao;
import yuyu.def.db.dao.ZT_TiginSinkinBosTrDao;
import yuyu.def.db.dao.ZT_TokuteiKankeiHoujinRnDao;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.entity.ZT_SmbcBosRn;
import yuyu.def.db.entity.ZT_SmbcBosTr;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.zdb.manager.ZdbDomManager;


/**
 * SinkeiyakudiskjyusinDomマネージャー<br />
 * Sinkeiyakudiskjyusinにおける、DB操作を提供する。<br />
 */
class SinkeiyakudiskjyusinDomManager {


    @Inject
    private ZT_SmbcBosRnDao smbcBosRnDao;


    @Inject
    private ZT_SmbcBosTrDao smbcBosTrDao;


    @Inject
    private ZT_SmbcPaperlessMos1TrDao smbcPaperlessMos1TrDao;


    @Inject
    private ZT_SmbcPaperlessMos2TrDao smbcPaperlessMos2TrDao;


    @Inject
    private ZT_HanyouPaperlessMos1TrDao hanyouPaperlessMos1TrDao;


    @Inject
    private ZT_HanyouPaperlessMos2TrDao hanyouPaperlessMos2TrDao;


    @Inject
    private ZT_TiginSinkinBosRnDao tiginSinkinBosRnDao;


    @Inject
    private ZT_TiginSinkinBosTrDao tiginSinkinBosTrDao;


    @Inject
    private ZT_TokuteiKankeiHoujinRnDao tokuteiKankeiHoujinRnDao;


    @Inject
    private ZT_FstpUriageSeikyuuKekkaRnDao fstpUriageSeikyuuKekkaRnDao;


    @Inject
    private ZT_FstpUriageSeikyuuKekkaTrDao fstpUriageSeikyuuKekkaTrDao;


    @Inject
    private ZT_SkCreditTourokukekkaQrRnDao skCreditTourokukekkaQrRnDao;


    @Inject
    private ZT_SkCreditTourokukekkaQrTrDao skCreditTourokukekkaQrTrDao;


    @Inject
    private ZT_SkKouhuriUkTrkkekkaRnDao skKouhuriUkTrkkekkaRnDao;


    @Inject
    private ZT_SkKouhuriUkTrkkekkaTrDao skKouhuriUkTrkkekkaTrDao;


    ExDBResults<ZT_TokuteiKankeiHoujinRn> getAllTokuteiKankeiHoujinRn(){
        return tokuteiKankeiHoujinRnDao.selectAllZT_TokuteiKankeiHoujinRn();
    }



    ZT_TokuteiKankeiHoujinRn getTokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {

        return tokuteiKankeiHoujinRnDao.getTokuteiKankeiHoujinRn(pZrnkinyuukikancd, pZrnmeisaibangou);
    }


    ExDBResults<ZT_SmbcBosRn> getAllSmbcBosRn(){
        return smbcBosRnDao.selectAllZT_SmbcBosRn();
    }



    ZT_SmbcBosRn getSmbcBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {

        return smbcBosRnDao.getSmbcBosRn(pZrnseihowebidkbn, pZrnseihowebkojincd, pZrnseihowebitijihozonhyouji, pZrnseihowebsekno);
    }


    ExDBResults<ZT_SmbcBosTr> getAllSmbcBosTr(){
        return smbcBosTrDao.selectAllZT_SmbcBosTr();
    }



    ZT_SmbcBosTr getSmbcBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {

        return smbcBosTrDao.getSmbcBosTr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebsekno);
    }


    ExDBResults<ZT_SmbcBosTr> getSmbcBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo) {


        ExDBResults<ZT_SmbcBosTr> exDBResults = smbcBosTrDao.getSmbcBosTrsByKakutyoujobcdItems(pZtrseihowebitijihozonhyouji, pZtrseihowebmosprtzmhyj, pFstmossksymdFrom
            , pFstmossksymdTo);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<ZT_TiginSinkinBosRn> getAllTiginSinkinBosRn(){
        return tiginSinkinBosRnDao.selectAllZT_TiginSinkinBosRn();
    }



    ZT_TiginSinkinBosRn getTiginSinkinBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {

        return tiginSinkinBosRnDao.getTiginSinkinBosRn(pZrnseihowebidkbn, pZrnseihowebkojincd, pZrnseihowebitijihozonhyouji, pZrnseihowebsekno);
    }


    ExDBResults<ZT_TiginSinkinBosTr> getAllTiginSinkinBosTr(){
        return tiginSinkinBosTrDao.selectAllZT_TiginSinkinBosTr();
    }



    ZT_TiginSinkinBosTr getTiginSinkinBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {

        return tiginSinkinBosTrDao.getTiginSinkinBosTr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebsekno);
    }


    ExDBResults<ZT_TiginSinkinBosTr> getTiginSinkinBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo) {


        ExDBResults<ZT_TiginSinkinBosTr> exDBResults = tiginSinkinBosTrDao.getTiginSinkinBosTrsByKakutyoujobcdItems(pZtrseihowebitijihozonhyouji, pZtrseihowebmosprtzmhyj, pFstmossksymdFrom
            , pFstmossksymdTo);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<ZT_SmbcPaperlessMos1Tr> getAllSmbcPaperlessMos1Tr(){
        return smbcPaperlessMos1TrDao.selectAllZT_SmbcPaperlessMos1Tr();
    }



    ZT_SmbcPaperlessMos1Tr getSmbcPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {

        return smbcPaperlessMos1TrDao.getSmbcPaperlessMos1Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    ExDBResults<ZT_SmbcPaperlessMos1Tr> getSmbcPaperlessMos1TrsByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults<ZT_SmbcPaperlessMos1Tr> exDBResults = smbcPaperlessMos1TrDao.getSmbcPaperlessMos1TrsByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<ZT_SmbcPaperlessMos2Tr> getAllSmbcPaperlessMos2Tr(){
        return smbcPaperlessMos2TrDao.selectAllZT_SmbcPaperlessMos2Tr();
    }



    ZT_SmbcPaperlessMos2Tr getSmbcPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {

        return smbcPaperlessMos2TrDao.getSmbcPaperlessMos2Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    ExDBResults<ZT_SmbcPaperlessMos2Tr> getSmbcPaperlessMos2TrsByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults<ZT_SmbcPaperlessMos2Tr> exDBResults = smbcPaperlessMos2TrDao.getSmbcPaperlessMos2TrsByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    Long getTokuteiKankeiHoujinRnCount() {

        return tokuteiKankeiHoujinRnDao.getTokuteiKankeiHoujinRnCount();
    }


    ExDBResults<ZT_IjiToukeiIdouInfoTr> getIjiToukeiIdouInfoTrsByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResults = SWAKInjector.getInstance(ZdbDomManager.class).getAllIjiToukeiIdouInfoTr();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<ZT_HanyouPaperlessMos1Tr> getAllHanyouPaperlessMos1Tr(){
        return hanyouPaperlessMos1TrDao.selectAllZT_HanyouPaperlessMos1Tr();
    }


    ZT_HanyouPaperlessMos1Tr getHanyouPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {

        return hanyouPaperlessMos1TrDao.getHanyouPaperlessMos1Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    ExDBResults<ZT_HanyouPaperlessMos2Tr> getAllHanyouPaperlessMos2Tr(){
        return hanyouPaperlessMos2TrDao.selectAllZT_HanyouPaperlessMos2Tr();
    }


    ZT_HanyouPaperlessMos2Tr getHanyouPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {

        return hanyouPaperlessMos2TrDao.getHanyouPaperlessMos2Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    ExDBResults<ZT_SkCreditTourokukekkaQrRn> getAllSkCreditTourokukekkaQrRn(){
        return skCreditTourokukekkaQrRnDao.selectAllZT_SkCreditTourokukekkaQrRn();
    }



    ZT_SkCreditTourokukekkaQrRn getSkCreditTourokukekkaQrRn(String pZrnsystemjyusinymd, String pZrnsystemjyusintime, String pZrncreditkessaiyouno) {

        return skCreditTourokukekkaQrRnDao.getSkCreditTourokukekkaQrRn(pZrnsystemjyusinymd, pZrnsystemjyusintime, pZrncreditkessaiyouno);
    }


    ExDBResults<ZT_SkCreditTourokukekkaQrTr> getAllSkCreditTourokukekkaQrTr(){
        return skCreditTourokukekkaQrTrDao.selectAllZT_SkCreditTourokukekkaQrTr();
    }



    ZT_SkCreditTourokukekkaQrTr getSkCreditTourokukekkaQrTr(String pZtrsystemjyusinymd, String pZtrsystemjyusintime, String pZtrcreditkessaiyouno) {

        return skCreditTourokukekkaQrTrDao.getSkCreditTourokukekkaQrTr(pZtrsystemjyusinymd, pZtrsystemjyusintime, pZtrcreditkessaiyouno);
    }


    ExDBResults<ZT_FstpUriageSeikyuuKekkaRn> getAllFstpUriageSeikyuuKekkaRn(){
        return fstpUriageSeikyuuKekkaRnDao.selectAllZT_FstpUriageSeikyuuKekkaRn();
    }



    ZT_FstpUriageSeikyuuKekkaRn getFstpUriageSeikyuuKekkaRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk) {

        return fstpUriageSeikyuuKekkaRnDao.getFstpUriageSeikyuuKekkaRn(pZrnuriageymd6keta, pZrncreditkessaiyouno, pZrnsyono, pZrnrecordno, pZrnseikyuukngk);
    }


    ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> getAllFstpUriageSeikyuuKekkaTr(){
        return fstpUriageSeikyuuKekkaTrDao.selectAllZT_FstpUriageSeikyuuKekkaTr();
    }



    ZT_FstpUriageSeikyuuKekkaTr getFstpUriageSeikyuuKekkaTr(String pZtruriageymd6keta, String pZtrcreditkessaiyouno, String pZtrsyono, String pZtrrecordno, Long pZtrseikyuukngk) {

        return fstpUriageSeikyuuKekkaTrDao.getFstpUriageSeikyuuKekkaTr(pZtruriageymd6keta, pZtrcreditkessaiyouno, pZtrsyono, pZtrrecordno, pZtrseikyuukngk);
    }


    ExDBResults<ZT_SkKouhuriUkTrkkekkaRn> getAllSkKouhuriUkTrkkekkaRn(){
        return skKouhuriUkTrkkekkaRnDao.selectAllZT_SkKouhuriUkTrkkekkaRn();
    }



    ZT_SkKouhuriUkTrkkekkaRn getSkKouhuriUkTrkkekkaRn(String pZrnsyukkncd, String pZrnkinyuukikancd8keta, String pZrnkinyuukkntratkiymd, String pZrnkinyuukkntratkitime
        , String pZrnkouhuriokyakusamano) {

        return skKouhuriUkTrkkekkaRnDao.getSkKouhuriUkTrkkekkaRn(pZrnsyukkncd, pZrnkinyuukikancd8keta, pZrnkinyuukkntratkiymd, pZrnkinyuukkntratkitime
            , pZrnkouhuriokyakusamano);
    }


    ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> getAllSkKouhuriUkTrkkekkaTr(){
        return skKouhuriUkTrkkekkaTrDao.selectAllZT_SkKouhuriUkTrkkekkaTr();
    }



    ZT_SkKouhuriUkTrkkekkaTr getSkKouhuriUkTrkkekkaTr(String pZtrsyukkncd, String pZtrkinyuukikancd8keta, String pZtrkinyuukkntratkiymd, String pZtrkinyuukkntratkitime
        , String pZtrkouhuriokyakusamano) {

        return skKouhuriUkTrkkekkaTrDao.getSkKouhuriUkTrkkekkaTr(pZtrsyukkncd, pZtrkinyuukikancd8keta, pZtrkinyuukkntratkiymd, pZtrkinyuukkntratkitime
            , pZtrkouhuriokyakusamano);
    }

}
