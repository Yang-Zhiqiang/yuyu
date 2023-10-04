package yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkasakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;

/**
 * ダイレクトサービス 値動き判定 値動き判定結果Ｆ作成機能DAOクラス
 */
public class DsNeugokiHanteiKekkaSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<MW_DsNeugokiHanteiKekkaWk> getDsNeugokiHanteiKekkaWkByKakutyoujobcd(String pKakutyouJobCd) {

        QMW_DsNeugokiHanteiKekkaWk qMW_DsNeugokiHanteiKekkaWk = new QMW_DsNeugokiHanteiKekkaWk("qMW_DsNeugokiHanteiKekkaWk");

        String strSql = $SELECT + qMW_DsNeugokiHanteiKekkaWk +
            $FROM (qMW_DsNeugokiHanteiKekkaWk);

        ExDBResults<MW_DsNeugokiHanteiKekkaWk> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qMW_DsNeugokiHanteiKekkaWk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
