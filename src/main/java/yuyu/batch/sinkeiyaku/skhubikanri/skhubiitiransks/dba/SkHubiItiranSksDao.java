package yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QBM_Dairiten;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約不備一覧作成DAOクラスです。
 */
public class SkHubiItiranSksDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<SkHubiInfoBean> getSkHubiInfo(BizDate pHasinymdFrom, BizDate pHasinymdTo) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn("qHT_MosSyouhn");
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("qHT_MosDairiten");
        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi("qHT_SkHubi");
        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail("qHT_SkHubiDetail");
        QHM_SkHubiNaiyou qHM_SkHubiNaiyou = new QHM_SkHubiNaiyou("qHM_SkHubiNaiyou");
        QHM_SkHubiKoumoku qHM_SkHubiKoumoku = new QHM_SkHubiKoumoku("qHM_SkHubiKoumoku");
        QHM_SkSeibiSijiNaiyou qHM_SkSeibiSijiNaiyou = new QHM_SkSeibiSijiNaiyou("qHM_SkSeibiSijiNaiyou");
        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten("qBM_Dairiten");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String strSql = $SELECT + $NEW(SkHubiInfoBean.class,
            qHT_SyoriCTL,
            qHT_MosKihon,
            qHT_MosSyouhn,
            qHT_MosDairiten,
            qHT_SkHubi,
            qHT_SkHubiDetail,
            qHM_SkHubiNaiyou,
            qHM_SkHubiKoumoku,
            qHM_SkSeibiSijiNaiyou,
            qBM_Dairiten,
            qBM_SyouhnZokusei) +
            $FROM(qHT_SyoriCTL,
                qHT_MosKihon,
                qHT_MosSyouhn,
                qHT_MosDairiten,
                qHT_SkHubi,
                qHT_SkHubiDetail,
                qHM_SkHubiNaiyou,
                qHM_SkHubiKoumoku,
                qHM_SkSeibiSijiNaiyou,
                qBM_Dairiten,
                qBM_SyouhnZokusei) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosSyouhn.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_SkHubi.mosno) +
                $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
                $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
                $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiNaiyou.skhubikoumokucd) +
                $AND + qHT_SkHubiDetail.skhubinaiyoucd.eq(qHM_SkHubiNaiyou.skhubinaiyoucd) +
                $AND + qHT_SkHubiDetail.syoruiCd.eq(qHM_SkHubiKoumoku.syoruiCd) +
                $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiKoumoku.skhubikoumokucd) +
                $AND + qHT_SkHubiDetail.skseibisijinaiyoucd.eq(qHM_SkSeibiSijiNaiyou.skseibisijinaiyoucd) +
                $AND + qHT_MosDairiten.tratkiagcd.eq(qBM_Dairiten.drtencd) +
                $AND + qHT_MosSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qHT_MosSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qHT_MosSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qHT_MosDairiten.renno.eq(1) +
                $AND + "(" + qHT_SkHubiDetail.hasinymd.ge(pHasinymdFrom) +
                $AND + qHT_SkHubiDetail.hasinymd.le(pHasinymdTo) + ")" +
                $ORDER_BY(qHT_SyoriCTL.mosnrkymd.asc(),
                    qHT_SyoriCTL.mosno.asc(),
                    qHT_SkHubiDetail.renno3keta.asc());

        return em
            .createJPQL(strSql, SkHubiInfoBean.class)
            .bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosSyouhn, qHT_MosDairiten, qHT_SkHubi, qHT_SkHubiDetail,
                qHM_SkHubiNaiyou, qHM_SkHubiKoumoku, qHM_SkSeibiSijiNaiyou, qBM_Dairiten, qBM_SyouhnZokusei)
                .getResults();
    }
}
