package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.sorter.SortBM_ChkHrkPTani;
import yuyu.def.biz.sorter.SortBM_ChkItijibrTuusanP;
import yuyu.def.biz.sorter.SortBM_ChkItijibrTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkJhKokutiTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkJhNenreiHani;
import yuyu.def.biz.sorter.SortBM_ChkJhNenreiHani2;
import yuyu.def.biz.sorter.SortBM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkJhNkgns;
import yuyu.def.biz.sorter.SortBM_ChkJhNkgnsHonken;
import yuyu.def.biz.sorter.SortBM_ChkJhSaikouSSTani;
import yuyu.def.biz.sorter.SortBM_ChkJhSaiteiP;
import yuyu.def.biz.sorter.SortBM_ChkJhSaiteiS;
import yuyu.def.biz.sorter.SortBM_ChkJhTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkKata;
import yuyu.def.biz.sorter.SortBM_ChkKeiyakuTaniSaikouS;
import yuyu.def.biz.sorter.SortBM_ChkKhnKyhKgBairitu;
import yuyu.def.biz.sorter.SortBM_ChkKokutiJougenS;
import yuyu.def.biz.sorter.SortBM_ChkKokutiTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkKykDairitenTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkKyuuhuKata;
import yuyu.def.biz.sorter.SortBM_ChkNenkinSaiteiS;
import yuyu.def.biz.sorter.SortBM_ChkNenkinSyurui;
import yuyu.def.biz.sorter.SortBM_ChkNenreiHani;
import yuyu.def.biz.sorter.SortBM_ChkNenreiHani2;
import yuyu.def.biz.sorter.SortBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.biz.sorter.SortBM_ChkNensyuuBairitu;
import yuyu.def.biz.sorter.SortBM_ChkNkgns;
import yuyu.def.biz.sorter.SortBM_ChkNkgnsHonken;
import yuyu.def.biz.sorter.SortBM_ChkSTani;
import yuyu.def.biz.sorter.SortBM_ChkSaikouSSTani;
import yuyu.def.biz.sorter.SortBM_ChkSaiteiP;
import yuyu.def.biz.sorter.SortBM_ChkSaiteiS;
import yuyu.def.biz.sorter.SortBM_ChkSueokiKikan;
import yuyu.def.biz.sorter.SortBM_ChkSyokugyou;
import yuyu.def.biz.sorter.SortBM_ChkSyouhnKokutiJougenS;
import yuyu.def.biz.sorter.SortBM_ChkTargetTkMokuhyouti;
import yuyu.def.biz.sorter.SortBM_ChkTkykHukaKahi;
import yuyu.def.biz.sorter.SortBM_ChkTkykHukaSeigen;
import yuyu.def.biz.sorter.SortBM_ChkTkykSyuNenreiHani;
import yuyu.def.biz.sorter.SortBM_ChkTuusanS;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.BM_ChkHrkPTaniDao;
import yuyu.def.db.dao.BM_ChkItijibrTuusanPDao;
import yuyu.def.db.dao.BM_ChkItijibrTuusanSDao;
import yuyu.def.db.dao.BM_ChkJhKokutiTuusanSDao;
import yuyu.def.db.dao.BM_ChkJhNenreiHani2Dao;
import yuyu.def.db.dao.BM_ChkJhNenreiHaniDao;
import yuyu.def.db.dao.BM_ChkJhNenreiNensyuuTuusanSDao;
import yuyu.def.db.dao.BM_ChkJhNkgnsDao;
import yuyu.def.db.dao.BM_ChkJhNkgnsHonkenDao;
import yuyu.def.db.dao.BM_ChkJhSaikouSSTaniDao;
import yuyu.def.db.dao.BM_ChkJhSaiteiPDao;
import yuyu.def.db.dao.BM_ChkJhSaiteiSDao;
import yuyu.def.db.dao.BM_ChkJhTuusanSDao;
import yuyu.def.db.dao.BM_ChkKataDao;
import yuyu.def.db.dao.BM_ChkKeiyakuTaniSaikouSDao;
import yuyu.def.db.dao.BM_ChkKhnKyhKgBairituDao;
import yuyu.def.db.dao.BM_ChkKokutiJougenSDao;
import yuyu.def.db.dao.BM_ChkKokutiTuusanSDao;
import yuyu.def.db.dao.BM_ChkKykDairitenTuusanSDao;
import yuyu.def.db.dao.BM_ChkKyuuhuKataDao;
import yuyu.def.db.dao.BM_ChkNenkinSaiteiSDao;
import yuyu.def.db.dao.BM_ChkNenkinSyuruiDao;
import yuyu.def.db.dao.BM_ChkNenreiHani2Dao;
import yuyu.def.db.dao.BM_ChkNenreiHaniDao;
import yuyu.def.db.dao.BM_ChkNenreiNensyuuTuusanSDao;
import yuyu.def.db.dao.BM_ChkNensyuuBairituDao;
import yuyu.def.db.dao.BM_ChkNkgnsDao;
import yuyu.def.db.dao.BM_ChkNkgnsHonkenDao;
import yuyu.def.db.dao.BM_ChkSTaniDao;
import yuyu.def.db.dao.BM_ChkSaikouSSTaniDao;
import yuyu.def.db.dao.BM_ChkSaiteiPDao;
import yuyu.def.db.dao.BM_ChkSaiteiSDao;
import yuyu.def.db.dao.BM_ChkSueokiKikanDao;
import yuyu.def.db.dao.BM_ChkSyokugyouDao;
import yuyu.def.db.dao.BM_ChkSyouhnKokutiJougenSDao;
import yuyu.def.db.dao.BM_ChkTargetTkMokuhyoutiDao;
import yuyu.def.db.dao.BM_ChkTkykHukaKahiDao;
import yuyu.def.db.dao.BM_ChkTkykHukaSeigenDao;
import yuyu.def.db.dao.BM_ChkTkykSyuNenreiHaniDao;
import yuyu.def.db.dao.BM_ChkTuusanSDao;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkJhNenreiHani;
import yuyu.def.db.entity.BM_ChkJhNenreiHani2;
import yuyu.def.db.entity.BM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.def.db.entity.BM_ChkJhNkgnsHonken;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;
import yuyu.def.db.entity.BM_ChkNenreiHani;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import yuyu.def.db.entity.BM_ChkNkgns;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.def.db.entity.BM_ChkTuusanS;


/**
 * ToriatsukaiDomマネージャー<br />
 * Toriatsukaiにおける、DB操作を提供する。<br />
 */
class ToriatsukaiDomManager {

    @Inject
    private BM_ChkHrkPTaniDao chkHrkPTaniDao;

    @Inject
    private BM_ChkItijibrTuusanPDao chkItijibrTuusanPDao;

    @Inject
    private BM_ChkItijibrTuusanSDao chkItijibrTuusanSDao;

    @Inject
    private BM_ChkJhKokutiTuusanSDao chkJhKokutiTuusanSDao;

    @Inject
    private BM_ChkJhNenreiHaniDao chkJhNenreiHaniDao;

    @Inject
    private BM_ChkJhNenreiHani2Dao chkJhNenreiHani2Dao;

    @Inject
    private BM_ChkJhNenreiNensyuuTuusanSDao chkJhNenreiNensyuuTuusanSDao;

    @Inject
    private BM_ChkJhNkgnsDao chkJhNkgnsDao;

    @Inject
    private BM_ChkJhNkgnsHonkenDao chkJhNkgnsHonkenDao;

    @Inject
    private BM_ChkJhSaikouSSTaniDao chkJhSaikouSSTaniDao;

    @Inject
    private BM_ChkJhSaiteiPDao chkJhSaiteiPDao;

    @Inject
    private BM_ChkJhSaiteiSDao chkJhSaiteiSDao;

    @Inject
    private BM_ChkJhTuusanSDao chkJhTuusanSDao;

    @Inject
    private BM_ChkKataDao chkKataDao;

    @Inject
    private BM_ChkKeiyakuTaniSaikouSDao chkKeiyakuTaniSaikouSDao;

    @Inject
    private BM_ChkKhnKyhKgBairituDao chkKhnKyhKgBairituDao;

    @Inject
    private BM_ChkKokutiJougenSDao chkKokutiJougenSDao;

    @Inject
    private BM_ChkKokutiTuusanSDao chkKokutiTuusanSDao;

    @Inject
    private BM_ChkKykDairitenTuusanSDao chkKykDairitenTuusanSDao;

    @Inject
    private BM_ChkKyuuhuKataDao chkKyuuhuKataDao;

    @Inject
    private BM_ChkNenkinSaiteiSDao chkNenkinSaiteiSDao;

    @Inject
    private BM_ChkNenkinSyuruiDao chkNenkinSyuruiDao;

    @Inject
    private BM_ChkNenreiHaniDao chkNenreiHaniDao;

    @Inject
    private BM_ChkNenreiHani2Dao chkNenreiHani2Dao;

    @Inject
    private BM_ChkNenreiNensyuuTuusanSDao chkNenreiNensyuuTuusanSDao;

    @Inject
    private BM_ChkNensyuuBairituDao chkNensyuuBairituDao;

    @Inject
    private BM_ChkNkgnsDao chkNkgnsDao;

    @Inject
    private BM_ChkNkgnsHonkenDao chkNkgnsHonkenDao;

    @Inject
    private BM_ChkSTaniDao chkSTaniDao;

    @Inject
    private BM_ChkSaikouSSTaniDao chkSaikouSSTaniDao;

    @Inject
    private BM_ChkSaiteiPDao chkSaiteiPDao;

    @Inject
    private BM_ChkSaiteiSDao chkSaiteiSDao;

    @Inject
    private BM_ChkSueokiKikanDao chkSueokiKikanDao;

    @Inject
    private BM_ChkSyokugyouDao chkSyokugyouDao;

    @Inject
    private BM_ChkSyouhnKokutiJougenSDao chkSyouhnKokutiJougenSDao;

    @Inject
    private BM_ChkTargetTkMokuhyoutiDao chkTargetTkMokuhyoutiDao;

    @Inject
    private BM_ChkTkykHukaKahiDao chkTkykHukaKahiDao;

    @Inject
    private BM_ChkTkykHukaSeigenDao chkTkykHukaSeigenDao;

    @Inject
    private BM_ChkTkykSyuNenreiHaniDao chkTkykSyuNenreiHaniDao;

    @Inject
    private BM_ChkTuusanSDao chkTuusanSDao;

    List<BM_ChkNenreiHani> getAllChkNenreiHani(){
        SortBM_ChkNenreiHani sortBM_ChkNenreiHani = new SortBM_ChkNenreiHani();
        return sortBM_ChkNenreiHani.OrderBM_ChkNenreiHaniByPkAsc(chkNenreiHaniDao.selectAll());
    }

    BM_ChkNenreiHani getChkNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen) {

        return chkNenreiHaniDao.getChkNenreiHani(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknto
            , pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen, pSyuyoteiriritufrom
            , pSyuyoteirirituto, pTokusyuchkno, pTksyouhncd, pTkhknkkn, pTkhknkknto
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknto, pTkhrkkknsmnkbn
            , pTkfromnen, pTktonen);
    }

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {

        return chkNenreiHaniDao.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(pChannelcd, pSyusyouhncd,
            pSyouhnsdno, pNen, pSeibetu, pSyukatakbn, pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn,
            pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {

        return chkNenreiHaniDao.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu,
            pSyukatakbn, pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSyuyoteiriritu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn,
            pTkhrkkkn, pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , BizNumber pSyuyoteiriritu, Integer pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {

        return chkNenreiHaniDao.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno,
            pSyukatakbnumu, pSyukatakbn, pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn , pSyuyoteiriritu,
            pSeibetu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    Long getChkNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {

        return chkNenreiHaniDao.getChkNenreiHaniCountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn,
            pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen, pSyuyoteiriritu);
    }

    List<BM_ChkJhNenreiHani> getAllChkJhNenreiHani(){
        SortBM_ChkJhNenreiHani sortBM_ChkJhNenreiHani = new SortBM_ChkJhNenreiHani();
        return sortBM_ChkJhNenreiHani.OrderBM_ChkJhNenreiHaniByPkAsc(chkJhNenreiHaniDao.selectAll());
    }

    BM_ChkJhNenreiHani getChkJhNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto
        , C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom
        , BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , BizNumber pTkfromnen, BizNumber pTktonen) {

        return chkJhNenreiHaniDao.getChkJhNenreiHani(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknto
            , pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen, pSyuyoteiriritufrom
            , pSyuyoteirirituto, pTokusyuchkno, pTksyouhncd, pTkhknkkn, pTkhknkknto
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknto, pTkhrkkknsmnkbn
            , pTkfromnen, pTktonen);
    }

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pTkykmossyouhnumu) {

        return chkJhNenreiHaniDao.getChkJhNenreiHanisByPkTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen,
            pSeibetu, pSyukatakbn, pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pTksyouhncd,
            pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn, pTkykmossyouhnumu);
    }

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , Integer pSeibetu, BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {

        return chkJhNenreiHaniDao.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn,
            pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pNen, pSeibetu, pSyuyoteiriritu, pTkykmossyouhnumu,
            pTksyouhncd, pTkhknkkn , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, Integer pSeibetu
        , BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        return chkJhNenreiHaniDao.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn,
            pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSeibetu, pSyuyoteiriritu, pTkykmossyouhnumu,
            pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    Long getChkJhNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn
        , C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {

        return chkJhNenreiHaniDao.getChkJhNenreiHaniCountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn,
            pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen, pSyuyoteiriritu);
    }

    List<BM_ChkTkykSyuNenreiHani> getAllChkTkykSyuNenreiHani(){
        SortBM_ChkTkykSyuNenreiHani sortBM_ChkTkykSyuNenreiHani = new SortBM_ChkTkykSyuNenreiHani();
        return sortBM_ChkTkykSyuNenreiHani.OrderBM_ChkTkykSyuNenreiHaniByPkAsc(chkTkykSyuNenreiHaniDao.selectAll());
    }

    BM_ChkTkykSyuNenreiHani getChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn) {

        return chkTkykSyuNenreiHaniDao.getChkTkykSyuNenreiHani(pPmnjtkkbn);
    }

    Long getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn pPmnjtkkbn, Integer pHhknnen) {

        return chkTkykSyuNenreiHaniDao.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(pPmnjtkkbn, pHhknnen);
    }

    List<BM_ChkKhnKyhKgBairitu> getAllChkKhnKyhKgBairitu(){
        SortBM_ChkKhnKyhKgBairitu sortBM_ChkKhnKyhKgBairitu = new SortBM_ChkKhnKyhKgBairitu();
        return sortBM_ChkKhnKyhKgBairitu.OrderBM_ChkKhnKyhKgBairituByPkAsc(chkKhnKyhKgBairituDao.selectAll());
    }

    BM_ChkKhnKyhKgBairitu getChkKhnKyhKgBairitu(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {

        return chkKhnKyhKgBairituDao.getChkKhnKyhKgBairitu(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pKhnkyhkgbairitukbn);
    }

    List<BM_ChkKhnKyhKgBairitu> getChkKhnKyhKgBairitusByPk(String pSyouhncd, Integer pSyouhnsdno, C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {

        return chkKhnKyhKgBairituDao.getChkKhnKyhKgBairitusByPk(pSyouhncd, pSyouhnsdno, pKhnkyhkgbairitukbn);
    }

    List<BM_ChkTkykHukaSeigen> getAllChkTkykHukaSeigen(){
        SortBM_ChkTkykHukaSeigen sortBM_ChkTkykHukaSeigen = new SortBM_ChkTkykHukaSeigen();
        return sortBM_ChkTkykHukaSeigen.OrderBM_ChkTkykHukaSeigenByPkAsc(chkTkykHukaSeigenDao.selectAll());
    }

    BM_ChkTkykHukaSeigen getChkTkykHukaSeigen(String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pSntkhoukbnfrom, Integer pSntkhoukbnto
        , BizNumber pHhknfromnen, BizNumber pHhkntonen, String pTksyouhncd) {

        return chkTkykHukaSeigenDao.getChkTkykHukaSeigen(pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSntkhoukbnfrom, pSntkhoukbnto
            , pHhknfromnen, pHhkntonen, pTksyouhncd);
    }

    List<BM_ChkTkykHukaSeigen> getChkTkykHukaSeigensByPk(String pSyusyouhncd, Integer pSyouhnsdno, Integer pSntkhoukbn, BizNumber pHhknnen, String pTksyouhncd) {

        return chkTkykHukaSeigenDao.getChkTkykHukaSeigensByPk(pSyusyouhncd, pSyouhnsdno, pSntkhoukbn, pHhknnen,
            pTksyouhncd);
    }

    List<BM_ChkKata> getAllChkKata(){
        SortBM_ChkKata sortBM_ChkKata = new SortBM_ChkKata();
        return sortBM_ChkKata.OrderBM_ChkKataByPkAsc(chkKataDao.selectAll());
    }

    BM_ChkKata getChkKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn) {

        return chkKataDao.getChkKata(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pTktanbrumu, pKatakbn);
    }

    List<BM_ChkKata> getChkKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_UmuKbn pTktanbrumu, C_KataKbn pKatakbn) {

        return chkKataDao.getChkKatasByPk(pSyouhncd, pSyouhnsdno, pTktanbrumu, pKatakbn);
    }

    List<BM_ChkKyuuhuKata> getAllChkKyuuhuKata(){
        SortBM_ChkKyuuhuKata sortBM_ChkKyuuhuKata = new SortBM_ChkKyuuhuKata();
        return sortBM_ChkKyuuhuKata.OrderBM_ChkKyuuhuKataByPkAsc(chkKyuuhuKataDao.selectAll());
    }

    BM_ChkKyuuhuKata getChkKyuuhuKata(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KyhgndkataKbn pKyhkatakbn) {

        return chkKyuuhuKataDao.getChkKyuuhuKata(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pKyhkatakbn);
    }

    List<BM_ChkKyuuhuKata> getChkKyuuhuKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_KyhgndkataKbn pKyhkatakbn) {

        return chkKyuuhuKataDao.getChkKyuuhuKatasByPk(pSyouhncd, pSyouhnsdno, pKyhkatakbn);
    }

    List<BM_ChkTkykHukaKahi> getAllChkTkykHukaKahi(){
        SortBM_ChkTkykHukaKahi sortBM_ChkTkykHukaKahi = new SortBM_ChkTkykHukaKahi();
        return sortBM_ChkTkykHukaKahi.OrderBM_ChkTkykHukaKahiByPkAsc(chkTkykHukaKahiDao.selectAll());
    }

    BM_ChkTkykHukaKahi getChkTkykHukaKahi(String pTksyouhncd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd) {

        return chkTkykHukaKahiDao.getChkTkykHukaKahi(pTksyouhncd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd);
    }

    List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisByPk(String pTksyouhncd, String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd) {

        return chkTkykHukaKahiDao.getChkTkykHukaKahisByPk(pTksyouhncd, pSyusyouhncd, pSyouhnsdno, pChannelcd);
    }

    List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_UmuKbn pTkhukahissuumu) {

        return chkTkykHukaKahiDao.getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(pSyusyouhncd,
            pSyouhnsdno, pChannelcd, pTkhukahissuumu);
    }

    List<BM_ChkSaiteiS> getAllChkSaiteiS(){
        SortBM_ChkSaiteiS sortBM_ChkSaiteiS = new SortBM_ChkSaiteiS();
        return sortBM_ChkSaiteiS.OrderBM_ChkSaiteiSByPkAsc(chkSaiteiSDao.selectAll());
    }

    BM_ChkSaiteiS getChkSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {

        return chkSaiteiSDao.getChkSaiteiS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pDntsdnumufrom, pDntsdnumuto
            , pHrkkknsmnkbnfrom, pHrkkknsmnkbnto, pHknkknfrom, pHknkknto, pSaiteisknwtkumufrom
            , pSaiteisknwtkumuto, pTuukasyu);
    }

    List<BM_ChkSaiteiS> getChkSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {

        return chkSaiteiSDao.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(pSyouhncd, pSyouhnsdno, pHrkkeiro, pSaiteisknwtkumu, pTuukasyu);
    }

    List<BM_ChkJhSaiteiS> getAllChkJhSaiteiS(){
        SortBM_ChkJhSaiteiS sortBM_ChkJhSaiteiS = new SortBM_ChkJhSaiteiS();
        return sortBM_ChkJhSaiteiS.OrderBM_ChkJhSaiteiSByPkAsc(chkJhSaiteiSDao.selectAll());
    }

    BM_ChkJhSaiteiS getChkJhSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto
        , Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom
        , Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {

        return chkJhSaiteiSDao.getChkJhSaiteiS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pDntsdnumufrom, pDntsdnumuto
            , pHrkkknsmnkbnfrom, pHrkkknsmnkbnto, pHknkknfrom, pHknkknto, pSaiteisknwtkumufrom
            , pSaiteisknwtkumuto, pTuukasyu);
    }

    List<BM_ChkJhSaiteiS> getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {

        return chkJhSaiteiSDao.getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(pSyouhncd, pSyouhnsdno, pHrkkeiro, pSaiteisknwtkumu, pTuukasyu);
    }

    List<BM_ChkJhSaiteiS> getChkJhSaiteiSsByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pDntsdnumufrom, Integer pDntsdnumuto, Integer pHrkkknsmnkbn
        , BizNumber pHknkkn, Integer pSaiteisknwtkumufrom, Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {

        return chkJhSaiteiSDao.getChkJhSaiteiSsByPk(pSyouhncd, pSyouhnsdno, pDntsdnumufrom, pDntsdnumuto, pHrkkknsmnkbn, pHknkkn, pSaiteisknwtkumufrom, pSaiteisknwtkumuto, pTuukasyu);
    }

    List<BM_ChkNenkinSaiteiS> getAllChkNenkinSaiteiS(){
        SortBM_ChkNenkinSaiteiS sortBM_ChkNenkinSaiteiS = new SortBM_ChkNenkinSaiteiS();
        return sortBM_ChkNenkinSaiteiS.OrderBM_ChkNenkinSaiteiSByPkAsc(chkNenkinSaiteiSDao.selectAll());
    }

    BM_ChkNenkinSaiteiS getChkNenkinSaiteiS(Integer pNenkinkkn, String pNenkinsyu) {

        return chkNenkinSaiteiSDao.getChkNenkinSaiteiS(pNenkinkkn, pNenkinsyu);
    }

    List<BM_ChkSaikouSSTani> getAllChkSaikouSSTani(){
        SortBM_ChkSaikouSSTani sortBM_ChkSaikouSSTani = new SortBM_ChkSaikouSSTani();
        return sortBM_ChkSaikouSSTani.OrderBM_ChkSaikouSSTaniByPkAsc(chkSaikouSSTaniDao.selectAll());
    }

    BM_ChkSaikouSSTani getChkSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {

        return chkSaikouSSTaniDao.getChkSaikouSSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto, pTuukasyu);
    }

    List<BM_ChkSaikouSSTani> getChkSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu) {


        return chkSaikouSSTaniDao.getChkSaikouSSTanisByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn, pTuukasyu);
    }

    List<BM_ChkJhSaikouSSTani> getAllChkJhSaikouSSTani(){
        SortBM_ChkJhSaikouSSTani sortBM_ChkJhSaikouSSTani = new SortBM_ChkJhSaikouSSTani();
        return sortBM_ChkJhSaikouSSTani.OrderBM_ChkJhSaikouSSTaniByPkAsc(chkJhSaikouSSTaniDao.selectAll());
    }

    BM_ChkJhSaikouSSTani getChkJhSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {

        return chkJhSaikouSSTaniDao.getChkJhSaikouSSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto, pTuukasyu);
    }

    List<BM_ChkJhSaikouSSTani> getChkJhSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu) {


        return chkJhSaikouSSTaniDao.getChkJhSaikouSSTanisByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn, pTuukasyu);
    }

    List<BM_ChkKeiyakuTaniSaikouS> getAllChkKeiyakuTaniSaikouS(){
        SortBM_ChkKeiyakuTaniSaikouS sortBM_ChkKeiyakuTaniSaikouS = new SortBM_ChkKeiyakuTaniSaikouS();
        return sortBM_ChkKeiyakuTaniSaikouS.OrderBM_ChkKeiyakuTaniSaikouSByPkAsc(chkKeiyakuTaniSaikouSDao.selectAll());
    }

    BM_ChkKeiyakuTaniSaikouS getChkKeiyakuTaniSaikouS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto) {

        return chkKeiyakuTaniSaikouSDao.getChkKeiyakuTaniSaikouS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto);
    }

    List<BM_ChkKeiyakuTaniSaikouS> getChkKeiyakuTaniSaikouSsByPk(String pSyouhncd, Integer pSyouhnsdno) {

        return chkKeiyakuTaniSaikouSDao.getChkKeiyakuTaniSaikouSsByPk(pSyouhncd, pSyouhnsdno);
    }

    List<BM_ChkKokutiJougenS> getAllChkKokutiJougenS(){
        SortBM_ChkKokutiJougenS sortBM_ChkKokutiJougenS = new SortBM_ChkKokutiJougenS();
        return sortBM_ChkKokutiJougenS.OrderBM_ChkKokutiJougenSByPkAsc(chkKokutiJougenSDao.selectAll());
    }

    BM_ChkKokutiJougenS getChkKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto) {

        return chkKokutiJougenSDao.getChkKokutiJougenS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto);
    }

    List<BM_ChkKokutiJougenS> getChkKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn) {

        return chkKokutiJougenSDao.getChkKokutiJougenSsByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn);
    }

    List<BM_ChkSyouhnKokutiJougenS> getAllChkSyouhnKokutiJougenS(){
        SortBM_ChkSyouhnKokutiJougenS sortBM_ChkSyouhnKokutiJougenS = new SortBM_ChkSyouhnKokutiJougenS();
        return sortBM_ChkSyouhnKokutiJougenS.OrderBM_ChkSyouhnKokutiJougenSByPkAsc(chkSyouhnKokutiJougenSDao.selectAll());
    }

    BM_ChkSyouhnKokutiJougenS getChkSyouhnKokutiJougenS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , Integer pMoskbnfrom, Integer pMoskbnto) {

        return chkSyouhnKokutiJougenSDao.getChkSyouhnKokutiJougenS(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pMoskbnfrom, pMoskbnto);
    }

    List<BM_ChkSyouhnKokutiJougenS> getChkSyouhnKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, Integer pMoskbn) {

        return chkSyouhnKokutiJougenSDao.getChkSyouhnKokutiJougenSsByPk(pSyouhncd, pSyouhnsdno, pHhknnen, pMoskbn);
    }

    List<BM_ChkNenkinSyurui> getAllChkNenkinSyurui(){
        SortBM_ChkNenkinSyurui sortBM_ChkNenkinSyurui = new SortBM_ChkNenkinSyurui();
        return sortBM_ChkNenkinSyurui.OrderBM_ChkNenkinSyuruiByPkAsc(chkNenkinSyuruiDao.selectAll());
    }

    BM_ChkNenkinSyurui getChkNenkinSyurui(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Sknenkinsyu pSknenkinsyu) {

        return chkNenkinSyuruiDao.getChkNenkinSyurui(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pSknenkinsyu);
    }

    List<BM_ChkTargetTkMokuhyouti> getAllChkTargetTkMokuhyouti(){
        SortBM_ChkTargetTkMokuhyouti sortBM_ChkTargetTkMokuhyouti = new SortBM_ChkTargetTkMokuhyouti();
        return sortBM_ChkTargetTkMokuhyouti.OrderBM_ChkTargetTkMokuhyoutiByPkAsc(chkTargetTkMokuhyoutiDao.selectAll());
    }

    BM_ChkTargetTkMokuhyouti getChkTargetTkMokuhyouti(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {

        return chkTargetTkMokuhyoutiDao.getChkTargetTkMokuhyouti(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd, pTargettkmokuhyouti);
    }

    List<BM_ChkTargetTkMokuhyouti> getChkTargetTkMokuhyoutisByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {

        return chkTargetTkMokuhyoutiDao.getChkTargetTkMokuhyoutisByPk(pSyouhncd, pSyouhnsdno, pChannelcd, pTargettkmokuhyouti);
    }


    List<BM_ChkKokutiTuusanS> getAllChkKokutiTuusanS(){
        SortBM_ChkKokutiTuusanS sortBM_ChkKokutiTuusanS = new SortBM_ChkKokutiTuusanS();
        return sortBM_ChkKokutiTuusanS.OrderBM_ChkKokutiTuusanSByPkAsc(chkKokutiTuusanSDao.selectAll());
    }

    BM_ChkKokutiTuusanS getChkKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto) {

        return chkKokutiTuusanSDao.getChkKokutiTuusanS(pHhknfromnen, pHhkntonen, pKijikbn, pIktkktkbnfrom, pIktkktkbnto);
    }

    List<BM_ChkKokutiTuusanS> getChkKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {

        return chkKokutiTuusanSDao.getChkKokutiTuusanSsByHhknnen(pHhknnen);
    }

    List<BM_ChkJhKokutiTuusanS> getAllChkJhKokutiTuusanS(){
        SortBM_ChkJhKokutiTuusanS sortBM_ChkJhKokutiTuusanS = new SortBM_ChkJhKokutiTuusanS();
        return sortBM_ChkJhKokutiTuusanS.OrderBM_ChkJhKokutiTuusanSByPkAsc(chkJhKokutiTuusanSDao.selectAll());
    }

    BM_ChkJhKokutiTuusanS getChkJhKokutiTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, C_KijiKbn pKijikbn, Integer pIktkktkbnfrom, Integer pIktkktkbnto) {

        return chkJhKokutiTuusanSDao.getChkJhKokutiTuusanS(pHhknfromnen, pHhkntonen, pKijikbn, pIktkktkbnfrom, pIktkktkbnto);
    }

    List<BM_ChkJhKokutiTuusanS> getChkJhKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {

        return chkJhKokutiTuusanSDao.getChkJhKokutiTuusanSsByHhknnen(pHhknnen);
    }

    List<BM_ChkTuusanS> getAllChkTuusanS(){
        SortBM_ChkTuusanS sortBM_ChkTuusanS = new SortBM_ChkTuusanS();
        return sortBM_ChkTuusanS.OrderBM_ChkTuusanSByPkAsc(chkTuusanSDao.selectAll());
    }

    BM_ChkTuusanS getChkTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkTuusanSDao.getChkTuusanS(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkTuusanS> getChkTuusanSsByPk(BizNumber pHhknnen) {

        return chkTuusanSDao.getChkTuusanSsByPk(pHhknnen);
    }

    List<BM_ChkJhTuusanS> getAllChkJhTuusanS(){
        SortBM_ChkJhTuusanS sortBM_ChkJhTuusanS = new SortBM_ChkJhTuusanS();
        return sortBM_ChkJhTuusanS.OrderBM_ChkJhTuusanSByPkAsc(chkJhTuusanSDao.selectAll());
    }

    BM_ChkJhTuusanS getChkJhTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkJhTuusanSDao.getChkJhTuusanS(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkJhTuusanS> getChkJhTuusanSsByPk(BizNumber pHhknnen) {

        return chkJhTuusanSDao.getChkJhTuusanSsByPk(pHhknnen);
    }

    List<BM_ChkNenreiNensyuuTuusanS> getAllChkNenreiNensyuuTuusanS(){
        SortBM_ChkNenreiNensyuuTuusanS sortBM_ChkNenreiNensyuuTuusanS = new SortBM_ChkNenreiNensyuuTuusanS();
        return sortBM_ChkNenreiNensyuuTuusanS.OrderBM_ChkNenreiNensyuuTuusanSByPkAsc(chkNenreiNensyuuTuusanSDao.selectAll());
    }

    BM_ChkNenreiNensyuuTuusanS getChkNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu) {

        return chkNenreiNensyuuTuusanSDao.getChkNenreiNensyuuTuusanS(pHhknfromnen, pHhkntonen, pHhknfromnensyuu, pHhkntonensyuu);
    }

    List<BM_ChkJhNenreiNensyuuTuusanS> getAllChkJhNenreiNensyuuTuusanS(){
        SortBM_ChkJhNenreiNensyuuTuusanS sortBM_ChkJhNenreiNensyuuTuusanS = new SortBM_ChkJhNenreiNensyuuTuusanS();
        return sortBM_ChkJhNenreiNensyuuTuusanS.OrderBM_ChkJhNenreiNensyuuTuusanSByPkAsc(chkJhNenreiNensyuuTuusanSDao.selectAll());
    }

    BM_ChkJhNenreiNensyuuTuusanS getChkJhNenreiNensyuuTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pHhknfromnensyuu, Integer pHhkntonensyuu) {

        return chkJhNenreiNensyuuTuusanSDao.getChkJhNenreiNensyuuTuusanS(pHhknfromnen, pHhkntonen, pHhknfromnensyuu, pHhkntonensyuu);
    }

    List<BM_ChkItijibrTuusanP> getAllChkItijibrTuusanP(){
        SortBM_ChkItijibrTuusanP sortBM_ChkItijibrTuusanP = new SortBM_ChkItijibrTuusanP();
        return sortBM_ChkItijibrTuusanP.OrderBM_ChkItijibrTuusanPByPkAsc(chkItijibrTuusanPDao.selectAll());
    }

    BM_ChkItijibrTuusanP getChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkItijibrTuusanPDao.getChkItijibrTuusanP(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkItijibrTuusanP> getChkItijibrTuusanPsByPK(BizNumber pHhknnen) {

        return chkItijibrTuusanPDao.getChkItijibrTuusanPsByPK(pHhknnen);
    }


    List<BM_ChkSyokugyou> getAllChkSyokugyou(){
        SortBM_ChkSyokugyou sortBM_ChkSyokugyou = new SortBM_ChkSyokugyou();
        return sortBM_ChkSyokugyou.OrderBM_ChkSyokugyouByPkAsc(chkSyokugyouDao.selectAll());
    }

    BM_ChkSyokugyou getChkSyokugyou(String pSyokugyoucd) {

        return chkSyokugyouDao.getChkSyokugyou(pSyokugyoucd);
    }

    List<BM_ChkNkgns> getAllChkNkgns(){
        SortBM_ChkNkgns sortBM_ChkNkgns = new SortBM_ChkNkgns();
        return sortBM_ChkNkgns.OrderBM_ChkNkgnsByPkAsc(chkNkgnsDao.selectAll());
    }

    BM_ChkNkgns getChkNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkNkgnsDao.getChkNkgns(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkNkgns> getChkNkgnssByPK(BizNumber pHhknnen) {


        return chkNkgnsDao.getChkNkgnssByPK(pHhknnen);
    }


    List<BM_ChkJhNkgns> getAllChkJhNkgns(){
        SortBM_ChkJhNkgns sortBM_ChkJhNkgns = new SortBM_ChkJhNkgns();
        return sortBM_ChkJhNkgns.OrderBM_ChkJhNkgnsByPkAsc(chkJhNkgnsDao.selectAll());
    }

    BM_ChkJhNkgns getChkJhNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkJhNkgnsDao.getChkJhNkgns(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkJhNkgns> getChkJhNkgnssByPK(BizNumber pHhknnen) {


        return chkJhNkgnsDao.getChkJhNkgnssByPK(pHhknnen);
    }

    List<BM_ChkItijibrTuusanS> getAllChkItijibrTuusanS(){
        SortBM_ChkItijibrTuusanS sortBM_ChkItijibrTuusanS = new SortBM_ChkItijibrTuusanS();
        return sortBM_ChkItijibrTuusanS.OrderBM_ChkItijibrTuusanSByPkAsc(chkItijibrTuusanSDao.selectAll());
    }

    BM_ChkItijibrTuusanS getChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkItijibrTuusanSDao.getChkItijibrTuusanS(pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkItijibrTuusanS> getChkItijibrTuusanSsByPK(BizNumber pHhknnen) {


        return chkItijibrTuusanSDao.getChkItijibrTuusanSsByPK(pHhknnen);
    }

    List<BM_ChkKykDairitenTuusanS> getAllChkKykDairitenTuusanS(){
        SortBM_ChkKykDairitenTuusanS sortBM_ChkKykDairitenTuusanS = new SortBM_ChkKykDairitenTuusanS();
        return sortBM_ChkKykDairitenTuusanS.OrderBM_ChkKykDairitenTuusanSByPkAsc(chkKykDairitenTuusanSDao.selectAll());
    }

    BM_ChkKykDairitenTuusanS getChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {

        return chkKykDairitenTuusanSDao.getChkKykDairitenTuusanS(pKihonssyuruikbn);
    }

    List<BM_ChkNensyuuBairitu> getAllChkNensyuuBairitu(){
        SortBM_ChkNensyuuBairitu sortBM_ChkNensyuuBairitu = new SortBM_ChkNensyuuBairitu();
        return sortBM_ChkNensyuuBairitu.OrderBM_ChkNensyuuBairituByPkAsc(chkNensyuuBairituDao.selectAll());
    }

    BM_ChkNensyuuBairitu getChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {

        return chkNensyuuBairituDao.getChkNensyuuBairitu(pNensyuukbn);
    }

    List<BM_ChkSaiteiP> getAllChkSaiteiP(){
        SortBM_ChkSaiteiP sortBM_ChkSaiteiP = new SortBM_ChkSaiteiP();
        return sortBM_ChkSaiteiP.OrderBM_ChkSaiteiPByPkAsc(chkSaiteiPDao.selectAll());
    }

    List<BM_ChkSaiteiP> getChkSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {


        return chkSaiteiPDao.getChkSaiteiPsByPk(pSyouhncd, pChannelcd, pHrkkaisuu, pHrkkkny,
            pSyouhnsdno, pTuukasyu, pSyouhinbetukey1);
    }

    BM_ChkSaiteiP getChkSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {

        return chkSaiteiPDao.getChkSaiteiP(pSyouhncd, pHrkkaisuu, pHrkkknfrom, pHrkkknto, pSyusyouhnsdnofrom
            , pSyusyouhnsdnoto, pChannelcd, pTuukasyu, pSyouhinbetukey1);
    }

    List<BM_ChkJhSaiteiP> getAllChkJhSaiteiP(){
        SortBM_ChkJhSaiteiP sortBM_ChkJhSaiteiP = new SortBM_ChkJhSaiteiP();
        return sortBM_ChkJhSaiteiP.OrderBM_ChkJhSaiteiPByPkAsc(chkJhSaiteiPDao.selectAll());
    }

    List<BM_ChkJhSaiteiP> getChkJhSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno
        , C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {


        return chkJhSaiteiPDao.getChkJhSaiteiPsByPk(pSyouhncd, pChannelcd, pHrkkaisuu, pHrkkkny, pSyouhnsdno,
            pTuukasyu, pSyouhinbetukey1);
    }

    BM_ChkJhSaiteiP getChkJhSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom
        , Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {

        return chkJhSaiteiPDao.getChkJhSaiteiP(pSyouhncd, pHrkkaisuu, pHrkkknfrom, pHrkkknto, pSyusyouhnsdnofrom
            , pSyusyouhnsdnoto, pChannelcd, pTuukasyu, pSyouhinbetukey1);
    }

    List<BM_ChkSTani> getAllChkSTani(){
        SortBM_ChkSTani sortBM_ChkSTani = new SortBM_ChkSTani();
        return sortBM_ChkSTani.OrderBM_ChkSTaniByPkAsc(chkSTaniDao.selectAll());
    }

    BM_ChkSTani getChkSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen
        , C_Tuukasyu pTuukasyu) {

        return chkSTaniDao.getChkSTani(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen
            , pTuukasyu);
    }

    List<BM_ChkSTani> getChkSTanisByPK(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, C_Tuukasyu pTuukasyu) {

        return chkSTaniDao.getChkSTanisByPK(pSyouhncd, pSyouhnsdno, pHhknnen, pTuukasyu);
    }

    List<BM_ChkHrkPTani> getAllChkHrkPTani(){
        SortBM_ChkHrkPTani sortBM_ChkHrkPTani = new SortBM_ChkHrkPTani();
        return sortBM_ChkHrkPTani.OrderBM_ChkHrkPTaniByPkAsc(chkHrkPTaniDao.selectAll());
    }

    BM_ChkHrkPTani getChkHrkPTani(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd
        , C_Tuukasyu pHrktuukasyu) {

        return chkHrkPTaniDao.getChkHrkPTani(pSyouhncd, pHrkkaisuu, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd
            , pHrktuukasyu);
    }

    List<BM_ChkHrkPTani> getChkHrkPTanisByPK(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_Tuukasyu pHrktuukasyu) {

        return chkHrkPTaniDao.getChkHrkPTanisByPK(pSyouhncd, pHrkkaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu);
    }

    List<BM_ChkNkgnsHonken> getAllChkNkgnsHonken(){
        SortBM_ChkNkgnsHonken sortBM_ChkNkgnsHonken = new SortBM_ChkNkgnsHonken();
        return sortBM_ChkNkgnsHonken.OrderBM_ChkNkgnsHonkenByPkAsc(chkNkgnsHonkenDao.selectAll());
    }

    BM_ChkNkgnsHonken getChkNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkNkgnsHonkenDao.getChkNkgnsHonken(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkJhNkgnsHonken> getAllChkJhNkgnsHonken(){
        SortBM_ChkJhNkgnsHonken sortBM_ChkJhNkgnsHonken = new SortBM_ChkJhNkgnsHonken();
        return sortBM_ChkJhNkgnsHonken.OrderBM_ChkJhNkgnsHonkenByPkAsc(chkJhNkgnsHonkenDao.selectAll());
    }

    BM_ChkJhNkgnsHonken getChkJhNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {

        return chkJhNkgnsHonkenDao.getChkJhNkgnsHonken(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknfromnen, pHhkntonen);
    }

    List<BM_ChkSueokiKikan> getAllChkSueokiKikan(){
        SortBM_ChkSueokiKikan sortBM_ChkSueokiKikan = new SortBM_ChkSueokiKikan();
        return sortBM_ChkSueokiKikan.OrderBM_ChkSueokiKikanByPkAsc(chkSueokiKikanDao.selectAll());
    }

    BM_ChkSueokiKikan getChkSueokiKikan(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pSueokikkn
        , C_SueokikknsmnKbn pSueokikknsmnkbn) {

        return chkSueokiKikanDao.getChkSueokiKikan(pSyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pChannelcd, pSueokikkn
            , pSueokikknsmnkbn);
    }

    List<BM_ChkSueokiKikan> getChkSueokiKikansByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pSueokikkn, C_SueokikknsmnKbn pSueokikknsmnkbn) {

        return chkSueokiKikanDao.getChkSueokiKikansByPk(pSyouhncd, pSyouhnsdno, pChannelcd, pSueokikkn, pSueokikknsmnkbn);
    }

    List<BM_ChkNkgnsHonken> getChkNkgnsHonkenByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pHhknnen) {

        return chkNkgnsHonkenDao.getChkNkgnsHonkenByPk(pSyouhncd, pSyouhnsdno, pHhknnen);
    }

    List<BM_ChkNenreiHani2> getAllChkNenreiHani2(){
        SortBM_ChkNenreiHani2 sortBM_ChkNenreiHani2 = new SortBM_ChkNenreiHani2();
        return sortBM_ChkNenreiHani2.OrderBM_ChkNenreiHani2ByPkAsc(chkNenreiHani2Dao.selectAll());
    }

    BM_ChkNenreiHani2 getChkNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {

        return chkNenreiHani2Dao.getChkNenreiHani2(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknseifrom
            , pHhknseito, pSyukatakbn, pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn
            , pSyuhrkkkn, pSyuhrkkknto, pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen
            , pSyuyoteiriritufrom, pSyuyoteirirituto, pSyudai1hknkkn, pTokusyuchkno
            , pTksyouhncd, pTkhknkkn, pTkhknkknto, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknto, pTkhrkkknsmnkbn, pTkfromnen, pTktonen);
    }

    List<BM_ChkJhNenreiHani2> getAllChkJhNenreiHani2(){
        SortBM_ChkJhNenreiHani2 sortBM_ChkJhNenreiHani2 = new SortBM_ChkJhNenreiHani2();
        return sortBM_ChkJhNenreiHani2.OrderBM_ChkJhNenreiHani2ByPkAsc(chkJhNenreiHani2Dao.selectAll());
    }

    BM_ChkJhNenreiHani2 getChkJhNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom
        , Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn
        , Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen
        , BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno
        , String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {

        return chkJhNenreiHani2Dao.getChkJhNenreiHani2(pChannelcd, pSyusyouhncd, pSyusyouhnsdnofrom, pSyusyouhnsdnoto, pHhknseifrom
            , pHhknseito, pSyukatakbn, pSyuhknkkn, pSyuhknkknto, pSyuhknkknsmnkbn
            , pSyuhrkkkn, pSyuhrkkknto, pSyuhrkkknsmnkbn, pSyufromnen, pSyutonen
            , pSyuyoteiriritufrom, pSyuyoteirirituto, pSyudai1hknkkn, pTokusyuchkno
            , pTksyouhncd, pTkhknkkn, pTkhknkknto, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknto, pTkhrkkknsmnkbn, pTkfromnen, pTktonen);
    }

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {

        return chkNenreiHani2Dao.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {

        return chkNenreiHani2Dao.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSyuyoteiriritu
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pSyukatakbnumu, pTkykmossyouhnumu);
    }

    List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, int pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {

        return chkNenreiHani2Dao.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbnumu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSyuyoteiriritu
            , pSyudai1hknkkn, pSeibetu, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    Long getChkNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {

        return chkNenreiHani2Dao.getChkNenreiHani2CountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn
            , pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen , pSyuyoteiriritu, pSyudai1hknkkn);
    }

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pTkykmossyouhnumu) {

        return chkJhNenreiHani2Dao.getChkJhNenreiHani2sByPkTkykmossyouhnumu(pChannelcd, pSyusyouhncd, pSyouhnsdno, pNen, pSeibetu, pSyukatakbn
            , pSyuhknkkn, pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn
            , pSyudai1hknkkn, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn, pTkhrkkkn
            , pTkhrkkknsmnkbn, pTkykmossyouhnumu);
    }

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , int pSeibetu, BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {

        return chkJhNenreiHani2Dao.getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pNen
            , pSeibetu, pSyuyoteiriritu, pSyudai1hknkkn, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn
            , pTkhknkknsmnkbn, pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, int pSeibetu
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {

        return chkJhNenreiHani2Dao.getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(pChannelcd, pSyusyouhncd, pSyouhnsdno, pSyukatakbn, pSyuhknkkn
            , pSyuhknkknsmnkbn, pSyuhrkkkn, pSyuhrkkknsmnkbn, pSeibetu
            , pSyuyoteiriritu, pSyudai1hknkkn, pTkykmossyouhnumu, pTksyouhncd, pTkhknkkn, pTkhknkknsmnkbn
            , pTkhrkkkn, pTkhrkkknsmnkbn);
    }

    Long getChkJhNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {

        return chkJhNenreiHani2Dao.getChkJhNenreiHani2CountByPkHhknsei(pChannelcd, pSyouhncd, pSyouhnsdno, pHhknsei, pKatakbn
            , pHknkkn, pHknkknsmnkbn, pHrkkkn, pHrkkknsmnkbn, pHhknnen, pSyuyoteiriritu, pSyudai1hknkkn);
    }

}
