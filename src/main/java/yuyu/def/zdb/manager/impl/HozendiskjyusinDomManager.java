package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.*;
import yuyu.def.db.entity.*;


/**
 * HozendiskjyusinDomマネージャー<br />
 * Hozendiskjyusin（契約保全（共有ディスク方式（送信）））における、DB操作を提供する。<br />
 */
class HozendiskjyusinDomManager {


    @Inject
    private ZT_BosyuuDrtenHoyuuKykRnDao bosyuuDrtenHoyuuKykRnDao;


    @Inject
    private ZT_BosyuuDrtenHoyuuKykTyDao bosyuuDrtenHoyuuKykTyDao;


    @Inject
    private ZT_CreditHnknTuutiRnDao creditHnknTuutiRnDao;


    @Inject
    private ZT_CreditHnknTuutiTyDao creditHnknTuutiTyDao;


    @Inject
    private ZT_DattaiTuutiKzhuriRnDao dattaiTuutiKzhuriRnDao;


    @Inject
    private ZT_DattaiTuutiKzhuriTyDao dattaiTuutiKzhuriTyDao;


    @Inject
    private ZT_DrtenKykIdouDetailRnDao drtenKykIdouDetailRnDao;


    @Inject
    private ZT_DrtenKykIdouDetailTyDao drtenKykIdouDetailTyDao;


    @Inject
    private ZT_DrtenMinyuKykDtlSyokaiRnDao drtenMinyuKykDtlSyokaiRnDao;


    @Inject
    private ZT_DrtenMinyuKykDtlSyokaiTyDao drtenMinyuKykDtlSyokaiTyDao;


    @Inject
    private ZT_DrtenMinyuuKykInfoRnDao drtenMinyuuKykInfoRnDao;


    @Inject
    private ZT_DrtenMinyuuKykInfoTyDao drtenMinyuuKykInfoTyDao;


    @Inject
    private ZT_DrtenMisyuSkInfoDataRnDao drtenMisyuSkInfoDataRnDao;


    @Inject
    private ZT_DrtenMisyuSkInfoDataTyDao drtenMisyuSkInfoDataTyDao;


    @Inject
    private ZT_DrtenSkKykDtlSyokaiRnDao drtenSkKykDtlSyokaiRnDao;


    @Inject
    private ZT_DrtenSkKykDtlSyokaiTyDao drtenSkKykDtlSyokaiTyDao;


    @Inject
    private ZT_DrtenTsryInfoRnDao drtenTsryInfoRnDao;


    @Inject
    private ZT_DrtenTsryInfoTyDao drtenTsryInfoTyDao;


    @Inject
    private ZT_DSeisanShrTysySyuseiRnDao dSeisanShrTysySyuseiRnDao;


    @Inject
    private ZT_DSeisanShrTysySyuseiTyDao dSeisanShrTysySyuseiTyDao;


    @Inject
    private ZT_GaikaKokyakuTuutiRnDao gaikaKokyakuTuutiRnDao;


    @Inject
    private ZT_GaikaKokyakuTuutiTyDao gaikaKokyakuTuutiTyDao;


    @Inject
    private ZT_GinkouMdhnMisyuuInfoFRnDao ginkouMdhnMisyuuInfoFRnDao;


    @Inject
    private ZT_GinkouMdhnMisyuuInfoFTyDao ginkouMdhnMisyuuInfoFTyDao;


    @Inject
    private ZT_HknkykIdouInfoRnDao hknkykIdouInfoRnDao;


    @Inject
    private ZT_HknkykIdouInfoTyDao hknkykIdouInfoTyDao;


    @Inject
    private ZT_HnsyScrMeigiRnDao hnsyScrMeigiRnDao;


    @Inject
    private ZT_HnsyScrMeigiTyDao hnsyScrMeigiTyDao;


    @Inject
    private ZT_HrhnTtdkKanRnDao hrhnTtdkKanRnDao;


    @Inject
    private ZT_HrhnTtdkKanTyDao hrhnTtdkKanTyDao;


    @Inject
    private ZT_KesikomiSousinCreditRnDao kesikomiSousinCreditRnDao;


    @Inject
    private ZT_KesikomiSousinCreditTyDao kesikomiSousinCreditTyDao;


    @Inject
    private ZT_KesikomiSousinHurikaeRnDao kesikomiSousinHurikaeRnDao;


    @Inject
    private ZT_KesikomiSousinHurikaeTyDao kesikomiSousinHurikaeTyDao;


    @Inject
    private ZT_KesikomiSousinKouhuriRnDao kesikomiSousinKouhuriRnDao;


    @Inject
    private ZT_KesikomiSousinKouhuriTyDao kesikomiSousinKouhuriTyDao;


    @Inject
    private ZT_KessanYokukiPRnDao kessanYokukiPRnDao;


    @Inject
    private ZT_KessanYokukiPTyDao kessanYokukiPTyDao;


    @Inject
    private ZT_KessanZennouFRnDao kessanZennouFRnDao;


    @Inject
    private ZT_KessanZennouFTyDao kessanZennouFTyDao;


    @Inject
    private ZT_KhDrtenMinyuuKykMeisaiRnDao khDrtenMinyuuKykMeisaiRnDao;


    @Inject
    private ZT_KhDrtenMinyuuKykMeisaiTyDao khDrtenMinyuuKykMeisaiTyDao;


    @Inject
    private ZT_KhGinkouMdhnFollowCallRnDao khGinkouMdhnFollowCallRnDao;


    @Inject
    private ZT_KhGinkouMdhnFollowCallTyDao khGinkouMdhnFollowCallTyDao;


    @Inject
    private ZT_KijituTouraiAnnaiRnDao kijituTouraiAnnaiRnDao;


    @Inject
    private ZT_KijituTouraiAnnaiTyDao kijituTouraiAnnaiTyDao;


    @Inject
    private ZT_KoujyoSyoumeiRnDao koujyoSyoumeiRnDao;


    @Inject
    private ZT_KoujyoSyoumeiTyDao koujyoSyoumeiTyDao;


    @Inject
    private ZT_KouzaHnknTuutiRnDao kouzaHnknTuutiRnDao;


    @Inject
    private ZT_KouzaHnknTuutiTyDao kouzaHnknTuutiTyDao;


    @Inject
    private ZT_KouzaHrkmTuutiRnDao kouzaHrkmTuutiRnDao;


    @Inject
    private ZT_KouzaHrkmTuutiTyDao kouzaHrkmTuutiTyDao;


    @Inject
    private ZT_KouzahuriMinyuTuutiRnDao kouzahuriMinyuTuutiRnDao;


    @Inject
    private ZT_KouzahuriMinyuTuutiTyDao kouzahuriMinyuTuutiTyDao;


    @Inject
    private ZT_KouzahuriStartAnnaiRnDao kouzahuriStartAnnaiRnDao;


    @Inject
    private ZT_KouzahuriStartAnnaiTyDao kouzahuriStartAnnaiTyDao;


    @Inject
    private ZT_KydGWKykInfoRnDao kydGWKykInfoRnDao;


    @Inject
    private ZT_KydGWKykInfoTyDao kydGWKykInfoTyDao;


    @Inject
    private ZT_KzhuriAnnaiUlfRnDao kzhuriAnnaiUlfRnDao;


    @Inject
    private ZT_KzhuriAnnaiUlfTyDao kzhuriAnnaiUlfTyDao;


    @Inject
    private ZT_SaihakkouHokensyoukenRnDao saihakkouHokensyoukenRnDao;


    @Inject
    private ZT_SaihakkouHokensyoukenTyDao saihakkouHokensyoukenTyDao;


    @Inject
    private ZT_SaihakkouSyoukenSuiiRnDao saihakkouSyoukenSuiiRnDao;


    @Inject
    private ZT_SaihakkouSyoukenSuiiTyDao saihakkouSyoukenSuiiTyDao;


    @Inject
    private ZT_SaihakkouSyoukenSuii2RnDao saihakkouSyoukenSuii2RnDao;


    @Inject
    private ZT_SaihakkouSyoukenSuii2TyDao saihakkouSyoukenSuii2TyDao;


    @Inject
    private ZT_SeihoWebIdouListRnDao seihoWebIdouListRnDao;


    @Inject
    private ZT_SeihoWebIdouListTyDao seihoWebIdouListTyDao;


    @Inject
    private ZT_SeisanDHaneiTuutiRnDao seisanDHaneiTuutiRnDao;


    @Inject
    private ZT_SeisanDHaneiTuutiTyDao seisanDHaneiTuutiTyDao;


    @Inject
    private ZT_SinkeiyakuHokensyoukenRnDao sinkeiyakuHokensyoukenRnDao;


    @Inject
    private ZT_SinkeiyakuHokensyoukenTyDao sinkeiyakuHokensyoukenTyDao;


    @Inject
    private ZT_SinkeiyakuSyoukenSuiiRnDao sinkeiyakuSyoukenSuiiRnDao;


    @Inject
    private ZT_SinkeiyakuSyoukenSuiiTyDao sinkeiyakuSyoukenSuiiTyDao;


    @Inject
    private ZT_SinkeiyakuSyoukenSuii2RnDao sinkeiyakuSyoukenSuii2RnDao;


    @Inject
    private ZT_SinkeiyakuSyoukenSuii2TyDao sinkeiyakuSyoukenSuii2TyDao;


    @Inject
    private ZT_SinkokuYokokuTuutiFSksRnDao sinkokuYokokuTuutiFSksRnDao;


    @Inject
    private ZT_SinkokuYokokuTuutiFSksTyDao sinkokuYokokuTuutiFSksTyDao;


    @Inject
    private ZT_SinninTouhyouRnDao sinninTouhyouRnDao;


    @Inject
    private ZT_SinninTouhyouTyDao sinninTouhyouTyDao;


    @Inject
    private ZT_SmbcGetujiKykMeisaiRnDao smbcGetujiKykMeisaiRnDao;


    @Inject
    private ZT_SmbcGetujiKykMeisaiTyDao smbcGetujiKykMeisaiTyDao;


    @Inject
    private ZT_SyainMeiboRnDao syainMeiboRnDao;


    @Inject
    private ZT_SyainMeiboTyDao syainMeiboTyDao;


    @Inject
    private ZT_SyoukenTkListShRnDao syoukenTkListShRnDao;


    @Inject
    private ZT_SyoukenTkListShTyDao syoukenTkListShTyDao;


    @Inject
    private ZT_SyoukenTkListSkRnDao syoukenTkListSkRnDao;


    @Inject
    private ZT_SyoukenTkListSkTyDao syoukenTkListSkTyDao;


    @Inject
    private ZT_SyoumetuTuutiRnDao syoumetuTuutiRnDao;


    @Inject
    private ZT_SyoumetuTuutiTyDao syoumetuTuutiTyDao;


    @Inject
    private ZT_TtdkKanAdHenkouRnDao ttdkKanAdHenkouRnDao;


    @Inject
    private ZT_TtdkKanAdHenkouTyDao ttdkKanAdHenkouTyDao;


    @Inject
    private ZT_TtdkKanKiykRnDao ttdkKanKiykRnDao;


    @Inject
    private ZT_TtdkKanKiykTyDao ttdkKanKiykTyDao;


    @Inject
    private ZT_TtdkKanRnDao ttdkKanRnDao;


    @Inject
    private ZT_TtdkKanTyDao ttdkKanTyDao;


    @Inject
    private ZT_TumitateYosokuRnDao tumitateYosokuRnDao;


    @Inject
    private ZT_TumitateYosokuTyDao tumitateYosokuTyDao;


    @Inject
    private ZT_UriageSousinRnDao uriageSousinRnDao;


    @Inject
    private ZT_UriageSousinTyDao uriageSousinTyDao;


    @Inject
    private ZT_YuseiMinyuKykDtlSyokaiRnDao yuseiMinyuKykDtlSyokaiRnDao;


    @Inject
    private ZT_YuseiMinyuKykDtlSyokaiTyDao yuseiMinyuKykDtlSyokaiTyDao;


    @Inject
    private ZT_YuukouseiNgTuutiRnDao yuukouseiNgTuutiRnDao;


    @Inject
    private ZT_YuukouseiNgTuutiTyDao yuukouseiNgTuutiTyDao;


    @Inject
    private ZT_ZennouHoyuuIdouKykDtlRnDao zennouHoyuuIdouKykDtlRnDao;


    @Inject
    private ZT_ZennouHoyuuIdouKykDtlTyDao zennouHoyuuIdouKykDtlTyDao;


    @Inject
    private ZT_GentumiSkMikomirituULFRnDao gentumiSkMikomirituULFRnDao;


    @Inject
    private ZT_GentumiSkMikomirituULFTyDao gentumiSkMikomirituULFTyDao;


    @Inject
    private ZT_SinBosyuuDrtenHoyuuKykRnDao sinBosyuuDrtenHoyuuKykRnDao;


    @Inject
    private ZT_SinBosyuuDrtenHoyuuKykTyDao sinBosyuuDrtenHoyuuKykTyDao;


    @Inject
    private ZT_DairitenGtmtZndkRnDao dairitenGtmtZndkRnDao;


    @Inject
    private ZT_DairitenGtmtZndkTyDao dairitenGtmtZndkTyDao;


    ExDBResults<ZT_SyainMeiboTy> getAllSyainMeiboTy(){
        return syainMeiboTyDao.selectAllZT_SyainMeiboTy();
    }



    ZT_SyainMeiboTy getSyainMeiboTy(String pZtysyono) {

        return syainMeiboTyDao.getSyainMeiboTy(pZtysyono);
    }


    ExDBResults<ZT_SyoukenTkListShTy> getAllSyoukenTkListShTy(){
        return syoukenTkListShTyDao.selectAllZT_SyoukenTkListShTy();
    }



    ZT_SyoukenTkListShTy getSyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {

        return syoukenTkListShTyDao.getSyoukenTkListShTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_SyoukenTkListShRn> getAllSyoukenTkListShRn(){
        return syoukenTkListShRnDao.selectAllZT_SyoukenTkListShRn();
    }



    ZT_SyoukenTkListShRn getSyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {

        return syoukenTkListShRnDao.getSyoukenTkListShRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_SyoukenTkListSkTy> getAllSyoukenTkListSkTy(){
        return syoukenTkListSkTyDao.selectAllZT_SyoukenTkListSkTy();
    }



    ZT_SyoukenTkListSkTy getSyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {

        return syoukenTkListSkTyDao.getSyoukenTkListSkTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_SyoukenTkListSkRn> getAllSyoukenTkListSkRn(){
        return syoukenTkListSkRnDao.selectAllZT_SyoukenTkListSkRn();
    }



    ZT_SyoukenTkListSkRn getSyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {

        return syoukenTkListSkRnDao.getSyoukenTkListSkRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_HnsyScrMeigiTy> getAllHnsyScrMeigiTy(){
        return hnsyScrMeigiTyDao.selectAllZT_HnsyScrMeigiTy();
    }



    ZT_HnsyScrMeigiTy getHnsyScrMeigiTy(String pZtytaisyounmkn, String pZtytaisyounmkj, String pZtytaisyouseiymd, String pZtynayosetaisyousegkbn
        , String pZtysyono) {

        return hnsyScrMeigiTyDao.getHnsyScrMeigiTy(pZtytaisyounmkn, pZtytaisyounmkj, pZtytaisyouseiymd, pZtynayosetaisyousegkbn
            , pZtysyono);
    }


    ExDBResults<ZT_HnsyScrMeigiRn> getAllHnsyScrMeigiRn(){
        return hnsyScrMeigiRnDao.selectAllZT_HnsyScrMeigiRn();
    }



    ZT_HnsyScrMeigiRn getHnsyScrMeigiRn(String pZrntaisyounmkn, String pZrntaisyounmkj, String pZrntaisyouseiymd, String pZrnnayosetaisyousegkbn
        , String pZrnsyono) {

        return hnsyScrMeigiRnDao.getHnsyScrMeigiRn(pZrntaisyounmkn, pZrntaisyounmkj, pZrntaisyouseiymd, pZrnnayosetaisyousegkbn
            , pZrnsyono);
    }


    ExDBResults<ZT_KoujyoSyoumeiTy> getAllKoujyoSyoumeiTy(){
        return koujyoSyoumeiTyDao.selectAllZT_KoujyoSyoumeiTy();
    }



    ZT_KoujyoSyoumeiTy getKoujyoSyoumeiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysakunm15keta) {

        return koujyoSyoumeiTyDao.getKoujyoSyoumeiTy(pZtytyouhyouymd, pZtysyono, pZtysakunm15keta);
    }


    ExDBResults<ZT_KoujyoSyoumeiRn> getAllKoujyoSyoumeiRn(){
        return koujyoSyoumeiRnDao.selectAllZT_KoujyoSyoumeiRn();
    }



    ZT_KoujyoSyoumeiRn getKoujyoSyoumeiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsakunm15keta) {

        return koujyoSyoumeiRnDao.getKoujyoSyoumeiRn(pZrntyouhyouymd, pZrnsyono, pZrnsakunm15keta);
    }


    ExDBResults<ZT_TtdkKanTy> getAllTtdkKanTy(){
        return ttdkKanTyDao.selectAllZT_TtdkKanTy();
    }



    ZT_TtdkKanTy getTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return ttdkKanTyDao.getTtdkKanTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_TtdkKanRn> getAllTtdkKanRn(){
        return ttdkKanRnDao.selectAllZT_TtdkKanRn();
    }



    ZT_TtdkKanRn getTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return ttdkKanRnDao.getTtdkKanRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_TtdkKanKiykTy> getAllTtdkKanKiykTy(){
        return ttdkKanKiykTyDao.selectAllZT_TtdkKanKiykTy();
    }



    ZT_TtdkKanKiykTy getTtdkKanKiykTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return ttdkKanKiykTyDao.getTtdkKanKiykTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_TtdkKanKiykRn> getAllTtdkKanKiykRn(){
        return ttdkKanKiykRnDao.selectAllZT_TtdkKanKiykRn();
    }



    ZT_TtdkKanKiykRn getTtdkKanKiykRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return ttdkKanKiykRnDao.getTtdkKanKiykRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_TtdkKanAdHenkouTy> getAllTtdkKanAdHenkouTy(){
        return ttdkKanAdHenkouTyDao.selectAllZT_TtdkKanAdHenkouTy();
    }



    ZT_TtdkKanAdHenkouTy getTtdkKanAdHenkouTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return ttdkKanAdHenkouTyDao.getTtdkKanAdHenkouTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_TtdkKanAdHenkouRn> getAllTtdkKanAdHenkouRn(){
        return ttdkKanAdHenkouRnDao.selectAllZT_TtdkKanAdHenkouRn();
    }



    ZT_TtdkKanAdHenkouRn getTtdkKanAdHenkouRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return ttdkKanAdHenkouRnDao.getTtdkKanAdHenkouRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_DrtenKykIdouDetailTy> getAllDrtenKykIdouDetailTy(){
        return drtenKykIdouDetailTyDao.selectAllZT_DrtenKykIdouDetailTy();
    }



    ZT_DrtenKykIdouDetailTy getDrtenKykIdouDetailTy(String pZtybsydrtencd, String pZtybosyuunincd, String pZtysyono, String pZtyidouhasseiymd, String pZtyidoukbn) {

        return drtenKykIdouDetailTyDao.getDrtenKykIdouDetailTy(pZtybsydrtencd, pZtybosyuunincd, pZtysyono, pZtyidouhasseiymd, pZtyidoukbn);
    }


    ExDBResults<ZT_DrtenKykIdouDetailRn> getAllDrtenKykIdouDetailRn(){
        return drtenKykIdouDetailRnDao.selectAllZT_DrtenKykIdouDetailRn();
    }



    ZT_DrtenKykIdouDetailRn getDrtenKykIdouDetailRn(String pZrnbsydrtencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnidouhasseiymd, String pZrnidoukbn) {

        return drtenKykIdouDetailRnDao.getDrtenKykIdouDetailRn(pZrnbsydrtencd, pZrnbosyuunincd, pZrnsyono, pZrnidouhasseiymd, pZrnidoukbn);
    }


    ExDBResults<ZT_BosyuuDrtenHoyuuKykTy> getAllBosyuuDrtenHoyuuKykTy(){
        return bosyuuDrtenHoyuuKykTyDao.selectAllZT_BosyuuDrtenHoyuuKykTy();
    }



    ZT_BosyuuDrtenHoyuuKykTy getBosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {

        return bosyuuDrtenHoyuuKykTyDao.getBosyuuDrtenHoyuuKykTy(pZtysyonosyuban);
    }


    ExDBResults<ZT_BosyuuDrtenHoyuuKykRn> getAllBosyuuDrtenHoyuuKykRn(){
        return bosyuuDrtenHoyuuKykRnDao.selectAllZT_BosyuuDrtenHoyuuKykRn();
    }



    ZT_BosyuuDrtenHoyuuKykRn getBosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {

        return bosyuuDrtenHoyuuKykRnDao.getBosyuuDrtenHoyuuKykRn(pZrnsyonosyuban);
    }


    ExDBResults<ZT_KydGWKykInfoTy> getAllKydGWKykInfoTy(){
        return kydGWKykInfoTyDao.selectAllZT_KydGWKykInfoTy();
    }



    ZT_KydGWKykInfoTy getKydGWKykInfoTy(String pZtysyono, String pZtysyoriymd, Long pZtykykmfksnctrlkh) {

        return kydGWKykInfoTyDao.getKydGWKykInfoTy(pZtysyono, pZtysyoriymd, pZtykykmfksnctrlkh);
    }


    ExDBResults<ZT_SinkeiyakuHokensyoukenTy> getAllSinkeiyakuHokensyoukenTy(){
        return sinkeiyakuHokensyoukenTyDao.selectAllZT_SinkeiyakuHokensyoukenTy();
    }



    ZT_SinkeiyakuHokensyoukenTy getSinkeiyakuHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {

        return sinkeiyakuHokensyoukenTyDao.getSinkeiyakuHokensyoukenTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_SaihakkouHokensyoukenTy> getAllSaihakkouHokensyoukenTy(){
        return saihakkouHokensyoukenTyDao.selectAllZT_SaihakkouHokensyoukenTy();
    }



    ZT_SaihakkouHokensyoukenTy getSaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {

        return saihakkouHokensyoukenTyDao.getSaihakkouHokensyoukenTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_SyainMeiboRn> getAllSyainMeiboRn(){
        return syainMeiboRnDao.selectAllZT_SyainMeiboRn();
    }



    ZT_SyainMeiboRn getSyainMeiboRn(String pZrnsyono) {

        return syainMeiboRnDao.getSyainMeiboRn(pZrnsyono);
    }


    ExDBResults<ZT_DrtenTsryInfoTy> getAllDrtenTsryInfoTy(){
        return drtenTsryInfoTyDao.selectAllZT_DrtenTsryInfoTy();
    }



    ZT_DrtenTsryInfoTy getDrtenTsryInfoTy(String pZtydairitencd, String pZtybosyuunincd, String pZtysyono, String pZtykikaisyoriymd, Long pZtykykmfksnctrlkh, String pZtysikibetujyunjyo) {

        return drtenTsryInfoTyDao.getDrtenTsryInfoTy(pZtydairitencd, pZtybosyuunincd, pZtysyono, pZtykikaisyoriymd, pZtykykmfksnctrlkh, pZtysikibetujyunjyo);
    }


    ExDBResults<ZT_SeihoWebIdouListTy> getAllSeihoWebIdouListTy(){
        return seihoWebIdouListTyDao.selectAllZT_SeihoWebIdouListTy();
    }



    ZT_SeihoWebIdouListTy getSeihoWebIdouListTy(String pZtysakuseiymd7keta, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono, String pZtyhasseiymd
        , String pZtyidoukbn1, String pZtykydatkikbnkj, String pZtykykyymm, String pZtycifcd) {

        return seihoWebIdouListTyDao.getSeihoWebIdouListTy(pZtysakuseiymd7keta, pZtybsydrtencd, pZtytntusycd, pZtysyono, pZtyhasseiymd
            , pZtyidoukbn1, pZtykydatkikbnkj, pZtykykyymm, pZtycifcd);
    }


    ExDBResults<ZT_HknkykIdouInfoTy> getAllHknkykIdouInfoTy(){
        return hknkykIdouInfoTyDao.selectAllZT_HknkykIdouInfoTy();
    }



    ZT_HknkykIdouInfoTy getHknkykIdouInfoTy(String pZtykyktuukasyu, String pZtyidouymd, String pZtyidoujiyuukbnzfi, String pZtydatakanrino, String pZtyrenno, String pZtytumitatekinkbn) {

        return hknkykIdouInfoTyDao.getHknkykIdouInfoTy(pZtykyktuukasyu, pZtyidouymd, pZtyidoujiyuukbnzfi, pZtydatakanrino, pZtyrenno, pZtytumitatekinkbn);
    }


    ExDBResults<ZT_KydGWKykInfoRn> getAllKydGWKykInfoRn(){
        return kydGWKykInfoRnDao.selectAllZT_KydGWKykInfoRn();
    }



    ZT_KydGWKykInfoRn getKydGWKykInfoRn(String pZrnsyono, String pZrnsyoriymd, Long pZrnkykmfksnctrlkh) {

        return kydGWKykInfoRnDao.getKydGWKykInfoRn(pZrnsyono, pZrnsyoriymd, pZrnkykmfksnctrlkh);
    }


    ExDBResults<ZT_SinkeiyakuHokensyoukenRn> getAllSinkeiyakuHokensyoukenRn(){
        return sinkeiyakuHokensyoukenRnDao.selectAllZT_SinkeiyakuHokensyoukenRn();
    }



    ZT_SinkeiyakuHokensyoukenRn getSinkeiyakuHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {

        return sinkeiyakuHokensyoukenRnDao.getSinkeiyakuHokensyoukenRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_SaihakkouHokensyoukenRn> getAllSaihakkouHokensyoukenRn(){
        return saihakkouHokensyoukenRnDao.selectAllZT_SaihakkouHokensyoukenRn();
    }



    ZT_SaihakkouHokensyoukenRn getSaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {

        return saihakkouHokensyoukenRnDao.getSaihakkouHokensyoukenRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_GaikaKokyakuTuutiTy> getAllGaikaKokyakuTuutiTy(){
        return gaikaKokyakuTuutiTyDao.selectAllZT_GaikaKokyakuTuutiTy();
    }



    ZT_GaikaKokyakuTuutiTy getGaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {

        return gaikaKokyakuTuutiTyDao.getGaikaKokyakuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_GaikaKokyakuTuutiRn> getAllGaikaKokyakuTuutiRn(){
        return gaikaKokyakuTuutiRnDao.selectAllZT_GaikaKokyakuTuutiRn();
    }



    ZT_GaikaKokyakuTuutiRn getGaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {

        return gaikaKokyakuTuutiRnDao.getGaikaKokyakuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_DrtenTsryInfoRn> getAllDrtenTsryInfoRn(){
        return drtenTsryInfoRnDao.selectAllZT_DrtenTsryInfoRn();
    }



    ZT_DrtenTsryInfoRn getDrtenTsryInfoRn(String pZrndairitencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnkikaisyoriymd, Long pZrnkykmfksnctrlkh, String pZrnsikibetujyunjyo) {

        return drtenTsryInfoRnDao.getDrtenTsryInfoRn(pZrndairitencd, pZrnbosyuunincd, pZrnsyono, pZrnkikaisyoriymd, pZrnkykmfksnctrlkh, pZrnsikibetujyunjyo);
    }


    ExDBResults<ZT_SeihoWebIdouListRn> getAllSeihoWebIdouListRn(){
        return seihoWebIdouListRnDao.selectAllZT_SeihoWebIdouListRn();
    }



    ZT_SeihoWebIdouListRn getSeihoWebIdouListRn(Long pZrnsakuseiymd7keta, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono, String pZrnhasseiymd
        , String pZrnidoukbn1, String pZrnkydatkikbnkj, String pZrnkykyymm, String pZrncifcd) {

        return seihoWebIdouListRnDao.getSeihoWebIdouListRn(pZrnsakuseiymd7keta, pZrnbsydrtencd, pZrntntusycd, pZrnsyono, pZrnhasseiymd
            , pZrnidoukbn1, pZrnkydatkikbnkj, pZrnkykyymm, pZrncifcd);
    }


    ExDBResults<ZT_HknkykIdouInfoRn> getAllHknkykIdouInfoRn(){
        return hknkykIdouInfoRnDao.selectAllZT_HknkykIdouInfoRn();
    }



    ZT_HknkykIdouInfoRn getHknkykIdouInfoRn(String pZrnkyktuukasyu, String pZrnidouymd, String pZrnidoujiyuukbnzfi, String pZrndatakanrino, String pZrnrenno, String pZtytumitatekinkbn) {

        return hknkykIdouInfoRnDao.getHknkykIdouInfoRn(pZrnkyktuukasyu, pZrnidouymd, pZrnidoujiyuukbnzfi, pZrndatakanrino, pZrnrenno, pZtytumitatekinkbn);
    }


    ExDBResults<ZT_SinkeiyakuSyoukenSuiiTy> getAllSinkeiyakuSyoukenSuiiTy(){
        return sinkeiyakuSyoukenSuiiTyDao.selectAllZT_SinkeiyakuSyoukenSuiiTy();
    }



    ZT_SinkeiyakuSyoukenSuiiTy getSinkeiyakuSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {

        return sinkeiyakuSyoukenSuiiTyDao.getSinkeiyakuSyoukenSuiiTy(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    ExDBResults<ZT_SinkeiyakuSyoukenSuiiRn> getAllSinkeiyakuSyoukenSuiiRn(){
        return sinkeiyakuSyoukenSuiiRnDao.selectAllZT_SinkeiyakuSyoukenSuiiRn();
    }



    ZT_SinkeiyakuSyoukenSuiiRn getSinkeiyakuSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {

        return sinkeiyakuSyoukenSuiiRnDao.getSinkeiyakuSyoukenSuiiRn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    ExDBResults<ZT_SaihakkouSyoukenSuiiTy> getAllSaihakkouSyoukenSuiiTy(){
        return saihakkouSyoukenSuiiTyDao.selectAllZT_SaihakkouSyoukenSuiiTy();
    }



    ZT_SaihakkouSyoukenSuiiTy getSaihakkouSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {

        return saihakkouSyoukenSuiiTyDao.getSaihakkouSyoukenSuiiTy(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    ExDBResults<ZT_SaihakkouSyoukenSuiiRn> getAllSaihakkouSyoukenSuiiRn(){
        return saihakkouSyoukenSuiiRnDao.selectAllZT_SaihakkouSyoukenSuiiRn();
    }



    ZT_SaihakkouSyoukenSuiiRn getSaihakkouSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {

        return saihakkouSyoukenSuiiRnDao.getSaihakkouSyoukenSuiiRn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    ExDBResults<ZT_SmbcGetujiKykMeisaiTy> getAllSmbcGetujiKykMeisaiTy(){
        return smbcGetujiKykMeisaiTyDao.selectAllZT_SmbcGetujiKykMeisaiTy();
    }



    ZT_SmbcGetujiKykMeisaiTy getSmbcGetujiKykMeisaiTy(String pZtydatakijyunymd, String pZtydatakijyunym, String pZtysyono) {

        return smbcGetujiKykMeisaiTyDao.getSmbcGetujiKykMeisaiTy(pZtydatakijyunymd, pZtydatakijyunym, pZtysyono);
    }


    ExDBResults<ZT_SmbcGetujiKykMeisaiRn> getAllSmbcGetujiKykMeisaiRn(){
        return smbcGetujiKykMeisaiRnDao.selectAllZT_SmbcGetujiKykMeisaiRn();
    }



    ZT_SmbcGetujiKykMeisaiRn getSmbcGetujiKykMeisaiRn(String pZrndatakijyunymd, String pZrndatakijyunym, String pZrnsyono) {

        return smbcGetujiKykMeisaiRnDao.getSmbcGetujiKykMeisaiRn(pZrndatakijyunymd, pZrndatakijyunym, pZrnsyono);
    }


    ExDBResults<ZT_TumitateYosokuTy> getAllTumitateYosokuTy(){
        return tumitateYosokuTyDao.selectAllZT_TumitateYosokuTy();
    }



    ZT_TumitateYosokuTy getTumitateYosokuTy(String pZtyhknsyukigou, String pZtykeiyakuymd, String pZtytysytymd, String pZtykyktuukasyu, String pZtyhknkkn
        , String pZtytmttknsyuruikbn, String pZtysisuukbn) {

        return tumitateYosokuTyDao.getTumitateYosokuTy(pZtyhknsyukigou, pZtykeiyakuymd, pZtytysytymd, pZtykyktuukasyu, pZtyhknkkn
            , pZtytmttknsyuruikbn, pZtysisuukbn);
    }


    ExDBResults<ZT_TumitateYosokuRn> getAllTumitateYosokuRn(){
        return tumitateYosokuRnDao.selectAllZT_TumitateYosokuRn();
    }



    ZT_TumitateYosokuRn getTumitateYosokuRn(String pZrnhknsyukigou, String pZrnkeiyakuymd, String pZrntysytymd, String pZrnkyktuukasyu, String pZrnhknkkn
        , String pZrntmttknsyuruikbn, String pZrnsisuukbn) {

        return tumitateYosokuRnDao.getTumitateYosokuRn(pZrnhknsyukigou, pZrnkeiyakuymd, pZrntysytymd, pZrnkyktuukasyu, pZrnhknkkn
            , pZrntmttknsyuruikbn, pZrnsisuukbn);
    }


    ZT_SinninTouhyouTy getSinninTouhyouTy(String pZtysyono) {

        return sinninTouhyouTyDao.getSinninTouhyouTy(pZtysyono);
    }


    ExDBResults<ZT_SinninTouhyouTy> getAllSinninTouhyouTy(){
        return sinninTouhyouTyDao.selectAllZT_SinninTouhyouTy();
    }



    ZT_SinninTouhyouRn getSinninTouhyouRn(String pZrnsyono) {

        return sinninTouhyouRnDao.getSinninTouhyouRn(pZrnsyono);
    }


    ExDBResults<ZT_SinninTouhyouRn> getAllSinninTouhyouRn(){
        return sinninTouhyouRnDao.selectAllZT_SinninTouhyouRn();
    }



    ExDBResults<ZT_DattaiTuutiKzhuriRn> getAllDattaiTuutiKzhuriRn(){
        return dattaiTuutiKzhuriRnDao.selectAllZT_DattaiTuutiKzhuriRn();
    }



    ZT_DattaiTuutiKzhuriRn getDattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono) {

        return dattaiTuutiKzhuriRnDao.getDattaiTuutiKzhuriRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_DattaiTuutiKzhuriTy> getAllDattaiTuutiKzhuriTy(){
        return dattaiTuutiKzhuriTyDao.selectAllZT_DattaiTuutiKzhuriTy();
    }



    ZT_DattaiTuutiKzhuriTy getDattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono) {

        return dattaiTuutiKzhuriTyDao.getDattaiTuutiKzhuriTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_GinkouMdhnMisyuuInfoFRn> getAllGinkouMdhnMisyuuInfoFRn(){
        return ginkouMdhnMisyuuInfoFRnDao.selectAllZT_GinkouMdhnMisyuuInfoFRn();
    }



    ZT_GinkouMdhnMisyuuInfoFRn getGinkouMdhnMisyuuInfoFRn(String pZrnbsydrtencd, String pZrndatasakuseiymd, String pZrnsyonosyuban) {

        return ginkouMdhnMisyuuInfoFRnDao.getGinkouMdhnMisyuuInfoFRn(pZrnbsydrtencd, pZrndatasakuseiymd, pZrnsyonosyuban);
    }


    ExDBResults<ZT_GinkouMdhnMisyuuInfoFTy> getAllGinkouMdhnMisyuuInfoFTy(){
        return ginkouMdhnMisyuuInfoFTyDao.selectAllZT_GinkouMdhnMisyuuInfoFTy();
    }



    ZT_GinkouMdhnMisyuuInfoFTy getGinkouMdhnMisyuuInfoFTy(String pZtybsydrtencd, String pZtydatasakuseiymd, String pZtysyonosyuban) {

        return ginkouMdhnMisyuuInfoFTyDao.getGinkouMdhnMisyuuInfoFTy(pZtybsydrtencd, pZtydatasakuseiymd, pZtysyonosyuban);
    }


    ExDBResults<ZT_HrhnTtdkKanRn> getAllHrhnTtdkKanRn(){
        return hrhnTtdkKanRnDao.selectAllZT_HrhnTtdkKanRn();
    }



    ZT_HrhnTtdkKanRn getHrhnTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return hrhnTtdkKanRnDao.getHrhnTtdkKanRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_HrhnTtdkKanTy> getAllHrhnTtdkKanTy(){
        return hrhnTtdkKanTyDao.selectAllZT_HrhnTtdkKanTy();
    }



    ZT_HrhnTtdkKanTy getHrhnTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return hrhnTtdkKanTyDao.getHrhnTtdkKanTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_KesikomiSousinHurikaeRn> getAllKesikomiSousinHurikaeRn(){
        return kesikomiSousinHurikaeRnDao.selectAllZT_KesikomiSousinHurikaeRn();
    }



    ZT_KesikomiSousinHurikaeRn getKesikomiSousinHurikaeRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {

        return kesikomiSousinHurikaeRnDao.getKesikomiSousinHurikaeRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    ExDBResults<ZT_KesikomiSousinHurikaeTy> getAllKesikomiSousinHurikaeTy(){
        return kesikomiSousinHurikaeTyDao.selectAllZT_KesikomiSousinHurikaeTy();
    }



    ZT_KesikomiSousinHurikaeTy getKesikomiSousinHurikaeTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {

        return kesikomiSousinHurikaeTyDao.getKesikomiSousinHurikaeTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    ExDBResults<ZT_KesikomiSousinKouhuriRn> getAllKesikomiSousinKouhuriRn(){
        return kesikomiSousinKouhuriRnDao.selectAllZT_KesikomiSousinKouhuriRn();
    }



    ZT_KesikomiSousinKouhuriRn getKesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {

        return kesikomiSousinKouhuriRnDao.getKesikomiSousinKouhuriRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    ExDBResults<ZT_KesikomiSousinKouhuriTy> getAllKesikomiSousinKouhuriTy(){
        return kesikomiSousinKouhuriTyDao.selectAllZT_KesikomiSousinKouhuriTy();
    }



    ZT_KesikomiSousinKouhuriTy getKesikomiSousinKouhuriTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {

        return kesikomiSousinKouhuriTyDao.getKesikomiSousinKouhuriTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    ExDBResults<ZT_KessanYokukiPRn> getAllKessanYokukiPRn(){
        return kessanYokukiPRnDao.selectAllZT_KessanYokukiPRn();
    }



    ZT_KessanYokukiPRn getKessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono) {

        return kessanYokukiPRnDao.getKessanYokukiPRn(pZrnkeijyouym, pZrnsyono);
    }


    ExDBResults<ZT_KessanYokukiPTy> getAllKessanYokukiPTy(){
        return kessanYokukiPTyDao.selectAllZT_KessanYokukiPTy();
    }



    ZT_KessanYokukiPTy getKessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {

        return kessanYokukiPTyDao.getKessanYokukiPTy(pZtykeijyouym, pZtysyono);
    }


    ExDBResults<ZT_KessanZennouFRn> getAllKessanZennouFRn(){
        return kessanZennouFRnDao.selectAllZT_KessanZennouFRn();
    }



    ZT_KessanZennouFRn getKessanZennouFRn(String pZrnsyono, String pZrnkbnkeiriyousegmentcd, String pZrnzennoutoukeilistkbn, String pZrnzennoukbn) {

        return kessanZennouFRnDao.getKessanZennouFRn(pZrnsyono, pZrnkbnkeiriyousegmentcd, pZrnzennoutoukeilistkbn, pZrnzennoukbn);
    }


    ExDBResults<ZT_KessanZennouFTy> getAllKessanZennouFTy(){
        return kessanZennouFTyDao.selectAllZT_KessanZennouFTy();
    }



    ZT_KessanZennouFTy getKessanZennouFTy(String pZtysyono, String pZtykbnkeiriyousegmentcd, String pZtyzennoutoukeilistkbn, String pZtyzennoukbn) {

        return kessanZennouFTyDao.getKessanZennouFTy(pZtysyono, pZtykbnkeiriyousegmentcd, pZtyzennoutoukeilistkbn, pZtyzennoukbn);
    }


    ExDBResults<ZT_KhDrtenMinyuuKykMeisaiRn> getAllKhDrtenMinyuuKykMeisaiRn(){
        return khDrtenMinyuuKykMeisaiRnDao.selectAllZT_KhDrtenMinyuuKykMeisaiRn();
    }



    ZT_KhDrtenMinyuuKykMeisaiRn getKhDrtenMinyuuKykMeisaiRn(String pZrnsyoriymd, String pZrnbsydrtencd, String pZrnsyono) {

        return khDrtenMinyuuKykMeisaiRnDao.getKhDrtenMinyuuKykMeisaiRn(pZrnsyoriymd, pZrnbsydrtencd, pZrnsyono);
    }


    ExDBResults<ZT_KhDrtenMinyuuKykMeisaiTy> getAllKhDrtenMinyuuKykMeisaiTy(){
        return khDrtenMinyuuKykMeisaiTyDao.selectAllZT_KhDrtenMinyuuKykMeisaiTy();
    }



    ZT_KhDrtenMinyuuKykMeisaiTy getKhDrtenMinyuuKykMeisaiTy(String pZtysyoriymd, String pZtybsydrtencd, String pZtysyono) {

        return khDrtenMinyuuKykMeisaiTyDao.getKhDrtenMinyuuKykMeisaiTy(pZtysyoriymd, pZtybsydrtencd, pZtysyono);
    }


    ExDBResults<ZT_KhGinkouMdhnFollowCallRn> getAllKhGinkouMdhnFollowCallRn(){
        return khGinkouMdhnFollowCallRnDao.selectAllZT_KhGinkouMdhnFollowCallRn();
    }



    ZT_KhGinkouMdhnFollowCallRn getKhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {

        return khGinkouMdhnFollowCallRnDao.getKhGinkouMdhnFollowCallRn(pZrnsyono, pZrnminyuuym);
    }


    ExDBResults<ZT_KhGinkouMdhnFollowCallTy> getAllKhGinkouMdhnFollowCallTy(){
        return khGinkouMdhnFollowCallTyDao.selectAllZT_KhGinkouMdhnFollowCallTy();
    }



    ZT_KhGinkouMdhnFollowCallTy getKhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {

        return khGinkouMdhnFollowCallTyDao.getKhGinkouMdhnFollowCallTy(pZtysyono, pZtyminyuuym);
    }


    ExDBResults<ZT_KijituTouraiAnnaiRn> getAllKijituTouraiAnnaiRn(){
        return kijituTouraiAnnaiRnDao.selectAllZT_KijituTouraiAnnaiRn();
    }



    ZT_KijituTouraiAnnaiRn getKijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {

        return kijituTouraiAnnaiRnDao.getKijituTouraiAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_KijituTouraiAnnaiTy> getAllKijituTouraiAnnaiTy(){
        return kijituTouraiAnnaiTyDao.selectAllZT_KijituTouraiAnnaiTy();
    }



    ZT_KijituTouraiAnnaiTy getKijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {

        return kijituTouraiAnnaiTyDao.getKijituTouraiAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_KouzaHnknTuutiRn> getAllKouzaHnknTuutiRn(){
        return kouzaHnknTuutiRnDao.selectAllZT_KouzaHnknTuutiRn();
    }



    ZT_KouzaHnknTuutiRn getKouzaHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return kouzaHnknTuutiRnDao.getKouzaHnknTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_KouzaHnknTuutiTy> getAllKouzaHnknTuutiTy(){
        return kouzaHnknTuutiTyDao.selectAllZT_KouzaHnknTuutiTy();
    }



    ZT_KouzaHnknTuutiTy getKouzaHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return kouzaHnknTuutiTyDao.getKouzaHnknTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_KouzaHrkmTuutiRn> getAllKouzaHrkmTuutiRn(){
        return kouzaHrkmTuutiRnDao.selectAllZT_KouzaHrkmTuutiRn();
    }



    ZT_KouzaHrkmTuutiRn getKouzaHrkmTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return kouzaHrkmTuutiRnDao.getKouzaHrkmTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_KouzaHrkmTuutiTy> getAllKouzaHrkmTuutiTy(){
        return kouzaHrkmTuutiTyDao.selectAllZT_KouzaHrkmTuutiTy();
    }



    ZT_KouzaHrkmTuutiTy getKouzaHrkmTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return kouzaHrkmTuutiTyDao.getKouzaHrkmTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_KouzahuriMinyuTuutiRn> getAllKouzahuriMinyuTuutiRn(){
        return kouzahuriMinyuTuutiRnDao.selectAllZT_KouzahuriMinyuTuutiRn();
    }



    ZT_KouzahuriMinyuTuutiRn getKouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {

        return kouzahuriMinyuTuutiRnDao.getKouzahuriMinyuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_KouzahuriMinyuTuutiTy> getAllKouzahuriMinyuTuutiTy(){
        return kouzahuriMinyuTuutiTyDao.selectAllZT_KouzahuriMinyuTuutiTy();
    }



    ZT_KouzahuriMinyuTuutiTy getKouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {

        return kouzahuriMinyuTuutiTyDao.getKouzahuriMinyuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_KouzahuriStartAnnaiRn> getAllKouzahuriStartAnnaiRn(){
        return kouzahuriStartAnnaiRnDao.selectAllZT_KouzahuriStartAnnaiRn();
    }



    ZT_KouzahuriStartAnnaiRn getKouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {

        return kouzahuriStartAnnaiRnDao.getKouzahuriStartAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_KouzahuriStartAnnaiTy> getAllKouzahuriStartAnnaiTy(){
        return kouzahuriStartAnnaiTyDao.selectAllZT_KouzahuriStartAnnaiTy();
    }



    ZT_KouzahuriStartAnnaiTy getKouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {

        return kouzahuriStartAnnaiTyDao.getKouzahuriStartAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_KzhuriAnnaiUlfRn> getAllKzhuriAnnaiUlfRn(){
        return kzhuriAnnaiUlfRnDao.selectAllZT_KzhuriAnnaiUlfRn();
    }



    ZT_KzhuriAnnaiUlfRn getKzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {

        return kzhuriAnnaiUlfRnDao.getKzhuriAnnaiUlfRn(pZrnsyono, pZrnjyuutouym);
    }


    ExDBResults<ZT_KzhuriAnnaiUlfTy> getAllKzhuriAnnaiUlfTy(){
        return kzhuriAnnaiUlfTyDao.selectAllZT_KzhuriAnnaiUlfTy();
    }



    ZT_KzhuriAnnaiUlfTy getKzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {

        return kzhuriAnnaiUlfTyDao.getKzhuriAnnaiUlfTy(pZtysyono, pZtyjyuutouym);
    }


    ExDBResults<ZT_SinkokuYokokuTuutiFSksRn> getAllSinkokuYokokuTuutiFSksRn(){
        return sinkokuYokokuTuutiFSksRnDao.selectAllZT_SinkokuYokokuTuutiFSksRn();
    }



    ZT_SinkokuYokokuTuutiFSksRn getSinkokuYokokuTuutiFSksRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsinkokunenkj) {

        return sinkokuYokokuTuutiFSksRnDao.getSinkokuYokokuTuutiFSksRn(pZrntyouhyouymd, pZrnsyono, pZrnsinkokunenkj);
    }


    ExDBResults<ZT_SinkokuYokokuTuutiFSksTy> getAllSinkokuYokokuTuutiFSksTy(){
        return sinkokuYokokuTuutiFSksTyDao.selectAllZT_SinkokuYokokuTuutiFSksTy();
    }



    ZT_SinkokuYokokuTuutiFSksTy getSinkokuYokokuTuutiFSksTy(String pZtytyouhyouymd, String pZtysyono, String pZtysinkokunenkj) {

        return sinkokuYokokuTuutiFSksTyDao.getSinkokuYokokuTuutiFSksTy(pZtytyouhyouymd, pZtysyono, pZtysinkokunenkj);
    }


    ExDBResults<ZT_DrtenMinyuuKykInfoRn> getAllDrtenMinyuuKykInfoRn(){
        return drtenMinyuuKykInfoRnDao.selectAllZT_DrtenMinyuuKykInfoRn();
    }



    ZT_DrtenMinyuuKykInfoRn getDrtenMinyuuKykInfoRn(String pZrnsyono) {

        return drtenMinyuuKykInfoRnDao.getDrtenMinyuuKykInfoRn(pZrnsyono);
    }


    ExDBResults<ZT_DrtenMinyuuKykInfoTy> getAllDrtenMinyuuKykInfoTy(){
        return drtenMinyuuKykInfoTyDao.selectAllZT_DrtenMinyuuKykInfoTy();
    }



    ZT_DrtenMinyuuKykInfoTy getDrtenMinyuuKykInfoTy(String pZtysyono) {

        return drtenMinyuuKykInfoTyDao.getDrtenMinyuuKykInfoTy(pZtysyono);
    }


    ExDBResults<ZT_DrtenMinyuKykDtlSyokaiRn> getAllDrtenMinyuKykDtlSyokaiRn(){
        return drtenMinyuKykDtlSyokaiRnDao.selectAllZT_DrtenMinyuKykDtlSyokaiRn();
    }



    ZT_DrtenMinyuKykDtlSyokaiRn getDrtenMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {

        return drtenMinyuKykDtlSyokaiRnDao.getDrtenMinyuKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    ExDBResults<ZT_DrtenMinyuKykDtlSyokaiTy> getAllDrtenMinyuKykDtlSyokaiTy(){
        return drtenMinyuKykDtlSyokaiTyDao.selectAllZT_DrtenMinyuKykDtlSyokaiTy();
    }



    ZT_DrtenMinyuKykDtlSyokaiTy getDrtenMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {

        return drtenMinyuKykDtlSyokaiTyDao.getDrtenMinyuKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    ExDBResults<ZT_YuseiMinyuKykDtlSyokaiRn> getAllYuseiMinyuKykDtlSyokaiRn(){
        return yuseiMinyuKykDtlSyokaiRnDao.selectAllZT_YuseiMinyuKykDtlSyokaiRn();
    }



    ZT_YuseiMinyuKykDtlSyokaiRn getYuseiMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {

        return yuseiMinyuKykDtlSyokaiRnDao.getYuseiMinyuKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    ExDBResults<ZT_YuseiMinyuKykDtlSyokaiTy> getAllYuseiMinyuKykDtlSyokaiTy(){
        return yuseiMinyuKykDtlSyokaiTyDao.selectAllZT_YuseiMinyuKykDtlSyokaiTy();
    }



    ZT_YuseiMinyuKykDtlSyokaiTy getYuseiMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {

        return yuseiMinyuKykDtlSyokaiTyDao.getYuseiMinyuKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    ExDBResults<ZT_DrtenMisyuSkInfoDataRn> getAllDrtenMisyuSkInfoDataRn(){
        return drtenMisyuSkInfoDataRnDao.selectAllZT_DrtenMisyuSkInfoDataRn();
    }



    ZT_DrtenMisyuSkInfoDataRn getDrtenMisyuSkInfoDataRn(String pZrnsyono, String pZrnbsydrtencd, String pZrnhanteiymd) {

        return drtenMisyuSkInfoDataRnDao.getDrtenMisyuSkInfoDataRn(pZrnsyono, pZrnbsydrtencd, pZrnhanteiymd);
    }


    ExDBResults<ZT_DrtenMisyuSkInfoDataTy> getAllDrtenMisyuSkInfoDataTy(){
        return drtenMisyuSkInfoDataTyDao.selectAllZT_DrtenMisyuSkInfoDataTy();
    }



    ZT_DrtenMisyuSkInfoDataTy getDrtenMisyuSkInfoDataTy(String pZtysyono, String pZtybsydrtencd, String pZtyhanteiymd) {

        return drtenMisyuSkInfoDataTyDao.getDrtenMisyuSkInfoDataTy(pZtysyono, pZtybsydrtencd, pZtyhanteiymd);
    }


    ExDBResults<ZT_SaihakkouSyoukenSuii2Rn> getAllSaihakkouSyoukenSuii2Rn(){
        return saihakkouSyoukenSuii2RnDao.selectAllZT_SaihakkouSyoukenSuii2Rn();
    }



    ZT_SaihakkouSyoukenSuii2Rn getSaihakkouSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {

        return saihakkouSyoukenSuii2RnDao.getSaihakkouSyoukenSuii2Rn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    ExDBResults<ZT_SaihakkouSyoukenSuii2Ty> getAllSaihakkouSyoukenSuii2Ty(){
        return saihakkouSyoukenSuii2TyDao.selectAllZT_SaihakkouSyoukenSuii2Ty();
    }



    ZT_SaihakkouSyoukenSuii2Ty getSaihakkouSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {

        return saihakkouSyoukenSuii2TyDao.getSaihakkouSyoukenSuii2Ty(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    ExDBResults<ZT_SinkeiyakuSyoukenSuii2Rn> getAllSinkeiyakuSyoukenSuii2Rn(){
        return sinkeiyakuSyoukenSuii2RnDao.selectAllZT_SinkeiyakuSyoukenSuii2Rn();
    }



    ZT_SinkeiyakuSyoukenSuii2Rn getSinkeiyakuSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {

        return sinkeiyakuSyoukenSuii2RnDao.getSinkeiyakuSyoukenSuii2Rn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    ExDBResults<ZT_SinkeiyakuSyoukenSuii2Ty> getAllSinkeiyakuSyoukenSuii2Ty(){
        return sinkeiyakuSyoukenSuii2TyDao.selectAllZT_SinkeiyakuSyoukenSuii2Ty();
    }



    ZT_SinkeiyakuSyoukenSuii2Ty getSinkeiyakuSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {

        return sinkeiyakuSyoukenSuii2TyDao.getSinkeiyakuSyoukenSuii2Ty(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    ExDBResults<ZT_ZennouHoyuuIdouKykDtlTy> getAllZennouHoyuuIdouKykDtlTy(){
        return zennouHoyuuIdouKykDtlTyDao.selectAllZT_ZennouHoyuuIdouKykDtlTy();
    }



    ZT_ZennouHoyuuIdouKykDtlTy getZennouHoyuuIdouKykDtlTy(String pZtydatakanrino, String pZtysyoricd, Integer pZtykykmfksnctr) {

        return zennouHoyuuIdouKykDtlTyDao.getZennouHoyuuIdouKykDtlTy(pZtydatakanrino, pZtysyoricd, pZtykykmfksnctr);
    }


    ExDBResults<ZT_ZennouHoyuuIdouKykDtlRn> getAllZennouHoyuuIdouKykDtlRn(){
        return zennouHoyuuIdouKykDtlRnDao.selectAllZT_ZennouHoyuuIdouKykDtlRn();
    }



    ZT_ZennouHoyuuIdouKykDtlRn getZennouHoyuuIdouKykDtlRn(String pZrndatakanrino, String pZrnsyoricd, Integer pZrnkykmfksnctr) {

        return zennouHoyuuIdouKykDtlRnDao.getZennouHoyuuIdouKykDtlRn(pZrndatakanrino, pZrnsyoricd, pZrnkykmfksnctr);
    }


    ExDBResults<ZT_SyoumetuTuutiTy> getAllSyoumetuTuutiTy(){
        return syoumetuTuutiTyDao.selectAllZT_SyoumetuTuutiTy();
    }



    ZT_SyoumetuTuutiTy getSyoumetuTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return syoumetuTuutiTyDao.getSyoumetuTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_SyoumetuTuutiRn> getAllSyoumetuTuutiRn(){
        return syoumetuTuutiRnDao.selectAllZT_SyoumetuTuutiRn();
    }



    ZT_SyoumetuTuutiRn getSyoumetuTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return syoumetuTuutiRnDao.getSyoumetuTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    ExDBResults<ZT_DrtenSkKykDtlSyokaiTy> getAllDrtenSkKykDtlSyokaiTy(){
        return drtenSkKykDtlSyokaiTyDao.selectAllZT_DrtenSkKykDtlSyokaiTy();
    }



    ZT_DrtenSkKykDtlSyokaiTy getDrtenSkKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {

        return drtenSkKykDtlSyokaiTyDao.getDrtenSkKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    ExDBResults<ZT_DrtenSkKykDtlSyokaiRn> getAllDrtenSkKykDtlSyokaiRn(){
        return drtenSkKykDtlSyokaiRnDao.selectAllZT_DrtenSkKykDtlSyokaiRn();
    }



    ZT_DrtenSkKykDtlSyokaiRn getDrtenSkKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {

        return drtenSkKykDtlSyokaiRnDao.getDrtenSkKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    ExDBResults<ZT_GentumiSkMikomirituULFTy> getAllGentumiSkMikomirituULFTy(){
        return gentumiSkMikomirituULFTyDao.selectAllZT_GentumiSkMikomirituULFTy();
    }


    ZT_GentumiSkMikomirituULFTy getGentumiSkMikomirituULFTy(String pZtydatakanrino){
        return gentumiSkMikomirituULFTyDao.getGentumiSkMikomirituULFTy(pZtydatakanrino);
    }


    ExDBResults<ZT_GentumiSkMikomirituULFRn> getAllGentumiSkMikomirituULFRn(){
        return gentumiSkMikomirituULFRnDao.selectAllZT_GentumiSkMikomirituULFRn();
    }


    ZT_GentumiSkMikomirituULFRn getGentumiSkMikomirituULFRn(String pZrndatakanrino){
        return gentumiSkMikomirituULFRnDao.getGentumiSkMikomirituULFRn(pZrndatakanrino);
    }


    ExDBResults<ZT_SinBosyuuDrtenHoyuuKykTy> getAllSinBosyuuDrtenHoyuuKykTy(){
        return sinBosyuuDrtenHoyuuKykTyDao.selectAllZT_SinBosyuuDrtenHoyuuKykTy();
    }


    ZT_SinBosyuuDrtenHoyuuKykTy getSinBosyuuDrtenHoyuuKykTy(String pZtysyono){
        return sinBosyuuDrtenHoyuuKykTyDao.getSinBosyuuDrtenHoyuuKykTy(pZtysyono);
    }


    ExDBResults<ZT_SinBosyuuDrtenHoyuuKykRn> getAllSinBosyuuDrtenHoyuuKykRn(){
        return sinBosyuuDrtenHoyuuKykRnDao.selectAllZT_SinBosyuuDrtenHoyuuKykRn();
    }


    ZT_SinBosyuuDrtenHoyuuKykRn getSinBosyuuDrtenHoyuuKykRn(String pZrnsyono){
        return sinBosyuuDrtenHoyuuKykRnDao.getSinBosyuuDrtenHoyuuKykRn(pZrnsyono);
    }


    ExDBResults<ZT_UriageSousinTy> getAllUriageSousinTy(){
        return uriageSousinTyDao.selectAllZT_UriageSousinTy();
    }



    ZT_UriageSousinTy getUriageSousinTy(String pZtycreditkessaiyouno, String pZtysyono, String pZtyuriageseikyuuymd, Long pZtyrsgaku, String pZtyrecordno) {

        return uriageSousinTyDao.getUriageSousinTy(pZtycreditkessaiyouno, pZtysyono, pZtyuriageseikyuuymd, pZtyrsgaku, pZtyrecordno);
    }


    ExDBResults<ZT_UriageSousinRn> getAllUriageSousinRn(){
        return uriageSousinRnDao.selectAllZT_UriageSousinRn();
    }



    ZT_UriageSousinRn getUriageSousinRn(String pZrncreditkessaiyouno, String pZrnsyono, String pZrnuriageseikyuuymd, Long pZrnrsgaku, String pZrnrecordno) {

        return uriageSousinRnDao.getUriageSousinRn(pZrncreditkessaiyouno, pZrnsyono, pZrnuriageseikyuuymd, pZrnrsgaku, pZrnrecordno);
    }


    ExDBResults<ZT_KesikomiSousinCreditTy> getAllKesikomiSousinCreditTy(){
        return kesikomiSousinCreditTyDao.selectAllZT_KesikomiSousinCreditTy();
    }



    ZT_KesikomiSousinCreditTy getKesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {

        return kesikomiSousinCreditTyDao.getKesikomiSousinCreditTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    ExDBResults<ZT_KesikomiSousinCreditRn> getAllKesikomiSousinCreditRn(){
        return kesikomiSousinCreditRnDao.selectAllZT_KesikomiSousinCreditRn();
    }



    ZT_KesikomiSousinCreditRn getKesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {

        return kesikomiSousinCreditRnDao.getKesikomiSousinCreditRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    ExDBResults<ZT_YuukouseiNgTuutiTy> getAllYuukouseiNgTuutiTy(){
        return yuukouseiNgTuutiTyDao.selectAllZT_YuukouseiNgTuutiTy();
    }



    ZT_YuukouseiNgTuutiTy getYuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono) {

        return yuukouseiNgTuutiTyDao.getYuukouseiNgTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    ExDBResults<ZT_YuukouseiNgTuutiRn> getAllYuukouseiNgTuutiRn(){
        return yuukouseiNgTuutiRnDao.selectAllZT_YuukouseiNgTuutiRn();
    }



    ZT_YuukouseiNgTuutiRn getYuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {

        return yuukouseiNgTuutiRnDao.getYuukouseiNgTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    ExDBResults<ZT_DSeisanShrTysySyuseiTy> getAllDSeisanShrTysySyuseiTy(){
        return dSeisanShrTysySyuseiTyDao.selectAllZT_DSeisanShrTysySyuseiTy();
    }



    ZT_DSeisanShrTysySyuseiTy getDSeisanShrTysySyuseiTy(String pZtysyono) {

        return dSeisanShrTysySyuseiTyDao.getDSeisanShrTysySyuseiTy(pZtysyono);
    }


    ExDBResults<ZT_DSeisanShrTysySyuseiRn> getAllDSeisanShrTysySyuseiRn(){
        return dSeisanShrTysySyuseiRnDao.selectAllZT_DSeisanShrTysySyuseiRn();
    }



    ZT_DSeisanShrTysySyuseiRn getDSeisanShrTysySyuseiRn(String pZrnsyono) {

        return dSeisanShrTysySyuseiRnDao.getDSeisanShrTysySyuseiRn(pZrnsyono);
    }


    ExDBResults<ZT_SeisanDHaneiTuutiTy> getAllSeisanDHaneiTuutiTy(){
        return seisanDHaneiTuutiTyDao.selectAllZT_SeisanDHaneiTuutiTy();
    }



    ZT_SeisanDHaneiTuutiTy getSeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {

        return seisanDHaneiTuutiTyDao.getSeisanDHaneiTuutiTy(pZtytyouhyouymd, pZtykeysyono);
    }


    ExDBResults<ZT_SeisanDHaneiTuutiRn> getAllSeisanDHaneiTuutiRn(){
        return seisanDHaneiTuutiRnDao.selectAllZT_SeisanDHaneiTuutiRn();
    }



    ZT_SeisanDHaneiTuutiRn getSeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {

        return seisanDHaneiTuutiRnDao.getSeisanDHaneiTuutiRn(pZrntyouhyouymd, pZrnkeysyono);
    }


    ExDBResults<ZT_DairitenGtmtZndkTy> getAllDairitenGtmtZndkTy(){
        return dairitenGtmtZndkTyDao.selectAllZT_DairitenGtmtZndkTy();
    }


    ZT_DairitenGtmtZndkTy getDairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono){
        return dairitenGtmtZndkTyDao.getDairitenGtmtZndkTy(pZtydatakijyunymd, pZtysyono);
    }


    ExDBResults<ZT_DairitenGtmtZndkRn> getAllDairitenGtmtZndkRn(){
        return dairitenGtmtZndkRnDao.selectAllZT_DairitenGtmtZndkRn();
    }


    ZT_DairitenGtmtZndkRn getDairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono){
        return dairitenGtmtZndkRnDao.getDairitenGtmtZndkRn(pZrndatakijyunymd, pZrnsyono);
    }


    ExDBResults<ZT_CreditHnknTuutiTy> getAllCreditHnknTuutiTy(){
        return creditHnknTuutiTyDao.selectAllZT_CreditHnknTuutiTy();
    }


    ZT_CreditHnknTuutiTy getCreditHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return creditHnknTuutiTyDao.getCreditHnknTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    ExDBResults<ZT_CreditHnknTuutiRn> getAllCreditHnknTuutiRn(){
        return creditHnknTuutiRnDao.selectAllZT_CreditHnknTuutiRn();
    }


    ZT_CreditHnknTuutiRn getCreditHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return creditHnknTuutiRnDao.getCreditHnknTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }
}
