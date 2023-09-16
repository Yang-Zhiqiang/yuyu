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
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.meta.QBM_ChkNenreiHani2;

/**
 * 年齢範囲チェックマスタ２(BM_ChkNenreiHani2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNenreiHani2Dao extends AbstractDao<BM_ChkNenreiHani2> {

    public BM_ChkNenreiHani2Dao() {
        super(BM_ChkNenreiHani2.class);
    }

    public BM_ChkNenreiHani2 getChkNenreiHani2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pHhknseifrom, Integer pHhknseito, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, Integer pSyudai1hknkkn, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        BM_ChkNenreiHani2 bM_ChkNenreiHani2 =  new BM_ChkNenreiHani2();
        bM_ChkNenreiHani2.setChannelcd(pChannelcd);
        bM_ChkNenreiHani2.setSyusyouhncd(pSyusyouhncd);
        bM_ChkNenreiHani2.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkNenreiHani2.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkNenreiHani2.setHhknseifrom(pHhknseifrom);
        bM_ChkNenreiHani2.setHhknseito(pHhknseito);
        bM_ChkNenreiHani2.setSyukatakbn(pSyukatakbn);
        bM_ChkNenreiHani2.setSyuhknkkn(pSyuhknkkn);
        bM_ChkNenreiHani2.setSyuhknkknto(pSyuhknkknto);
        bM_ChkNenreiHani2.setSyuhknkknsmnkbn(pSyuhknkknsmnkbn);
        bM_ChkNenreiHani2.setSyuhrkkkn(pSyuhrkkkn);
        bM_ChkNenreiHani2.setSyuhrkkknto(pSyuhrkkknto);
        bM_ChkNenreiHani2.setSyuhrkkknsmnkbn(pSyuhrkkknsmnkbn);
        bM_ChkNenreiHani2.setSyufromnen(pSyufromnen);
        bM_ChkNenreiHani2.setSyutonen(pSyutonen);
        bM_ChkNenreiHani2.setSyuyoteiriritufrom(pSyuyoteiriritufrom);
        bM_ChkNenreiHani2.setSyuyoteirirituto(pSyuyoteirirituto);
        bM_ChkNenreiHani2.setSyudai1hknkkn(pSyudai1hknkkn);
        bM_ChkNenreiHani2.setTokusyuchkno(pTokusyuchkno);
        bM_ChkNenreiHani2.setTksyouhncd(pTksyouhncd);
        bM_ChkNenreiHani2.setTkhknkkn(pTkhknkkn);
        bM_ChkNenreiHani2.setTkhknkknto(pTkhknkknto);
        bM_ChkNenreiHani2.setTkhknkknsmnkbn(pTkhknkknsmnkbn);
        bM_ChkNenreiHani2.setTkhrkkkn(pTkhrkkkn);
        bM_ChkNenreiHani2.setTkhrkkknto(pTkhrkkknto);
        bM_ChkNenreiHani2.setTkhrkkknsmnkbn(pTkhrkkknsmnkbn);
        bM_ChkNenreiHani2.setTkfromnen(pTkfromnen);
        bM_ChkNenreiHani2.setTktonen(pTktonen);
        return this.selectOne(bM_ChkNenreiHani2);
    }

    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkNenreiHani2 qBM_ChkNenreiHani2 = new QBM_ChkNenreiHani2("qBM_ChkNenreiHani2");


        String strSql = $SELECT + qBM_ChkNenreiHani2 +
            $FROM(qBM_ChkNenreiHani2) +
            $WHERE + qBM_ChkNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn) +
            $AND + qBM_ChkNenreiHani2.syufromnen.le(pNen) +
            $AND + qBM_ChkNenreiHani2.syutonen.ge(pNen) +
            $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.tkfromnen.le(pNen) +
                $AND + qBM_ChkNenreiHani2.tktonen.ge(pNen) +
                $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(strSql).bind(qBM_ChkNenreiHani2).getResultList();
    }

    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, int pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn
        , C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkNenreiHani2 qBM_ChkNenreiHani2 = new QBM_ChkNenreiHani2("qBM_ChkNenreiHani2");


        String strSql = $SELECT + qBM_ChkNenreiHani2 +
            $FROM(qBM_ChkNenreiHani2) +
            $WHERE + qBM_ChkNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syufromnen.le(pNen) +
            $AND + qBM_ChkNenreiHani2.syutonen.ge(pNen) +
            $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.tkfromnen.le(pNen) +
                $AND + qBM_ChkNenreiHani2.tktonen.ge(pNen) +
                $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(strSql).bind(qBM_ChkNenreiHani2).getResultList();
    }

    public List<BM_ChkNenreiHani2> getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyuyoteiriritu
        , Integer pSyudai1hknkkn, int pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn
        , C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkNenreiHani2 qBM_ChkNenreiHani2 = new QBM_ChkNenreiHani2("qBM_ChkNenreiHani2");


        String strSql = $SELECT + qBM_ChkNenreiHani2 +
            $FROM(qBM_ChkNenreiHani2) +
            $WHERE + qBM_ChkNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani2.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {

            strSql = strSql + $AND + qBM_ChkNenreiHani2.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani2.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani2.tkhknkknto.ge(Integer.valueOf(pTkhknkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknto.ge(Integer.valueOf(pTkhrkkkn.toString())) +
                $AND + qBM_ChkNenreiHani2.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani2.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(strSql).bind(qBM_ChkNenreiHani2).getResultList();
    }

    public Long getChkNenreiHani2CountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno, int pHhknsei, C_KataKbn pKatakbn
        , Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen
        , BizNumber pSyuyoteiriritu, Integer pSyudai1hknkkn) {


        QBM_ChkNenreiHani2 qBM_ChkNenreiHani2 = new QBM_ChkNenreiHani2("qBM_ChkNenreiHani2");


        String strSql =  $SELECT + $COUNT + "(*)" +
            $FROM(qBM_ChkNenreiHani2) +
            $WHERE + qBM_ChkNenreiHani2.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani2.syusyouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani2.hhknseifrom.le(pHhknsei) +
            $AND + qBM_ChkNenreiHani2.hhknseito.ge(pHhknsei) +
            $AND + qBM_ChkNenreiHani2.syukatakbn.eq(pKatakbn) +
            $AND + qBM_ChkNenreiHani2.syuhknkkn.le(pHknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknto.ge(pHknkkn) +
            $AND + qBM_ChkNenreiHani2.syuhknkknsmnkbn.eq(pHknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkkn.le(pHrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknto.ge(pHrkkkn) +
            $AND + qBM_ChkNenreiHani2.syuhrkkknsmnkbn.eq(pHrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani2.syufromnen.le(pHhknnen) +
            $AND + qBM_ChkNenreiHani2.syutonen.ge(pHhknnen) +
            $AND + qBM_ChkNenreiHani2.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syuyoteirirituto.ge(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani2.syudai1hknkkn.eq(pSyudai1hknkkn);

        return em.createJPQL(strSql).bind(qBM_ChkNenreiHani2).getSingleResult();
    }
}
