package yuyu.batch.hozen.khinterf.khmizuhodrtensikkoukykdtlfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 インターフェイス みずほ代理店失効契約明細Ｆ作成Daoクラスです。<br />
 */
public class KhMizuhoDrtenSikkouKykDtlFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<PMinyuuSyoumetuInfoBean> getPMinyuuSyoumetuInfoBeans(String pKakutyouJobCd, BizDateYM pSyoriYm) {

        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        String sql = $SELECT + $NEW(PMinyuuSyoumetuInfoBean.class,
            qIT_PMinyuuSyoumetuInfo.syono,
            qIT_PMinyuuSyoumetuInfo.kbnkey,
            qIT_PMinyuuSyoumetuInfo.syoriym,
            qIT_PMinyuuSyoumetuInfo.syoriYmd,
            qIT_PMinyuuSyoumetuInfo.syoumetuymd) +
            $FROM(qIT_PMinyuuSyoumetuInfo) +
            $WHERE + qIT_PMinyuuSyoumetuInfo.syoriym.eq(pSyoriYm);

        ExDBResults<PMinyuuSyoumetuInfoBean> exDBResults =
            exDBEntityManager.createJPQL(sql, PMinyuuSyoumetuInfoBean.class).bind(qIT_PMinyuuSyoumetuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
