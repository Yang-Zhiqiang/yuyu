package yuyu.def.sinkeiyaku.manager;

import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.base.manager.DomManager;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.entity.HT_BAK_SkDenpyoData;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.entity.HT_BAK_SyoriCTL;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SouseirituKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.def.sinkeiyaku.result.bean.BosKihonInfosByKakutyoujobcdItemsBean;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean;
import yuyu.def.sinkeiyaku.result.bean.HubimikaishoInfosBean;
import yuyu.def.sinkeiyaku.result.bean.KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean;
import yuyu.def.sinkeiyaku.result.bean.NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;
import yuyu.def.sinkeiyaku.result.bean.SkhubibunsekiInfosBean;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;


/**
 * 新契約 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface SinkeiyakuDomManager extends DomManager {


    List<HT_SyoriCTL> getAllSyoriCTL();


    HT_SyoriCTL getSyoriCTL(String pMosno);


    List<HT_SyoriCTL> getSyoriCTLsBySyono(String pSyono);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymd(BizDate pSrsyoriymd);


    List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNe(String pSakuinnmno, String pMosno);


    List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(String pSakuinnmno, String pMosno, C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosym(String pKakutyoujobcd, BizDateYM pMosymFrom, BizDateYM pMosymTo);


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(String pKakutyoujobcd, BizDateYM pHanteikijyunymnyuukin, BizDateYM pHanteikijyunymminyuukin);


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(String pKakutyoujobcd, BizDateYM pHanteikijyunymdto, BizDateYM pHanteikijyunymdfrom);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(String pKakutyoujobcd, BizDateYM pMosym);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(String pKakutyoujobcd, C_SeirituKbn pSeiritukbn, BizDate pSrsyoriymd);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(String pKakutyoujobcd, BizDateYM pBosyuuym);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymdNull(BizDate pSrsyoriymd);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM pBosyuuym);


    List<HT_MosDairiten> getKoseiinKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym);


    List<HT_MosDairiten> getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym);


    List<HT_SyoriCTL> getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(String pDaimosno, String pMosno);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymd(BizDate pHnknsyoriymd);


    ExDBResults<SkhubibunsekiInfosBean>  getSkhubibunsekiInfos(BizDate pTysytTaisyouYmdFrom, BizDate pTysytTaisyouYmdTo);


    ExDBResults<HT_SyoriCTL> getSmbcSnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd);


    ExDBResults<HT_SyoriCTL> getSmbcHnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd);


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(String pKakutyoujobcd, BizDateYM pSeisekiym, BizDateYM pBosyuuym);


    List<HT_JigyouIkkatu> getAllJigyouIkkatu();


    HT_JigyouIkkatu getJigyouIkkatu(String pDaimosno);


    List<HT_SkHubi> getSkHubisByMosnoHasinymdKaisyouymd(String pMosno, BizDate pHasinymd, BizDate pKaisyouymd);


    ExDBResults<HubimikaishoInfosBean> getHubimikaishoInfos();


    List<HT_SkHubi> getSkHubisByMosnoKaisyouymdHasinymd(String pMosno);


    List<C_SyoruiCdKbn> getSkHubiDetailsByMosnoKaisyouymdNull(String pMosno);


    ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean>  getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(String pKakutyoujobcd);


    List<HT_SkHubiDetail> getSkHubiDetailsByMosym(BizDateYM pMosym);


    Integer getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(String pMosno, String pHubisikibetukey);


    Long getSkHubiDetailCountByMosnoTrkymdHasinymd(String pMosno);


    Long getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(String pMosno);


    Long getSkHubiDetailCountByMosnoKaisyouymd(String pMosno);


    Long getSkHubiDetailCountByPkHasinkyokakbn(String pMosno, String pHubisikibetukey);


    List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(String pHubisikibetukey);


    List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(String pHubisikibetukey);


    List<HT_BAK_SyoriCTL> getAllBAKSyoriCTL();


    HT_BAK_SyoriCTL getBAKSyoriCTL(String pMosno, String pTrkssikibetukey);


    List<HT_BAK_SyoriCTL> getBAKSyoriCTLsByMosno(String pMosno);


    List<HT_BAK_SyoriCTL> getBAKSyoriCTLsBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);


    List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> getSyoukaiIchiranInfosByMosymdBosyuuymItems(BizDate pMosfromymd, BizDate pMostoymd, String pDaimosno, BizDateYM pBosyuuym, C_UmuKbn pNyknnrkumu, C_KetteiKbn pKetteikbn
        , C_SeirituKbn pSeiritukbn, C_UmuKbn pKthhbkbn, C_HknsyuruiNo pHknsyuruino, String pTratkiagcd, String pOyadrtencd
        , boolean pSrhumu, boolean pMkshb, String pKyknmkn, BizDate pKykseiymd);


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymd(String pKakutyoujobcd, BizDate pSrsyoriymd);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(String pKakutyoujobcd, BizDate pSrsyoriymd);


    List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(String pMosno, String pSubSystemId);


    ExDBResults<HT_KmTsRireki> getKmtsrirekisBySyoriTime(String pSyoriTimeFrom, String pSyoriTimeTo);


    Long getKmTsRirekiDistinctSyoriTimeCountByMosno(String pMosno);


    List<HT_MosKihon> getMosKihonsByUktkid(String pUktkid);


    List<HT_MosKihon> getMosKihonsByUktkidMosnoNe(String pUktkid, String pMosno);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym);


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(String pKakutyoujobcd, BizDate pMosnrkymd);


    Long getSyoriCTLCountBySeiritukbnsKykkbn(String pKeiyakusyanm);


    Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(String pBsyujoyadrtencd, String pKeiyakusyanm);


    Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(String pBsyujoyadrtencd);


    List<HT_SkHubiDetail> getSkHubiDetailsByMosnoSyoruicd(String pMosno, C_SyoruiCdKbn pSyoruiCdKbn);



    List<HM_KetteiSya> getAllKetteiSya();


    HM_KetteiSya getKetteiSya(String pKetsyacd);


    HT_MostenkenRireki getMostenkenRirekiByMosnoMaxRenno(String pMosno);


    Long getMostenkenRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd);


    BizDate getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(String pMosno);


    List<HM_KetteiSya> getKetteiSyasByKetsyacdMostenkenrankkbns(String pKetsyacd, C_MostenkenRankKbn... pMostenkenrankkbn);


    List<HM_KetteiSya> getKetteiSyasByKetsyacdImusateirankkbns(String pKetsyacd, C_ImusateirankKbn... pImusateirankkbn);


    List<HM_KetteiSya> getKetteiSyasByKetsyacdKnksateirankkbns(String pKetsyacd, C_KnksateirankKbn... pKnksateirankkbn);


    List<HM_KetteiSya> getKetteiSyasByKetsyacdKetsyanm(String pKetsyacd, String pKetsyanm);


    Integer getImusateiRirekiMaxRennoByMosno(String pMosno);


    Long getImusateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd);


    HT_ImusateiRireki getImusateiRirekiByMosnoMaxRenno(String pMosno);


    HT_ImusateiRireki getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(String pMosno, C_SyorikekkaKbn pImusateikekkakbn);


    BizDate getSkDenpyoDataMinDenymdByMosnoRstuukasyu(String pMosno, C_Tuukasyu pRstuukasyu);


    HT_KnksateiRireki getKnksateiRirekiByMosnoMaxRenno(String pMosno);


    Long getKnksateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd);


    Integer getDakuhiKetteiMaxDakuhiktrennoByMosno(String pMosno);


    HT_DakuhiKettei getDakuhiKetteiByMosnoMaxDakuhiktrenno(String pMosno);


    HT_DakuhiKettei getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(String pMosno, C_DakuhiktbunruiKbn pDakuhiktbunruikbn);


    HT_KykKak getKykKakByMosnoMaxRenno(String pMosno);


    Integer getKykKakMaxRennoByMosno(String pMosno);


    List<HT_DakuhiKettei> getDakuhiKetteisByKetsyacd(String pKetsyacd);


    List<HT_Tokunin> getTokuninsByKetsyacd(String pKetsyacd);


    HT_MostenkenRireki getMostenkenRirekiByMosnoKanryouMaxRenno(String pMosno);



    List<HT_SkDenpyoData> getAllSkDenpyoData();


    HT_SkDenpyoData getSkDenpyoData(String pDenrenno, Integer pEdano);


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByHenkin(String pMosno, Integer pRenno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd, BizDate pHnknsyoriymd);


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(String pMosno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd);


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByNyksyoriymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pNyksyoriymd);


    List<HT_SkDenpyoData> getSkDenpyoDatasByDenrenno(String pDenrenno);


    List<HT_SkDenpyoData> getSkDenpyoDatasByMosno(String pMosno);


    List<HT_SkDenpyoData> getSkDenpyoDatasBySyono(String pSyono);


    ExDBUpdatableResults<HT_SkDenpyoData> getSkDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<HT_SkFBSoukinData> getAllSkFBSoukinData();


    HT_SkFBSoukinData getSkFBSoukinData(String pFbsoukindatasikibetukey);


    ExDBResults<HT_SkFBSoukinData> getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<HT_SkFBSoukinData> getSkFBSoukinDatasByMosno(String pMosno);


    List<HT_SkGaikaFBSoukinData> getAllSkGaikaFBSoukinData();


    HT_SkGaikaFBSoukinData getSkGaikaFBSoukinData(String pFbsoukindatasikibetukey);


    ExDBResults<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByMosno(String pMosno);


    Integer getHenkinMaxRennoByMosno(String pMosno);


    List<HT_HrkmNyknData> getAllHrkmNyknData();


    HT_HrkmNyknData getHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno);


    List<HT_HrkmNyknData> getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk);


    List<HT_HrkmNyknData> getHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140
        , BizDate pSyoriYmd, Integer pIribaraikbn);


    ExDBUpdatableResults<HT_HrkmNyknData> getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg);


    List<HT_GaikaHrkmNyknData> getAllGaikaHrkmNyknData();


    HT_GaikaHrkmNyknData getGaikaHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno);


    List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk);


    List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140, BizDate pSyoriYmd
        , Integer pIribaraikbn);


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdDengk(String pKakutyoujobcd);


    List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean> getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate pSyoriYmd, BizDate pZengetuLastd, C_Tuukasyu pTuukasyu);


    List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate pKsnymd, C_Tuukasyu pTuukasyu);


    List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate pSyoriYmd, C_Tuukasyu pTuukasyu);


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(String pKakutyoujobcd, BizDate pSyoriYmd, Integer pIribaraikbn);


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg);


    List<HW_HrkmNyknTaisyouWk> getAllHrkmNyknTaisyouWk();


    HW_HrkmNyknTaisyouWk getHrkmNyknTaisyouWk(BizDate pSyoriYmd, String pMosno, Integer pRenno);


    ExDBResults<HW_HrkmNyknTaisyouWk>  getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<HW_NyuukinJyouhouHuittiWk> getAllNyuukinJyouhouHuittiWk();


    HW_NyuukinJyouhouHuittiWk getNyuukinJyouhouHuittiWk(BizDate pNyksyoriymd, String pItirenno);


    List<HW_MosMatiKknKeikaWk> getAllMosMatiKknKeikaWk();


    HW_MosMatiKknKeikaWk getMosMatiKknKeikaWk(BizDate pNyksyoriymd, String pItirenno);


    List<HT_HrkmNyknSakujyo> getAllHrkmNyknSakujyo();


    HT_HrkmNyknSakujyo getHrkmNyknSakujyo(String pHrkmdeldataskbtkey);


    List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosBySyorizumiflg(C_Syorizumiflg pSyorizumiflg);


    List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(String pOyadrtencd, String pMosno, String pHrkmirninnm, BizCurrency pTrhkkgk, C_Tuukasyu pRstuukasyu, C_Syorizumiflg pSyorizumiflg);


    ExDBUpdatableResults<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg);


    List<HW_JidouNyknTaisyougaiWk> getAllJidouNyknTaisyougaiWk();


    HW_JidouNyknTaisyougaiWk getJidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno);


    List<HT_JidouSyuunouMeisai> getAllJidouSyuunouMeisai();


    HT_JidouSyuunouMeisai getJidouSyuunouMeisai(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu);


    List<HW_SikinIdouWk> getAllSikinIdouWk();


    HW_SikinIdouWk getSikinIdouWk(BizDate pNyksyoriymd, String pItirenno);


    List<HT_GrossNykn> getAllGrossNykn();


    HT_GrossNykn getGrossNykn(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno);


    List<HT_GrossNyknMeisai> getAllGrossNyknMeisai();


    HT_GrossNyknMeisai getGrossNyknMeisai(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno, Integer pMeisairenno);


    List<HT_SkKouzahuriAnnaiData> getAllSkKouzahuriAnnaiData();


    HT_SkKouzahuriAnnaiData getSkKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym);


    List<HT_SkKouzahuriAnnaiData> getSkKouzahuriAnnaiDatasByMosno(String pMosno);


    List<HT_SkSyuunouKekkaData> getAllSkSyuunouKekkaData();


    HT_SkSyuunouKekkaData getSkSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, BizDateYM pJyuutouym);


    List<HT_SkSyuunouKekkaData> getSkSyuunouKekkaDatasByMosno(String pMosno);


    List<HT_SkUriageData> getAllSkUriageData();


    HT_SkUriageData getSkUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, Integer pAuthorikaisuu);


    List<HT_SkUriageData> getSkUriageDatasByMosno(String pMosno);


    List<HT_BAK_SkDenpyoData> getAllBAKSkDenpyoData();


    HT_BAK_SkDenpyoData getBAKSkDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano);


    List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);


    List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasByMosno(String pMosno);


    HT_Nyuukin getNyuukinByMosnoMaxRenno(String pMosno);


    DengkByMosnoRstuukasyuBean getDengkByMosnoRstuukasyuRyosyuymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pRyosyuymd);


    Integer getHenteiRirekiMaxRennoByMosno(String pMosno);


    BizDate getNyuukinMinRyosyuymdByMosno(String pMosno);


    BizDate getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(String pMosno);


    BizDate getNyuukinMinRyosyuymdByMosnoZenhnknkbn(String pMosno, C_ZenhnknKbn pZenhnknkbn);


    BizDate getNyuukinMaxRyosyuymdByMosno(String pMosno);


    Integer getNyuukinMaxRennoByMosno(String pMosno);


    Map<CurrencyType, BizCurrency> getNyuukinSumRyosyugkByMosnoMaxRenno(String pMosno);


    HT_Nyuukin getNyuukinByMosnoMinRenno(String pMosno);


    Long getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(String pMosno);


    HT_Nyuukin getNyuukinByMosnoRyosyuymdZenhnknkbn(String pMosno, BizDate pRyosyuymd);


    NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(String pMosno);


    Integer getJigyouIkkatuNyuukinMaxRennoByDaimosno(String pDaimosno);


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymd(String pMosno, BizDate pHnknsyoriymd);


    Long getHenkinCountByMosnoHnknsyoriymd(String pMosno);


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(String pMosno, BizDate pHnknsyoriymd, C_Tuukasyu pHnkntuukasyu);


    List<BizCurrency> getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd);


    Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByMosnoHnkntuukasyu(String pMosno, C_Tuukasyu pHnkntuukasyu);


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd);


    Integer getHenkinMaxZenhnknrenno(String pMosno);


    List<HT_SkCreditCardQrTrkMihanei> getAllSkCreditCardQrTrkMihanei();


    HT_SkCreditCardQrTrkMihanei getSkCreditCardQrTrkMihanei(BizDate pSyoriYmd, BizDate pSystemjyusinymd, String pSystemjyusintime, String pCreditkessaiyouno);


    List<HW_CreditTrkHaneierrList> getAllCreditTrkHaneierrList();


    HW_CreditTrkHaneierrList getCreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno);


    List<HW_CreditTrkNgList> getAllCreditTrkNgList();


    HW_CreditTrkNgList getCreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno);


    List<HT_SkKouhuriUkTrkMihanei> getAllSkKouhuriUkTrkMihanei();


    HT_SkKouhuriUkTrkMihanei getSkKouhuriUkTrkMihanei(BizDate pSyoriYmd, String pSyukkncd, String pKinyuucd8keta, BizDate pKinyuukkntratkiymd, String pKinyuukkntratkitime
        , String pKouhuriokyakusamano);


    List<HT_JidouSyuunouMeisai2> getAllJidouSyuunouMeisai2();


    HT_JidouSyuunouMeisai2 getJidouSyuunouMeisai2(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn pNyktyhyoutkbn);



    List<HT_SmbcStyKanri> getAllSmbcStyKanri();


    HT_SmbcStyKanri getSmbcStyKanri(BizDate pDatarenymd, BizNumber pDatasakuseirenno);


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcd(String pKakutyoujobcd);


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno(String pKakutyoujobcd);


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno(String pKakutyoujobcd);


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySmbcsyono(String pSmbcsyono);


    List<HT_SisyaToukeiHokan> getAllSisyaToukeiHokan();


    HT_SisyaToukeiHokan getSisyaToukeiHokan(String pSstmosno, Integer pRenno);


    List<HT_SisyaToukeiHokan> getSisyaToukeiHokansBySstmosno(String pSstmosno);


    List<HT_SkLincJyusinData> getAllSkLincJyusinData();


    HT_SkLincJyusinData getSkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno);


    HT_SkLincJyusinData getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(String pMosno);


    List<HT_SkLincJyusinData> getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate pSyoriYmd, String pLinckyknaiykekdatarennooya);


    List<HT_SkLincSousinData> getAllSkLincSousinData();


    HT_SkLincSousinData getSkLincSousinData(String pMosno, BizDate pSyoriYmd, Integer pRenno);


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyono(String pSyono);


    List<HT_SmbcStyKanri> getSmbcStyKanrisByMosno(String pMosno);


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoRendouflg(String pSyono);


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(String pSyono, String pSmbcseihosyknhkkzmymd);


    BizNumber getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate pDatarenymd);


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(String pSyono, String pSmbcseihosyknhkkzmymd, String pSmbcseihotrksymd);


    List<HT_SmbcStyKanriSsRireki> getAllSmbcStyKanriSsRireki();


    HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRireki(String pSyono);


    List<HT_SmbcStyKanriSsRireki> getSmbcStyKanriSsRirekisByMosno(String pMosno);


    HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(String pSyono, String pSyrctrltblkostime);


    List<HT_BAK_SmbcStyKanri> getAllBAKSmbcStyKanri();


    List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);


    List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisByMosno(String pMosno);


    HT_BAK_SmbcStyKanri getBAKSmbcStyKanri(BizDate pDatarenymd, String pTrkssikibetukey, BizNumber pDatasakuseirenno);



    List<HT_IjitoukeiMeisai> getAllIjitoukeiMeisai();


    HT_IjitoukeiMeisai getIjitoukeiMeisai(String pSyono, Integer pRenno8keta);


    List<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyono(String pSyono);


    ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo);


    List<HW_SyuHukugouSikkanZhkWk> getAllSyuHukugouSikkanZhkWk();


    HW_SyuHukugouSikkanZhkWk getSyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo);


    ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(String pKakutyoujobcd, BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo, BizDateYM pBosyuuymTo, BizDate pIdousyoriymdTo);



    List<HT_SouseirituKihon> getAllSouseirituKihon();


    HT_SouseirituKihon getSouseirituKihon(String pSyono);



    List<HT_YuukoukknKykList> getAllYuukoukknKykList();


    HT_YuukoukknKykList getYuukoukknKykList(String pMosno, BizDate pTyouhyouymd);


    List<HT_YuukoukknKykList> getYuukoukknKykListsByMosno(String pMosno);


    List<HT_MiseirijiyuuMeisai> getAllMiseirijiyuuMeisai();


    HT_MiseirijiyuuMeisai getMiseirijiyuuMeisai(String pMosno);


    List<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn);


    ExDBResults<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn, String pOyadrtencd);



    List<HT_GaibuQrYoyaku2> getAllGaibuQrYoyaku2();


    HT_GaibuQrYoyaku2 getGaibuQrYoyaku2(BizDate pSyoriYmd, C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn);


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymd(BizDate pQrsakuseiymd);


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn, BizDate pQrsakuseiymd);


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymdNull();


    List<HT_MosnoKanri> getAllMosnoKanri();


    HT_MosnoKanri getMosnoKanri(String pMosno8keta);


    String getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(String pMosnoFrom, String pMosnoTo, C_KahiKbn pSaibankahikbn);


    ExDBUpdatableResults<HT_MosnoKanri> getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(String pKakutyoujobcd, BizDate pMossykykyoteiymd);


    List<HT_MosMikakuteiJyouhouKanri> getAllMosMikakuteiJyouhouKanri();


    HT_MosMikakuteiJyouhouKanri getMosMikakuteiJyouhouKanri(String pMosno);


    List<HT_MosMikakuteiSyorui> getAllMosMikakuteiSyorui();


    HT_MosMikakuteiSyorui getMosMikakuteiSyorui(String pDocumentid);


    List<HT_MosMikakuteiSyorui> getMosMikakuteiSyoruisByMosno(String pMosno);



    List<HT_BosKihon> getAllBosKihon();


    HT_BosKihon getBosKihon(String pMosno);


    ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> getBosKihonInfosByKakutyoujobcdItems(String pKakutyoujobcd, C_MosUketukeKbn pMosuketukekbn, C_MosTourokuJyoukyouKbn pMostourokujyoukyoukbn
        , C_UmuKbn  pPplessdatasousinumukbn);



    List<HM_SkHokenSyuruiNo> getAllSkHokenSyuruiNo();


    HM_SkHokenSyuruiNo getSkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd);


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo pHknsyuruino);


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujitoymdGt(BizDate pHyoujitoymd);


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosBySysdate(BizDate pSysdate);


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujidate(BizDate pHyoujidate);


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo pHknsyuruino, BizDate pHyoujidate);


    List<HM_SkHokenSyuruiNoAisyou> getAllSkHokenSyuruiNoAisyou();


    HM_SkHokenSyuruiNoAisyou getSkHokenSyuruiNoAisyou(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosdfrom, Integer pHknsyuruinosdto, String pHknsyuruinobetukey1
        , C_AisyoumeiChannelKbn pAisyoumeichannelkbn);


    List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo pHknsyuruino, C_AisyoumeiChannelKbn pAisyoumeichannelkbn);


    List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByPK(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeichannelkbn, String pHknsyuruinobetukey1);


    List<HM_SkChannel> getAllSkChannel();


    HM_SkChannel getSkChannel(C_Channelcd pChannelcd, String pOyadrtencd);


    List<HM_SkChannel> getSkChannelsByChannelcd(C_Channelcd pChannelcd);


    List<HM_SkDairitenKobetuJyouhou> getAllSkDairitenKobetuJyouhou();


    HM_SkDairitenKobetuJyouhou getSkDairitenKobetuJyouhou(String pOyadrtencd);


    List<HM_SkDairitenKobetuJyouhou> getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn);


    List<HM_TokuteiKankeiHoujin> getAllTokuteiKankeiHoujin();


    List<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(String pTkhjnkinyuucd, String pTkhjnkjdrtennm, String pTkhjnnmkj);


    HM_TokuteiKankeiHoujin getTokuteiKankeiHoujin(String pTkhjnkinyuucd, BizNumber pMeisaino);


    ExDBResults<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujins();


    List<HM_TokuteiKankeiHjnNmTotugou> getAllTokuteiKankeiHjnNmTotugou();


    HM_TokuteiKankeiHjnNmTotugou getTokuteiKankeiHjnNmTotugou(String pTkhjnkinyuucd, BizNumber pMeisaino, Integer pRenno);


    List<String> getTotugoutkhjnnmkjsByTkhjnkinyuucd(String pTkhjnkinyuucd);


    List<HM_SiinBunrui> getAllSiinBunrui();


    HM_SiinBunrui getSiinBunrui(String pSiincd);


    List<HM_SkHubiKoumoku> getAllSkHubiKoumoku();


    HM_SkHubiKoumoku getSkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd, String pSkhubikoumokucd);


    List<HM_SkHubiKoumoku> getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn pSyoruiCd);


    List<HM_SkHubiNaiyou> getSkHubiNaiyousBySkhubikoumokucd(String pSkhubikoumokucd);


    List<HM_SkHubiNaiyou> getAllSkHubiNaiyou();


    HM_SkHubiNaiyou getSkHubiNaiyou(String pSkhubikoumokucd, String pSkhubinaiyoucd);


    List<HM_SkHubiRenrakuNaiyou> getAllSkHubiRenrakuNaiyou();


    HM_SkHubiRenrakuNaiyou getSkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd);


    List<HM_SkSeibiSijiNaiyou> getAllSkSeibiSijiNaiyou();


    HM_SkSeibiSijiNaiyou getSkSeibiSijiNaiyou(String pSkseibisijinaiyoucd);


    List<HM_HurikomiKouza> getAllHurikomiKouza();


    List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyuNe(C_Tuukasyu  pTuukasyu);


    HM_HurikomiKouza getHurikomiKouza(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, String pHrkmirnincd);


    List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, C_YokinKbn pYokinkbn);


    List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu);


    List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyu(C_Tuukasyu pTuukasyu);


    List<HM_ChkTesuuryou> getAllChkTesuuryou();


    HM_ChkTesuuryou getChkTesuuryou(Integer pRenno3keta);


    List<HM_Honkouza> getAllHonkouza();


    HM_Honkouza getHonkouza(String pHonkouzacd);


    List<HM_SyouhnTaniHonkouza> getAllSyouhnTaniHonkouza();


    HM_SyouhnTaniHonkouza getSyouhnTaniHonkouza(String pSyouhncd);


    List<HM_SyouhnTaniHonkouza2> getAllSyouhnTaniHonkouza2();


    HM_SyouhnTaniHonkouza2 getSyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu);



    List<HV_MosSyoruiMitoutyakuList> getAllMosSyoruiMitoutyakuList();


    HV_MosSyoruiMitoutyakuList getMosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno);


    ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate pKnjyymd);

}
