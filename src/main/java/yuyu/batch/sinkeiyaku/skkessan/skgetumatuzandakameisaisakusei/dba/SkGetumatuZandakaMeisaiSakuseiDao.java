package yuyu.batch.sinkeiyaku.skkessan.skgetumatuzandakameisaisakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 決算 新契約月末残高明細作成の機能DAOクラスです
 */
public class SkGetumatuZandakaMeisaiSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymdPkakinsyoriymdKyktuukasyulst(BizDate pKijyunymd, C_Tuukasyu... pTuukasyuLst) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM (qHT_SyoriCTL,qHT_MosKihon) +
            $WHERE + $EXISTS(
                $SELECT + qHT_Henkin.mosno +
                $FROM + qHT_Henkin.HT_Henkin() +
                $WHERE + qHT_Henkin.pkakinsyoriymd.lt(pKijyunymd) +
                $AND +
                "(" +
                qHT_Henkin.hnknsyoriymd.isNull() +
                $OR + qHT_Henkin.hnknsyoriymd.ge(pKijyunymd) +
                ")" +
                $AND + qHT_Henkin.mosno.eq(qHT_SyoriCTL.mosno)) +
                $AND + qHT_MosKihon.mosno.eq(qHT_SyoriCTL.mosno) +
                $AND + qHT_MosKihon.kyktuukasyu.in(pTuukasyuLst) +
                $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_Henkin, qHT_MosKihon).getResultList();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeiritukbnSrsyoriymdNyksyoriymdKyktuukasyulst(BizDate pKijyunymd, C_Tuukasyu... pTuukasyuLst) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM (qHT_SyoriCTL,qHT_MosKihon) +
            $WHERE + "(" + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.NONE) +
            $OR +
            "(" +
            qHT_SyoriCTL.srsyoriymd.isNotNull()+
            $AND + qHT_SyoriCTL.srsyoriymd.ge(pKijyunymd) +
            ")" + ")" +
            $AND +
            $EXISTS($SELECT + qHT_Nyuukin.mosno +
                $FROM + qHT_Nyuukin.HT_Nyuukin() +
                $WHERE + qHT_Nyuukin.nyksyoriymd.lt(pKijyunymd) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_Nyuukin.mosno)) +
                $AND + qHT_MosKihon.mosno.eq(qHT_SyoriCTL.mosno) +
                $AND + qHT_MosKihon.kyktuukasyu.in(pTuukasyuLst) +
                $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_Nyuukin, qHT_MosKihon).getResults();
    }

}
