package yuyu.batch.sinkeiyaku.skkessan.skpkakinzandakameisaisakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 決算 新契約Ｐ過金残高明細作成の機能DAOクラスです。
 */
public class SkPKakinZandakaMeisaiSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymdPkakinsyoriymdHnkntuukasyuKyktuukasyulst(BizDate pKijyunYmd,
        C_Tuukasyu pHnkntuukasyu, C_Tuukasyu... pKyktuukasyuLst) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String strSubSql = $SELECT + qHT_Henkin.mosno +
            $FROM(qHT_Henkin) +
            $WHERE + qHT_Henkin.pkakinsyoriymd.lt(pKijyunYmd) +
            $AND + $(qHT_Henkin.hnknsyoriymd.isNull() +
                $OR + qHT_Henkin.hnknsyoriymd.ge(pKijyunYmd)) +
                $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
                $AND + qHT_Henkin.mosno.eq(qHT_SyoriCTL.mosno);

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM (qHT_SyoriCTL, qHT_MosKihon) +
            $WHERE + $EXISTS + $(strSubSql) +
            $AND + qHT_MosKihon.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_MosKihon.kyktuukasyu.in(pKyktuukasyuLst) +
            $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_Henkin, qHT_MosKihon).getResultList();
    }

    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnkntuukasyu(String pMosno, BizDate pKijyunYmd, C_Tuukasyu pHnkntuukasyu) {

        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");

        String strSql = $SELECT + qHT_Henkin +
            $FROM(qHT_Henkin) +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + $( qHT_Henkin.hnknsyoriymd.isNull()  +
                $OR + qHT_Henkin.hnknsyoriymd.ge(pKijyunYmd)) +
                $AND + qHT_Henkin.pkakinsyoriymd.lt(pKijyunYmd) +
                $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
                $ORDER_BY(qHT_Henkin.pkakinsyoriymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_Henkin).getResultList();
    }
}
