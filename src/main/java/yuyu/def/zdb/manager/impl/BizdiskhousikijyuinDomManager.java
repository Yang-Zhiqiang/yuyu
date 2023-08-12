package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.dao.ZT_AcsAdrNmRnDao;
import yuyu.def.db.dao.ZT_BosyuuninRnDao;
import yuyu.def.db.dao.ZT_DairitenBuntanInfoRnDao;
import yuyu.def.db.dao.ZT_DairitenItakuSyouhnRnDao;
import yuyu.def.db.dao.ZT_DairitenRnDao;
import yuyu.def.db.dao.ZT_DairitenSyougouRnDao;
import yuyu.def.db.dao.ZT_EgsyokuinSysRendouRnDao;
import yuyu.def.db.dao.ZT_EgsyokuinSysRendouTyDao;
import yuyu.def.db.dao.ZT_FurikaeDenpyouHikaeRnDao;
import yuyu.def.db.dao.ZT_FurikaeDenpyouHikaeTyDao;
import yuyu.def.db.dao.ZT_FurikaeDenpyouRnDao;
import yuyu.def.db.dao.ZT_FurikaeDenpyouTyDao;
import yuyu.def.db.dao.ZT_GknyknmeisaiRnDao;
import yuyu.def.db.dao.ZT_GknyknmeisaiTrDao;
import yuyu.def.db.dao.ZT_HonyakuYouKouinRnDao;
import yuyu.def.db.dao.ZT_HoyuuJyunzouZougenFRnDao;
import yuyu.def.db.dao.ZT_HoyuuJyunzouZougenFTyDao;
import yuyu.def.db.dao.ZT_IdCardKihonRnDao;
import yuyu.def.db.dao.ZT_IdCardYakusyokuRnDao;
import yuyu.def.db.dao.ZT_JinsokuShrTtdkInfoRnDao;
import yuyu.def.db.dao.ZT_JinsokuShrTtdkInfoTyDao;
import yuyu.def.db.dao.ZT_KaikeiTorihikiFileRnDao;
import yuyu.def.db.dao.ZT_KaikeiTorihikiFileTyDao;
import yuyu.def.db.dao.ZT_KawaserateRnDao;
import yuyu.def.db.dao.ZT_KawaserateTrDao;
import yuyu.def.db.dao.ZT_KeizokurituRenrakuULFRnDao;
import yuyu.def.db.dao.ZT_KeizokurituRenrakuULFTyDao;
import yuyu.def.db.dao.ZT_KinyuuKikanInfoRnDao;
import yuyu.def.db.dao.ZT_KokyakuYuyuKykmeisaiFRnDao;
import yuyu.def.db.dao.ZT_KokyakuYuyuKykmeisaiFTyDao;
import yuyu.def.db.dao.ZT_KubunKeiriFileRnDao;
import yuyu.def.db.dao.ZT_KubunKeiriFileTyDao;
import yuyu.def.db.dao.ZT_NyknmeisaiRnDao;
import yuyu.def.db.dao.ZT_NyknmeisaiTrDao;
import yuyu.def.db.dao.ZT_OnlineGknyknmeisaiRnDao;
import yuyu.def.db.dao.ZT_OnlineGknyknmeisaiTrDao;
import yuyu.def.db.dao.ZT_SiharaiTyousyoRnDao;
import yuyu.def.db.dao.ZT_SiharaiTyousyoTyDao;
import yuyu.def.db.dao.ZT_SinkimatuHoyuuFRnDao;
import yuyu.def.db.dao.ZT_SinkimatuHoyuuFTyDao;
import yuyu.def.db.dao.ZT_SisuuRendouRnDao;
import yuyu.def.db.dao.ZT_SkFurikaeDenpyouHikaeRnDao;
import yuyu.def.db.dao.ZT_SkFurikaeDenpyouHikaeTyDao;
import yuyu.def.db.dao.ZT_SkFurikaeDenpyouRnDao;
import yuyu.def.db.dao.ZT_SkFurikaeDenpyouTyDao;
import yuyu.def.db.dao.ZT_SkIpJissekiRnDao;
import yuyu.def.db.dao.ZT_SkIpJissekiTyDao;
import yuyu.def.db.dao.ZT_SkKaikeiTorihikiFileRnDao;
import yuyu.def.db.dao.ZT_SkKaikeiTorihikiFileTyDao;
import yuyu.def.db.dao.ZT_SkKubunKeiriFileRnDao;
import yuyu.def.db.dao.ZT_SkKubunKeiriFileTyDao;
import yuyu.def.db.dao.ZT_SosikiRnDao;
import yuyu.def.db.dao.ZT_TuukabetuKyuusibiRnDao;
import yuyu.def.db.dao.ZT_TuutirirekiMeisaiFRnDao;
import yuyu.def.db.dao.ZT_TuutirirekiMeisaiFTyDao;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.entity.ZT_FurikaeDenpyouRn;
import yuyu.def.db.entity.ZT_FurikaeDenpyouTy;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileTy;
import yuyu.def.db.entity.ZT_KawaserateRn;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.entity.ZT_KubunKeiriFileRn;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFRn;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouRn;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouTy;
import yuyu.def.db.entity.ZT_SkIpJissekiRn;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileRn;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileTy;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;


/**
 * BizdiskhousikijyuinDomマネージャー<br />
 * Bizdiskhousikijyuinにおける、DB操作を提供する。<br />
 */
class BizdiskhousikijyuinDomManager {


    @Inject
    private ZT_AcsAdrNmRnDao acsAdrNmRnDao;


    @Inject
    private ZT_BosyuuninRnDao bosyuuninRnDao;


    @Inject
    private ZT_DairitenBuntanInfoRnDao dairitenBuntanInfoRnDao;


    @Inject
    private ZT_DairitenItakuSyouhnRnDao dairitenItakuSyouhnRnDao;


    @Inject
    private ZT_DairitenRnDao dairitenRnDao;


    @Inject
    private ZT_DairitenSyougouRnDao dairitenSyougouRnDao;


    @Inject
    private ZT_EgsyokuinSysRendouRnDao egsyokuinSysRendouRnDao;


    @Inject
    private ZT_EgsyokuinSysRendouTyDao egsyokuinSysRendouTyDao;


    @Inject
    private ZT_FurikaeDenpyouHikaeRnDao furikaeDenpyouHikaeRnDao;


    @Inject
    private ZT_FurikaeDenpyouHikaeTyDao furikaeDenpyouHikaeTyDao;


    @Inject
    private ZT_FurikaeDenpyouRnDao furikaeDenpyouRnDao;


    @Inject
    private ZT_FurikaeDenpyouTyDao furikaeDenpyouTyDao;


    @Inject
    private ZT_GknyknmeisaiRnDao gknyknmeisaiRnDao;


    @Inject
    private ZT_GknyknmeisaiTrDao gknyknmeisaiTrDao;


    @Inject
    private ZT_HonyakuYouKouinRnDao honyakuYouKouinRnDao;


    @Inject
    private ZT_HoyuuJyunzouZougenFRnDao hoyuuJyunzouZougenFRnDao;


    @Inject
    private ZT_HoyuuJyunzouZougenFTyDao hoyuuJyunzouZougenFTyDao;


    @Inject
    private ZT_IdCardKihonRnDao idCardKihonRnDao;


    @Inject
    private ZT_IdCardYakusyokuRnDao idCardYakusyokuRnDao;


    @Inject
    private ZT_JinsokuShrTtdkInfoRnDao jinsokuShrTtdkInfoRnDao;


    @Inject
    private ZT_JinsokuShrTtdkInfoTyDao jinsokuShrTtdkInfoTyDao;


    @Inject
    private ZT_KaikeiTorihikiFileRnDao kaikeiTorihikiFileRnDao;


    @Inject
    private ZT_KaikeiTorihikiFileTyDao kaikeiTorihikiFileTyDao;


    @Inject
    private ZT_KawaserateRnDao kawaserateRnDao;


    @Inject
    private ZT_KawaserateTrDao kawaserateTrDao;


    @Inject
    private ZT_KeizokurituRenrakuULFRnDao keizokurituRenrakuULFRnDao;


    @Inject
    private ZT_KeizokurituRenrakuULFTyDao keizokurituRenrakuULFTyDao;


    @Inject
    private ZT_KinyuuKikanInfoRnDao kinyuuKikanInfoRnDao;


    @Inject
    private ZT_KokyakuYuyuKykmeisaiFRnDao kokyakuYuyuKykmeisaiFRnDao;


    @Inject
    private ZT_KokyakuYuyuKykmeisaiFTyDao kokyakuYuyuKykmeisaiFTyDao;


    @Inject
    private ZT_KubunKeiriFileRnDao kubunKeiriFileRnDao;


    @Inject
    private ZT_KubunKeiriFileTyDao kubunKeiriFileTyDao;


    @Inject
    private ZT_NyknmeisaiRnDao nyknmeisaiRnDao;


    @Inject
    private ZT_NyknmeisaiTrDao nyknmeisaiTrDao;


    @Inject
    private ZT_SiharaiTyousyoRnDao siharaiTyousyoRnDao;


    @Inject
    private ZT_SiharaiTyousyoTyDao siharaiTyousyoTyDao;


    @Inject
    private ZT_SinkimatuHoyuuFRnDao sinkimatuHoyuuFRnDao;


    @Inject
    private ZT_SinkimatuHoyuuFTyDao sinkimatuHoyuuFTyDao;


    @Inject
    private ZT_SisuuRendouRnDao sisuuRendouRnDao;


    @Inject
    private ZT_SkFurikaeDenpyouHikaeRnDao skFurikaeDenpyouHikaeRnDao;


    @Inject
    private ZT_SkFurikaeDenpyouHikaeTyDao skFurikaeDenpyouHikaeTyDao;


    @Inject
    private ZT_SkFurikaeDenpyouRnDao skFurikaeDenpyouRnDao;


    @Inject
    private ZT_SkFurikaeDenpyouTyDao skFurikaeDenpyouTyDao;


    @Inject
    private ZT_SkIpJissekiRnDao skIpJissekiRnDao;


    @Inject
    private ZT_SkIpJissekiTyDao skIpJissekiTyDao;


    @Inject
    private ZT_SkKaikeiTorihikiFileRnDao skKaikeiTorihikiFileRnDao;


    @Inject
    private ZT_SkKaikeiTorihikiFileTyDao skKaikeiTorihikiFileTyDao;


    @Inject
    private ZT_SkKubunKeiriFileRnDao skKubunKeiriFileRnDao;


    @Inject
    private ZT_SkKubunKeiriFileTyDao skKubunKeiriFileTyDao;


    @Inject
    private ZT_SosikiRnDao sosikiRnDao;


    @Inject
    private ZT_TuukabetuKyuusibiRnDao tuukabetuKyuusibiRnDao;


    @Inject
    private ZT_TuutirirekiMeisaiFRnDao tuutirirekiMeisaiFRnDao;


    @Inject
    private ZT_TuutirirekiMeisaiFTyDao tuutirirekiMeisaiFTyDao;


    @Inject
    private ZT_OnlineGknyknmeisaiRnDao onlineGknyknmeisaiRnDao;


    @Inject
    private ZT_OnlineGknyknmeisaiTrDao onlineGknyknmeisaiTrDao;


    Long getAcsAdrNmRnCount() {

        return acsAdrNmRnDao.getAcsAdrNmRnCount();
    }


    ExDBResults<ZT_KinyuuKikanInfoRn> getAllKinyuuKikanInfoRn(){
        return kinyuuKikanInfoRnDao.selectAllZT_KinyuuKikanInfoRn();
    }



    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdNe4Space() {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRnsByZrnsitencdNe4Space();
    }


    ZT_KinyuuKikanInfoRn getKinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRn(pZrnkinyuukikancd, pZrnsitencd);
    }


    Long getKinyuuKikanInfoRnCountByZrnsitencdNe4Space() {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRnCountByZrnsitencdNe4Space();
    }


    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(String pZrnkinyuukikancdKeta4) {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(pZrnkinyuukikancdKeta4);
    }


    Long getKinyuuKikanInfoRnCountByZrnsitencdE4Space() {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();
    }


    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdE4Space() {

        return kinyuuKikanInfoRnDao.getKinyuuKikanInfoRnsByZrnsitencdE4Space();
    }


    ExDBResults<ZT_AcsAdrNmRn> getAllAcsAdrNmRn(){
        return acsAdrNmRnDao.selectAllZT_AcsAdrNmRn();
    }



    ZT_AcsAdrNmRn getAcsAdrNmRn(String pZrnkihontikucd) {

        return acsAdrNmRnDao.getAcsAdrNmRn(pZrnkihontikucd);
    }


    ExDBResults<ZT_AcsAdrNmRn> getAcsAdrNmRnsByZrnkihontikucdKeta7(String pZrnkihontikucdKeta7) {

        return acsAdrNmRnDao.getAcsAdrNmRnsByZrnkihontikucdKeta7(pZrnkihontikucdKeta7);
    }


    ExDBResults<ZT_DairitenRn> getAllDairitenRn(){
        return dairitenRnDao.selectAllZT_DairitenRn();
    }



    Long getDairitenRnCount() {

        return dairitenRnDao.getDairitenRnCount();
    }


    ZT_DairitenRn getDairitenRn(String pZrndairitencd) {

        return dairitenRnDao.getDairitenRn(pZrndairitencd);
    }


    ExDBResults<ZT_DairitenSyougouRn> getAllDairitenSyougouRn(){
        return dairitenSyougouRnDao.selectAllZT_DairitenSyougouRn();
    }



    ZT_DairitenSyougouRn getDairitenSyougouRn(String pZrndairitencd) {

        return dairitenSyougouRnDao.getDairitenSyougouRn(pZrndairitencd);
    }


    Long getDairitenSyougouRnCount() {

        return dairitenSyougouRnDao.getDairitenSyougouRnCount();
    }


    ExDBResults<ZT_TuukabetuKyuusibiRn> getAllTuukabetuKyuusibiRn(){
        return tuukabetuKyuusibiRnDao.selectAllZT_TuukabetuKyuusibiRn();
    }



    ZT_TuukabetuKyuusibiRn getTuukabetuKyuusibiRn(String pZrntekiyouymd) {

        return tuukabetuKyuusibiRnDao.getTuukabetuKyuusibiRn(pZrntekiyouymd);
    }


    Long getTuukabetuKyuusibiRnCount() {

        return tuukabetuKyuusibiRnDao.getTuukabetuKyuusibiRnCount();
    }


    ExDBResults<ZT_BosyuuninRn> getAllBosyuuninRn(){
        return bosyuuninRnDao.selectAllZT_BosyuuninRn();
    }



    ZT_BosyuuninRn getBosyuuninRn(String pZrnbosyuunincd) {

        return bosyuuninRnDao.getBosyuuninRn(pZrnbosyuunincd);
    }


    ExDBResults<ZT_BosyuuninRn> getBosyuuninRnsByZrnbosyuunincdKeta6(String pZrnbosyuunincdKeta6) {

        return bosyuuninRnDao.getBosyuuninRnsByZrnbosyuunincdKeta6(pZrnbosyuunincdKeta6);
    }


    ExDBResults<ZT_DairitenBuntanInfoRn> getAllDairitenBuntanInfoRn(){
        return dairitenBuntanInfoRnDao.selectAllZT_DairitenBuntanInfoRn();
    }



    ZT_DairitenBuntanInfoRn getDairitenBuntanInfoRn(String pZrndairitencd, String pZrndairitensyouhincd, String pZrntesuuryoubuntandrtencd, String pZrntesuuryoubuntanstartym) {

        return dairitenBuntanInfoRnDao.getDairitenBuntanInfoRn(pZrndairitencd, pZrndairitensyouhincd, pZrntesuuryoubuntandrtencd, pZrntesuuryoubuntanstartym);
    }


    ExDBResults<ZT_HonyakuYouKouinRn> getAllHonyakuYouKouinRn(){
        return honyakuYouKouinRnDao.selectAllZT_HonyakuYouKouinRn();
    }



    ZT_HonyakuYouKouinRn getHonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {

        return honyakuYouKouinRnDao.getHonyakuYouKouinRn(pZrnkinyuukikancd, pZrnkouincd);
    }


    ExDBResults<ZT_HonyakuYouKouinRn> getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(String pZrnkinyuukikancdKeta4) {

        return honyakuYouKouinRnDao.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(pZrnkinyuukikancdKeta4);
    }


    Long getHonyakuYouKouinRnCount() {

        return honyakuYouKouinRnDao.getHonyakuYouKouinRnCount();
    }


    ExDBResults<ZT_IdCardKihonRn> getAllIdCardKihonRn(){
        return idCardKihonRnDao.selectAllZT_IdCardKihonRn();
    }



    ZT_IdCardKihonRn getIdCardKihonRn(String pZrnidkbn, String pZrnidcd) {

        return idCardKihonRnDao.getIdCardKihonRn(pZrnidkbn, pZrnidcd);
    }


    Long getIdCardKihonRnCount() {

        return idCardKihonRnDao.getIdCardKihonRnCount();
    }


    ExDBResults<ZT_IdCardKihonRn> getIdCardKihonRnsByZrnidcdKeta6(String pZrnidcdKeta6) {

        return idCardKihonRnDao.getIdCardKihonRnsByZrnidcdKeta6(pZrnidcdKeta6);
    }


    ExDBResults<ZT_IdCardYakusyokuRn> getAllIdCardYakusyokuRn(){
        return idCardYakusyokuRnDao.selectAllZT_IdCardYakusyokuRn();
    }



    ZT_IdCardYakusyokuRn getIdCardYakusyokuRn(String pZrnidkbn, String pZrnidcd, String pZrnyakusyokuhatureiymd, String pZrnyakusyokuhatureino) {

        return idCardYakusyokuRnDao.getIdCardYakusyokuRn(pZrnidkbn, pZrnidcd, pZrnyakusyokuhatureiymd, pZrnyakusyokuhatureino);
    }


    Long getIdCardYakusyokuRnCount() {

        return idCardYakusyokuRnDao.getIdCardYakusyokuRnCount();
    }


    ExDBResults<ZT_SosikiRn> getAllSosikiRn(){
        return sosikiRnDao.selectAllZT_SosikiRn();
    }



    ZT_SosikiRn getSosikiRn(String pZrnsosikicd) {

        return sosikiRnDao.getSosikiRn(pZrnsosikicd);
    }


    Long getSosikiRnCount() {

        return sosikiRnDao.getSosikiRnCount();
    }


    ExDBResults<ZT_KawaserateRn> getAllKawaserateRn(){
        return kawaserateRnDao.selectAllZT_KawaserateRn();
    }



    ZT_KawaserateRn getKawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {

        return kawaserateRnDao.getKawaserateRn(pZrnkwsratekjymd, pZrnkawaserendoukbn);
    }


    ExDBResults<ZT_KawaserateTr> getAllKawaserateTr(){
        return kawaserateTrDao.selectAllZT_KawaserateTr();
    }



    ZT_KawaserateTr getKawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {

        return kawaserateTrDao.getKawaserateTr(pZtrkwsratekjymd, pZtrkawaserendoukbn);
    }


    ExDBResults<ZT_NyknmeisaiRn> getAllNyknmeisaiRn(){
        return nyknmeisaiRnDao.selectAllZT_NyknmeisaiRn();
    }



    ZT_NyknmeisaiRn getNyknmeisaiRn(String pZrnsakuseiymd6keta, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano
        , String pZrnsyoukaino, String pZrnrenno8) {

        return nyknmeisaiRnDao.getNyknmeisaiRn(pZrnsakuseiymd6keta, pZrnbankcd, pZrnshitencd, pZrnyokinkbn, pZrnkouzano
            , pZrnsyoukaino, pZrnrenno8);
    }


    ExDBResults<ZT_NyknmeisaiTr> getAllNyknmeisaiTr(){
        return nyknmeisaiTrDao.selectAllZT_NyknmeisaiTr();
    }



    ZT_NyknmeisaiTr getNyknmeisaiTr(String pZtrsakuseiymd6keta, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano
            , String pZtrsyoukaino, String pZtrrenno8) {

        return nyknmeisaiTrDao.getNyknmeisaiTr(pZtrsakuseiymd6keta, pZtrbankcd, pZtrshitencd, pZtryokinkbn, pZtrkouzano
                , pZtrsyoukaino, pZtrrenno8);
    }


    ExDBResults<ZT_NyknmeisaiTr> getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(String pKakutyoujobcd, String pZtrsakuseiymd6keta) {


        ExDBResults<ZT_NyknmeisaiTr> exDBResults = nyknmeisaiTrDao
            .getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(pZtrsakuseiymd6keta);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<ZT_GknyknmeisaiRn> getAllGknyknmeisaiRn(){
        return gknyknmeisaiRnDao.selectAllZT_GknyknmeisaiRn();
    }



    ZT_GknyknmeisaiRn getGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd
            , String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnksnymd) {

        return gknyknmeisaiRnDao.getGknyknmeisaiRn(pZrnsakuseiymd, pZrnrenrakuymd, pZrnrenrakukaisuu, pZrnbankcd, pZrnshitencd
                , pZrnyokinkbn, pZrnkouzano, pZrnzndktuukasyu, pZrnksnymd);
    }


    ExDBResults<ZT_GknyknmeisaiTr> getAllGknyknmeisaiTr(){
        return gknyknmeisaiTrDao.selectAllZT_GknyknmeisaiTr();
    }



    ExDBResults<ZT_GknyknmeisaiTr> getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(String pKakutyoujobcd, String pZtrsakuseiymd) {


        ExDBResults<ZT_GknyknmeisaiTr> exDBResults = gknyknmeisaiTrDao
                .getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(pZtrsakuseiymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ZT_GknyknmeisaiTr getGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd
            , String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrksnymd) {

        return gknyknmeisaiTrDao.getGknyknmeisaiTr(pZtrsakuseiymd, pZtrrenrakuymd, pZtrrenrakukaisuu, pZtrbankcd, pZtrshitencd
                , pZtryokinkbn, pZtrkouzano, pZtrzndktuukasyu, pZtrksnymd);
    }


    ExDBResults<ZT_FurikaeDenpyouTy> getAllFurikaeDenpyouTy(){
        return furikaeDenpyouTyDao.selectAllZT_FurikaeDenpyouTy();
    }



    ZT_FurikaeDenpyouTy getFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
            , String pZtytorihikituki, String pZtytorihikibi) {

        return furikaeDenpyouTyDao.getFurikaeDenpyouTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
                , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_FurikaeDenpyouHikaeTy> getAllFurikaeDenpyouHikaeTy(){
        return furikaeDenpyouHikaeTyDao.selectAllZT_FurikaeDenpyouHikaeTy();
    }



    ZT_FurikaeDenpyouHikaeTy getFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
            , String pZtytorihikituki, String pZtytorihikibi) {

        return furikaeDenpyouHikaeTyDao.getFurikaeDenpyouHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
                , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_SkFurikaeDenpyouTy> getAllSkFurikaeDenpyouTy(){
        return skFurikaeDenpyouTyDao.selectAllZT_SkFurikaeDenpyouTy();
    }



    ZT_SkFurikaeDenpyouTy getSkFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
            , String pZtytorihikituki, String pZtytorihikibi) {

        return skFurikaeDenpyouTyDao.getSkFurikaeDenpyouTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
                , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_SkFurikaeDenpyouHikaeTy> getAllSkFurikaeDenpyouHikaeTy(){
        return skFurikaeDenpyouHikaeTyDao.selectAllZT_SkFurikaeDenpyouHikaeTy();
    }



    ZT_SkFurikaeDenpyouHikaeTy getSkFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
            , String pZtytorihikituki, String pZtytorihikibi) {

        return skFurikaeDenpyouHikaeTyDao.getSkFurikaeDenpyouHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
                , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_FurikaeDenpyouRn> getAllFurikaeDenpyouRn(){
        return furikaeDenpyouRnDao.selectAllZT_FurikaeDenpyouRn();
    }



    ZT_FurikaeDenpyouRn getFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
            , String pZrntorihikituki, String pZrntorihikibi) {

        return furikaeDenpyouRnDao.getFurikaeDenpyouRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
                , pZrntorihikituki, pZrntorihikibi);
    }


    ExDBResults<ZT_FurikaeDenpyouHikaeRn> getAllFurikaeDenpyouHikaeRn(){
        return furikaeDenpyouHikaeRnDao.selectAllZT_FurikaeDenpyouHikaeRn();
    }



    ZT_FurikaeDenpyouHikaeRn getFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
            , String pZrntorihikituki, String pZrntorihikibi) {

        return furikaeDenpyouHikaeRnDao.getFurikaeDenpyouHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
                , pZrntorihikituki, pZrntorihikibi);
    }


    ExDBResults<ZT_SkFurikaeDenpyouRn> getAllSkFurikaeDenpyouRn(){
        return skFurikaeDenpyouRnDao.selectAllZT_SkFurikaeDenpyouRn();
    }



    ZT_SkFurikaeDenpyouRn getSkFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
            , String pZrntorihikituki, String pZrntorihikibi) {

        return skFurikaeDenpyouRnDao.getSkFurikaeDenpyouRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
                , pZrntorihikituki, pZrntorihikibi);
    }


    ExDBResults<ZT_SkFurikaeDenpyouHikaeRn> getAllSkFurikaeDenpyouHikaeRn(){
        return skFurikaeDenpyouHikaeRnDao.selectAllZT_SkFurikaeDenpyouHikaeRn();
    }



    ZT_SkFurikaeDenpyouHikaeRn getSkFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
            , String pZrntorihikituki, String pZrntorihikibi) {

        return skFurikaeDenpyouHikaeRnDao.getSkFurikaeDenpyouHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
                , pZrntorihikituki, pZrntorihikibi);
    }


    ExDBResults<ZT_JinsokuShrTtdkInfoTy> getAllJinsokuShrTtdkInfoTy(){
        return jinsokuShrTtdkInfoTyDao.selectAllZT_JinsokuShrTtdkInfoTy();
    }



    ZT_JinsokuShrTtdkInfoTy getJinsokuShrTtdkInfoTy(String pZtysyorisosikicd, String pZtysyoricd, String pZtyhknknshrsntkno, String pZtysyoruiukeymd, String pZtysyoriymd
            , String pZtydenymd, String pZtysyono) {

        return jinsokuShrTtdkInfoTyDao.getJinsokuShrTtdkInfoTy(pZtysyorisosikicd, pZtysyoricd, pZtyhknknshrsntkno, pZtysyoruiukeymd, pZtysyoriymd
                , pZtydenymd, pZtysyono);
    }


    ExDBResults<ZT_JinsokuShrTtdkInfoRn> getAllJinsokuShrTtdkInfoRn(){
        return jinsokuShrTtdkInfoRnDao.selectAllZT_JinsokuShrTtdkInfoRn();
    }



    ZT_JinsokuShrTtdkInfoRn getJinsokuShrTtdkInfoRn(String pZrnsyorisosikicd, String pZrnsyoricd, String pZrnhknknshrsntkno, String pZrnsyoruiukeymd, String pZrnsyoriymd
            , String pZrndenymd, String pZrnsyono) {

        return jinsokuShrTtdkInfoRnDao.getJinsokuShrTtdkInfoRn(pZrnsyorisosikicd, pZrnsyoricd, pZrnhknknshrsntkno, pZrnsyoruiukeymd, pZrnsyoriymd
                , pZrndenymd, pZrnsyono);
    }


    ExDBResults<ZT_KaikeiTorihikiFileTy> getAllKaikeiTorihikiFileTy(){
        return kaikeiTorihikiFileTyDao.selectAllZT_KaikeiTorihikiFileTy();
    }



    ZT_KaikeiTorihikiFileTy getKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
            , String pZtysuitoubumon, String pZtytekiyoucd) {

        return kaikeiTorihikiFileTyDao.getKaikeiTorihikiFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
                , pZtysuitoubumon, pZtytekiyoucd);
    }


    ExDBResults<ZT_SkKaikeiTorihikiFileTy> getAllSkKaikeiTorihikiFileTy(){
        return skKaikeiTorihikiFileTyDao.selectAllZT_SkKaikeiTorihikiFileTy();
    }



    ZT_SkKaikeiTorihikiFileTy getSkKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
            , String pZtysuitoubumon, String pZtytekiyoucd) {

        return skKaikeiTorihikiFileTyDao.getSkKaikeiTorihikiFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
                , pZtysuitoubumon, pZtytekiyoucd);
    }


    ExDBResults<ZT_KaikeiTorihikiFileRn> getAllKaikeiTorihikiFileRn(){
        return kaikeiTorihikiFileRnDao.selectAllZT_KaikeiTorihikiFileRn();
    }



    ZT_KaikeiTorihikiFileRn getKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
            , String pZrnsuitoubumon, String pZrntekiyoucd) {

        return kaikeiTorihikiFileRnDao.getKaikeiTorihikiFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
                , pZrnsuitoubumon, pZrntekiyoucd);
    }


    ExDBResults<ZT_SkKaikeiTorihikiFileRn> getAllSkKaikeiTorihikiFileRn(){
        return skKaikeiTorihikiFileRnDao.selectAllZT_SkKaikeiTorihikiFileRn();
    }



    ZT_SkKaikeiTorihikiFileRn getSkKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
            , String pZrnsuitoubumon, String pZrntekiyoucd) {

        return skKaikeiTorihikiFileRnDao.getSkKaikeiTorihikiFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
                , pZrnsuitoubumon, pZrntekiyoucd);
    }


    ExDBResults<ZT_KubunKeiriFileTy> getAllKubunKeiriFileTy(){
        return kubunKeiriFileTyDao.selectAllZT_KubunKeiriFileTy();
    }



    ZT_KubunKeiriFileTy getKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
            , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {

        return kubunKeiriFileTyDao.getKubunKeiriFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
                , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    ExDBResults<ZT_SkKubunKeiriFileTy> getAllSkKubunKeiriFileTy(){
        return skKubunKeiriFileTyDao.selectAllZT_SkKubunKeiriFileTy();
    }



    ZT_SkKubunKeiriFileTy getSkKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
            , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {

        return skKubunKeiriFileTyDao.getSkKubunKeiriFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
                , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    ExDBResults<ZT_KubunKeiriFileRn> getAllKubunKeiriFileRn(){
        return kubunKeiriFileRnDao.selectAllZT_KubunKeiriFileRn();
    }



    ZT_KubunKeiriFileRn getKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
            , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {

        return kubunKeiriFileRnDao.getKubunKeiriFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
                , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    ExDBResults<ZT_SkKubunKeiriFileRn> getAllSkKubunKeiriFileRn(){
        return skKubunKeiriFileRnDao.selectAllZT_SkKubunKeiriFileRn();
    }



    ZT_SkKubunKeiriFileRn getSkKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
            , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {

        return skKubunKeiriFileRnDao.getSkKubunKeiriFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
                , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    Long getDairitenBuntanInfoRnCount() {

        return dairitenBuntanInfoRnDao.getDairitenBuntanInfoRnCount();
    }


    Long getBosyuuninRnCount() {

        return bosyuuninRnDao.getBosyuuninRnCount();

    }


    ExDBResults<ZT_SiharaiTyousyoTy> getAllSiharaiTyousyoTy(){
        return siharaiTyousyoTyDao.selectAllZT_SiharaiTyousyoTy();
    }



    ZT_SiharaiTyousyoTy getSiharaiTyousyoTy(Integer pZtysequenceno) {

        return siharaiTyousyoTyDao.getSiharaiTyousyoTy(pZtysequenceno);
    }


    ExDBResults<ZT_SiharaiTyousyoRn> getAllSiharaiTyousyoRn(){
        return siharaiTyousyoRnDao.selectAllZT_SiharaiTyousyoRn();
    }



    ZT_SiharaiTyousyoRn getSiharaiTyousyoRn(Integer pZrnsequenceno) {

        return siharaiTyousyoRnDao.getSiharaiTyousyoRn(pZrnsequenceno);
    }


    ExDBResults<ZT_EgsyokuinSysRendouTy> getAllEgsyokuinSysRendouTy(){
        return egsyokuinSysRendouTyDao.selectAllZT_EgsyokuinSysRendouTy();
    }



    ZT_EgsyokuinSysRendouTy getEgsyokuinSysRendouTy(Integer pZtysequenceno) {

        return egsyokuinSysRendouTyDao.getEgsyokuinSysRendouTy(pZtysequenceno);
    }


    ExDBResults<ZT_EgsyokuinSysRendouRn> getAllEgsyokuinSysRendouRn(){
        return egsyokuinSysRendouRnDao.selectAllZT_EgsyokuinSysRendouRn();
    }



    ZT_EgsyokuinSysRendouRn getEgsyokuinSysRendouRn(Integer pZrnsequenceno) {

        return egsyokuinSysRendouRnDao.getEgsyokuinSysRendouRn(pZrnsequenceno);
    }


    ExDBResults<ZT_SkIpJissekiTy> getAllSkIpJissekiTy(){
        return skIpJissekiTyDao.selectAllZT_SkIpJissekiTy();
    }



    ZT_SkIpJissekiTy getSkIpJissekiTy(Integer pZtysequenceno) {

        return skIpJissekiTyDao.getSkIpJissekiTy(pZtysequenceno);
    }


    ExDBResults<ZT_SkIpJissekiRn> getAllSkIpJissekiRn(){
        return skIpJissekiRnDao.selectAllZT_SkIpJissekiRn();
    }



    ZT_SkIpJissekiRn getSkIpJissekiRn(Integer pZrnsequenceno) {

        return skIpJissekiRnDao.getSkIpJissekiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_SinkimatuHoyuuFTy> getAllSinkimatuHoyuuFTy(){
        return sinkimatuHoyuuFTyDao.selectAllZT_SinkimatuHoyuuFTy();
    }



    ZT_SinkimatuHoyuuFTy getSinkimatuHoyuuFTy(Integer pZtysequenceno) {

        return sinkimatuHoyuuFTyDao.getSinkimatuHoyuuFTy(pZtysequenceno);
    }


    ExDBResults<ZT_SinkimatuHoyuuFRn> getAllSinkimatuHoyuuFRn(){
        return sinkimatuHoyuuFRnDao.selectAllZT_SinkimatuHoyuuFRn();
    }



    ZT_SinkimatuHoyuuFRn getSinkimatuHoyuuFRn(Integer pZrnsequenceno) {

        return sinkimatuHoyuuFRnDao.getSinkimatuHoyuuFRn(pZrnsequenceno);
    }


    ExDBResults<ZT_HoyuuJyunzouZougenFTy> getAllHoyuuJyunzouZougenFTy(){
        return hoyuuJyunzouZougenFTyDao.selectAllZT_HoyuuJyunzouZougenFTy();
    }



    ZT_HoyuuJyunzouZougenFTy getHoyuuJyunzouZougenFTy(Integer pZtysequenceno) {

        return hoyuuJyunzouZougenFTyDao.getHoyuuJyunzouZougenFTy(pZtysequenceno);
    }


    ExDBResults<ZT_HoyuuJyunzouZougenFRn> getAllHoyuuJyunzouZougenFRn(){
        return hoyuuJyunzouZougenFRnDao.selectAllZT_HoyuuJyunzouZougenFRn();
    }



    ZT_HoyuuJyunzouZougenFRn getHoyuuJyunzouZougenFRn(Integer pZrnsequenceno) {

        return hoyuuJyunzouZougenFRnDao.getHoyuuJyunzouZougenFRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KeizokurituRenrakuULFTy> getAllKeizokurituRenrakuULFTy(){
        return keizokurituRenrakuULFTyDao.selectAllZT_KeizokurituRenrakuULFTy();
    }



    ZT_KeizokurituRenrakuULFTy getKeizokurituRenrakuULFTy(Integer pZtysequenceno) {

        return keizokurituRenrakuULFTyDao.getKeizokurituRenrakuULFTy(pZtysequenceno);
    }


    ExDBResults<ZT_KeizokurituRenrakuULFRn> getAllKeizokurituRenrakuULFRn(){
        return keizokurituRenrakuULFRnDao.selectAllZT_KeizokurituRenrakuULFRn();
    }



    ZT_KeizokurituRenrakuULFRn getKeizokurituRenrakuULFRn(Integer pZrnsequenceno) {

        return keizokurituRenrakuULFRnDao.getKeizokurituRenrakuULFRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TuutirirekiMeisaiFTy> getAllTuutirirekiMeisaiFTy(){
        return tuutirirekiMeisaiFTyDao.selectAllZT_TuutirirekiMeisaiFTy();
    }



    ZT_TuutirirekiMeisaiFTy getTuutirirekiMeisaiFTy(String pZtytuutirirekino, String pZtytuutisakuseiymd, String pZtytuutisakuseino) {

        return tuutirirekiMeisaiFTyDao.getTuutirirekiMeisaiFTy(pZtytuutirirekino, pZtytuutisakuseiymd, pZtytuutisakuseino);
    }


    ExDBResults<ZT_TuutirirekiMeisaiFRn> getAllTuutirirekiMeisaiFRn(){
        return tuutirirekiMeisaiFRnDao.selectAllZT_TuutirirekiMeisaiFRn();
    }



    ZT_TuutirirekiMeisaiFRn getTuutirirekiMeisaiFRn(String pZrntuutirirekino, String pZrntuutisakuseiymd, String pZrntuutisakuseino) {

        return tuutirirekiMeisaiFRnDao.getTuutirirekiMeisaiFRn(pZrntuutirirekino, pZrntuutisakuseiymd, pZrntuutisakuseino);
    }


    ExDBResults<ZT_KokyakuYuyuKykmeisaiFTy> getAllKokyakuYuyuKykmeisaiFTy(){
        return kokyakuYuyuKykmeisaiFTyDao.selectAllZT_KokyakuYuyuKykmeisaiFTy();
    }



    ZT_KokyakuYuyuKykmeisaiFTy getKokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {

        return kokyakuYuyuKykmeisaiFTyDao.getKokyakuYuyuKykmeisaiFTy(pZtysequenceno);
    }


    ExDBResults<ZT_KokyakuYuyuKykmeisaiFRn> getAllKokyakuYuyuKykmeisaiFRn(){
        return kokyakuYuyuKykmeisaiFRnDao.selectAllZT_KokyakuYuyuKykmeisaiFRn();
    }



    ZT_KokyakuYuyuKykmeisaiFRn getKokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {

        return kokyakuYuyuKykmeisaiFRnDao.getKokyakuYuyuKykmeisaiFRn(pZrnsequenceno);
    }



    ExDBResults<ZT_OnlineGknyknmeisaiRn> getAllOnlineGknyknmeisaiRn(){
        return onlineGknyknmeisaiRnDao.selectAllZT_OnlineGknyknmeisaiRn();
    }


    ZT_OnlineGknyknmeisaiRn getOnlineGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd
            , String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnsyorino1) {
        return onlineGknyknmeisaiRnDao.getOnlineGknyknmeisaiRn(pZrnsakuseiymd, pZrnrenrakuymd, pZrnrenrakukaisuu, pZrnbankcd, pZrnshitencd
                , pZrnyokinkbn, pZrnkouzano, pZrnzndktuukasyu, pZrnsyorino1);
    }


    ExDBResults<ZT_OnlineGknyknmeisaiTr> getAllOnlineGknyknmeisaiTr(){
        return onlineGknyknmeisaiTrDao.selectAllZT_OnlineGknyknmeisaiTr();
    }


    ZT_OnlineGknyknmeisaiTr getOnlineGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd
            , String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrsyorino1) {
        return onlineGknyknmeisaiTrDao.getOnlineGknyknmeisaiTr(pZtrsakuseiymd, pZtrrenrakuymd, pZtrrenrakukaisuu, pZtrbankcd, pZtrshitencd
                , pZtryokinkbn, pZtrkouzano, pZtrzndktuukasyu, pZtrsyorino1);
    }


    ExDBResults<ZT_SisuuRendouRn> getAllSisuuRendouRn(){
        return sisuuRendouRnDao.selectAllZT_SisuuRendouRn();
    }


    ZT_SisuuRendouRn getSisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {

        return sisuuRendouRnDao.getSisuuRendouRn(pZrntorikomiyousisuukbn, pZrnsisuukouhyouymd);
    }


    ExDBResults<ZT_DairitenItakuSyouhnRn> getAllDairitenItakuSyouhnRn(){
        return dairitenItakuSyouhnRnDao.selectAllZT_DairitenItakuSyouhnRn();
    }



    Long getDairitenItakuSyouhnRnCount() {

        return dairitenItakuSyouhnRnDao.getDairitenItakuSyouhnRnCount();
    }


    ZT_DairitenItakuSyouhnRn getDairitenItakuSyouhnRn(String pZrndairitencd, String pZrndrtsyouhinsikibetukbnstr, String pZrndrthrkhouhoukbn, String pZrndrtplannmkbn
        , String pZrnitakuhknhnbkaisiymd) {

        return dairitenItakuSyouhnRnDao.getDairitenItakuSyouhnRn(pZrndairitencd, pZrndrtsyouhinsikibetukbnstr, pZrndrthrkhouhoukbn, pZrndrtplannmkbn
            , pZrnitakuhknhnbkaisiymd);
    }
}
