package yuyu.batch.hozen.khozen.khcifcdikkatuhenkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.db.meta.QIW_CifcdIktHnkWk;

/**
 * 契約保全 契約保全 ＣＩＦコード一括変更DAOクラスです。<br />
 */
public class KhCifcdIkkatuHenkouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IW_CifcdIktHnkWk> getAllCifcdIktHnkWkByKakutyoujobcd(String pKakutyoujobcd) {

        QIW_CifcdIktHnkWk qIW_CifcdIktHnkWk = new QIW_CifcdIktHnkWk("qIW_CifcdIktHnkWk");

        String strSql = $SELECT + qIW_CifcdIktHnkWk +
            $FROM(qIW_CifcdIktHnkWk);

        ExDBResults<IW_CifcdIktHnkWk> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIW_CifcdIktHnkWk)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void deleteCifcdIktHnkWk() {

        QIW_CifcdIktHnkWk qIW_CifcdIktHnkWk = new QIW_CifcdIktHnkWk("qIW_CifcdIktHnkWk");

        String strSql = $DELETE_FROM(qIW_CifcdIktHnkWk);

        exDBEntityManager.createJPQL(strSql).bind(qIW_CifcdIktHnkWk).executeUpdate();
    }
}
