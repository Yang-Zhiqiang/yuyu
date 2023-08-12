package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.db.entity.*;
import yuyu.def.zdb.manager.ZdbDomManager;


/**
 * システム間連携 DOM マネージャ 実装クラス<br />
 * {@link ZdbDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class ZdbDomManagerImpl extends AbstractDomManager implements ZdbDomManager {


    @Inject
    private BizdiskhousikijyuinDomManager bizdiskhousikijyuinDomManager;


    @Inject
    private NayosedisksousinDomManager nayosedisksousinDomManager;


    @Inject
    private BizNayosedisksousinDomManager bizNayosedisksousinDomManager;


    @Inject
    private SuuridiskjyusinDomManager suuridiskjyusinDomManager;


    @Inject
    private SuuridisksousinDomManager suuridisksousinDomManager;


    @Inject
    private SinkeiyakudiskjyusinDomManager sinkeiyakudiskjyusinDomManager;


    @Inject
    private SinkeiyakuijitokeijyusinDomManager sinkeiyakuijitokeijyusinDomManager;


    @Inject
    private SinkeiyakujyohososinDomManager sinkeiyakujyohososinDomManager;


    @Inject
    private SinkeiyakuijitokeisosinDomManager sinkeiyakuijitokeisosinDomManager;


    @Inject
    private SinkeiyakuetcDomManager sinkeiyakuetcDomManager;


    @Inject
    private SinkeiyakuLincSosinDomManager sinkeiyakuLincSosinDomManager;


    @Inject
    private SinkeiyakuLincJyusinDomManager sinkeiyakuLincJyusinDomManager;


    @Inject
    private HozendiskjyusinDomManager hozendiskjyusinDomManager;


    @Inject
    private HozenkydiskjyusinDomManager hozenkydiskjyusinDomManager;


    @Inject
    private SiharaidiskjyusinDomManager siharaidiskjyusinDomManager;


    @Inject
    private DirectServiceDomManager directServiceDomManager;



    @Override
    public Long getAcsAdrNmRnCount() {
        return bizdiskhousikijyuinDomManager.getAcsAdrNmRnCount();
    }


    @Override
    public ExDBResults<ZT_KinyuuKikanInfoRn> getAllKinyuuKikanInfoRn() {
        return bizdiskhousikijyuinDomManager.getAllKinyuuKikanInfoRn();
    }


    @Override
    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdNe4Space() {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRnsByZrnsitencdNe4Space();
    }


    @Override
    public ZT_KinyuuKikanInfoRn getKinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRn(pZrnkinyuukikancd, pZrnsitencd);
    }


    @Override
    public Long getKinyuuKikanInfoRnCountByZrnsitencdNe4Space() {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRnCountByZrnsitencdNe4Space();
    }


    @Override
    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(String pZrnkinyuukikancdKeta4) {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(pZrnkinyuukikancdKeta4);
    }


    @Override
    public Long getKinyuuKikanInfoRnCountByZrnsitencdE4Space() {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();
    }


    @Override
    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdE4Space() {
        return bizdiskhousikijyuinDomManager.getKinyuuKikanInfoRnsByZrnsitencdE4Space();
    }


    @Override
    public ExDBResults<ZT_AcsAdrNmRn> getAllAcsAdrNmRn() {
        return bizdiskhousikijyuinDomManager.getAllAcsAdrNmRn();
    }


    @Override
    public ZT_AcsAdrNmRn getAcsAdrNmRn(String pZrnkihontikucd) {
        return bizdiskhousikijyuinDomManager.getAcsAdrNmRn(pZrnkihontikucd);
    }


    @Override
    public ExDBResults<ZT_AcsAdrNmRn> getAcsAdrNmRnsByZrnkihontikucdKeta7(String pZrnkihontikucdKeta7) {
        return bizdiskhousikijyuinDomManager.getAcsAdrNmRnsByZrnkihontikucdKeta7(pZrnkihontikucdKeta7);
    }


    @Override
    public ExDBResults<ZT_DairitenRn> getAllDairitenRn() {
        return bizdiskhousikijyuinDomManager.getAllDairitenRn();
    }


    @Override
    public Long getDairitenRnCount() {
        return bizdiskhousikijyuinDomManager.getDairitenRnCount();
    }


    @Override
    public ZT_DairitenRn getDairitenRn(String pZrndairitencd) {
        return bizdiskhousikijyuinDomManager.getDairitenRn(pZrndairitencd);
    }


    @Override
    public ExDBResults<ZT_DairitenSyougouRn> getAllDairitenSyougouRn() {
        return bizdiskhousikijyuinDomManager.getAllDairitenSyougouRn();
    }


    @Override
    public ZT_DairitenSyougouRn getDairitenSyougouRn(String pZrndairitencd) {
        return bizdiskhousikijyuinDomManager.getDairitenSyougouRn(pZrndairitencd);
    }


    @Override
    public Long getDairitenSyougouRnCount() {
        return bizdiskhousikijyuinDomManager.getDairitenSyougouRnCount();
    }


    @Override
    public ExDBResults<ZT_TuukabetuKyuusibiRn> getAllTuukabetuKyuusibiRn() {
        return bizdiskhousikijyuinDomManager.getAllTuukabetuKyuusibiRn();
    }


    @Override
    public ZT_TuukabetuKyuusibiRn getTuukabetuKyuusibiRn(String pZrntekiyouymd) {
        return bizdiskhousikijyuinDomManager.getTuukabetuKyuusibiRn(pZrntekiyouymd);
    }


    @Override
    public Long getTuukabetuKyuusibiRnCount() {
        return bizdiskhousikijyuinDomManager.getTuukabetuKyuusibiRnCount();
    }


    @Override
    public ExDBResults<ZT_BosyuuninRn> getAllBosyuuninRn() {
        return bizdiskhousikijyuinDomManager.getAllBosyuuninRn();
    }


    @Override
    public ZT_BosyuuninRn getBosyuuninRn(String pZrnbosyuunincd) {
        return bizdiskhousikijyuinDomManager.getBosyuuninRn(pZrnbosyuunincd);
    }


    @Override
    public ExDBResults<ZT_BosyuuninRn> getBosyuuninRnsByZrnbosyuunincdKeta6(String pZrnbosyuunincdKeta6) {
        return bizdiskhousikijyuinDomManager.getBosyuuninRnsByZrnbosyuunincdKeta6(pZrnbosyuunincdKeta6);
    }


    @Override
    public ExDBResults<ZT_DairitenBuntanInfoRn> getAllDairitenBuntanInfoRn() {
        return bizdiskhousikijyuinDomManager.getAllDairitenBuntanInfoRn();
    }


    @Override
    public ZT_DairitenBuntanInfoRn getDairitenBuntanInfoRn(String pZrndairitencd, String pZrndairitensyouhincd, String pZrntesuuryoubuntandrtencd, String pZrntesuuryoubuntanstartym) {
        return bizdiskhousikijyuinDomManager.getDairitenBuntanInfoRn(pZrndairitencd, pZrndairitensyouhincd, pZrntesuuryoubuntandrtencd, pZrntesuuryoubuntanstartym);
    }


    @Override
    public ExDBResults<ZT_HonyakuYouKouinRn> getAllHonyakuYouKouinRn() {
        return bizdiskhousikijyuinDomManager.getAllHonyakuYouKouinRn();
    }


    @Override
    public ZT_HonyakuYouKouinRn getHonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {
        return bizdiskhousikijyuinDomManager.getHonyakuYouKouinRn(pZrnkinyuukikancd, pZrnkouincd);
    }


    @Override
    public ExDBResults<ZT_HonyakuYouKouinRn> getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(String pZrnkinyuukikancdKeta4) {
        return bizdiskhousikijyuinDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(pZrnkinyuukikancdKeta4);
    }


    @Override
    public Long getHonyakuYouKouinRnCount() {
        return bizdiskhousikijyuinDomManager.getHonyakuYouKouinRnCount();
    }


    @Override
    public ExDBResults<ZT_IdCardKihonRn> getAllIdCardKihonRn() {
        return bizdiskhousikijyuinDomManager.getAllIdCardKihonRn();
    }


    @Override
    public ZT_IdCardKihonRn getIdCardKihonRn(String pZrnidkbn, String pZrnidcd) {
        return bizdiskhousikijyuinDomManager.getIdCardKihonRn(pZrnidkbn, pZrnidcd);
    }


    @Override
    public Long getIdCardKihonRnCount() {
        return bizdiskhousikijyuinDomManager.getIdCardKihonRnCount();
    }


    @Override
    public ExDBResults<ZT_IdCardKihonRn> getIdCardKihonRnsByZrnidcdKeta6(String pZrnidcdKeta6) {
        return bizdiskhousikijyuinDomManager.getIdCardKihonRnsByZrnidcdKeta6(pZrnidcdKeta6);
    }


    @Override
    public ExDBResults<ZT_IdCardYakusyokuRn> getAllIdCardYakusyokuRn() {
        return bizdiskhousikijyuinDomManager.getAllIdCardYakusyokuRn();
    }


    @Override
    public ZT_IdCardYakusyokuRn getIdCardYakusyokuRn(String pZrnidkbn, String pZrnidcd, String pZrnyakusyokuhatureiymd, String pZrnyakusyokuhatureino) {
        return bizdiskhousikijyuinDomManager.getIdCardYakusyokuRn(pZrnidkbn, pZrnidcd, pZrnyakusyokuhatureiymd, pZrnyakusyokuhatureino);
    }


    @Override
    public Long getIdCardYakusyokuRnCount() {
        return bizdiskhousikijyuinDomManager.getIdCardYakusyokuRnCount();
    }


    @Override
    public ExDBResults<ZT_SosikiRn> getAllSosikiRn() {
        return bizdiskhousikijyuinDomManager.getAllSosikiRn();
    }


    @Override
    public ZT_SosikiRn getSosikiRn(String pZrnsosikicd) {
        return bizdiskhousikijyuinDomManager.getSosikiRn(pZrnsosikicd);
    }


    @Override
    public Long getSosikiRnCount() {
        return bizdiskhousikijyuinDomManager.getSosikiRnCount();
    }


    @Override
    public ExDBResults<ZT_KawaserateRn> getAllKawaserateRn() {
        return bizdiskhousikijyuinDomManager.getAllKawaserateRn();
    }


    @Override
    public ZT_KawaserateRn getKawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {
        return bizdiskhousikijyuinDomManager.getKawaserateRn(pZrnkwsratekjymd, pZrnkawaserendoukbn);
    }


    @Override
    public ExDBResults<ZT_KawaserateTr> getAllKawaserateTr() {
        return bizdiskhousikijyuinDomManager.getAllKawaserateTr();
    }


    @Override
    public ZT_KawaserateTr getKawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {
        return bizdiskhousikijyuinDomManager.getKawaserateTr(pZtrkwsratekjymd, pZtrkawaserendoukbn);
    }


    @Override
    public ExDBResults<ZT_NyknmeisaiRn> getAllNyknmeisaiRn() {
        return bizdiskhousikijyuinDomManager.getAllNyknmeisaiRn();
    }


    @Override
    public ZT_NyknmeisaiRn getNyknmeisaiRn(String pZrnsakuseiymd6keta, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano
        , String pZrnsyoukaino, String pZrnrenno8) {
        return bizdiskhousikijyuinDomManager.getNyknmeisaiRn(pZrnsakuseiymd6keta, pZrnbankcd, pZrnshitencd, pZrnyokinkbn, pZrnkouzano
            , pZrnsyoukaino, pZrnrenno8);
    }


    @Override
    public ExDBResults<ZT_NyknmeisaiTr> getAllNyknmeisaiTr() {
        return bizdiskhousikijyuinDomManager.getAllNyknmeisaiTr();
    }


    @Override
    public ZT_NyknmeisaiTr getNyknmeisaiTr(String pZtrsakuseiymd6keta, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano
        , String pZtrsyoukaino, String pZtrrenno8) {
        return bizdiskhousikijyuinDomManager.getNyknmeisaiTr(pZtrsakuseiymd6keta, pZtrbankcd, pZtrshitencd, pZtryokinkbn, pZtrkouzano
            , pZtrsyoukaino, pZtrrenno8);
    }


    @Override
    public ExDBResults<ZT_NyknmeisaiTr> getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(String pKakutyoujobcd, String pZtrsakuseiymd6keta) {
        return bizdiskhousikijyuinDomManager.getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(pKakutyoujobcd, pZtrsakuseiymd6keta);
    }


    @Override
    public ExDBResults<ZT_GknyknmeisaiRn> getAllGknyknmeisaiRn() {
        return bizdiskhousikijyuinDomManager.getAllGknyknmeisaiRn();
    }


    @Override
    public ZT_GknyknmeisaiRn getGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd
        , String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnksnymd) {
        return bizdiskhousikijyuinDomManager.getGknyknmeisaiRn(pZrnsakuseiymd, pZrnrenrakuymd, pZrnrenrakukaisuu, pZrnbankcd, pZrnshitencd
            , pZrnyokinkbn, pZrnkouzano, pZrnzndktuukasyu, pZrnksnymd);
    }


    @Override
    public ExDBResults<ZT_GknyknmeisaiTr> getAllGknyknmeisaiTr() {
        return bizdiskhousikijyuinDomManager.getAllGknyknmeisaiTr();
    }


    @Override
    public ExDBResults<ZT_GknyknmeisaiTr> getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(String pKakutyoujobcd, String pZtrsakuseiymd) {
        return bizdiskhousikijyuinDomManager.getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(pKakutyoujobcd, pZtrsakuseiymd);
    }


    @Override
    public ZT_GknyknmeisaiTr getGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd
        , String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrksnymd) {
        return bizdiskhousikijyuinDomManager.getGknyknmeisaiTr(pZtrsakuseiymd, pZtrrenrakuymd, pZtrrenrakukaisuu, pZtrbankcd, pZtrshitencd
            , pZtryokinkbn, pZtrkouzano, pZtrzndktuukasyu, pZtrksnymd);
    }


    @Override
    public ExDBResults<ZT_FurikaeDenpyouTy> getAllFurikaeDenpyouTy() {
        return bizdiskhousikijyuinDomManager.getAllFurikaeDenpyouTy();
    }


    @Override
    public ZT_FurikaeDenpyouTy getFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return bizdiskhousikijyuinDomManager.getFurikaeDenpyouTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_FurikaeDenpyouHikaeTy> getAllFurikaeDenpyouHikaeTy() {
        return bizdiskhousikijyuinDomManager.getAllFurikaeDenpyouHikaeTy();
    }


    @Override
    public ZT_FurikaeDenpyouHikaeTy getFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return bizdiskhousikijyuinDomManager.getFurikaeDenpyouHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkFurikaeDenpyouTy> getAllSkFurikaeDenpyouTy() {
        return bizdiskhousikijyuinDomManager.getAllSkFurikaeDenpyouTy();
    }


    @Override
    public ZT_SkFurikaeDenpyouTy getSkFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return bizdiskhousikijyuinDomManager.getSkFurikaeDenpyouTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkFurikaeDenpyouHikaeTy> getAllSkFurikaeDenpyouHikaeTy() {
        return bizdiskhousikijyuinDomManager.getAllSkFurikaeDenpyouHikaeTy();
    }


    @Override
    public ZT_SkFurikaeDenpyouHikaeTy getSkFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return bizdiskhousikijyuinDomManager.getSkFurikaeDenpyouHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_FurikaeDenpyouRn> getAllFurikaeDenpyouRn() {
        return bizdiskhousikijyuinDomManager.getAllFurikaeDenpyouRn();
    }


    @Override
    public ZT_FurikaeDenpyouRn getFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return bizdiskhousikijyuinDomManager.getFurikaeDenpyouRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_FurikaeDenpyouHikaeRn> getAllFurikaeDenpyouHikaeRn() {
        return bizdiskhousikijyuinDomManager.getAllFurikaeDenpyouHikaeRn();
    }


    @Override
    public ZT_FurikaeDenpyouHikaeRn getFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return bizdiskhousikijyuinDomManager.getFurikaeDenpyouHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkFurikaeDenpyouRn> getAllSkFurikaeDenpyouRn() {
        return bizdiskhousikijyuinDomManager.getAllSkFurikaeDenpyouRn();
    }


    @Override
    public ZT_SkFurikaeDenpyouRn getSkFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return bizdiskhousikijyuinDomManager.getSkFurikaeDenpyouRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkFurikaeDenpyouHikaeRn> getAllSkFurikaeDenpyouHikaeRn() {
        return bizdiskhousikijyuinDomManager.getAllSkFurikaeDenpyouHikaeRn();
    }


    @Override
    public ZT_SkFurikaeDenpyouHikaeRn getSkFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return bizdiskhousikijyuinDomManager.getSkFurikaeDenpyouHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_JinsokuShrTtdkInfoTy> getAllJinsokuShrTtdkInfoTy() {
        return bizdiskhousikijyuinDomManager.getAllJinsokuShrTtdkInfoTy();
    }


    @Override
    public ZT_JinsokuShrTtdkInfoTy getJinsokuShrTtdkInfoTy(String pZtysyorisosikicd, String pZtysyoricd, String pZtyhknknshrsntkno, String pZtysyoruiukeymd, String pZtysyoriymd
        , String pZtydenymd, String pZtysyono) {
        return bizdiskhousikijyuinDomManager.getJinsokuShrTtdkInfoTy(pZtysyorisosikicd, pZtysyoricd, pZtyhknknshrsntkno, pZtysyoruiukeymd, pZtysyoriymd
            , pZtydenymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_JinsokuShrTtdkInfoRn> getAllJinsokuShrTtdkInfoRn() {
        return bizdiskhousikijyuinDomManager.getAllJinsokuShrTtdkInfoRn();
    }


    @Override
    public ZT_JinsokuShrTtdkInfoRn getJinsokuShrTtdkInfoRn(String pZrnsyorisosikicd, String pZrnsyoricd, String pZrnhknknshrsntkno, String pZrnsyoruiukeymd, String pZrnsyoriymd
        , String pZrndenymd, String pZrnsyono) {
        return bizdiskhousikijyuinDomManager.getJinsokuShrTtdkInfoRn(pZrnsyorisosikicd, pZrnsyoricd, pZrnhknknshrsntkno, pZrnsyoruiukeymd, pZrnsyoriymd
            , pZrndenymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KaikeiTorihikiFileTy> getAllKaikeiTorihikiFileTy() {
        return bizdiskhousikijyuinDomManager.getAllKaikeiTorihikiFileTy();
    }


    @Override
    public ZT_KaikeiTorihikiFileTy getKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd) {
        return bizdiskhousikijyuinDomManager.getKaikeiTorihikiFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumon, pZtytekiyoucd);
    }


    @Override
    public ExDBResults<ZT_SkKaikeiTorihikiFileTy> getAllSkKaikeiTorihikiFileTy() {
        return bizdiskhousikijyuinDomManager.getAllSkKaikeiTorihikiFileTy();
    }


    @Override
    public ZT_SkKaikeiTorihikiFileTy getSkKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd) {
        return bizdiskhousikijyuinDomManager.getSkKaikeiTorihikiFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumon, pZtytekiyoucd);
    }


    @Override
    public ExDBResults<ZT_KaikeiTorihikiFileRn> getAllKaikeiTorihikiFileRn() {
        return bizdiskhousikijyuinDomManager.getAllKaikeiTorihikiFileRn();
    }


    @Override
    public ZT_KaikeiTorihikiFileRn getKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd) {
        return bizdiskhousikijyuinDomManager.getKaikeiTorihikiFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumon, pZrntekiyoucd);
    }


    @Override
    public ExDBResults<ZT_SkKaikeiTorihikiFileRn> getAllSkKaikeiTorihikiFileRn() {
        return bizdiskhousikijyuinDomManager.getAllSkKaikeiTorihikiFileRn();
    }


    @Override
    public ZT_SkKaikeiTorihikiFileRn getSkKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd) {
        return bizdiskhousikijyuinDomManager.getSkKaikeiTorihikiFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumon, pZrntekiyoucd);
    }


    @Override
    public ExDBResults<ZT_KubunKeiriFileTy> getAllKubunKeiriFileTy() {
        return bizdiskhousikijyuinDomManager.getAllKubunKeiriFileTy();
    }


    @Override
    public ZT_KubunKeiriFileTy getKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        return bizdiskhousikijyuinDomManager.getKubunKeiriFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    @Override
    public ExDBResults<ZT_SkKubunKeiriFileTy> getAllSkKubunKeiriFileTy() {
        return bizdiskhousikijyuinDomManager.getAllSkKubunKeiriFileTy();
    }


    @Override
    public ZT_SkKubunKeiriFileTy getSkKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        return bizdiskhousikijyuinDomManager.getSkKubunKeiriFileTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    @Override
    public ExDBResults<ZT_KubunKeiriFileRn> getAllKubunKeiriFileRn() {
        return bizdiskhousikijyuinDomManager.getAllKubunKeiriFileRn();
    }


    @Override
    public ZT_KubunKeiriFileRn getKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        return bizdiskhousikijyuinDomManager.getKubunKeiriFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    @Override
    public ExDBResults<ZT_SkKubunKeiriFileRn> getAllSkKubunKeiriFileRn() {
        return bizdiskhousikijyuinDomManager.getAllSkKubunKeiriFileRn();
    }


    @Override
    public ZT_SkKubunKeiriFileRn getSkKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        return bizdiskhousikijyuinDomManager.getSkKubunKeiriFileRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    @Override
    public Long getDairitenBuntanInfoRnCount() {
        return bizdiskhousikijyuinDomManager.getDairitenBuntanInfoRnCount();
    }


    @Override
    public Long getBosyuuninRnCount() {
        return bizdiskhousikijyuinDomManager.getBosyuuninRnCount();
    }


    @Override
    public ExDBResults<ZT_SiharaiTyousyoTy> getAllSiharaiTyousyoTy() {
        return bizdiskhousikijyuinDomManager.getAllSiharaiTyousyoTy();
    }


    @Override
    public ZT_SiharaiTyousyoTy getSiharaiTyousyoTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getSiharaiTyousyoTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SiharaiTyousyoRn> getAllSiharaiTyousyoRn() {
        return bizdiskhousikijyuinDomManager.getAllSiharaiTyousyoRn();
    }


    @Override
    public ZT_SiharaiTyousyoRn getSiharaiTyousyoRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getSiharaiTyousyoRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_EgsyokuinSysRendouTy> getAllEgsyokuinSysRendouTy() {
        return bizdiskhousikijyuinDomManager.getAllEgsyokuinSysRendouTy();
    }


    @Override
    public ZT_EgsyokuinSysRendouTy getEgsyokuinSysRendouTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getEgsyokuinSysRendouTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_EgsyokuinSysRendouRn> getAllEgsyokuinSysRendouRn() {
        return bizdiskhousikijyuinDomManager.getAllEgsyokuinSysRendouRn();
    }


    @Override
    public ZT_EgsyokuinSysRendouRn getEgsyokuinSysRendouRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getEgsyokuinSysRendouRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_SkIpJissekiTy> getAllSkIpJissekiTy() {
        return bizdiskhousikijyuinDomManager.getAllSkIpJissekiTy();
    }


    @Override
    public ZT_SkIpJissekiTy getSkIpJissekiTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getSkIpJissekiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SkIpJissekiRn> getAllSkIpJissekiRn() {
        return bizdiskhousikijyuinDomManager.getAllSkIpJissekiRn();
    }


    @Override
    public ZT_SkIpJissekiRn getSkIpJissekiRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getSkIpJissekiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_SinkimatuHoyuuFTy> getAllSinkimatuHoyuuFTy() {
        return bizdiskhousikijyuinDomManager.getAllSinkimatuHoyuuFTy();
    }


    @Override
    public ZT_SinkimatuHoyuuFTy getSinkimatuHoyuuFTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getSinkimatuHoyuuFTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SinkimatuHoyuuFRn> getAllSinkimatuHoyuuFRn() {
        return bizdiskhousikijyuinDomManager.getAllSinkimatuHoyuuFRn();
    }


    @Override
    public ZT_SinkimatuHoyuuFRn getSinkimatuHoyuuFRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getSinkimatuHoyuuFRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_HoyuuJyunzouZougenFTy> getAllHoyuuJyunzouZougenFTy() {
        return bizdiskhousikijyuinDomManager.getAllHoyuuJyunzouZougenFTy();
    }


    @Override
    public ZT_HoyuuJyunzouZougenFTy getHoyuuJyunzouZougenFTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getHoyuuJyunzouZougenFTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_HoyuuJyunzouZougenFRn> getAllHoyuuJyunzouZougenFRn() {
        return bizdiskhousikijyuinDomManager.getAllHoyuuJyunzouZougenFRn();
    }


    @Override
    public ZT_HoyuuJyunzouZougenFRn getHoyuuJyunzouZougenFRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getHoyuuJyunzouZougenFRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KeizokurituRenrakuULFTy> getAllKeizokurituRenrakuULFTy() {
        return bizdiskhousikijyuinDomManager.getAllKeizokurituRenrakuULFTy();
    }


    @Override
    public ZT_KeizokurituRenrakuULFTy getKeizokurituRenrakuULFTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getKeizokurituRenrakuULFTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KeizokurituRenrakuULFRn> getAllKeizokurituRenrakuULFRn() {
        return bizdiskhousikijyuinDomManager.getAllKeizokurituRenrakuULFRn();
    }


    @Override
    public ZT_KeizokurituRenrakuULFRn getKeizokurituRenrakuULFRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getKeizokurituRenrakuULFRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TuutirirekiMeisaiFTy> getAllTuutirirekiMeisaiFTy() {
        return bizdiskhousikijyuinDomManager.getAllTuutirirekiMeisaiFTy();
    }


    @Override
    public ZT_TuutirirekiMeisaiFTy getTuutirirekiMeisaiFTy(String pZtytuutirirekino, String pZtytuutisakuseiymd, String pZtytuutisakuseino) {
        return bizdiskhousikijyuinDomManager.getTuutirirekiMeisaiFTy(pZtytuutirirekino, pZtytuutisakuseiymd, pZtytuutisakuseino);
    }


    @Override
    public ExDBResults<ZT_TuutirirekiMeisaiFRn> getAllTuutirirekiMeisaiFRn() {
        return bizdiskhousikijyuinDomManager.getAllTuutirirekiMeisaiFRn();
    }


    @Override
    public ZT_TuutirirekiMeisaiFRn getTuutirirekiMeisaiFRn(String pZrntuutirirekino, String pZrntuutisakuseiymd, String pZrntuutisakuseino) {
        return bizdiskhousikijyuinDomManager.getTuutirirekiMeisaiFRn(pZrntuutirirekino, pZrntuutisakuseiymd, pZrntuutisakuseino);
    }


    @Override
    public ExDBResults<ZT_KokyakuYuyuKykmeisaiFTy> getAllKokyakuYuyuKykmeisaiFTy() {
        return bizdiskhousikijyuinDomManager.getAllKokyakuYuyuKykmeisaiFTy();
    }


    @Override
    public ZT_KokyakuYuyuKykmeisaiFTy getKokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {
        return bizdiskhousikijyuinDomManager.getKokyakuYuyuKykmeisaiFTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KokyakuYuyuKykmeisaiFRn> getAllKokyakuYuyuKykmeisaiFRn() {
        return bizdiskhousikijyuinDomManager.getAllKokyakuYuyuKykmeisaiFRn();
    }


    @Override
    public ZT_KokyakuYuyuKykmeisaiFRn getKokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {
        return bizdiskhousikijyuinDomManager.getKokyakuYuyuKykmeisaiFRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_OnlineGknyknmeisaiRn> getAllOnlineGknyknmeisaiRn() {
        return bizdiskhousikijyuinDomManager.getAllOnlineGknyknmeisaiRn();
    }


    @Override
    public ZT_OnlineGknyknmeisaiRn getOnlineGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd,
        String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano,
        String pZrnzndktuukasyu, String pZtrsyorino1) {
        return bizdiskhousikijyuinDomManager.getOnlineGknyknmeisaiRn(pZrnsakuseiymd, pZrnrenrakuymd, pZrnrenrakukaisuu, pZrnbankcd, pZrnshitencd
            , pZrnyokinkbn, pZrnkouzano, pZrnzndktuukasyu, pZtrsyorino1);
    }


    @Override
    public ExDBResults<ZT_OnlineGknyknmeisaiTr> getAllOnlineGknyknmeisaiTr() {
        return bizdiskhousikijyuinDomManager.getAllOnlineGknyknmeisaiTr();
    }


    @Override
    public ZT_OnlineGknyknmeisaiTr getOnlineGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd,
        String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano,
        String pZtrzndktuukasyu, String pZtrsyorino1) {
        return bizdiskhousikijyuinDomManager.getOnlineGknyknmeisaiTr(pZtrsakuseiymd, pZtrrenrakuymd, pZtrrenrakukaisuu, pZtrbankcd, pZtrshitencd
            , pZtryokinkbn, pZtrkouzano, pZtrzndktuukasyu, pZtrsyorino1);
    }


    @Override
    public ExDBResults<ZT_SisuuRendouRn> getAllSisuuRendouRn() {
        return bizdiskhousikijyuinDomManager.getAllSisuuRendouRn();
    }


    @Override
    public ZT_SisuuRendouRn getSisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {
        return bizdiskhousikijyuinDomManager.getSisuuRendouRn(pZrntorikomiyousisuukbn, pZrnsisuukouhyouymd);
    }


    @Override
    public ExDBResults<ZT_DairitenItakuSyouhnRn> getAllDairitenItakuSyouhnRn() {
        return bizdiskhousikijyuinDomManager.getAllDairitenItakuSyouhnRn();
    }


    @Override
    public Long getDairitenItakuSyouhnRnCount() {
        return bizdiskhousikijyuinDomManager.getDairitenItakuSyouhnRnCount();
    }


    @Override
    public ZT_DairitenItakuSyouhnRn getDairitenItakuSyouhnRn(String pZrndairitencd, String pZrndrtsyouhinsikibetukbnstr, String pZrndrthrkhouhoukbn, String pZrndrtplannmkbn
        , String pZrnitakuhknhnbkaisiymd) {
        return bizdiskhousikijyuinDomManager.getDairitenItakuSyouhnRn(pZrndairitencd, pZrndrtsyouhinsikibetukbnstr, pZrndrthrkhouhoukbn, pZrndrtplannmkbn
            , pZrnitakuhknhnbkaisiymd);
    }



    @Override
    public ExDBResults<ZT_SntkInfoTourokuTy> getAllSntkInfoTourokuTy() {
        return nayosedisksousinDomManager.getAllSntkInfoTourokuTy();
    }



    @Override
    public ZT_SntkInfoTourokuTy getSntkInfoTourokuTy(String pZtysntkinfono, String pZtyrenno, String pZtysntkinfotourokusyskbn) {
        return bizNayosedisksousinDomManager.getSntkInfoTourokuTy(pZtysntkinfono, pZtyrenno, pZtysntkinfotourokusyskbn);
    }


    @Override
    public ExDBResults<ZT_SntkInfoTourokuRn> getAllSntkInfoTourokuRn() {
        return bizNayosedisksousinDomManager.getAllSntkInfoTourokuRn();
    }


    @Override
    public ZT_SntkInfoTourokuRn getSntkInfoTourokuRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {
        return bizNayosedisksousinDomManager.getSntkInfoTourokuRn(pZrnsntkinfono, pZrnrenno, pZrnsntkinfotourokusyskbn);
    }


    @Override
    public ExDBResults<ZT_TjtIdouNaiyouTy> getAllTjtIdouNaiyouTy() {
        return bizNayosedisksousinDomManager.getAllTjtIdouNaiyouTy();
    }


    @Override
    public ZT_TjtIdouNaiyouTy getTjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {
        return bizNayosedisksousinDomManager.getTjtIdouNaiyouTy(pZtyhuho2kyknokbn, pZtyhuho2kykno);
    }


    @Override
    public ExDBResults<ZT_TjtIdouNaiyouRn> getAllTjtIdouNaiyouRn() {
        return bizNayosedisksousinDomManager.getAllTjtIdouNaiyouRn();
    }


    @Override
    public ZT_TjtIdouNaiyouRn getTjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        return bizNayosedisksousinDomManager.getTjtIdouNaiyouRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }


    @Override
    public ExDBResults<ZT_SntkInfoHaneiKekkaTr> getAllSntkInfoHaneiKekkaTr() {
        return bizNayosedisksousinDomManager.getAllSntkInfoHaneiKekkaTr();
    }


    @Override
    public ZT_SntkInfoHaneiKekkaTr getSntkInfoHaneiKekkaTr(String pZtrsntkinfono, Integer pZtrrenno, String pZtrsntkinfotourokusyskbn) {
        return bizNayosedisksousinDomManager.getSntkInfoHaneiKekkaTr(pZtrsntkinfono, pZtrrenno, pZtrsntkinfotourokusyskbn);
    }


    @Override
    public ExDBResults<ZT_SntkInfoHaneiKekkaRn> getAllSntkInfoHaneiKekkaRn() {
        return bizNayosedisksousinDomManager.getAllSntkInfoHaneiKekkaRn();
    }


    @Override
    public ZT_SntkInfoHaneiKekkaRn getSntkInfoHaneiKekkaRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {
        return bizNayosedisksousinDomManager.getSntkInfoHaneiKekkaRn(pZrnsntkinfono, pZrnrenno, pZrnsntkinfotourokusyskbn);
    }


    @Override
    public ExDBResults<ZT_KykIdouHaneiKekkaTr> getAllKykIdouHaneiKekkaTr() {
        return bizNayosedisksousinDomManager.getAllKykIdouHaneiKekkaTr();
    }


    @Override
    public ZT_KykIdouHaneiKekkaTr getKykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {
        return bizNayosedisksousinDomManager.getKykIdouHaneiKekkaTr(pZtrhuho2kyknokbn, pZtrhuho2kykno);
    }


    @Override
    public ExDBResults<ZT_KykIdouHaneiKekkaRn> getAllKykIdouHaneiKekkaRn() {
        return bizNayosedisksousinDomManager.getAllKykIdouHaneiKekkaRn();
    }


    @Override
    public ZT_KykIdouHaneiKekkaRn getKykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        return bizNayosedisksousinDomManager.getKykIdouHaneiKekkaRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }



    @Override
    public ExDBResults<ZT_RatepRn> getAllRatepRn() {
        return suuridiskjyusinDomManager.getAllRatepRn();
    }


    @Override
    public ZT_RatepRn getRatepRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn) {
        return suuridiskjyusinDomManager.getRatepRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn);
    }


    @Override
    public ExDBResults<ZT_RatevRn> getAllRatevRn() {
        return suuridiskjyusinDomManager.getAllRatevRn();
    }


    @Override
    public ZT_RatevRn getRatevRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn) {
        return suuridiskjyusinDomManager.getRatevRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn);
    }


    @Override
    public ExDBResults<ZT_RatedRn> getAllRatedRn() {
        return suuridiskjyusinDomManager.getAllRatedRn();
    }


    @Override
    public ZT_RatedRn getRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        return suuridiskjyusinDomManager.getRatedRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrndnendo, pZrnnaiteikakuteikbn);
    }


    @Override
    public ExDBResults<ZT_NennkinRatepkisovRn> getAllNennkinRatepkisovRn() {
        return suuridiskjyusinDomManager.getAllNennkinRatepkisovRn();
    }


    @Override
    public ZT_NennkinRatepkisovRn getNennkinRatepkisovRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn) {
        return suuridiskjyusinDomManager.getNennkinRatepkisovRn(pZrnnenkinkbn, pZrnnenkinsyu, pZrnnenkinkigousedaikbn, pZrnnknshry, pZrnnkkaisigoyoteiriritukbn
            , pZrnnenkinjimutesuuryoukbn);
    }


    @Override
    public ExDBResults<ZT_NennkinRatedRn> getAllNennkinRatedRn() {
        return suuridiskjyusinDomManager.getAllNennkinRatedRn();
    }


    @Override
    public ZT_NennkinRatedRn getNennkinRatedRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn
        , String pZrnnenkinjimutesuuryoukbn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        return suuridiskjyusinDomManager.getNennkinRatedRn(pZrnnenkinkbn, pZrnnenkinsyu, pZrnnenkinkigousedaikbn, pZrnnknshry, pZrnnkkaisigoyoteiriritukbn
            , pZrnnenkinjimutesuuryoukbn, pZrndnendo, pZrnnaiteikakuteikbn);
    }


    @Override
    public ExDBResults<ZT_RisaHitSyouhnyouRatedRn> getAllRisaHitSyouhnyouRatedRn() {
        return suuridiskjyusinDomManager.getAllRisaHitSyouhnyouRatedRn();
    }


    @Override
    public ZT_RisaHitSyouhnyouRatedRn getRisaHitSyouhnyouRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        return suuridiskjyusinDomManager.getRisaHitSyouhnyouRatedRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrndnendo, pZrnnaiteikakuteikbn);
    }


    @Override
    public ExDBResults<ZT_Ratep2Rn> getAllRatep2Rn() {
        return suuridiskjyusinDomManager.getAllRatep2Rn();
    }


    @Override
    public ZT_Ratep2Rn getRatep2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrnryouritukbn) {
        return suuridiskjyusinDomManager.getRatep2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn, pZrnryouritukbn);
    }


    @Override
    public ExDBResults<ZT_Ratev2Rn> getAllRatev2Rn() {
        return suuridiskjyusinDomManager.getAllRatev2Rn();
    }


    @Override
    public ZT_Ratev2Rn getRatev2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {
        return suuridiskjyusinDomManager.getRatev2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn);
    }


    @Override
    public ExDBResults<ZT_RisaHitSyouhnyouRated2Rn> getAllRisaHitSyouhnyouRated2Rn() {
        return suuridiskjyusinDomManager.getAllRisaHitSyouhnyouRated2Rn();
    }


    @Override
    public ZT_RisaHitSyouhnyouRated2Rn getRisaHitSyouhnyouRated2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrndnendo
        , String pZrnnaiteikakuteikbn) {
        return suuridiskjyusinDomManager.getRisaHitSyouhnyouRated2Rn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn, pZrndnendo
            , pZrnnaiteikakuteikbn);
    }


    @Override
    public ExDBResults<ZT_RatewRn> getAllRatewRn() {
        return suuridiskjyusinDomManager.getAllRatewRn();
    }


    @Override
    public ZT_RatewRn getRatewRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn
        , String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn
        , String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {
        return suuridiskjyusinDomManager.getRatewRn(pZrnhknsyukigou, pZrnhknsyuruikigousedaikbn, pZrnyoteiriritu, pZrnpmenkbn
            , pZrnhrkkaisuukbn, pZrnhhknsei, pZrnkeiyakujihhknnen, pZrnsaimnkkykhyj, pZrnhknkkn
            , pZrnphrkkikn, pZrnannaifuyouriyuukbn, pZrntuukasyukbn, pZrndai1hknkkn);
    }



    @Override
    public ExDBResults<ZT_HoyuuMeisaiTy> getAllHoyuuMeisaiTy() {
        return suuridisksousinDomManager.getAllHoyuuMeisaiTy();
    }


    @Override
    public ZT_HoyuuMeisaiTy getHoyuuMeisaiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getHoyuuMeisaiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_HoyuuMeisaiRn> getAllHoyuuMeisaiRn() {
        return suuridisksousinDomManager.getAllHoyuuMeisaiRn();
    }


    @Override
    public ZT_HoyuuMeisaiRn getHoyuuMeisaiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getHoyuuMeisaiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_IdouMeisaiTy> getAllIdouMeisaiTy() {
        return suuridisksousinDomManager.getAllIdouMeisaiTy();
    }


    @Override
    public ZT_IdouMeisaiTy getIdouMeisaiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getIdouMeisaiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_IdouMeisaiRn> getAllIdouMeisaiRn() {
        return suuridisksousinDomManager.getAllIdouMeisaiRn();
    }


    @Override
    public ZT_IdouMeisaiRn getIdouMeisaiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getIdouMeisaiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_BikinIdouMeisaiTy> getAllBikinIdouMeisaiTy() {
        return suuridisksousinDomManager.getAllBikinIdouMeisaiTy();
    }


    @Override
    public ZT_BikinIdouMeisaiTy getBikinIdouMeisaiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getBikinIdouMeisaiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_BikinIdouMeisaiRn> getAllBikinIdouMeisaiRn() {
        return suuridisksousinDomManager.getAllBikinIdouMeisaiRn();
    }


    @Override
    public ZT_BikinIdouMeisaiRn getBikinIdouMeisaiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getBikinIdouMeisaiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr1Ty> getAllSkeiksnbsgetujisr1Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr1Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr1Ty getSkeiksnbsgetujisr1Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr1Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr1Rn> getAllSkeiksnbsgetujisr1Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr1Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr1Rn getSkeiksnbsgetujisr1Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr1Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr2Ty> getAllSkeiksnbsgetujisr2Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr2Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr2Ty getSkeiksnbsgetujisr2Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr2Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr2Rn> getAllSkeiksnbsgetujisr2Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr2Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr2Rn getSkeiksnbsgetujisr2Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr2Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr3Ty> getAllSkeiksnbsgetujisr3Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr3Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr3Ty getSkeiksnbsgetujisr3Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr3Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr3Rn> getAllSkeiksnbsgetujisr3Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr3Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr3Rn getSkeiksnbsgetujisr3Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr3Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr4Ty> getAllSkeiksnbsgetujisr4Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr4Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr4Ty getSkeiksnbsgetujisr4Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr4Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr4Rn> getAllSkeiksnbsgetujisr4Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr4Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr4Rn getSkeiksnbsgetujisr4Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr4Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr5Ty> getAllSkeiksnbsgetujisr5Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr5Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr5Ty getSkeiksnbsgetujisr5Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr5Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr5Rn> getAllSkeiksnbsgetujisr5Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr5Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr5Rn getSkeiksnbsgetujisr5Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr5Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr6Ty> getAllSkeiksnbsgetujisr6Ty() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr6Ty();
    }


    @Override
    public ZT_Skeiksnbsgetujisr6Ty getSkeiksnbsgetujisr6Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr6Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Skeiksnbsgetujisr6Rn> getAllSkeiksnbsgetujisr6Rn() {
        return suuridisksousinDomManager.getAllSkeiksnbsgetujisr6Rn();
    }


    @Override
    public ZT_Skeiksnbsgetujisr6Rn getSkeiksnbsgetujisr6Rn(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSkeiksnbsgetujisr6Rn(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_SkeisynyptoukeiksnTy> getAllSkeisynyptoukeiksnTy() {
        return suuridisksousinDomManager.getAllSkeisynyptoukeiksnTy();
    }


    @Override
    public ZT_SkeisynyptoukeiksnTy getSkeisynyptoukeiksnTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getSkeisynyptoukeiksnTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SkeisynyptoukeiksnRn> getAllSkeisynyptoukeiksnRn() {
        return suuridisksousinDomManager.getAllSkeisynyptoukeiksnRn();
    }


    @Override
    public ZT_SkeisynyptoukeiksnRn getSkeisynyptoukeiksnRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getSkeisynyptoukeiksnRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_SkeisynyptoukeirigTy> getAllSkeisynyptoukeirigTy() {
        return suuridisksousinDomManager.getAllSkeisynyptoukeirigTy();
    }


    @Override
    public ZT_SkeisynyptoukeirigTy getSkeisynyptoukeirigTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getSkeisynyptoukeirigTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SkeisynyptoukeirigRn> getAllSkeisynyptoukeirigRn() {
        return suuridisksousinDomManager.getAllSkeisynyptoukeirigRn();
    }


    @Override
    public ZT_SkeisynyptoukeirigRn getSkeisynyptoukeirigRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getSkeisynyptoukeirigRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KaiykHrSoutougakuTy> getAllKaiykHrSoutougakuTy() {
        return suuridisksousinDomManager.getAllKaiykHrSoutougakuTy();
    }


    @Override
    public ZT_KaiykHrSoutougakuTy getKaiykHrSoutougakuTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKaiykHrSoutougakuTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KaiykHrSoutougakuRn> getAllKaiykHrSoutougakuRn() {
        return suuridisksousinDomManager.getAllKaiykHrSoutougakuRn();
    }


    @Override
    public ZT_KaiykHrSoutougakuRn getKaiykHrSoutougakuRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKaiykHrSoutougakuRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusZeroTy> getAllTjHitsyyugkNplusZeroTy() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusZeroTy();
    }


    @Override
    public ZT_TjHitsyyugkNplusZeroTy getTjHitsyyugkNplusZeroTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusZeroTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusZeroRn> getAllTjHitsyyugkNplusZeroRn() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusZeroRn();
    }


    @Override
    public ZT_TjHitsyyugkNplusZeroRn getTjHitsyyugkNplusZeroRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusZeroRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusOneTy> getAllTjHitsyyugkNplusOneTy() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusOneTy();
    }


    @Override
    public ZT_TjHitsyyugkNplusOneTy getTjHitsyyugkNplusOneTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusOneTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusOneRn> getAllTjHitsyyugkNplusOneRn() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusOneRn();
    }


    @Override
    public ZT_TjHitsyyugkNplusOneRn getTjHitsyyugkNplusOneRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusOneRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusTwoTy> getAllTjHitsyyugkNplusTwoTy() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusTwoTy();
    }


    @Override
    public ZT_TjHitsyyugkNplusTwoTy getTjHitsyyugkNplusTwoTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusTwoTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusTwoRn> getAllTjHitsyyugkNplusTwoRn() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusTwoRn();
    }


    @Override
    public ZT_TjHitsyyugkNplusTwoRn getTjHitsyyugkNplusTwoRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusTwoRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNminusZeroTy> getAllTjHitsyyugkNminusZeroTy() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNminusZeroTy();
    }


    @Override
    public ZT_TjHitsyyugkNminusZeroTy getTjHitsyyugkNminusZeroTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNminusZeroTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNminusZeroRn> getAllTjHitsyyugkNminusZeroRn() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNminusZeroRn();
    }


    @Override
    public ZT_TjHitsyyugkNminusZeroRn getTjHitsyyugkNminusZeroRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNminusZeroRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusQuartTy> getAllTjHitsyyugkNplusQuartTy() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusQuartTy();
    }


    @Override
    public ZT_TjHitsyyugkNplusQuartTy getTjHitsyyugkNplusQuartTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusQuartTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TjHitsyyugkNplusQuartRn> getAllTjHitsyyugkNplusQuartRn() {
        return suuridisksousinDomManager.getAllTjHitsyyugkNplusQuartRn();
    }


    @Override
    public ZT_TjHitsyyugkNplusQuartRn getTjHitsyyugkNplusQuartRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTjHitsyyugkNplusQuartRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNplusZeroTy> getAllRisaTjHitNplusZeroTy() {
        return suuridisksousinDomManager.getAllRisaTjHitNplusZeroTy();
    }


    @Override
    public ZT_RisaTjHitNplusZeroTy getRisaTjHitNplusZeroTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNplusZeroTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNplusZeroRn> getAllRisaTjHitNplusZeroRn() {
        return suuridisksousinDomManager.getAllRisaTjHitNplusZeroRn();
    }


    @Override
    public ZT_RisaTjHitNplusZeroRn getRisaTjHitNplusZeroRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNplusZeroRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNminusZeroTy> getAllRisaTjHitNminusZeroTy() {
        return suuridisksousinDomManager.getAllRisaTjHitNminusZeroTy();
    }


    @Override
    public ZT_RisaTjHitNminusZeroTy getRisaTjHitNminusZeroTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNminusZeroTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNminusZeroRn> getAllRisaTjHitNminusZeroRn() {
        return suuridisksousinDomManager.getAllRisaTjHitNminusZeroRn();
    }


    @Override
    public ZT_RisaTjHitNminusZeroRn getRisaTjHitNminusZeroRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNminusZeroRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNplusQuartTy> getAllRisaTjHitNplusQuartTy() {
        return suuridisksousinDomManager.getAllRisaTjHitNplusQuartTy();
    }


    @Override
    public ZT_RisaTjHitNplusQuartTy getRisaTjHitNplusQuartTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNplusQuartTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RisaTjHitNplusQuartRn> getAllRisaTjHitNplusQuartRn() {
        return suuridisksousinDomManager.getAllRisaTjHitNplusQuartRn();
    }


    @Override
    public ZT_RisaTjHitNplusQuartRn getRisaTjHitNplusQuartRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRisaTjHitNplusQuartRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_SbRituRendouTy> getAllSbRituRendouTy() {
        return suuridisksousinDomManager.getAllSbRituRendouTy();
    }


    @Override
    public ZT_SbRituRendouTy getSbRituRendouTy(String pZtydatakanrino) {
        return suuridisksousinDomManager.getSbRituRendouTy(pZtydatakanrino);
    }


    @Override
    public ExDBResults<ZT_SbRituRendouRn> getAllSbRituRendouRn() {
        return suuridisksousinDomManager.getAllSbRituRendouRn();
    }


    @Override
    public ZT_SbRituRendouRn getSbRituRendouRn(String pZrndatakanrino) {
        return suuridisksousinDomManager.getSbRituRendouRn(pZrndatakanrino);
    }


    @Override
    public ExDBResults<ZT_SbRituToukeiSeibiRenTy> getAllSbRituToukeiSeibiRenTy() {
        return suuridisksousinDomManager.getAllSbRituToukeiSeibiRenTy();
    }


    @Override
    public ZT_SbRituToukeiSeibiRenTy getSbRituToukeiSeibiRenTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getSbRituToukeiSeibiRenTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SbRituToukeiSeibiRenRn> getAllSbRituToukeiSeibiRenRn() {
        return suuridisksousinDomManager.getAllSbRituToukeiSeibiRenRn();
    }


    @Override
    public ZT_SbRituToukeiSeibiRenRn getSbRituToukeiSeibiRenRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getSbRituToukeiSeibiRenRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_JigyounndsikiTkHoyuuTy> getAllJigyounndsikiTkHoyuuTy() {
        return suuridisksousinDomManager.getAllJigyounndsikiTkHoyuuTy();
    }


    @Override
    public ZT_JigyounndsikiTkHoyuuTy getJigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getJigyounndsikiTkHoyuuTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_JigyounndsikiTkHoyuuRn> getAllJigyounndsikiTkHoyuuRn() {
        return suuridisksousinDomManager.getAllJigyounndsikiTkHoyuuRn();
    }


    @Override
    public ZT_JigyounndsikiTkHoyuuRn getJigyounndsikiTkHoyuuRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getJigyounndsikiTkHoyuuRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KyhknShrJyoukyouRnrkTy> getAllKyhknShrJyoukyouRnrkTy() {
        return suuridisksousinDomManager.getAllKyhknShrJyoukyouRnrkTy();
    }


    @Override
    public ZT_KyhknShrJyoukyouRnrkTy getKyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKyhknShrJyoukyouRnrkTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KyhknShrJyoukyouRnrkRn> getAllKyhknShrJyoukyouRnrkRn() {
        return suuridisksousinDomManager.getAllKyhknShrJyoukyouRnrkRn();
    }


    @Override
    public ZT_KyhknShrJyoukyouRnrkRn getKyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKyhknShrJyoukyouRnrkRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_GkknHnkuSyrSynypTukiTy> getAllGkknHnkuSyrSynypTukiTy() {
        return suuridisksousinDomManager.getAllGkknHnkuSyrSynypTukiTy();
    }


    @Override
    public ZT_GkknHnkuSyrSynypTukiTy getGkknHnkuSyrSynypTukiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getGkknHnkuSyrSynypTukiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_GkknHnkuSyrSynypTukiRn> getAllGkknHnkuSyrSynypTukiRn() {
        return suuridisksousinDomManager.getAllGkknHnkuSyrSynypTukiRn();
    }


    @Override
    public ZT_GkknHnkuSyrSynypTukiRn getGkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getGkknHnkuSyrSynypTukiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu1Ty> getAllSp2RnduyuSouseiritu1Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu1Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu1Ty getSp2RnduyuSouseiritu1Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu1Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu1Rn> getAllSp2RnduyuSouseiritu1Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu1Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu1Rn getSp2RnduyuSouseiritu1Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu1Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu2Ty> getAllSp2RnduyuSouseiritu2Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu2Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu2Ty getSp2RnduyuSouseiritu2Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu2Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu2Rn> getAllSp2RnduyuSouseiritu2Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu2Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu2Rn getSp2RnduyuSouseiritu2Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu2Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu3Ty> getAllSp2RnduyuSouseiritu3Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu3Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu3Ty getSp2RnduyuSouseiritu3Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu3Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu3Rn> getAllSp2RnduyuSouseiritu3Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu3Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu3Rn getSp2RnduyuSouseiritu3Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu3Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu4Ty> getAllSp2RnduyuSouseiritu4Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu4Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu4Ty getSp2RnduyuSouseiritu4Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu4Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu4Rn> getAllSp2RnduyuSouseiritu4Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu4Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu4Rn getSp2RnduyuSouseiritu4Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu4Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu5Ty> getAllSp2RnduyuSouseiritu5Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu5Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu5Ty getSp2RnduyuSouseiritu5Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu5Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu5Rn> getAllSp2RnduyuSouseiritu5Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu5Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu5Rn getSp2RnduyuSouseiritu5Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu5Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu6Ty> getAllSp2RnduyuSouseiritu6Ty() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu6Ty();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu6Ty getSp2RnduyuSouseiritu6Ty(String pZtyktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu6Ty(pZtyktgysyono);
    }


    @Override
    public ExDBResults<ZT_Sp2RnduyuSouseiritu6Rn> getAllSp2RnduyuSouseiritu6Rn() {
        return suuridisksousinDomManager.getAllSp2RnduyuSouseiritu6Rn();
    }


    @Override
    public ZT_Sp2RnduyuSouseiritu6Rn getSp2RnduyuSouseiritu6Rn(String pZrnktgysyono) {
        return suuridisksousinDomManager.getSp2RnduyuSouseiritu6Rn(pZrnktgysyono);
    }


    @Override
    public ExDBResults<ZT_AlmNnknHyuTy> getAllAlmNnknHyuTy() {
        return suuridisksousinDomManager.getAllAlmNnknHyuTy();
    }


    @Override
    public ZT_AlmNnknHyuTy getAlmNnknHyuTy(String pZtynksyousyono) {
        return suuridisksousinDomManager.getAlmNnknHyuTy(pZtynksyousyono);
    }


    @Override
    public ExDBResults<ZT_AlmNnknHyuRn> getAllAlmNnknHyuRn() {
        return suuridisksousinDomManager.getAllAlmNnknHyuRn();
    }


    @Override
    public ZT_AlmNnknHyuRn getAlmNnknHyuRn(String pZrnnksyousyono) {
        return suuridisksousinDomManager.getAlmNnknHyuRn(pZrnnksyousyono);
    }


    @Override
    public ExDBResults<ZT_OuNnknShrTy> getAllOuNnknShrTy() {
        return suuridisksousinDomManager.getAllOuNnknShrTy();
    }


    @Override
    public ZT_OuNnknShrTy getOuNnknShrTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getOuNnknShrTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_OuNnknShrRn> getAllOuNnknShrRn() {
        return suuridisksousinDomManager.getAllOuNnknShrRn();
    }


    @Override
    public ZT_OuNnknShrRn getOuNnknShrRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getOuNnknShrRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkIktHriTy> getAllNkIktHriTy() {
        return suuridisksousinDomManager.getAllNkIktHriTy();
    }


    @Override
    public ZT_NkIktHriTy getNkIktHriTy(String pZtydatakanrino) {
        return suuridisksousinDomManager.getNkIktHriTy(pZtydatakanrino);
    }


    @Override
    public ExDBResults<ZT_NkIktHriRn> getAllNkIktHriRn() {
        return suuridisksousinDomManager.getAllNkIktHriRn();
    }


    @Override
    public ZT_NkIktHriRn getNkIktHriRn(String pZrndatakanrino) {
        return suuridisksousinDomManager.getNkIktHriRn(pZrndatakanrino);
    }


    @Override
    public ExDBResults<ZT_NkGensiHySgTy> getAllNkGensiHySgTy() {
        return suuridisksousinDomManager.getAllNkGensiHySgTy();
    }


    @Override
    public ZT_NkGensiHySgTy getNkGensiHySgTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkGensiHySgTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkGensiRigTy> getAllNkGensiRigTy() {
        return suuridisksousinDomManager.getAllNkGensiRigTy();
    }


    @Override
    public ZT_NkGensiRigTy getNkGensiRigTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkGensiRigTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkGensiKtyTy> getAllNkGensiKtyTy() {
        return suuridisksousinDomManager.getAllNkGensiKtyTy();
    }


    @Override
    public ZT_NkGensiKtyTy getNkGensiKtyTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkGensiKtyTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkGensiHySgRn> getAllNkGensiHySgRn() {
        return suuridisksousinDomManager.getAllNkGensiHySgRn();
    }


    @Override
    public ZT_NkGensiHySgRn getNkGensiHySgRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkGensiHySgRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkGensiRigRn> getAllNkGensiRigRn() {
        return suuridisksousinDomManager.getAllNkGensiRigRn();
    }


    @Override
    public ZT_NkGensiRigRn getNkGensiRigRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkGensiRigRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkGensiKtyRn> getAllNkGensiKtyRn() {
        return suuridisksousinDomManager.getAllNkGensiKtyRn();
    }


    @Override
    public ZT_NkGensiKtyRn getNkGensiKtyRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkGensiKtyRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiHySgTy> getAllNkToukeiHySgTy() {
        return suuridisksousinDomManager.getAllNkToukeiHySgTy();
    }


    @Override
    public ZT_NkToukeiHySgTy getNkToukeiHySgTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkToukeiHySgTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiRigTy> getAllNkToukeiRigTy() {
        return suuridisksousinDomManager.getAllNkToukeiRigTy();
    }


    @Override
    public ZT_NkToukeiRigTy getNkToukeiRigTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkToukeiRigTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiKtyTy> getAllNkToukeiKtyTy() {
        return suuridisksousinDomManager.getAllNkToukeiKtyTy();
    }


    @Override
    public ZT_NkToukeiKtyTy getNkToukeiKtyTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getNkToukeiKtyTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiHySgRn> getAllNkToukeiHySgRn() {
        return suuridisksousinDomManager.getAllNkToukeiHySgRn();
    }


    @Override
    public ZT_NkToukeiHySgRn getNkToukeiHySgRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkToukeiHySgRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiRigRn> getAllNkToukeiRigRn() {
        return suuridisksousinDomManager.getAllNkToukeiRigRn();
    }


    @Override
    public ZT_NkToukeiRigRn getNkToukeiRigRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkToukeiRigRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkToukeiKtyRn> getAllNkToukeiKtyRn() {
        return suuridisksousinDomManager.getAllNkToukeiKtyRn();
    }


    @Override
    public ZT_NkToukeiKtyRn getNkToukeiKtyRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getNkToukeiKtyRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_NkHitRigTy> getAllNkHitRigTy() {
        return suuridisksousinDomManager.getAllNkHitRigTy();
    }


    @Override
    public ZT_NkHitRigTy getNkHitRigTy(String pZtynksyousyono) {
        return suuridisksousinDomManager.getNkHitRigTy(pZtynksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitKtyTy> getAllNkHitKtyTy() {
        return suuridisksousinDomManager.getAllNkHitKtyTy();
    }


    @Override
    public ZT_NkHitKtyTy getNkHitKtyTy(String pZtynksyousyono) {
        return suuridisksousinDomManager.getNkHitKtyTy(pZtynksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitKsnTy> getAllNkHitKsnTy() {
        return suuridisksousinDomManager.getAllNkHitKsnTy();
    }


    @Override
    public ZT_NkHitKsnTy getNkHitKsnTy(String pZtynksyousyono) {
        return suuridisksousinDomManager.getNkHitKsnTy(pZtynksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitRigRn> getAllNkHitRigRn() {
        return suuridisksousinDomManager.getAllNkHitRigRn();
    }


    @Override
    public ZT_NkHitRigRn getNkHitRigRn(String pZrnnksyousyono) {
        return suuridisksousinDomManager.getNkHitRigRn(pZrnnksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitKtyRn> getAllNkHitKtyRn() {
        return suuridisksousinDomManager.getAllNkHitKtyRn();
    }


    @Override
    public ZT_NkHitKtyRn getNkHitKtyRn(String pZrnnksyousyono) {
        return suuridisksousinDomManager.getNkHitKtyRn(pZrnnksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitKsnRn> getAllNkHitKsnRn() {
        return suuridisksousinDomManager.getAllNkHitKsnRn();
    }


    @Override
    public ZT_NkHitKsnRn getNkHitKsnRn(String pZrnnksyousyono) {
        return suuridisksousinDomManager.getNkHitKsnRn(pZrnnksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitAddInfoTy> getAllNkHitAddInfoTy() {
        return suuridisksousinDomManager.getAllNkHitAddInfoTy();
    }


    @Override
    public ZT_NkHitAddInfoTy getNkHitAddInfoTy(String pZtynksyousyono) {
        return suuridisksousinDomManager.getNkHitAddInfoTy(pZtynksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkHitAddInfoRn> getAllNkHitAddInfoRn() {
        return suuridisksousinDomManager.getAllNkHitAddInfoRn();
    }


    @Override
    public ZT_NkHitAddInfoRn getNkHitAddInfoRn(String pZrnnksyousyono) {
        return suuridisksousinDomManager.getNkHitAddInfoRn(pZrnnksyousyono);
    }


    @Override
    public ExDBResults<ZT_NkBikinTy> getAllNkBikinTy() {
        return suuridisksousinDomManager.getAllNkBikinTy();
    }


    @Override
    public ZT_NkBikinTy getNkBikinTy(String pZtynksyousyono, String pZtyshiharaihasseiymd) {
        return suuridisksousinDomManager.getNkBikinTy(pZtynksyousyono, pZtyshiharaihasseiymd);
    }


    @Override
    public ExDBResults<ZT_NkBikinRn> getAllNkBikinRn() {
        return suuridisksousinDomManager.getAllNkBikinRn();
    }


    @Override
    public ZT_NkBikinRn getNkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd) {
        return suuridisksousinDomManager.getNkBikinRn(pZrnnksyousyono, pZrnshiharaihasseiymd);
    }


    @Override
    public ExDBResults<ZT_SkKsnKaikeiTorihikiTy> getAllSkKsnKaikeiTorihikiTy() {
        return suuridisksousinDomManager.getAllSkKsnKaikeiTorihikiTy();
    }


    @Override
    public ZT_SkKsnKaikeiTorihikiTy getSkKsnKaikeiTorihikiTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd) {
        return suuridisksousinDomManager.getSkKsnKaikeiTorihikiTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumon, pZtytekiyoucd);
    }


    @Override
    public ExDBResults<ZT_SkKsnKaikeiTorihikiRn> getAllSkKsnKaikeiTorihikiRn() {
        return suuridisksousinDomManager.getAllSkKsnKaikeiTorihikiRn();
    }


    @Override
    public ZT_SkKsnKaikeiTorihikiRn getSkKsnKaikeiTorihikiRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd) {
        return suuridisksousinDomManager.getSkKsnKaikeiTorihikiRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumon, pZrntekiyoucd);
    }


    @Override
    public ExDBResults<ZT_SkKsnKubunKeiriTy> getAllSkKsnKubunKeiriTy() {
        return suuridisksousinDomManager.getAllSkKsnKubunKeiriTy();
    }


    @Override
    public ZT_SkKsnKubunKeiriTy getSkKsnKubunKeiriTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        return suuridisksousinDomManager.getSkKsnKubunKeiriTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    @Override
    public ExDBResults<ZT_SkKsnKubunKeiriRn> getAllSkKsnKubunKeiriRn() {
        return suuridisksousinDomManager.getAllSkKsnKubunKeiriRn();
    }


    @Override
    public ZT_SkKsnKubunKeiriRn getSkKsnKubunKeiriRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        return suuridisksousinDomManager.getSkKsnKubunKeiriRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    @Override
    public ExDBResults<ZT_SkKsnHurikaeTy> getAllSkKsnHurikaeTy() {
        return suuridisksousinDomManager.getAllSkKsnHurikaeTy();
    }


    @Override
    public ZT_SkKsnHurikaeTy getSkKsnHurikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return suuridisksousinDomManager.getSkKsnHurikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkKsnHurikaeHikaeTy> getAllSkKsnHurikaeHikaeTy() {
        return suuridisksousinDomManager.getAllSkKsnHurikaeHikaeTy();
    }


    @Override
    public ZT_SkKsnHurikaeHikaeTy getSkKsnHurikaeHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {
        return suuridisksousinDomManager.getSkKsnHurikaeHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkKsnHurikaeRn> getAllSkKsnHurikaeRn() {
        return suuridisksousinDomManager.getAllSkKsnHurikaeRn();
    }


    @Override
    public ZT_SkKsnHurikaeRn getSkKsnHurikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return suuridisksousinDomManager.getSkKsnHurikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_SkKsnHurikaeHikaeRn> getAllSkKsnHurikaeHikaeRn() {
        return suuridisksousinDomManager.getAllSkKsnHurikaeHikaeRn();
    }


    @Override
    public ZT_SkKsnHurikaeHikaeRn getSkKsnHurikaeHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {
        return suuridisksousinDomManager.getSkKsnHurikaeHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    @Override
    public ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuTy> getAllSrKbkSsuRnduHknVKnsyuyuTy() {
        return suuridisksousinDomManager.getAllSrKbkSsuRnduHknVKnsyuyuTy();
    }


    @Override
    public ZT_SrKbkSsuRnduHknVKnsyuyuTy getSrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getSrKbkSsuRnduHknVKnsyuyuTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuRn> getAllSrKbkSsuRnduHknVKnsyuyuRn() {
        return suuridisksousinDomManager.getAllSrKbkSsuRnduHknVKnsyuyuRn();
    }


    @Override
    public ZT_SrKbkSsuRnduHknVKnsyuyuRn getSrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getSrKbkSsuRnduHknVKnsyuyuRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiTy> getAllKsnKbkSsuRnduHknJigyohiTy() {
        return suuridisksousinDomManager.getAllKsnKbkSsuRnduHknJigyohiTy();
    }


    @Override
    public ZT_KsnKbkSsuRnduHknJigyohiTy getKsnKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKsnKbkSsuRnduHknJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiRn> getAllKsnKbkSsuRnduHknJigyohiRn() {
        return suuridisksousinDomManager.getAllKsnKbkSsuRnduHknJigyohiRn();
    }


    @Override
    public ZT_KsnKbkSsuRnduHknJigyohiRn getKsnKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKsnKbkSsuRnduHknJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknKimatuVTy> getAllKbkSsuRnduHknKimatuVTy() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknKimatuVTy();
    }


    @Override
    public ZT_KbkSsuRnduHknKimatuVTy getKbkSsuRnduHknKimatuVTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknKimatuVTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknKimatuVRn> getAllKbkSsuRnduHknKimatuVRn() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknKimatuVRn();
    }


    @Override
    public ZT_KbkSsuRnduHknKimatuVRn getKbkSsuRnduHknKimatuVRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknKimatuVRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknJigyohiTy> getAllKbkSsuRnduHknJigyohiTy() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknJigyohiTy();
    }


    @Override
    public ZT_KbkSsuRnduHknJigyohiTy getKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknJigyohiRn> getAllKbkSsuRnduHknJigyohiRn() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknJigyohiRn();
    }


    @Override
    public ZT_KbkSsuRnduHknJigyohiRn getKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknIdouVTy> getAllKbkSsuRnduHknIdouVTy() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknIdouVTy();
    }


    @Override
    public ZT_KbkSsuRnduHknIdouVTy getKbkSsuRnduHknIdouVTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknIdouVTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KbkSsuRnduHknIdouVRn> getAllKbkSsuRnduHknIdouVRn() {
        return suuridisksousinDomManager.getAllKbkSsuRnduHknIdouVRn();
    }


    @Override
    public ZT_KbkSsuRnduHknIdouVRn getKbkSsuRnduHknIdouVRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKbkSsuRnduHknIdouVRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknJigyohiRn> getAllRrtHndugtHknJigyohiRn() {
        return suuridisksousinDomManager.getAllRrtHndugtHknJigyohiRn();
    }


    @Override
    public ZT_RrtHndugtHknJigyohiRn getRrtHndugtHknJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknJigyohiTy> getAllRrtHndugtHknJigyohiTy() {
        return suuridisksousinDomManager.getAllRrtHndugtHknJigyohiTy();
    }


    @Override
    public ZT_RrtHndugtHknJigyohiTy getRrtHndugtHknJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknKsnJigyohiRn> getAllRrtHndugtHknKsnJigyohiRn() {
        return suuridisksousinDomManager.getAllRrtHndugtHknKsnJigyohiRn();
    }


    @Override
    public ZT_RrtHndugtHknKsnJigyohiRn getRrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknKsnJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknKsnJigyohiTy> getAllRrtHndugtHknKsnJigyohiTy() {
        return suuridisksousinDomManager.getAllRrtHndugtHknKsnJigyohiTy();
    }


    @Override
    public ZT_RrtHndugtHknKsnJigyohiTy getRrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknKsnJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknVKnsyuyuRn> getAllRrtHndugtHknVKnsyuyuRn() {
        return suuridisksousinDomManager.getAllRrtHndugtHknVKnsyuyuRn();
    }


    @Override
    public ZT_RrtHndugtHknVKnsyuyuRn getRrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknVKnsyuyuRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RrtHndugtHknVKnsyuyuTy> getAllRrtHndugtHknVKnsyuyuTy() {
        return suuridisksousinDomManager.getAllRrtHndugtHknVKnsyuyuTy();
    }


    @Override
    public ZT_RrtHndugtHknVKnsyuyuTy getRrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRrtHndugtHknVKnsyuyuTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_ZitkAzukarikinSrRendouRn> getAllZitkAzukarikinSrRendouRn() {
        return suuridisksousinDomManager.getAllZitkAzukarikinSrRendouRn();
    }


    @Override
    public ZT_ZitkAzukarikinSrRendouRn getZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getZitkAzukarikinSrRendouRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_ZitkAzukarikinSrRendouTy> getAllZitkAzukarikinSrRendouTy() {
        return suuridisksousinDomManager.getAllZitkAzukarikinSrRendouTy();
    }


    @Override
    public ZT_ZitkAzukarikinSrRendouTy getZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getZitkAzukarikinSrRendouTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_TmttHaitoukinMeisaiRn> getAllTmttHaitoukinMeisaiRn() {
        return suuridisksousinDomManager.getAllTmttHaitoukinMeisaiRn();
    }


    @Override
    public ZT_TmttHaitoukinMeisaiRn getTmttHaitoukinMeisaiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getTmttHaitoukinMeisaiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_TmttHaitoukinMeisaiTy> getAllTmttHaitoukinMeisaiTy() {
        return suuridisksousinDomManager.getAllTmttHaitoukinMeisaiTy();
    }


    @Override
    public ZT_TmttHaitoukinMeisaiTy getTmttHaitoukinMeisaiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getTmttHaitoukinMeisaiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KariwariateHtkinMeisaiRn> getAllKariwariateHtkinMeisaiRn() {
        return suuridisksousinDomManager.getAllKariwariateHtkinMeisaiRn();
    }


    @Override
    public ZT_KariwariateHtkinMeisaiRn getKariwariateHtkinMeisaiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKariwariateHtkinMeisaiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KariwariateHtkinMeisaiTy> getAllKariwariateHtkinMeisaiTy() {
        return suuridisksousinDomManager.getAllKariwariateHtkinMeisaiTy();
    }


    @Override
    public ZT_KariwariateHtkinMeisaiTy getKariwariateHtkinMeisaiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKariwariateHtkinMeisaiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_BikinKeiyakuSeisandRn> getAllBikinKeiyakuSeisandRn() {
        return suuridisksousinDomManager.getAllBikinKeiyakuSeisandRn();
    }


    @Override
    public ZT_BikinKeiyakuSeisandRn getBikinKeiyakuSeisandRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getBikinKeiyakuSeisandRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_BikinKeiyakuSeisandTy> getAllBikinKeiyakuSeisandTy() {
        return suuridisksousinDomManager.getAllBikinKeiyakuSeisandTy();
    }


    @Override
    public ZT_BikinKeiyakuSeisandTy getBikinKeiyakuSeisandTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getBikinKeiyakuSeisandTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_DshrToukeiRn> getAllDshrToukeiRn() {
        return suuridisksousinDomManager.getAllDshrToukeiRn();
    }


    @Override
    public ZT_DshrToukeiRn getDshrToukeiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getDshrToukeiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_DshrToukeiTy> getAllDshrToukeiTy() {
        return suuridisksousinDomManager.getAllDshrToukeiTy();
    }


    @Override
    public ZT_DshrToukeiTy getDshrToukeiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getDshrToukeiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_DshrToukeiLoadingRn> getAllDshrToukeiLoadingRn() {
        return suuridisksousinDomManager.getAllDshrToukeiLoadingRn();
    }


    @Override
    public ZT_DshrToukeiLoadingRn getDshrToukeiLoadingRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getDshrToukeiLoadingRn(pZrnsequenceno);
    }

    @Override
    public ExDBResults<ZT_RayVKnsyuyuTy> getAllRayVKnsyuyuTy() {
        return suuridisksousinDomManager.getAllRayVKnsyuyuTy();
    }


    @Override
    public ZT_RayVKnsyuyuTy getRayVKnsyuyuTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRayVKnsyuyuTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RayVKnsyuyuRn> getAllRayVKnsyuyuRn() {
        return suuridisksousinDomManager.getAllRayVKnsyuyuRn();
    }


    @Override
    public ZT_RayVKnsyuyuRn getRayVKnsyuyuRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRayVKnsyuyuRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RayKimatuVTy> getAllRayKimatuVTy() {
        return suuridisksousinDomManager.getAllRayKimatuVTy();
    }


    @Override
    public ZT_RayKimatuVTy getRayKimatuVTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRayKimatuVTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RayKimatuVRn> getAllRayKimatuVRn() {
        return suuridisksousinDomManager.getAllRayKimatuVRn();
    }


    @Override
    public ZT_RayKimatuVRn getRayKimatuVRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRayKimatuVRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RayIdouVTy> getAllRayIdouVTy() {
        return suuridisksousinDomManager.getAllRayIdouVTy();
    }


    @Override
    public ZT_RayIdouVTy getRayIdouVTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRayIdouVTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RayIdouVRn> getAllRayIdouVRn() {
        return suuridisksousinDomManager.getAllRayIdouVRn();
    }


    @Override
    public ZT_RayIdouVRn getRayIdouVRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRayIdouVRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_RayJigyohiTy> getAllRayJigyohiTy() {
        return suuridisksousinDomManager.getAllRayJigyohiTy();
    }


    @Override
    public ZT_RayJigyohiTy getRayJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getRayJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_RayJigyohiRn> getAllRayJigyohiRn() {
        return suuridisksousinDomManager.getAllRayJigyohiRn();
    }


    @Override
    public ZT_RayJigyohiRn getRayJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getRayJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_KsnRayJigyohiTy> getAllKsnRayJigyohiTy() {
        return suuridisksousinDomManager.getAllKsnRayJigyohiTy();
    }


    @Override
    public ZT_KsnRayJigyohiTy getKsnRayJigyohiTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getKsnRayJigyohiTy(pZtysequenceno);
    }


    @Override
    public ExDBResults<ZT_KsnRayJigyohiRn> getAllKsnRayJigyohiRn() {
        return suuridisksousinDomManager.getAllKsnRayJigyohiRn();
    }


    @Override
    public ZT_KsnRayJigyohiRn getKsnRayJigyohiRn(Integer pZrnsequenceno) {
        return suuridisksousinDomManager.getKsnRayJigyohiRn(pZrnsequenceno);
    }


    @Override
    public ExDBResults<ZT_DshrToukeiLoadingTy> getAllDshrToukeiLoadingTy() {
        return suuridisksousinDomManager.getAllDshrToukeiLoadingTy();
    }


    @Override
    public ZT_DshrToukeiLoadingTy getDshrToukeiLoadingTy(Integer pZtysequenceno) {
        return suuridisksousinDomManager.getDshrToukeiLoadingTy(pZtysequenceno);
    }



    @Override
    public ExDBResults<ZT_TokuteiKankeiHoujinRn> getAllTokuteiKankeiHoujinRn() {
        return sinkeiyakudiskjyusinDomManager.getAllTokuteiKankeiHoujinRn();
    }


    @Override
    public ZT_TokuteiKankeiHoujinRn getTokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {
        return sinkeiyakudiskjyusinDomManager.getTokuteiKankeiHoujinRn(pZrnkinyuukikancd, pZrnmeisaibangou);
    }


    @Override
    public ExDBResults<ZT_SmbcBosRn> getAllSmbcBosRn() {
        return sinkeiyakudiskjyusinDomManager.getAllSmbcBosRn();
    }


    @Override
    public ZT_SmbcBosRn getSmbcBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {
        return sinkeiyakudiskjyusinDomManager.getSmbcBosRn(pZrnseihowebidkbn, pZrnseihowebkojincd, pZrnseihowebitijihozonhyouji, pZrnseihowebsekno);
    }


    @Override
    public ExDBResults<ZT_SmbcBosTr> getAllSmbcBosTr() {
        return sinkeiyakudiskjyusinDomManager.getAllSmbcBosTr();
    }


    @Override
    public ZT_SmbcBosTr getSmbcBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {
        return sinkeiyakudiskjyusinDomManager.getSmbcBosTr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebsekno);
    }


    @Override
    public ExDBResults<ZT_SmbcBosTr> getSmbcBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo) {
        return sinkeiyakudiskjyusinDomManager.getSmbcBosTrsByKakutyoujobcdItems(pKakutyoujobcd, pZtrseihowebitijihozonhyouji, pZtrseihowebmosprtzmhyj, pFstmossksymdFrom
            , pFstmossksymdTo);
    }


    @Override
    public ExDBResults<ZT_TiginSinkinBosRn> getAllTiginSinkinBosRn() {
        return sinkeiyakudiskjyusinDomManager.getAllTiginSinkinBosRn();
    }


    @Override
    public ZT_TiginSinkinBosRn getTiginSinkinBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {
        return sinkeiyakudiskjyusinDomManager.getTiginSinkinBosRn(pZrnseihowebidkbn, pZrnseihowebkojincd, pZrnseihowebitijihozonhyouji, pZrnseihowebsekno);
    }


    @Override
    public ExDBResults<ZT_TiginSinkinBosTr> getAllTiginSinkinBosTr() {
        return sinkeiyakudiskjyusinDomManager.getAllTiginSinkinBosTr();
    }


    @Override
    public ZT_TiginSinkinBosTr getTiginSinkinBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {
        return sinkeiyakudiskjyusinDomManager.getTiginSinkinBosTr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebsekno);
    }


    @Override
    public ExDBResults<ZT_TiginSinkinBosTr> getTiginSinkinBosTrsByKakutyoujobcdItems(String pKakutyoujobcd, String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom
        , String pFstmossksymdTo) {
        return sinkeiyakudiskjyusinDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems(pKakutyoujobcd, pZtrseihowebitijihozonhyouji, pZtrseihowebmosprtzmhyj, pFstmossksymdFrom
            , pFstmossksymdTo);
    }


    @Override
    public ExDBResults<ZT_SmbcPaperlessMos1Tr> getAllSmbcPaperlessMos1Tr() {
        return sinkeiyakudiskjyusinDomManager.getAllSmbcPaperlessMos1Tr();
    }


    @Override
    public ZT_SmbcPaperlessMos1Tr getSmbcPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        return sinkeiyakudiskjyusinDomManager.getSmbcPaperlessMos1Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    @Override
    public ExDBResults<ZT_SmbcPaperlessMos1Tr> getSmbcPaperlessMos1TrsByKakutyoujobcd(String pKakutyoujobcd) {
        return sinkeiyakudiskjyusinDomManager.getSmbcPaperlessMos1TrsByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<ZT_SmbcPaperlessMos2Tr> getAllSmbcPaperlessMos2Tr() {
        return sinkeiyakudiskjyusinDomManager.getAllSmbcPaperlessMos2Tr();
    }


    @Override
    public ZT_SmbcPaperlessMos2Tr getSmbcPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        return sinkeiyakudiskjyusinDomManager.getSmbcPaperlessMos2Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    @Override
    public ExDBResults<ZT_SmbcPaperlessMos2Tr> getSmbcPaperlessMos2TrsByKakutyoujobcd(String pKakutyoujobcd) {
        return sinkeiyakudiskjyusinDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public Long getTokuteiKankeiHoujinRnCount() {
        return sinkeiyakudiskjyusinDomManager.getTokuteiKankeiHoujinRnCount();
    }


    @Override
    public ExDBResults<ZT_IjiToukeiIdouInfoTr> getIjiToukeiIdouInfoTrsByKakutyoujobcd(String pKakutyoujobcd) {
        return sinkeiyakudiskjyusinDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<ZT_HanyouPaperlessMos1Tr> getAllHanyouPaperlessMos1Tr() {
        return sinkeiyakudiskjyusinDomManager.getAllHanyouPaperlessMos1Tr();
    }


    @Override
    public ZT_HanyouPaperlessMos1Tr getHanyouPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        return sinkeiyakudiskjyusinDomManager.getHanyouPaperlessMos1Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    @Override
    public ExDBResults<ZT_HanyouPaperlessMos2Tr> getAllHanyouPaperlessMos2Tr() {
        return sinkeiyakudiskjyusinDomManager.getAllHanyouPaperlessMos2Tr();
    }


    @Override
    public ZT_HanyouPaperlessMos2Tr getHanyouPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        return sinkeiyakudiskjyusinDomManager.getHanyouPaperlessMos2Tr(pZtrseihowebidkbn, pZtrseihowebkojincd, pZtrseihowebitijihozonhyouji, pZtrseihowebseknoc);
    }


    @Override
    public ExDBResults<ZT_SkCreditTourokukekkaQrRn> getAllSkCreditTourokukekkaQrRn() {
        return sinkeiyakudiskjyusinDomManager.getAllSkCreditTourokukekkaQrRn();
    }


    @Override
    public ZT_SkCreditTourokukekkaQrRn getSkCreditTourokukekkaQrRn(String pZrnsystemjyusinymd, String pZrnsystemjyusintime, String pZrncreditkessaiyouno) {
        return sinkeiyakudiskjyusinDomManager.getSkCreditTourokukekkaQrRn(pZrnsystemjyusinymd, pZrnsystemjyusintime, pZrncreditkessaiyouno);
    }


    @Override
    public ExDBResults<ZT_SkCreditTourokukekkaQrTr> getAllSkCreditTourokukekkaQrTr() {
        return sinkeiyakudiskjyusinDomManager.getAllSkCreditTourokukekkaQrTr();
    }


    @Override
    public ZT_SkCreditTourokukekkaQrTr getSkCreditTourokukekkaQrTr(String pZtrsystemjyusinymd, String pZtrsystemjyusintime, String pZtrcreditkessaiyouno) {
        return sinkeiyakudiskjyusinDomManager.getSkCreditTourokukekkaQrTr(pZtrsystemjyusinymd, pZtrsystemjyusintime, pZtrcreditkessaiyouno);
    }


    @Override
    public ExDBResults<ZT_FstpUriageSeikyuuKekkaRn> getAllFstpUriageSeikyuuKekkaRn() {
        return sinkeiyakudiskjyusinDomManager.getAllFstpUriageSeikyuuKekkaRn();
    }


    @Override
    public ZT_FstpUriageSeikyuuKekkaRn getFstpUriageSeikyuuKekkaRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk) {
        return sinkeiyakudiskjyusinDomManager.getFstpUriageSeikyuuKekkaRn(pZrnuriageymd6keta, pZrncreditkessaiyouno, pZrnsyono, pZrnrecordno, pZrnseikyuukngk);
    }


    @Override
    public ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> getAllFstpUriageSeikyuuKekkaTr() {
        return sinkeiyakudiskjyusinDomManager.getAllFstpUriageSeikyuuKekkaTr();
    }


    @Override
    public ZT_FstpUriageSeikyuuKekkaTr getFstpUriageSeikyuuKekkaTr(String pZtruriageymd6keta, String pZtrcreditkessaiyouno, String pZtrsyono, String pZtrrecordno, Long pZtrseikyuukngk) {
        return sinkeiyakudiskjyusinDomManager.getFstpUriageSeikyuuKekkaTr(pZtruriageymd6keta, pZtrcreditkessaiyouno, pZtrsyono, pZtrrecordno, pZtrseikyuukngk);
    }


    @Override
    public ExDBResults<ZT_SkKouhuriUkTrkkekkaRn> getAllSkKouhuriUkTrkkekkaRn() {
        return sinkeiyakudiskjyusinDomManager.getAllSkKouhuriUkTrkkekkaRn();
    }


    @Override
    public ZT_SkKouhuriUkTrkkekkaRn getSkKouhuriUkTrkkekkaRn(String pZrnsyukkncd, String pZrnkinyuukikancd8keta, String pZrnkinyuukkntratkiymd, String pZrnkinyuukkntratkitime
        , String pZrnkouhuriokyakusamano) {
        return sinkeiyakudiskjyusinDomManager.getSkKouhuriUkTrkkekkaRn(pZrnsyukkncd, pZrnkinyuukikancd8keta, pZrnkinyuukkntratkiymd, pZrnkinyuukkntratkitime
            , pZrnkouhuriokyakusamano);
    }


    @Override
    public ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> getAllSkKouhuriUkTrkkekkaTr() {
        return sinkeiyakudiskjyusinDomManager.getAllSkKouhuriUkTrkkekkaTr();
    }


    @Override
    public ZT_SkKouhuriUkTrkkekkaTr getSkKouhuriUkTrkkekkaTr(String pZtrsyukkncd, String pZtrkinyuukikancd8keta, String pZtrkinyuukkntratkiymd, String pZtrkinyuukkntratkitime
        , String pZtrkouhuriokyakusamano) {
        return sinkeiyakudiskjyusinDomManager.getSkKouhuriUkTrkkekkaTr(pZtrsyukkncd, pZtrkinyuukikancd8keta, pZtrkinyuukkntratkiymd, pZtrkinyuukkntratkitime
            , pZtrkouhuriokyakusamano);
    }



    @Override
    public ExDBResults<ZT_IjiToukeiIdouInfoRn> getAllIjiToukeiIdouInfoRn() {
        return sinkeiyakuijitokeijyusinDomManager.getAllIjiToukeiIdouInfoRn();
    }


    @Override
    public ZT_IjiToukeiIdouInfoRn getIjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {
        return sinkeiyakuijitokeijyusinDomManager.getIjiToukeiIdouInfoRn(pZrnsyono, pZrnkykmfksnctr);
    }


    @Override
    public ExDBResults<ZT_IjiToukeiIdouInfoTr> getAllIjiToukeiIdouInfoTr() {
        return sinkeiyakuijitokeijyusinDomManager.getAllIjiToukeiIdouInfoTr();
    }


    @Override
    public ZT_IjiToukeiIdouInfoTr getIjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {
        return sinkeiyakuijitokeijyusinDomManager.getIjiToukeiIdouInfoTr(pZtrsyono, pZtrkykmfksnctr);
    }



    @Override
    public ExDBResults<ZT_DrtenIpToukeiTy> getAllDrtenIpToukeiTy() {
        return sinkeiyakujyohososinDomManager.getAllDrtenIpToukeiTy();
    }


    @Override
    public ZT_DrtenIpToukeiTy getDrtenIpToukeiTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosym, String pZtymosno) {
        return sinkeiyakujyohososinDomManager.getDrtenIpToukeiTy(pZtyeigyouhonbusisyacd, pZtysosikicd, pZtyatukaikojincd, pZtymosym, pZtymosno);
    }


    @Override
    public ExDBResults<ZT_DrtenIpToukeiRn> getAllDrtenIpToukeiRn() {
        return sinkeiyakujyohososinDomManager.getAllDrtenIpToukeiRn();
    }


    @Override
    public ZT_DrtenIpToukeiRn getDrtenIpToukeiRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosym, String pZrnmosno) {
        return sinkeiyakujyohososinDomManager.getDrtenIpToukeiRn(pZrneigyouhonbusisyacd, pZrnsosikicd, pZrnatukaikojincd, pZrnmosym, pZrnmosno);
    }


    @Override
    public ExDBResults<ZT_SkSeirituRituTy> getAllSkSeirituRituTy() {
        return sinkeiyakujyohososinDomManager.getAllSkSeirituRituTy();
    }


    @Override
    public ZT_SkSeirituRituTy getSkSeirituRituTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosno) {
        return sinkeiyakujyohososinDomManager.getSkSeirituRituTy(pZtyeigyouhonbusisyacd, pZtysosikicd, pZtyatukaikojincd, pZtymosno);
    }


    @Override
    public ExDBResults<ZT_SkSeirituRituRn> getAllSkSeirituRituRn() {
        return sinkeiyakujyohososinDomManager.getAllSkSeirituRituRn();
    }


    @Override
    public ZT_SkSeirituRituRn getSkSeirituRituRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosno) {
        return sinkeiyakujyohososinDomManager.getSkSeirituRituRn(pZrneigyouhonbusisyacd, pZrnsosikicd, pZrnatukaikojincd, pZrnmosno);
    }


    @Override
    public ExDBResults<ZT_MosJkItiranSyoukaiTy> getAllMosJkItiranSyoukaiTy() {
        return sinkeiyakujyohososinDomManager.getAllMosJkItiranSyoukaiTy();
    }


    @Override
    public ZT_MosJkItiranSyoukaiTy getMosJkItiranSyoukaiTy(String pZtymosym, String pZtymosno, String pZtybsydrtencd, String pZtyatukaikojincd) {
        return sinkeiyakujyohososinDomManager.getMosJkItiranSyoukaiTy(pZtymosym, pZtymosno, pZtybsydrtencd, pZtyatukaikojincd);
    }


    @Override
    public ExDBResults<ZT_MosJkItiranSyoukaiRn> getAllMosJkItiranSyoukaiRn() {
        return sinkeiyakujyohososinDomManager.getAllMosJkItiranSyoukaiRn();
    }


    @Override
    public ZT_MosJkItiranSyoukaiRn getMosJkItiranSyoukaiRn(String pZrnmosym, String pZrnmosno, String pZrnbsydrtencd, String pZrnatukaikojincd) {
        return sinkeiyakujyohososinDomManager.getMosJkItiranSyoukaiRn(pZrnmosym, pZrnmosno, pZrnbsydrtencd, pZrnatukaikojincd);
    }


    @Override
    public ExDBResults<ZT_SeirituInfoTy> getAllSeirituInfoTy() {
        return sinkeiyakujyohososinDomManager.getAllSeirituInfoTy();
    }


    @Override
    public ZT_SeirituInfoTy getSeirituInfoTy(String pZtykijyunym, String pZtymosno) {
        return sinkeiyakujyohososinDomManager.getSeirituInfoTy(pZtykijyunym, pZtymosno);
    }


    @Override
    public ExDBResults<ZT_SeirituInfoRn> getAllSeirituInfoRn() {
        return sinkeiyakujyohososinDomManager.getAllSeirituInfoRn();
    }


    @Override
    public ZT_SeirituInfoRn getSeirituInfoRn(String pZrnkijyunym, String pZrnmosno) {
        return sinkeiyakujyohososinDomManager.getSeirituInfoRn(pZrnkijyunym, pZrnmosno);
    }


    @Override
    public ExDBResults<ZT_HonsyaToukeiTy> getAllHonsyaToukeiTy() {
        return sinkeiyakujyohososinDomManager.getAllHonsyaToukeiTy();
    }


    @Override
    public ZT_HonsyaToukeiTy getHonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {
        return sinkeiyakujyohososinDomManager.getHonsyaToukeiTy(pZtykijyunym, pZtymosno);
    }


    @Override
    public ExDBResults<ZT_HonsyaToukeiRn> getAllHonsyaToukeiRn() {
        return sinkeiyakujyohososinDomManager.getAllHonsyaToukeiRn();
    }


    @Override
    public ZT_HonsyaToukeiRn getHonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {
        return sinkeiyakujyohososinDomManager.getHonsyaToukeiRn(pZrnkijyunym, pZrnmosno);
    }


    @Override
    public ExDBResults<ZT_FstpUriageSeikyuuDataTy> getAllFstpUriageSeikyuuDataTy() {
        return sinkeiyakujyohososinDomManager.getAllFstpUriageSeikyuuDataTy();
    }


    @Override
    public ZT_FstpUriageSeikyuuDataTy getFstpUriageSeikyuuDataTy(String pZtyuriageymd6keta, String pZtycreditkessaiyouno, String pZtysyono, String pZtyrecordno, Long pZtyseikyuukngk11keta) {
        return sinkeiyakujyohososinDomManager.getFstpUriageSeikyuuDataTy(pZtyuriageymd6keta, pZtycreditkessaiyouno, pZtysyono, pZtyrecordno, pZtyseikyuukngk11keta);
    }


    @Override
    public ExDBResults<ZT_FstpUriageSeikyuuDataRn> getAllFstpUriageSeikyuuDataRn() {
        return sinkeiyakujyohososinDomManager.getAllFstpUriageSeikyuuDataRn();
    }


    @Override
    public ZT_FstpUriageSeikyuuDataRn getFstpUriageSeikyuuDataRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk11keta) {
        return sinkeiyakujyohososinDomManager.getFstpUriageSeikyuuDataRn(pZrnuriageymd6keta, pZrncreditkessaiyouno, pZrnsyono, pZrnrecordno, pZrnseikyuukngk11keta);
    }



    @Override
    public ExDBResults<ZT_IsaToukeiDataTy> getAllIsaToukeiDataTy() {
        return sinkeiyakuijitokeisosinDomManager.getAllIsaToukeiDataTy();
    }


    @Override
    public ZT_IsaToukeiDataTy getIsaToukeiDataTy(String pZtymosno) {
        return sinkeiyakuijitokeisosinDomManager.getIsaToukeiDataTy(pZtymosno);
    }


    @Override
    public ExDBResults<ZT_IsaToukeiDataRn> getAllIsaToukeiDataRn() {
        return sinkeiyakuijitokeisosinDomManager.getAllIsaToukeiDataRn();
    }


    @Override
    public ZT_IsaToukeiDataRn getIsaToukeiDataRn(String pZrnmosno) {
        return sinkeiyakuijitokeisosinDomManager.getIsaToukeiDataRn(pZrnmosno);
    }


    @Override
    public ExDBResults<ZT_SyuSibouToukeiTy> getAllSyuSibouToukeiTy() {
        return sinkeiyakuijitokeisosinDomManager.getAllSyuSibouToukeiTy();
    }


    @Override
    public ZT_SyuSibouToukeiTy getSyuSibouToukeiTy(String pZtysyono) {
        return sinkeiyakuijitokeisosinDomManager.getSyuSibouToukeiTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SyuSibouToukeiRn> getAllSyuSibouToukeiRn() {
        return sinkeiyakuijitokeisosinDomManager.getAllSyuSibouToukeiRn();
    }


    @Override
    public ZT_SyuSibouToukeiRn getSyuSibouToukeiRn(String pZrnsyono) {
        return sinkeiyakuijitokeisosinDomManager.getSyuSibouToukeiRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_SyuHukugouSikkanDataTy> getAllSyuHukugouSikkanDataTy() {
        return sinkeiyakuijitokeisosinDomManager.getAllSyuHukugouSikkanDataTy();
    }


    @Override
    public ZT_SyuHukugouSikkanDataTy getSyuHukugouSikkanDataTy(String pZtyijitoukeidaihyousyurui, String pZtykeiyakunendo, String pZtyhknnendo, String pZtyhhknseikbn
        , String pZtykykage, String pZtytoutatunenrei, String pZtyatukaibetu, String pZtysinsahouhou, String pZtyketteikekkakbn
        , String pZtysibousrank, String pZtyjissituhosyousrank, String pZtysirajikykkbn, String pZtyhrkhuhukbn
        , String pZtyhknsyurui2keta, String pZtydaisiincd, String pZtytyuusiincd, String pZtysyousiincd, String pZtynenreihousikikbn
        , String pZtysykgycd, String pZtytodouhukencd, String pZtybotaisisyaeigyouhonbu, String pZtysisyaeigyoubu
        , String pZtyaatukaisosikicd, String pZtynensyuukbn, String pZtyhanbaikeirokbn, String pZtyoyadairitencd
        , String pZtytratkidrtencd, String pZtybsudirtnatkikeitaikbn, String pZtykyktuuka, String pZtyhrktuuka
        , String pZtyhknsyukigou, String pZtysyksbyensitihsyutyhkumu, String pZtyjyudkaigomehrtkhkumu, String pZtyijitoukeizennoukbn
        , String pZtydai1hknkkn, String pZtyijitoukeitikshrtkykkbn) {
        return sinkeiyakuijitokeisosinDomManager.getSyuHukugouSikkanDataTy(pZtyijitoukeidaihyousyurui, pZtykeiyakunendo, pZtyhknnendo, pZtyhhknseikbn
            , pZtykykage, pZtytoutatunenrei, pZtyatukaibetu, pZtysinsahouhou, pZtyketteikekkakbn
            , pZtysibousrank, pZtyjissituhosyousrank, pZtysirajikykkbn, pZtyhrkhuhukbn
            , pZtyhknsyurui2keta, pZtydaisiincd, pZtytyuusiincd, pZtysyousiincd, pZtynenreihousikikbn
            , pZtysykgycd, pZtytodouhukencd, pZtybotaisisyaeigyouhonbu, pZtysisyaeigyoubu
            , pZtyaatukaisosikicd, pZtynensyuukbn, pZtyhanbaikeirokbn, pZtyoyadairitencd
            , pZtytratkidrtencd, pZtybsudirtnatkikeitaikbn, pZtykyktuuka, pZtyhrktuuka
            , pZtyhknsyukigou, pZtysyksbyensitihsyutyhkumu, pZtyjyudkaigomehrtkhkumu, pZtyijitoukeizennoukbn
            , pZtydai1hknkkn, pZtyijitoukeitikshrtkykkbn);
    }


    @Override
    public ExDBResults<ZT_SyuHukugouSikkanDataRn> getAllSyuHukugouSikkanDataRn() {
        return sinkeiyakuijitokeisosinDomManager.getAllSyuHukugouSikkanDataRn();
    }


    @Override
    public ZT_SyuHukugouSikkanDataRn getSyuHukugouSikkanDataRn(String pZrnijitoukeidaihyousyurui, String pZrnkeiyakunendo, String pZrnhknnendo, String pZrnhhknseikbn
        , String pZrnkykage, String pZrntoutatunenrei, String pZrnatukaibetu, String pZrnsinsahouhou, String pZrnketteikekkakbn
        , String pZrnsibousrank, String pZrnjissituhosyousrank, String pZrnsirajikykkbn, String pZrnhrkhuhukbn
        , String pZrnhknsyurui2keta, String pZrndaisiincd, String pZrntyuusiincd, String pZrnsyousiincd, String pZrnnenreihousikikbn
        , String pZrnsykgycd, String pZrntodouhukencd, String pZrnbotaisisyaeigyouhonbu, String pZrnsisyaeigyoubu
        , String pZrnaatukaisosikicd, String pZrnnensyuukbn, String pZrnhanbaikeirokbn, String pZrnoyadairitencd
        , String pZrntratkidrtencd, String pZrnbsudirtnatkikeitaikbn, String pZrnkyktuuka, String pZrnhrktuuka
        , String pZrnhknsyukigou, String pZrnsyksbyensitihsyutyhkumu, String pZrnjyudkaigomehrtkhkumu, String pZrnijitoukeizennoukbn
        , String pZrndai1hknkkn, String pZrnijitoukeitikshrtkykkbn) {
        return sinkeiyakuijitokeisosinDomManager.getSyuHukugouSikkanDataRn(pZrnijitoukeidaihyousyurui, pZrnkeiyakunendo, pZrnhknnendo, pZrnhhknseikbn
            , pZrnkykage, pZrntoutatunenrei, pZrnatukaibetu, pZrnsinsahouhou, pZrnketteikekkakbn
            , pZrnsibousrank, pZrnjissituhosyousrank, pZrnsirajikykkbn, pZrnhrkhuhukbn
            , pZrnhknsyurui2keta, pZrndaisiincd, pZrntyuusiincd, pZrnsyousiincd, pZrnnenreihousikikbn
            , pZrnsykgycd, pZrntodouhukencd, pZrnbotaisisyaeigyouhonbu, pZrnsisyaeigyoubu
            , pZrnaatukaisosikicd, pZrnnensyuukbn, pZrnhanbaikeirokbn, pZrnoyadairitencd
            , pZrntratkidrtencd, pZrnbsudirtnatkikeitaikbn, pZrnkyktuuka, pZrnhrktuuka
            , pZrnhknsyukigou, pZrnsyksbyensitihsyutyhkumu, pZrnjyudkaigomehrtkhkumu, pZrnijitoukeizennoukbn
            , pZrndai1hknkkn, pZrnijitoukeitikshrtkykkbn);
    }



    @Override
    public ExDBResults<ZT_SmbcSkMeisaiRendouTy> getAllSmbcSkMeisaiRendouTy() {
        return sinkeiyakuetcDomManager.getAllSmbcSkMeisaiRendouTy();
    }


    @Override
    public ZT_SmbcSkMeisaiRendouTy getSmbcSkMeisaiRendouTy(String pZtysmbcdatakbn, String pZtysmbcdatasakuseiymd, String pZtysmbchknkaisyacd, String pZtysmbcuktkkanriid) {
        return sinkeiyakuetcDomManager.getSmbcSkMeisaiRendouTy(pZtysmbcdatakbn, pZtysmbcdatasakuseiymd, pZtysmbchknkaisyacd, pZtysmbcuktkkanriid);
    }


    @Override
    public ExDBResults<ZT_SmbcSkMeisaiRendouRn> getAllSmbcSkMeisaiRendouRn() {
        return sinkeiyakuetcDomManager.getAllSmbcSkMeisaiRendouRn();
    }


    @Override
    public ZT_SmbcSkMeisaiRendouRn getSmbcSkMeisaiRendouRn(String pZrnsmbcdatakbn, String pZrnsmbcdatasakuseiymd, String pZrnsmbchknkaisyacd, String pZrnsmbcuktkkanriid) {
        return sinkeiyakuetcDomManager.getSmbcSkMeisaiRendouRn(pZrnsmbcdatakbn, pZrnsmbcdatasakuseiymd, pZrnsmbchknkaisyacd, pZrnsmbcuktkkanriid);
    }



    @Override
    public ExDBResults<ZT_OnlineLincSousinTy> getAllOnlineLincSousinTy() {
        return sinkeiyakuLincSosinDomManager.getAllOnlineLincSousinTy();
    }


    @Override
    public ZT_OnlineLincSousinTy getOnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        return sinkeiyakuLincSosinDomManager.getOnlineLincSousinTy(pZtyrecordsyubetukbn, pZtykykkanrino);
    }


    @Override
    public ExDBResults<ZT_OnlineLincSousinRn> getAllOnlineLincSousinRn() {
        return sinkeiyakuLincSosinDomManager.getAllOnlineLincSousinRn();
    }


    @Override
    public ZT_OnlineLincSousinRn getOnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        return sinkeiyakuLincSosinDomManager.getOnlineLincSousinRn(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }


    @Override
    public ExDBResults<ZT_YakansyoriLincSousinTy> getAllYakansyoriLincSousinTy() {
        return sinkeiyakuLincSosinDomManager.getAllYakansyoriLincSousinTy();
    }


    @Override
    public ZT_YakansyoriLincSousinTy getYakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        return sinkeiyakuLincSosinDomManager.getYakansyoriLincSousinTy(pZtyrecordsyubetukbn, pZtykykkanrino);
    }


    @Override
    public ExDBResults<ZT_YakansyoriLincSousinRn> getAllYakansyoriLincSousinRn() {
        return sinkeiyakuLincSosinDomManager.getAllYakansyoriLincSousinRn();
    }


    @Override
    public ZT_YakansyoriLincSousinRn getYakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        return sinkeiyakuLincSosinDomManager.getYakansyoriLincSousinRn(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }



    @Override
    public ExDBResults<ZT_LincJyusinRn> getAllLincJyusinRn() {
        return sinkeiyakuLincJyusinDomManager.getAllLincJyusinRn();
    }


    @Override
    public ZT_LincJyusinRn getLincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {
        return sinkeiyakuLincJyusinDomManager.getLincJyusinRn(pZrnsyoriymd, pZrnrenno10);
    }


    @Override
    public ExDBResults<ZT_LincJyusinTr> getAllLincJyusinTr() {
        return sinkeiyakuLincJyusinDomManager.getAllLincJyusinTr();
    }


    @Override
    public ZT_LincJyusinTr getLincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {
        return sinkeiyakuLincJyusinDomManager.getLincJyusinTr(pZtrsyoriymd, pZtrrenno10);
    }



    @Override
    public ExDBResults<ZT_SyainMeiboTy> getAllSyainMeiboTy() {
        return hozendiskjyusinDomManager.getAllSyainMeiboTy();
    }


    @Override
    public ZT_SyainMeiboTy getSyainMeiboTy(String pZtysyono) {
        return hozendiskjyusinDomManager.getSyainMeiboTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SyoukenTkListShTy> getAllSyoukenTkListShTy() {
        return hozendiskjyusinDomManager.getAllSyoukenTkListShTy();
    }


    @Override
    public ZT_SyoukenTkListShTy getSyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getSyoukenTkListShTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SyoukenTkListShRn> getAllSyoukenTkListShRn() {
        return hozendiskjyusinDomManager.getAllSyoukenTkListShRn();
    }


    @Override
    public ZT_SyoukenTkListShRn getSyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getSyoukenTkListShRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_SyoukenTkListSkTy> getAllSyoukenTkListSkTy() {
        return hozendiskjyusinDomManager.getAllSyoukenTkListSkTy();
    }


    @Override
    public ZT_SyoukenTkListSkTy getSyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getSyoukenTkListSkTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SyoukenTkListSkRn> getAllSyoukenTkListSkRn() {
        return hozendiskjyusinDomManager.getAllSyoukenTkListSkRn();
    }


    @Override
    public ZT_SyoukenTkListSkRn getSyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getSyoukenTkListSkRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_HnsyScrMeigiTy> getAllHnsyScrMeigiTy() {
        return hozendiskjyusinDomManager.getAllHnsyScrMeigiTy();
    }


    @Override
    public ZT_HnsyScrMeigiTy getHnsyScrMeigiTy(String pZtytaisyounmkn, String pZtytaisyounmkj, String pZtytaisyouseiymd, String pZtynayosetaisyousegkbn
        , String pZtysyono) {
        return hozendiskjyusinDomManager.getHnsyScrMeigiTy(pZtytaisyounmkn, pZtytaisyounmkj, pZtytaisyouseiymd, pZtynayosetaisyousegkbn
            , pZtysyono);
    }


    @Override
    public ExDBResults<ZT_HnsyScrMeigiRn> getAllHnsyScrMeigiRn() {
        return hozendiskjyusinDomManager.getAllHnsyScrMeigiRn();
    }


    @Override
    public ZT_HnsyScrMeigiRn getHnsyScrMeigiRn(String pZrntaisyounmkn, String pZrntaisyounmkj, String pZrntaisyouseiymd, String pZrnnayosetaisyousegkbn
        , String pZrnsyono) {
        return hozendiskjyusinDomManager.getHnsyScrMeigiRn(pZrntaisyounmkn, pZrntaisyounmkj, pZrntaisyouseiymd, pZrnnayosetaisyousegkbn
            , pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KoujyoSyoumeiTy> getAllKoujyoSyoumeiTy() {
        return hozendiskjyusinDomManager.getAllKoujyoSyoumeiTy();
    }


    @Override
    public ZT_KoujyoSyoumeiTy getKoujyoSyoumeiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysakunm15keta) {
        return hozendiskjyusinDomManager.getKoujyoSyoumeiTy(pZtytyouhyouymd, pZtysyono, pZtysakunm15keta);
    }


    @Override
    public ExDBResults<ZT_KoujyoSyoumeiRn> getAllKoujyoSyoumeiRn() {
        return hozendiskjyusinDomManager.getAllKoujyoSyoumeiRn();
    }


    @Override
    public ZT_KoujyoSyoumeiRn getKoujyoSyoumeiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsakunm15keta) {
        return hozendiskjyusinDomManager.getKoujyoSyoumeiRn(pZrntyouhyouymd, pZrnsyono, pZrnsakunm15keta);
    }


    @Override
    public ExDBResults<ZT_TtdkKanTy> getAllTtdkKanTy() {
        return hozendiskjyusinDomManager.getAllTtdkKanTy();
    }


    @Override
    public ZT_TtdkKanTy getTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_TtdkKanRn> getAllTtdkKanRn() {
        return hozendiskjyusinDomManager.getAllTtdkKanRn();
    }


    @Override
    public ZT_TtdkKanRn getTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_TtdkKanKiykTy> getAllTtdkKanKiykTy() {
        return hozendiskjyusinDomManager.getAllTtdkKanKiykTy();
    }


    @Override
    public ZT_TtdkKanKiykTy getTtdkKanKiykTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanKiykTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_TtdkKanKiykRn> getAllTtdkKanKiykRn() {
        return hozendiskjyusinDomManager.getAllTtdkKanKiykRn();
    }


    @Override
    public ZT_TtdkKanKiykRn getTtdkKanKiykRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanKiykRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_TtdkKanAdHenkouTy> getAllTtdkKanAdHenkouTy() {
        return hozendiskjyusinDomManager.getAllTtdkKanAdHenkouTy();
    }


    @Override
    public ZT_TtdkKanAdHenkouTy getTtdkKanAdHenkouTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanAdHenkouTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_TtdkKanAdHenkouRn> getAllTtdkKanAdHenkouRn() {
        return hozendiskjyusinDomManager.getAllTtdkKanAdHenkouRn();
    }


    @Override
    public ZT_TtdkKanAdHenkouRn getTtdkKanAdHenkouRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getTtdkKanAdHenkouRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_DrtenKykIdouDetailTy> getAllDrtenKykIdouDetailTy() {
        return hozendiskjyusinDomManager.getAllDrtenKykIdouDetailTy();
    }


    @Override
    public ZT_DrtenKykIdouDetailTy getDrtenKykIdouDetailTy(String pZtybsydrtencd, String pZtybosyuunincd, String pZtysyono, String pZtyidouhasseiymd, String pZtyidoukbn) {
        return hozendiskjyusinDomManager.getDrtenKykIdouDetailTy(pZtybsydrtencd, pZtybosyuunincd, pZtysyono, pZtyidouhasseiymd, pZtyidoukbn);
    }


    @Override
    public ExDBResults<ZT_DrtenKykIdouDetailRn> getAllDrtenKykIdouDetailRn() {
        return hozendiskjyusinDomManager.getAllDrtenKykIdouDetailRn();
    }


    @Override
    public ZT_DrtenKykIdouDetailRn getDrtenKykIdouDetailRn(String pZrnbsydrtencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnidouhasseiymd, String pZrnidoukbn) {
        return hozendiskjyusinDomManager.getDrtenKykIdouDetailRn(pZrnbsydrtencd, pZrnbosyuunincd, pZrnsyono, pZrnidouhasseiymd, pZrnidoukbn);
    }


    @Override
    public ExDBResults<ZT_BosyuuDrtenHoyuuKykTy> getAllBosyuuDrtenHoyuuKykTy() {
        return hozendiskjyusinDomManager.getAllBosyuuDrtenHoyuuKykTy();
    }


    @Override
    public ZT_BosyuuDrtenHoyuuKykTy getBosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {
        return hozendiskjyusinDomManager.getBosyuuDrtenHoyuuKykTy(pZtysyonosyuban);
    }


    @Override
    public ExDBResults<ZT_BosyuuDrtenHoyuuKykRn> getAllBosyuuDrtenHoyuuKykRn() {
        return hozendiskjyusinDomManager.getAllBosyuuDrtenHoyuuKykRn();
    }


    @Override
    public ZT_BosyuuDrtenHoyuuKykRn getBosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {
        return hozendiskjyusinDomManager.getBosyuuDrtenHoyuuKykRn(pZrnsyonosyuban);
    }


    @Override
    public ExDBResults<ZT_KydGWKykInfoTy> getAllKydGWKykInfoTy() {
        return hozendiskjyusinDomManager.getAllKydGWKykInfoTy();
    }


    @Override
    public ZT_KydGWKykInfoTy getKydGWKykInfoTy(String pZtysyono, String pZtysyoriymd, Long pZtykykmfksnctrlkh) {
        return hozendiskjyusinDomManager.getKydGWKykInfoTy(pZtysyono, pZtysyoriymd, pZtykykmfksnctrlkh);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuHokensyoukenTy> getAllSinkeiyakuHokensyoukenTy() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuHokensyoukenTy();
    }


    @Override
    public ZT_SinkeiyakuHokensyoukenTy getSinkeiyakuHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getSinkeiyakuHokensyoukenTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SaihakkouHokensyoukenTy> getAllSaihakkouHokensyoukenTy() {
        return hozendiskjyusinDomManager.getAllSaihakkouHokensyoukenTy();
    }


    @Override
    public ZT_SaihakkouHokensyoukenTy getSaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getSaihakkouHokensyoukenTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SyainMeiboRn> getAllSyainMeiboRn() {
        return hozendiskjyusinDomManager.getAllSyainMeiboRn();
    }


    @Override
    public ZT_SyainMeiboRn getSyainMeiboRn(String pZrnsyono) {
        return hozendiskjyusinDomManager.getSyainMeiboRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DrtenTsryInfoTy> getAllDrtenTsryInfoTy() {
        return hozendiskjyusinDomManager.getAllDrtenTsryInfoTy();
    }


    @Override
    public ZT_DrtenTsryInfoTy getDrtenTsryInfoTy(String pZtydairitencd, String pZtybosyuunincd, String pZtysyono, String pZtykikaisyoriymd, Long pZtykykmfksnctrlkh, String pZtysikibetujyunjyo) {
        return hozendiskjyusinDomManager.getDrtenTsryInfoTy(pZtydairitencd, pZtybosyuunincd, pZtysyono, pZtykikaisyoriymd, pZtykykmfksnctrlkh, pZtysikibetujyunjyo);
    }


    @Override
    public ExDBResults<ZT_SeihoWebIdouListTy> getAllSeihoWebIdouListTy() {
        return hozendiskjyusinDomManager.getAllSeihoWebIdouListTy();
    }


    @Override
    public ZT_SeihoWebIdouListTy getSeihoWebIdouListTy(String pZtysakuseiymd7keta, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono, String pZtyhasseiymd
        , String pZtyidoukbn1, String pZtykydatkikbnkj, String pZtykykyymm, String pZtycifcd) {
        return hozendiskjyusinDomManager.getSeihoWebIdouListTy(pZtysakuseiymd7keta, pZtybsydrtencd, pZtytntusycd, pZtysyono, pZtyhasseiymd
            , pZtyidoukbn1, pZtykydatkikbnkj, pZtykykyymm, pZtycifcd);
    }


    @Override
    public ExDBResults<ZT_HknkykIdouInfoTy> getAllHknkykIdouInfoTy() {
        return hozendiskjyusinDomManager.getAllHknkykIdouInfoTy();
    }


    @Override
    public ZT_HknkykIdouInfoTy getHknkykIdouInfoTy(String pZtykyktuukasyu, String pZtyidouymd, String pZtyidoujiyuukbnzfi, String pZtydatakanrino, String pZtyrenno, String pZtytumitatekinkbn) {
        return hozendiskjyusinDomManager.getHknkykIdouInfoTy(pZtykyktuukasyu, pZtyidouymd, pZtyidoujiyuukbnzfi, pZtydatakanrino, pZtyrenno, pZtytumitatekinkbn);
    }


    @Override
    public ExDBResults<ZT_KydGWKykInfoRn> getAllKydGWKykInfoRn() {
        return hozendiskjyusinDomManager.getAllKydGWKykInfoRn();
    }


    @Override
    public ZT_KydGWKykInfoRn getKydGWKykInfoRn(String pZrnsyono, String pZrnsyoriymd, Long pZrnkykmfksnctrlkh) {
        return hozendiskjyusinDomManager.getKydGWKykInfoRn(pZrnsyono, pZrnsyoriymd, pZrnkykmfksnctrlkh);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuHokensyoukenRn> getAllSinkeiyakuHokensyoukenRn() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuHokensyoukenRn();
    }


    @Override
    public ZT_SinkeiyakuHokensyoukenRn getSinkeiyakuHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getSinkeiyakuHokensyoukenRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_SaihakkouHokensyoukenRn> getAllSaihakkouHokensyoukenRn() {
        return hozendiskjyusinDomManager.getAllSaihakkouHokensyoukenRn();
    }


    @Override
    public ZT_SaihakkouHokensyoukenRn getSaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getSaihakkouHokensyoukenRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_GaikaKokyakuTuutiTy> getAllGaikaKokyakuTuutiTy() {
        return hozendiskjyusinDomManager.getAllGaikaKokyakuTuutiTy();
    }


    @Override
    public ZT_GaikaKokyakuTuutiTy getGaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getGaikaKokyakuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_GaikaKokyakuTuutiRn> getAllGaikaKokyakuTuutiRn() {
        return hozendiskjyusinDomManager.getAllGaikaKokyakuTuutiRn();
    }


    @Override
    public ZT_GaikaKokyakuTuutiRn getGaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getGaikaKokyakuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DrtenTsryInfoRn> getAllDrtenTsryInfoRn() {
        return hozendiskjyusinDomManager.getAllDrtenTsryInfoRn();
    }


    @Override
    public ZT_DrtenTsryInfoRn getDrtenTsryInfoRn(String pZrndairitencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnkikaisyoriymd, Long pZrnkykmfksnctrlkh, String pZrnsikibetujyunjyo) {
        return hozendiskjyusinDomManager.getDrtenTsryInfoRn(pZrndairitencd, pZrnbosyuunincd, pZrnsyono, pZrnkikaisyoriymd, pZrnkykmfksnctrlkh, pZrnsikibetujyunjyo);
    }


    @Override
    public ExDBResults<ZT_SeihoWebIdouListRn> getAllSeihoWebIdouListRn() {
        return hozendiskjyusinDomManager.getAllSeihoWebIdouListRn();
    }


    @Override
    public ZT_SeihoWebIdouListRn getSeihoWebIdouListRn(Long pZrnsakuseiymd7keta, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono, String pZrnhasseiymd
        , String pZrnidoukbn1, String pZrnkydatkikbnkj, String pZrnkykyymm, String pZrncifcd) {
        return hozendiskjyusinDomManager.getSeihoWebIdouListRn(pZrnsakuseiymd7keta, pZrnbsydrtencd, pZrntntusycd, pZrnsyono, pZrnhasseiymd
            , pZrnidoukbn1, pZrnkydatkikbnkj, pZrnkykyymm, pZrncifcd);
    }


    @Override
    public ExDBResults<ZT_HknkykIdouInfoRn> getAllHknkykIdouInfoRn() {
        return hozendiskjyusinDomManager.getAllHknkykIdouInfoRn();
    }


    @Override
    public ZT_HknkykIdouInfoRn getHknkykIdouInfoRn(String pZrnkyktuukasyu, String pZrnidouymd, String pZrnidoujiyuukbnzfi, String pZrndatakanrino, String pZrnrenno, String pZtytumitatekinkbn) {
        return hozendiskjyusinDomManager.getHknkykIdouInfoRn(pZrnkyktuukasyu, pZrnidouymd, pZrnidoujiyuukbnzfi, pZrndatakanrino, pZrnrenno, pZtytumitatekinkbn);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuSyoukenSuiiTy> getAllSinkeiyakuSyoukenSuiiTy() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuSyoukenSuiiTy();
    }


    @Override
    public ZT_SinkeiyakuSyoukenSuiiTy getSinkeiyakuSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        return hozendiskjyusinDomManager.getSinkeiyakuSyoukenSuiiTy(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuSyoukenSuiiRn> getAllSinkeiyakuSyoukenSuiiRn() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuSyoukenSuiiRn();
    }


    @Override
    public ZT_SinkeiyakuSyoukenSuiiRn getSinkeiyakuSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        return hozendiskjyusinDomManager.getSinkeiyakuSyoukenSuiiRn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SaihakkouSyoukenSuiiTy> getAllSaihakkouSyoukenSuiiTy() {
        return hozendiskjyusinDomManager.getAllSaihakkouSyoukenSuiiTy();
    }


    @Override
    public ZT_SaihakkouSyoukenSuiiTy getSaihakkouSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        return hozendiskjyusinDomManager.getSaihakkouSyoukenSuiiTy(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SaihakkouSyoukenSuiiRn> getAllSaihakkouSyoukenSuiiRn() {
        return hozendiskjyusinDomManager.getAllSaihakkouSyoukenSuiiRn();
    }


    @Override
    public ZT_SaihakkouSyoukenSuiiRn getSaihakkouSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        return hozendiskjyusinDomManager.getSaihakkouSyoukenSuiiRn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SmbcGetujiKykMeisaiTy> getAllSmbcGetujiKykMeisaiTy() {
        return hozendiskjyusinDomManager.getAllSmbcGetujiKykMeisaiTy();
    }


    @Override
    public ZT_SmbcGetujiKykMeisaiTy getSmbcGetujiKykMeisaiTy(String pZtydatakijyunymd, String pZtydatakijyunym, String pZtysyono) {
        return hozendiskjyusinDomManager.getSmbcGetujiKykMeisaiTy(pZtydatakijyunymd, pZtydatakijyunym, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SmbcGetujiKykMeisaiRn> getAllSmbcGetujiKykMeisaiRn() {
        return hozendiskjyusinDomManager.getAllSmbcGetujiKykMeisaiRn();
    }


    @Override
    public ZT_SmbcGetujiKykMeisaiRn getSmbcGetujiKykMeisaiRn(String pZrndatakijyunymd, String pZrndatakijyunym, String pZrnsyono) {
        return hozendiskjyusinDomManager.getSmbcGetujiKykMeisaiRn(pZrndatakijyunymd, pZrndatakijyunym, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_TumitateYosokuTy> getAllTumitateYosokuTy() {
        return hozendiskjyusinDomManager.getAllTumitateYosokuTy();
    }


    @Override
    public ZT_TumitateYosokuTy getTumitateYosokuTy(String pZtyhknsyukigou, String pZtykeiyakuymd, String pZtytysytymd, String pZtykyktuukasyu, String pZtyhknkkn
        , String pZtytmttknsyuruikbn, String pZtysisuukbn) {
        return hozendiskjyusinDomManager.getTumitateYosokuTy(pZtyhknsyukigou, pZtykeiyakuymd, pZtytysytymd, pZtykyktuukasyu, pZtyhknkkn
            , pZtytmttknsyuruikbn, pZtysisuukbn);
    }


    @Override
    public ExDBResults<ZT_TumitateYosokuRn> getAllTumitateYosokuRn() {
        return hozendiskjyusinDomManager.getAllTumitateYosokuRn();
    }


    @Override
    public ZT_TumitateYosokuRn getTumitateYosokuRn(String pZrnhknsyukigou, String pZrnkeiyakuymd, String pZrntysytymd, String pZrnkyktuukasyu, String pZrnhknkkn
        , String pZrntmttknsyuruikbn, String pZrnsisuukbn) {
        return hozendiskjyusinDomManager.getTumitateYosokuRn(pZrnhknsyukigou, pZrnkeiyakuymd, pZrntysytymd, pZrnkyktuukasyu, pZrnhknkkn
            , pZrntmttknsyuruikbn, pZrnsisuukbn);
    }


    @Override
    public ZT_SinninTouhyouTy getSinninTouhyouTy(String pZtysyono) {
        return hozendiskjyusinDomManager.getSinninTouhyouTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SinninTouhyouTy> getAllSinninTouhyouTy() {
        return hozendiskjyusinDomManager.getAllSinninTouhyouTy();
    }


    @Override
    public ZT_SinninTouhyouRn getSinninTouhyouRn(String pZrnsyono) {
        return hozendiskjyusinDomManager.getSinninTouhyouRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_SinninTouhyouRn> getAllSinninTouhyouRn() {
        return hozendiskjyusinDomManager.getAllSinninTouhyouRn();
    }


    @Override
    public ExDBResults<ZT_DattaiTuutiKzhuriRn> getAllDattaiTuutiKzhuriRn() {
        return hozendiskjyusinDomManager.getAllDattaiTuutiKzhuriRn();
    }


    @Override
    public ZT_DattaiTuutiKzhuriRn getDattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getDattaiTuutiKzhuriRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DattaiTuutiKzhuriTy> getAllDattaiTuutiKzhuriTy() {
        return hozendiskjyusinDomManager.getAllDattaiTuutiKzhuriTy();
    }


    @Override
    public ZT_DattaiTuutiKzhuriTy getDattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getDattaiTuutiKzhuriTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_GinkouMdhnMisyuuInfoFRn> getAllGinkouMdhnMisyuuInfoFRn() {
        return hozendiskjyusinDomManager.getAllGinkouMdhnMisyuuInfoFRn();
    }


    @Override
    public ZT_GinkouMdhnMisyuuInfoFRn getGinkouMdhnMisyuuInfoFRn(String pZrnbsydrtencd, String pZrndatasakuseiymd, String pZrnsyonosyuban) {
        return hozendiskjyusinDomManager.getGinkouMdhnMisyuuInfoFRn(pZrnbsydrtencd, pZrndatasakuseiymd, pZrnsyonosyuban);
    }


    @Override
    public ExDBResults<ZT_GinkouMdhnMisyuuInfoFTy> getAllGinkouMdhnMisyuuInfoFTy() {
        return hozendiskjyusinDomManager.getAllGinkouMdhnMisyuuInfoFTy();
    }


    @Override
    public ZT_GinkouMdhnMisyuuInfoFTy getGinkouMdhnMisyuuInfoFTy(String pZtybsydrtencd, String pZtydatasakuseiymd, String pZtysyonosyuban) {
        return hozendiskjyusinDomManager.getGinkouMdhnMisyuuInfoFTy(pZtybsydrtencd, pZtydatasakuseiymd, pZtysyonosyuban);
    }


    @Override
    public ExDBResults<ZT_HrhnTtdkKanRn> getAllHrhnTtdkKanRn() {
        return hozendiskjyusinDomManager.getAllHrhnTtdkKanRn();
    }


    @Override
    public ZT_HrhnTtdkKanRn getHrhnTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getHrhnTtdkKanRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_HrhnTtdkKanTy> getAllHrhnTtdkKanTy() {
        return hozendiskjyusinDomManager.getAllHrhnTtdkKanTy();
    }


    @Override
    public ZT_HrhnTtdkKanTy getHrhnTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getHrhnTtdkKanTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinHurikaeRn> getAllKesikomiSousinHurikaeRn() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinHurikaeRn();
    }


    @Override
    public ZT_KesikomiSousinHurikaeRn getKesikomiSousinHurikaeRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinHurikaeRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinHurikaeTy> getAllKesikomiSousinHurikaeTy() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinHurikaeTy();
    }


    @Override
    public ZT_KesikomiSousinHurikaeTy getKesikomiSousinHurikaeTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinHurikaeTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinKouhuriRn> getAllKesikomiSousinKouhuriRn() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinKouhuriRn();
    }


    @Override
    public ZT_KesikomiSousinKouhuriRn getKesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinKouhuriRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinKouhuriTy> getAllKesikomiSousinKouhuriTy() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinKouhuriTy();
    }


    @Override
    public ZT_KesikomiSousinKouhuriTy getKesikomiSousinKouhuriTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinKouhuriTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_KessanYokukiPRn> getAllKessanYokukiPRn() {
        return hozendiskjyusinDomManager.getAllKessanYokukiPRn();
    }


    @Override
    public ZT_KessanYokukiPRn getKessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono) {
        return hozendiskjyusinDomManager.getKessanYokukiPRn(pZrnkeijyouym, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KessanYokukiPTy> getAllKessanYokukiPTy() {
        return hozendiskjyusinDomManager.getAllKessanYokukiPTy();
    }


    @Override
    public ZT_KessanYokukiPTy getKessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {
        return hozendiskjyusinDomManager.getKessanYokukiPTy(pZtykeijyouym, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_KessanZennouFRn> getAllKessanZennouFRn() {
        return hozendiskjyusinDomManager.getAllKessanZennouFRn();
    }


    @Override
    public ZT_KessanZennouFRn getKessanZennouFRn(String pZrnsyono, String pZrnkbnkeiriyousegmentcd, String pZrnzennoutoukeilistkbn, String pZrnzennoukbn) {
        return hozendiskjyusinDomManager.getKessanZennouFRn(pZrnsyono, pZrnkbnkeiriyousegmentcd, pZrnzennoutoukeilistkbn, pZrnzennoukbn);
    }


    @Override
    public ExDBResults<ZT_KessanZennouFTy> getAllKessanZennouFTy() {
        return hozendiskjyusinDomManager.getAllKessanZennouFTy();
    }


    @Override
    public ZT_KessanZennouFTy getKessanZennouFTy(String pZtysyono, String pZtykbnkeiriyousegmentcd, String pZtyzennoutoukeilistkbn, String pZtyzennoukbn) {
        return hozendiskjyusinDomManager.getKessanZennouFTy(pZtysyono, pZtykbnkeiriyousegmentcd, pZtyzennoutoukeilistkbn, pZtyzennoukbn);
    }


    @Override
    public ExDBResults<ZT_KhDrtenMinyuuKykMeisaiRn> getAllKhDrtenMinyuuKykMeisaiRn() {
        return hozendiskjyusinDomManager.getAllKhDrtenMinyuuKykMeisaiRn();
    }


    @Override
    public ZT_KhDrtenMinyuuKykMeisaiRn getKhDrtenMinyuuKykMeisaiRn(String pZrnsyoriymd, String pZrnbsydrtencd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getKhDrtenMinyuuKykMeisaiRn(pZrnsyoriymd, pZrnbsydrtencd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KhDrtenMinyuuKykMeisaiTy> getAllKhDrtenMinyuuKykMeisaiTy() {
        return hozendiskjyusinDomManager.getAllKhDrtenMinyuuKykMeisaiTy();
    }


    @Override
    public ZT_KhDrtenMinyuuKykMeisaiTy getKhDrtenMinyuuKykMeisaiTy(String pZtysyoriymd, String pZtybsydrtencd, String pZtysyono) {
        return hozendiskjyusinDomManager.getKhDrtenMinyuuKykMeisaiTy(pZtysyoriymd, pZtybsydrtencd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_KhGinkouMdhnFollowCallRn> getAllKhGinkouMdhnFollowCallRn() {
        return hozendiskjyusinDomManager.getAllKhGinkouMdhnFollowCallRn();
    }


    @Override
    public ZT_KhGinkouMdhnFollowCallRn getKhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {
        return hozendiskjyusinDomManager.getKhGinkouMdhnFollowCallRn(pZrnsyono, pZrnminyuuym);
    }


    @Override
    public ExDBResults<ZT_KhGinkouMdhnFollowCallTy> getAllKhGinkouMdhnFollowCallTy() {
        return hozendiskjyusinDomManager.getAllKhGinkouMdhnFollowCallTy();
    }


    @Override
    public ZT_KhGinkouMdhnFollowCallTy getKhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {
        return hozendiskjyusinDomManager.getKhGinkouMdhnFollowCallTy(pZtysyono, pZtyminyuuym);
    }


    @Override
    public ExDBResults<ZT_KijituTouraiAnnaiRn> getAllKijituTouraiAnnaiRn() {
        return hozendiskjyusinDomManager.getAllKijituTouraiAnnaiRn();
    }


    @Override
    public ZT_KijituTouraiAnnaiRn getKijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getKijituTouraiAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KijituTouraiAnnaiTy> getAllKijituTouraiAnnaiTy() {
        return hozendiskjyusinDomManager.getAllKijituTouraiAnnaiTy();
    }


    @Override
    public ZT_KijituTouraiAnnaiTy getKijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getKijituTouraiAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_KouzaHnknTuutiRn> getAllKouzaHnknTuutiRn() {
        return hozendiskjyusinDomManager.getAllKouzaHnknTuutiRn();
    }


    @Override
    public ZT_KouzaHnknTuutiRn getKouzaHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getKouzaHnknTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_KouzaHnknTuutiTy> getAllKouzaHnknTuutiTy() {
        return hozendiskjyusinDomManager.getAllKouzaHnknTuutiTy();
    }


    @Override
    public ZT_KouzaHnknTuutiTy getKouzaHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getKouzaHnknTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_KouzaHrkmTuutiRn> getAllKouzaHrkmTuutiRn() {
        return hozendiskjyusinDomManager.getAllKouzaHrkmTuutiRn();
    }


    @Override
    public ZT_KouzaHrkmTuutiRn getKouzaHrkmTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getKouzaHrkmTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_KouzaHrkmTuutiTy> getAllKouzaHrkmTuutiTy() {
        return hozendiskjyusinDomManager.getAllKouzaHrkmTuutiTy();
    }


    @Override
    public ZT_KouzaHrkmTuutiTy getKouzaHrkmTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getKouzaHrkmTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_KouzahuriMinyuTuutiRn> getAllKouzahuriMinyuTuutiRn() {
        return hozendiskjyusinDomManager.getAllKouzahuriMinyuTuutiRn();
    }


    @Override
    public ZT_KouzahuriMinyuTuutiRn getKouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getKouzahuriMinyuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KouzahuriMinyuTuutiTy> getAllKouzahuriMinyuTuutiTy() {
        return hozendiskjyusinDomManager.getAllKouzahuriMinyuTuutiTy();
    }


    @Override
    public ZT_KouzahuriMinyuTuutiTy getKouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getKouzahuriMinyuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_KouzahuriStartAnnaiRn> getAllKouzahuriStartAnnaiRn() {
        return hozendiskjyusinDomManager.getAllKouzahuriStartAnnaiRn();
    }


    @Override
    public ZT_KouzahuriStartAnnaiRn getKouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getKouzahuriStartAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_KouzahuriStartAnnaiTy> getAllKouzahuriStartAnnaiTy() {
        return hozendiskjyusinDomManager.getAllKouzahuriStartAnnaiTy();
    }


    @Override
    public ZT_KouzahuriStartAnnaiTy getKouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getKouzahuriStartAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_KzhuriAnnaiUlfRn> getAllKzhuriAnnaiUlfRn() {
        return hozendiskjyusinDomManager.getAllKzhuriAnnaiUlfRn();
    }


    @Override
    public ZT_KzhuriAnnaiUlfRn getKzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {
        return hozendiskjyusinDomManager.getKzhuriAnnaiUlfRn(pZrnsyono, pZrnjyuutouym);
    }


    @Override
    public ExDBResults<ZT_KzhuriAnnaiUlfTy> getAllKzhuriAnnaiUlfTy() {
        return hozendiskjyusinDomManager.getAllKzhuriAnnaiUlfTy();
    }


    @Override
    public ZT_KzhuriAnnaiUlfTy getKzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {
        return hozendiskjyusinDomManager.getKzhuriAnnaiUlfTy(pZtysyono, pZtyjyuutouym);
    }


    @Override
    public ExDBResults<ZT_SinkokuYokokuTuutiFSksRn> getAllSinkokuYokokuTuutiFSksRn() {
        return hozendiskjyusinDomManager.getAllSinkokuYokokuTuutiFSksRn();
    }


    @Override
    public ZT_SinkokuYokokuTuutiFSksRn getSinkokuYokokuTuutiFSksRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsinkokunenkj) {
        return hozendiskjyusinDomManager.getSinkokuYokokuTuutiFSksRn(pZrntyouhyouymd, pZrnsyono, pZrnsinkokunenkj);
    }


    @Override
    public ExDBResults<ZT_SinkokuYokokuTuutiFSksTy> getAllSinkokuYokokuTuutiFSksTy() {
        return hozendiskjyusinDomManager.getAllSinkokuYokokuTuutiFSksTy();
    }


    @Override
    public ZT_SinkokuYokokuTuutiFSksTy getSinkokuYokokuTuutiFSksTy(String pZtytyouhyouymd, String pZtysyono, String pZtysinkokunenkj) {
        return hozendiskjyusinDomManager.getSinkokuYokokuTuutiFSksTy(pZtytyouhyouymd, pZtysyono, pZtysinkokunenkj);
    }


    @Override
    public ExDBResults<ZT_DrtenMinyuuKykInfoRn> getAllDrtenMinyuuKykInfoRn() {
        return hozendiskjyusinDomManager.getAllDrtenMinyuuKykInfoRn();
    }


    @Override
    public ZT_DrtenMinyuuKykInfoRn getDrtenMinyuuKykInfoRn(String pZrnsyono) {
        return hozendiskjyusinDomManager.getDrtenMinyuuKykInfoRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DrtenMinyuuKykInfoTy> getAllDrtenMinyuuKykInfoTy() {
        return hozendiskjyusinDomManager.getAllDrtenMinyuuKykInfoTy();
    }


    @Override
    public ZT_DrtenMinyuuKykInfoTy getDrtenMinyuuKykInfoTy(String pZtysyono) {
        return hozendiskjyusinDomManager.getDrtenMinyuuKykInfoTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_DrtenMinyuKykDtlSyokaiRn> getAllDrtenMinyuKykDtlSyokaiRn() {
        return hozendiskjyusinDomManager.getAllDrtenMinyuKykDtlSyokaiRn();
    }


    @Override
    public ZT_DrtenMinyuKykDtlSyokaiRn getDrtenMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getDrtenMinyuKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DrtenMinyuKykDtlSyokaiTy> getAllDrtenMinyuKykDtlSyokaiTy() {
        return hozendiskjyusinDomManager.getAllDrtenMinyuKykDtlSyokaiTy();
    }


    @Override
    public ZT_DrtenMinyuKykDtlSyokaiTy getDrtenMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        return hozendiskjyusinDomManager.getDrtenMinyuKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_YuseiMinyuKykDtlSyokaiRn> getAllYuseiMinyuKykDtlSyokaiRn() {
        return hozendiskjyusinDomManager.getAllYuseiMinyuKykDtlSyokaiRn();
    }


    @Override
    public ZT_YuseiMinyuKykDtlSyokaiRn getYuseiMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getYuseiMinyuKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_YuseiMinyuKykDtlSyokaiTy> getAllYuseiMinyuKykDtlSyokaiTy() {
        return hozendiskjyusinDomManager.getAllYuseiMinyuKykDtlSyokaiTy();
    }


    @Override
    public ZT_YuseiMinyuKykDtlSyokaiTy getYuseiMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        return hozendiskjyusinDomManager.getYuseiMinyuKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_DrtenMisyuSkInfoDataRn> getAllDrtenMisyuSkInfoDataRn() {
        return hozendiskjyusinDomManager.getAllDrtenMisyuSkInfoDataRn();
    }


    @Override
    public ZT_DrtenMisyuSkInfoDataRn getDrtenMisyuSkInfoDataRn(String pZrnsyono, String pZrnbsydrtencd, String pZrnhanteiymd) {
        return hozendiskjyusinDomManager.getDrtenMisyuSkInfoDataRn(pZrnsyono, pZrnbsydrtencd, pZrnhanteiymd);
    }


    @Override
    public ExDBResults<ZT_DrtenMisyuSkInfoDataTy> getAllDrtenMisyuSkInfoDataTy() {
        return hozendiskjyusinDomManager.getAllDrtenMisyuSkInfoDataTy();
    }


    @Override
    public ZT_DrtenMisyuSkInfoDataTy getDrtenMisyuSkInfoDataTy(String pZtysyono, String pZtybsydrtencd, String pZtyhanteiymd) {
        return hozendiskjyusinDomManager.getDrtenMisyuSkInfoDataTy(pZtysyono, pZtybsydrtencd, pZtyhanteiymd);
    }


    @Override
    public ExDBResults<ZT_SaihakkouSyoukenSuii2Rn> getAllSaihakkouSyoukenSuii2Rn() {
        return hozendiskjyusinDomManager.getAllSaihakkouSyoukenSuii2Rn();
    }


    @Override
    public ZT_SaihakkouSyoukenSuii2Rn getSaihakkouSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        return hozendiskjyusinDomManager.getSaihakkouSyoukenSuii2Rn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SaihakkouSyoukenSuii2Ty> getAllSaihakkouSyoukenSuii2Ty() {
        return hozendiskjyusinDomManager.getAllSaihakkouSyoukenSuii2Ty();
    }


    @Override
    public ZT_SaihakkouSyoukenSuii2Ty getSaihakkouSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        return hozendiskjyusinDomManager.getSaihakkouSyoukenSuii2Ty(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuSyoukenSuii2Rn> getAllSinkeiyakuSyoukenSuii2Rn() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuSyoukenSuii2Rn();
    }


    @Override
    public ZT_SinkeiyakuSyoukenSuii2Rn getSinkeiyakuSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        return hozendiskjyusinDomManager.getSinkeiyakuSyoukenSuii2Rn(pZrnsyono, pZrntyouhyouymd, pZrnsuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_SinkeiyakuSyoukenSuii2Ty> getAllSinkeiyakuSyoukenSuii2Ty() {
        return hozendiskjyusinDomManager.getAllSinkeiyakuSyoukenSuii2Ty();
    }


    @Override
    public ZT_SinkeiyakuSyoukenSuii2Ty getSinkeiyakuSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        return hozendiskjyusinDomManager.getSinkeiyakuSyoukenSuii2Ty(pZtysyono, pZtytyouhyouymd, pZtysuiihyouptn);
    }


    @Override
    public ExDBResults<ZT_DrtenSkKykDtlSyokaiTy> getAllDrtenSkKykDtlSyokaiTy() {
        return hozendiskjyusinDomManager.getAllDrtenSkKykDtlSyokaiTy();
    }


    @Override
    public ZT_DrtenSkKykDtlSyokaiTy getDrtenSkKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        return hozendiskjyusinDomManager.getDrtenSkKykDtlSyokaiTy(pZtysakuseiym, pZtybsydrtencd, pZtytntusycd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_DrtenSkKykDtlSyokaiRn> getAllDrtenSkKykDtlSyokaiRn() {
        return hozendiskjyusinDomManager.getAllDrtenSkKykDtlSyokaiRn();
    }


    @Override
    public ZT_DrtenSkKykDtlSyokaiRn getDrtenSkKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getDrtenSkKykDtlSyokaiRn(pZrnsakuseiym, pZrnbsydrtencd, pZrntntusycd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_ZennouHoyuuIdouKykDtlTy> getAllZennouHoyuuIdouKykDtlTy() {
        return hozendiskjyusinDomManager.getAllZennouHoyuuIdouKykDtlTy();
    }


    @Override
    public ZT_ZennouHoyuuIdouKykDtlTy getZennouHoyuuIdouKykDtlTy(String pZtydatakanrino, String pZtysyoricd, Integer pZtykykmfksnctr) {
        return hozendiskjyusinDomManager.getZennouHoyuuIdouKykDtlTy(pZtydatakanrino, pZtysyoricd, pZtykykmfksnctr);
    }


    @Override
    public ExDBResults<ZT_ZennouHoyuuIdouKykDtlRn> getAllZennouHoyuuIdouKykDtlRn() {
        return hozendiskjyusinDomManager.getAllZennouHoyuuIdouKykDtlRn();
    }


    @Override
    public ZT_ZennouHoyuuIdouKykDtlRn getZennouHoyuuIdouKykDtlRn(String pZrndatakanrino, String pZrnsyoricd, Integer pZrnkykmfksnctr) {
        return hozendiskjyusinDomManager.getZennouHoyuuIdouKykDtlRn(pZrndatakanrino, pZrnsyoricd, pZrnkykmfksnctr);
    }


    @Override
    public ExDBResults<ZT_SyoumetuTuutiTy> getAllSyoumetuTuutiTy() {
        return hozendiskjyusinDomManager.getAllSyoumetuTuutiTy();
    }


    @Override
    public ZT_SyoumetuTuutiTy getSyoumetuTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getSyoumetuTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_SyoumetuTuutiRn> getAllSyoumetuTuutiRn() {
        return hozendiskjyusinDomManager.getAllSyoumetuTuutiRn();
    }


    @Override
    public ZT_SyoumetuTuutiRn getSyoumetuTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getSyoumetuTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public ExDBResults<ZT_GentumiSkMikomirituULFTy> getAllGentumiSkMikomirituULFTy() {
        return hozendiskjyusinDomManager.getAllGentumiSkMikomirituULFTy();
    }


    @Override
    public ZT_GentumiSkMikomirituULFTy getGentumiSkMikomirituULFTy(String pZtydatakanrino) {
        return hozendiskjyusinDomManager.getGentumiSkMikomirituULFTy(pZtydatakanrino);
    }


    @Override
    public ExDBResults<ZT_GentumiSkMikomirituULFRn> getAllGentumiSkMikomirituULFRn() {
        return hozendiskjyusinDomManager.getAllGentumiSkMikomirituULFRn();
    }


    @Override
    public ZT_GentumiSkMikomirituULFRn getGentumiSkMikomirituULFRn(String pZrndatakanrino) {
        return hozendiskjyusinDomManager.getGentumiSkMikomirituULFRn(pZrndatakanrino);
    }


    @Override
    public ExDBResults<ZT_SinBosyuuDrtenHoyuuKykTy> getAllSinBosyuuDrtenHoyuuKykTy() {
        return hozendiskjyusinDomManager.getAllSinBosyuuDrtenHoyuuKykTy();
    }


    @Override
    public ZT_SinBosyuuDrtenHoyuuKykTy getSinBosyuuDrtenHoyuuKykTy(String pZtysyono) {
        return hozendiskjyusinDomManager.getSinBosyuuDrtenHoyuuKykTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_SinBosyuuDrtenHoyuuKykRn> getAllSinBosyuuDrtenHoyuuKykRn() {
        return hozendiskjyusinDomManager.getAllSinBosyuuDrtenHoyuuKykRn();
    }


    @Override
    public ZT_SinBosyuuDrtenHoyuuKykRn getSinBosyuuDrtenHoyuuKykRn(String pZrnsyono) {
        return hozendiskjyusinDomManager.getSinBosyuuDrtenHoyuuKykRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_UriageSousinTy> getAllUriageSousinTy() {
        return hozendiskjyusinDomManager.getAllUriageSousinTy();
    }


    @Override
    public ZT_UriageSousinTy getUriageSousinTy(String pZtycreditkessaiyouno, String pZtysyono, String pZtyuriageseikyuuymd, Long pZtyrsgaku, String pZtyrecordno) {
        return hozendiskjyusinDomManager.getUriageSousinTy(pZtycreditkessaiyouno, pZtysyono, pZtyuriageseikyuuymd, pZtyrsgaku, pZtyrecordno);
    }


    @Override
    public ExDBResults<ZT_UriageSousinRn> getAllUriageSousinRn() {
        return hozendiskjyusinDomManager.getAllUriageSousinRn();
    }


    @Override
    public ZT_UriageSousinRn getUriageSousinRn(String pZrncreditkessaiyouno, String pZrnsyono, String pZrnuriageseikyuuymd, Long pZrnrsgaku, String pZrnrecordno) {
        return hozendiskjyusinDomManager.getUriageSousinRn(pZrncreditkessaiyouno, pZrnsyono, pZrnuriageseikyuuymd, pZrnrsgaku, pZrnrecordno);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinCreditTy> getAllKesikomiSousinCreditTy() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinCreditTy();
    }


    @Override
    public ZT_KesikomiSousinCreditTy getKesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinCreditTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_KesikomiSousinCreditRn> getAllKesikomiSousinCreditRn() {
        return hozendiskjyusinDomManager.getAllKesikomiSousinCreditRn();
    }


    @Override
    public ZT_KesikomiSousinCreditRn getKesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        return hozendiskjyusinDomManager.getKesikomiSousinCreditRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }


    @Override
    public ExDBResults<ZT_YuukouseiNgTuutiTy> getAllYuukouseiNgTuutiTy() {
        return hozendiskjyusinDomManager.getAllYuukouseiNgTuutiTy();
    }


    @Override
    public ZT_YuukouseiNgTuutiTy getYuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getYuukouseiNgTuutiTy(pZtytyouhyouymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_YuukouseiNgTuutiRn> getAllYuukouseiNgTuutiRn() {
        return hozendiskjyusinDomManager.getAllYuukouseiNgTuutiRn();
    }


    @Override
    public ZT_YuukouseiNgTuutiRn getYuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getYuukouseiNgTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_DSeisanShrTysySyuseiTy> getAllDSeisanShrTysySyuseiTy() {
        return hozendiskjyusinDomManager.getAllDSeisanShrTysySyuseiTy();
    }


    @Override
    public ZT_DSeisanShrTysySyuseiTy getDSeisanShrTysySyuseiTy(String pZtysyono) {
        return hozendiskjyusinDomManager.getDSeisanShrTysySyuseiTy(pZtysyono);
    }


    @Override
    public ExDBResults<ZT_DSeisanShrTysySyuseiRn> getAllDSeisanShrTysySyuseiRn() {
        return hozendiskjyusinDomManager.getAllDSeisanShrTysySyuseiRn();
    }


    @Override
    public ZT_DSeisanShrTysySyuseiRn getDSeisanShrTysySyuseiRn(String pZrnsyono) {
        return hozendiskjyusinDomManager.getDSeisanShrTysySyuseiRn(pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_SeisanDHaneiTuutiTy> getAllSeisanDHaneiTuutiTy() {
        return hozendiskjyusinDomManager.getAllSeisanDHaneiTuutiTy();
    }


    @Override
    public ZT_SeisanDHaneiTuutiTy getSeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {
        return hozendiskjyusinDomManager.getSeisanDHaneiTuutiTy(pZtytyouhyouymd, pZtykeysyono);
    }


    @Override
    public ExDBResults<ZT_SeisanDHaneiTuutiRn> getAllSeisanDHaneiTuutiRn() {
        return hozendiskjyusinDomManager.getAllSeisanDHaneiTuutiRn();
    }


    @Override
    public ZT_SeisanDHaneiTuutiRn getSeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {
        return hozendiskjyusinDomManager.getSeisanDHaneiTuutiRn(pZrntyouhyouymd, pZrnkeysyono);
    }


    @Override
    public ExDBResults<ZT_DairitenGtmtZndkTy> getAllDairitenGtmtZndkTy() {
        return hozendiskjyusinDomManager.getAllDairitenGtmtZndkTy();
    }


    @Override
    public ZT_DairitenGtmtZndkTy getDairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono) {
        return hozendiskjyusinDomManager.getDairitenGtmtZndkTy(pZtydatakijyunymd, pZtysyono);
    }


    @Override
    public ExDBResults<ZT_DairitenGtmtZndkRn> getAllDairitenGtmtZndkRn() {
        return hozendiskjyusinDomManager.getAllDairitenGtmtZndkRn();
    }


    @Override
    public ZT_DairitenGtmtZndkRn getDairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono) {
        return hozendiskjyusinDomManager.getDairitenGtmtZndkRn(pZrndatakijyunymd, pZrnsyono);
    }


    @Override
    public ExDBResults<ZT_CreditHnknTuutiTy> getAllCreditHnknTuutiTy() {
        return hozendiskjyusinDomManager.getAllCreditHnknTuutiTy();
    }


    @Override
    public ZT_CreditHnknTuutiTy getCreditHnknTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return hozendiskjyusinDomManager.getCreditHnknTuutiTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_CreditHnknTuutiRn> getAllCreditHnknTuutiRn() {
        return hozendiskjyusinDomManager.getAllCreditHnknTuutiRn();
    }


    @Override
    public ZT_CreditHnknTuutiRn getCreditHnknTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return hozendiskjyusinDomManager.getCreditHnknTuutiRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }



    @Override
    public ExDBResults<ZT_KzhuriSyuunouKekkaRn> getAllKzhuriSyuunouKekkaRn() {
        return hozenkydiskjyusinDomManager.getAllKzhuriSyuunouKekkaRn();
    }


    @Override
    public ZT_KzhuriSyuunouKekkaRn getKzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {
        return hozenkydiskjyusinDomManager.getKzhuriSyuunouKekkaRn(pZrnsyono, pZrnjyuutouym);
    }


    @Override
    public ExDBResults<ZT_KzhuriSyuunouKekkaTr> getAllKzhuriSyuunouKekkaTr() {
        return hozenkydiskjyusinDomManager.getAllKzhuriSyuunouKekkaTr();
    }


    @Override
    public ZT_KzhuriSyuunouKekkaTr getKzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {
        return hozenkydiskjyusinDomManager.getKzhuriSyuunouKekkaTr(pZtrsyono, pZtrjyuutouym);
    }


    @Override
    public ExDBResults<ZT_UriageKekkaTr> getAllUriageKekkaTr() {
        return hozenkydiskjyusinDomManager.getAllUriageKekkaTr();
    }


    @Override
    public ZT_UriageKekkaTr getUriageKekkaTr(String pZtrsyono, String pZtrcreditkessaiyouno, String pZtruriageymd6keta, String pZtrrecordno, Long pZtrseikyuukngk) {
        return hozenkydiskjyusinDomManager.getUriageKekkaTr(pZtrsyono, pZtrcreditkessaiyouno, pZtruriageymd6keta, pZtrrecordno, pZtrseikyuukngk);
    }


    @Override
    public ExDBResults<ZT_UriageKekkaRn> getAllUriageKekkaRn() {
        return hozenkydiskjyusinDomManager.getAllUriageKekkaRn();
    }


    @Override
    public ZT_UriageKekkaRn getUriageKekkaRn(String pZrnsyono, String pZrncreditkessaiyouno, String pZrnuriageymd6keta, String pZrnrecordno, Long pZrnseikyuukngk) {
        return hozenkydiskjyusinDomManager.getUriageKekkaRn(pZrnsyono, pZrncreditkessaiyouno, pZrnuriageymd6keta, pZrnrecordno, pZrnseikyuukngk);
    }


    @Override
    public ExDBResults<ZT_YuukouKakKekkaFRn> getAllYuukouKakKekkaFRn() {
        return hozenkydiskjyusinDomManager.getAllYuukouKakKekkaFRn();
    }


    @Override
    public ZT_YuukouKakKekkaFRn getYuukouKakKekkaFRn(String pZrncreditkessaiyouno) {
        return hozenkydiskjyusinDomManager.getYuukouKakKekkaFRn(pZrncreditkessaiyouno);
    }


    @Override
    public ExDBResults<ZT_YuukouKakKekkaFTr> getAllYuukouKakKekkaFTr() {
        return hozenkydiskjyusinDomManager.getAllYuukouKakKekkaFTr();
    }


    @Override
    public ZT_YuukouKakKekkaFTr getYuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {
        return hozenkydiskjyusinDomManager.getYuukouKakKekkaFTr(pZtrcreditkessaiyouno);
    }


    @Override
    public ExDBResults<ZT_AuthoriKekkaRn> getAllAuthoriKekkaRn() {
        return hozenkydiskjyusinDomManager.getAllAuthoriKekkaRn();
    }


    @Override
    public ZT_AuthoriKekkaRn getAuthoriKekkaRn(String pZrnrenno7, String pZrncreditkessaiyouno, String pZrndatajyusinymd) {
        return hozenkydiskjyusinDomManager.getAuthoriKekkaRn(pZrnrenno7, pZrncreditkessaiyouno, pZrndatajyusinymd);
    }


    @Override
    public ExDBResults<ZT_AuthoriKekkaTr> getAllAuthoriKekkaTr() {
        return hozenkydiskjyusinDomManager.getAllAuthoriKekkaTr();
    }


    @Override
    public ZT_AuthoriKekkaTr getAuthoriKekkaTr(String pZtrrenno7, String pZtrcreditkessaiyouno, String pZtrdatajyusinymd) {
        return hozenkydiskjyusinDomManager.getAuthoriKekkaTr(pZtrrenno7, pZtrcreditkessaiyouno, pZtrdatajyusinymd);
    }



    @Override
    public ExDBResults<ZT_AiKyuubuByoumeiRn> getAllAiKyuubuByoumeiRn() {
        return siharaidiskjyusinDomManager.getAllAiKyuubuByoumeiRn();
    }


    @Override
    public ZT_AiKyuubuByoumeiRn getAiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {
        return siharaidiskjyusinDomManager.getAiKyuubuByoumeiRn(pZrnbyoumeitourokuno);
    }


    @Override
    public ExDBResults<ZT_SiShrdetailTy> getAllSiShrdetailTy() {
        return siharaidiskjyusinDomManager.getAllSiShrdetailTy();
    }


    @Override
    public ZT_SiShrdetailTy getSiShrdetailTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        return siharaidiskjyusinDomManager.getSiShrdetailTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }


    @Override
    public ExDBResults<ZT_SiShrdetailRn> getAllSiShrdetailRn() {
        return siharaidiskjyusinDomManager.getAllSiShrdetailRn();
    }


    @Override
    public ZT_SiShrdetailRn getSiShrdetailRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        return siharaidiskjyusinDomManager.getSiShrdetailRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }


    @Override
    public Long getAiKyuubuByoumeiRnCount() {
        return siharaidiskjyusinDomManager.getAiKyuubuByoumeiRnCount();
    }



    @Override
    public ExDBResults<ZT_DsKariPasswordTuutiTy> getAllDsKariPasswordTuutiTy() {
        return directServiceDomManager.getAllDsKariPasswordTuutiTy();
    }


    @Override
    public ZT_DsKariPasswordTuutiTy getDsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {
        return directServiceDomManager.getDsKariPasswordTuutiTy(pZtykrpasswordtuutikey);
    }


    @Override
    public ExDBResults<ZT_DsKariPasswordTuutiRn> getAllDsKariPasswordTuutiRn() {
        return directServiceDomManager.getAllDsKariPasswordTuutiRn();
    }


    @Override
    public ZT_DsKariPasswordTuutiRn getDsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {
        return directServiceDomManager.getDsKariPasswordTuutiRn(pZrnkrpasswordtuutikey);
    }


    @Override
    public ExDBResults<ZT_DsHanyouKokyakuTuutiRn> getAllDsHanyouKokyakuTuutiRn() {
        return directServiceDomManager.getAllDsHanyouKokyakuTuutiRn();
    }


    @Override
    public ZT_DsHanyouKokyakuTuutiRn getDsHanyouKokyakuTuutiRn(String pZrndshanyoukokatetuutikey, String pZrndskokno, String pZrndstuutikbn) {
        return directServiceDomManager.getDsHanyouKokyakuTuutiRn(pZrndshanyoukokatetuutikey, pZrndskokno, pZrndstuutikbn);
    }


    @Override
    public ExDBResults<ZT_DsHanyouKokyakuTuutiTy> getAllDsHanyouKokyakuTuutiTy() {
        return directServiceDomManager.getAllDsHanyouKokyakuTuutiTy();
    }


    @Override
    public ZT_DsHanyouKokyakuTuutiTy getDsHanyouKokyakuTuutiTy(String pZtydshanyoukokatetuutikey, String pZtydskokno, String pZtydstuutikbn) {
        return directServiceDomManager.getDsHanyouKokyakuTuutiTy(pZtydshanyoukokatetuutikey, pZtydskokno, pZtydstuutikbn);
    }

}
