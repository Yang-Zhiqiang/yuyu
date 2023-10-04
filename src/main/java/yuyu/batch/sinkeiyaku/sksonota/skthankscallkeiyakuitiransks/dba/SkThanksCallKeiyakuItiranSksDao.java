package yuyu.batch.sinkeiyaku.sksonota.skthankscallkeiyakuitiransks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 その他 サンクスコール対象契約情報DAOクラスです
 */
public class SkThanksCallKeiyakuItiranSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkThanksCallKeiyakuInfoBean> getSkThanksCallKeiyakuInfo(String pKakutyoujobCd, BizDate pSrsyoriYmd) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String strSql = $SELECT + $NEW(SkThanksCallKeiyakuInfoBean.class,
            qHT_SyoriCTL.mosno,
            qHT_MosKihon.kykkbn,
            qHT_MosKihon.kyknen,
            qHT_MosKihon.hhknnen) +
            $FROM(qHT_SyoriCTL, qHT_MosKihon) +
            $WHERE + qHT_SyoriCTL.srsyoriymd.eq(pSrsyoriYmd) +
            $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.skeijimukbn.eq(C_SkeijimuKbn.SMBC) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_MosKihon.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + qHT_MosKihon.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI) +
            $ORDER_BY(qHT_SyoriCTL.syono.asc());

        ExDBResults<SkThanksCallKeiyakuInfoBean> exDBResults = exDBEntityManager.createJPQL(strSql, SkThanksCallKeiyakuInfoBean.class)
            .bind(qHT_SyoriCTL, qHT_MosKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobCd));

        return exDBResults;
    }
}
