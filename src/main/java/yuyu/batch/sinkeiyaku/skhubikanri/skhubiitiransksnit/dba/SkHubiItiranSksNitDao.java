package yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransksnit.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 不備管理 新契約不備一覧作成（ＮＩＴ）の機能DAOクラス
 */

public class SkHubiItiranSksNitDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<HT_SyoriCTL> getNITPplessHubiKeiyaku(String pOyadrtencd,
        String pKakutyoujobcd) {
        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("qHT_MosDairiten");
        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail("qHT_SkHubiDetail");
        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi("qHT_SkHubi");

        String mainStry = $SELECT_DISTINCT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL,
                qHT_MosKihon,
                qHT_MosDairiten,
                qHT_SkHubiDetail,
                qHT_SkHubi) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_SkHubi.mosno) +
                $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
                $AND + qHT_MosDairiten.renno.eq(1) +
                $AND + qHT_MosDairiten.oyadrtencd.eq(pOyadrtencd) +
                $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.NONE) +
                $AND + qHT_SyoriCTL.mosuketukekbn.eq(C_MosUketukeKbn.PAPERLESSNIT) +
                $AND + qHT_SkHubiDetail.hubiitiransksymd.isNull() +
                $AND + qHT_SkHubiDetail.hasinymd.isNotNull() +
                $AND + qHT_SkHubiDetail.kaisyouymd.isNull() +
                $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        ExDBUpdatableResults<HT_SyoriCTL> exDBResults = exDBEntityManager
            .createJPQL(mainStry)
            .bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten, qHT_SkHubi,
                qHT_SkHubiDetail).getUpdatableResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;

    }
}
