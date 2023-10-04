package yuyu.batch.hozen.khinterf.khseihowebdrtensikkoudtlfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ代理店失効契約明細Ｆ作成機能DAOクラスです。<br />
 */
public class KhSeihowebDrtenSikkouDtlFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KykKihon> getKykkhnTblEntityListBySyoriYm(String pKakutyoujobcd, BizDateYM pSyoriYm) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        String strSql = $SELECT + qIT_KykKihon +
            $FROM(qIT_KykKihon,
                qIT_PMinyuuSyoumetuInfo) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_PMinyuuSyoumetuInfo.syono) +
                $AND + qIT_PMinyuuSyoumetuInfo.syoriym.eq(pSyoriYm);

        ExDBResults<IT_KykKihon> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KykKihon, qIT_PMinyuuSyoumetuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

}
