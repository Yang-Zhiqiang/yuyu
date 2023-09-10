package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.base.manager.AbstractDomManager;
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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
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
 * 新契約 DOM マネージャ 実装クラス<br />
 * {@link SinkeiyakuDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class SinkeiyakuDomManagerImpl extends AbstractDomManager implements SinkeiyakuDomManager {


    @Inject
    private MosInfoDomManager mosInfoDomManager;


    @Inject
    private SateiKetInfoDomManager sateiKetInfoDomManager;


    @Inject
    private NyknyInfoDomManager nyknyInfoDomManager;


    @Inject
    private GaibuRendoInfoDomManager gaibuRendoInfoDomManager;


    @Inject
    private IjitoukeiInfoDomManager ijitoukeiInfoDomManager;


    @Inject
    private SouseirituInfoDomManager souseirituInfoDomManager;


    @Inject
    private ReportInfoDomManager reportInfoDomManager;


    @Inject
    private MousikomisyoInfoDomManager mousikomisyoInfoDomManager;


    @Inject
    private BosyuuInfoDomManager bosyuuInfoDomManager;


    @Inject
    private SinkeiyakuMstInfoDomManager sinkeiyakuMstInfoDomManager;


    @Inject
    private ViewDomManager viewDomManager;



    @Override
    public List<HT_SyoriCTL> getAllSyoriCTL() {
        return mosInfoDomManager.getAllSyoriCTL();
    }


    @Override
    public HT_SyoriCTL getSyoriCTL(String pMosno) {
        return mosInfoDomManager.getSyoriCTL(pMosno);
    }


    @Override
    public List<HT_SyoriCTL> getSyoriCTLsBySyono(String pSyono) {
        return mosInfoDomManager.getSyoriCTLsBySyono(pSyono);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymd(BizDate pSrsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsBySrsyoriymd(pSrsyoriymd);
    }


    @Override
    public List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNe(String pSakuinnmno, String pMosno) {
        return mosInfoDomManager.getSyoriCTLsBySakuinnmnoMosnoNe(pSakuinnmno, pMosno);
    }


    @Override
    public List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(String pSakuinnmno, String pMosno, C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {
        return mosInfoDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(pSakuinnmno, pMosno, pSntkinfotaisyousyakbn);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(pKakutyoujobcd, pSeisekiym);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosym(String pKakutyoujobcd, BizDateYM pMosymFrom, BizDateYM pMosymTo) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdMosym(pKakutyoujobcd, pMosymFrom, pMosymTo);
    }


    @Override
    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(String pKakutyoujobcd, BizDateYM pHanteikijyunymnyuukin, BizDateYM pHanteikijyunymminyuukin) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(pKakutyoujobcd, pHanteikijyunymnyuukin, pHanteikijyunymminyuukin);
    }


    @Override
    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(String pKakutyoujobcd, BizDateYM pHanteikijyunymdto, BizDateYM pHanteikijyunymdfrom) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(pKakutyoujobcd, pHanteikijyunymdto, pHanteikijyunymdfrom);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(String pKakutyoujobcd, BizDateYM pMosym) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(pKakutyoujobcd, pMosym);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(String pKakutyoujobcd, C_SeirituKbn pSeiritukbn, BizDate pSrsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(pKakutyoujobcd, pSeiritukbn, pSrsyoriymd);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(String pKakutyoujobcd, BizDateYM pBosyuuym) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(pKakutyoujobcd, pBosyuuym);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymdNull(BizDate pSrsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsBySrsyoriymdNull(pSrsyoriymd);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {
        return mosInfoDomManager.getSyoriCTLsByBosyuuymFromTo(pBosyuuymFrom, pBosyuuymTo);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {
        return mosInfoDomManager.getSyoriCTLsBySeirituKbnBosyuuymFromTo(pBosyuuymFrom, pBosyuuymTo);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM pBosyuuym) {
        return mosInfoDomManager.getSyoriCTLsBySeirituKbnBosyuuym(pBosyuuym);
    }


    @Override
    public List<HT_MosDairiten> getKoseiinKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {
        return mosInfoDomManager.getKoseiinKeiyakuGaitouKeiyakusBySyoriym(pSyoriym);
    }


    @Override
    public List<HT_MosDairiten> getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {
        return mosInfoDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(pSyoriym);
    }


    @Override
    public List<HT_SyoriCTL> getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(String pDaimosno, String pMosno) {
        return mosInfoDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(pDaimosno, pMosno);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymd(BizDate pHnknsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsByHnknsyoriymd(pHnknsyoriymd);
    }


    @Override
    public ExDBResults<SkhubibunsekiInfosBean>  getSkhubibunsekiInfos(BizDate pTysytTaisyouYmdFrom, BizDate pTysytTaisyouYmdTo) {
        return mosInfoDomManager.getSkhubibunsekiInfos(pTysytTaisyouYmdFrom, pTysytTaisyouYmdTo);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSmbcSnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd) {
        return mosInfoDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSmbcHnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd) {
        return mosInfoDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(String pKakutyoujobcd, BizDateYM pSeisekiym, BizDateYM pBosyuuym) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(pKakutyoujobcd, pSeisekiym, pBosyuuym);
    }


    @Override
    public List<HT_JigyouIkkatu> getAllJigyouIkkatu() {
        return mosInfoDomManager.getAllJigyouIkkatu();
    }


    @Override
    public HT_JigyouIkkatu getJigyouIkkatu(String pDaimosno) {
        return mosInfoDomManager.getJigyouIkkatu(pDaimosno);
    }


    @Override
    public List<HT_SkHubi> getSkHubisByMosnoHasinymdKaisyouymd(String pMosno, BizDate pHasinymd, BizDate pKaisyouymd) {
        return mosInfoDomManager.getSkHubisByMosnoHasinymdKaisyouymd(pMosno, pHasinymd, pKaisyouymd);
    }


    @Override
    public ExDBResults<HubimikaishoInfosBean> getHubimikaishoInfos() {
        return mosInfoDomManager.getHubimikaishoInfos();
    }


    @Override
    public List<HT_SkHubi> getSkHubisByMosnoKaisyouymdHasinymd(String pMosno) {
        return mosInfoDomManager.getSkHubisByMosnoKaisyouymdHasinymd(pMosno);
    }


    @Override
    public List<C_SyoruiCdKbn> getSkHubiDetailsByMosnoKaisyouymdNull(String pMosno) {
        return mosInfoDomManager.getSkHubiDetailsByMosnoKaisyouymdNull(pMosno);
    }


    @Override
    public ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean>  getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(String pKakutyoujobcd) {
        return mosInfoDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(pKakutyoujobcd);
    }


    @Override
    public List<HT_SkHubiDetail> getSkHubiDetailsByMosym(BizDateYM pMosym) {
        return mosInfoDomManager.getSkHubiDetailsByMosym(pMosym);
    }


    @Override
    public Integer getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(String pMosno, String pHubisikibetukey) {
        return mosInfoDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(pMosno, pHubisikibetukey);
    }


    @Override
    public Long getSkHubiDetailCountByMosnoTrkymdHasinymd(String pMosno) {
        return mosInfoDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymd(pMosno);
    }


    @Override
    public Long getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(String pMosno) {
        return mosInfoDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(pMosno);
    }


    @Override
    public Long getSkHubiDetailCountByMosnoKaisyouymd(String pMosno) {
        return mosInfoDomManager.getSkHubiDetailCountByMosnoKaisyouymd(pMosno);
    }


    @Override
    public Long getSkHubiDetailCountByPkHasinkyokakbn(String pMosno, String pHubisikibetukey) {
        return mosInfoDomManager.getSkHubiDetailCountByPkHasinkyokakbn(pMosno, pHubisikibetukey);
    }


    @Override
    public List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(String pHubisikibetukey) {
        return mosInfoDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(pHubisikibetukey);
    }


    @Override
    public List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(String pHubisikibetukey) {
        return mosInfoDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(pHubisikibetukey);
    }


    @Override
    public List<HT_BAK_SyoriCTL> getAllBAKSyoriCTL() {
        return mosInfoDomManager.getAllBAKSyoriCTL();
    }


    @Override
    public HT_BAK_SyoriCTL getBAKSyoriCTL(String pMosno, String pTrkssikibetukey) {
        return mosInfoDomManager.getBAKSyoriCTL(pMosno, pTrkssikibetukey);
    }


    @Override
    public List<HT_BAK_SyoriCTL> getBAKSyoriCTLsByMosno(String pMosno) {
        return mosInfoDomManager.getBAKSyoriCTLsByMosno(pMosno);
    }


    @Override
    public List<HT_BAK_SyoriCTL> getBAKSyoriCTLsBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return mosInfoDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    @Override
    public List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> getSyoukaiIchiranInfosByMosymdBosyuuymItems(BizDate pMosfromymd, BizDate pMostoymd, String pDaimosno, BizDateYM pBosyuuym, C_UmuKbn pNyknnrkumu, C_KetteiKbn pKetteikbn
        , C_SeirituKbn pSeiritukbn, C_UmuKbn pKthhbkbn, C_HknsyuruiNo pHknsyuruino, String pTratkiagcd, String pOyadrtencd
        , boolean pSrhumu, boolean pMkshb, String pKyknmkn, BizDate pKykseiymd) {
        return mosInfoDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(pMosfromymd, pMostoymd, pDaimosno, pBosyuuym, pNyknnrkumu, pKetteikbn
            , pSeiritukbn, pKthhbkbn, pHknsyuruino, pTratkiagcd, pOyadrtencd
            , pSrhumu, pMkshb, pKyknmkn, pKykseiymd);
    }


    @Override
    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymd(String pKakutyoujobcd, BizDate pSrsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd(pKakutyoujobcd, pSrsyoriymd);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(String pKakutyoujobcd, BizDate pSrsyoriymd) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(pKakutyoujobcd, pSrsyoriymd);
    }


    @Override
    public List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(String pMosno, String pSubSystemId) {
        return mosInfoDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(pMosno, pSubSystemId);
    }


    @Override
    public ExDBResults<HT_KmTsRireki> getKmtsrirekisBySyoriTime(String pSyoriTimeFrom, String pSyoriTimeTo) {
        return mosInfoDomManager.getKmtsrirekisBySyoriTime(pSyoriTimeFrom, pSyoriTimeTo);
    }


    @Override
    public Long getKmTsRirekiDistinctSyoriTimeCountByMosno(String pMosno) {
        return mosInfoDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(pMosno);
    }


    @Override
    public List<HT_MosKihon> getMosKihonsByUktkid(String pUktkid) {
        return mosInfoDomManager.getMosKihonsByUktkid(pUktkid);
    }


    @Override
    public List<HT_MosKihon> getMosKihonsByUktkidMosnoNe(String pUktkid, String pMosno) {
        return mosInfoDomManager.getMosKihonsByUktkidMosnoNe(pUktkid, pMosno);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(pKakutyoujobcd, pSeisekiym);
    }


    @Override
    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(String pKakutyoujobcd, BizDate pMosnrkymd) {
        return mosInfoDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(pKakutyoujobcd, pMosnrkymd);
    }


    @Override
    public Long getSyoriCTLCountBySeiritukbnsKykkbn(String pKeiyakusyanm) {
        return mosInfoDomManager.getSyoriCTLCountBySeiritukbnsKykkbn(pKeiyakusyanm);
    }


    @Override
    public Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(String pBsyujoyadrtencd, String pKeiyakusyanm) {
        return mosInfoDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(pBsyujoyadrtencd, pKeiyakusyanm);
    }


    @Override
    public Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(String pBsyujoyadrtencd) {
        return mosInfoDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(pBsyujoyadrtencd);
    }


    @Override
    public List<HT_SkHubiDetail> getSkHubiDetailsByMosnoSyoruicd(String pMosno, C_SyoruiCdKbn pSyoruiCdKbn) {
        return mosInfoDomManager.getSkHubiDetailsByMosnoSyoruicd(pMosno, pSyoruiCdKbn);
    }



    @Override
    public List<HM_KetteiSya> getAllKetteiSya() {
        return sateiKetInfoDomManager.getAllKetteiSya();
    }


    @Override
    public HM_KetteiSya getKetteiSya(String pKetsyacd) {
        return sateiKetInfoDomManager.getKetteiSya(pKetsyacd);
    }


    @Override
    public HT_MostenkenRireki getMostenkenRirekiByMosnoMaxRenno(String pMosno) {
        return sateiKetInfoDomManager.getMostenkenRirekiByMosnoMaxRenno(pMosno);
    }


    @Override
    public Long getMostenkenRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {
        return sateiKetInfoDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    @Override
    public BizDate getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(String pMosno) {
        return sateiKetInfoDomManager.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(pMosno);
    }


    @Override
    public List<HM_KetteiSya> getKetteiSyasByKetsyacdMostenkenrankkbns(String pKetsyacd, C_MostenkenRankKbn... pMostenkenrankkbn) {
        return sateiKetInfoDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns(pKetsyacd, pMostenkenrankkbn);
    }


    @Override
    public List<HM_KetteiSya> getKetteiSyasByKetsyacdImusateirankkbns(String pKetsyacd, C_ImusateirankKbn... pImusateirankkbn) {
        return sateiKetInfoDomManager.getKetteiSyasByKetsyacdImusateirankkbns(pKetsyacd, pImusateirankkbn);
    }


    @Override
    public List<HM_KetteiSya> getKetteiSyasByKetsyacdKnksateirankkbns(String pKetsyacd, C_KnksateirankKbn... pKnksateirankkbn) {
        return sateiKetInfoDomManager.getKetteiSyasByKetsyacdKnksateirankkbns(pKetsyacd, pKnksateirankkbn);
    }


    @Override
    public List<HM_KetteiSya> getKetteiSyasByKetsyacdKetsyanm(String pKetsyacd, String pKetsyanm) {
        return sateiKetInfoDomManager.getKetteiSyasByKetsyacdKetsyanm(pKetsyacd, pKetsyanm);
    }


    @Override
    public Integer getImusateiRirekiMaxRennoByMosno(String pMosno) {
        return sateiKetInfoDomManager.getImusateiRirekiMaxRennoByMosno(pMosno);
    }


    @Override
    public Long getImusateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {
        return sateiKetInfoDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    @Override
    public HT_ImusateiRireki getImusateiRirekiByMosnoMaxRenno(String pMosno) {
        return sateiKetInfoDomManager.getImusateiRirekiByMosnoMaxRenno(pMosno);
    }


    @Override
    public HT_ImusateiRireki getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(String pMosno, C_SyorikekkaKbn pImusateikekkakbn) {
        return sateiKetInfoDomManager.getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(pMosno, pImusateikekkakbn);
    }


    @Override
    public BizDate getSkDenpyoDataMinDenymdByMosnoRstuukasyu(String pMosno, C_Tuukasyu pRstuukasyu) {
        return sateiKetInfoDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu(pMosno, pRstuukasyu);
    }


    @Override
    public HT_KnksateiRireki getKnksateiRirekiByMosnoMaxRenno(String pMosno) {
        return sateiKetInfoDomManager.getKnksateiRirekiByMosnoMaxRenno(pMosno);
    }


    @Override
    public Long getKnksateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {
        return sateiKetInfoDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    @Override
    public Integer getDakuhiKetteiMaxDakuhiktrennoByMosno(String pMosno) {
        return sateiKetInfoDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno(pMosno);
    }


    @Override
    public HT_DakuhiKettei getDakuhiKetteiByMosnoMaxDakuhiktrenno(String pMosno) {
        return sateiKetInfoDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(pMosno);
    }


    @Override
    public HT_DakuhiKettei getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(String pMosno, C_DakuhiktbunruiKbn pDakuhiktbunruikbn) {
        return sateiKetInfoDomManager.getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(pMosno, pDakuhiktbunruikbn);
    }


    @Override
    public HT_KykKak getKykKakByMosnoMaxRenno(String pMosno) {
        return sateiKetInfoDomManager.getKykKakByMosnoMaxRenno(pMosno);
    }


    @Override
    public Integer getKykKakMaxRennoByMosno(String pMosno) {
        return sateiKetInfoDomManager.getKykKakMaxRennoByMosno(pMosno);
    }


    @Override
    public List<HT_DakuhiKettei> getDakuhiKetteisByKetsyacd(String pKetsyacd) {
        return sateiKetInfoDomManager.getDakuhiKetteisByKetsyacd(pKetsyacd);
    }


    @Override
    public List<HT_Tokunin> getTokuninsByKetsyacd(String pKetsyacd) {
        return sateiKetInfoDomManager.getTokuninsByKetsyacd(pKetsyacd);
    }


    @Override
    public HT_MostenkenRireki getMostenkenRirekiByMosnoKanryouMaxRenno(String pMosno) {
        return sateiKetInfoDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno(pMosno);
    }



    @Override
    public List<HT_SkDenpyoData> getAllSkDenpyoData() {
        return nyknyInfoDomManager.getAllSkDenpyoData();
    }


    @Override
    public HT_SkDenpyoData getSkDenpyoData(String pDenrenno, Integer pEdano) {
        return nyknyInfoDomManager.getSkDenpyoData(pDenrenno, pEdano);
    }


    @Override
    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByHenkin(String pMosno, Integer pRenno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd, BizDate pHnknsyoriymd) {
        return nyknyInfoDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(pMosno, pRenno, pHnkntuukasyu, pPkakinsyoriymd, pHnknsyoriymd);
    }


    @Override
    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(String pMosno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd) {
        return nyknyInfoDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(pMosno, pHnkntuukasyu, pPkakinsyoriymd);
    }


    @Override
    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByNyksyoriymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pNyksyoriymd) {
        return nyknyInfoDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(pMosno, pRstuukasyu, pNyksyoriymd);
    }


    @Override
    public List<HT_SkDenpyoData> getSkDenpyoDatasByDenrenno(String pDenrenno) {
        return nyknyInfoDomManager.getSkDenpyoDatasByDenrenno(pDenrenno);
    }


    @Override
    public List<HT_SkDenpyoData> getSkDenpyoDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkDenpyoDatasByMosno(pMosno);
    }


    @Override
    public List<HT_SkDenpyoData> getSkDenpyoDatasBySyono(String pSyono) {
        return nyknyInfoDomManager.getSkDenpyoDatasBySyono(pSyono);
    }


    @Override
    public ExDBUpdatableResults<HT_SkDenpyoData> getSkDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return nyknyInfoDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<HT_SkFBSoukinData> getAllSkFBSoukinData() {
        return nyknyInfoDomManager.getAllSkFBSoukinData();
    }


    @Override
    public HT_SkFBSoukinData getSkFBSoukinData(String pFbsoukindatasikibetukey) {
        return nyknyInfoDomManager.getSkFBSoukinData(pFbsoukindatasikibetukey);
    }


    @Override
    public ExDBResults<HT_SkFBSoukinData> getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return nyknyInfoDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<HT_SkFBSoukinData> getSkFBSoukinDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkFBSoukinDatasByMosno(pMosno);
    }


    @Override
    public List<HT_SkGaikaFBSoukinData> getAllSkGaikaFBSoukinData() {
        return nyknyInfoDomManager.getAllSkGaikaFBSoukinData();
    }


    @Override
    public HT_SkGaikaFBSoukinData getSkGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        return nyknyInfoDomManager.getSkGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }


    @Override
    public ExDBResults<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return nyknyInfoDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkGaikaFBSoukinDatasByMosno(pMosno);
    }


    @Override
    public Integer getHenkinMaxRennoByMosno(String pMosno) {
        return nyknyInfoDomManager.getHenkinMaxRennoByMosno(pMosno);
    }


    @Override
    public List<HT_HrkmNyknData> getAllHrkmNyknData() {
        return nyknyInfoDomManager.getAllHrkmNyknData();
    }


    @Override
    public HT_HrkmNyknData getHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {
        return nyknyInfoDomManager.getHrkmNyknData(pDensyskbn, pSyoriYmd, pItirenno);
    }


    @Override
    public List<HT_HrkmNyknData> getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk) {
        return nyknyInfoDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(pMosno, pOyadrtencd, pHrkmirninnm, pTrhkkgk);
    }


    @Override
    public List<HT_HrkmNyknData> getHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140
        , BizDate pSyoriYmd, Integer pIribaraikbn) {
        return nyknyInfoDomManager.getHrkmNyknDatasByBankcdSitencdItems(pBankcd, pSitencd, pYokinkbn, pKouzano, pTrhkkgk, pHrkmirninnm140
            , pSyoriYmd, pIribaraikbn);
    }


    @Override
    public ExDBUpdatableResults<HT_HrkmNyknData> getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {
        return nyknyInfoDomManager.getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(pKakutyoujobcd, pSyorizumiflg);
    }


    @Override
    public List<HT_GaikaHrkmNyknData> getAllGaikaHrkmNyknData() {
        return nyknyInfoDomManager.getAllGaikaHrkmNyknData();
    }


    @Override
    public HT_GaikaHrkmNyknData getGaikaHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {
        return nyknyInfoDomManager.getGaikaHrkmNyknData(pDensyskbn, pSyoriYmd, pItirenno);
    }


    @Override
    public List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk) {
        return nyknyInfoDomManager.getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(pMosno, pOyadrtencd, pHrkmirninnm, pTrhkkgk);
    }


    @Override
    public List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140, BizDate pSyoriYmd
        , Integer pIribaraikbn) {
        return nyknyInfoDomManager.getGaikaHrkmNyknDatasByBankcdSitencdItems(pBankcd, pSitencd, pKouzano, pTrhkkgk, pHrkmirninnm140, pSyoriYmd
            , pIribaraikbn);
    }


    @Override
    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdDengk(String pKakutyoujobcd) {
        return nyknyInfoDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk(pKakutyoujobcd);
    }


    @Override
    public List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean> getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate pSyoriYmd, BizDate pZengetuLastd, C_Tuukasyu pTuukasyu) {
        return nyknyInfoDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(pSyoriYmd, pZengetuLastd, pTuukasyu);
    }


    @Override
    public List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate pKsnymd, C_Tuukasyu pTuukasyu) {
        return nyknyInfoDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(pKsnymd, pTuukasyu);
    }


    @Override
    public List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate pSyoriYmd, C_Tuukasyu pTuukasyu) {
        return nyknyInfoDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(pSyoriYmd, pTuukasyu);
    }


    @Override
    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(String pKakutyoujobcd, BizDate pSyoriYmd, Integer pIribaraikbn) {
        return nyknyInfoDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(pKakutyoujobcd, pSyoriYmd, pIribaraikbn);
    }


    @Override
    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {
        return nyknyInfoDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(pKakutyoujobcd, pSyorizumiflg);
    }


    @Override
    public List<HW_HrkmNyknTaisyouWk> getAllHrkmNyknTaisyouWk() {
        return nyknyInfoDomManager.getAllHrkmNyknTaisyouWk();
    }


    @Override
    public HW_HrkmNyknTaisyouWk getHrkmNyknTaisyouWk(BizDate pSyoriYmd, String pMosno, Integer pRenno) {
        return nyknyInfoDomManager.getHrkmNyknTaisyouWk(pSyoriYmd, pMosno, pRenno);
    }


    @Override
    public ExDBResults<HW_HrkmNyknTaisyouWk>  getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return nyknyInfoDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<HW_NyuukinJyouhouHuittiWk> getAllNyuukinJyouhouHuittiWk() {
        return nyknyInfoDomManager.getAllNyuukinJyouhouHuittiWk();
    }


    @Override
    public HW_NyuukinJyouhouHuittiWk getNyuukinJyouhouHuittiWk(BizDate pNyksyoriymd, String pItirenno) {
        return nyknyInfoDomManager.getNyuukinJyouhouHuittiWk(pNyksyoriymd, pItirenno);
    }


    @Override
    public List<HW_MosMatiKknKeikaWk> getAllMosMatiKknKeikaWk() {
        return nyknyInfoDomManager.getAllMosMatiKknKeikaWk();
    }


    @Override
    public HW_MosMatiKknKeikaWk getMosMatiKknKeikaWk(BizDate pNyksyoriymd, String pItirenno) {
        return nyknyInfoDomManager.getMosMatiKknKeikaWk(pNyksyoriymd, pItirenno);
    }


    @Override
    public List<HT_HrkmNyknSakujyo> getAllHrkmNyknSakujyo() {
        return nyknyInfoDomManager.getAllHrkmNyknSakujyo();
    }


    @Override
    public HT_HrkmNyknSakujyo getHrkmNyknSakujyo(String pHrkmdeldataskbtkey) {
        return nyknyInfoDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey);
    }


    @Override
    public List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosBySyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        return nyknyInfoDomManager.getHrkmNyknSakujyosBySyorizumiflg(pSyorizumiflg);
    }


    @Override
    public List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(String pOyadrtencd, String pMosno, String pHrkmirninnm, BizCurrency pTrhkkgk, C_Tuukasyu pRstuukasyu, C_Syorizumiflg pSyorizumiflg) {
        return nyknyInfoDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(pOyadrtencd, pMosno, pHrkmirninnm, pTrhkkgk, pRstuukasyu, pSyorizumiflg);
    }


    @Override
    public ExDBUpdatableResults<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {
        return nyknyInfoDomManager.getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(pKakutyoujobcd, pSyorizumiflg);
    }


    @Override
    public List<HW_JidouNyknTaisyougaiWk> getAllJidouNyknTaisyougaiWk() {
        return nyknyInfoDomManager.getAllJidouNyknTaisyougaiWk();
    }


    @Override
    public HW_JidouNyknTaisyougaiWk getJidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno) {
        return nyknyInfoDomManager.getJidouNyknTaisyougaiWk(pNyksyoriymd, pItirenno);
    }


    @Override
    public List<HT_JidouSyuunouMeisai> getAllJidouSyuunouMeisai() {
        return nyknyInfoDomManager.getAllJidouSyuunouMeisai();
    }


    @Override
    public HT_JidouSyuunouMeisai getJidouSyuunouMeisai(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu) {
        return nyknyInfoDomManager.getJidouSyuunouMeisai(pSyoriYmd, pKessankbn, pRstuukasyu);
    }


    @Override
    public List<HW_SikinIdouWk> getAllSikinIdouWk() {
        return nyknyInfoDomManager.getAllSikinIdouWk();
    }


    @Override
    public HW_SikinIdouWk getSikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {
        return nyknyInfoDomManager.getSikinIdouWk(pNyksyoriymd, pItirenno);
    }


    @Override
    public List<HT_GrossNykn> getAllGrossNykn() {
        return nyknyInfoDomManager.getAllGrossNykn();
    }


    @Override
    public HT_GrossNykn getGrossNykn(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno) {
        return nyknyInfoDomManager.getGrossNykn(pRyosyuymd, pOyadrtencd, pRenno);
    }


    @Override
    public List<HT_GrossNyknMeisai> getAllGrossNyknMeisai() {
        return nyknyInfoDomManager.getAllGrossNyknMeisai();
    }


    @Override
    public HT_GrossNyknMeisai getGrossNyknMeisai(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno, Integer pMeisairenno) {
        return nyknyInfoDomManager.getGrossNyknMeisai(pRyosyuymd, pOyadrtencd, pRenno, pMeisairenno);
    }


    @Override
    public List<HT_SkKouzahuriAnnaiData> getAllSkKouzahuriAnnaiData() {
        return nyknyInfoDomManager.getAllSkKouzahuriAnnaiData();
    }


    @Override
    public HT_SkKouzahuriAnnaiData getSkKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym) {
        return nyknyInfoDomManager.getSkKouzahuriAnnaiData(pAnsyuusyskbn, pSyoriYmd, pMosno, pNyknaiyoukbn, pJyuutouym);
    }


    @Override
    public List<HT_SkKouzahuriAnnaiData> getSkKouzahuriAnnaiDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkKouzahuriAnnaiDatasByMosno(pMosno);
    }


    @Override
    public List<HT_SkSyuunouKekkaData> getAllSkSyuunouKekkaData() {
        return nyknyInfoDomManager.getAllSkSyuunouKekkaData();
    }


    @Override
    public HT_SkSyuunouKekkaData getSkSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, BizDateYM pJyuutouym) {
        return nyknyInfoDomManager.getSkSyuunouKekkaData(pAnsyuusyskbn, pSyoriYmd, pMosno, pJyuutouym);
    }


    @Override
    public List<HT_SkSyuunouKekkaData> getSkSyuunouKekkaDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkSyuunouKekkaDatasByMosno(pMosno);
    }


    @Override
    public List<HT_SkUriageData> getAllSkUriageData() {
        return nyknyInfoDomManager.getAllSkUriageData();
    }


    @Override
    public HT_SkUriageData getSkUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, Integer pAuthorikaisuu) {
        return nyknyInfoDomManager.getSkUriageData(pAnsyuusyskbn, pSyoriYmd, pMosno, pAuthorikaisuu);
    }


    @Override
    public List<HT_SkUriageData> getSkUriageDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getSkUriageDatasByMosno(pMosno);
    }


    @Override
    public List<HT_BAK_SkDenpyoData> getAllBAKSkDenpyoData() {
        return nyknyInfoDomManager.getAllBAKSkDenpyoData();
    }


    @Override
    public HT_BAK_SkDenpyoData getBAKSkDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano) {
        return nyknyInfoDomManager.getBAKSkDenpyoData(pDenrenno, pTrkssikibetukey, pEdano);
    }


    @Override
    public List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return nyknyInfoDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    @Override
    public List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasByMosno(String pMosno) {
        return nyknyInfoDomManager.getBAKSkDenpyoDatasByMosno(pMosno);
    }


    @Override
    public HT_Nyuukin getNyuukinByMosnoMaxRenno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinByMosnoMaxRenno(pMosno);
    }


    @Override
    public DengkByMosnoRstuukasyuBean getDengkByMosnoRstuukasyuRyosyuymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pRyosyuymd) {
        return nyknyInfoDomManager.getDengkByMosnoRstuukasyuRyosyuymd(pMosno, pRstuukasyu, pRyosyuymd);
    }


    @Override
    public Integer getHenteiRirekiMaxRennoByMosno(String pMosno) {
        return nyknyInfoDomManager.getHenteiRirekiMaxRennoByMosno(pMosno);
    }


    @Override
    public BizDate getNyuukinMinRyosyuymdByMosno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinMinRyosyuymdByMosno(pMosno);
    }


    @Override
    public BizDate getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(String pMosno) {
        return nyknyInfoDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(pMosno);
    }


    @Override
    public BizDate getNyuukinMinRyosyuymdByMosnoZenhnknkbn(String pMosno, C_ZenhnknKbn pZenhnknkbn) {
        return nyknyInfoDomManager.getNyuukinMinRyosyuymdByMosnoZenhnknkbn(pMosno, pZenhnknkbn);
    }


    @Override
    public BizDate getNyuukinMaxRyosyuymdByMosno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinMaxRyosyuymdByMosno(pMosno);
    }


    @Override
    public Integer getNyuukinMaxRennoByMosno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinMaxRennoByMosno(pMosno);
    }


    @Override
    public Map<CurrencyType, BizCurrency> getNyuukinSumRyosyugkByMosnoMaxRenno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno(pMosno);
    }


    @Override
    public HT_Nyuukin getNyuukinByMosnoMinRenno(String pMosno) {
        return nyknyInfoDomManager.getNyuukinByMosnoMinRenno(pMosno);
    }


    @Override
    public Long getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(String pMosno) {
        return nyknyInfoDomManager.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(pMosno);
    }


    @Override
    public HT_Nyuukin getNyuukinByMosnoRyosyuymdZenhnknkbn(String pMosno, BizDate pRyosyuymd) {
        return nyknyInfoDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn(pMosno, pRyosyuymd);
    }


    @Override
    public NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(String pMosno) {
        return nyknyInfoDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(pMosno);
    }


    @Override
    public Integer getJigyouIkkatuNyuukinMaxRennoByDaimosno(String pDaimosno) {
        return nyknyInfoDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno(pDaimosno);
    }


    @Override
    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymd(String pMosno, BizDate pHnknsyoriymd) {
        return nyknyInfoDomManager.getHenkinsByMosnoHnknsyoriymd(pMosno, pHnknsyoriymd);
    }


    @Override
    public Long getHenkinCountByMosnoHnknsyoriymd(String pMosno) {
        return nyknyInfoDomManager.getHenkinCountByMosnoHnknsyoriymd(pMosno);
    }


    @Override
    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(String pMosno, BizDate pHnknsyoriymd, C_Tuukasyu pHnkntuukasyu) {
        return nyknyInfoDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(pMosno, pHnknsyoriymd, pHnkntuukasyu);
    }


    @Override
    public List<BizCurrency> getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {
        return nyknyInfoDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(pMosno, pHnknsyoriymd);
    }


    @Override
    public Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByMosnoHnkntuukasyu(String pMosno, C_Tuukasyu pHnkntuukasyu) {
        return nyknyInfoDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu(pMosno, pHnkntuukasyu);
    }


    @Override
    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {
        return nyknyInfoDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn(pMosno, pHnknsyoriymd);
    }


    @Override
    public Integer getHenkinMaxZenhnknrenno(String pMosno) {
        return nyknyInfoDomManager.getHenkinMaxZenhnknrenno(pMosno);
    }


    @Override
    public List<HT_SkCreditCardQrTrkMihanei> getAllSkCreditCardQrTrkMihanei() {
        return nyknyInfoDomManager.getAllSkCreditCardQrTrkMihanei();
    }


    @Override
    public HT_SkCreditCardQrTrkMihanei getSkCreditCardQrTrkMihanei(BizDate pSyoriYmd, BizDate pSystemjyusinymd, String pSystemjyusintime, String pCreditkessaiyouno) {
        return nyknyInfoDomManager.getSkCreditCardQrTrkMihanei(pSyoriYmd, pSystemjyusinymd, pSystemjyusintime, pCreditkessaiyouno);
    }


    @Override
    public List<HW_CreditTrkHaneierrList> getAllCreditTrkHaneierrList() {
        return nyknyInfoDomManager.getAllCreditTrkHaneierrList();
    }


    @Override
    public HW_CreditTrkHaneierrList getCreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {
        return nyknyInfoDomManager.getCreditTrkHaneierrList(pTyouhyouymd, pDatarenno);
    }


    @Override
    public List<HW_CreditTrkNgList> getAllCreditTrkNgList() {
        return nyknyInfoDomManager.getAllCreditTrkNgList();
    }


    @Override
    public HW_CreditTrkNgList getCreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {
        return nyknyInfoDomManager.getCreditTrkNgList(pTyouhyouymd, pDatarenno);
    }


    @Override
    public List<HT_SkKouhuriUkTrkMihanei> getAllSkKouhuriUkTrkMihanei() {
        return nyknyInfoDomManager.getAllSkKouhuriUkTrkMihanei();
    }


    @Override
    public HT_SkKouhuriUkTrkMihanei getSkKouhuriUkTrkMihanei(BizDate pSyoriYmd, String pSyukkncd, String pKinyuucd8keta, BizDate pKinyuukkntratkiymd, String pKinyuukkntratkitime
        , String pKouhuriokyakusamano) {
        return nyknyInfoDomManager.getSkKouhuriUkTrkMihanei(pSyoriYmd, pSyukkncd, pKinyuucd8keta, pKinyuukkntratkiymd, pKinyuukkntratkitime
            , pKouhuriokyakusamano);
    }


    @Override
    public List<HT_JidouSyuunouMeisai2> getAllJidouSyuunouMeisai2() {
        return nyknyInfoDomManager.getAllJidouSyuunouMeisai2();
    }


    @Override
    public HT_JidouSyuunouMeisai2 getJidouSyuunouMeisai2(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn pNyktyhyoutkbn) {
        return nyknyInfoDomManager.getJidouSyuunouMeisai2(pSyoriYmd, pKessankbn, pRstuukasyu, pNyktyhyoutkbn);
    }



    @Override
    public List<HT_SmbcStyKanri> getAllSmbcStyKanri() {
        return gaibuRendoInfoDomManager.getAllSmbcStyKanri();
    }


    @Override
    public HT_SmbcStyKanri getSmbcStyKanri(BizDate pDatarenymd, BizNumber pDatasakuseirenno) {
        return gaibuRendoInfoDomManager.getSmbcStyKanri(pDatarenymd, pDatasakuseirenno);
    }


    @Override
    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcd(String pKakutyoujobcd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno(String pKakutyoujobcd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno(String pKakutyoujobcd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno(pKakutyoujobcd);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySmbcsyono(String pSmbcsyono) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisBySmbcsyono(pSmbcsyono);
    }


    @Override
    public List<HT_SisyaToukeiHokan> getAllSisyaToukeiHokan() {
        return gaibuRendoInfoDomManager.getAllSisyaToukeiHokan();
    }


    @Override
    public HT_SisyaToukeiHokan getSisyaToukeiHokan(String pSstmosno, Integer pRenno) {
        return gaibuRendoInfoDomManager.getSisyaToukeiHokan(pSstmosno, pRenno);
    }


    @Override
    public List<HT_SisyaToukeiHokan> getSisyaToukeiHokansBySstmosno(String pSstmosno) {
        return gaibuRendoInfoDomManager.getSisyaToukeiHokansBySstmosno(pSstmosno);
    }


    @Override
    public List<HT_SkLincJyusinData> getAllSkLincJyusinData() {
        return gaibuRendoInfoDomManager.getAllSkLincJyusinData();
    }


    @Override
    public HT_SkLincJyusinData getSkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {
        return gaibuRendoInfoDomManager.getSkLincJyusinData(pSyoriYmd, pLinckyknaiykekdatarenno);
    }


    @Override
    public HT_SkLincJyusinData getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(String pMosno) {
        return gaibuRendoInfoDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(pMosno);
    }


    @Override
    public List<HT_SkLincJyusinData> getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate pSyoriYmd, String pLinckyknaiykekdatarennooya) {
        return gaibuRendoInfoDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(pSyoriYmd, pLinckyknaiykekdatarennooya);
    }


    @Override
    public List<HT_SkLincSousinData> getAllSkLincSousinData() {
        return gaibuRendoInfoDomManager.getAllSkLincSousinData();
    }


    @Override
    public HT_SkLincSousinData getSkLincSousinData(String pMosno, BizDate pSyoriYmd, Integer pRenno) {
        return gaibuRendoInfoDomManager.getSkLincSousinData(pMosno, pSyoriYmd, pRenno);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyono(String pSyono) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisBySyono(pSyono);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisByMosno(String pMosno) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisByMosno(pMosno);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoRendouflg(String pSyono) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisBySyonoRendouflg(pSyono);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(String pSyono, String pSmbcseihosyknhkkzmymd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(pSyono, pSmbcseihosyknhkkzmymd);
    }


    @Override
    public BizNumber getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate pDatarenymd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(pDatarenymd);
    }


    @Override
    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(String pSyono, String pSmbcseihosyknhkkzmymd, String pSmbcseihotrksymd) {
        return gaibuRendoInfoDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(pSyono, pSmbcseihosyknhkkzmymd, pSmbcseihotrksymd);
    }


    @Override
    public List<HT_SmbcStyKanriSsRireki> getAllSmbcStyKanriSsRireki() {
        return gaibuRendoInfoDomManager.getAllSmbcStyKanriSsRireki();
    }


    @Override
    public HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRireki(String pSyono) {
        return gaibuRendoInfoDomManager.getSmbcStyKanriSsRireki(pSyono);
    }


    @Override
    public List<HT_SmbcStyKanriSsRireki> getSmbcStyKanriSsRirekisByMosno(String pMosno) {
        return gaibuRendoInfoDomManager.getSmbcStyKanriSsRirekisByMosno(pMosno);
    }


    @Override
    public HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(String pSyono, String pSyrctrltblkostime) {
        return gaibuRendoInfoDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(pSyono, pSyrctrltblkostime);
    }


    @Override
    public List<HT_BAK_SmbcStyKanri> getAllBAKSmbcStyKanri() {
        return gaibuRendoInfoDomManager.getAllBAKSmbcStyKanri();
    }


    @Override
    public List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return gaibuRendoInfoDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    @Override
    public List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisByMosno(String pMosno) {
        return gaibuRendoInfoDomManager.getBAKSmbcStyKanrisByMosno(pMosno);
    }


    @Override
    public HT_BAK_SmbcStyKanri getBAKSmbcStyKanri(BizDate pDatarenymd, String pTrkssikibetukey, BizNumber pDatasakuseirenno) {
        return gaibuRendoInfoDomManager.getBAKSmbcStyKanri(pDatarenymd, pTrkssikibetukey, pDatasakuseirenno);
    }



    @Override
    public List<HT_IjitoukeiMeisai> getAllIjitoukeiMeisai() {
        return ijitoukeiInfoDomManager.getAllIjitoukeiMeisai();
    }


    @Override
    public HT_IjitoukeiMeisai getIjitoukeiMeisai(String pSyono, Integer pRenno8keta) {
        return ijitoukeiInfoDomManager.getIjitoukeiMeisai(pSyono, pRenno8keta);
    }


    @Override
    public List<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyono(String pSyono) {
        return ijitoukeiInfoDomManager.getIjitoukeiMeisaisBySyono(pSyono);
    }


    @Override
    public ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo) {
        return ijitoukeiInfoDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(pSyoumetuymdFrom, pSyoumetuymdTo);
    }


    @Override
    public List<HW_SyuHukugouSikkanZhkWk> getAllSyuHukugouSikkanZhkWk() {
        return ijitoukeiInfoDomManager.getAllSyuHukugouSikkanZhkWk();
    }


    @Override
    public HW_SyuHukugouSikkanZhkWk getSyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {
        return ijitoukeiInfoDomManager.getSyuHukugouSikkanZhkWk(pSyono, pHknnendo);
    }


    @Override
    public ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(String pKakutyoujobcd, BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo, BizDateYM pBosyuuymTo, BizDate pIdousyoriymdTo) {
        return ijitoukeiInfoDomManager.getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(pKakutyoujobcd, pSyoumetuymdFrom, pSyoumetuymdTo, pBosyuuymTo, pIdousyoriymdTo);
    }



    @Override
    public List<HT_SouseirituKihon> getAllSouseirituKihon() {
        return souseirituInfoDomManager.getAllSouseirituKihon();
    }


    @Override
    public HT_SouseirituKihon getSouseirituKihon(String pSyono) {
        return souseirituInfoDomManager.getSouseirituKihon(pSyono);
    }



    @Override
    public List<HT_YuukoukknKykList> getAllYuukoukknKykList() {
        return reportInfoDomManager.getAllYuukoukknKykList();
    }


    @Override
    public HT_YuukoukknKykList getYuukoukknKykList(String pMosno, BizDate pTyouhyouymd) {
        return reportInfoDomManager.getYuukoukknKykList(pMosno, pTyouhyouymd);
    }


    @Override
    public List<HT_YuukoukknKykList> getYuukoukknKykListsByMosno(String pMosno) {
        return reportInfoDomManager.getYuukoukknKykListsByMosno(pMosno);
    }


    @Override
    public List<HT_MiseirijiyuuMeisai> getAllMiseirijiyuuMeisai() {
        return reportInfoDomManager.getAllMiseirijiyuuMeisai();
    }


    @Override
    public HT_MiseirijiyuuMeisai getMiseirijiyuuMeisai(String pMosno) {
        return reportInfoDomManager.getMiseirijiyuuMeisai(pMosno);
    }


    @Override
    public List<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn) {
        return reportInfoDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(pTyouhyouymd, pKeikakbn);
    }


    @Override
    public ExDBResults<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn, String pOyadrtencd) {
        return reportInfoDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(pTyouhyouymd, pKeikakbn, pOyadrtencd);
    }



    @Override
    public List<HT_GaibuQrYoyaku2> getAllGaibuQrYoyaku2() {
        return mousikomisyoInfoDomManager.getAllGaibuQrYoyaku2();
    }


    @Override
    public HT_GaibuQrYoyaku2 getGaibuQrYoyaku2(BizDate pSyoriYmd, C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn) {
        return mousikomisyoInfoDomManager.getGaibuQrYoyaku2(pSyoriYmd, pSkeijimukbn, pHknsyuruino, pMosnosaibankbn);
    }


    @Override
    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymd(BizDate pQrsakuseiymd) {
        return mousikomisyoInfoDomManager.getGaibuQrYoyaku2sByQrsakuseiymd(pQrsakuseiymd);
    }


    @Override
    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn, BizDate pQrsakuseiymd) {
        return mousikomisyoInfoDomManager.getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(pSkeijimukbn, pHknsyuruino, pMosnosaibankbn, pQrsakuseiymd);
    }


    @Override
    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymdNull() {
        return mousikomisyoInfoDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();
    }


    @Override
    public List<HT_MosnoKanri> getAllMosnoKanri() {
        return mousikomisyoInfoDomManager.getAllMosnoKanri();
    }


    @Override
    public HT_MosnoKanri getMosnoKanri(String pMosno8keta) {
        return mousikomisyoInfoDomManager.getMosnoKanri(pMosno8keta);
    }


    @Override
    public String getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(String pMosnoFrom, String pMosnoTo, C_KahiKbn pSaibankahikbn) {
        return mousikomisyoInfoDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(pMosnoFrom, pMosnoTo, pSaibankahikbn);
    }


    @Override
    public ExDBUpdatableResults<HT_MosnoKanri> getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(String pKakutyoujobcd, BizDate pMossykykyoteiymd) {
        return mousikomisyoInfoDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(pKakutyoujobcd, pMossykykyoteiymd);
    }


    @Override
    public List<HT_MosMikakuteiJyouhouKanri> getAllMosMikakuteiJyouhouKanri() {
        return mousikomisyoInfoDomManager.getAllMosMikakuteiJyouhouKanri();
    }


    @Override
    public HT_MosMikakuteiJyouhouKanri getMosMikakuteiJyouhouKanri(String pMosno) {
        return mousikomisyoInfoDomManager.getMosMikakuteiJyouhouKanri(pMosno);
    }


    @Override
    public List<HT_MosMikakuteiSyorui> getAllMosMikakuteiSyorui() {
        return mousikomisyoInfoDomManager.getAllMosMikakuteiSyorui();
    }


    @Override
    public HT_MosMikakuteiSyorui getMosMikakuteiSyorui(String pDocumentid) {
        return mousikomisyoInfoDomManager.getMosMikakuteiSyorui(pDocumentid);
    }


    @Override
    public List<HT_MosMikakuteiSyorui> getMosMikakuteiSyoruisByMosno(String pMosno) {
        return mousikomisyoInfoDomManager.getMosMikakuteiSyoruisByMosno(pMosno);
    }



    @Override
    public List<HT_BosKihon> getAllBosKihon() {
        return bosyuuInfoDomManager.getAllBosKihon();
    }


    @Override
    public HT_BosKihon getBosKihon(String pMosno) {
        return bosyuuInfoDomManager.getBosKihon(pMosno);
    }


    @Override
    public ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> getBosKihonInfosByKakutyoujobcdItems(String pKakutyoujobcd, C_MosUketukeKbn pMosuketukekbn, C_MosTourokuJyoukyouKbn pMostourokujyoukyoukbn, C_UmuKbn pPplessdatasousinumukbn) {
        return bosyuuInfoDomManager.getBosKihonInfosByKakutyoujobcdItems(pKakutyoujobcd, pMosuketukekbn, pMostourokujyoukyoukbn, pPplessdatasousinumukbn);
    }



    @Override
    public List<HM_SkHokenSyuruiNo> getAllSkHokenSyuruiNo() {
        return sinkeiyakuMstInfoDomManager.getAllSkHokenSyuruiNo();
    }


    @Override
    public HM_SkHokenSyuruiNo getSkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNo(pHknsyuruino, pHknsyuruinosd);
    }


    @Override
    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNosByHknsyuruino(pHknsyuruino);
    }


    @Override
    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujitoymdGt(BizDate pHyoujitoymd) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(pHyoujitoymd);
    }


    @Override
    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosBySysdate(BizDate pSysdate) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNosBySysdate(pSysdate);
    }


    @Override
    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujidate(BizDate pHyoujidate) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNosByHyoujidate(pHyoujidate);
    }


    @Override
    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo pHknsyuruino, BizDate pHyoujidate) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(pHknsyuruino, pHyoujidate);
    }


    @Override
    public List<HM_SkHokenSyuruiNoAisyou> getAllSkHokenSyuruiNoAisyou() {
        return sinkeiyakuMstInfoDomManager.getAllSkHokenSyuruiNoAisyou();
    }


    @Override
    public HM_SkHokenSyuruiNoAisyou getSkHokenSyuruiNoAisyou(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosdfrom, Integer pHknsyuruinosdto, String pHknsyuruinobetukey1
        , C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNoAisyou(pHknsyuruino, pHknsyuruinosdfrom, pHknsyuruinosdto, pHknsyuruinobetukey1
            , pAisyoumeichannelkbn);
    }


    @Override
    public List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo pHknsyuruino, C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(pHknsyuruino, pAisyoumeichannelkbn);
    }


    @Override
    public List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByPK(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeichannelkbn, String pHknsyuruinobetukey1) {
        return sinkeiyakuMstInfoDomManager.getSkHokenSyuruiNoAisyousByPK(pHknsyuruino, pHknsyuruinosd, pAisyoumeichannelkbn, pHknsyuruinobetukey1);
    }


    @Override
    public List<HM_SkChannel> getAllSkChannel() {
        return sinkeiyakuMstInfoDomManager.getAllSkChannel();
    }


    @Override
    public HM_SkChannel getSkChannel(C_Channelcd pChannelcd, String pOyadrtencd) {
        return sinkeiyakuMstInfoDomManager.getSkChannel(pChannelcd, pOyadrtencd);
    }


    @Override
    public List<HM_SkChannel> getSkChannelsByChannelcd(C_Channelcd pChannelcd) {
        return sinkeiyakuMstInfoDomManager.getSkChannelsByChannelcd(pChannelcd);
    }


    @Override
    public List<HM_SkDairitenKobetuJyouhou> getAllSkDairitenKobetuJyouhou() {
        return sinkeiyakuMstInfoDomManager.getAllSkDairitenKobetuJyouhou();
    }


    @Override
    public HM_SkDairitenKobetuJyouhou getSkDairitenKobetuJyouhou(String pOyadrtencd) {
        return sinkeiyakuMstInfoDomManager.getSkDairitenKobetuJyouhou(pOyadrtencd);
    }


    @Override
    public List<HM_SkDairitenKobetuJyouhou> getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {
        return sinkeiyakuMstInfoDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(pDrtenRnrkhouKbn);
    }


    @Override
    public List<HM_TokuteiKankeiHoujin> getAllTokuteiKankeiHoujin() {
        return sinkeiyakuMstInfoDomManager.getAllTokuteiKankeiHoujin();
    }


    @Override
    public List<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(String pTkhjnkinyuucd, String pTkhjnkjdrtennm, String pTkhjnnmkj) {
        return sinkeiyakuMstInfoDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(pTkhjnkinyuucd, pTkhjnkjdrtennm, pTkhjnnmkj);
    }


    @Override
    public HM_TokuteiKankeiHoujin getTokuteiKankeiHoujin(String pTkhjnkinyuucd, BizNumber pMeisaino) {
        return sinkeiyakuMstInfoDomManager.getTokuteiKankeiHoujin(pTkhjnkinyuucd, pMeisaino);
    }


    @Override
    public ExDBResults<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujins() {
        return sinkeiyakuMstInfoDomManager.getTokuteiKankeiHoujins();
    }


    @Override
    public List<HM_TokuteiKankeiHjnNmTotugou> getAllTokuteiKankeiHjnNmTotugou() {
        return sinkeiyakuMstInfoDomManager.getAllTokuteiKankeiHjnNmTotugou();
    }


    @Override
    public HM_TokuteiKankeiHjnNmTotugou getTokuteiKankeiHjnNmTotugou(String pTkhjnkinyuucd, BizNumber pMeisaino, Integer pRenno) {
        return sinkeiyakuMstInfoDomManager.getTokuteiKankeiHjnNmTotugou(pTkhjnkinyuucd, pMeisaino, pRenno);
    }


    @Override
    public List<String> getTotugoutkhjnnmkjsByTkhjnkinyuucd(String pTkhjnkinyuucd) {
        return sinkeiyakuMstInfoDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd(pTkhjnkinyuucd);
    }


    @Override
    public List<HM_SiinBunrui> getAllSiinBunrui() {
        return sinkeiyakuMstInfoDomManager.getAllSiinBunrui();
    }


    @Override
    public HM_SiinBunrui getSiinBunrui(String pSiincd) {
        return sinkeiyakuMstInfoDomManager.getSiinBunrui(pSiincd);
    }


    @Override
    public List<HM_SkHubiKoumoku> getAllSkHubiKoumoku() {
        return sinkeiyakuMstInfoDomManager.getAllSkHubiKoumoku();
    }


    @Override
    public HM_SkHubiKoumoku getSkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd, String pSkhubikoumokucd) {
        return sinkeiyakuMstInfoDomManager.getSkHubiKoumoku(pSyoruiCd, pSkhubikoumokucd);
    }


    @Override
    public List<HM_SkHubiKoumoku> getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        return sinkeiyakuMstInfoDomManager.getSkHubiKoumokusBySyoruiCd(pSyoruiCd);
    }


    @Override
    public List<HM_SkHubiNaiyou> getSkHubiNaiyousBySkhubikoumokucd(String pSkhubikoumokucd) {
        return sinkeiyakuMstInfoDomManager.getSkHubiNaiyousBySkhubikoumokucd(pSkhubikoumokucd);
    }


    @Override
    public List<HM_SkHubiNaiyou> getAllSkHubiNaiyou() {
        return sinkeiyakuMstInfoDomManager.getAllSkHubiNaiyou();
    }


    @Override
    public HM_SkHubiNaiyou getSkHubiNaiyou(String pSkhubikoumokucd, String pSkhubinaiyoucd) {
        return sinkeiyakuMstInfoDomManager.getSkHubiNaiyou(pSkhubikoumokucd, pSkhubinaiyoucd);
    }


    @Override
    public List<HM_SkHubiRenrakuNaiyou> getAllSkHubiRenrakuNaiyou() {
        return sinkeiyakuMstInfoDomManager.getAllSkHubiRenrakuNaiyou();
    }


    @Override
    public HM_SkHubiRenrakuNaiyou getSkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {
        return sinkeiyakuMstInfoDomManager.getSkHubiRenrakuNaiyou(pSkhubirenrakunaiyoucd);
    }


    @Override
    public List<HM_SkSeibiSijiNaiyou> getAllSkSeibiSijiNaiyou() {
        return sinkeiyakuMstInfoDomManager.getAllSkSeibiSijiNaiyou();
    }


    @Override
    public HM_SkSeibiSijiNaiyou getSkSeibiSijiNaiyou(String pSkseibisijinaiyoucd) {
        return sinkeiyakuMstInfoDomManager.getSkSeibiSijiNaiyou(pSkseibisijinaiyoucd);
    }


    @Override
    public List<HM_HurikomiKouza> getAllHurikomiKouza() {
        return sinkeiyakuMstInfoDomManager.getAllHurikomiKouza();
    }


    @Override
    public List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyuNe(C_Tuukasyu  pTuukasyu) {
        return sinkeiyakuMstInfoDomManager.getHurikomiKouzasByTuukasyuNe(pTuukasyu);
    }


    @Override
    public HM_HurikomiKouza getHurikomiKouza(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, String pHrkmirnincd) {
        return sinkeiyakuMstInfoDomManager.getHurikomiKouza(pBankcd, pSitencd, pKouzano, pTuukasyu, pHrkmirnincd);
    }


    @Override
    public List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, C_YokinKbn pYokinkbn) {
        return sinkeiyakuMstInfoDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(pBankcd, pSitencd, pKouzano, pTuukasyu, pYokinkbn);
    }


    @Override
    public List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu) {
        return sinkeiyakuMstInfoDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(pBankcd, pSitencd, pKouzano, pTuukasyu);
    }


    @Override
    public List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyu(C_Tuukasyu pTuukasyu) {
        return sinkeiyakuMstInfoDomManager.getHurikomiKouzasByTuukasyu(pTuukasyu);
    }


    @Override
    public List<HM_ChkTesuuryou> getAllChkTesuuryou() {
        return sinkeiyakuMstInfoDomManager.getAllChkTesuuryou();
    }


    @Override
    public HM_ChkTesuuryou getChkTesuuryou(Integer pRenno3keta) {
        return sinkeiyakuMstInfoDomManager.getChkTesuuryou(pRenno3keta);
    }


    @Override
    public List<HM_Honkouza> getAllHonkouza() {
        return sinkeiyakuMstInfoDomManager.getAllHonkouza();
    }


    @Override
    public HM_Honkouza getHonkouza(String pHonkouzacd) {
        return sinkeiyakuMstInfoDomManager.getHonkouza(pHonkouzacd);
    }


    @Override
    public List<HM_SyouhnTaniHonkouza> getAllSyouhnTaniHonkouza() {
        return sinkeiyakuMstInfoDomManager.getAllSyouhnTaniHonkouza();
    }


    @Override
    public HM_SyouhnTaniHonkouza getSyouhnTaniHonkouza(String pSyouhncd) {
        return sinkeiyakuMstInfoDomManager.getSyouhnTaniHonkouza(pSyouhncd);
    }


    @Override
    public List<HM_SyouhnTaniHonkouza2> getAllSyouhnTaniHonkouza2() {
        return sinkeiyakuMstInfoDomManager.getAllSyouhnTaniHonkouza2();
    }


    @Override
    public HM_SyouhnTaniHonkouza2 getSyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {
        return sinkeiyakuMstInfoDomManager.getSyouhnTaniHonkouza2(pSyouhncd, pKyktuukasyu);
    }



    @Override
    public List<HV_MosSyoruiMitoutyakuList> getAllMosSyoruiMitoutyakuList() {
        return viewDomManager.getAllMosSyoruiMitoutyakuList();
    }


    @Override
    public HV_MosSyoruiMitoutyakuList getMosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno) {
        return viewDomManager.getMosSyoruiMitoutyakuList(pSyoriYmd, pItirenno);
    }


    @Override
    public ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate pKnjyymd) {
        return viewDomManager.getMosSyoruiMitoutyakuListsByKnjyymdLe(pKnjyymd);
    }

}
