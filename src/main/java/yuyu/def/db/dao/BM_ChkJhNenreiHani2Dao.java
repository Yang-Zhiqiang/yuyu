package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkJhNenreiHani2;
import yuyu.def.db.meta.QBM_ChkJhNenreiHani2;

/**
 * 年齢範囲事方書チェックマスタ２(BM_ChkJhNenreiHani2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhNenreiHani2Dao extends AbstractDao<BM_ChkJhNenreiHani2> {

    public BM_ChkJhNenreiHani2Dao() {
        super(BM_ChkJhNenreiHani2.class);
    }

    public BM_ChkJhNenreiHani2 getChkJhNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom, Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        BM_ChkJhNenreiHani2 bM_ChkJhNenreiHani2 =  new BM_ChkJhNenreiHani2();
        bM_ChkJhNenreiHani2.setChannelcd(pChannelcd);
        bM_ChkJhNenreiHani2.setSyusyouhncd(pSyusyouhncd);
        bM_ChkJhNenreiHani2.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhNenreiHani2.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhNenreiHani2.setHhknseifrom(pHhknseifrom);
        bM_ChkJhNenreiHani2.setHhknseito(pHhknseito);
        bM_ChkJhNenreiHani2.setSyukatakbn(pSyukatakbn);
        bM_ChkJhNenreiHani2.setSyuhknkkn(pSyuhknkkn);
        bM_ChkJhNenreiHani2.setSyuhknkknto(pSyuhknkknto);
        bM_ChkJhNenreiHani2.setSyuhknkknsmnkbn(pSyuhknkknsmnkbn);
        bM_ChkJhNenreiHani2.setSyuhrkkkn(pSyuhrkkkn);
        bM_ChkJhNenreiHani2.setSyuhrkkknto(pSyuhrkkknto);
        bM_ChkJhNenreiHani2.setSyuhrkkknsmnkbn(pSyuhrkkknsmnkbn);
        bM_ChkJhNenreiHani2.setSyufromnen(pSyufromnen);
        bM_ChkJhNenreiHani2.setSyutonen(pSyutonen);
        bM_ChkJhNenreiHani2.setSyuyoteiriritufrom(pSyuyoteiriritufrom);
        bM_ChkJhNenreiHani2.setSyuyoteirirituto(pSyuyoteirirituto);
        bM_ChkJhNenreiHani2.setSyudai1hknkkn(pSyudai1hknkkn);
        bM_ChkJhNenreiHani2.setTokusyuchkno(pTokusyuchkno);
        bM_ChkJhNenreiHani2.setTksyouhncd(pTksyouhncd);
        bM_ChkJhNenreiHani2.setTkhknkkn(pTkhknkkn);
        bM_ChkJhNenreiHani2.setTkhknkknto(pTkhknkknto);
        bM_ChkJhNenreiHani2.setTkhknkknsmnkbn(pTkhknkknsmnkbn);
        bM_ChkJhNenreiHani2.setTkhrkkkn(pTkhrkkkn);
        bM_ChkJhNenreiHani2.setTkhrkkknto(pTkhrkkknto);
        bM_ChkJhNenreiHani2.setTkhrkkknsmnkbn(pTkhrkkknsmnkbn);
        bM_ChkJhNenreiHani2.setTkfromnen(pTkfromnen);
        bM_ChkJhNenreiHani2.setTktonen(pTktonen);
        return this.selectOne(bM_ChkJhNenreiHani2);
    }

    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkJhNenreiHani2 qBM_ChkJhNenreiHani2 = new QBM_ChkJhNenreiHani2("qBM_ChkJhNenreiHani2");


        String querySql = $SELECT + qBM_ChkJhNenreiHani2 +
            $FROM(qBM_ChkJhNenreiHani2) +
            $WHERE + qBM_ChkJhNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syufromnen.le(pNen) +
            $AND + qBM_ChkJhNenreiHani2.syutonen.ge(pNen) +
            $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu);


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.tkfromnen.le(pNen) +
                $AND + qBM_ChkJhNenreiHani2.tktonen.ge(pNen) +
                $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani2).getResultList();
    }

    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen
        , int pSeibetu, BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkJhNenreiHani2 qBM_ChkJhNenreiHani2 = new QBM_ChkJhNenreiHani2("qBM_ChkJhNenreiHani2");


        String querySql = $SELECT + qBM_ChkJhNenreiHani2 +
            $FROM(qBM_ChkJhNenreiHani2) +
            $WHERE + qBM_ChkJhNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syufromnen.le(pNen) +
            $AND + qBM_ChkJhNenreiHani2.syutonen.ge(pNen) +
            $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);



        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.tkfromnen.le(pNen) +
                $AND + qBM_ChkJhNenreiHani2.tktonen.ge(pNen) +
                $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani2).getResultList();
    }

    public List<BM_ChkJhNenreiHani2> getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn
        , C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, int pSeibetu
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn
        , BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkJhNenreiHani2 qBM_ChkJhNenreiHani2 = new QBM_ChkJhNenreiHani2("qBM_ChkJhNenreiHani2");


        String querySql = $SELECT + qBM_ChkJhNenreiHani2 +
            $FROM(qBM_ChkJhNenreiHani2) +
            $WHERE + qBM_ChkJhNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);



        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkJhNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani2).getResultList();
    }

    public Long getChkJhNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {


        QBM_ChkJhNenreiHani2 qBM_ChkJhNenreiHani2 = new QBM_ChkJhNenreiHani2("qBM_ChkJhNenreiHani2");


        String querySql =  $SELECT + $COUNT + "(*)" +
            $FROM(qBM_ChkJhNenreiHani2) +
            $WHERE + qBM_ChkJhNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani2.hhknseifrom.le(pHhknsei) +
            $AND + qBM_ChkJhNenreiHani2.hhknseito.ge(pHhknsei) +
            $AND + qBM_ChkJhNenreiHani2.syukatakbn.eq(pKatakbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkkn.le(pHknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknto.ge(pHknkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhknkknsmnkbn.eq(pHknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkkn.le(pHrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknto.ge(pHrkkkn) +
            $AND + qBM_ChkJhNenreiHani2.syuhrkkknsmnkbn.eq(pHrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani2.syufromnen.le(pHhknnen) +
            $AND + qBM_ChkJhNenreiHani2.syutonen.ge(pHhknnen) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani2).getSingleResult();
    }
}
