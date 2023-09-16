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
import yuyu.def.db.entity.BM_ChkNenreiHani;
import yuyu.def.db.meta.QBM_ChkNenreiHani;

/**
 * 年齢範囲チェックマスタ(BM_ChkNenreiHaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNenreiHaniDao extends AbstractDao<BM_ChkNenreiHani> {

    public BM_ChkNenreiHaniDao() {
        super(BM_ChkNenreiHani.class);
    }

    public BM_ChkNenreiHani getChkNenreiHani(C_Channelcd pChannelcd, String pSyusyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_KataKbn pSyukatakbn, Integer pSyuhknkkn, Integer pSyuhknkknto, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, Integer pSyuhrkkknto, C_HrkkknsmnKbn pSyuhrkkknsmnkbn, BizNumber pSyufromnen, BizNumber pSyutonen, BizNumber pSyuyoteiriritufrom, BizNumber pSyuyoteirirituto, BizNumber pTokusyuchkno, String pTksyouhncd, BizNumber pTkhknkkn, Integer pTkhknkknto, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, Integer pTkhrkkknto, C_HrkkknsmnKbn pTkhrkkknsmnkbn, BizNumber pTkfromnen, BizNumber pTktonen) {
        BM_ChkNenreiHani bM_ChkNenreiHani =  new BM_ChkNenreiHani();
        bM_ChkNenreiHani.setChannelcd(pChannelcd);
        bM_ChkNenreiHani.setSyusyouhncd(pSyusyouhncd);
        bM_ChkNenreiHani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkNenreiHani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkNenreiHani.setSyukatakbn(pSyukatakbn);
        bM_ChkNenreiHani.setSyuhknkkn(pSyuhknkkn);
        bM_ChkNenreiHani.setSyuhknkknto(pSyuhknkknto);
        bM_ChkNenreiHani.setSyuhknkknsmnkbn(pSyuhknkknsmnkbn);
        bM_ChkNenreiHani.setSyuhrkkkn(pSyuhrkkkn);
        bM_ChkNenreiHani.setSyuhrkkknto(pSyuhrkkknto);
        bM_ChkNenreiHani.setSyuhrkkknsmnkbn(pSyuhrkkknsmnkbn);
        bM_ChkNenreiHani.setSyufromnen(pSyufromnen);
        bM_ChkNenreiHani.setSyutonen(pSyutonen);
        bM_ChkNenreiHani.setSyuyoteiriritufrom(pSyuyoteiriritufrom);
        bM_ChkNenreiHani.setSyuyoteirirituto(pSyuyoteirirituto);
        bM_ChkNenreiHani.setTokusyuchkno(pTokusyuchkno);
        bM_ChkNenreiHani.setTksyouhncd(pTksyouhncd);
        bM_ChkNenreiHani.setTkhknkkn(pTkhknkkn);
        bM_ChkNenreiHani.setTkhknkknto(pTkhknkknto);
        bM_ChkNenreiHani.setTkhknkknsmnkbn(pTkhknkknsmnkbn);
        bM_ChkNenreiHani.setTkhrkkkn(pTkhrkkkn);
        bM_ChkNenreiHani.setTkhrkkknto(pTkhrkkknto);
        bM_ChkNenreiHani.setTkhrkkknsmnkbn(pTkhrkkknsmnkbn);
        bM_ChkNenreiHani.setTkfromnen(pTkfromnen);
        bM_ChkNenreiHani.setTktonen(pTktonen);
        return this.selectOne(bM_ChkNenreiHani);
    }

    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(C_Channelcd pChannelcd,
        String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn,
        Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn,
        C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkNenreiHani qBM_ChkNenreiHani = new QBM_ChkNenreiHani();


        String querySql = $SELECT + qBM_ChkNenreiHani +
            $FROM + qBM_ChkNenreiHani.BM_ChkNenreiHani() +
            $WHERE + qBM_ChkNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syufromnen.le(pNen) +
            $AND + qBM_ChkNenreiHani.syutonen.ge(pNen) +
            $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.tkfromnen.le(pNen) +
                $AND + qBM_ChkNenreiHani.tktonen.ge(pNen) +
                $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(querySql).bind(qBM_ChkNenreiHani).getResultList();
    }


    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(C_Channelcd pChannelcd,
        String pSyusyouhncd, Integer pSyouhnsdno, BizNumber pNen, Integer pSeibetu, C_KataKbn pSyukatakbn,
        Integer pSyuhknkkn, C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        BizNumber pSyuyoteiriritu, String pTksyouhncd, BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn,
        BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn, C_UmuKbn pSyukatakbnumu, C_UmuKbn pTkykmossyouhnumu) {


        QBM_ChkNenreiHani qBM_ChkNenreiHani = new QBM_ChkNenreiHani();


        String querySql = $SELECT + qBM_ChkNenreiHani +
            $FROM + qBM_ChkNenreiHani.BM_ChkNenreiHani() +
            $WHERE + qBM_ChkNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syufromnen.le(pNen) +
            $AND + qBM_ChkNenreiHani.syutonen.ge(pNen) +
            $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.tkfromnen.le(pNen) +
                $AND + qBM_ChkNenreiHani.tktonen.ge(pNen) +
                $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(querySql).bind(qBM_ChkNenreiHani).getResultList();
    }

    public List<BM_ChkNenreiHani> getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(C_Channelcd pChannelcd,
        String pSyusyouhncd, Integer pSyouhnsdno, C_UmuKbn pSyukatakbnumu, C_KataKbn pSyukatakbn, Integer pSyuhknkkn,
        C_HknkknsmnKbn pSyuhknkknsmnkbn, Integer pSyuhrkkkn, C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        BizNumber pSyuyoteiriritu, Integer pSeibetu, C_UmuKbn pTkykmossyouhnumu, String pTksyouhncd,
        BizNumber pTkhknkkn, C_HknkknsmnKbn pTkhknkknsmnkbn, BizNumber pTkhrkkkn, C_HrkkknsmnKbn pTkhrkkknsmnkbn) {


        QBM_ChkNenreiHani qBM_ChkNenreiHani = new QBM_ChkNenreiHani();


        String querySql = $SELECT + qBM_ChkNenreiHani +
            $FROM + qBM_ChkNenreiHani.BM_ChkNenreiHani() +
            $WHERE + qBM_ChkNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani.syusyouhncd.eq(pSyusyouhncd) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syuhknkkn.le(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknto.ge(pSyuhknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknsmnkbn.eq(pSyuhknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syuhrkkkn.le(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknto.ge(pSyuhrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknsmnkbn.eq(pSyuhrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
            $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu) +
            $AND + qBM_ChkNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);


        if (C_UmuKbn.ARI.eq(pSyukatakbnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.syukatakbn.eq(pSyukatakbn);
        }


        if (C_UmuKbn.ARI.eq(pTkykmossyouhnumu)) {
            querySql = querySql + $AND + qBM_ChkNenreiHani.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkNenreiHani.tkhknkkn.le(pTkhknkkn) +
                $AND + qBM_ChkNenreiHani.tkhknkknto.ge(Integer.parseInt(String.valueOf(pTkhknkkn))) +
                $AND + qBM_ChkNenreiHani.tkhknkknsmnkbn.eq(pTkhknkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.tkhrkkkn.le(pTkhrkkkn) +
                $AND + qBM_ChkNenreiHani.tkhrkkknto.ge(Integer.parseInt(String.valueOf(pTkhrkkkn))) +
                $AND + qBM_ChkNenreiHani.tkhrkkknsmnkbn.eq(pTkhrkkknsmnkbn) +
                $AND + qBM_ChkNenreiHani.hhknseifrom.le(pSeibetu) +
                $AND + qBM_ChkNenreiHani.hhknseito.ge(pSeibetu);
        }

        return em.createJPQL(querySql).bind(qBM_ChkNenreiHani).getResultList();
    }

    public Long getChkNenreiHaniCountByPkHhknsei(C_Channelcd pChannelcd, String pSyouhncd, Integer pSyouhnsdno,
        Integer pHhknsei, C_KataKbn pKatakbn, Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn, BizNumber pHhknnen, BizNumber pSyuyoteiriritu) {


        QBM_ChkNenreiHani qBM_ChkNenreiHani = new QBM_ChkNenreiHani();


        String querySql = $SELECT + $COUNT +"(*)"+
            $FROM + qBM_ChkNenreiHani.BM_ChkNenreiHani() +
            $WHERE + qBM_ChkNenreiHani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkNenreiHani.syusyouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNenreiHani.hhknseifrom.le(pHhknsei) +
            $AND + qBM_ChkNenreiHani.hhknseito.ge(pHhknsei) +
            $AND + qBM_ChkNenreiHani.syukatakbn.eq(pKatakbn) +
            $AND + qBM_ChkNenreiHani.syuhknkkn.le(pHknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknto.ge(pHknkkn) +
            $AND + qBM_ChkNenreiHani.syuhknkknsmnkbn.eq(pHknkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syuhrkkkn.le(pHrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknto.ge(pHrkkkn) +
            $AND + qBM_ChkNenreiHani.syuhrkkknsmnkbn.eq(pHrkkknsmnkbn) +
            $AND + qBM_ChkNenreiHani.syufromnen.le(pHhknnen) +
            $AND + qBM_ChkNenreiHani.syutonen.ge(pHhknnen) +
            $AND + qBM_ChkNenreiHani.syuyoteiriritufrom.le(pSyuyoteiriritu) +
            $AND + qBM_ChkNenreiHani.syuyoteirirituto.ge(pSyuyoteiriritu);

        return em.createJPQL(querySql).bind(qBM_ChkNenreiHani).getSingleResult();
    }

}
