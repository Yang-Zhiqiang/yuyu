package yuyu.def.zdb.manager;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.base.manager.DomManager;
import yuyu.def.db.entity.*;


/**
 * システム間連携 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface ZdbDomManager extends DomManager {


    Long getAcsAdrNmRnCount();


    ExDBResults<ZT_KinyuuKikanInfoRn> getAllKinyuuKikanInfoRn();


    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdNe4Space();


    ZT_KinyuuKikanInfoRn getKinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd);


    Long getKinyuuKikanInfoRnCountByZrnsitencdNe4Space();


    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(String pZrnkinyuukikancdKeta4);


    Long getKinyuuKikanInfoRnCountByZrnsitencdE4Space();


    ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdE4Space();


    ExDBResults<ZT_AcsAdrNmRn> getAllAcsAdrNmRn();


    ZT_AcsAdrNmRn getAcsAdrNmRn(String pZrnkihontikucd);


    ExDBResults<ZT_AcsAdrNmRn> getAcsAdrNmRnsByZrnkihontikucdKeta7(String pZrnkihontikucdKeta7);


    ExDBResults<ZT_DairitenRn> getAllDairitenRn();


    Long getDairitenRnCount();


    ZT_DairitenRn getDairitenRn(String pZrndairitencd);


    ExDBResults<ZT_DairitenSyougouRn> getAllDairitenSyougouRn();


    ZT_DairitenSyougouRn getDairitenSyougouRn(String pZrndairitencd);


    Long getDairitenSyougouRnCount();


    ExDBResults<ZT_TuukabetuKyuusibiRn> getAllTuukabetuKyuusibiRn();


    ZT_TuukabetuKyuusibiRn getTuukabetuKyuusibiRn(String pZrntekiyouymd);


    Long getTuukabetuKyuusibiRnCount();


    ExDBResults<ZT_BosyuuninRn> getAllBosyuuninRn();


    ZT_BosyuuninRn getBosyuuninRn(String pZrnbosyuunincd);


    ExDBResults<ZT_BosyuuninRn> getBosyuuninRnsByZrnbosyuunincdKeta6(String pZrnbosyuunincdKeta6);


    ExDBResults<ZT_DairitenBuntanInfoRn> getAllDairitenBuntanInfoRn();


    ZT_DairitenBuntanInfoRn getDairitenBuntanInfoRn(String pZrndairitencd, String pZrndairitensyouhincd, String pZrntesuuryoubuntandrtencd, String pZrntesuuryoubuntanstartym);


    ExDBResults<ZT_HonyakuYouKouinRn> getAllHonyakuYouKouinRn();


    ZT_HonyakuYouKouinRn getHonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd);


    ExDBResults<ZT_HonyakuYouKouinRn> getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(String pZrnkinyuukikancdKeta4);


    Long getHonyakuYouKouinRnCount();


    ExDBResults<ZT_IdCardKihonRn> getAllIdCardKihonRn();


    ZT_IdCardKihonRn getIdCardKihonRn(String pZrnidkbn, String pZrnidcd);


    Long getIdCardKihonRnCount();


    ExDBResults<ZT_IdCardKihonRn> getIdCardKihonRnsByZrnidcdKeta6(String pZrnidcdKeta6);


    ExDBResults<ZT_IdCardYakusyokuRn> getAllIdCardYakusyokuRn();


    ZT_IdCardYakusyokuRn getIdCardYakusyokuRn(String pZrnidkbn, String pZrnidcd, String pZrnyakusyokuhatureiymd, String pZrnyakusyokuhatureino);


    Long getIdCardYakusyokuRnCount();


    ExDBResults<ZT_SosikiRn> getAllSosikiRn();


    ZT_SosikiRn getSosikiRn(String pZrnsosikicd);


    Long getSosikiRnCount();


    ExDBResults<ZT_KawaserateRn> getAllKawaserateRn();


    ZT_KawaserateRn getKawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn);


    ExDBResults<ZT_KawaserateTr> getAllKawaserateTr();


    ZT_KawaserateTr getKawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn);


    ExDBResults<ZT_NyknmeisaiRn> getAllNyknmeisaiRn();


    ZT_NyknmeisaiRn getNyknmeisaiRn(String pZrnsakuseiymd6keta, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano
        , String pZrnsyoukaino, String pZrnrenno8);


    ExDBResults<ZT_NyknmeisaiTr> getAllNyknmeisaiTr();


    ZT_NyknmeisaiTr getNyknmeisaiTr(String pZtrsakuseiymd6keta, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano
        , String pZtrsyoukaino, String pZtrrenno8);


    ExDBResults<ZT_NyknmeisaiTr> getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(String pKakutyoujobcd, String pZtrsakuseiymd6keta);


    ExDBResults<ZT_GknyknmeisaiRn> getAllGknyknmeisaiRn();


    ZT_GknyknmeisaiRn getGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd
        , String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnksnymd);


    ExDBResults<ZT_GknyknmeisaiTr> getAllGknyknmeisaiTr();


    ExDBResults<ZT_GknyknmeisaiTr> getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(String pKakutyoujobcd, String pZtrsakuseiymd);


    ZT_GknyknmeisaiTr getGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd
        , String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrksnymd);


    ExDBResults<ZT_FurikaeDenpyouTy> getAllFurikaeDenpyouTy();


    ZT_FurikaeDenpyouTy getFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_FurikaeDenpyouHikaeTy> getAllFurikaeDenpyouHikaeTy();


    ZT_FurikaeDenpyouHikaeTy getFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_SkFurikaeDenpyouTy> getAllSkFurikaeDenpyouTy();


    ZT_SkFurikaeDenpyouTy getSkFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_SkFurikaeDenpyouHikaeTy> getAllSkFurikaeDenpyouHikaeTy();


    ZT_SkFurikaeDenpyouHikaeTy getSkFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_FurikaeDenpyouRn> getAllFurikaeDenpyouRn();


    ZT_FurikaeDenpyouRn getFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_FurikaeDenpyouHikaeRn> getAllFurikaeDenpyouHikaeRn();


    ZT_FurikaeDenpyouHikaeRn getFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_SkFurikaeDenpyouRn> getAllSkFurikaeDenpyouRn();


    ZT_SkFurikaeDenpyouRn getSkFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_SkFurikaeDenpyouHikaeRn> getAllSkFurikaeDenpyouHikaeRn();


    ZT_SkFurikaeDenpyouHikaeRn getSkFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_JinsokuShrTtdkInfoTy> getAllJinsokuShrTtdkInfoTy();


    ZT_JinsokuShrTtdkInfoTy getJinsokuShrTtdkInfoTy(String pZtysyorisosikicd, String pZtysyoricd, String pZtyhknknshrsntkno, String pZtysyoruiukeymd, String pZtysyoriymd
        , String pZtydenymd, String pZtysyono);


    ExDBResults<ZT_JinsokuShrTtdkInfoRn> getAllJinsokuShrTtdkInfoRn();


    ZT_JinsokuShrTtdkInfoRn getJinsokuShrTtdkInfoRn(String pZrnsyorisosikicd, String pZrnsyoricd, String pZrnhknknshrsntkno, String pZrnsyoruiukeymd, String pZrnsyoriymd
        , String pZrndenymd, String pZrnsyono);


    ExDBResults<ZT_KaikeiTorihikiFileTy> getAllKaikeiTorihikiFileTy();


    ZT_KaikeiTorihikiFileTy getKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd);


    ExDBResults<ZT_SkKaikeiTorihikiFileTy> getAllSkKaikeiTorihikiFileTy();


    ZT_SkKaikeiTorihikiFileTy getSkKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd);


    ExDBResults<ZT_KaikeiTorihikiFileRn> getAllKaikeiTorihikiFileRn();


    ZT_KaikeiTorihikiFileRn getKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd);


    ExDBResults<ZT_SkKaikeiTorihikiFileRn> getAllSkKaikeiTorihikiFileRn();


    ZT_SkKaikeiTorihikiFileRn getSkKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd);


    ExDBResults<ZT_KubunKeiriFileTy> getAllKubunKeiriFileTy();


    ZT_KubunKeiriFileTy getKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment);


    ExDBResults<ZT_SkKubunKeiriFileTy> getAllSkKubunKeiriFileTy();


    ZT_SkKubunKeiriFileTy getSkKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment);


    ExDBResults<ZT_KubunKeiriFileRn> getAllKubunKeiriFileRn();


    ZT_KubunKeiriFileRn getKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment);


    ExDBResults<ZT_SkKubunKeiriFileRn> getAllSkKubunKeiriFileRn();


    ZT_SkKubunKeiriFileRn getSkKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment);


    Long getDairitenBuntanInfoRnCount();


    Long getBosyuuninRnCount();


    ExDBResults<ZT_SiharaiTyousyoTy> getAllSiharaiTyousyoTy();


    ZT_SiharaiTyousyoTy getSiharaiTyousyoTy(Integer pZtysequenceno);


    ExDBResults<ZT_SiharaiTyousyoRn> getAllSiharaiTyousyoRn();


    ZT_SiharaiTyousyoRn getSiharaiTyousyoRn(Integer pZrnsequenceno);


    ExDBResults<ZT_EgsyokuinSysRendouTy> getAllEgsyokuinSysRendouTy();


    ZT_EgsyokuinSysRendouTy getEgsyokuinSysRendouTy(Integer pZtysequenceno);


    ExDBResults<ZT_EgsyokuinSysRendouRn> getAllEgsyokuinSysRendouRn();


    ZT_EgsyokuinSysRendouRn getEgsyokuinSysRendouRn(Integer pZrnsequenceno);


    ExDBResults<ZT_SkIpJissekiTy> getAllSkIpJissekiTy();


    ZT_SkIpJissekiTy getSkIpJissekiTy(Integer pZtysequenceno);


    ExDBResults<ZT_SkIpJissekiRn> getAllSkIpJissekiRn();


    ZT_SkIpJissekiRn getSkIpJissekiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_SinkimatuHoyuuFTy> getAllSinkimatuHoyuuFTy();


    ZT_SinkimatuHoyuuFTy getSinkimatuHoyuuFTy(Integer pZtysequenceno);


    ExDBResults<ZT_SinkimatuHoyuuFRn> getAllSinkimatuHoyuuFRn();


    ZT_SinkimatuHoyuuFRn getSinkimatuHoyuuFRn(Integer pZrnsequenceno);


    ExDBResults<ZT_HoyuuJyunzouZougenFTy> getAllHoyuuJyunzouZougenFTy();


    ZT_HoyuuJyunzouZougenFTy getHoyuuJyunzouZougenFTy(Integer pZtysequenceno);


    ExDBResults<ZT_HoyuuJyunzouZougenFRn> getAllHoyuuJyunzouZougenFRn();


    ZT_HoyuuJyunzouZougenFRn getHoyuuJyunzouZougenFRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KeizokurituRenrakuULFTy> getAllKeizokurituRenrakuULFTy();


    ZT_KeizokurituRenrakuULFTy getKeizokurituRenrakuULFTy(Integer pZtysequenceno);


    ExDBResults<ZT_KeizokurituRenrakuULFRn> getAllKeizokurituRenrakuULFRn();


    ZT_KeizokurituRenrakuULFRn getKeizokurituRenrakuULFRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TuutirirekiMeisaiFTy> getAllTuutirirekiMeisaiFTy();


    ZT_TuutirirekiMeisaiFTy getTuutirirekiMeisaiFTy(String pZtytuutirirekino, String pZtytuutisakuseiymd, String pZtytuutisakuseino);


    ExDBResults<ZT_TuutirirekiMeisaiFRn> getAllTuutirirekiMeisaiFRn();


    ZT_TuutirirekiMeisaiFRn getTuutirirekiMeisaiFRn(String pZrntuutirirekino, String pZrntuutisakuseiymd, String pZrntuutisakuseino);


    ExDBResults<ZT_KokyakuYuyuKykmeisaiFTy> getAllKokyakuYuyuKykmeisaiFTy();


    ZT_KokyakuYuyuKykmeisaiFTy getKokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno);


    ExDBResults<ZT_KokyakuYuyuKykmeisaiFRn> getAllKokyakuYuyuKykmeisaiFRn();


    ZT_KokyakuYuyuKykmeisaiFRn getKokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno);


    ExDBResults<ZT_OnlineGknyknmeisaiRn> getAllOnlineGknyknmeisaiRn();


    ZT_OnlineGknyknmeisaiRn getOnlineGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd
        , String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZtrsyorino1);


    ExDBResults<ZT_OnlineGknyknmeisaiTr> getAllOnlineGknyknmeisaiTr();


    ZT_OnlineGknyknmeisaiTr getOnlineGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd
        , String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrsyorino1);


    ExDBResults<ZT_SisuuRendouRn> getAllSisuuRendouRn();


    ZT_SisuuRendouRn getSisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd);


    ExDBResults<ZT_DairitenItakuSyouhnRn> getAllDairitenItakuSyouhnRn();


    Long getDairitenItakuSyouhnRnCount();


    ZT_DairitenItakuSyouhnRn getDairitenItakuSyouhnRn(String pZrndairitencd, String pZrndrtsyouhinsikibetukbnstr, String pZrndrthrkhouhoukbn, String pZrndrtplannmkbn
        , String pZrnitakuhknhnbkaisiymd);



    ExDBResults<ZT_SntkInfoTourokuTy> getAllSntkInfoTourokuTy();



    ZT_SntkInfoTourokuTy getSntkInfoTourokuTy(String pZtysntkinfono, String pZtyrenno, String pZtysntkinfotourokusyskbn);


    ExDBResults<ZT_SntkInfoTourokuRn> getAllSntkInfoTourokuRn();


    ZT_SntkInfoTourokuRn getSntkInfoTourokuRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn);


    ExDBResults<ZT_TjtIdouNaiyouTy> getAllTjtIdouNaiyouTy();


    ZT_TjtIdouNaiyouTy getTjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno);


    ExDBResults<ZT_TjtIdouNaiyouRn> getAllTjtIdouNaiyouRn();


    ZT_TjtIdouNaiyouRn getTjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno);


    ExDBResults<ZT_SntkInfoHaneiKekkaTr> getAllSntkInfoHaneiKekkaTr();


    ZT_SntkInfoHaneiKekkaTr getSntkInfoHaneiKekkaTr(String pZtrsntkinfono, Integer pZtrrenno, String pZtrsntkinfotourokusyskbn);


    ExDBResults<ZT_SntkInfoHaneiKekkaRn> getAllSntkInfoHaneiKekkaRn();


    ZT_SntkInfoHaneiKekkaRn getSntkInfoHaneiKekkaRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn);


    ExDBResults<ZT_KykIdouHaneiKekkaTr> getAllKykIdouHaneiKekkaTr();


    ZT_KykIdouHaneiKekkaTr getKykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno);


    ExDBResults<ZT_KykIdouHaneiKekkaRn> getAllKykIdouHaneiKekkaRn();


    ZT_KykIdouHaneiKekkaRn getKykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno);



    ExDBResults<ZT_RatepRn> getAllRatepRn();


    ZT_RatepRn getRatepRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn);


    ExDBResults<ZT_RatevRn> getAllRatevRn();


    ZT_RatevRn getRatevRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn);


    ExDBResults<ZT_RatedRn> getAllRatedRn();


    ZT_RatedRn getRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn);


    ExDBResults<ZT_NennkinRatepkisovRn> getAllNennkinRatepkisovRn();


    ZT_NennkinRatepkisovRn getNennkinRatepkisovRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn);


    ExDBResults<ZT_NennkinRatedRn> getAllNennkinRatedRn();


    ZT_NennkinRatedRn getNennkinRatedRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn, String pZrndnendo, String pZrnnaiteikakuteikbn);


    ExDBResults<ZT_RisaHitSyouhnyouRatedRn> getAllRisaHitSyouhnyouRatedRn();


    ZT_RisaHitSyouhnyouRatedRn getRisaHitSyouhnyouRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn);


    ExDBResults<ZT_Ratep2Rn> getAllRatep2Rn();


    ZT_Ratep2Rn getRatep2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrnryouritukbn);


    ExDBResults<ZT_Ratev2Rn> getAllRatev2Rn();


    ZT_Ratev2Rn getRatev2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn);


    ExDBResults<ZT_RisaHitSyouhnyouRated2Rn> getAllRisaHitSyouhnyouRated2Rn();


    ZT_RisaHitSyouhnyouRated2Rn getRisaHitSyouhnyouRated2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrndnendo
        , String pZrnnaiteikakuteikbn);


    ExDBResults<ZT_RatewRn> getAllRatewRn();


    ZT_RatewRn getRatewRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn);



    ExDBResults<ZT_HoyuuMeisaiTy> getAllHoyuuMeisaiTy();


    ZT_HoyuuMeisaiTy getHoyuuMeisaiTy(Integer pZtysequenceno);


    ExDBResults<ZT_HoyuuMeisaiRn> getAllHoyuuMeisaiRn();


    ZT_HoyuuMeisaiRn getHoyuuMeisaiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_IdouMeisaiTy> getAllIdouMeisaiTy();


    ZT_IdouMeisaiTy getIdouMeisaiTy(Integer pZtysequenceno);


    ExDBResults<ZT_IdouMeisaiRn> getAllIdouMeisaiRn();


    ZT_IdouMeisaiRn getIdouMeisaiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_BikinIdouMeisaiTy> getAllBikinIdouMeisaiTy();


    ZT_BikinIdouMeisaiTy getBikinIdouMeisaiTy(Integer pZtysequenceno);


    ExDBResults<ZT_BikinIdouMeisaiRn> getAllBikinIdouMeisaiRn();


    ZT_BikinIdouMeisaiRn getBikinIdouMeisaiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_Skeiksnbsgetujisr1Ty> getAllSkeiksnbsgetujisr1Ty();


    ZT_Skeiksnbsgetujisr1Ty getSkeiksnbsgetujisr1Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr1Rn> getAllSkeiksnbsgetujisr1Rn();


    ZT_Skeiksnbsgetujisr1Rn getSkeiksnbsgetujisr1Rn(String pZrnktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr2Ty> getAllSkeiksnbsgetujisr2Ty();


    ZT_Skeiksnbsgetujisr2Ty getSkeiksnbsgetujisr2Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr2Rn> getAllSkeiksnbsgetujisr2Rn();


    ZT_Skeiksnbsgetujisr2Rn getSkeiksnbsgetujisr2Rn(String pZrnktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr3Ty> getAllSkeiksnbsgetujisr3Ty();


    ZT_Skeiksnbsgetujisr3Ty getSkeiksnbsgetujisr3Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr3Rn> getAllSkeiksnbsgetujisr3Rn();


    ZT_Skeiksnbsgetujisr3Rn getSkeiksnbsgetujisr3Rn(String pZrnktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr4Ty> getAllSkeiksnbsgetujisr4Ty();


    ZT_Skeiksnbsgetujisr4Ty getSkeiksnbsgetujisr4Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr4Rn> getAllSkeiksnbsgetujisr4Rn();


    ZT_Skeiksnbsgetujisr4Rn getSkeiksnbsgetujisr4Rn(String pZrnktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr5Ty> getAllSkeiksnbsgetujisr5Ty();


    ZT_Skeiksnbsgetujisr5Ty getSkeiksnbsgetujisr5Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr5Rn> getAllSkeiksnbsgetujisr5Rn();


    ZT_Skeiksnbsgetujisr5Rn getSkeiksnbsgetujisr5Rn(String pZrnktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr6Ty> getAllSkeiksnbsgetujisr6Ty();


    ZT_Skeiksnbsgetujisr6Ty getSkeiksnbsgetujisr6Ty(String pZtyktgysyono);


    ExDBResults<ZT_Skeiksnbsgetujisr6Rn> getAllSkeiksnbsgetujisr6Rn();


    ZT_Skeiksnbsgetujisr6Rn getSkeiksnbsgetujisr6Rn(String pZtyktgysyono);


    ExDBResults<ZT_SkeisynyptoukeiksnTy> getAllSkeisynyptoukeiksnTy();


    ZT_SkeisynyptoukeiksnTy getSkeisynyptoukeiksnTy(Integer pZtysequenceno);


    ExDBResults<ZT_SkeisynyptoukeiksnRn> getAllSkeisynyptoukeiksnRn();


    ZT_SkeisynyptoukeiksnRn getSkeisynyptoukeiksnRn(Integer pZrnsequenceno);


    ExDBResults<ZT_SkeisynyptoukeirigTy> getAllSkeisynyptoukeirigTy();


    ZT_SkeisynyptoukeirigTy getSkeisynyptoukeirigTy(Integer pZtysequenceno);


    ExDBResults<ZT_SkeisynyptoukeirigRn> getAllSkeisynyptoukeirigRn();


    ZT_SkeisynyptoukeirigRn getSkeisynyptoukeirigRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KaiykHrSoutougakuTy> getAllKaiykHrSoutougakuTy();


    ZT_KaiykHrSoutougakuTy getKaiykHrSoutougakuTy(Integer pZtysequenceno);


    ExDBResults<ZT_KaiykHrSoutougakuRn> getAllKaiykHrSoutougakuRn();


    ZT_KaiykHrSoutougakuRn getKaiykHrSoutougakuRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusZeroTy> getAllTjHitsyyugkNplusZeroTy();


    ZT_TjHitsyyugkNplusZeroTy getTjHitsyyugkNplusZeroTy(Integer pZtysequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusZeroRn> getAllTjHitsyyugkNplusZeroRn();


    ZT_TjHitsyyugkNplusZeroRn getTjHitsyyugkNplusZeroRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusOneTy> getAllTjHitsyyugkNplusOneTy();


    ZT_TjHitsyyugkNplusOneTy getTjHitsyyugkNplusOneTy(Integer pZtysequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusOneRn> getAllTjHitsyyugkNplusOneRn();


    ZT_TjHitsyyugkNplusOneRn getTjHitsyyugkNplusOneRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusTwoTy> getAllTjHitsyyugkNplusTwoTy();


    ZT_TjHitsyyugkNplusTwoTy getTjHitsyyugkNplusTwoTy(Integer pZtysequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusTwoRn> getAllTjHitsyyugkNplusTwoRn();


    ZT_TjHitsyyugkNplusTwoRn getTjHitsyyugkNplusTwoRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TjHitsyyugkNminusZeroTy> getAllTjHitsyyugkNminusZeroTy();


    ZT_TjHitsyyugkNminusZeroTy getTjHitsyyugkNminusZeroTy(Integer pZtysequenceno);


    ExDBResults<ZT_TjHitsyyugkNminusZeroRn> getAllTjHitsyyugkNminusZeroRn();


    ZT_TjHitsyyugkNminusZeroRn getTjHitsyyugkNminusZeroRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusQuartTy> getAllTjHitsyyugkNplusQuartTy();


    ZT_TjHitsyyugkNplusQuartTy getTjHitsyyugkNplusQuartTy(Integer pZtysequenceno);


    ExDBResults<ZT_TjHitsyyugkNplusQuartRn> getAllTjHitsyyugkNplusQuartRn();


    ZT_TjHitsyyugkNplusQuartRn getTjHitsyyugkNplusQuartRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RisaTjHitNplusZeroTy> getAllRisaTjHitNplusZeroTy();


    ZT_RisaTjHitNplusZeroTy getRisaTjHitNplusZeroTy(Integer pZtysequenceno);


    ExDBResults<ZT_RisaTjHitNplusZeroRn> getAllRisaTjHitNplusZeroRn();


    ZT_RisaTjHitNplusZeroRn getRisaTjHitNplusZeroRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RisaTjHitNminusZeroTy> getAllRisaTjHitNminusZeroTy();


    ZT_RisaTjHitNminusZeroTy getRisaTjHitNminusZeroTy(Integer pZtysequenceno);


    ExDBResults<ZT_RisaTjHitNminusZeroRn> getAllRisaTjHitNminusZeroRn();


    ZT_RisaTjHitNminusZeroRn getRisaTjHitNminusZeroRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RisaTjHitNplusQuartTy> getAllRisaTjHitNplusQuartTy();


    ZT_RisaTjHitNplusQuartTy getRisaTjHitNplusQuartTy(Integer pZtysequenceno);


    ExDBResults<ZT_RisaTjHitNplusQuartRn> getAllRisaTjHitNplusQuartRn();


    ZT_RisaTjHitNplusQuartRn getRisaTjHitNplusQuartRn(Integer pZrnsequenceno);


    ExDBResults<ZT_SbRituRendouTy> getAllSbRituRendouTy();


    ZT_SbRituRendouTy getSbRituRendouTy(String pZtydatakanrino);


    ExDBResults<ZT_SbRituRendouRn> getAllSbRituRendouRn();


    ZT_SbRituRendouRn getSbRituRendouRn(String pZrndatakanrino);


    ExDBResults<ZT_SbRituToukeiSeibiRenTy> getAllSbRituToukeiSeibiRenTy();


    ZT_SbRituToukeiSeibiRenTy getSbRituToukeiSeibiRenTy(Integer pZtysequenceno);


    ExDBResults<ZT_SbRituToukeiSeibiRenRn> getAllSbRituToukeiSeibiRenRn();


    ZT_SbRituToukeiSeibiRenRn getSbRituToukeiSeibiRenRn(Integer pZrnsequenceno);


    ExDBResults<ZT_JigyounndsikiTkHoyuuTy> getAllJigyounndsikiTkHoyuuTy();


    ZT_JigyounndsikiTkHoyuuTy getJigyounndsikiTkHoyuuTy(Integer pZtysequenceno);


    ExDBResults<ZT_JigyounndsikiTkHoyuuRn> getAllJigyounndsikiTkHoyuuRn();


    ZT_JigyounndsikiTkHoyuuRn getJigyounndsikiTkHoyuuRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KyhknShrJyoukyouRnrkTy> getAllKyhknShrJyoukyouRnrkTy();


    ZT_KyhknShrJyoukyouRnrkTy getKyhknShrJyoukyouRnrkTy(Integer pZtysequenceno);


    ExDBResults<ZT_KyhknShrJyoukyouRnrkRn> getAllKyhknShrJyoukyouRnrkRn();


    ZT_KyhknShrJyoukyouRnrkRn getKyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno);


    ExDBResults<ZT_GkknHnkuSyrSynypTukiTy> getAllGkknHnkuSyrSynypTukiTy();


    ZT_GkknHnkuSyrSynypTukiTy getGkknHnkuSyrSynypTukiTy(Integer pZtysequenceno);


    ExDBResults<ZT_GkknHnkuSyrSynypTukiRn> getAllGkknHnkuSyrSynypTukiRn();


    ZT_GkknHnkuSyrSynypTukiRn getGkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_Sp2RnduyuSouseiritu1Ty> getAllSp2RnduyuSouseiritu1Ty();


    ZT_Sp2RnduyuSouseiritu1Ty getSp2RnduyuSouseiritu1Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu1Rn> getAllSp2RnduyuSouseiritu1Rn();


    ZT_Sp2RnduyuSouseiritu1Rn getSp2RnduyuSouseiritu1Rn(String pZrnktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu2Ty> getAllSp2RnduyuSouseiritu2Ty();


    ZT_Sp2RnduyuSouseiritu2Ty getSp2RnduyuSouseiritu2Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu2Rn> getAllSp2RnduyuSouseiritu2Rn();


    ZT_Sp2RnduyuSouseiritu2Rn getSp2RnduyuSouseiritu2Rn(String pZrnktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu3Ty> getAllSp2RnduyuSouseiritu3Ty();


    ZT_Sp2RnduyuSouseiritu3Ty getSp2RnduyuSouseiritu3Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu3Rn> getAllSp2RnduyuSouseiritu3Rn();


    ZT_Sp2RnduyuSouseiritu3Rn getSp2RnduyuSouseiritu3Rn(String pZrnktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu4Ty> getAllSp2RnduyuSouseiritu4Ty();


    ZT_Sp2RnduyuSouseiritu4Ty getSp2RnduyuSouseiritu4Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu4Rn> getAllSp2RnduyuSouseiritu4Rn();


    ZT_Sp2RnduyuSouseiritu4Rn getSp2RnduyuSouseiritu4Rn(String pZrnktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu5Ty> getAllSp2RnduyuSouseiritu5Ty();


    ZT_Sp2RnduyuSouseiritu5Ty getSp2RnduyuSouseiritu5Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu5Rn> getAllSp2RnduyuSouseiritu5Rn();


    ZT_Sp2RnduyuSouseiritu5Rn getSp2RnduyuSouseiritu5Rn(String pZrnktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu6Ty> getAllSp2RnduyuSouseiritu6Ty();


    ZT_Sp2RnduyuSouseiritu6Ty getSp2RnduyuSouseiritu6Ty(String pZtyktgysyono);


    ExDBResults<ZT_Sp2RnduyuSouseiritu6Rn> getAllSp2RnduyuSouseiritu6Rn();


    ZT_Sp2RnduyuSouseiritu6Rn getSp2RnduyuSouseiritu6Rn(String pZrnktgysyono);


    ExDBResults<ZT_AlmNnknHyuTy> getAllAlmNnknHyuTy();


    ZT_AlmNnknHyuTy getAlmNnknHyuTy(String pZtynksyousyono);


    ExDBResults<ZT_AlmNnknHyuRn> getAllAlmNnknHyuRn();


    ZT_AlmNnknHyuRn getAlmNnknHyuRn(String pZrnnksyousyono);


    ExDBResults<ZT_OuNnknShrTy> getAllOuNnknShrTy();


    ZT_OuNnknShrTy getOuNnknShrTy(Integer pZtysequenceno);


    ExDBResults<ZT_OuNnknShrRn> getAllOuNnknShrRn();


    ZT_OuNnknShrRn getOuNnknShrRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkIktHriTy> getAllNkIktHriTy();


    ZT_NkIktHriTy getNkIktHriTy(String pZtydatakanrino);


    ExDBResults<ZT_NkIktHriRn> getAllNkIktHriRn();


    ZT_NkIktHriRn getNkIktHriRn(String pZrndatakanrino);


    ExDBResults<ZT_NkGensiHySgTy> getAllNkGensiHySgTy();


    ZT_NkGensiHySgTy getNkGensiHySgTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkGensiRigTy> getAllNkGensiRigTy();


    ZT_NkGensiRigTy getNkGensiRigTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkGensiKtyTy> getAllNkGensiKtyTy();


    ZT_NkGensiKtyTy getNkGensiKtyTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkGensiHySgRn> getAllNkGensiHySgRn();


    ZT_NkGensiHySgRn getNkGensiHySgRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkGensiRigRn> getAllNkGensiRigRn();


    ZT_NkGensiRigRn getNkGensiRigRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkGensiKtyRn> getAllNkGensiKtyRn();


    ZT_NkGensiKtyRn getNkGensiKtyRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkToukeiHySgTy> getAllNkToukeiHySgTy();


    ZT_NkToukeiHySgTy getNkToukeiHySgTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkToukeiRigTy> getAllNkToukeiRigTy();


    ZT_NkToukeiRigTy getNkToukeiRigTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkToukeiKtyTy> getAllNkToukeiKtyTy();


    ZT_NkToukeiKtyTy getNkToukeiKtyTy(Integer pZtysequenceno);


    ExDBResults<ZT_NkToukeiHySgRn> getAllNkToukeiHySgRn();


    ZT_NkToukeiHySgRn getNkToukeiHySgRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkToukeiRigRn> getAllNkToukeiRigRn();


    ZT_NkToukeiRigRn getNkToukeiRigRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkToukeiKtyRn> getAllNkToukeiKtyRn();


    ZT_NkToukeiKtyRn getNkToukeiKtyRn(Integer pZrnsequenceno);


    ExDBResults<ZT_NkHitRigTy> getAllNkHitRigTy();


    ZT_NkHitRigTy getNkHitRigTy(String pZtynksyousyono);


    ExDBResults<ZT_NkHitKtyTy> getAllNkHitKtyTy();


    ZT_NkHitKtyTy getNkHitKtyTy(String pZtynksyousyono);


    ExDBResults<ZT_NkHitKsnTy> getAllNkHitKsnTy();


    ZT_NkHitKsnTy getNkHitKsnTy(String pZtynksyousyono);


    ExDBResults<ZT_NkHitRigRn> getAllNkHitRigRn();


    ZT_NkHitRigRn getNkHitRigRn(String pZrnnksyousyono);


    ExDBResults<ZT_NkHitKtyRn> getAllNkHitKtyRn();


    ZT_NkHitKtyRn getNkHitKtyRn(String pZrnnksyousyono);


    ExDBResults<ZT_NkHitKsnRn> getAllNkHitKsnRn();


    ZT_NkHitKsnRn getNkHitKsnRn(String pZrnnksyousyono);


    ExDBResults<ZT_NkHitAddInfoTy> getAllNkHitAddInfoTy();


    ZT_NkHitAddInfoTy getNkHitAddInfoTy(String pZtynksyousyono);


    ExDBResults<ZT_NkHitAddInfoRn> getAllNkHitAddInfoRn();


    ZT_NkHitAddInfoRn getNkHitAddInfoRn(String pZrnnksyousyono);


    ExDBResults<ZT_NkBikinTy> getAllNkBikinTy();


    ZT_NkBikinTy getNkBikinTy(String pZtynksyousyono, String pZtyshiharaihasseiymd);


    ExDBResults<ZT_NkBikinRn> getAllNkBikinRn();


    ZT_NkBikinRn getNkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd);


    ExDBResults<ZT_SkKsnKaikeiTorihikiTy> getAllSkKsnKaikeiTorihikiTy();


    ZT_SkKsnKaikeiTorihikiTy getSkKsnKaikeiTorihikiTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd);


    ExDBResults<ZT_SkKsnKaikeiTorihikiRn> getAllSkKsnKaikeiTorihikiRn();


    ZT_SkKsnKaikeiTorihikiRn getSkKsnKaikeiTorihikiRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd);


    ExDBResults<ZT_SkKsnKubunKeiriTy> getAllSkKsnKubunKeiriTy();


    ZT_SkKsnKubunKeiriTy getSkKsnKubunKeiriTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment);


    ExDBResults<ZT_SkKsnKubunKeiriRn> getAllSkKsnKubunKeiriRn();


    ZT_SkKsnKubunKeiriRn getSkKsnKubunKeiriRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment);


    ExDBResults<ZT_SkKsnHurikaeTy> getAllSkKsnHurikaeTy();


    ZT_SkKsnHurikaeTy getSkKsnHurikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_SkKsnHurikaeHikaeTy> getAllSkKsnHurikaeHikaeTy();


    ZT_SkKsnHurikaeHikaeTy getSkKsnHurikaeHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi);


    ExDBResults<ZT_SkKsnHurikaeRn> getAllSkKsnHurikaeRn();


    ZT_SkKsnHurikaeRn getSkKsnHurikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_SkKsnHurikaeHikaeRn> getAllSkKsnHurikaeHikaeRn();


    ZT_SkKsnHurikaeHikaeRn getSkKsnHurikaeHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi);


    ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuTy> getAllSrKbkSsuRnduHknVKnsyuyuTy();


    ZT_SrKbkSsuRnduHknVKnsyuyuTy getSrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno);


    ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuRn> getAllSrKbkSsuRnduHknVKnsyuyuRn();


    ZT_SrKbkSsuRnduHknVKnsyuyuRn getSrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiTy> getAllKsnKbkSsuRnduHknJigyohiTy();


    ZT_KsnKbkSsuRnduHknJigyohiTy getKsnKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiRn> getAllKsnKbkSsuRnduHknJigyohiRn();


    ZT_KsnKbkSsuRnduHknJigyohiRn getKsnKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KbkSsuRnduHknKimatuVTy> getAllKbkSsuRnduHknKimatuVTy();


    ZT_KbkSsuRnduHknKimatuVTy getKbkSsuRnduHknKimatuVTy(Integer pZtysequenceno);


    ExDBResults<ZT_KbkSsuRnduHknKimatuVRn> getAllKbkSsuRnduHknKimatuVRn();


    ZT_KbkSsuRnduHknKimatuVRn getKbkSsuRnduHknKimatuVRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KbkSsuRnduHknJigyohiTy> getAllKbkSsuRnduHknJigyohiTy();


    ZT_KbkSsuRnduHknJigyohiTy getKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_KbkSsuRnduHknJigyohiRn> getAllKbkSsuRnduHknJigyohiRn();


    ZT_KbkSsuRnduHknJigyohiRn getKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KbkSsuRnduHknIdouVTy> getAllKbkSsuRnduHknIdouVTy();


    ZT_KbkSsuRnduHknIdouVTy getKbkSsuRnduHknIdouVTy(Integer pZtysequenceno);


    ExDBResults<ZT_KbkSsuRnduHknIdouVRn> getAllKbkSsuRnduHknIdouVRn();


    ZT_KbkSsuRnduHknIdouVRn getKbkSsuRnduHknIdouVRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RrtHndugtHknJigyohiRn> getAllRrtHndugtHknJigyohiRn();


    ZT_RrtHndugtHknJigyohiRn getRrtHndugtHknJigyohiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RrtHndugtHknJigyohiTy> getAllRrtHndugtHknJigyohiTy();


    ZT_RrtHndugtHknJigyohiTy getRrtHndugtHknJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_RrtHndugtHknKsnJigyohiRn> getAllRrtHndugtHknKsnJigyohiRn();


    ZT_RrtHndugtHknKsnJigyohiRn getRrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RrtHndugtHknKsnJigyohiTy> getAllRrtHndugtHknKsnJigyohiTy();


    ZT_RrtHndugtHknKsnJigyohiTy getRrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_RrtHndugtHknVKnsyuyuRn> getAllRrtHndugtHknVKnsyuyuRn();


    ZT_RrtHndugtHknVKnsyuyuRn getRrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RrtHndugtHknVKnsyuyuTy> getAllRrtHndugtHknVKnsyuyuTy();


    ZT_RrtHndugtHknVKnsyuyuTy getRrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno);


    ExDBResults<ZT_ZitkAzukarikinSrRendouRn> getAllZitkAzukarikinSrRendouRn();


    ZT_ZitkAzukarikinSrRendouRn getZitkAzukarikinSrRendouRn(Integer pZrnsequenceno);


    ExDBResults<ZT_ZitkAzukarikinSrRendouTy> getAllZitkAzukarikinSrRendouTy();


    ZT_ZitkAzukarikinSrRendouTy getZitkAzukarikinSrRendouTy(Integer pZtysequenceno);


    ExDBResults<ZT_TmttHaitoukinMeisaiRn> getAllTmttHaitoukinMeisaiRn();


    ZT_TmttHaitoukinMeisaiRn getTmttHaitoukinMeisaiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_TmttHaitoukinMeisaiTy> getAllTmttHaitoukinMeisaiTy();


    ZT_TmttHaitoukinMeisaiTy getTmttHaitoukinMeisaiTy(Integer pZtysequenceno);


    ExDBResults<ZT_KariwariateHtkinMeisaiRn> getAllKariwariateHtkinMeisaiRn();


    ZT_KariwariateHtkinMeisaiRn getKariwariateHtkinMeisaiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KariwariateHtkinMeisaiTy> getAllKariwariateHtkinMeisaiTy();


    ZT_KariwariateHtkinMeisaiTy getKariwariateHtkinMeisaiTy(Integer pZtysequenceno);


    ExDBResults<ZT_BikinKeiyakuSeisandRn> getAllBikinKeiyakuSeisandRn();


    ZT_BikinKeiyakuSeisandRn getBikinKeiyakuSeisandRn(Integer pZrnsequenceno);


    ExDBResults<ZT_BikinKeiyakuSeisandTy> getAllBikinKeiyakuSeisandTy();


    ZT_BikinKeiyakuSeisandTy getBikinKeiyakuSeisandTy(Integer pZtysequenceno);


    ExDBResults<ZT_DshrToukeiRn> getAllDshrToukeiRn();


    ZT_DshrToukeiRn getDshrToukeiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_DshrToukeiTy> getAllDshrToukeiTy();


    ZT_DshrToukeiTy getDshrToukeiTy(Integer pZtysequenceno);


    ExDBResults<ZT_DshrToukeiLoadingRn> getAllDshrToukeiLoadingRn();


    ZT_DshrToukeiLoadingRn getDshrToukeiLoadingRn(Integer pZrnsequenceno);


    ExDBResults<ZT_DshrToukeiLoadingTy> getAllDshrToukeiLoadingTy();


    ZT_DshrToukeiLoadingTy getDshrToukeiLoadingTy(Integer pZtysequenceno);


    ExDBResults<ZT_RayVKnsyuyuTy> getAllRayVKnsyuyuTy();


    ZT_RayVKnsyuyuTy getRayVKnsyuyuTy(Integer pZtysequenceno);


    ExDBResults<ZT_RayVKnsyuyuRn> getAllRayVKnsyuyuRn();


    ZT_RayVKnsyuyuRn getRayVKnsyuyuRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RayKimatuVTy> getAllRayKimatuVTy();


    ZT_RayKimatuVTy getRayKimatuVTy(Integer pZtysequenceno);


    ExDBResults<ZT_RayKimatuVRn> getAllRayKimatuVRn();


    ZT_RayKimatuVRn getRayKimatuVRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RayIdouVTy> getAllRayIdouVTy();


    ZT_RayIdouVTy getRayIdouVTy(Integer pZtysequenceno);


    ExDBResults<ZT_RayIdouVRn> getAllRayIdouVRn();


    ZT_RayIdouVRn getRayIdouVRn(Integer pZrnsequenceno);


    ExDBResults<ZT_RayJigyohiTy> getAllRayJigyohiTy();


    ZT_RayJigyohiTy getRayJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_RayJigyohiRn> getAllRayJigyohiRn();


    ZT_RayJigyohiRn getRayJigyohiRn(Integer pZrnsequenceno);


    ExDBResults<ZT_KsnRayJigyohiTy> getAllKsnRayJigyohiTy();


    ZT_KsnRayJigyohiTy getKsnRayJigyohiTy(Integer pZtysequenceno);


    ExDBResults<ZT_KsnRayJigyohiRn> getAllKsnRayJigyohiRn();


    ZT_KsnRayJigyohiRn getKsnRayJigyohiRn(Integer pZrnsequenceno);



    ExDBResults<ZT_TokuteiKankeiHoujinRn> getAllTokuteiKankeiHoujinRn();


    ZT_TokuteiKankeiHoujinRn getTokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou);


    ExDBResults<ZT_SmbcBosRn> getAllSmbcBosRn();


    ZT_SmbcBosRn getSmbcBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno);


    ExDBResults<ZT_SmbcBosTr> getAllSmbcBosTr();


    ZT_SmbcBosTr getSmbcBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno);


    ExDBResults<ZT_SmbcBosTr> getSmbcBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo);


    ExDBResults<ZT_TiginSinkinBosRn> getAllTiginSinkinBosRn();


    ZT_TiginSinkinBosRn getTiginSinkinBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno);


    ExDBResults<ZT_TiginSinkinBosTr> getAllTiginSinkinBosTr();


    ZT_TiginSinkinBosTr getTiginSinkinBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno);


    ExDBResults<ZT_TiginSinkinBosTr> getTiginSinkinBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo);


    ExDBResults<ZT_SmbcPaperlessMos1Tr> getAllSmbcPaperlessMos1Tr();


    ZT_SmbcPaperlessMos1Tr getSmbcPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc);


    ExDBResults<ZT_SmbcPaperlessMos1Tr> getSmbcPaperlessMos1TrsByKakutyoujobcd(String pKakutyoujobcd);


    ExDBResults<ZT_SmbcPaperlessMos2Tr> getAllSmbcPaperlessMos2Tr();


    ZT_SmbcPaperlessMos2Tr getSmbcPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc);


    ExDBResults<ZT_SmbcPaperlessMos2Tr> getSmbcPaperlessMos2TrsByKakutyoujobcd(String pKakutyoujobcd);


    Long getTokuteiKankeiHoujinRnCount();


    ExDBResults<ZT_IjiToukeiIdouInfoTr> getIjiToukeiIdouInfoTrsByKakutyoujobcd(String pKakutyoujobcd);


    ExDBResults<ZT_HanyouPaperlessMos1Tr> getAllHanyouPaperlessMos1Tr();


    ZT_HanyouPaperlessMos1Tr getHanyouPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc);


    ExDBResults<ZT_HanyouPaperlessMos2Tr> getAllHanyouPaperlessMos2Tr();


    ZT_HanyouPaperlessMos2Tr getHanyouPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc);


    ExDBResults<ZT_SkCreditTourokukekkaQrRn> getAllSkCreditTourokukekkaQrRn();


    ZT_SkCreditTourokukekkaQrRn getSkCreditTourokukekkaQrRn(String pZrnsystemjyusinymd, String pZrnsystemjyusintime, String pZrncreditkessaiyouno);


    ExDBResults<ZT_SkCreditTourokukekkaQrTr> getAllSkCreditTourokukekkaQrTr();


    ZT_SkCreditTourokukekkaQrTr getSkCreditTourokukekkaQrTr(String pZtrsystemjyusinymd, String pZtrsystemjyusintime, String pZtrcreditkessaiyouno);


    ExDBResults<ZT_FstpUriageSeikyuuKekkaRn> getAllFstpUriageSeikyuuKekkaRn();


    ZT_FstpUriageSeikyuuKekkaRn getFstpUriageSeikyuuKekkaRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk);


    ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> getAllFstpUriageSeikyuuKekkaTr();


    ZT_FstpUriageSeikyuuKekkaTr getFstpUriageSeikyuuKekkaTr(String pZtruriageymd6keta, String pZtrcreditkessaiyouno, String pZtrsyono, String pZtrrecordno, Long pZtrseikyuukngk);


    ExDBResults<ZT_SkKouhuriUkTrkkekkaRn> getAllSkKouhuriUkTrkkekkaRn();


    ZT_SkKouhuriUkTrkkekkaRn getSkKouhuriUkTrkkekkaRn(String pZrnsyukkncd, String pZrnkinyuukikancd8keta, String pZrnkinyuukkntratkiymd, String pZrnkinyuukkntratkitime
        , String pZrnkouhuriokyakusamano);


    ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> getAllSkKouhuriUkTrkkekkaTr();


    ZT_SkKouhuriUkTrkkekkaTr getSkKouhuriUkTrkkekkaTr(String pZtrsyukkncd, String pZtrkinyuukikancd8keta, String pZtrkinyuukkntratkiymd, String pZtrkinyuukkntratkitime
        , String pZtrkouhuriokyakusamano);



    ExDBResults<ZT_IjiToukeiIdouInfoRn> getAllIjiToukeiIdouInfoRn();


    ZT_IjiToukeiIdouInfoRn getIjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr);


    ExDBResults<ZT_IjiToukeiIdouInfoTr> getAllIjiToukeiIdouInfoTr();


    ZT_IjiToukeiIdouInfoTr getIjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr);



    ExDBResults<ZT_DrtenIpToukeiTy> getAllDrtenIpToukeiTy();


    ZT_DrtenIpToukeiTy getDrtenIpToukeiTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosym, String pZtymosno);


    ExDBResults<ZT_DrtenIpToukeiRn> getAllDrtenIpToukeiRn();


    ZT_DrtenIpToukeiRn getDrtenIpToukeiRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosym, String pZrnmosno);


    ExDBResults<ZT_SkSeirituRituTy> getAllSkSeirituRituTy();


    ZT_SkSeirituRituTy getSkSeirituRituTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosno);


    ExDBResults<ZT_SkSeirituRituRn> getAllSkSeirituRituRn();


    ZT_SkSeirituRituRn getSkSeirituRituRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosno);


    ExDBResults<ZT_MosJkItiranSyoukaiTy> getAllMosJkItiranSyoukaiTy();


    ZT_MosJkItiranSyoukaiTy getMosJkItiranSyoukaiTy(String pZtymosym, String pZtymosno, String pZtybsydrtencd, String pZtyatukaikojincd);


    ExDBResults<ZT_MosJkItiranSyoukaiRn> getAllMosJkItiranSyoukaiRn();


    ZT_MosJkItiranSyoukaiRn getMosJkItiranSyoukaiRn(String pZrnmosym, String pZrnmosno, String pZrnbsydrtencd, String pZrnatukaikojincd);


    ExDBResults<ZT_SeirituInfoTy> getAllSeirituInfoTy();


    ZT_SeirituInfoTy getSeirituInfoTy(String pZtykijyunym, String pZtymosno);


    ExDBResults<ZT_SeirituInfoRn> getAllSeirituInfoRn();


    ZT_SeirituInfoRn getSeirituInfoRn(String pZrnkijyunym, String pZrnmosno);


    ExDBResults<ZT_HonsyaToukeiTy> getAllHonsyaToukeiTy();


    ZT_HonsyaToukeiTy getHonsyaToukeiTy(String pZtykijyunym, String pZtymosno);


    ExDBResults<ZT_HonsyaToukeiRn> getAllHonsyaToukeiRn();


    ZT_HonsyaToukeiRn getHonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno);


    ExDBResults<ZT_FstpUriageSeikyuuDataTy> getAllFstpUriageSeikyuuDataTy();


    ZT_FstpUriageSeikyuuDataTy getFstpUriageSeikyuuDataTy(String pZtyuriageymd6keta, String pZtycreditkessaiyouno, String pZtysyono, String pZtyrecordno, Long pZtyseikyuukngk11keta);


    ExDBResults<ZT_FstpUriageSeikyuuDataRn> getAllFstpUriageSeikyuuDataRn();


    ZT_FstpUriageSeikyuuDataRn getFstpUriageSeikyuuDataRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk11keta);



    ExDBResults<ZT_IsaToukeiDataTy> getAllIsaToukeiDataTy();


    ZT_IsaToukeiDataTy getIsaToukeiDataTy(String pZtymosno);


    ExDBResults<ZT_IsaToukeiDataRn> getAllIsaToukeiDataRn();


    ZT_IsaToukeiDataRn getIsaToukeiDataRn(String pZrnmosno);


    ExDBResults<ZT_SyuSibouToukeiTy> getAllSyuSibouToukeiTy();


    ZT_SyuSibouToukeiTy getSyuSibouToukeiTy(String pZtysyono);


    ExDBResults<ZT_SyuSibouToukeiRn> getAllSyuSibouToukeiRn();


    ZT_SyuSibouToukeiRn getSyuSibouToukeiRn(String pZrnsyono);


    ExDBResults<ZT_SyuHukugouSikkanDataTy> getAllSyuHukugouSikkanDataTy();


    ZT_SyuHukugouSikkanDataTy getSyuHukugouSikkanDataTy(String pZtyijitoukeidaihyousyurui, String pZtykeiyakunendo, String pZtyhknnendo, String pZtyhhknseikbn
        , String pZtykykage, String pZtytoutatunenrei, String pZtyatukaibetu, String pZtysinsahouhou, String pZtyketteikekkakbn
        , String pZtysibousrank, String pZtyjissituhosyousrank, String pZtysirajikykkbn, String pZtyhrkhuhukbn
        , String pZtyhknsyurui2keta, String pZtydaisiincd, String pZtytyuusiincd, String pZtysyousiincd, String pZtynenreihousikikbn
        , String pZtysykgycd, String pZtytodouhukencd, String pZtybotaisisyaeigyouhonbu, String pZtysisyaeigyoubu
        , String pZtyaatukaisosikicd, String pZtynensyuukbn, String pZtyhanbaikeirokbn, String pZtyoyadairitencd
        , String pZtytratkidrtencd, String pZtybsudirtnatkikeitaikbn, String pZtykyktuuka, String pZtyhrktuuka
        , String pZtyhknsyukigou, String pZtysyksbyensitihsyutyhkumu, String pZtyjyudkaigomehrtkhkumu, String pZtyijitoukeizennoukbn
        , String pZtydai1hknkkn, String pZtyijitoukeitikshrtkykkbn);


    ExDBResults<ZT_SyuHukugouSikkanDataRn> getAllSyuHukugouSikkanDataRn();


    ZT_SyuHukugouSikkanDataRn getSyuHukugouSikkanDataRn(String pZrnijitoukeidaihyousyurui, String pZrnkeiyakunendo, String pZrnhknnendo, String pZrnhhknseikbn
        , String pZrnkykage, String pZrntoutatunenrei, String pZrnatukaibetu, String pZrnsinsahouhou, String pZrnketteikekkakbn
        , String pZrnsibousrank, String pZrnjissituhosyousrank, String pZrnsirajikykkbn, String pZrnhrkhuhukbn
        , String pZrnhknsyurui2keta, String pZrndaisiincd, String pZrntyuusiincd, String pZrnsyousiincd, String pZrnnenreihousikikbn
        , String pZrnsykgycd, String pZrntodouhukencd, String pZrnbotaisisyaeigyouhonbu, String pZrnsisyaeigyoubu
        , String pZrnaatukaisosikicd, String pZrnnensyuukbn, String pZrnhanbaikeirokbn, String pZrnoyadairitencd
        , String pZrntratkidrtencd, String pZrnbsudirtnatkikeitaikbn, String pZrnkyktuuka, String pZrnhrktuuka
        , String pZrnhknsyukigou, String pZrnsyksbyensitihsyutyhkumu, String pZrnjyudkaigomehrtkhkumu, String pZrnijitoukeizennoukbn
        , String pZrndai1hknkkn, String pZrnijitoukeitikshrtkykkbn);



    ExDBResults<ZT_SmbcSkMeisaiRendouTy> getAllSmbcSkMeisaiRendouTy();


    ZT_SmbcSkMeisaiRendouTy getSmbcSkMeisaiRendouTy(String pZtysmbcdatakbn, String pZtysmbcdatasakuseiymd, String pZtysmbchknkaisyacd, String pZtysmbcuktkkanriid);


    ExDBResults<ZT_SmbcSkMeisaiRendouRn> getAllSmbcSkMeisaiRendouRn();


    ZT_SmbcSkMeisaiRendouRn getSmbcSkMeisaiRendouRn(String pZrnsmbcdatakbn, String pZrnsmbcdatasakuseiymd, String pZrnsmbchknkaisyacd, String pZrnsmbcuktkkanriid);



    ExDBResults<ZT_OnlineLincSousinTy> getAllOnlineLincSousinTy();


    ZT_OnlineLincSousinTy getOnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino);


    ExDBResults<ZT_OnlineLincSousinRn> getAllOnlineLincSousinRn();


    ZT_OnlineLincSousinRn getOnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino);


    ExDBResults<ZT_YakansyoriLincSousinTy> getAllYakansyoriLincSousinTy();


    ZT_YakansyoriLincSousinTy getYakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino);


    ExDBResults<ZT_YakansyoriLincSousinRn> getAllYakansyoriLincSousinRn();


    ZT_YakansyoriLincSousinRn getYakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino);



    ExDBResults<ZT_LincJyusinRn> getAllLincJyusinRn();


    ZT_LincJyusinRn getLincJyusinRn(String pZrnsyoriymd, String pZrnrenno10);


    ExDBResults<ZT_LincJyusinTr> getAllLincJyusinTr();


    ZT_LincJyusinTr getLincJyusinTr(String pZtrsyoriymd, String pZtrrenno10);



    ExDBResults<ZT_SyainMeiboTy> getAllSyainMeiboTy();


    ZT_SyainMeiboTy getSyainMeiboTy(String pZtysyono);


    ExDBResults<ZT_SyoukenTkListShTy> getAllSyoukenTkListShTy();


    ZT_SyoukenTkListShTy getSyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_SyoukenTkListShRn> getAllSyoukenTkListShRn();


    ZT_SyoukenTkListShRn getSyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_SyoukenTkListSkTy> getAllSyoukenTkListSkTy();


    ZT_SyoukenTkListSkTy getSyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_SyoukenTkListSkRn> getAllSyoukenTkListSkRn();


    ZT_SyoukenTkListSkRn getSyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_HnsyScrMeigiTy> getAllHnsyScrMeigiTy();


    ZT_HnsyScrMeigiTy getHnsyScrMeigiTy(String pZtytaisyounmkn, String pZtytaisyounmkj, String pZtytaisyouseiymd, String pZtynayosetaisyousegkbn
        , String pZtysyono);


    ExDBResults<ZT_HnsyScrMeigiRn> getAllHnsyScrMeigiRn();


    ZT_HnsyScrMeigiRn getHnsyScrMeigiRn(String pZrntaisyounmkn, String pZrntaisyounmkj, String pZrntaisyouseiymd, String pZrnnayosetaisyousegkbn
        , String pZrnsyono);


    ExDBResults<ZT_KoujyoSyoumeiTy> getAllKoujyoSyoumeiTy();


    ZT_KoujyoSyoumeiTy getKoujyoSyoumeiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysakunm15keta);


    ExDBResults<ZT_KoujyoSyoumeiRn> getAllKoujyoSyoumeiRn();


    ZT_KoujyoSyoumeiRn getKoujyoSyoumeiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsakunm15keta);


    ExDBResults<ZT_TtdkKanTy> getAllTtdkKanTy();


    ZT_TtdkKanTy getTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_TtdkKanRn> getAllTtdkKanRn();


    ZT_TtdkKanRn getTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_TtdkKanKiykTy> getAllTtdkKanKiykTy();


    ZT_TtdkKanKiykTy getTtdkKanKiykTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_TtdkKanKiykRn> getAllTtdkKanKiykRn();


    ZT_TtdkKanKiykRn getTtdkKanKiykRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_TtdkKanAdHenkouTy> getAllTtdkKanAdHenkouTy();


    ZT_TtdkKanAdHenkouTy getTtdkKanAdHenkouTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_TtdkKanAdHenkouRn> getAllTtdkKanAdHenkouRn();


    ZT_TtdkKanAdHenkouRn getTtdkKanAdHenkouRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_DrtenKykIdouDetailTy> getAllDrtenKykIdouDetailTy();


    ZT_DrtenKykIdouDetailTy getDrtenKykIdouDetailTy(String pZtybsydrtencd, String pZtybosyuunincd, String pZtysyono, String pZtyidouhasseiymd, String pZtyidoukbn);


    ExDBResults<ZT_DrtenKykIdouDetailRn> getAllDrtenKykIdouDetailRn();


    ZT_DrtenKykIdouDetailRn getDrtenKykIdouDetailRn(String pZrnbsydrtencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnidouhasseiymd, String pZrnidoukbn);


    ExDBResults<ZT_BosyuuDrtenHoyuuKykTy> getAllBosyuuDrtenHoyuuKykTy();


    ZT_BosyuuDrtenHoyuuKykTy getBosyuuDrtenHoyuuKykTy(String pZtysyonosyuban);


    ExDBResults<ZT_BosyuuDrtenHoyuuKykRn> getAllBosyuuDrtenHoyuuKykRn();


    ZT_BosyuuDrtenHoyuuKykRn getBosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban);


    ExDBResults<ZT_KydGWKykInfoTy> getAllKydGWKykInfoTy();


    ZT_KydGWKykInfoTy getKydGWKykInfoTy(String pZtysyono, String pZtysyoriymd, Long pZtykykmfksnctrlkh);


    ExDBResults<ZT_SinkeiyakuHokensyoukenTy> getAllSinkeiyakuHokensyoukenTy();


    ZT_SinkeiyakuHokensyoukenTy getSinkeiyakuHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_SaihakkouHokensyoukenTy> getAllSaihakkouHokensyoukenTy();


    ZT_SaihakkouHokensyoukenTy getSaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_SyainMeiboRn> getAllSyainMeiboRn();


    ZT_SyainMeiboRn getSyainMeiboRn(String pZrnsyono);


    ExDBResults<ZT_DrtenTsryInfoTy> getAllDrtenTsryInfoTy();


    ZT_DrtenTsryInfoTy getDrtenTsryInfoTy(String pZtydairitencd, String pZtybosyuunincd, String pZtysyono, String pZtykikaisyoriymd, Long pZtykykmfksnctrlkh, String pZtysikibetujyunjyo);


    ExDBResults<ZT_SeihoWebIdouListTy> getAllSeihoWebIdouListTy();


    ZT_SeihoWebIdouListTy getSeihoWebIdouListTy(String pZtysakuseiymd7keta, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono, String pZtyhasseiymd
        , String pZtyidoukbn1, String pZtykydatkikbnkj, String pZtykykyymm, String pZtycifcd);


    ExDBResults<ZT_HknkykIdouInfoTy> getAllHknkykIdouInfoTy();


    ZT_HknkykIdouInfoTy getHknkykIdouInfoTy(String pZtykyktuukasyu, String pZtyidouymd, String pZtyidoujiyuukbnzfi, String pZtydatakanrino, String pZtyrenno, String pZtytumitatekinkbn);


    ExDBResults<ZT_KydGWKykInfoRn> getAllKydGWKykInfoRn();


    ZT_KydGWKykInfoRn getKydGWKykInfoRn(String pZrnsyono, String pZrnsyoriymd, Long pZrnkykmfksnctrlkh);


    ExDBResults<ZT_SinkeiyakuHokensyoukenRn> getAllSinkeiyakuHokensyoukenRn();


    ZT_SinkeiyakuHokensyoukenRn getSinkeiyakuHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_SaihakkouHokensyoukenRn> getAllSaihakkouHokensyoukenRn();


    ZT_SaihakkouHokensyoukenRn getSaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_GaikaKokyakuTuutiTy> getAllGaikaKokyakuTuutiTy();


    ZT_GaikaKokyakuTuutiTy getGaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_GaikaKokyakuTuutiRn> getAllGaikaKokyakuTuutiRn();


    ZT_GaikaKokyakuTuutiRn getGaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_DrtenTsryInfoRn> getAllDrtenTsryInfoRn();


    ZT_DrtenTsryInfoRn getDrtenTsryInfoRn(String pZrndairitencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnkikaisyoriymd, Long pZrnkykmfksnctrlkh, String pZrnsikibetujyunjyo);


    ExDBResults<ZT_SeihoWebIdouListRn> getAllSeihoWebIdouListRn();


    ZT_SeihoWebIdouListRn getSeihoWebIdouListRn(Long pZrnsakuseiymd7keta, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono, String pZrnhasseiymd
        , String pZrnidoukbn1, String pZrnkydatkikbnkj, String pZrnkykyymm, String pZrncifcd);


    ExDBResults<ZT_HknkykIdouInfoRn> getAllHknkykIdouInfoRn();


    ZT_HknkykIdouInfoRn getHknkykIdouInfoRn(String pZrnkyktuukasyu, String pZrnidouymd, String pZrnidoujiyuukbnzfi, String pZrndatakanrino, String pZrnrenno, String pZtytumitatekinkbn);


    ExDBResults<ZT_SinkeiyakuSyoukenSuiiTy> getAllSinkeiyakuSyoukenSuiiTy();


    ZT_SinkeiyakuSyoukenSuiiTy getSinkeiyakuSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn);


    ExDBResults<ZT_SinkeiyakuSyoukenSuiiRn> getAllSinkeiyakuSyoukenSuiiRn();


    ZT_SinkeiyakuSyoukenSuiiRn getSinkeiyakuSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn);


    ExDBResults<ZT_SaihakkouSyoukenSuiiTy> getAllSaihakkouSyoukenSuiiTy();


    ZT_SaihakkouSyoukenSuiiTy getSaihakkouSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn);


    ExDBResults<ZT_SaihakkouSyoukenSuiiRn> getAllSaihakkouSyoukenSuiiRn();


    ZT_SaihakkouSyoukenSuiiRn getSaihakkouSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn);


    ExDBResults<ZT_SmbcGetujiKykMeisaiTy> getAllSmbcGetujiKykMeisaiTy();


    ZT_SmbcGetujiKykMeisaiTy getSmbcGetujiKykMeisaiTy(String pZtydatakijyunymd, String pZtydatakijyunym, String pZtysyono);


    ExDBResults<ZT_SmbcGetujiKykMeisaiRn> getAllSmbcGetujiKykMeisaiRn();


    ZT_SmbcGetujiKykMeisaiRn getSmbcGetujiKykMeisaiRn(String pZrndatakijyunymd, String pZrndatakijyunym, String pZrnsyono);


    ExDBResults<ZT_TumitateYosokuTy> getAllTumitateYosokuTy();


    ZT_TumitateYosokuTy getTumitateYosokuTy(String pZtyhknsyukigou, String pZtykeiyakuymd, String pZtytysytymd, String pZtykyktuukasyu, String pZtyhknkkn
        , String pZtytmttknsyuruikbn, String pZtysisuukbn);


    ExDBResults<ZT_TumitateYosokuRn> getAllTumitateYosokuRn();


    ZT_TumitateYosokuRn getTumitateYosokuRn(String pZrnhknsyukigou, String pZrnkeiyakuymd, String pZrntysytymd, String pZrnkyktuukasyu, String pZrnhknkkn
        , String pZrntmttknsyuruikbn, String pZrnsisuukbn);


    ZT_SinninTouhyouTy getSinninTouhyouTy(String pZtysyono);


    ExDBResults<ZT_SinninTouhyouTy> getAllSinninTouhyouTy();


    ZT_SinninTouhyouRn getSinninTouhyouRn(String pZrnsyono);


    ExDBResults<ZT_SinninTouhyouRn> getAllSinninTouhyouRn();


    ExDBResults<ZT_DattaiTuutiKzhuriRn> getAllDattaiTuutiKzhuriRn();


    ZT_DattaiTuutiKzhuriRn getDattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_DattaiTuutiKzhuriTy> getAllDattaiTuutiKzhuriTy();


    ZT_DattaiTuutiKzhuriTy getDattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_GinkouMdhnMisyuuInfoFRn> getAllGinkouMdhnMisyuuInfoFRn();


    ZT_GinkouMdhnMisyuuInfoFRn getGinkouMdhnMisyuuInfoFRn(String pZrnbsydrtencd, String pZrndatasakuseiymd, String pZrnsyonosyuban);


    ExDBResults<ZT_GinkouMdhnMisyuuInfoFTy> getAllGinkouMdhnMisyuuInfoFTy();


    ZT_GinkouMdhnMisyuuInfoFTy getGinkouMdhnMisyuuInfoFTy(String pZtybsydrtencd, String pZtydatasakuseiymd, String pZtysyonosyuban);


    ExDBResults<ZT_HrhnTtdkKanRn> getAllHrhnTtdkKanRn();


    ZT_HrhnTtdkKanRn getHrhnTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_HrhnTtdkKanTy> getAllHrhnTtdkKanTy();


    ZT_HrhnTtdkKanTy getHrhnTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_KesikomiSousinHurikaeRn> getAllKesikomiSousinHurikaeRn();


    ZT_KesikomiSousinHurikaeRn getKesikomiSousinHurikaeRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd);


    ExDBResults<ZT_KesikomiSousinHurikaeTy> getAllKesikomiSousinHurikaeTy();


    ZT_KesikomiSousinHurikaeTy getKesikomiSousinHurikaeTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd);


    ExDBResults<ZT_KesikomiSousinKouhuriRn> getAllKesikomiSousinKouhuriRn();


    ZT_KesikomiSousinKouhuriRn getKesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd);


    ExDBResults<ZT_KesikomiSousinKouhuriTy> getAllKesikomiSousinKouhuriTy();


    ZT_KesikomiSousinKouhuriTy getKesikomiSousinKouhuriTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd);


    ExDBResults<ZT_KessanYokukiPRn> getAllKessanYokukiPRn();


    ZT_KessanYokukiPRn getKessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono);


    ExDBResults<ZT_KessanYokukiPTy> getAllKessanYokukiPTy();


    ZT_KessanYokukiPTy getKessanYokukiPTy(String pZtykeijyouym, String pZtysyono);


    ExDBResults<ZT_KessanZennouFRn> getAllKessanZennouFRn();


    ZT_KessanZennouFRn getKessanZennouFRn(String pZrnsyono, String pZrnkbnkeiriyousegmentcd, String pZrnzennoutoukeilistkbn, String pZrnzennoukbn);


    ExDBResults<ZT_KessanZennouFTy> getAllKessanZennouFTy();


    ZT_KessanZennouFTy getKessanZennouFTy(String pZtysyono, String pZtykbnkeiriyousegmentcd, String pZtyzennoutoukeilistkbn, String pZtyzennoukbn);


    ExDBResults<ZT_KhDrtenMinyuuKykMeisaiRn> getAllKhDrtenMinyuuKykMeisaiRn();


    ZT_KhDrtenMinyuuKykMeisaiRn getKhDrtenMinyuuKykMeisaiRn(String pZrnsyoriymd, String pZrnbsydrtencd, String pZrnsyono);


    ExDBResults<ZT_KhDrtenMinyuuKykMeisaiTy> getAllKhDrtenMinyuuKykMeisaiTy();


    ZT_KhDrtenMinyuuKykMeisaiTy getKhDrtenMinyuuKykMeisaiTy(String pZtysyoriymd, String pZtybsydrtencd, String pZtysyono);


    ExDBResults<ZT_KhGinkouMdhnFollowCallRn> getAllKhGinkouMdhnFollowCallRn();


    ZT_KhGinkouMdhnFollowCallRn getKhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym);


    ExDBResults<ZT_KhGinkouMdhnFollowCallTy> getAllKhGinkouMdhnFollowCallTy();


    ZT_KhGinkouMdhnFollowCallTy getKhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym);


    ExDBResults<ZT_KijituTouraiAnnaiRn> getAllKijituTouraiAnnaiRn();


    ZT_KijituTouraiAnnaiRn getKijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_KijituTouraiAnnaiTy> getAllKijituTouraiAnnaiTy();


    ZT_KijituTouraiAnnaiTy getKijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_KouzaHnknTuutiRn> getAllKouzaHnknTuutiRn();


    ZT_KouzaHnknTuutiRn getKouzaHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_KouzaHnknTuutiTy> getAllKouzaHnknTuutiTy();


    ZT_KouzaHnknTuutiTy getKouzaHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_KouzaHrkmTuutiRn> getAllKouzaHrkmTuutiRn();


    ZT_KouzaHrkmTuutiRn getKouzaHrkmTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_KouzaHrkmTuutiTy> getAllKouzaHrkmTuutiTy();


    ZT_KouzaHrkmTuutiTy getKouzaHrkmTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_KouzahuriMinyuTuutiRn> getAllKouzahuriMinyuTuutiRn();


    ZT_KouzahuriMinyuTuutiRn getKouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_KouzahuriMinyuTuutiTy> getAllKouzahuriMinyuTuutiTy();


    ZT_KouzahuriMinyuTuutiTy getKouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_KouzahuriStartAnnaiRn> getAllKouzahuriStartAnnaiRn();


    ZT_KouzahuriStartAnnaiRn getKouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_KouzahuriStartAnnaiTy> getAllKouzahuriStartAnnaiTy();


    ZT_KouzahuriStartAnnaiTy getKouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_KzhuriAnnaiUlfRn> getAllKzhuriAnnaiUlfRn();


    ZT_KzhuriAnnaiUlfRn getKzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym);


    ExDBResults<ZT_KzhuriAnnaiUlfTy> getAllKzhuriAnnaiUlfTy();


    ZT_KzhuriAnnaiUlfTy getKzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym);


    ExDBResults<ZT_SinkokuYokokuTuutiFSksRn> getAllSinkokuYokokuTuutiFSksRn();


    ZT_SinkokuYokokuTuutiFSksRn getSinkokuYokokuTuutiFSksRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsinkokunenkj);


    ExDBResults<ZT_SinkokuYokokuTuutiFSksTy> getAllSinkokuYokokuTuutiFSksTy();


    ZT_SinkokuYokokuTuutiFSksTy getSinkokuYokokuTuutiFSksTy(String pZtytyouhyouymd, String pZtysyono, String pZtysinkokunenkj);


    ExDBResults<ZT_DrtenMinyuuKykInfoRn> getAllDrtenMinyuuKykInfoRn();


    ZT_DrtenMinyuuKykInfoRn getDrtenMinyuuKykInfoRn(String pZrnsyono);


    ExDBResults<ZT_DrtenMinyuuKykInfoTy> getAllDrtenMinyuuKykInfoTy();


    ZT_DrtenMinyuuKykInfoTy getDrtenMinyuuKykInfoTy(String pZtysyono);


    ExDBResults<ZT_DrtenMinyuKykDtlSyokaiRn> getAllDrtenMinyuKykDtlSyokaiRn();


    ZT_DrtenMinyuKykDtlSyokaiRn getDrtenMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono);


    ExDBResults<ZT_DrtenMinyuKykDtlSyokaiTy> getAllDrtenMinyuKykDtlSyokaiTy();


    ZT_DrtenMinyuKykDtlSyokaiTy getDrtenMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono);


    ExDBResults<ZT_YuseiMinyuKykDtlSyokaiRn> getAllYuseiMinyuKykDtlSyokaiRn();


    ZT_YuseiMinyuKykDtlSyokaiRn getYuseiMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono);


    ExDBResults<ZT_YuseiMinyuKykDtlSyokaiTy> getAllYuseiMinyuKykDtlSyokaiTy();


    ZT_YuseiMinyuKykDtlSyokaiTy getYuseiMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono);


    ExDBResults<ZT_DrtenMisyuSkInfoDataRn> getAllDrtenMisyuSkInfoDataRn();


    ZT_DrtenMisyuSkInfoDataRn getDrtenMisyuSkInfoDataRn(String pZrnsyono, String pZrnbsydrtencd, String pZrnhanteiymd);


    ExDBResults<ZT_DrtenMisyuSkInfoDataTy> getAllDrtenMisyuSkInfoDataTy();


    ZT_DrtenMisyuSkInfoDataTy getDrtenMisyuSkInfoDataTy(String pZtysyono, String pZtybsydrtencd, String pZtyhanteiymd);


    ExDBResults<ZT_SaihakkouSyoukenSuii2Rn> getAllSaihakkouSyoukenSuii2Rn();


    ZT_SaihakkouSyoukenSuii2Rn getSaihakkouSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn);


    ExDBResults<ZT_SaihakkouSyoukenSuii2Ty> getAllSaihakkouSyoukenSuii2Ty();


    ZT_SaihakkouSyoukenSuii2Ty getSaihakkouSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn);


    ExDBResults<ZT_SinkeiyakuSyoukenSuii2Rn> getAllSinkeiyakuSyoukenSuii2Rn();


    ZT_SinkeiyakuSyoukenSuii2Rn getSinkeiyakuSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn);


    ExDBResults<ZT_SinkeiyakuSyoukenSuii2Ty> getAllSinkeiyakuSyoukenSuii2Ty();


    ZT_SinkeiyakuSyoukenSuii2Ty getSinkeiyakuSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn);


    ExDBResults<ZT_ZennouHoyuuIdouKykDtlTy> getAllZennouHoyuuIdouKykDtlTy();


    ZT_ZennouHoyuuIdouKykDtlTy getZennouHoyuuIdouKykDtlTy(String pZtydatakanrino, String pZtysyoricd, Integer pZtykykmfksnctr);


    ExDBResults<ZT_ZennouHoyuuIdouKykDtlRn> getAllZennouHoyuuIdouKykDtlRn();


    ZT_ZennouHoyuuIdouKykDtlRn getZennouHoyuuIdouKykDtlRn(String pZrndatakanrino, String pZrnsyoricd, Integer pZrnkykmfksnctr);

    ExDBResults<ZT_SyoumetuTuutiTy> getAllSyoumetuTuutiTy();


    ZT_SyoumetuTuutiTy getSyoumetuTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_SyoumetuTuutiRn> getAllSyoumetuTuutiRn();


    ZT_SyoumetuTuutiRn getSyoumetuTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    ExDBResults<ZT_DrtenSkKykDtlSyokaiTy> getAllDrtenSkKykDtlSyokaiTy();


    ZT_DrtenSkKykDtlSyokaiTy getDrtenSkKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono);


    ExDBResults<ZT_DrtenSkKykDtlSyokaiRn> getAllDrtenSkKykDtlSyokaiRn();


    ZT_DrtenSkKykDtlSyokaiRn getDrtenSkKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono);


    ExDBResults<ZT_GentumiSkMikomirituULFTy> getAllGentumiSkMikomirituULFTy();


    ZT_GentumiSkMikomirituULFTy getGentumiSkMikomirituULFTy(String pZtydatakanrino);


    ExDBResults<ZT_GentumiSkMikomirituULFRn> getAllGentumiSkMikomirituULFRn();


    ZT_GentumiSkMikomirituULFRn getGentumiSkMikomirituULFRn(String pZrndatakanrino);


    ExDBResults<ZT_SinBosyuuDrtenHoyuuKykTy> getAllSinBosyuuDrtenHoyuuKykTy();


    ZT_SinBosyuuDrtenHoyuuKykTy getSinBosyuuDrtenHoyuuKykTy(String pZtysyono);


    ExDBResults<ZT_SinBosyuuDrtenHoyuuKykRn> getAllSinBosyuuDrtenHoyuuKykRn();


    ZT_SinBosyuuDrtenHoyuuKykRn getSinBosyuuDrtenHoyuuKykRn(String pZrnsyono);


    ExDBResults<ZT_UriageSousinTy> getAllUriageSousinTy();


    ZT_UriageSousinTy getUriageSousinTy(String pZtycreditkessaiyouno, String pZtysyono, String pZtyuriageseikyuuymd, Long pZtyrsgaku, String pZtyrecordno);


    ExDBResults<ZT_UriageSousinRn> getAllUriageSousinRn();


    ZT_UriageSousinRn getUriageSousinRn(String pZrncreditkessaiyouno, String pZrnsyono, String pZrnuriageseikyuuymd, Long pZrnrsgaku, String pZrnrecordno);


    ExDBResults<ZT_KesikomiSousinCreditTy> getAllKesikomiSousinCreditTy();


    ZT_KesikomiSousinCreditTy getKesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd);


    ExDBResults<ZT_KesikomiSousinCreditRn> getAllKesikomiSousinCreditRn();


    ZT_KesikomiSousinCreditRn getKesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd);


    ExDBResults<ZT_YuukouseiNgTuutiTy> getAllYuukouseiNgTuutiTy();


    ZT_YuukouseiNgTuutiTy getYuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono);


    ExDBResults<ZT_YuukouseiNgTuutiRn> getAllYuukouseiNgTuutiRn();


    ZT_YuukouseiNgTuutiRn getYuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono);


    ExDBResults<ZT_DSeisanShrTysySyuseiTy> getAllDSeisanShrTysySyuseiTy();


    ZT_DSeisanShrTysySyuseiTy getDSeisanShrTysySyuseiTy(String pZtysyono);


    ExDBResults<ZT_DSeisanShrTysySyuseiRn> getAllDSeisanShrTysySyuseiRn();


    ZT_DSeisanShrTysySyuseiRn getDSeisanShrTysySyuseiRn(String pZrnsyono);


    ExDBResults<ZT_SeisanDHaneiTuutiTy> getAllSeisanDHaneiTuutiTy();


    ZT_SeisanDHaneiTuutiTy getSeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono);


    ExDBResults<ZT_SeisanDHaneiTuutiRn> getAllSeisanDHaneiTuutiRn();


    ZT_SeisanDHaneiTuutiRn getSeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono);


    ExDBResults<ZT_DairitenGtmtZndkTy> getAllDairitenGtmtZndkTy();


    ZT_DairitenGtmtZndkTy getDairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono);


    ExDBResults<ZT_DairitenGtmtZndkRn> getAllDairitenGtmtZndkRn();


    ZT_DairitenGtmtZndkRn getDairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono);


    ExDBResults<ZT_CreditHnknTuutiTy> getAllCreditHnknTuutiTy();


    ZT_CreditHnknTuutiTy getCreditHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_CreditHnknTuutiRn> getAllCreditHnknTuutiRn();


    ZT_CreditHnknTuutiRn getCreditHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);



    ExDBResults<ZT_KzhuriSyuunouKekkaRn> getAllKzhuriSyuunouKekkaRn();


    ZT_KzhuriSyuunouKekkaRn getKzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym);


    ExDBResults<ZT_KzhuriSyuunouKekkaTr> getAllKzhuriSyuunouKekkaTr();


    ZT_KzhuriSyuunouKekkaTr getKzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym);


    ExDBResults<ZT_UriageKekkaTr> getAllUriageKekkaTr();


    ZT_UriageKekkaTr getUriageKekkaTr(String pZtrsyono, String pZtrcreditkessaiyouno, String pZtruriageymd6keta, String pZtrrecordno, Long pZtrseikyuukngk);


    ExDBResults<ZT_UriageKekkaRn> getAllUriageKekkaRn();


    ZT_UriageKekkaRn getUriageKekkaRn(String pZrnsyono, String pZrncreditkessaiyouno, String pZrnuriageymd6keta, String pZrnrecordno, Long pZrnseikyuukngk);


    ExDBResults<ZT_YuukouKakKekkaFRn> getAllYuukouKakKekkaFRn();


    ZT_YuukouKakKekkaFRn getYuukouKakKekkaFRn(String pZrncreditkessaiyouno);


    ExDBResults<ZT_YuukouKakKekkaFTr> getAllYuukouKakKekkaFTr();


    ZT_YuukouKakKekkaFTr getYuukouKakKekkaFTr(String pZtrcreditkessaiyouno);


    ExDBResults<ZT_AuthoriKekkaRn> getAllAuthoriKekkaRn();


    ZT_AuthoriKekkaRn getAuthoriKekkaRn(String pZrnrenno7, String pZrncreditkessaiyouno, String pZrndatajyusinymd);


    ExDBResults<ZT_AuthoriKekkaTr> getAllAuthoriKekkaTr();


    ZT_AuthoriKekkaTr getAuthoriKekkaTr(String pZtrrenno7, String pZtrcreditkessaiyouno, String pZtrdatajyusinymd);



    ExDBResults<ZT_AiKyuubuByoumeiRn> getAllAiKyuubuByoumeiRn();


    ZT_AiKyuubuByoumeiRn getAiKyuubuByoumeiRn(String pZrnbyoumeitourokuno);


    ExDBResults<ZT_SiShrdetailTy> getAllSiShrdetailTy();


    ZT_SiShrdetailTy getSiShrdetailTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno);


    ExDBResults<ZT_SiShrdetailRn> getAllSiShrdetailRn();


    ZT_SiShrdetailRn getSiShrdetailRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno);


    Long getAiKyuubuByoumeiRnCount();



    ExDBResults<ZT_DsKariPasswordTuutiTy> getAllDsKariPasswordTuutiTy();


    ZT_DsKariPasswordTuutiTy getDsKariPasswordTuutiTy(String pZtykrpasswordtuutikey);


    ExDBResults<ZT_DsKariPasswordTuutiRn> getAllDsKariPasswordTuutiRn();


    ZT_DsKariPasswordTuutiRn getDsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey);


    ExDBResults<ZT_DsHanyouKokyakuTuutiRn> getAllDsHanyouKokyakuTuutiRn();


    ZT_DsHanyouKokyakuTuutiRn getDsHanyouKokyakuTuutiRn(String pZrndshanyoukokatetuutikey, String pZrndskokno, String pZrndstuutikbn);


    ExDBResults<ZT_DsHanyouKokyakuTuutiTy> getAllDsHanyouKokyakuTuutiTy();


    ZT_DsHanyouKokyakuTuutiTy getDsHanyouKokyakuTuutiTy(String pZtydshanyoukokatetuutikey, String pZtydskokno, String pZtydstuutikbn);

}
