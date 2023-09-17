package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.AddressDistinctItemsBypostalCdBean;
import yuyu.def.biz.result.bean.AddressDistinctPostAdrkjAdrknbkarisByItemsBean;
import yuyu.def.biz.result.bean.BzSkHonsyaDenpyousByDenymdTaisyakukbnBean;
import yuyu.def.biz.result.bean.GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean;
import yuyu.def.biz.result.bean.SokujiSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.SyoruiZokuseiMasterInfoBean;
import yuyu.def.biz.result.bean.SyoruiZokuseiTyouhyouInfoBean;
import yuyu.def.biz.result.bean.SyouhnZokuseiHaitoukbnSeg1cdByPKBean;
import yuyu.def.biz.result.bean.TyakkinSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean;
import yuyu.def.biz.result.bean.ZengetubunDenpyouDatasByDenymdFromDenymdToBean;
import yuyu.def.biz.result.bean.ZtrhyousiInfoBySyoruiCdBean;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;

import yuyu.def.classification.C_KeiriyendthnkKbn;

import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.*;


/**
 * 業務共通 DOM マネージャ 実装クラス<br />
 * {@link BizDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class BizDomManagerImpl extends AbstractDomManager implements BizDomManager {

    @Inject
    private SyouhnZokuseiDomManager syouhnZokuseiDomManager;

    @Inject
    private ToriatsukaiDomManager toriatsukaiDomManager;

    @Inject
    private KawaseRateDomManager kawaseRateDomManager;

    @Inject
    private SyuunouDomManager syuunouDomManager;

    @Inject
    private KeiriKaikeiDomManager keiriKaikeiDomManager;

    @Inject
    private SateiKetteiDomManager sateiKetteiDomManager;

    @Inject
    private DairitenDomManager dairitenDomManager;

    @Inject
    private SyoruiDomManager syoruiDomManager;

    @Inject
    private EtcDomManager etcDomManager;

    @Inject
    private SystemRenkeiDomManager systemRenkeiDomManager;

    @Inject
    private NayoseDomManager nayoseDomManager;

    @Inject
    private NenkinInfoRendouManager nenkinInfoRendouManager;

    @Inject
    private MaintenanceBatchRecoveryDomManager maintenanceBatchRecoveryDomManager;

    @Inject
    private UserKengenInfoWkDomManager userKengenInfoWkDomManager;

    @Inject
    private ViewDomManager viewDomManager;

    @Inject
    private HonbanDataTysytManager honbanDataTysytManager;

    @Inject
    private SystemHonbanKsDomManager systemHonbanKsDomManager;

    @Override
    public List<BM_SyouhnZokusei> getAllSyouhnZokusei() {
        return syouhnZokuseiDomManager.getAllSyouhnZokusei();
    }

    @Override
    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {
        return syouhnZokuseiDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);
    }

    @Override
    public BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdHyoujiymd(String pSyouhncd, BizDate pHiduke) {
        return syouhnZokuseiDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhncd, pHiduke);
    }

    @Override
    public SyouhnZokuseiHaitoukbnSeg1cdByPKBean getSyouhnZokuseiHaitoukbnSeg1cdByPK(String pSyouhncd, Integer pSyouhnsdno) {
        return syouhnZokuseiDomManager.getSyouhnZokuseiHaitoukbnSeg1cdByPK(pSyouhncd, pSyouhnsdno);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyutkkbnHyoujiymd(C_SyutkKbn pSyutkkbn, BizDate pHyoujidate) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(pSyutkkbn, pHyoujidate);
    }

    @Override
    public Integer getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(String pSyouhncd, BizDate pKykymd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(pSyouhncd, pKykymd);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncd(String pSyouhncd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisBySyouhncd(pSyouhncd);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKijyunymd(String pSyouhncd, BizDate pKijyunymd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisBySyouhncdKijyunymd(pSyouhncd, pKijyunymd);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByHyoujidateItems(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu, pDai1hknkkn);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByHknsyuruinoItems(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu, pDai1hknkkn
            , pTuukasyu, pSyksbyensitihsyutktekiumu, pSknenkinsyu, pTeikisiharaikinumu);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByKykymdItems(pKykymd, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu, pDai1hknkkn
            , pTuukasyu, pSyksbyensitihsyutktekiumu, pSknenkinsyu, pTeikisiharaikinumu);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems2(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu,
        C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByKykymdItems2(pKykymd, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu, pSyksbyensitihsyutktekiumu, pSknenkinsyu, pTeikisiharaikinumu);
    }

    @Override
    public BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(String pSyouhncd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(pSyouhncd);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(String pMosno, C_SyutkKbn pSyutkkbn, BizDate pSyssyoriymd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(pMosno, pSyutkkbn, pSyssyoriymd);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(pSyouhncd, pKykymd);
    }

    @Override
    public List<BM_KyhNitigakuBairitu> getAllKyhNitigakuBairitu() {
        return syouhnZokuseiDomManager.getAllKyhNitigakuBairitu();
    }

    @Override
    public BM_KyhNitigakuBairitu getKyhNitigakuBairitu(String pSyouhncd, Integer pSyouhnsdno, C_KataKbn pKatakbn) {
        return syouhnZokuseiDomManager.getKyhNitigakuBairitu(pSyouhncd, pSyouhnsdno, pKatakbn);
    }

    @Override
    public List<BM_TokujyouSakugenRate> getAllTokujyouSakugenRate() {
        return syouhnZokuseiDomManager.getAllTokujyouSakugenRate();
    }

    @Override
    public BM_TokujyouSakugenRate getTokujyouSakugenRate(String pSyouhncd, Integer pSyouhnsdno, C_Tkjyskgnkkn pTkjyskgnkkn) {
        return syouhnZokuseiDomManager.getTokujyouSakugenRate(pSyouhncd, pSyouhnsdno, pTkjyskgnkkn);
    }

    @Override
    public List<BM_Tuuka> getAllTuuka() {
        return syouhnZokuseiDomManager.getAllTuuka();
    }

    @Override
    public BM_Tuuka getTuuka(C_Tuukasyu pTuukasyu) {
        return syouhnZokuseiDomManager.getTuuka(pTuukasyu);
    }

    @Override
    public List<BM_BunsyonoSettei> getAllBunsyonoSettei() {
        return syouhnZokuseiDomManager.getAllBunsyonoSettei();
    }

    @Override
    public BM_BunsyonoSettei getBunsyonoSettei(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, String pOyadrtencd, Integer pRenno) {
        return syouhnZokuseiDomManager.getBunsyonoSettei(pBunsyosyubetukbn, pAisyoumeikbn, pChannelcd, pOyadrtencd, pRenno);
    }

    @Override
    public List<BM_BunsyonoSettei> getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, BizDate pTekiyouYmd) {
        return syouhnZokuseiDomManager.getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(pBunsyosyubetukbn, pAisyoumeikbn, pChannelcd, pTekiyouYmd);
    }

    @Override
    public List<BM_SyouhnbetuSegment> getAllSyouhnbetuSegment() {
        return syouhnZokuseiDomManager.getAllSyouhnbetuSegment();
    }

    @Override
    public BM_SyouhnbetuSegment getSyouhnbetuSegment(String pSyouhncd, C_Tuukasyu pKyktuukasyu, C_SegbunruiKbn pSegbunrui1, C_SegbunruiKbn pSegbunrui2) {
        return syouhnZokuseiDomManager.getSyouhnbetuSegment(pSyouhncd, pKyktuukasyu, pSegbunrui1, pSegbunrui2);
    }

    @Override
    public List<BM_BosyuuKyuusi> getAllBosyuuKyuusi() {
        return syouhnZokuseiDomManager.getAllBosyuuKyuusi();
    }

    @Override
    public BM_BosyuuKyuusi getBosyuuKyuusi(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , Integer pHanteiyuusendo) {
        return syouhnZokuseiDomManager.getBosyuuKyuusi(pSksyskbn, pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pSkeijimukbn
            , pHanteiyuusendo);
    }

    @Override
    public List<BM_BosyuuKyuusi> getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , C_BoskyuusiRiyuuKbn pBoskyuusiriyuukbn) {
        return syouhnZokuseiDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(pSksyskbn, pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pSkeijimukbn
            , pBoskyuusiriyuukbn);
    }

    @Override
    public List<BM_SyouhnToriatukaiTuuka> getAllSyouhnToriatukaiTuuka() {
        return syouhnZokuseiDomManager.getAllSyouhnToriatukaiTuuka();
    }

    @Override
    public BM_SyouhnToriatukaiTuuka getSyouhnToriatukaiTuuka(String pSyouhncd, BizDate pTkyfromymd, BizDate pTkytoymd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu) {
        return syouhnZokuseiDomManager.getSyouhnToriatukaiTuuka(pSyouhncd, pTkyfromymd, pTkytoymd, pZenkizennouumu, pKyktuukasyu
            , pHrktuukasyu);
    }

    @Override
    public List<BM_SyouhnToriatukaiTuuka> getSyouhnToriatukaiTuukasByPk(String pSyouhncd, BizDate pTekiyouYmd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu) {
        return syouhnZokuseiDomManager.getSyouhnToriatukaiTuukasByPk(pSyouhncd, pTekiyouYmd, pZenkizennouumu, pKyktuukasyu
            , pHrktuukasyu);
    }

    @Override
    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems2(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu
        , C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {
        return syouhnZokuseiDomManager.getSyouhnZokuseisByHknsyuruinoItems2(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu
            , pSyksbyensitihsyutktekiumu, pSknenkinsyu, pTeikisiharaikinumu);
    }

    @Override
    public List<BM_ChkNenreiHani> getAllChkNenreiHani() {
        return toriatsukaiDomManager.getAllChkNenreiHani();
    }

    @Override
    public BM_ChkNenreiHani getChkNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen) {
        return toriatsukaiDomManager.getChkNenreiHani(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknto
            , pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen, pSyuyoteiriritufrom
            , pSyuyoteirirituto, pTokusyuchkno, pTksyouhncd, pTkhknkkn, pTkhknkknto
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknto, pTkhrkkknsmnkbn
            , pTkfromnen, pTktonen);
    }

    @Override
    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn
            , pSyukatakbnumu, pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyuyoteiriritu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, Integer pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbnumu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyuyoteiriritu, pSeibetu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public Long getChkNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {
        return toriatsukaiDomManager.getChkNenreiHaniCountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn, pHknkkn
            , pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen, pSyuyoteiriritu);
    }

    @Override
    public List<BM_ChkJhNenreiHani> getAllChkJhNenreiHani() {
        return toriatsukaiDomManager.getAllChkJhNenreiHani();
    }

    @Override
    public BM_ChkJhNenreiHani getChkJhNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen) {
        return toriatsukaiDomManager.getChkJhNenreiHani(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknto
            , pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen, pSyuyoteiriritufrom
            , pSyuyoteirirituto, pTokusyuchkno, pTksyouhncd, pTkhknkkn, pTkhknkknto
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknto, pTkhrkkknsmnkbn
            , pTkfromnen, pTktonen);
    }

    @Override
    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn
            , pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , Integer pSeibetu, BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pNen
            , pSeibetu, pSyuyoteiriritu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, Integer pSeibetu
        , BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSeibetu
            , pSyuyoteiriritu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn
            , pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public Long getChkJhNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {
        return toriatsukaiDomManager.getChkJhNenreiHaniCountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn, pHknkkn
            , pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen, pSyuyoteiriritu);
    }

    @Override
    public List<BM_ChkTkykSyuNenreiHani> getAllChkTkykSyuNenreiHani() {
        return toriatsukaiDomManager.getAllChkTkykSyuNenreiHani();
    }

    @Override
    public BM_ChkTkykSyuNenreiHani getChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn) {
        return toriatsukaiDomManager.getChkTkykSyuNenreiHani(pPmnjtkkbn);
    }

    @Override
    public Long getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn pPmnjtkkbn, Integer pHhknnen) {
        return toriatsukaiDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(pPmnjtkkbn, pHhknnen);
    }

    @Override
    public List<BM_ChkKhnKyhKgBairitu> getAllChkKhnKyhKgBairitu() {
        return toriatsukaiDomManager.getAllChkKhnKyhKgBairitu();
    }

    @Override
    public BM_ChkKhnKyhKgBairitu getChkKhnKyhKgBairitu(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        return toriatsukaiDomManager.getChkKhnKyhKgBairitu(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pKhnkyhkgbairitukbn);
    }

    @Override
    public List<BM_ChkKhnKyhKgBairitu> getChkKhnKyhKgBairitusByPk(String pSyouhncd, Integer pSyouhnsdno, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        return toriatsukaiDomManager.getChkKhnKyhKgBairitusByPk(pSyouhncd, pSyouhnsdno, pKhnkyhkgbairitukbn);
    }

    @Override
    public List<BM_ChkTkykHukaSeigen> getAllChkTkykHukaSeigen() {
        return toriatsukaiDomManager.getAllChkTkykHukaSeigen();
    }

    @Override
    public BM_ChkTkykHukaSeigen getChkTkykHukaSeigen(String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pSntkhoukbnfrom, Integer pSntkhoukbnto
        , BizNumber pHhknfromnen, BizNumber pHhkntonen, String pTksyouhncd) {
        return toriatsukaiDomManager.getChkTkykHukaSeigen(pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSntkhoukbnfrom, pSntkhoukbnto
            , pHhknfromnen, pHhkntonen, pTksyouhncd);
    }

    @Override
    public List<BM_ChkTkykHukaSeigen> getChkTkykHukaSeigensByPk(String pSyusyouhncd, Integer pSyouhnsdno, Integer pSntkhoukbn, BizNumber pHhknnen, String pTksyouhncd) {
        return toriatsukaiDomManager.getChkTkykHukaSeigensByPk(pSyusyouhncd, pSyouhnsdno, pSntkhoukbn, pHhknnen, pTksyouhncd);
    }

    @Override
    public List<BM_ChkKata> getAllChkKata() {
        return toriatsukaiDomManager.getAllChkKata();
    }

    @Override
    public BM_ChkKata getChkKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn) {
        return toriatsukaiDomManager.getChkKata(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pTktanbrumu, pKatakbn);
    }

    @Override
    public List<BM_ChkKata> getChkKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn) {
        return toriatsukaiDomManager.getChkKatasByPk(pSyouhncd, pSyouhnsdno, pTktanbrumu, pKatakbn);
    }

    @Override
    public List<BM_ChkKyuuhuKata> getAllChkKyuuhuKata() {
        return toriatsukaiDomManager.getAllChkKyuuhuKata();
    }

    @Override
    public BM_ChkKyuuhuKata getChkKyuuhuKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KyhgndkataKbn pKyhkatakbn) {
        return toriatsukaiDomManager.getChkKyuuhuKata(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pKyhkatakbn);
    }

    @Override
    public List<BM_ChkKyuuhuKata> getChkKyuuhuKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_KyhgndkataKbn pKyhkatakbn) {
        return toriatsukaiDomManager.getChkKyuuhuKatasByPk(pSyouhncd, pSyouhnsdno, pKyhkatakbn);
    }

    @Override
    public List<BM_ChkTkykHukaKahi> getAllChkTkykHukaKahi() {
        return toriatsukaiDomManager.getAllChkTkykHukaKahi();
    }

    @Override
    public BM_ChkTkykHukaKahi getChkTkykHukaKahi(String pTksyouhncd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd) {
        return toriatsukaiDomManager.getChkTkykHukaKahi(pTksyouhncd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd);
    }

    @Override
    public List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisByPk(String pTksyouhncd, String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd) {
        return toriatsukaiDomManager.getChkTkykHukaKahisByPk(pTksyouhncd, pSyusyouhncd, pSyouhnsdno, pChannelcd);
    }

    @Override
    public List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_UmuKbn pTkhukahissuumu) {
        return toriatsukaiDomManager.getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(pSyusyouhncd, pSyouhnsdno, pChannelcd, pTkhukahissuumu);
    }

    @Override
    public List<BM_ChkSaiteiS> getAllChkSaiteiS() {
        return toriatsukaiDomManager.getAllChkSaiteiS();
    }

    @Override
    public BM_ChkSaiteiS getChkSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSaiteiS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pDntsdnumufrom, pDntsdnumuto
            , pHrkkknsmnkbnfrom, pHrkkknsmnkbnto, pHknkknfrom, pHknkknto, pSaiteisknwtkumufrom
            , pSaiteisknwtkumuto, pTuukasyu);
    }

    @Override
    public List<BM_ChkSaiteiS> getChkSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(pSyouhncd, pSyouhnsdno, pHrkkeiro, pSaiteisknwtkumu, pTuukasyu);
    }

    @Override
    public List<BM_ChkJhSaiteiS> getAllChkJhSaiteiS() {
        return toriatsukaiDomManager.getAllChkJhSaiteiS();
    }

    @Override
    public BM_ChkJhSaiteiS getChkJhSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkJhSaiteiS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pDntsdnumufrom, pDntsdnumuto
            , pHrkkknsmnkbnfrom, pHrkkknsmnkbnto, pHknkknfrom, pHknkknto, pSaiteisknwtkumufrom
            , pSaiteisknwtkumuto, pTuukasyu);
    }

    @Override
    public List<BM_ChkJhSaiteiS> getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(pSyouhncd, pSyouhnsdno, pHrkkeiro, pSaiteisknwtkumu, pTuukasyu);
    }

    @Override
    public List<BM_ChkJhSaiteiS> getChkJhSaiteiSsByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pDntsdnumufrom, Integer pDntsdnumuto, Integer pHrkkknsmnkbn
        , BizNumber pHknkkn, Integer pSaiteisknwtkumufrom, Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkJhSaiteiSsByPk(pSyouhncd, pSyouhnsdno, pDntsdnumufrom, pDntsdnumuto, pHrkkknsmnkbn
            , pHknkkn, pSaiteisknwtkumufrom, pSaiteisknwtkumuto, pTuukasyu);
    }

    @Override
    public List<BM_ChkNenkinSaiteiS> getAllChkNenkinSaiteiS() {
        return toriatsukaiDomManager.getAllChkNenkinSaiteiS();
    }

    @Override
    public BM_ChkNenkinSaiteiS getChkNenkinSaiteiS(Integer pNenkinkkn, String pNenkinsyu) {
        return toriatsukaiDomManager.getChkNenkinSaiteiS(pNenkinkkn, pNenkinsyu);
    }

    @Override
    public List<BM_ChkSaikouSSTani> getAllChkSaikouSSTani() {
        return toriatsukaiDomManager.getAllChkSaikouSSTani();
    }

    @Override
    public BM_ChkSaikouSSTani getChkSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSaikouSSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto, pTuukasyu);
    }

    @Override
    public List<BM_ChkSaikouSSTani> getChkSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSaikouSSTanisByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn, pTuukasyu);
    }

    @Override
    public List<BM_ChkJhSaikouSSTani> getAllChkJhSaikouSSTani() {
        return toriatsukaiDomManager.getAllChkJhSaikouSSTani();
    }

    @Override
    public BM_ChkJhSaikouSSTani getChkJhSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkJhSaikouSSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto, pTuukasyu);
    }

    @Override
    public List<BM_ChkJhSaikouSSTani> getChkJhSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkJhSaikouSSTanisByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn, pTuukasyu);
    }

    @Override
    public List<BM_ChkKeiyakuTaniSaikouS> getAllChkKeiyakuTaniSaikouS() {
        return toriatsukaiDomManager.getAllChkKeiyakuTaniSaikouS();
    }

    @Override
    public BM_ChkKeiyakuTaniSaikouS getChkKeiyakuTaniSaikouS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto) {
        return toriatsukaiDomManager.getChkKeiyakuTaniSaikouS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto);
    }

    @Override
    public List<BM_ChkKeiyakuTaniSaikouS> getChkKeiyakuTaniSaikouSsByPk(String pSyouhncd, Integer pSyouhnsdno) {
        return toriatsukaiDomManager.getChkKeiyakuTaniSaikouSsByPk(pSyouhncd, pSyouhnsdno);
    }

    @Override
    public List<BM_ChkKokutiJougenS> getAllChkKokutiJougenS() {
        return toriatsukaiDomManager.getAllChkKokutiJougenS();
    }

    @Override
    public BM_ChkKokutiJougenS getChkKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto) {
        return toriatsukaiDomManager.getChkKokutiJougenS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto);
    }

    @Override
    public List<BM_ChkKokutiJougenS> getChkKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn) {
        return toriatsukaiDomManager.getChkKokutiJougenSsByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn);
    }

    @Override
    public List<BM_ChkSyouhnKokutiJougenS> getAllChkSyouhnKokutiJougenS() {
        return toriatsukaiDomManager.getAllChkSyouhnKokutiJougenS();
    }

    @Override
    public BM_ChkSyouhnKokutiJougenS getChkSyouhnKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto) {
        return toriatsukaiDomManager.getChkSyouhnKokutiJougenS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto);
    }

    @Override
    public List<BM_ChkSyouhnKokutiJougenS> getChkSyouhnKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn) {
        return toriatsukaiDomManager.getChkSyouhnKokutiJougenSsByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn);
    }

    @Override
    public List<BM_ChkNenkinSyurui> getAllChkNenkinSyurui() {
        return toriatsukaiDomManager.getAllChkNenkinSyurui();
    }

    @Override
    public BM_ChkNenkinSyurui getChkNenkinSyurui(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Sknenkinsyu pSknenkinsyu) {
        return toriatsukaiDomManager.getChkNenkinSyurui(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSknenkinsyu);
    }

    @Override
    public List<BM_ChkTargetTkMokuhyouti> getAllChkTargetTkMokuhyouti() {
        return toriatsukaiDomManager.getAllChkTargetTkMokuhyouti();
    }

    @Override
    public BM_ChkTargetTkMokuhyouti getChkTargetTkMokuhyouti(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {
        return toriatsukaiDomManager.getChkTargetTkMokuhyouti(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd, pTargettkmokuhyouti);
    }

    @Override
    public List<BM_ChkTargetTkMokuhyouti> getChkTargetTkMokuhyoutisByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {
        return toriatsukaiDomManager.getChkTargetTkMokuhyoutisByPk(pSyouhncd, pSyouhnsdno, pChannelcd, pTargettkmokuhyouti);
    }

    @Override
    public List<BM_ChkKokutiTuusanS> getAllChkKokutiTuusanS() {
        return toriatsukaiDomManager.getAllChkKokutiTuusanS();
    }

    @Override
    public BM_ChkKokutiTuusanS getChkKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto) {
        return toriatsukaiDomManager.getChkKokutiTuusanS(pHhknfromnen, pHhkntonen, pKijikbn, pIktkktkbnfrom, pIktkktkbnto);
    }

    @Override
    public List<BM_ChkKokutiTuusanS> getChkKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkKokutiTuusanSsByHhknnen(pHhknnen);
    }

    @Override
    public List<BM_ChkJhKokutiTuusanS> getAllChkJhKokutiTuusanS() {
        return toriatsukaiDomManager.getAllChkJhKokutiTuusanS();
    }

    @Override
    public BM_ChkJhKokutiTuusanS getChkJhKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto) {
        return toriatsukaiDomManager.getChkJhKokutiTuusanS(pHhknfromnen, pHhkntonen, pKijikbn, pIktkktkbnfrom, pIktkktkbnto);
    }

    @Override
    public List<BM_ChkJhKokutiTuusanS> getChkJhKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkJhKokutiTuusanSsByHhknnen(pHhknnen);
    }

    @Override
    public List<BM_ChkTuusanS> getAllChkTuusanS() {
        return toriatsukaiDomManager.getAllChkTuusanS();
    }

    @Override
    public BM_ChkTuusanS getChkTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkTuusanS(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkTuusanS> getChkTuusanSsByPk(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkTuusanSsByPk(pHhknnen);
    }

    @Override
    public List<BM_ChkJhTuusanS> getAllChkJhTuusanS() {
        return toriatsukaiDomManager.getAllChkJhTuusanS();
    }

    @Override
    public BM_ChkJhTuusanS getChkJhTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkJhTuusanS(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkJhTuusanS> getChkJhTuusanSsByPk(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkJhTuusanSsByPk(pHhknnen);
    }

    @Override
    public List<BM_ChkNenreiNensyuuTuusanS> getAllChkNenreiNensyuuTuusanS() {
        return toriatsukaiDomManager.getAllChkNenreiNensyuuTuusanS();
    }

    @Override
    public BM_ChkNenreiNensyuuTuusanS getChkNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu) {
        return toriatsukaiDomManager.getChkNenreiNensyuuTuusanS(pHhknfromnen, pHhkntonen, pHhknfromnensyuu, pHhkntonensyuu);
    }

    @Override
    public List<BM_ChkJhNenreiNensyuuTuusanS> getAllChkJhNenreiNensyuuTuusanS() {
        return toriatsukaiDomManager.getAllChkJhNenreiNensyuuTuusanS();
    }

    @Override
    public BM_ChkJhNenreiNensyuuTuusanS getChkJhNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu) {
        return toriatsukaiDomManager.getChkJhNenreiNensyuuTuusanS(pHhknfromnen, pHhkntonen, pHhknfromnensyuu, pHhkntonensyuu);
    }

    @Override
    public List<BM_ChkItijibrTuusanP> getAllChkItijibrTuusanP() {
        return toriatsukaiDomManager.getAllChkItijibrTuusanP();
    }

    @Override
    public BM_ChkItijibrTuusanP getChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkItijibrTuusanP(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkItijibrTuusanP> getChkItijibrTuusanPsByPK(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkItijibrTuusanPsByPK(pHhknnen);
    }

    @Override
    public List<BM_ChkSyokugyou> getAllChkSyokugyou() {
        return toriatsukaiDomManager.getAllChkSyokugyou();
    }

    @Override
    public BM_ChkSyokugyou getChkSyokugyou(String pSyokugyoucd) {
        return toriatsukaiDomManager.getChkSyokugyou(pSyokugyoucd);
    }

    @Override
    public List<BM_ChkNkgns> getAllChkNkgns() {
        return toriatsukaiDomManager.getAllChkNkgns();
    }

    @Override
    public BM_ChkNkgns getChkNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkNkgns(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkNkgns> getChkNkgnssByPK(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkNkgnssByPK(pHhknnen);
    }

    @Override
    public List<BM_ChkJhNkgns> getAllChkJhNkgns() {
        return toriatsukaiDomManager.getAllChkJhNkgns();
    }

    @Override
    public BM_ChkJhNkgns getChkJhNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkJhNkgns(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkJhNkgns> getChkJhNkgnssByPK(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkJhNkgnssByPK(pHhknnen);
    }

    @Override
    public List<BM_ChkItijibrTuusanS> getAllChkItijibrTuusanS() {
        return toriatsukaiDomManager.getAllChkItijibrTuusanS();
    }

    @Override
    public BM_ChkItijibrTuusanS getChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkItijibrTuusanS(pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkItijibrTuusanS> getChkItijibrTuusanSsByPK(BizNumber pHhknnen) {
        return toriatsukaiDomManager.getChkItijibrTuusanSsByPK(pHhknnen);
    }

    @Override
    public List<BM_ChkKykDairitenTuusanS> getAllChkKykDairitenTuusanS() {
        return toriatsukaiDomManager.getAllChkKykDairitenTuusanS();
    }

    @Override
    public BM_ChkKykDairitenTuusanS getChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {
        return toriatsukaiDomManager.getChkKykDairitenTuusanS(pKihonssyuruikbn);
    }

    @Override
    public List<BM_ChkNensyuuBairitu> getAllChkNensyuuBairitu() {
        return toriatsukaiDomManager.getAllChkNensyuuBairitu();
    }

    @Override
    public BM_ChkNensyuuBairitu getChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {
        return toriatsukaiDomManager.getChkNensyuuBairitu(pNensyuukbn);
    }

    @Override
    public List<BM_ChkSaiteiP> getAllChkSaiteiP() {
        return toriatsukaiDomManager.getAllChkSaiteiP();
    }

    @Override
    public List<BM_ChkSaiteiP> getChkSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        return toriatsukaiDomManager.getChkSaiteiPsByPk(pSyouhncd, pChannelcd, pHrkkaisuu, pHrkkkny, pSyouhnsdno
            , pTuukasyu, pSyouhinbetukey1);
    }

    @Override
    public BM_ChkSaiteiP getChkSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        return toriatsukaiDomManager.getChkSaiteiP(pSyouhncd, pHrkkaisuu, pHrkkknfrom, pHrkkknto, pSyusyouhnsdnofrom
            , pSyusyouhnsdnoto, pChannelcd, pTuukasyu, pSyouhinbetukey1);
    }

    @Override
    public List<BM_ChkJhSaiteiP> getAllChkJhSaiteiP() {
        return toriatsukaiDomManager.getAllChkJhSaiteiP();
    }

    @Override
    public List<BM_ChkJhSaiteiP> getChkJhSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        return toriatsukaiDomManager.getChkJhSaiteiPsByPk(pSyouhncd, pChannelcd, pHrkkaisuu, pHrkkkny, pSyouhnsdno
            , pTuukasyu, pSyouhinbetukey1);
    }

    @Override
    public BM_ChkJhSaiteiP getChkJhSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        return toriatsukaiDomManager.getChkJhSaiteiP(pSyouhncd, pHrkkaisuu, pHrkkknfrom, pHrkkknto, pSyusyouhnsdnofrom
            , pSyusyouhnsdnoto, pChannelcd, pTuukasyu, pSyouhinbetukey1);
    }

    @Override
    public List<BM_ChkSTani> getAllChkSTani() {
        return toriatsukaiDomManager.getAllChkSTani();
    }

    @Override
    public BM_ChkSTani getChkSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pTuukasyu);
    }

    @Override
    public List<BM_ChkSTani> getChkSTanisByPK(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, C_Tuukasyu pTuukasyu) {
        return toriatsukaiDomManager.getChkSTanisByPK(pSyouhncd, pSyouhnsdno, pHhknnen, pTuukasyu);
    }

    @Override
    public List<BM_ChkHrkPTani> getAllChkHrkPTani() {
        return toriatsukaiDomManager.getAllChkHrkPTani();
    }

    @Override
    public BM_ChkHrkPTani getChkHrkPTani(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd
        , C_Tuukasyu pHrktuukasyu) {
        return toriatsukaiDomManager.getChkHrkPTani(pSyouhncd, pHrkkaisuu, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd
            , pHrktuukasyu);
    }

    @Override
    public List<BM_ChkHrkPTani> getChkHrkPTanisByPK(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_Tuukasyu pHrktuukasyu) {
        return toriatsukaiDomManager.getChkHrkPTanisByPK(pSyouhncd, pHrkkaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu);
    }

    @Override
    public List<BM_ChkNkgnsHonken> getAllChkNkgnsHonken() {
        return toriatsukaiDomManager.getAllChkNkgnsHonken();
    }

    @Override
    public BM_ChkNkgnsHonken getChkNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkNkgnsHonken(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkJhNkgnsHonken> getAllChkJhNkgnsHonken() {
        return toriatsukaiDomManager.getAllChkJhNkgnsHonken();
    }

    @Override
    public BM_ChkJhNkgnsHonken getChkJhNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        return toriatsukaiDomManager.getChkJhNkgnsHonken(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen);
    }

    @Override
    public List<BM_ChkSueokiKikan> getAllChkSueokiKikan() {
        return toriatsukaiDomManager.getAllChkSueokiKikan();
    }

    @Override
    public BM_ChkSueokiKikan getChkSueokiKikan(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pSueokikkn
        , C_SueokikknsmnKbn pSueokikknsmnkbn) {
        return toriatsukaiDomManager.getChkSueokiKikan(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd, pSueokikkn
            , pSueokikknsmnkbn);
    }

    @Override
    public List<BM_ChkSueokiKikan> getChkSueokiKikansByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pSueokikkn, C_SueokikknsmnKbn pSueokikknsmnkbn) {
        return toriatsukaiDomManager.getChkSueokiKikansByPk(pSyouhncd, pSyouhnsdno, pChannelcd, pSueokikkn, pSueokikknsmnkbn);
    }

    @Override
    public List<BM_ChkNkgnsHonken> getChkNkgnsHonkenByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pHhknnen) {
        return toriatsukaiDomManager.getChkNkgnsHonkenByPk(pSyouhncd, pSyouhnsdno, pHhknnen);
    }

    @Override
    public List<BM_ChkNenreiHani2> getAllChkNenreiHani2() {
        return toriatsukaiDomManager.getAllChkNenreiHani2();
    }

    @Override
    public BM_ChkNenreiHani2 getChkNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        return toriatsukaiDomManager.getChkNenreiHani2(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknseifrom
            , pHhknseito, pSyukatakbn, pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn
            , pSyuhrkkkn, pSyuhrkkknto, pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen
            , pSyuyoteiriritufrom, pSyuyoteirirituto, pSyudai1hknkkn, pTokusyuchkno
            , pTksyouhncd, pTkhknkkn, pTkhknkknto, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknto, pTkhrkkknsmnkbn, pTkfromnen, pTktonen);
    }

    @Override
    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSyuyoteiriritu
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, int pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbnumu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSyuyoteiriritu
            , pSyudai1hknkkn, pSeibetu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public Long getChkNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {
        return toriatsukaiDomManager.getChkNenreiHani2CountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn
            , pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen
            , pSyuyoteiriritu, pSyudai1hknkkn);
    }

    @Override
    public List<BM_ChkJhNenreiHani2> getAllChkJhNenreiHani2() {
        return toriatsukaiDomManager.getAllChkJhNenreiHani2();
    }

    @Override
    public BM_ChkJhNenreiHani2 getChkJhNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        return toriatsukaiDomManager.getChkJhNenreiHani2(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknseifrom
            , pHhknseito, pSyukatakbn, pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn
            , pSyuhrkkkn, pSyuhrkkknto, pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen
            , pSyuyoteiriritufrom, pSyuyoteirirituto, pSyudai1hknkkn, pTokusyuchkno
            , pTksyouhncd, pTkhknkkn, pTkhknkknto, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknto, pTkhrkkknsmnkbn, pTkfromnen, pTktonen);
    }

    @Override
    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pTkykmossyouhnumu) {
        return toriatsukaiDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pTkykmossyouhnumu);
    }

    @Override
    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , int pSeibetu, BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pNen
            , pSeibetu, pSyuyoteiriritu, pSyudai1hknkkn, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, int pSeibetu
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        return toriatsukaiDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSeibetu
            , pSyuyoteiriritu, pSyudai1hknkkn, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn
            , pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    @Override
    public Long getChkJhNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {
        return toriatsukaiDomManager.getChkJhNenreiHani2CountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn
            , pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen
            , pSyuyoteiriritu, pSyudai1hknkkn);
    }

    @Override
    public List<BM_KawaseRate> getAllKawaseRate() {
        return kawaseRateDomManager.getAllKawaseRate();
    }

    @Override
    public BM_KawaseRate getKawaseRate(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn, C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawasetekiyokbn
        , C_KawasetsryKbn pKawasetsrykbn) {
        return kawaseRateDomManager.getKawaseRate(pKwsratekjymd, pKwsrendoukbn, pMototuuka, pKanzantuuka, pKawasetekiyokbn
            , pKawasetsrykbn);
    }

    @Override
    public List<BM_TuukabetuKyuusibi> getAllTuukabetuKyuusibi() {
        return kawaseRateDomManager.getAllTuukabetuKyuusibi();
    }

    @Override
    public BM_TuukabetuKyuusibi getTuukabetuKyuusibi(BizDate pTuukatoriatukaiymd) {
        return kawaseRateDomManager.getTuukabetuKyuusibi(pTuukatoriatukaiymd);
    }

    @Override
    public List<BM_UnitFundKbn> getAllUnitFundKbn() {
        return kawaseRateDomManager.getAllUnitFundKbn();
    }

    @Override
    public BM_UnitFundKbn getUnitFundKbn(String pSyouhncd, Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, Integer pRenno) {
        return kawaseRateDomManager.getUnitFundKbn(pSyouhncd, pSyouhnsdno, pTuukasyu, pRenno);
    }

    @Override
    public List<BM_KijyungkHanteiKawaseRate> getAllKijyungkHanteiKawaseRate() {
        return kawaseRateDomManager.getAllKijyungkHanteiKawaseRate();
    }

    @Override
    public BM_KijyungkHanteiKawaseRate getKijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {
        return kawaseRateDomManager.getKijyungkHanteiKawaseRate(pKijunnendo, pKyktuukasyu);
    }

    @Override
    public List<BM_FundIndexKihon> getAllFundIndexKihon() {
        return kawaseRateDomManager.getAllFundIndexKihon();
    }

    @Override
    public BM_FundIndexKihon getFundIndexKihon(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd) {
        return kawaseRateDomManager.getFundIndexKihon(pUnitfundkbn, pFundhyoukaymd);
    }

    @Override
    public List<BM_FundIndexSyokitousi> getAllFundIndexSyokitousi() {
        return kawaseRateDomManager.getAllFundIndexSyokitousi();
    }

    @Override
    public BM_FundIndexSyokitousi getFundIndexSyokitousi(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {
        return kawaseRateDomManager.getFundIndexSyokitousi(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    @Override
    public List<BM_FundIndexGetumatuCf> getAllFundIndexGetumatuCf() {
        return kawaseRateDomManager.getAllFundIndexGetumatuCf();
    }

    @Override
    public BM_FundIndexGetumatuCf getFundIndexGetumatuCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {
        return kawaseRateDomManager.getFundIndexGetumatuCf(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    @Override
    public List<BM_FundIndexGessyoCf> getAllFundIndexGessyoCf() {
        return kawaseRateDomManager.getAllFundIndexGessyoCf();
    }

    @Override
    public BM_FundIndexGessyoCf getFundIndexGessyoCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {
        return kawaseRateDomManager.getFundIndexGessyoCf(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    @Override
    public List<BM_FundIndexCfGaku> getAllFundIndexCfGaku() {
        return kawaseRateDomManager.getAllFundIndexCfGaku();
    }

    @Override
    public BM_FundIndexCfGaku getFundIndexCfGaku(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {
        return kawaseRateDomManager.getFundIndexCfGaku(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    @Override
    public List<BM_NenkinYoteiRiritu> getAllNenkinYoteiRiritu() {
        return kawaseRateDomManager.getAllNenkinYoteiRiritu();
    }

    @Override
    public List<BM_NenkinYoteiRiritu> getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykymd) {
        return kawaseRateDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(pNenkinsyu, pTuukasyu, pKykymd);
    }

    @Override
    public BM_NenkinYoteiRiritu getNenkinYoteiRiritu(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykfromymd, BizDate pKyktoymd) {
        return kawaseRateDomManager.getNenkinYoteiRiritu(pNenkinsyu, pTuukasyu, pKykfromymd, pKyktoymd);
    }

    @Override
    public List<BM_YoteiRiritu> getAllYoteiRiritu() {
        return kawaseRateDomManager.getAllYoteiRiritu();
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pCalckijyunymd) {
        return kawaseRateDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(pSyouhncd, pTuukasyu, pCalckijyunymd);
    }

    @Override
    public BM_YoteiRiritu getYoteiRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {
        return kawaseRateDomManager.getYoteiRiritu(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu, BizDate pKykymd) {
        return kawaseRateDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(pMosno, pSyutkkbn, pTuukasyu, pKykymd);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyu(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu) {
        return kawaseRateDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(pMosno, pSyutkkbn, pTuukasyu);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pKykymd) {
        return kawaseRateDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(pSyouhncd, pTuukasyu, pKykymd);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {
        return kawaseRateDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd(pSyouhncd, pKykymd);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyu(String pSyouhncd, C_Tuukasyu pTuukasyu) {
        return kawaseRateDomManager.getYoteiRiritusBySyouhncdTuukasyu(pSyouhncd, pTuukasyu);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {
        return kawaseRateDomManager.getYoteiRiritusByPK(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    @Override
    public List<BM_YoteiRiritu> getYoteiRiritusByKyktoymdMax() {
        return kawaseRateDomManager.getYoteiRiritusByKyktoymdMax();
    }

    @Override
    public List<BM_YoteiRiritu2> getYoteiRiritu2sByKijyuntoymdMax() {
        return kawaseRateDomManager.getYoteiRiritu2sByKijyuntoymdMax();
    }

    @Override
    public List<BM_YoteiRiritu2> getYoteiRiritu2sBySyouhncdKijyuntoymdMax(String pSyouhncd) {
        return kawaseRateDomManager.getYoteiRiritu2sBySyouhncdKijyuntoymdMax(pSyouhncd);
    }

    @Override
    public List<BM_YoteiRiritu3> getAllYoteiRiritu3() {
        return kawaseRateDomManager.getAllYoteiRiritu3();
    }

    @Override
    public BM_YoteiRiritu3 getYoteiRiritu3(String pSyouhncd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd) {
        return kawaseRateDomManager.getYoteiRiritu3(pSyouhncd, pTuukasyu, pYoteiriritutkybr1, pYoteiriritutkybr2, pKijyunfromymd
            , pKijyuntoymd);
    }


    @Override
    public List<BM_YoteiRiritu3> getYoteiRiritu3sBySyouhncdKijyuntoymdMax(String pSyouhncd) {
        return kawaseRateDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax(pSyouhncd);
    }

    @Override
    public List<BM_YoteiRirituRendouSeigyo> getAllYoteiRirituRendouSeigyo() {
        return kawaseRateDomManager.getAllYoteiRirituRendouSeigyo();
    }

    @Override
    public BM_YoteiRirituRendouSeigyo getYoteiRirituRendouSeigyo(String pYoteirirituhanteidfrom, String yoteirirituhanteidto, String pSyouhncd) {
        return kawaseRateDomManager.getYoteiRirituRendouSeigyo(pYoteirirituhanteidfrom, yoteirirituhanteidto, pSyouhncd);
    }

    @Override
    public List<BM_YoteiRirituRendouSeigyo> getYoteiRirituRendouSeigyosByYoteirirituhanteid(String pYoteirirituhanteid) {
        return kawaseRateDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid(pYoteirirituhanteid);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getAllSjkkkTyouseiyouRiritu() {
        return kawaseRateDomManager.getAllSjkkkTyouseiyouRiritu();
    }

    @Override
    public BM_SjkkkTyouseiyouRiritu getSjkkkTyouseiyouRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritu(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritusByPK(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPKKykymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritusByPKKykymd(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykymd);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(pSyouhncd, pTuukasyu, pHhknnenkbn);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByKyktoymdMax() {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritusByKyktoymdMax();
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPk(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritusByPk(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykymd);
    }

    @Override
    public List<BM_KaiyakuKoujyoRitu> getAllKaiyakuKoujyoRitu() {
        return kawaseRateDomManager.getAllKaiyakuKoujyoRitu();
    }

    @Override
    public BM_KaiyakuKoujyoRitu getKaiyakuKoujyoRitu(String pSyouhncd, String pRyouritusdno, String pKaiyakukjtkybr1, String pKaiyakukjtkybr2, Integer pKeikanensuu) {
        return kawaseRateDomManager.getKaiyakuKoujyoRitu(pSyouhncd, pRyouritusdno, pKaiyakukjtkybr1, pKaiyakukjtkybr2, pKeikanensuu);
    }

    @Override
    public List<BM_RateP> getAllRateP() {
        return kawaseRateDomManager.getAllRateP();
    }

    @Override
    public BM_RateP getRateP(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {
        return kawaseRateDomManager.getRateP(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    @Override
    public List<BM_RateV> getAllRateV() {
        return kawaseRateDomManager.getAllRateV();
    }

    @Override
    public BM_RateV getRateV(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {
        return kawaseRateDomManager.getRateV(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    @Override
    public List<BM_RateD> getAllRateD() {
        return kawaseRateDomManager.getAllRateD();
    }

    @Override
    public BM_RateD getRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {
        return kawaseRateDomManager.getRateD(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    @Override
    public List<BM_RateNenkinPkisoV> getAllRateNenkinPkisoV() {
        return kawaseRateDomManager.getAllRateNenkinPkisoV();
    }

    @Override
    public BM_RateNenkinPkisoV getRateNenkinPkisoV(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode) {
        return kawaseRateDomManager.getRateNenkinPkisoV(pPalnenkinsisutemusyurui, pPalnenkinsyuruikigou, pPalnenkinkigousedaicode, pPalnenkinsiharaikikan
            , pPalnnknksgyoteiriritucode, pPalnnknksgjmtesuuryoucode);
    }

    @Override
    public List<BM_RateNenkinD> getAllRateNenkinD() {
        return kawaseRateDomManager.getAllRateNenkinD();
    }

    @Override
    public BM_RateNenkinD getRateNenkinD(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode, String pPaldnendo, String pPaldratenaikakucode) {
        return kawaseRateDomManager.getRateNenkinD(pPalnenkinsisutemusyurui, pPalnenkinsyuruikigou, pPalnenkinkigousedaicode, pPalnenkinsiharaikikan
            , pPalnnknksgyoteiriritucode, pPalnnknksgjmtesuuryoucode, pPaldnendo, pPaldratenaikakucode);
    }

    @Override
    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {
        return kawaseRateDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(pTyakkinyoteiymd, pSyutokuendymd);
    }

    @Override
    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {
        return kawaseRateDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(pTyakkinyoteiymd, pSyutokuendymd);
    }

    @Override
    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {
        return kawaseRateDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(pTyakkinyoteiymd, pSyutokuendymd);
    }

    @Override
    public List<BM_YoteiRiritu2> getAllYoteiRiritu2() {
        return kawaseRateDomManager.getAllYoteiRiritu2();
    }

    @Override
    public BM_YoteiRiritu2 getYoteiRiritu2(String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        return kawaseRateDomManager.getYoteiRiritu2(pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pKijyunfromymd, pKijyuntoymd);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu2> getAllSjkkkTyouseiyouRiritu2() {
        return kawaseRateDomManager.getAllSjkkkTyouseiyouRiritu2();
    }

    @Override
    public BM_SjkkkTyouseiyouRiritu2 getSjkkkTyouseiyouRiritu2(String pSyouhncd, String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd) {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritu2(pSyouhncd, pSjkkktyouseiriritutkybr1, pSjkkktyouseiriritutkybr2, pKijyunfromymd
            , pKijyuntoymd);
    }

    @Override
    public List<BM_Sisuu> getAllSisuu() {
        return kawaseRateDomManager.getAllSisuu();
    }

    @Override
    public BM_Sisuu getSisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {
        return kawaseRateDomManager.getSisuu(pSisuukbn, pSisuukouhyouymd);
    }

    @Override
    public List<BM_SisuuKihon> getAllSisuuKihon() {
        return kawaseRateDomManager.getAllSisuuKihon();
    }

    @Override
    public BM_SisuuKihon getSisuuKihon(C_Sisuukbn pSisuukbn) {
        return kawaseRateDomManager.getSisuuKihon(pSisuukbn);
    }

    @Override
    public List<BM_HsykkntkSysnNkGnsritu> getAllHsykkntkSysnNkGnsritu() {
        return kawaseRateDomManager.getAllHsykkntkSysnNkGnsritu();
    }

    @Override
    public BM_HsykkntkSysnNkGnsritu getHsykkntkSysnNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, C_Seibetu pSeibetu, Integer pNkshrstartnen) {
        return kawaseRateDomManager.getHsykkntkSysnNkGnsritu(pRyouritusdno, pTuukasyu, pSeibetu, pNkshrstartnen);
    }

    @Override
    public List<BM_KktNkGnsritu> getAllKktNkGnsritu() {
        return kawaseRateDomManager.getAllKktNkGnsritu();
    }

    @Override
    public BM_KktNkGnsritu getKktNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {
        return kawaseRateDomManager.getKktNkGnsritu(pRyouritusdno, pTuukasyu, pShrkkn);
    }

    @Override
    public List<BM_Sisuu> getSisuusBySisuukouhyouymdMax() {
        return kawaseRateDomManager.getSisuusBySisuukouhyouymdMax();
    }

    @Override
    public List<BM_AzukariRiritu> getAllAzukariRiritu() {
        return kawaseRateDomManager.getAllAzukariRiritu();
    }

    @Override
    public BM_AzukariRiritu getAzukariRiritu(C_Tuukasyu pTuukasyu, BizDate pTkyfromymd, BizDate pTkytoymd) {
        return kawaseRateDomManager.getAzukariRiritu(pTuukasyu, pTkyfromymd, pTkytoymd);
    }

    @Override
    public List<BM_HaitouRiritu> getAllHaitouRiritu() {
        return kawaseRateDomManager.getAllHaitouRiritu();
    }

    @Override
    public BM_HaitouRiritu getHaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        return kawaseRateDomManager.getHaitouRiritu(pKijyunfromymd, pKijyuntoymd);
    }

    @Override
    public List<BM_IkkatuKeisuu> getAllIkkatuKeisuu() {
        return kawaseRateDomManager.getAllIkkatuKeisuu();
    }

    @Override
    public BM_IkkatuKeisuu getIkkatuKeisuu(Integer pIkttekiyouno, Integer pNen1nen2baraihyouji, Integer pKeikatukisuu) {
        return kawaseRateDomManager.getIkkatuKeisuu(pIkttekiyouno, pNen1nen2baraihyouji, pKeikatukisuu);
    }

    @Override
    public List<BM_IkkatuTekiyouNo> getAllIkkatuTekiyouNo() {
        return kawaseRateDomManager.getAllIkkatuTekiyouNo();
    }

    @Override
    public BM_IkkatuTekiyouNo getIkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno) {
        return kawaseRateDomManager.getIkkatuTekiyouNo(pSyouhncd, pRyouritusdno);
    }

    @Override
    public List<BM_IkkatuTekiyouNo2> getAllIkkatuTekiyouNo2() {
        return kawaseRateDomManager.getAllIkkatuTekiyouNo2();
    }

    @Override
    public BM_IkkatuTekiyouNo2 getIkkatuTekiyouNo2(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, String pIkttekiyoubr1, String pIkttekiyoubr2
        , String pIkttekiyoubr3) {
        return kawaseRateDomManager.getIkkatuTekiyouNo2(pSyouhncd, pRyouritusdno, pYoteiriritu, pIkttekiyoubr1, pIkttekiyoubr2
            , pIkttekiyoubr3);
    }

    @Override
    public List<BM_ZennouGenkaRitu> getAllZennouGenkaRitu() {
        return kawaseRateDomManager.getAllZennouGenkaRitu();
    }

    @Override
    public BM_ZennouGenkaRitu getZennouGenkaRitu(Integer pZennounensuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouGenkaRitu(pZennounensuu, pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouKeikaRiritu> getAllZennouKeikaRiritu() {
        return kawaseRateDomManager.getAllZennouKeikaRiritu();
    }

    @Override
    public BM_ZennouKeikaRiritu getZennouKeikaRiritu(Integer pKeikatukisuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouKeikaRiritu(pKeikatukisuu, pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouRiritu> getAllZennouRiritu() {
        return kawaseRateDomManager.getAllZennouRiritu();
    }

    @Override
    public BM_ZennouRiritu getZennouRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouRiritu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouTumitateRitu> getAllZennouTumitateRitu() {
        return kawaseRateDomManager.getAllZennouTumitateRitu();
    }

    @Override
    public BM_ZennouTumitateRitu getZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouTumitateRitu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_KktNk1stNkBigkGnsritu> getAllKktNk1stNkBigkGnsritu() {
        return kawaseRateDomManager.getAllKktNk1stNkBigkGnsritu();
    }

    @Override
    public BM_KktNk1stNkBigkGnsritu getKktNk1stNkBigkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {
        return kawaseRateDomManager.getKktNk1stNkBigkGnsritu(pRyouritusdno, pTuukasyu, pShrkkn);
    }

    @Override
    public List<BM_SibouRitu> getAllSibouRitu() {
        return kawaseRateDomManager.getAllSibouRitu();
    }

    @Override
    public BM_SibouRitu getSibouRitu(String pRyouritusdno, C_Seibetu pSeibetu, Integer pNen) {
        return kawaseRateDomManager.getSibouRitu(pRyouritusdno, pSeibetu, pNen);
    }

    @Override
    public BM_RisaHitSyouhnyouRateD getRisaHitSyouhnyouRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {
        return kawaseRateDomManager.getRisaHitSyouhnyouRateD(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    @Override
    public List<BM_RisaHitSyouhnyouRateD> getAllRisaHitSyouhnyouRateD() {
        return kawaseRateDomManager.getAllRisaHitSyouhnyouRateD();
    }

    @Override
    public List<BM_RateP2> getAllRateP2() {
        return kawaseRateDomManager.getAllRateP2();
    }

    @Override
    public BM_RateP2 getRateP2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPalryouritukbn) {
        return kawaseRateDomManager.getRateP2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn, pPalryouritukbn);
    }

    @Override
    public BM_RateP2 getRateP2byRatePkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {
        return kawaseRateDomManager.getRateP2byRatePkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    @Override
    public List<BM_RateV2> getAllRateV2() {
        return kawaseRateDomManager.getAllRateV2();
    }

    @Override
    public BM_RateV2 getRateV2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn) {
        return kawaseRateDomManager.getRateV2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn);
    }

    @Override
    public BM_RateV2 getRateV2byRateVkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {
        return kawaseRateDomManager.getRateV2byRateVkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    @Override
    public List<BM_RisaHitSyouhnyouRateD2> getAllRisaHitSyouhnyouRateD2() {
        return kawaseRateDomManager.getAllRisaHitSyouhnyouRateD2();
    }

    @Override
    public BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPaldnendo, String pPaldratenaikakucode) {
        return kawaseRateDomManager.getRisaHitSyouhnyouRateD2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn, pPaldnendo, pPaldratenaikakucode);
    }

    @Override
    public BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {
        return kawaseRateDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    @Override
    public List<BM_RateW> getAllRateW() {
        return kawaseRateDomManager.getAllRateW();
    }

    @Override
    public BM_RateW getRateW(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn) {
        return kawaseRateDomManager.getRateW(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn);
    }

    @Override
    public List<BM_TienrisokuRiritu> getAllTienrisokuRiritu() {
        return kawaseRateDomManager.getAllTienrisokuRiritu();
    }

    @Override
    public BM_TienrisokuRiritu getTienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getTienrisokuRiritu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouGenkaRitu2> getAllZennouGenkaRitu2() {
        return kawaseRateDomManager.getAllZennouGenkaRitu2();
    }

    @Override
    public BM_ZennouGenkaRitu2 getZennouGenkaRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pZennounensuu
        , String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouGenkaRitu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pZennounensuu
            , pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouKeikaRiritu2> getAllZennouKeikaRiritu2() {
        return kawaseRateDomManager.getAllZennouKeikaRiritu2();
    }

    @Override
    public BM_ZennouKeikaRiritu2 getZennouKeikaRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pKeikatukisuu
        , String pTekiyoukknfrom, String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouKeikaRiritu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pKeikatukisuu
            , pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouRiritu2> getAllZennouRiritu2() {
        return kawaseRateDomManager.getAllZennouRiritu2();
    }

    @Override
    public BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto) {
        return kawaseRateDomManager.getZennouRiritu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pTekiyoukknfrom
            , pTekiyoukknkto);
    }

    @Override
    public List<BM_ZennouTumitateRitu2> getAllZennouTumitateRitu2() {
        return kawaseRateDomManager.getAllZennouTumitateRitu2();
    }

    @Override
    public BM_ZennouTumitateRitu2 ZennouTumitateRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto) {
        return kawaseRateDomManager.ZennouTumitateRitu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pTekiyoukknfrom
            , pTekiyoukknkto);
    }

    @Override
    public List<BM_Ginkou> getAllGinkou() {
        return syuunouDomManager.getAllGinkou();
    }

    @Override
    public BM_Ginkou getGinkou(String pBankcd, String pSitencd) {
        return syuunouDomManager.getGinkou(pBankcd, pSitencd);
    }

    @Override
    public Long getGinkouCountByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn) {
        return syuunouDomManager.getGinkouCountByBankcdSitencdBanknmknSitennmkn(pBankcd, pSitencd, pBanknmkn, pSitennmkn);
    }

    @Override
    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn) {
        return syuunouDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd, pSitencd, pBanknmkn, pSitennmkn);
    }

    @Override
    public Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj) {
        return syuunouDomManager.getGinkouCountByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj);
    }

    @Override
    public Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt) {
        return syuunouDomManager.getGinkouCountByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj
            , pTysyttaisyougaibankcdhrt);
    }

    @Override
    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj) {
        return syuunouDomManager.getGinkousByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj);
    }

    @Override
    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt) {
        return syuunouDomManager.getGinkousByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj
            , pTysyttaisyougaibankcdhrt);
    }

    @Override
    public List<BM_CreditCardKaisya> getAllCreditCardKaisya() {
        return syuunouDomManager.getAllCreditCardKaisya();
    }

    @Override
    public BM_CreditCardKaisya getCreditCardKaisya(String pCardkaisyacd) {
        return syuunouDomManager.getCreditCardKaisya(pCardkaisyacd);
    }



    @Override
    public List<BM_KinyuuKikanHuhoyofuriInfo> getAllKinyuuKikanHuhoyofuriInfo() {
        return syuunouDomManager.getAllKinyuuKikanHuhoyofuriInfo();
    }

    @Override
    public BM_KinyuuKikanHuhoyofuriInfo getKinyuuKikanHuhoyofuriInfo(String pBankcd) {
        return syuunouDomManager.getKinyuuKikanHuhoyofuriInfo(pBankcd);
    }

    @Override
    public Long getGinkousCountByBankcdBanknmkn(String pBankcd, String pBanknmkn) {
        return syuunouDomManager.getGinkousCountByBankcdBanknmkn(pBankcd, pBanknmkn);
    }

    @Override
    public List<BM_Ginkou> getGinkousByBankcdBanknmknOrderByBankcdAsc(String pBankcd, String pBanknmkn) {
        return syuunouDomManager.getGinkousByBankcdBanknmknOrderByBankcdAsc(pBankcd, pBanknmkn);
    }

    @Override
    public List<BM_KanjyouKamoku> getAllKanjyouKamoku() {
        return keiriKaikeiDomManager.getAllKanjyouKamoku();
    }

    @Override
    public BM_KanjyouKamoku getKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd) {
        return keiriKaikeiDomManager.getKanjyouKamoku(pKanjyoukmkcd);
    }

    @Override
    public List<BT_DenpyoData> getAllDenpyoData() {
        return keiriKaikeiDomManager.getAllDenpyoData();
    }

    @Override
    public BT_DenpyoData getDenpyoData(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return keiriKaikeiDomManager.getDenpyoData(pDensyskbn, pDenrenno, pEdano);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdDensyskbn(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_DensysKbn pDensyskbn) {
        return keiriKaikeiDomManager.getDenpyoDatasBySyoriYmdDensyskbn(pSyoriYmdFrom, pSyoriYmdTo, pDensyskbn);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_DensysKbn... pDensyskbn) {
        return keiriKaikeiDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(pKakutyoujobcd, pSyoriYmd, pDensyskbn);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate pDenymd, BizDate pSyoriYmd, BizDate pFstpryosyuymd) {
        return keiriKaikeiDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(pDenymd, pSyoriYmd, pFstpryosyuymd);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(pSyoriYmd);
    }

    @Override
    public List<BT_DenpyoData> getDenpyoDatasByDenymdKanjyoukmkcds(BizDate pKensakuYmdFrom, BizDate pKensakuYmdTo) {
        return keiriKaikeiDomManager.getDenpyoDatasByDenymdKanjyoukmkcds(pKensakuYmdFrom, pKensakuYmdTo);
    }

    @Override
    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn) {
        return keiriKaikeiDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensyskbn, pKeirisyono, pDensyorikbn);
    }

    @Override
    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn, BizDate pDenymd) {
        return keiriKaikeiDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensyskbn, pKeirisyono, pDensyorikbn, pDenymd);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate pDenymdFrom, BizDate pDenymdTo) {
        return keiriKaikeiDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(pDenymdFrom, pDenymdTo);
    }

    @Override
    public List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> getBzSkHonsyaDenpyousByDenymdTaisyakukbn(BizDate pDenymdFrom, BizDate pDenymdTo, C_TaisyakuKbn pTaisyakukbn) {
        return keiriKaikeiDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(pDenymdFrom, pDenymdTo, pTaisyakukbn);
    }

    @Override
    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BT_HuriDenpyou> getAllHuriDenpyou() {
        return keiriKaikeiDomManager.getAllHuriDenpyou();
    }

    @Override
    public BT_HuriDenpyou getHuriDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return keiriKaikeiDomManager.getHuriDenpyou(pDensyskbn, pDenrenno, pEdano);
    }

    @Override
    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousBySyoriYmd(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getHuriDenpyousBySyoriYmd(pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBUpdatableResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BM_Segment> getAllSegment() {
        return keiriKaikeiDomManager.getAllSegment();
    }

    @Override
    public BM_Segment getSegment(C_Segcd pSegcd) {
        return keiriKaikeiDomManager.getSegment(pSegcd);
    }

    @Override
    public List<BM_DensimeNenkanSchedule> getAllDensimeNenkanSchedule() {
        return keiriKaikeiDomManager.getAllDensimeNenkanSchedule();
    }

    @Override
    public BM_DensimeNenkanSchedule getDensimeNenkanSchedule(BizDateYM pSyoriym) {
        return keiriKaikeiDomManager.getDensimeNenkanSchedule(pSyoriym);
    }

    @Override
    public List<BT_KawaseRateData> getAllKawaseRateData() {
        return keiriKaikeiDomManager.getAllKawaseRateData();
    }

    @Override
    public BT_KawaseRateData getKawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {
        return keiriKaikeiDomManager.getKawaseRateData(pKwsratekjymd, pKwsrendoukbn);
    }

    @Override
    public List<BT_SinkeiyakuHurikaeDen> getAllSinkeiyakuHurikaeDen() {
        return keiriKaikeiDomManager.getAllSinkeiyakuHurikaeDen();
    }

    @Override
    public BT_SinkeiyakuHurikaeDen getSinkeiyakuHurikaeDen(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return keiriKaikeiDomManager.getSinkeiyakuHurikaeDen(pDensyskbn, pDenrenno, pEdano);
    }

    @Override
    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensBySyoriYmd(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getSinkeiyakuHurikaeDensBySyoriYmd(pSyoriYmd);
    }

    @Override
    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BT_Hjyblist> getAllHjyblist() {
        return keiriKaikeiDomManager.getAllHjyblist();
    }

    @Override
    public BT_Hjyblist getHjyblist(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, String pSyorisyokantantcd, BizDate pDenymd) {
        return keiriKaikeiDomManager.getHjyblist(pHjybtantositucd, pKanjyoukmkcd, pSyorisyokantantcd, pDenymd);
    }

    @Override
    public ExDBResults<BT_Hjyblist> getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(String pKakutyoujobcd, BizDate pDenymdFrom, BizDate pDenymdTo) {
        return keiriKaikeiDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(pKakutyoujobcd, pDenymdFrom, pDenymdTo);
    }

    @Override
    public List<BT_Hjybruikeigaku> getAllHjybruikeigaku() {
        return keiriKaikeiDomManager.getAllHjybruikeigaku();
    }

    @Override
    public BT_Hjybruikeigaku getHjybruikeigaku(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym) {
        return keiriKaikeiDomManager.getHjybruikeigaku(pHjybtantositucd, pKanjyoukmkcd, pDenym);
    }

    @Override
    public List<BT_Hjybruikeigaku> getHjybruikeigakusByPK(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym) {
        return keiriKaikeiDomManager.getHjybruikeigakusByPK(pHjybtantositucd, pKanjyoukmkcd, pDenym);
    }

    @Override
    public List<BT_Nyknmeisai> getAllNyknmeisai() {
        return keiriKaikeiDomManager.getAllNyknmeisai();
    }

    @Override
    public BT_Nyknmeisai getNyknmeisai(String pHrkmsakuseiymd6keta, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano
        , String pHrkmsyoukaino, String pHrkmrenno8) {
        return keiriKaikeiDomManager.getNyknmeisai(pHrkmsakuseiymd6keta, pHrkmbankcd, pHrkmshitencd, pHrkmyokinkbn, pHrkmkouzano
            , pHrkmsyoukaino, pHrkmrenno8);
    }

    @Override
    public ExDBResults<BT_Nyknmeisai> getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(String pKakutyoujobcd, String pHrkmsakuseiymd6keta) {
        return keiriKaikeiDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(pKakutyoujobcd, pHrkmsakuseiymd6keta);
    }

    @Override
    public List<BT_Gknyknmeisai> getAllGknyknmeisai() {
        return keiriKaikeiDomManager.getAllGknyknmeisai();
    }

    @Override
    public BT_Gknyknmeisai getGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {
        return keiriKaikeiDomManager.getGknyknmeisai(pHrkmsakuseiymd, pHrkmrenrakuymd, pHrkmrenrakukaisuu, pHrkmbankcd, pHrkmshitencd
            , pHrkmyokinkbn, pHrkmkouzano, pHrkmzndktuukasyu, pHrkmsyorino1);
    }

    @Override
    public ExDBResults<BT_Gknyknmeisai> getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(String pKakutyoujobcd, String pHrkmsakuseiymd) {
        return keiriKaikeiDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(pKakutyoujobcd, pHrkmsakuseiymd);
    }

    @Override
    public List<BM_FBSoukinListKanri> getAllFBSoukinListKanri() {
        return keiriKaikeiDomManager.getAllFBSoukinListKanri();
    }

    @Override
    public BM_FBSoukinListKanri getFBSoukinListKanri(String pSyoricd, String pSyorisosikicd) {
        return keiriKaikeiDomManager.getFBSoukinListKanri(pSyoricd, pSyorisosikicd);
    }

    @Override
    public List<BT_FBSoukinData> getAllFBSoukinData() {
        return keiriKaikeiDomManager.getAllFBSoukinData();
    }

    @Override
    public BT_FBSoukinData getFBSoukinData(String pFbsoukindatasikibetukey) {
        return keiriKaikeiDomManager.getFBSoukinData(pFbsoukindatasikibetukey);
    }

    @Override
    public ExDBUpdatableResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {
        return keiriKaikeiDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(pKakutyoujobcd, pSyoriYmd, pGyoumucd);
    }

    @Override
    public ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn) {
        return keiriKaikeiDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(pKakutyoujobcd, pSyoriYmd, pShrhousiteikbn);
    }

    @Override
    public ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {
        return keiriKaikeiDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(pKakutyoujobcd, pSyoriYmd, pGyoumucd);
    }

    @Override
    public List<BT_GkFBSoukinData> getAllGkFBSoukinData() {
        return keiriKaikeiDomManager.getAllGkFBSoukinData();
    }

    @Override
    public BT_GkFBSoukinData getGkFBSoukinData(String pFbsoukindatasikibetukey) {
        return keiriKaikeiDomManager.getGkFBSoukinData(pFbsoukindatasikibetukey);
    }

    @Override
    public ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn, BizDate pDratekakuteiymd, C_Gkgyoumucd... pGkgyoumucd) {
        return keiriKaikeiDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(pKakutyoujobcd, pSyoriYmd, pShrhousiteikbn, pDratekakuteiymd, pGkgyoumucd);
    }

    @Override
    public ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {
        return keiriKaikeiDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(pKakutyoujobcd, pSyoriYmd, pGkgyoumucd);
    }

    @Override
    public ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {
        return keiriKaikeiDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(pKakutyoujobcd, pSyoriYmd, pGkgyoumucd);
    }

    @Override
    public ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BT_SikinIdouListSks> getAllSikinIdouListSks() {
        return keiriKaikeiDomManager.getAllSikinIdouListSks();
    }

    @Override
    public BT_SikinIdouListSks getSikinIdouListSks(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return keiriKaikeiDomManager.getSikinIdouListSks(pDensyskbn, pDenrenno, pEdano);
    }

    @Override
    public ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> getSokujiSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getSokujiSikinIdouListSkssBySyoriYmd(pSyoriYmd);
    }

    @Override
    public ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> getTyakkinSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getTyakkinSikinIdouListSkssBySyoriYmd(pSyoriYmd);
    }

    @Override
    public List<BT_OnlineGknyknmeisai> getAllOnlineGknyknmeisai() {
        return keiriKaikeiDomManager.getAllOnlineGknyknmeisai();
    }

    @Override
    public BT_OnlineGknyknmeisai getOnlineGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {
        return keiriKaikeiDomManager.getOnlineGknyknmeisai(pHrkmsakuseiymd, pHrkmrenrakuymd, pHrkmrenrakukaisuu, pHrkmbankcd, pHrkmshitencd
            , pHrkmyokinkbn, pHrkmkouzano, pHrkmzndktuukasyu, pHrkmsyorino1);
    }

    @Override
    public List<BT_HjybruikeigakuTeisei> getAllHjybruikeigakuTeisei() {
        return keiriKaikeiDomManager.getAllHjybruikeigakuTeisei();
    }

    @Override
    public BT_HjybruikeigakuTeisei  getHjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        return keiriKaikeiDomManager.getHjybruikeigakuTeisei(pHjybruigkteiseitantositucd, pKanjyoukmkcd);

    }

    @Override
    public List<BT_SikinIdouRireki> getAllSikinIdouRireki() {
        return keiriKaikeiDomManager.getAllSikinIdouRireki();
    }

    @Override
    public BT_SikinIdouRireki getSikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno) {
        return keiriKaikeiDomManager.getSikinIdouRireki(pSyoriYmd, pKeirisyorirenno);
    }

    @Override
    public List<BM_SegmentSikinidou> getAllSegmentSikinidou() {
        return keiriKaikeiDomManager.getAllSegmentSikinidou();
    }

    @Override
    public BM_SegmentSikinidou getSegmentSikinidou(C_Segcd  pSegcd) {
        return keiriKaikeiDomManager.getSegmentSikinidou(pSegcd);
    }

    @Override
    public List<BT_HijynNykSiknIdouLstSksGk> getAllHijynNykSiknIdouLstSksGk() {
        return keiriKaikeiDomManager.getAllHijynNykSiknIdouLstSksGk();
    }

    @Override
    public BT_HijynNykSiknIdouLstSksGk getHijynNykSiknIdouLstSksGk(BizDate pSyoriYmd, C_SikinidouPKbn pSikinidoupkbn, String pSyono, Integer pRenno) {
        return keiriKaikeiDomManager.getHijynNykSiknIdouLstSksGk(pSyoriYmd, pSikinidoupkbn, pSyono, pRenno);
    }


    @Override
    public List<BM_SikinIdouGroup> getAllSikinIdouGroup() {
        return keiriKaikeiDomManager.getAllSikinIdouGroup();
    }

    @Override
    public BM_SikinIdouGroup getSikinIdouGroup(C_Segcd pSegcd) {
        return keiriKaikeiDomManager.getSikinIdouGroup(pSegcd);
    }

    @Override
    public List<BT_YendthnkSikinIdouData> getAllYendthnkSikinIdouData() {
        return keiriKaikeiDomManager.getAllYendthnkSikinIdouData();
    }

    @Override
    public BT_YendthnkSikinIdouData getYendthnkSikinIdouData(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getYendthnkSikinIdouData(pSyono, pKeiriyendthnkkbn, pSyoriYmd);
    }

    @Override
    public List<BT_YendthnkSikinIdouListSks> getAllYendthnkSikinIdouListSks() {
        return keiriKaikeiDomManager.getAllYendthnkSikinIdouListSks();
    }

    @Override
    public BT_YendthnkSikinIdouListSks getYendthnkSikinIdouListSks(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {
        return keiriKaikeiDomManager.getYendthnkSikinIdouListSks(pSyono, pKeiriyendthnkkbn, pSyoriYmd);
    }


    @Override
    public List<BT_HijynNykSikinIdouListSks> getAllHijynNykSikinIdouListSks() {
        return keiriKaikeiDomManager.getAllHijynNykSikinIdouListSks();
    }

    @Override
    public BT_HijynNykSikinIdouListSks getHijynNykSikinIdouListSks(String pSyono, BizDateYM pSikinidoupjytym) {
        return keiriKaikeiDomManager.getHijynNykSikinIdouListSks(pSyono, pSikinidoupjytym);
    }

    @Override
    public List<BT_KbtKarikanjyou> getAllKbtKarikanjyou() {
        return keiriKaikeiDomManager.getAllKbtKarikanjyou();
    }

    @Override
    public BT_KbtKarikanjyou getKbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {
        return keiriKaikeiDomManager.getKbtKarikanjyou(pKbtkarikanjyouskbtkey);
    }

    @Override
    public List<BM_HutanpoBui> getAllHutanpoBui() {
        return sateiKetteiDomManager.getAllHutanpoBui();
    }

    @Override
    public BM_HutanpoBui getHutanpoBui(String pHtnpbuicd) {
        return sateiKetteiDomManager.getHutanpoBui(pHtnpbuicd);
    }

    @Override
    public List<BM_Syoubyou> getAllSyoubyou() {
        return sateiKetteiDomManager.getAllSyoubyou();
    }

    @Override
    public BM_Syoubyou getSyoubyou(String pSyoubyoucd) {
        return sateiKetteiDomManager.getSyoubyou(pSyoubyoucd);
    }

    @Override
    public List<BM_Syoubyou> getSyoubyousBySyoubyoucdSyoubyounm(String pSyoubyoucd, String pSyoubyounm) {
        return sateiKetteiDomManager.getSyoubyousBySyoubyoucdSyoubyounm(pSyoubyoucd, pSyoubyounm);
    }

    @Override
    public List<BM_Syokugyou> getAllSyokugyou() {
        return sateiKetteiDomManager.getAllSyokugyou();
    }

    @Override
    public BM_Syokugyou getSyokugyou(String pSyokugyoucd) {
        return sateiKetteiDomManager.getSyokugyou(pSyokugyoucd);
    }

    @Override
    public List<BM_Syokugyou> getSyokugyousBySyokugyoucdSyokugyounm(String pSyokugyoucd, String pSyokugyounm) {
        return sateiKetteiDomManager.getSyokugyousBySyokugyoucdSyokugyounm(pSyokugyoucd, pSyokugyounm);
    }

    @Override
    public List<BM_LincKaisyacd> getAllLincKaisyacd() {
        return sateiKetteiDomManager.getAllLincKaisyacd();
    }

    @Override
    public BM_LincKaisyacd getLincKaisyacd(String pLinckaisyacdnum) {
        return sateiKetteiDomManager.getLincKaisyacd(pLinckaisyacdnum);
    }

    @Override
    public List<BM_Channel> getAllChannel() {
        return dairitenDomManager.getAllChannel();
    }

    @Override
    public BM_Channel getChannel(C_Channelcd pChannelcd) {
        return dairitenDomManager.getChannel(pChannelcd);
    }

    @Override
    public List<BM_Dairiten> getAllDairiten() {
        return dairitenDomManager.getAllDairiten();
    }

    @Override
    public BM_Dairiten getDairiten(String pDrtencd) {
        return dairitenDomManager.getDairiten(pDrtencd);
    }

    @Override
    public List<BM_Dairiten> getDairitensByOyadrtencdDrtenjimcd(String pOyadrtencd, String pDrtenjimcd) {
        return dairitenDomManager.getDairitensByOyadrtencdDrtenjimcd(pOyadrtencd, pDrtenjimcd);
    }

    @Override
    public List<BM_Dairiten> getDairitensByKinyuucdKinyuusitencd(String pKinyuucd, String pKinyuusitencd) {
        return dairitenDomManager.getDairitensByKinyuucdKinyuusitencd(pKinyuucd, pKinyuusitencd);
    }

    @Override
    public String getDairitenMinDrtencdByKinyuucdDrtenjimcd(String pKinyuucd, String pDrtenjimcd) {
        return dairitenDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd(pKinyuucd, pDrtenjimcd);
    }

    @Override
    public List<BM_Dairiten> getDairitensByDrtencds(String[] pDrtencd) {
        return dairitenDomManager.getDairitensByDrtencds(pDrtencd);
    }

    @Override
    public List<BM_Dairiten> getDairitensByKinyuucd(String pKinyuucd) {
        return dairitenDomManager.getDairitensByKinyuucd(pKinyuucd);
    }

    @Override
    public List<BM_DairitenSyougou> getAllDairitenSyougou() {
        return dairitenDomManager.getAllDairitenSyougou();
    }

    @Override
    public BM_DairitenSyougou getDairitenSyougou(String pDrtencd) {
        return dairitenDomManager.getDairitenSyougou(pDrtencd);
    }

    @Override
    public List<BM_Bosyuunin> getAllBosyuunin() {
        return dairitenDomManager.getAllBosyuunin();
    }

    @Override
    public BM_Bosyuunin getBosyuunin(String pBosyuucd) {
        return dairitenDomManager.getBosyuunin(pBosyuucd);
    }

    @Override
    public List<BM_Bosyuunin> getBosyuuninByBosyuutrkno(String pBosyuutrkno) {
        return dairitenDomManager.getBosyuuninByBosyuutrkno(pBosyuutrkno);
    }

    @Override
    public List<BM_Tyouhyourenrakusaki> getAllTyouhyourenrakusaki() {
        return dairitenDomManager.getAllTyouhyourenrakusaki();
    }

    @Override
    public BM_Tyouhyourenrakusaki getTyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        return dairitenDomManager.getTyouhyourenrakusaki(pTyhyrenrakusikibetukbn);
    }

    @Override
    public List<BM_Kouin> getAllKouin() {
        return dairitenDomManager.getAllKouin();
    }

    @Override
    public BM_Kouin getKouin(String pKinyuucd, String pKouincd) {
        return dairitenDomManager.getKouin(pKinyuucd, pKouincd);
    }

    @Override
    public List<BM_Kouin> getKouinsBybosyuucd(String pBosyuucd) {
        return dairitenDomManager.getKouinsBybosyuucd(pBosyuucd);
    }

    @Override
    public List<BM_Kouin> getKouinsByKouincds(String pKinyuucd, String[] pKouincd) {
        return dairitenDomManager.getKouinsByKouincds(pKinyuucd, pKouincd);
    }

    @Override
    public List<BT_MdhnBank> getAllMdhnBank() {
        return dairitenDomManager.getAllMdhnBank();
    }

    @Override
    public BT_MdhnBank getMdhnBank(String pDrtencd) {
        return dairitenDomManager.getMdhnBank(pDrtencd);
    }

    @Override
    public List<BT_HknBosyuRiyouInfo> getAllHknBosyuRiyouInfo() {
        return dairitenDomManager.getAllHknBosyuRiyouInfo();
    }

    @Override
    public BT_HknBosyuRiyouInfo getHknBosyuRiyouInfo(String pDrtencd) {
        return dairitenDomManager.getHknBosyuRiyouInfo(pDrtencd);
    }

    @Override
    public List<BT_BuntanInfo> getAllBuntanInfo() {
        return dairitenDomManager.getAllBuntanInfo();
    }

    @Override
    public BT_BuntanInfo getBuntanInfo(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pTesuuryoubuntanstartym) {
        return dairitenDomManager.getBuntanInfo(pDrtencd, pDairitensyouhincd, pTesuuryoubuntandrtencd, pTesuuryoubuntanstartym);
    }

    @Override
    public List<BT_BuntanInfo> getBuntanInfosByPK(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pSyutokukijyunym) {
        return dairitenDomManager.getBuntanInfosByPK(pDrtencd, pDairitensyouhincd, pTesuuryoubuntandrtencd, pSyutokukijyunym);
    }

    @Override
    public List<BT_BuntanInfo> getBuntanInfosAitedrtenSiteinasi(String pDrtencd,String pDairitensyouhincd, BizDateYM pSyutokukijyunym) {
        return dairitenDomManager.getBuntanInfosAitedrtenSiteinasi(pDrtencd, pDairitensyouhincd, pSyutokukijyunym);
    }

    @Override
    public List<BT_DairitenItakuSyouhn> getAllDairitenItakuSyouhn() {
        return dairitenDomManager.getAllDairitenItakuSyouhn();
    }

    @Override
    public BT_DairitenItakuSyouhn getDairitenItakuSyouhn(String pDrtencd, String pDrtsyouhinsikibetukbnstr, String pDrthrkhouhoukbn, String pDrtplannmkbn, BizDate pItakuhknhnbkaisiymd) {
        return dairitenDomManager.getDairitenItakuSyouhn(pDrtencd, pDrtsyouhinsikibetukbnstr, pDrthrkhouhoukbn, pDrtplannmkbn, pItakuhknhnbkaisiymd);
    }

    @Override
    public Long getDairitenCountByDrtencdDrtennm(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {
        return dairitenDomManager.getDairitenCountByDrtencdDrtennm(pDrtencd, pDrtennmkn, pDrtennmkj1, pDrtennmkj2);
    }

    @Override
    public List<BM_Dairiten> getDairitenByDrtencdDrtennmOrderByDrtencdAsc(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {
        return dairitenDomManager.getDairitenByDrtencdDrtennmOrderByDrtencdAsc(pDrtencd, pDrtennmkn, pDrtennmkj1, pDrtennmkj2);
    }

    @Override
    public List<BM_SyoruiKtg> getAllSyoruiKtg() {
        return syoruiDomManager.getAllSyoruiKtg();
    }

    @Override
    public BM_SyoruiKtg getSyoruiKtg(C_SyoruiCdKbn pSyoruiCd, String pKtgsyoruicd) {
        return syoruiDomManager.getSyoruiKtg(pSyoruiCd, pKtgsyoruicd);
    }

    @Override
    public List<BT_TyouhyouOutputKengen> getAllTyouhyouOutputKengen() {
        return syoruiDomManager.getAllTyouhyouOutputKengen();
    }

    @Override
    public BT_TyouhyouOutputKengen getTyouhyouOutputKengen(String pRoleCd, C_SyoruiCdKbn pSyoruiCd) {
        return syoruiDomManager.getTyouhyouOutputKengen(pRoleCd, pSyoruiCd);
    }

    @Override
    public List<BM_TorikomiSyoruiHukaInfo> getAllTorikomiSyoruiHukaInfo() {
        return syoruiDomManager.getAllTorikomiSyoruiHukaInfo();
    }

    @Override
    public BM_TorikomiSyoruiHukaInfo getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        return syoruiDomManager.getTorikomiSyoruiHukaInfo(pSyoruiCd);
    }

    @Override
    public ZtrhyousiInfoBySyoruiCdBean getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        return syoruiDomManager.getZtrhyousiInfoBySyoruiCd(pSyoruiCd);
    }

    @Override
    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn, C_UmuKbn pQrsealumukbn, C_SkeijimuKbn... pSkeijimukbn) {
        return syoruiDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(pSubSystemId, pSyoruitorikomihoukbn, pQrsealumukbn, pSkeijimukbn);
    }

    @Override
    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn) {
        return syoruiDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(pSubSystemId, pSyoruitorikomihoukbn);
    }

    @Override
    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosByImagegazoukaKbn(C_ImagegazoukaKbn pImagegazoukakbn) {
        return syoruiDomManager.getTorikomiSyoruiHukaInfosByImagegazoukaKbn(pImagegazoukakbn);
    }

    @Override
    public List<BM_SyoruiZokuseiHukaInfo> getAllSyoruiZokuseiHukaInfo() {
        return syoruiDomManager.getAllSyoruiZokuseiHukaInfo();
    }

    @Override
    public BM_SyoruiZokuseiHukaInfo getSyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        return syoruiDomManager.getSyoruiZokuseiHukaInfo(pSyoruiCd);
    }

    @Override
    public List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(String[] pRoleCd, C_KahiKbn pIkkatuoutputkahikbn) {
        return syoruiDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(pRoleCd, pIkkatuoutputkahikbn);
    }

    @Override
    public List<SyoruiZokuseiMasterInfoBean> getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(String[] pRoleCd, String[] pSubSystemId) {
        return syoruiDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(pRoleCd, pSubSystemId);
    }

    @Override
    public List<BM_SyoruiZokuseiHukaInfo> getSyoruiZokuseiHukaInfosBySubSystemIds(String[] pSubSystemId) {
        return syoruiDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(pSubSystemId);
    }

    @Override
    public List<BM_Syonokanri> getAllSyonokanri() {
        return etcDomManager.getAllSyonokanri();
    }

    @Override
    public BM_Syonokanri getSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno) {
        return etcDomManager.getSyonokanri(pSeirekinen2keta, pBosyuusosikicd, pSyonorenno);
    }

    @Override
    public List<BM_Syonokanri> getSyonokanrisBySyono(String pSyono) {
        return etcDomManager.getSyonokanrisBySyono(pSyono);
    }

    @Override
    public String getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(String pSeirekinen2keta) {
        return etcDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(pSeirekinen2keta);
    }

    @Override
    public String getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(String pSeirekinen2keta, BizDate pSaibanymd) {
        return etcDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(pSeirekinen2keta, pSaibanymd);
    }

    @Override
    public Integer getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd) {
        return etcDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta, pBosyuusosikicd);
    }

    @Override
    public List<BM_Simekiribi> getAllSimekiribi() {
        return etcDomManager.getAllSimekiribi();
    }

    @Override
    public BM_Simekiribi getSimekiribi(BizDateYM pBosyuuym) {
        return etcDomManager.getSimekiribi(pBosyuuym);
    }

    @Override
    public List<BT_HengakuEpsilonDenpyo> getAllHengakuEpsilonDenpyo() {
        return etcDomManager.getAllHengakuEpsilonDenpyo();
    }

    @Override
    public BT_HengakuEpsilonDenpyo getHengakuEpsilonDenpyo(C_HengakuSyuruiKbn pHengakusyuruikbn, C_UnitFundKbn pUnitfundkbn, C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn
        , String pKacd, BizDate pDenymd, C_DenpyouKbn pDenpyoukbn, C_TaisyakuKbn pTaisyakukbn, String pKamokucd
        , BizDate pSyoriYmd) {
        return etcDomManager.getHengakuEpsilonDenpyo(pHengakusyuruikbn, pUnitfundkbn, pTkbtkanjyouunitfundkbn
            , pKacd, pDenymd, pDenpyoukbn, pTaisyakukbn, pKamokucd
            , pSyoriYmd);
    }

    @Override
    public List<BT_KinouHukaInfo> getAllKinouHukaInfo() {
        return etcDomManager.getAllKinouHukaInfo();
    }

    @Override
    public BT_KinouHukaInfo getKinouHukaInfo(String pKinouId) {
        return etcDomManager.getKinouHukaInfo(pKinouId);
    }

    @Override
    public List<BT_WariateHukaInfo> getAllWariateHukaInfo() {
        return etcDomManager.getAllWariateHukaInfo();
    }

    @Override
    public BT_WariateHukaInfo getWariateHukaInfo(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid,  String  pUserId) {
        return etcDomManager.getWariateHukaInfo(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukatskid, pUserId);
    }

    @Override
    public List<BT_WariateHukaInfo> getWariateHukaInfosByPKWithoutUserId(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid) {
        return etcDomManager.getWariateHukaInfosByPKWithoutUserId(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukatskid);
    }

    @Override
    public List<BT_WariateHukaInfo> getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukakaijyotskid) {
        return etcDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukakaijyotskid);
    }

    @Override
    public List<BT_LastSyoriYMDKanri> getAllLastSyoriYMDKanri() {
        return etcDomManager.getAllLastSyoriYMDKanri();
    }

    @Override
    public BT_LastSyoriYMDKanri getLastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        return etcDomManager.getLastSyoriYMDKanri(pLastsyoriymdkanrikbn);
    }

    @Override
    public List<BM_Address> getAllAddress() {
        return etcDomManager.getAllAddress();
    }

    @Override
    public BM_Address getAddress(String pPostalCd, String pKihontikucdsimo1) {
        return etcDomManager.getAddress(pPostalCd, pKihontikucdsimo1);
    }

    @Override
    public Long getAddressDistinctPostAdrkjAdrknbkarisCountByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj) {
        return etcDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems(pPostalCd, pKihontikucdsyoumetukbn, pTodouhukencd, pAdrkn
            , pAdrkj);
    }

    @Override
    public List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> getAddressDistinctPostAdrkjAdrknbkarisByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj) {
        return etcDomManager.getAddressDistinctPostAdrkjAdrknbkarisByItems(pPostalCd, pKihontikucdsyoumetukbn, pTodouhukencd, pAdrkn
            , pAdrkj);
    }

    @Override
    public List<String> getAddressDistinctAdrknblankarisByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {
        return etcDomManager.getAddressDistinctAdrknblankarisByPostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    @Override
    public C_TodouhukenKbn getAddressMinTodouhukencdByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {
        return etcDomManager.getAddressMinTodouhukencdByPostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    @Override
    public List<AddressDistinctItemsBypostalCdBean> getAddressDistinctItemsBypostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {
        return etcDomManager.getAddressDistinctItemsBypostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getAllGyoumuKouteiInfo() {
        return etcDomManager.getAllGyoumuKouteiInfo();
    }

    @Override
    public BT_GyoumuKouteiInfo getGyoumuKouteiInfo(String pKouteikanriid) {
        return etcDomManager.getGyoumuKouteiInfo(pKouteikanriid);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {
        return etcDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(pSyukouteikanriid, pSyukouteijimutetuzukicd);
    }

    @Override
    public List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {
        return etcDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(pSyukouteikanriid, pSyukouteijimutetuzukicd);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySkno(String pSkno) {
        return etcDomManager.getGyoumuKouteiInfosBySkno(pSkno);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByMosno(String pMosno) {
        return etcDomManager.getGyoumuKouteiInfosByMosno(pMosno);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(String pJimutetuzukicd, String pSyono, String pSkno) {
        return etcDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(pJimutetuzukicd, pSyono, pSkno);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriids(String[] pSyukouteikanriid) {
        return etcDomManager.getGyoumuKouteiInfosBySyukouteikanriids(pSyukouteikanriid);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriid(String pSyukouteikanriid) {
        return etcDomManager.getGyoumuKouteiInfosBySyukouteikanriid(pSyukouteikanriid);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(String pJimutetuzukicd, String pSyukouteikanriid) {
        return etcDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(pJimutetuzukicd, pSyukouteikanriid);
    }

    @Override
    public List<AS_Kinou> getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn pTjttrkskahi, String pSubSystemId) {
        return etcDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(pTjttrkskahi, pSubSystemId);
    }

    @Override
    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyonoSkno(String pSyono, String pSkno) {
        return etcDomManager.getGyoumuKouteiInfosBySyonoSkno(pSyono, pSkno);
    }

    @Override
    public List<BM_PalSyoumetujiyuu> getAllPalSyoumetujiyuu() {
        return etcDomManager.getAllPalSyoumetujiyuu();
    }

    @Override
    public BM_PalSyoumetujiyuu getPalSyoumetujiyuu(String pPalsyoumetucd, C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        return etcDomManager.getPalSyoumetujiyuu(pPalsyoumetucd, pBetukutikeiyakukbn);
    }

    @Override
    public List<BM_TantouCd> getAllTantouCd() {
        return etcDomManager.getAllTantouCd();
    }

    @Override
    public BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd) {
        return etcDomManager.getTantouCd(pTantocd);
    }

    @Override
    public List<BM_Syoritanto> getAllSyoritanto() {
        return etcDomManager.getAllSyoritanto();
    }

    @Override
    public BM_Syoritanto getSyoritanto(String pSyoricd) {
        return etcDomManager.getSyoritanto(pSyoricd);
    }

    @Override
    public List<BM_SosikiMadoguti> getAllSosikiMadoguti() {
        return etcDomManager.getAllSosikiMadoguti();
    }

    @Override
    public BM_SosikiMadoguti getSosikiMadoguti(String pSskmdsosikicd) {
        return etcDomManager.getSosikiMadoguti(pSskmdsosikicd);
    }

    @Override
    public List<BM_WariateHukaInfoKanri> getAllWariateHukaInfoKanri() {
        return etcDomManager.getAllWariateHukaInfoKanri();
    }

    @Override
    public BM_WariateHukaInfoKanri getWariateHukaInfoKanri(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, Integer pRenno) {
        return etcDomManager.getWariateHukaInfoKanri(pSubSystemId, pJimutetuzukicd, pCurrenttskid, pRenno);
    }

    @Override
    public List<BM_WariateHukaInfoKanri> getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, String pNexttskid) {
        return etcDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(pSubSystemId, pJimutetuzukicd, pCurrenttskid, pNexttskid);
    }

    @Override
    public List<BT_WariateHukaInfo> getWariateHukaInfosBySubSystemIdUserId(String pSubSystemId, String pUserId) {
        return etcDomManager.getWariateHukaInfosBySubSystemIdUserId(pSubSystemId, pUserId);
    }

    @Override
    public List<AT_TyouhyouKensaku> getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, String pSubSystemId, BizDate pSyoriYmd, Integer pOutCount) {
        return etcDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(pSyoruiCd, pSubSystemId, pSyoriYmd, pOutCount);
    }

    @Override
    public List<SyoruiZokuseiTyouhyouInfoBean> getSyoruiZokuseiTyouhyouInfo(String pSubSystemId, BizDate pSyoriYmd, String[] pRoleCd, C_SyoruiCdKbn pSyoruiCd) {
        return etcDomManager.getSyoruiZokuseiTyouhyouInfo(pSubSystemId, pSyoriYmd, pRoleCd, pSyoruiCd);
    }

    @Override
    public List<AT_TyouhyouKensaku> getTyouhyouKensakusByTyouhyouJoinKey(String pTyouhyouJoinKey) {
        return etcDomManager.getTyouhyouKensakusByTyouhyouJoinKey(pTyouhyouJoinKey);
    }

    @Override
    public Long getTyouhyouKensakuCountByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto) {
        return etcDomManager.getTyouhyouKensakuCountByKensakuInfo(pSubSystemId, pSyoruiCd, pKensakuKey1, pKensakuKey2, pKensakuKey3
            , pKensakuKey4, pKensakuKey5, pTyouhyouymdfrom, pTyouhyouymdto);
    }

    @Override
    public List<AT_TyouhyouKensaku> getTyouhyouKensakusByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto) {
        return etcDomManager.getTyouhyouKensakusByKensakuInfo(pSubSystemId, pSyoruiCd, pKensakuKey1, pKensakuKey2, pKensakuKey3
            , pKensakuKey4, pKensakuKey5, pTyouhyouymdfrom, pTyouhyouymdto);
    }

    @Override
    public List<UsersByKinouIdKinouModeIdUserIdBean> getUsersByKinouIdKinouModeIdUserId(String pKinouId, String pKinouModeId, String pUserId) {
        return etcDomManager.getUsersByKinouIdKinouModeIdUserId(pKinouId, pKinouModeId, pUserId);
    }

    @Override
    public List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(String pKinouId, String pKinouModeId, String pUserId, String pFlowId, String pNodeId) {
        return etcDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(pKinouId, pKinouModeId, pUserId, pFlowId, pNodeId);
    }

    @Override
    public ExDBUpdatableResults<AM_User> getUsersByTables() {
        return etcDomManager.getUsersByTables();
    }

    @Override
    public ExDBResults<AT_AccessLog> getAccessLogsByTimeStamp(Long pSyoriYmdFrom, Long pSyoriYmdTo) {
        return etcDomManager.getAccessLogsByTimeStamp(pSyoriYmdFrom, pSyoriYmdTo);
    }

    @Override
    public ExDBResults<AT_AccessLog> getAccessLogsBySyoriYmdFromSyoriYmdTo(Long pSyoriYmdFrom, Long pSyoriYmdTo) {
        return etcDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(pSyoriYmdFrom, pSyoriYmdTo);
    }

    @Override
    public List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        return etcDomManager.getFileHozonInfosByFileSyuruiCd(pFileSyuruiCd);
    }

    @Override
    public List<BM_Address> getAddressesByPostalCd(String pPostalCd) {
        return etcDomManager.getAddressesByPostalCd(pPostalCd);
    }

    @Override
    public List<AS_SubSystem> getSubSystemsBySubSystemIds(String[] pSubSystemId) {
        return etcDomManager.getSubSystemsBySubSystemIds(pSubSystemId);
    }

    @Override
    public List<BT_TuutirirekiMeisaiHokan> getAllTuutirirekiMeisaiHokan() {
        return etcDomManager.getAllTuutirirekiMeisaiHokan();
    }

    @Override
    public BT_TuutirirekiMeisaiHokan getTuutirirekiMeisaiHokan(String pTuutirirekirenno) {
        return etcDomManager.getTuutirirekiMeisaiHokan(pTuutirirekirenno);
    }

    @Override
    public ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM pTuutisakuseiym) {
        return etcDomManager.getTuutirirekiMeisaiHokansByTuutisakuseiymd2(pTuutisakuseiym);
    }

    @Override
    public List<BM_SeisanDShrymd> getAllSeisanDShrymd() {
        return etcDomManager.getAllSeisanDShrymd();
    }

    @Override
    public BM_SeisanDShrymd getSeisanDShrymd(BizDateY pSyorinendo) {
        return etcDomManager.getSeisanDShrymd(pSyorinendo);
    }

    @Override
    public List<BT_SystemRenkei> getAllSystemRenkei() {
        return systemRenkeiDomManager.getAllSystemRenkei();
    }

    @Override
    public BT_SystemRenkei getSystemRenkei(String pInterfaceid) {
        return systemRenkeiDomManager.getSystemRenkei(pInterfaceid);
    }

    @Override
    public List<BT_YoukyuuNoKanri> getAllYoukyuuNoKanri() {
        return nayoseDomManager.getAllYoukyuuNoKanri();
    }

    @Override
    public BT_YoukyuuNoKanri getYoukyuuNoKanri(String pYoukyuuno) {
        return nayoseDomManager.getYoukyuuNoKanri(pYoukyuuno);
    }

    @Override
    public List<BM_MqBatchSosiki> getAllMqBatchSosiki() {
        return nayoseDomManager.getAllMqBatchSosiki();
    }

    @Override
    public BM_MqBatchSosiki getMqBatchSosiki(String pKinouId) {
        return nayoseDomManager.getMqBatchSosiki(pKinouId);
    }

    @Override
    public List<BT_TjtIdouNyKh> getAllTjtIdouNyKh() {
        return nayoseDomManager.getAllTjtIdouNyKh();
    }

    @Override
    public BT_TjtIdouNyKh getTjtIdouNyKh(String pSyono, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNyKh(pSyono, pRenno3keta);
    }

    @Override
    public ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhs() {
        return nayoseDomManager.getTjtIdouNyKhs();
    }

    @Override
    public ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {
        return nayoseDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(pKakutyoujobcd);
    }

    @Override
    public List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyono(String pSyono) {
        return nayoseDomManager.getTjtIdouNyKhsBySyono(pSyono);
    }

    @Override
    public Integer getTjtIdouNyKhMaxRenno3ketaBySyono(String pSyono) {
        return nayoseDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono(pSyono);
    }

    @Override
    public List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyonoYoukyuuno(String pSyono, String pYoukyuuno) {
        return nayoseDomManager.getTjtIdouNyKhsBySyonoYoukyuuno(pSyono, pYoukyuuno);
    }

    @Override
    public List<BT_TjtIdouNySk> getAllTjtIdouNySk() {
        return nayoseDomManager.getAllTjtIdouNySk();
    }

    @Override
    public ExDBResults<BT_TjtIdouNySk> getTjtIdouNySks() {
        return nayoseDomManager.getTjtIdouNySks();
    }

    @Override
    public ExDBResults<BT_TjtIdouNySk> getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {
        return nayoseDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(pKakutyoujobcd);
    }

    @Override
    public List<BT_TjtIdouNySk> getTjtIdouNySksByMosno(String pMosno) {
        return nayoseDomManager.getTjtIdouNySksByMosno(pMosno);
    }

    @Override
    public BT_TjtIdouNySk getTjtIdouNySk(String pMosno, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNySk(pMosno, pRenno3keta);
    }

    @Override
    public Integer getTjtIdouNySkMaxRenno3ketaByMosno(String pMosno) {
        return nayoseDomManager.getTjtIdouNySkMaxRenno3ketaByMosno(pMosno);
    }

    @Override
    public List<BT_TjtIdouNySk> getTjtIdouNySksByMosnoYoukyuuno(String pMosno, String pYoukyuuno) {
        return nayoseDomManager.getTjtIdouNySksByMosnoYoukyuuno(pMosno, pYoukyuuno);
    }

    @Override
    public List<BT_TjtIdouNyNk> getAllTjtIdouNyNk() {
        return nayoseDomManager.getAllTjtIdouNyNk();
    }

    @Override
    public List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysyno(String pNksysyno) {
        return nayoseDomManager.getTjtIdouNyNksByNksysyno(pNksysyno);
    }

    @Override
    public ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNks() {
        return nayoseDomManager.getTjtIdouNyNks();
    }

    @Override
    public ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {
        return nayoseDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta(pKakutyoujobcd);
    }

    @Override
    public BT_TjtIdouNyNk getTjtIdouNyNk(String pNksysyno, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNyNk(pNksysyno, pRenno3keta);
    }

    @Override
    public Integer getTjtIdouNyNkMaxRenno3ketaByNksysyno(String pNksysyno) {
        return nayoseDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno(pNksysyno);
    }

    @Override
    public List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysynoYoukyuuno(String pNksysyno, String pYoukyuuno) {
        return nayoseDomManager.getTjtIdouNyNksByNksysynoYoukyuuno(pNksysyno, pYoukyuuno);
    }

    @Override
    public List<BT_TjtIdouNyKhItjhzn> getAllTjtIdouNyKhItjhzn() {
        return nayoseDomManager.getAllTjtIdouNyKhItjhzn();
    }

    @Override
    public BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNyKhItjhzn(pSyono, pRenno3keta);
    }

    @Override
    public List<BT_TjtIdouNySkItjhzn> getAllTjtIdouNySkItjhzn() {
        return nayoseDomManager.getAllTjtIdouNySkItjhzn();
    }

    @Override
    public BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn(String pMosno, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNySkItjhzn(pMosno, pRenno3keta);
    }

    @Override
    public List<BT_TjtIdouNyNkItjhzn> getAllTjtIdouNyNkItjhzn() {
        return nayoseDomManager.getAllTjtIdouNyNkItjhzn();
    }

    @Override
    public BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn(String pNksysyno, Integer pRenno3keta) {
        return nayoseDomManager.getTjtIdouNyNkItjhzn(pNksysyno, pRenno3keta);
    }

    @Override
    public List<BT_NenkinInfoRendou> getAllNenkinInfoRendou() {
        return nenkinInfoRendouManager.getAllNenkinInfoRendou();
    }

    @Override
    public BT_NenkinInfoRendou getNenkinInfoRendou(BizDate pSyoriYmd, String pSyono, Integer pRenno) {
        return nenkinInfoRendouManager.getNenkinInfoRendou(pSyoriYmd, pSyono, pRenno);
    }

    @Override
    public ExDBUpdatableResults<BT_NenkinInfoRendou> getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return nenkinInfoRendouManager.getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BT_SkipKey> getAllSkipKey() {
        return maintenanceBatchRecoveryDomManager.getAllSkipKey();
    }

    @Override
    public BT_SkipKey getSkipKey(String pRecoverysikibetukey) {
        return maintenanceBatchRecoveryDomManager.getSkipKey(pRecoverysikibetukey);
    }

    @Override
    public List<BM_RecoveryFilter> getAllRecoveryFilter() {
        return maintenanceBatchRecoveryDomManager.getAllRecoveryFilter();
    }

    @Override
    public BM_RecoveryFilter getRecoveryFilter(String pRecoveryfilterid) {
        return maintenanceBatchRecoveryDomManager.getRecoveryFilter(pRecoveryfilterid);
    }

    @Override
    public List<BW_IdCardWk> getAllIdCardWk() {
        return userKengenInfoWkDomManager.getAllIdCardWk();
    }

    @Override
    public BW_IdCardWk getIdCardWk(String pIdkbn, String pIdcd) {
        return userKengenInfoWkDomManager.getIdCardWk(pIdkbn, pIdcd);
    }

    @Override
    public ExDBResults<BW_IdCardWk>  getIdCardWks() {
        return userKengenInfoWkDomManager.getIdCardWks();
    }

    @Override
    public Long getIdCardWkCount() {
        return userKengenInfoWkDomManager.getIdCardWkCount();
    }

    @Override
    public ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWk() {
        return userKengenInfoWkDomManager.getIdCardWksByNotExistsUserWk();
    }

    @Override
    public ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWkUserNm() {
        return userKengenInfoWkDomManager.getIdCardWksByNotExistsUserWkUserNm();
    }

    @Override
    public ExDBResults<BW_IdCardWk> getIdCardWksSyoukaiUserByNotExistsUserWk() {
        return userKengenInfoWkDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk();
    }

    @Override
    public List<BW_UserIdKanrenWk> getAllUserIdKanrenWk() {
        return userKengenInfoWkDomManager.getAllUserIdKanrenWk();
    }

    @Override
    public BW_UserIdKanrenWk getUserIdKanrenWk(String pIdkbn, String pIdcd) {
        return userKengenInfoWkDomManager.getUserIdKanrenWk(pIdkbn, pIdcd);
    }

    @Override
    public List<BW_IdCardYakusyokuWk> getAllIdCardYakusyokuWk() {
        return userKengenInfoWkDomManager.getAllIdCardYakusyokuWk();
    }

    @Override
    public BW_IdCardYakusyokuWk getIdCardYakusyokuWk(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {
        return userKengenInfoWkDomManager.getIdCardYakusyokuWk(pIdkbn, pIdcd, pYakusyokuhatureiymd, pYakusyokuhatureino);
    }

    @Override
    public List<BT_UserKengenHaneiSskInfo> getAllUserKengenHaneiSskInfo() {
        return userKengenInfoWkDomManager.getAllUserKengenHaneiSskInfo();
    }

    @Override
    public BT_UserKengenHaneiSskInfo getUserKengenHaneiSskInfo(String pSosikicdkami3) {
        return userKengenInfoWkDomManager.getUserKengenHaneiSskInfo(pSosikicdkami3);
    }

    @Override
    public List<BW_UserWk> getAllUserWk() {
        return userKengenInfoWkDomManager.getAllUserWk();
    }

    @Override
    public BW_UserWk getUserWk(String pUserId) {
        return userKengenInfoWkDomManager.getUserWk(pUserId);
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSisyaUserRoleWk(String[] pSisyaReigaiSosikiCdList, String[] pSisyayouRoleCdList) {
        return userKengenInfoWkDomManager.getUserWksNotExistsSisyaUserRoleWk(pSisyaReigaiSosikiCdList, pSisyayouRoleCdList);
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSyoukaiUserRoleWk(String[] pHnsaSknmSsyRoruCdList) {
        return userKengenInfoWkDomManager.getUserWksNotExistsSyoukaiUserRoleWk(pHnsaSknmSsyRoruCdList);
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserIdKanrenWk() {
        return userKengenInfoWkDomManager.getUserWksNotExistsUserIdKanrenWk();
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaReigaiSosikiCdList) {
        return userKengenInfoWkDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(pSisyaReigaiSosikiCdList);
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList) {
        return userKengenInfoWkDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(pSisyaAtukaiSosikiCdList,pSisyaReigaiSosikiCdList);
    }

    @Override
    public List<BW_UserRoleWk> getAllUserRoleWk() {
        return userKengenInfoWkDomManager.getAllUserRoleWk();
    }

    @Override
    public BW_UserRoleWk getUserRoleWk(String pUserId, String pRoleCd) {
        return userKengenInfoWkDomManager.getUserRoleWk(pUserId, pRoleCd);
    }

    @Override
    public List<BW_UserRoleWk> getUserRoleWksByUserId(String pUserId) {
        return userKengenInfoWkDomManager.getUserRoleWksByUserId(pUserId);
    }

    @Override
    public ExDBUpdatableResults<BW_IdCardWk> getIdCardWksBySyozokusosikicdKeta3() {
        return userKengenInfoWkDomManager.getIdCardWksBySyozokusosikicdKeta3();
    }

    @Override
    public ExDBUpdatableResults<BW_UserWk> getUserWksBySyozokusosikicdKeta3() {
        return userKengenInfoWkDomManager.getUserWksBySyozokusosikicdKeta3();
    }

    @Override
    public List<BV_SiharaiTyousyo> getAllSiharaiTyousyo() {
        return viewDomManager.getAllSiharaiTyousyo();
    }

    @Override
    public BV_SiharaiTyousyo getSiharaiTyousyo(String pSubSystemId, String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        return viewDomManager.getSiharaiTyousyo(pSubSystemId, pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    @Override
    public ExDBResults<BV_SiharaiTyousyo> getSiharaiTyousyosByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return viewDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<BV_HjybruikeigakuData> getAllHjybruikeigakuData() {
        return viewDomManager.getAllHjybruikeigakuData();
    }

    @Override
    public BV_HjybruikeigakuData getHjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        return viewDomManager.getHjybruikeigakuData(pHjybtantositucd, pKanjyoukmkcd);
    }

    @Override
    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax() {
        return kawaseRateDomManager.getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();
    }

    @Override
    public List<BM_TestSyonokanri> getAllTestSyonokanri() {
        return honbanDataTysytManager.getAllTestSyonokanri();
    }

    @Override
    public BM_TestSyonokanri getTestSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno) {
        return honbanDataTysytManager.getTestSyonokanri(pSeirekinen2keta, pBosyuusosikicd, pSyonorenno);
    }

    @Override
    public List<BT_TestKykData> getAllTestKykData() {
        return honbanDataTysytManager.getAllTestKykData();
    }

    @Override
    public BT_TestKykData getTestKykData(String pUniqueId) {
        return honbanDataTysytManager.getTestKykData(pUniqueId);
    }

    @Override
    public List<BT_KijituTuriHnbnKnsouTut> getAllKijituTuriHnbnKnsouTut() {
        return systemHonbanKsDomManager.getAllKijituTuriHnbnKnsouTut();
    }

    @Override
    public BT_KijituTuriHnbnKnsouTut getKijituTuriHnbnKnsouTut(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno) {
        return systemHonbanKsDomManager.getKijituTuriHnbnKnsouTut(pSyoriYmd, pSubSystemId, pTysytno);
    }

    @Override
    public List<BT_KijituTuriHnbnKnsouTutJk> getAllKijituTuriHnbnKnsouTutJk() {
        return systemHonbanKsDomManager.getAllKijituTuriHnbnKnsouTutJk();
    }

    @Override
    public BT_KijituTuriHnbnKnsouTutJk getKijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {
        return systemHonbanKsDomManager.getKijituTuriHnbnKnsouTutJk(pSubSystemId, pTysytno);
    }

    @Override
    public List<BT_KijituTouraiHonbanKensyou> getAllKijituTouraiHonbanKensyou() {
        return systemHonbanKsDomManager.getAllKijituTouraiHonbanKensyou();
    }

    @Override
    public BT_KijituTouraiHonbanKensyou getKijituTouraiHonbanKensyou(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno, String pDatakanrino) {
        return systemHonbanKsDomManager.getKijituTouraiHonbanKensyou(pSyoriYmd, pSubSystemId, pTysytno, pDatakanrino);
    }
}
