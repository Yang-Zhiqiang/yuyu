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
import yuyu.def.db.entity.BM_ChkJhNenreiHani;
import yuyu.def.db.meta.QBM_ChkJhNenreiHani;

/**
 * 年齢範囲事方書チェックマスタ(BM_ChkJhNenreiHaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhNenreiHaniDao extends AbstractDao<BM_ChkJhNenreiHani> {

    public BM_ChkJhNenreiHaniDao() {
        super(BM_ChkJhNenreiHani.class);
    }

    public BM_ChkJhNenreiHani getChkJhNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        BM_ChkJhNenreiHani bM_ChkJhNenreiHani =  new BM_ChkJhNenreiHani();
        bM_ChkJhNenreiHani.setChannelcd(pChannelcd);
        bM_ChkJhNenreiHani.setSyusyouhncd(pSyusyouhncd);
        bM_ChkJhNenreiHani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhNenreiHani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhNenreiHani.setSyukatakbn(pSyukatakbn);
        bM_ChkJhNenreiHani.setSyuhknkkn(pSyuhknkkn);
        bM_ChkJhNenreiHani.setSyuhknkknto(pSyuhknkknto);
        bM_ChkJhNenreiHani.setSyuhknkknsmnkbn(pSyuhknkknsmnkbn);
        bM_ChkJhNenreiHani.setSyuhrkkkn(pSyuhrkkkn);
        bM_ChkJhNenreiHani.setSyuhrkkknto(pSyuhrkkknto);
        bM_ChkJhNenreiHani.setSyuhrkkknsmnkbn(pSyuhrkkknsmnkbn);
        bM_ChkJhNenreiHani.setSyufromnen(pSyufromnen);
        bM_ChkJhNenreiHani.setSyutonen(pSyutonen);
        bM_ChkJhNenreiHani.setSyuyoteiriritufrom(pSyuyoteiriritufrom);
        bM_ChkJhNenreiHani.setSyuyoteirirituto(pSyuyoteirirituto);
        bM_ChkJhNenreiHani.setTokusyuchkno(pTokusyuchkno);
        bM_ChkJhNenreiHani.setTksyouhncd(pTksyouhncd);
        bM_ChkJhNenreiHani.setTkhknkkn(pTkhknkkn);
        bM_ChkJhNenreiHani.setTkhknkknto(pTkhknkknto);
        bM_ChkJhNenreiHani.setTkhknkknsmnkbn(pTkhknkknsmnkbn);
        bM_ChkJhNenreiHani.setTkhrkkkn(pTkhrkkkn);
        bM_ChkJhNenreiHani.setTkhrkkknto(pTkhrkkknto);
        bM_ChkJhNenreiHani.setTkhrkkknsmnkbn(pTkhrkkknsmnkbn);
        bM_ChkJhNenreiHani.setTkfromnen(pTkfromnen);
        bM_ChkJhNenreiHani.setTktonen(pTktonen);
        return this.selectOne(bM_ChkJhNenreiHani);
    }

    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumu(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn
        , Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn
        , String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn
        , C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkJhNenreiHani qBM_ChkJhNenreiHani = new QBM_ChkJhNenreiHani();


        String querySql = $SELECT + qBM_ChkJhNenreiHani +
            $FROM + qBM_ChkJhNenreiHani.BM_ChkJhNenreiHani() +
            $WHERE + qBM_ChkJhNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syufromnen.le(pNen) +
            $AND + qBM_ChkJhNenreiHani.syutonen.ge(pNen) +
            $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu);


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.tkfromnen.le(pNen) +
                $AND + qBM_ChkJhNenreiHani.tktonen.ge(pNen) +
                $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani).getResultList();
    }


    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd,
        String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn,
        C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pNen,
        Integer pSeibetu, BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd,
        BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkJhNenreiHani qBM_ChkJhNenreiHani = new QBM_ChkJhNenreiHani();


        String querySql = $SELECT + qBM_ChkJhNenreiHani +
            $FROM + qBM_ChkJhNenreiHani.BM_ChkJhNenreiHani() +
            $WHERE + qBM_ChkJhNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syufromnen.le(pNen) +
            $AND + qBM_ChkJhNenreiHani.syutonen.ge(pNen) +
            $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.tkfromnen.le(pNen) +
                $AND + qBM_ChkJhNenreiHani.tktonen.ge(pNen) +
                $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani).getResultList();
    }

    public List<BM_ChkJhNenreiHani> getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd,
        String pSyusyouhncd, Integer pSyouhnsdno, C_KataKbn pSyukatakbn, Integer pSyuhknkkn,
        C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, Integer pSeibetu,
        BizNumber pSyuyoteiriritu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd, BizNumber pTkhknkkn,
        C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkJhNenreiHani qBM_ChkJhNenreiHani = new QBM_ChkJhNenreiHani();


        String querySql = $SELECT + qBM_ChkJhNenreiHani +
            $FROM + qBM_ChkJhNenreiHani.BM_ChkJhNenreiHani() +
            $WHERE + qBM_ChkJhNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syukatakbn.eq(pSyukatakbn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkJhNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkJhNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkJhNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkJhNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pSeibetu);
        }


        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani).getResultList();
    }

    public Long getChkJhNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno,
        Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {


        QBM_ChkJhNenreiHani qBM_ChkJhNenreiHani = new QBM_ChkJhNenreiHani();


        String querySql = $SELECT + $COUNT +"(*)"+
            $FROM + qBM_ChkJhNenreiHani.BM_ChkJhNenreiHani() +
            $WHERE + qBM_ChkJhNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhNenreiHani.hhknseifrom.le(pHhknsei) +
            $AND + qBM_ChkJhNenreiHani.hhknseito.ge(pHhknsei) +
            $AND + qBM_ChkJhNenreiHani.syukatakbn.eq(pKatakbn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkkn.le(pHknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknto.ge(pHknkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhknkknsmnkbn.eq(pHknkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkkn.le(pHrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknto.ge(pHrkkkn) +
            $AND + qBM_ChkJhNenreiHani.syuhrkkknsmnkbn.eq(pHrkkknsmnkbn) +
            $AND + qBM_ChkJhNenreiHani.syufromnen.le(pHhknnen) +
            $AND + qBM_ChkJhNenreiHani.syutonen.ge(pHhknnen) +
            $AND + qBM_ChkJhNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkJhNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);

        return em.createJPQL(querySql).bind(qBM_ChkJhNenreiHani).getSingleResult();
    }
}
