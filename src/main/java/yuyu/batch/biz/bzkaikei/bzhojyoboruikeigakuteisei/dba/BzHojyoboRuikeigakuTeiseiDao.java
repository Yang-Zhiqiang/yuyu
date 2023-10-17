package yuyu.batch.biz.bzkaikei.bzhojyoboruikeigakuteisei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;

/**
 * 業務共通 経理･会計 補助簿累計額訂正の機能DAOクラス
 */
public class BzHojyoboRuikeigakuTeiseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<BV_HjybruikeigakuData> getHjybruikeigakuData(String pKakutyoujobcd) {

        QBV_HjybruikeigakuData qBV_HjybruikeigakuData = new QBV_HjybruikeigakuData();

        String strSql = $SELECT + qBV_HjybruikeigakuData +
            $FROM + qBV_HjybruikeigakuData.BV_HjybruikeigakuData();

        ExDBResults<BV_HjybruikeigakuData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qBV_HjybruikeigakuData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}