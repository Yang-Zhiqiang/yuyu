package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiteisei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknData;

/**
 * 新契約 入金 振込入金データ訂正DAOクラス
 */
public class SkHurikomiTeiseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<HT_HrkmNyknData> getHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbnNyktyhyoutlst(
        String pKakutyoujobcd, BizDate pSyoriYmd, Integer pIribaraikbn, C_NyktyhyoutKbn... pNyktyhyoutKbnLst) {

        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData("qHT_HrkmNyknData");

        String strSql = $SELECT + qHT_HrkmNyknData +
            $FROM(qHT_HrkmNyknData)+
            $WHERE + qHT_HrkmNyknData.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_HrkmNyknData.iribaraikbn.eq(pIribaraikbn)+
            $AND + qHT_HrkmNyknData.nyktyhyoutkbn.in(pNyktyhyoutKbnLst) +
            $ORDER_BY(qHT_HrkmNyknData.bankcd.asc(),
                qHT_HrkmNyknData.sitencd.asc());

        ExDBUpdatableResults<HT_HrkmNyknData> exDBUpdatableResults =
            exDBEntityManager.createJPQL(strSql).bind(qHT_HrkmNyknData).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;
    }

}
