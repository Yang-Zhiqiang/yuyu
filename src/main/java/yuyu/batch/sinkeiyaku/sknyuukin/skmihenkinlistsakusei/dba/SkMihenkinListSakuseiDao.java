package yuyu.batch.sinkeiyaku.sknyuukin.skmihenkinlistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 入金 未返金リスト作成処理DAOクラス
 */
public class SkMihenkinListSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByPkakinsyoriymdNyknnrkumuKyktuukasyulst(BizDate pPkakinsyoriymd, C_Tuukasyu... pKyktuukasyuLst) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("qHT_MosDairiten");

        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String strSql1 = $SELECT + qHT_Henkin.mosno +
            $FROM(qHT_Henkin) +
            $WHERE + qHT_Henkin.hnknsyoriymd.isNull() +
            $AND + qHT_Henkin.pkakinsyoriymd.le(pPkakinsyoriymd) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_Henkin.mosno);


        String strSql2 = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL, qHT_MosKihon) +
            $LEFT_OUTER_JOIN + qHT_SyoriCTL.HT_MosDairiten() +
            $AS + qHT_MosDairiten +
            $WHERE + qHT_SyoriCTL.nyknnrkumu.eq(C_UmuKbn.ARI) +
            $AND + $EXISTS(strSql1) +
            $AND + qHT_MosKihon.kyktuukasyu.in(pKyktuukasyuLst) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + "(" + qHT_MosDairiten.renno.eq(1) +
            $OR + qHT_MosDairiten.mosno.isNull()+ ")" +
            $ORDER_BY(qHT_MosDairiten.oyadrtencd.asc(),
                qHT_MosDairiten.tratkiagcd.asc(),
                qHT_SyoriCTL.mosno.asc());


        return exDBEntityManager.createJPQL(strSql2).bind(qHT_SyoriCTL, qHT_MosDairiten, qHT_Henkin, qHT_MosKihon).getResults();
    }

}
