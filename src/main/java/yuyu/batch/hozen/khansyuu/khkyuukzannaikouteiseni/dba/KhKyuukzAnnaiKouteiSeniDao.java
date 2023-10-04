package yuyu.batch.hozen.khansyuu.khkyuukzannaikouteiseni.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.meta.QIT_KyuukzAnnaimati;

/**
 * 契約保全 案内収納 旧口座案内契約工程遷移処理DAO
 */
public class KhKyuukzAnnaiKouteiSeniDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KyuukzAnnaimatiBean> getKyuukzAnnaimatiBeans(String pKakutyouJobCd) {

        QIT_KyuukzAnnaimati qIT_KyuukzAnnaimati = new QIT_KyuukzAnnaimati("qIT_KyuukzAnnaimati");

        String queryStr = $SELECT + $NEW(KyuukzAnnaimatiBean.class,
            qIT_KyuukzAnnaimati.kouteikanriid,
            qIT_KyuukzAnnaimati.syono) +
            $FROM(qIT_KyuukzAnnaimati) +
            $WHERE + qIT_KyuukzAnnaimati.syorizumiflg.eq(C_Syorizumiflg.MISYORI);

        ExDBResults<KyuukzAnnaimatiBean> exDBResults = exDBEntityManager
            .createJPQL(queryStr, KyuukzAnnaimatiBean.class).bind(qIT_KyuukzAnnaimati).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

}
