package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.meta.QHT_GaikaHrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknData;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 入金 振込入金データ振分の機能DAOクラスです。
 */
public class SkHurikomiHuriwakeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<SkMosInfoBean> getSkMosInfo() {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("QHT_SyoriCTL");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("QHT_MosKihon");
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("QHT_MosDairiten");

        String strSql = $SELECT + $NEW(SkMosInfoBean.class,
            qHT_MosKihon.mosno,
            qHT_MosKihon.kykkbn,
            qHT_MosKihon.kyknmkn,
            qHT_MosKihon.hhknnmkn,
            qHT_MosDairiten.oyadrtencd) +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            "," + qHT_MosKihon.HT_MosKihon() +
            "," + qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_MosDairiten.renno.eq(1) +
            $AND + qHT_SyoriCTL.seiritukbn.in(C_SeirituKbn.NONE, C_SeirituKbn.ITIPMATI);

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten).getResultList();
    }

    public List<String> getSkHrkmNykMosnoList() {

        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData("qHT_HrkmNyknData");

        String strSql = $SELECT + qHT_HrkmNyknData.nykmosno +
            $FROM(qHT_HrkmNyknData) +
            $WHERE + qHT_HrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $GROUP_BY + qHT_HrkmNyknData.nykmosno +
            $HAVING + $COUNT(qHT_HrkmNyknData.nykmosno)+ $GT + "1" +
            $ORDER_BY(qHT_HrkmNyknData.nykmosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_HrkmNyknData).getResultList();
    }

    public List<String> getSkGkHrkmNykMosnoList() {

        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData("qHT_GaikaHrkmNyknData");

        String strSql = $SELECT + qHT_GaikaHrkmNyknData.nykmosno +
            $FROM(qHT_GaikaHrkmNyknData) +
            $WHERE + qHT_GaikaHrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $GROUP_BY + qHT_GaikaHrkmNyknData.nykmosno +
            $HAVING + $COUNT(qHT_GaikaHrkmNyknData.nykmosno)+ $GT + "1" +
            $ORDER_BY( qHT_GaikaHrkmNyknData.nykmosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_GaikaHrkmNyknData).getResultList();
    }
}
