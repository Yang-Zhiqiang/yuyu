package yuyu.def.biz.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.base.manager.DomManager;
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
 * 業務共通 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface BizDomManager extends DomManager {
    List<BM_SyouhnZokusei> getAllSyouhnZokusei();

    BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno);

    BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdHyoujiymd(String pSyouhncd, BizDate pHiduke);

    SyouhnZokuseiHaitoukbnSeg1cdByPKBean getSyouhnZokuseiHaitoukbnSeg1cdByPK(String pSyouhncd, Integer pSyouhnsdno);

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyutkkbnHyoujiymd(C_SyutkKbn pSyutkkbn, BizDate pHyoujidate);

    Integer getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(String pSyouhncd, BizDate pKykymd);

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncd(String pSyouhncd);

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKijyunymd(String pSyouhncd, BizDate pKijyunymd);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems2(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu,
        C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu);

    BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(String pSyouhncd);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(String pMosno, C_SyutkKbn pSyutkkbn, BizDate pSyssyoriymd);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu);

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd);

    List<BM_KyhNitigakuBairitu> getAllKyhNitigakuBairitu();

    BM_KyhNitigakuBairitu getKyhNitigakuBairitu(String pSyouhncd, Integer pSyouhnsdno, C_KataKbn pKatakbn);

    List<BM_TokujyouSakugenRate> getAllTokujyouSakugenRate();

    BM_TokujyouSakugenRate getTokujyouSakugenRate(String pSyouhncd, Integer pSyouhnsdno, C_Tkjyskgnkkn pTkjyskgnkkn);

    List<BM_Tuuka> getAllTuuka();

    BM_Tuuka getTuuka(C_Tuukasyu pTuukasyu);

    List<BM_BunsyonoSettei> getAllBunsyonoSettei();

    BM_BunsyonoSettei getBunsyonoSettei(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, String pOyadrtencd, Integer pRenno);

    List<BM_BunsyonoSettei> getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, BizDate pTekiyouYmd);

    List<BM_SyouhnbetuSegment> getAllSyouhnbetuSegment();

    BM_SyouhnbetuSegment getSyouhnbetuSegment(String pSyouhncd, C_Tuukasyu pKyktuukasyu, C_SegbunruiKbn pSegbunrui1, C_SegbunruiKbn pSegbunrui2);

    List<BM_BosyuuKyuusi> getAllBosyuuKyuusi();

    BM_BosyuuKyuusi getBosyuuKyuusi(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , Integer pHanteiyuusendo);

    List<BM_BosyuuKyuusi> getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , C_BoskyuusiRiyuuKbn pBoskyuusiriyuukbn);

    List<BM_SyouhnToriatukaiTuuka> getAllSyouhnToriatukaiTuuka();

    BM_SyouhnToriatukaiTuuka getSyouhnToriatukaiTuuka(String pSyouhncd, BizDate pTkyfromymd, BizDate pTkytoymd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu);

    List<BM_SyouhnToriatukaiTuuka> getSyouhnToriatukaiTuukasByPk(String pSyouhncd, BizDate pTekiyouYmd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu);

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems2(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu
        , C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu);

    List<BM_ChkNenreiHani> getAllChkNenreiHani();

    BM_ChkNenreiHani getChkNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen);

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, Integer pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    Long getChkNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu);

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, int pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    Long getChkNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn);

    List<BM_ChkJhNenreiHani> getAllChkJhNenreiHani();

    BM_ChkJhNenreiHani getChkJhNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen);

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , Integer pSeibetu, BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, Integer pSeibetu
        , BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    Long getChkJhNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu);

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pTkykmossyouhnumu);

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , int pSeibetu, BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, int pSeibetu, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn);

    Long getChkJhNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn);

    List<BM_ChkTkykSyuNenreiHani> getAllChkTkykSyuNenreiHani();

    BM_ChkTkykSyuNenreiHani getChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn);

    Long getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn pPmnjtkkbn, Integer pHhknnen);

    List<BM_ChkKhnKyhKgBairitu> getAllChkKhnKyhKgBairitu();

    BM_ChkKhnKyhKgBairitu getChkKhnKyhKgBairitu(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn);

    List<BM_ChkKhnKyhKgBairitu> getChkKhnKyhKgBairitusByPk(String pSyouhncd, Integer pSyouhnsdno, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn);

    List<BM_ChkTkykHukaSeigen> getAllChkTkykHukaSeigen();

    BM_ChkTkykHukaSeigen getChkTkykHukaSeigen(String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pSntkhoukbnfrom, Integer pSntkhoukbnto
        , BizNumber pHhknfromnen, BizNumber pHhkntonen, String pTksyouhncd);

    List<BM_ChkTkykHukaSeigen> getChkTkykHukaSeigensByPk(String pSyusyouhncd, Integer pSyouhnsdno, Integer pSntkhoukbn, BizNumber pHhknnen, String pTksyouhncd);

    List<BM_ChkKata> getAllChkKata();

    BM_ChkKata getChkKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn);

    List<BM_ChkKata> getChkKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn);

    List<BM_ChkKyuuhuKata> getAllChkKyuuhuKata();

    BM_ChkKyuuhuKata getChkKyuuhuKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KyhgndkataKbn pKyhkatakbn);

    List<BM_ChkKyuuhuKata> getChkKyuuhuKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_KyhgndkataKbn pKyhkatakbn);

    List<BM_ChkTkykHukaKahi> getAllChkTkykHukaKahi();

    BM_ChkTkykHukaKahi getChkTkykHukaKahi(String pTksyouhncd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd);

    List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisByPk(String pTksyouhncd, String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd);

    List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_UmuKbn pTkhukahissuumu);

    List<BM_ChkSaiteiS> getAllChkSaiteiS();

    BM_ChkSaiteiS getChkSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu);

    List<BM_ChkSaiteiS> getChkSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu);

    List<BM_ChkJhSaiteiS> getAllChkJhSaiteiS();

    BM_ChkJhSaiteiS getChkJhSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu);

    List<BM_ChkJhSaiteiS> getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu);

    List<BM_ChkJhSaiteiS> getChkJhSaiteiSsByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pDntsdnumufrom, Integer pDntsdnumuto, Integer pHrkkknsmnkbn
        , BizNumber pHknkkn, Integer pSaiteisknwtkumufrom, Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu);

    List<BM_ChkNenkinSaiteiS> getAllChkNenkinSaiteiS();

    BM_ChkNenkinSaiteiS getChkNenkinSaiteiS(Integer pNenkinkkn, String pNenkinsyu);

    List<BM_ChkSaikouSSTani> getAllChkSaikouSSTani();

    BM_ChkSaikouSSTani getChkSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu);

    List<BM_ChkSaikouSSTani> getChkSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu);

    List<BM_ChkJhSaikouSSTani> getAllChkJhSaikouSSTani();

    BM_ChkJhSaikouSSTani getChkJhSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu);

    List<BM_ChkJhSaikouSSTani> getChkJhSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu);

    List<BM_ChkKeiyakuTaniSaikouS> getAllChkKeiyakuTaniSaikouS();

    BM_ChkKeiyakuTaniSaikouS getChkKeiyakuTaniSaikouS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto);

    List<BM_ChkKeiyakuTaniSaikouS> getChkKeiyakuTaniSaikouSsByPk(String pSyouhncd, Integer pSyouhnsdno);

    List<BM_ChkKokutiJougenS> getAllChkKokutiJougenS();

    BM_ChkKokutiJougenS getChkKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto);

    List<BM_ChkKokutiJougenS> getChkKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn);

    List<BM_ChkSyouhnKokutiJougenS> getAllChkSyouhnKokutiJougenS();

    BM_ChkSyouhnKokutiJougenS getChkSyouhnKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto);

    List<BM_ChkSyouhnKokutiJougenS> getChkSyouhnKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn);

    List<BM_ChkNenkinSyurui> getAllChkNenkinSyurui();

    BM_ChkNenkinSyurui getChkNenkinSyurui(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Sknenkinsyu pSknenkinsyu);

    List<BM_ChkTargetTkMokuhyouti> getAllChkTargetTkMokuhyouti();

    BM_ChkTargetTkMokuhyouti getChkTargetTkMokuhyouti(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti);

    List<BM_ChkTargetTkMokuhyouti> getChkTargetTkMokuhyoutisByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti);

    List<BM_ChkKokutiTuusanS> getAllChkKokutiTuusanS();

    BM_ChkKokutiTuusanS getChkKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto);

    List<BM_ChkKokutiTuusanS> getChkKokutiTuusanSsByHhknnen(BizNumber pHhknnen);

    List<BM_ChkJhKokutiTuusanS> getAllChkJhKokutiTuusanS();

    BM_ChkJhKokutiTuusanS getChkJhKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto);

    List<BM_ChkJhKokutiTuusanS> getChkJhKokutiTuusanSsByHhknnen(BizNumber pHhknnen);

    List<BM_ChkTuusanS> getAllChkTuusanS();

    BM_ChkTuusanS getChkTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkTuusanS> getChkTuusanSsByPk(BizNumber pHhknnen);

    List<BM_ChkJhTuusanS> getAllChkJhTuusanS();

    BM_ChkJhTuusanS getChkJhTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkJhTuusanS> getChkJhTuusanSsByPk(BizNumber pHhknnen);

    List<BM_ChkNenreiNensyuuTuusanS> getAllChkNenreiNensyuuTuusanS();

    BM_ChkNenreiNensyuuTuusanS getChkNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu);

    List<BM_ChkJhNenreiNensyuuTuusanS> getAllChkJhNenreiNensyuuTuusanS();

    BM_ChkJhNenreiNensyuuTuusanS getChkJhNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu);

    List<BM_ChkItijibrTuusanP> getAllChkItijibrTuusanP();

    BM_ChkItijibrTuusanP getChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkItijibrTuusanP> getChkItijibrTuusanPsByPK(BizNumber pHhknnen);

    List<BM_ChkSyokugyou> getAllChkSyokugyou();

    BM_ChkSyokugyou getChkSyokugyou(String pSyokugyoucd);

    List<BM_ChkNkgns> getAllChkNkgns();

    BM_ChkNkgns getChkNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkNkgns> getChkNkgnssByPK(BizNumber pHhknnen);

    List<BM_ChkJhNkgns> getAllChkJhNkgns();

    BM_ChkJhNkgns getChkJhNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkJhNkgns> getChkJhNkgnssByPK(BizNumber pHhknnen);

    List<BM_ChkItijibrTuusanS> getAllChkItijibrTuusanS();

    BM_ChkItijibrTuusanS getChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkItijibrTuusanS> getChkItijibrTuusanSsByPK(BizNumber pHhknnen);

    List<BM_ChkKykDairitenTuusanS> getAllChkKykDairitenTuusanS();

    BM_ChkKykDairitenTuusanS getChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn);

    List<BM_ChkNensyuuBairitu> getAllChkNensyuuBairitu();

    BM_ChkNensyuuBairitu getChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn);

    List<BM_ChkSaiteiP> getAllChkSaiteiP();

    List<BM_ChkSaiteiP> getChkSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1);

    BM_ChkSaiteiP getChkSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1);

    List<BM_ChkJhSaiteiP> getAllChkJhSaiteiP();

    List<BM_ChkJhSaiteiP> getChkJhSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1);

    BM_ChkJhSaiteiP getChkJhSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1);

    List<BM_ChkSTani> getAllChkSTani();

    BM_ChkSTani getChkSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , C_Tuukasyu pTuukasyu);

    List<BM_ChkSTani> getChkSTanisByPK(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, C_Tuukasyu pTuukasyu);

    List<BM_ChkHrkPTani> getAllChkHrkPTani();

    BM_ChkHrkPTani getChkHrkPTani(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd
        , C_Tuukasyu pHrktuukasyu);

    List<BM_ChkHrkPTani> getChkHrkPTanisByPK(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_Tuukasyu pHrktuukasyu);

    List<BM_ChkNkgnsHonken> getAllChkNkgnsHonken();

    BM_ChkNkgnsHonken getChkNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkJhNkgnsHonken> getAllChkJhNkgnsHonken();

    BM_ChkJhNkgnsHonken getChkJhNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen);

    List<BM_ChkSueokiKikan> getAllChkSueokiKikan();

    BM_ChkSueokiKikan getChkSueokiKikan(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pSueokikkn
        , C_SueokikknsmnKbn pSueokikknsmnkbn);

    List<BM_ChkSueokiKikan> getChkSueokiKikansByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pSueokikkn, C_SueokikknsmnKbn pSueokikknsmnkbn);

    List<BM_ChkNkgnsHonken> getChkNkgnsHonkenByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pHhknnen);

    List<BM_ChkNenreiHani2> getAllChkNenreiHani2();

    BM_ChkNenreiHani2 getChkNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen);

    List<BM_ChkJhNenreiHani2> getAllChkJhNenreiHani2();

    BM_ChkJhNenreiHani2 getChkJhNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen);

    List<BM_KawaseRate> getAllKawaseRate();

    BM_KawaseRate getKawaseRate(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn, C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawasetekiyokbn
        , C_KawasetsryKbn pKawasetsrykbn);

    List<BM_TuukabetuKyuusibi> getAllTuukabetuKyuusibi();

    BM_TuukabetuKyuusibi getTuukabetuKyuusibi(BizDate pTuukatoriatukaiymd);

    List<BM_UnitFundKbn> getAllUnitFundKbn();

    BM_UnitFundKbn getUnitFundKbn(String pSyouhncd, Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, Integer pRenno);

    List<BM_KijyungkHanteiKawaseRate> getAllKijyungkHanteiKawaseRate();

    BM_KijyungkHanteiKawaseRate getKijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu);

    List<BM_FundIndexKihon> getAllFundIndexKihon();

    BM_FundIndexKihon getFundIndexKihon(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd);

    List<BM_FundIndexSyokitousi> getAllFundIndexSyokitousi();

    BM_FundIndexSyokitousi getFundIndexSyokitousi(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey);

    List<BM_FundIndexGetumatuCf> getAllFundIndexGetumatuCf();

    BM_FundIndexGetumatuCf getFundIndexGetumatuCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey);

    List<BM_FundIndexGessyoCf> getAllFundIndexGessyoCf();

    BM_FundIndexGessyoCf getFundIndexGessyoCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey);

    List<BM_FundIndexCfGaku> getAllFundIndexCfGaku();

    BM_FundIndexCfGaku getFundIndexCfGaku(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey);

    List<BM_NenkinYoteiRiritu> getAllNenkinYoteiRiritu();

    List<BM_NenkinYoteiRiritu> getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykymd);

    BM_NenkinYoteiRiritu getNenkinYoteiRiritu(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykfromymd, BizDate pKyktoymd);

    List<BM_YoteiRiritu> getAllYoteiRiritu();

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pCalckijyunymd);

    BM_YoteiRiritu getYoteiRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd);

    List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu, BizDate pKykymd);

    List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyu(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu);

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pKykymd);

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd);

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyu(String pSyouhncd, C_Tuukasyu pTuukasyu);

    List<BM_YoteiRiritu> getYoteiRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd);

    List<BM_YoteiRiritu> getYoteiRiritusByKyktoymdMax();

    List<BM_YoteiRiritu2> getYoteiRiritu2sByKijyuntoymdMax();

    public List<BM_YoteiRiritu2> getYoteiRiritu2sBySyouhncdKijyuntoymdMax(String pSyouhncd);

    List<BM_YoteiRiritu3> getAllYoteiRiritu3();

    BM_YoteiRiritu3 getYoteiRiritu3(String pSyouhncd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd);

    List<BM_YoteiRiritu3> getYoteiRiritu3sBySyouhncdKijyuntoymdMax(String pSyouhncd);

    List<BM_YoteiRirituRendouSeigyo> getAllYoteiRirituRendouSeigyo();

    BM_YoteiRirituRendouSeigyo getYoteiRirituRendouSeigyo(String pYoteirirituhanteidfrom, String yoteirirituhanteidto, String pSyouhncd);

    public List<BM_YoteiRirituRendouSeigyo> getYoteiRirituRendouSeigyosByYoteirirituhanteid(String pYoteirirituhanteid);

    List<BM_SjkkkTyouseiyouRiritu> getAllSjkkkTyouseiyouRiritu();

    BM_SjkkkTyouseiyouRiritu getSjkkkTyouseiyouRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd);

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd);

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPKKykymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd);

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn);

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByKyktoymdMax();

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPk(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd);

    List<BM_KaiyakuKoujyoRitu> getAllKaiyakuKoujyoRitu();

    BM_KaiyakuKoujyoRitu getKaiyakuKoujyoRitu(String pSyouhncd, String pRyouritusdno, String pKaiyakukjtkybr1, String pKaiyakukjtkybr2, Integer pKeikanensuu);

    List<BM_RateP> getAllRateP();

    BM_RateP getRateP(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan);

    List<BM_RateV> getAllRateV();

    BM_RateV getRateV(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan);

    List<BM_RateD> getAllRateD();

    BM_RateD getRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode);

    List<BM_RateNenkinPkisoV> getAllRateNenkinPkisoV();

    BM_RateNenkinPkisoV getRateNenkinPkisoV(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode);

    List<BM_RateNenkinD> getAllRateNenkinD();

    BM_RateNenkinD getRateNenkinD(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode, String pPaldnendo, String pPaldratenaikakucode);

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd);

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd);

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd);

    List<BM_YoteiRiritu2> getAllYoteiRiritu2();

    BM_YoteiRiritu2 getYoteiRiritu2(String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd);

    List<BM_SjkkkTyouseiyouRiritu2> getAllSjkkkTyouseiyouRiritu2();

    BM_SjkkkTyouseiyouRiritu2 getSjkkkTyouseiyouRiritu2(String pSyouhncd, String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd);

    List<BM_Sisuu> getAllSisuu();

    BM_Sisuu getSisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd);

    List<BM_SisuuKihon> getAllSisuuKihon();

    BM_SisuuKihon getSisuuKihon(C_Sisuukbn pSisuukbn);

    List<BM_HsykkntkSysnNkGnsritu> getAllHsykkntkSysnNkGnsritu();

    BM_HsykkntkSysnNkGnsritu getHsykkntkSysnNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, C_Seibetu pSeibetu, Integer pNkshrstartnen);

    List<BM_KktNkGnsritu> getAllKktNkGnsritu();

    BM_KktNkGnsritu getKktNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn);

    List<BM_Sisuu> getSisuusBySisuukouhyouymdMax();

    List<BM_AzukariRiritu> getAllAzukariRiritu();

    BM_AzukariRiritu getAzukariRiritu(C_Tuukasyu pTuukasyu, BizDate pTkyfromymd, BizDate pTkytoymd);

    List<BM_HaitouRiritu> getAllHaitouRiritu();

    BM_HaitouRiritu getHaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd);

    List<BM_IkkatuKeisuu> getAllIkkatuKeisuu();

    BM_IkkatuKeisuu getIkkatuKeisuu(Integer pIkttekiyouno, Integer pNen1nen2baraihyouji, Integer pKeikatukisuu);

    List<BM_IkkatuTekiyouNo> getAllIkkatuTekiyouNo();

    BM_IkkatuTekiyouNo getIkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno);

    List<BM_IkkatuTekiyouNo2> getAllIkkatuTekiyouNo2();

    BM_IkkatuTekiyouNo2 getIkkatuTekiyouNo2(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, String pIkttekiyoubr1, String pIkttekiyoubr2
        , String pIkttekiyoubr3);

    List<BM_ZennouGenkaRitu> getAllZennouGenkaRitu();

    BM_ZennouGenkaRitu getZennouGenkaRitu(Integer pZennounensuu, String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouKeikaRiritu> getAllZennouKeikaRiritu();

    BM_ZennouKeikaRiritu getZennouKeikaRiritu(Integer pKeikatukisuu, String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouRiritu> getAllZennouRiritu();

    BM_ZennouRiritu getZennouRiritu(String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouTumitateRitu> getAllZennouTumitateRitu();

    BM_ZennouTumitateRitu getZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_KktNk1stNkBigkGnsritu> getAllKktNk1stNkBigkGnsritu();

    BM_KktNk1stNkBigkGnsritu getKktNk1stNkBigkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn);

    List<BM_SibouRitu> getAllSibouRitu();

    BM_SibouRitu getSibouRitu(String pRyouritusdno, C_Seibetu pSeibetu, Integer pNen);

    BM_RisaHitSyouhnyouRateD getRisaHitSyouhnyouRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode);

    List<BM_RisaHitSyouhnyouRateD> getAllRisaHitSyouhnyouRateD();

    List<BM_RateP2> getAllRateP2();

    BM_RateP2 getRateP2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPalryouritukbn);

    BM_RateP2 getRateP2byRatePkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan);

    List<BM_RateV2> getAllRateV2();

    BM_RateV2 getRateV2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn);

    BM_RateV2 getRateV2byRateVkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan);

    List<BM_RisaHitSyouhnyouRateD2> getAllRisaHitSyouhnyouRateD2();

    BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPaldnendo, String pPaldratenaikakucode);

    BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode);

    List<BM_RateW> getAllRateW();

    BM_RateW getRateW(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn);

    List<BM_TienrisokuRiritu> getAllTienrisokuRiritu();

    BM_TienrisokuRiritu getTienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouGenkaRitu2> getAllZennouGenkaRitu2();

    BM_ZennouGenkaRitu2 getZennouGenkaRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pZennounensuu
        , String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouKeikaRiritu2> getAllZennouKeikaRiritu2();

    BM_ZennouKeikaRiritu2 getZennouKeikaRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pKeikatukisuu
        , String pTekiyoukknfrom, String pTekiyoukknkto);

    List<BM_ZennouRiritu2> getAllZennouRiritu2();

    BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto);

    List<BM_ZennouTumitateRitu2> getAllZennouTumitateRitu2();

    BM_ZennouTumitateRitu2 ZennouTumitateRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto);

    List<BM_Ginkou> getAllGinkou();

    BM_Ginkou getGinkou(String pBankcd, String pSitencd);

    Long getGinkouCountByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn);

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn);

    Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj);

    Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt);

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj);

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt);

    List<BM_CreditCardKaisya> getAllCreditCardKaisya();

    BM_CreditCardKaisya getCreditCardKaisya(String pCardkaisyacd);

    List<BM_KinyuuKikanHuhoyofuriInfo> getAllKinyuuKikanHuhoyofuriInfo();

    BM_KinyuuKikanHuhoyofuriInfo getKinyuuKikanHuhoyofuriInfo(String pBankcd);

    Long getGinkousCountByBankcdBanknmkn(String pBankcd, String pBanknmkn);

    List<BM_Ginkou> getGinkousByBankcdBanknmknOrderByBankcdAsc(String pBankcd, String pBanknmkn);


    List<BM_KanjyouKamoku> getAllKanjyouKamoku();

    BM_KanjyouKamoku getKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd);

    List<BT_DenpyoData> getAllDenpyoData();

    BT_DenpyoData getDenpyoData(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdDensyskbn(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_DensysKbn pDensyskbn);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_DensysKbn... pDensyskbn);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate pDenymd, BizDate pSyoriYmd, BizDate pFstpryosyuymd);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate pSyoriYmd);

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate pSyoriYmd);

    List<BT_DenpyoData> getDenpyoDatasByDenymdKanjyoukmkcds(BizDate pKensakuYmdFrom, BizDate pKensakuYmdTo);

    List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn);

    List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn, BizDate pDenymd);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate pDenymdFrom, BizDate pDenymdTo);

    List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> getBzSkHonsyaDenpyousByDenymdTaisyakukbn(BizDate pDenymdFrom, BizDate pDenymdTo, C_TaisyakuKbn pTaisyakukbn);

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BT_HuriDenpyou> getAllHuriDenpyou();

    BT_HuriDenpyou getHuriDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousBySyoriYmd(BizDate pSyoriYmd);

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBUpdatableResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BM_Segment> getAllSegment();

    BM_Segment getSegment(C_Segcd pSegcd);

    List<BM_DensimeNenkanSchedule> getAllDensimeNenkanSchedule();

    BM_DensimeNenkanSchedule getDensimeNenkanSchedule(BizDateYM pSyoriym);

    List<BT_KawaseRateData> getAllKawaseRateData();

    BT_KawaseRateData getKawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn);

    List<BT_SinkeiyakuHurikaeDen> getAllSinkeiyakuHurikaeDen();

    BT_SinkeiyakuHurikaeDen getSinkeiyakuHurikaeDen(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensBySyoriYmd(BizDate pSyoriYmd);

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BT_Hjyblist> getAllHjyblist();

    BT_Hjyblist getHjyblist(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, String pSyorisyokantantcd, BizDate pDenymd);

    ExDBResults<BT_Hjyblist> getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(String pKakutyoujobcd, BizDate pDenymdFrom, BizDate pDenymdTo);

    List<BT_Hjybruikeigaku> getAllHjybruikeigaku();

    BT_Hjybruikeigaku getHjybruikeigaku(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym);

    List<BT_Hjybruikeigaku> getHjybruikeigakusByPK(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym);

    List<BT_Nyknmeisai> getAllNyknmeisai();

    BT_Nyknmeisai getNyknmeisai(String pHrkmsakuseiymd6keta, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano
        , String pHrkmsyoukaino, String pHrkmrenno8);

    ExDBResults<BT_Nyknmeisai> getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(String pKakutyoujobcd, String pHrkmsakuseiymd6keta);

    List<BT_Gknyknmeisai> getAllGknyknmeisai();

    BT_Gknyknmeisai getGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1);

    ExDBResults<BT_Gknyknmeisai> getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(String pKakutyoujobcd, String pHrkmsakuseiymd);

    List<BM_FBSoukinListKanri> getAllFBSoukinListKanri();

    BM_FBSoukinListKanri getFBSoukinListKanri(String pSyoricd, String pSyorisosikicd);

    List<BT_FBSoukinData> getAllFBSoukinData();

    BT_FBSoukinData getFBSoukinData(String pFbsoukindatasikibetukey);

    ExDBUpdatableResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd);

    ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn);

    ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd);

    List<BT_GkFBSoukinData> getAllGkFBSoukinData();

    BT_GkFBSoukinData getGkFBSoukinData(String pFbsoukindatasikibetukey);

    ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn, BizDate pDratekakuteiymd, C_Gkgyoumucd... pGkgyoumucd);

    ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd);

    ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd);

    ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BT_SikinIdouListSks> getAllSikinIdouListSks();

    BT_SikinIdouListSks getSikinIdouListSks(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);

    ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> getSokujiSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd);

    ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> getTyakkinSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd);


    List<BT_OnlineGknyknmeisai> getAllOnlineGknyknmeisai();

    BT_OnlineGknyknmeisai getOnlineGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1);

    List<BT_HjybruikeigakuTeisei> getAllHjybruikeigakuTeisei();

    BT_HjybruikeigakuTeisei  getHjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd);

    List<BT_SikinIdouRireki> getAllSikinIdouRireki();

    BT_SikinIdouRireki getSikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno);

    List<BM_SegmentSikinidou> getAllSegmentSikinidou();

    BM_SegmentSikinidou getSegmentSikinidou(C_Segcd  pSegcd);

    List<BT_HijynNykSiknIdouLstSksGk> getAllHijynNykSiknIdouLstSksGk();

    BT_HijynNykSiknIdouLstSksGk getHijynNykSiknIdouLstSksGk(BizDate pSyoriYmd, C_SikinidouPKbn pSikinidoupkbn, String pSyono, Integer pRenno);


    List<BM_SikinIdouGroup> getAllSikinIdouGroup();

    BM_SikinIdouGroup getSikinIdouGroup(C_Segcd pSegcd);

    List<BT_YendthnkSikinIdouData> getAllYendthnkSikinIdouData();

    BT_YendthnkSikinIdouData getYendthnkSikinIdouData(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd);

    List<BT_YendthnkSikinIdouListSks> getAllYendthnkSikinIdouListSks();

    BT_YendthnkSikinIdouListSks getYendthnkSikinIdouListSks(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd);



    List<BT_HijynNykSikinIdouListSks> getAllHijynNykSikinIdouListSks();

    BT_HijynNykSikinIdouListSks getHijynNykSikinIdouListSks(String pSyono, BizDateYM pSikinidoupjytym);

    List<BT_KbtKarikanjyou> getAllKbtKarikanjyou();

    BT_KbtKarikanjyou getKbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey);

    List<BM_HutanpoBui> getAllHutanpoBui();

    BM_HutanpoBui getHutanpoBui(String pHtnpbuicd);

    List<BM_Syoubyou> getAllSyoubyou();

    BM_Syoubyou getSyoubyou(String pSyoubyoucd);

    List<BM_Syoubyou> getSyoubyousBySyoubyoucdSyoubyounm(String pSyoubyoucd, String pSyoubyounm);

    List<BM_Syokugyou> getAllSyokugyou();

    BM_Syokugyou getSyokugyou(String pSyokugyoucd);

    List<BM_Syokugyou> getSyokugyousBySyokugyoucdSyokugyounm(String pSyokugyoucd, String pSyokugyounm);

    List<BM_LincKaisyacd> getAllLincKaisyacd();

    BM_LincKaisyacd getLincKaisyacd(String pLinckaisyacdnum);


    List<BM_Channel> getAllChannel();

    BM_Channel getChannel(C_Channelcd pChannelcd);

    List<BM_Dairiten> getAllDairiten();

    BM_Dairiten getDairiten(String pDrtencd);

    List<BM_Dairiten> getDairitensByOyadrtencdDrtenjimcd(String pOyadrtencd, String pDrtenjimcd);

    List<BM_Dairiten> getDairitensByKinyuucdKinyuusitencd(String pKinyuucd, String pKinyuusitencd);

    String getDairitenMinDrtencdByKinyuucdDrtenjimcd(String pKinyuucd, String pDrtenjimcd);

    List<BM_Dairiten> getDairitensByDrtencds(String[] pDrtencd);

    List<BM_Dairiten> getDairitensByKinyuucd(String pKinyuucd);

    List<BM_DairitenSyougou> getAllDairitenSyougou();

    BM_DairitenSyougou getDairitenSyougou(String pDrtencd);

    List<BM_Bosyuunin> getAllBosyuunin();

    BM_Bosyuunin getBosyuunin(String pBosyuucd);

    List<BM_Bosyuunin> getBosyuuninByBosyuutrkno(String pBosyuutrkno);

    List<BM_Tyouhyourenrakusaki> getAllTyouhyourenrakusaki();

    BM_Tyouhyourenrakusaki getTyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn);

    List<BM_Kouin> getAllKouin();

    BM_Kouin getKouin(String pKinyuucd, String pKouincd);

    List<BM_Kouin> getKouinsBybosyuucd(String pBosyuucd);

    List<BM_Kouin> getKouinsByKouincds(String pKinyuucd, String[] pKouincd);

    List<BT_MdhnBank> getAllMdhnBank();

    BT_MdhnBank getMdhnBank(String pDrtencd);

    List<BT_HknBosyuRiyouInfo> getAllHknBosyuRiyouInfo();

    BT_HknBosyuRiyouInfo getHknBosyuRiyouInfo(String pDrtencd);

    List<BT_BuntanInfo> getAllBuntanInfo();

    BT_BuntanInfo getBuntanInfo(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pTesuuryoubuntanstartym);

    List<BT_BuntanInfo> getBuntanInfosByPK(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pSyutokukijyunym);

    List<BT_BuntanInfo> getBuntanInfosAitedrtenSiteinasi(String pDrtencd, String pDairitensyouhincd, BizDateYM pSyutokukijyunym);

    List<BT_DairitenItakuSyouhn> getAllDairitenItakuSyouhn();

    BT_DairitenItakuSyouhn getDairitenItakuSyouhn(String pDrtencd, String pDrtsyouhinsikibetukbnstr, String pDrthrkhouhoukbn, String pDrtplannmkbn, BizDate pItakuhknhnbkaisiymd);

    Long getDairitenCountByDrtencdDrtennm(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2);

    List<BM_Dairiten> getDairitenByDrtencdDrtennmOrderByDrtencdAsc(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2);

    List<BM_SyoruiKtg> getAllSyoruiKtg();

    BM_SyoruiKtg getSyoruiKtg(C_SyoruiCdKbn pSyoruiCd, String pKtgsyoruicd);

    List<BT_TyouhyouOutputKengen> getAllTyouhyouOutputKengen();

    BT_TyouhyouOutputKengen getTyouhyouOutputKengen(String pRoleCd, C_SyoruiCdKbn pSyoruiCd);

    List<BM_TorikomiSyoruiHukaInfo> getAllTorikomiSyoruiHukaInfo();

    BM_TorikomiSyoruiHukaInfo getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd);

    ZtrhyousiInfoBySyoruiCdBean getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn pSyoruiCd);

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn, C_UmuKbn pQrsealumukbn, C_SkeijimuKbn... pSkeijimukbn);

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn);

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosByImagegazoukaKbn(C_ImagegazoukaKbn pImagegazoukakbn);

    List<BM_SyoruiZokuseiHukaInfo> getAllSyoruiZokuseiHukaInfo();

    BM_SyoruiZokuseiHukaInfo getSyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd);

    List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(String[] pRoleCd, C_KahiKbn pIkkatuoutputkahikbn);

    List<SyoruiZokuseiMasterInfoBean> getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(String[] pRoleCd, String[] pSubSystemId);

    List<BM_SyoruiZokuseiHukaInfo> getSyoruiZokuseiHukaInfosBySubSystemIds(String[] pSubSystemId);

    List<BM_Syonokanri> getAllSyonokanri();

    BM_Syonokanri getSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno);

    List<BM_Syonokanri> getSyonokanrisBySyono(String pSyono);

    String getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(String pSeirekinen2keta);

    String getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(String pSeirekinen2keta, BizDate pSaibanymd);

    Integer getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd);

    List<BM_Simekiribi> getAllSimekiribi();

    BM_Simekiribi getSimekiribi(BizDateYM pBosyuuym);

    List<BT_HengakuEpsilonDenpyo> getAllHengakuEpsilonDenpyo();

    BT_HengakuEpsilonDenpyo getHengakuEpsilonDenpyo(C_HengakuSyuruiKbn pHengakusyuruikbn, C_UnitFundKbn pUnitfundkbn, C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn
        , String pKacd, BizDate pDenymd, C_DenpyouKbn pDenpyoukbn, C_TaisyakuKbn pTaisyakukbn, String pKamokucd
        , BizDate pSyoriYmd);

    List<BT_KinouHukaInfo> getAllKinouHukaInfo();

    BT_KinouHukaInfo getKinouHukaInfo(String pKinouId);

    List<BT_WariateHukaInfo> getAllWariateHukaInfo();

    BT_WariateHukaInfo getWariateHukaInfo(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid,  String  pUserId);

    List<BT_WariateHukaInfo> getWariateHukaInfosByPKWithoutUserId(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid);

    List<BT_WariateHukaInfo> getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukakaijyotskid);

    List<BT_LastSyoriYMDKanri> getAllLastSyoriYMDKanri();

    BT_LastSyoriYMDKanri getLastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn);

    List<BM_Address> getAllAddress();

    BM_Address getAddress(String pPostalCd, String pKihontikucdsimo1);

    Long getAddressDistinctPostAdrkjAdrknbkarisCountByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj);

    List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> getAddressDistinctPostAdrkjAdrknbkarisByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj);

    List<String> getAddressDistinctAdrknblankarisByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn);

    C_TodouhukenKbn getAddressMinTodouhukencdByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn);

    List<AddressDistinctItemsBypostalCdBean> getAddressDistinctItemsBypostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn);

    List<BT_GyoumuKouteiInfo> getAllGyoumuKouteiInfo();

    BT_GyoumuKouteiInfo getGyoumuKouteiInfo(String pKouteikanriid);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(String pSyukouteikanriid, String pSyukouteijimutetuzukicd);

    List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(String pSyukouteikanriid, String pSyukouteijimutetuzukicd);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySkno(String pSkno);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByMosno(String pMosno);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(String pJimutetuzukicd, String pSyono, String pSkno);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriids(String[] pSyukouteikanriid);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriid(String pSyukouteikanriid);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(String pJimutetuzukicd, String pSyukouteikanriid);

    List<AS_Kinou> getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn pTjttrkskahi, String pSubSystemId);

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyonoSkno(String pSyono, String pSkno);

    List<BM_PalSyoumetujiyuu> getAllPalSyoumetujiyuu();

    BM_PalSyoumetujiyuu getPalSyoumetujiyuu(String pPalsyoumetucd, C_BetukutiKeiyakuKbn pBetukutikeiyakukbn);

    List<BM_TantouCd> getAllTantouCd();

    BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd);

    List<BM_Syoritanto> getAllSyoritanto();

    BM_Syoritanto getSyoritanto(String pSyoricd);

    List<BM_SosikiMadoguti> getAllSosikiMadoguti();

    BM_SosikiMadoguti getSosikiMadoguti(String pSskmdsosikicd);

    List<BM_WariateHukaInfoKanri> getAllWariateHukaInfoKanri();

    BM_WariateHukaInfoKanri getWariateHukaInfoKanri(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, Integer pRenno);

    List<BM_WariateHukaInfoKanri> getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, String pNexttskid);

    List<BT_WariateHukaInfo> getWariateHukaInfosBySubSystemIdUserId(String pSubSystemId, String pUserId);

    List<AT_TyouhyouKensaku> getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, String pSubSystemId, BizDate pSyoriYmd, Integer pOutCount);

    List<SyoruiZokuseiTyouhyouInfoBean> getSyoruiZokuseiTyouhyouInfo(String pSubSystemId, BizDate pSyoriYmd, String[] pRoleCd, C_SyoruiCdKbn pSyoruiCd);

    List<AT_TyouhyouKensaku> getTyouhyouKensakusByTyouhyouJoinKey(String pTyouhyouJoinKey);

    Long getTyouhyouKensakuCountByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto);

    List<AT_TyouhyouKensaku> getTyouhyouKensakusByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto);

    List<UsersByKinouIdKinouModeIdUserIdBean> getUsersByKinouIdKinouModeIdUserId(String pKinouId, String pKinouModeId, String pUserId);

    List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(String pKinouId, String pKinouModeId, String pUserId, String pFlowId, String pNodeId);

    ExDBUpdatableResults<AM_User> getUsersByTables();

    ExDBResults<AT_AccessLog> getAccessLogsByTimeStamp(Long pSyoriYmdFrom, Long pSyoriYmdTo);

    ExDBResults<AT_AccessLog> getAccessLogsBySyoriYmdFromSyoriYmdTo(Long pSyoriYmdFrom, Long pSyoriYmdTo);

    List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd);

    List<BM_Address> getAddressesByPostalCd(String pPostalCd);

    List<AS_SubSystem> getSubSystemsBySubSystemIds(String[] pSubSystemId);

    List<BT_TuutirirekiMeisaiHokan> getAllTuutirirekiMeisaiHokan();

    BT_TuutirirekiMeisaiHokan getTuutirirekiMeisaiHokan(String pTuutirirekirenno);

    ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM pTuutisakuseiym);

    List<BM_SeisanDShrymd> getAllSeisanDShrymd();

    BM_SeisanDShrymd getSeisanDShrymd(BizDateY pSyorinendo);

    List<BT_SystemRenkei> getAllSystemRenkei();

    BT_SystemRenkei getSystemRenkei(String pInterfaceid);

    List<BT_YoukyuuNoKanri> getAllYoukyuuNoKanri();

    BT_YoukyuuNoKanri getYoukyuuNoKanri(String pYoukyuuno);

    List<BM_MqBatchSosiki> getAllMqBatchSosiki();

    BM_MqBatchSosiki getMqBatchSosiki(String pKinouId);

    List<BT_TjtIdouNyKh> getAllTjtIdouNyKh();

    BT_TjtIdouNyKh getTjtIdouNyKh(String pSyono, Integer pRenno3keta);

    ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhs();

    ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd);

    List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyono(String pSyono);

    Integer getTjtIdouNyKhMaxRenno3ketaBySyono(String pSyono);

    List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyonoYoukyuuno(String pSyono, String pYoukyuuno);

    List<BT_TjtIdouNySk> getAllTjtIdouNySk();

    ExDBResults<BT_TjtIdouNySk> getTjtIdouNySks();

    ExDBResults<BT_TjtIdouNySk> getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd);

    List<BT_TjtIdouNySk> getTjtIdouNySksByMosno(String pMosno);

    BT_TjtIdouNySk getTjtIdouNySk(String pMosno, Integer pRenno3keta);

    Integer getTjtIdouNySkMaxRenno3ketaByMosno(String pMosno);

    List<BT_TjtIdouNySk> getTjtIdouNySksByMosnoYoukyuuno(String pMosno, String pYoukyuuno);

    List<BT_TjtIdouNyNk> getAllTjtIdouNyNk();

    List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysyno(String pNksysyno);

    ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNks();

    ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd);

    BT_TjtIdouNyNk getTjtIdouNyNk(String pNksysyno, Integer pRenno3keta);

    Integer getTjtIdouNyNkMaxRenno3ketaByNksysyno(String pNksysyno);

    List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysynoYoukyuuno(String pNksysyno, String pYoukyuuno);

    List<BT_TjtIdouNyKhItjhzn> getAllTjtIdouNyKhItjhzn();

    BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta);

    List<BT_TjtIdouNySkItjhzn> getAllTjtIdouNySkItjhzn();

    BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn(String pMosno, Integer pRenno3keta);

    List<BT_TjtIdouNyNkItjhzn> getAllTjtIdouNyNkItjhzn();

    BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn(String pNksysyno, Integer pRenno3keta);

    List<BT_NenkinInfoRendou> getAllNenkinInfoRendou();

    BT_NenkinInfoRendou getNenkinInfoRendou(BizDate pSyoriYmd, String pSyono, Integer pRenno);

    ExDBUpdatableResults<BT_NenkinInfoRendou> getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BT_SkipKey> getAllSkipKey();

    BT_SkipKey getSkipKey(String pRecoverysikibetukey);

    List<BM_RecoveryFilter> getAllRecoveryFilter();

    BM_RecoveryFilter getRecoveryFilter(String pRecoveryfilterid);

    List<BW_IdCardWk> getAllIdCardWk();

    BW_IdCardWk getIdCardWk(String pIdkbn, String pIdcd);

    ExDBResults<BW_IdCardWk>  getIdCardWks();

    Long getIdCardWkCount();

    ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWk();

    ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWkUserNm();

    ExDBResults<BW_IdCardWk> getIdCardWksSyoukaiUserByNotExistsUserWk();

    List<BW_UserIdKanrenWk> getAllUserIdKanrenWk();

    BW_UserIdKanrenWk getUserIdKanrenWk(String pIdkbn, String pIdcd);

    List<BW_IdCardYakusyokuWk> getAllIdCardYakusyokuWk();

    BW_IdCardYakusyokuWk getIdCardYakusyokuWk(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino);

    List<BT_UserKengenHaneiSskInfo> getAllUserKengenHaneiSskInfo();

    BT_UserKengenHaneiSskInfo getUserKengenHaneiSskInfo(String pSosikicdkami3);

    List<BW_UserWk> getAllUserWk();

    BW_UserWk getUserWk(String pUserId);

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSisyaUserRoleWk(String[] pSisyaReigaiSosikiCdList, String[] pSisyayouRoleCdList);

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSyoukaiUserRoleWk(String[] pHnsaSknmSsyRoruCdList);

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserIdKanrenWk();

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaReigaiSosikiCdList);

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList);

    List<BW_UserRoleWk> getAllUserRoleWk();

    BW_UserRoleWk getUserRoleWk(String pUserId, String pRoleCd);

    List<BW_UserRoleWk> getUserRoleWksByUserId(String pUserId);

    ExDBUpdatableResults<BW_IdCardWk> getIdCardWksBySyozokusosikicdKeta3();

    ExDBUpdatableResults<BW_UserWk> getUserWksBySyozokusosikicdKeta3();

    List<BV_SiharaiTyousyo> getAllSiharaiTyousyo();

    BV_SiharaiTyousyo getSiharaiTyousyo(String pSubSystemId, String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno);

    ExDBResults<BV_SiharaiTyousyo> getSiharaiTyousyosByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<BV_HjybruikeigakuData> getAllHjybruikeigakuData();

    BV_HjybruikeigakuData getHjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd);



    List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();

    List<BM_TestSyonokanri> getAllTestSyonokanri();

    BM_TestSyonokanri getTestSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno);

    List<BT_TestKykData> getAllTestKykData();

    BT_TestKykData getTestKykData(String pUniqueId);

    List<BT_KijituTuriHnbnKnsouTut> getAllKijituTuriHnbnKnsouTut();

    BT_KijituTuriHnbnKnsouTut getKijituTuriHnbnKnsouTut(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno);

    List<BT_KijituTuriHnbnKnsouTutJk> getAllKijituTuriHnbnKnsouTutJk();

    BT_KijituTuriHnbnKnsouTutJk getKijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno);

    List<BT_KijituTouraiHonbanKensyou> getAllKijituTouraiHonbanKensyou();

    BT_KijituTouraiHonbanKensyou getKijituTouraiHonbanKensyou(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno, String pDatakanrino);

}
