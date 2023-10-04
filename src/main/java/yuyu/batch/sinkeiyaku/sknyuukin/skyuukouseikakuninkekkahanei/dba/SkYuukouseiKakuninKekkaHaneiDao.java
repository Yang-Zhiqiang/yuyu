package yuyu.batch.sinkeiyaku.sknyuukin.skyuukouseikakuninkekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.db.meta.QIT_YuukouKakKekkaSk;

/**
 * 新契約 入金 新契約有効性確認結果反映Daoクラス
 */
public class SkYuukouseiKakuninKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdHrkkeiroCredityuukoukakkbn(String pKakutyouJobCd) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String sql = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL, qHT_MosKihon) +
            $WHERE + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_SyoriCTL.credityuukoukakkbn.eq(C_CreditYuukoukakKbn.OK) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_MosKihon.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +
            $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        ExDBUpdatableResults<HT_SyoriCTL> exDBUpdResults = exDBEntityManager
            .createJPQL(sql).bind(qHT_SyoriCTL, qHT_MosKihon).getUpdatableResults();

        exDBUpdResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBUpdResults;
    }

    public IT_YuukouKakKekkaSk getYuukouKakKekkaSkByMosno(String pMosno) {

        QIT_YuukouKakKekkaSk qIT_YuukouKakKekkaSk = new QIT_YuukouKakKekkaSk("qIT_YuukouKakKekkaSk");

        String sql = $SELECT + qIT_YuukouKakKekkaSk +
            $FROM(qIT_YuukouKakKekkaSk) +
            $WHERE + qIT_YuukouKakKekkaSk.creditkessaiyouno.like("3200" + pMosno + "%");

        return exDBEntityManager.createJPQL(sql).bind(qIT_YuukouKakKekkaSk).getSingleResult();
    }

}
