package yuyu.batch.sinkeiyaku.skmaster.sktokuteikankeihjnnmtotugou;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;

/**
 * 特定関係法人名突合マスタ反映DAOクラスです。
 */
public class SkTokuteikankeihjnnmTotugouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateTokuteiKankeiHjnNmTotugou() {

        String strSql = "truncate table HM_TokuteiKankeiHjnNmTotugou";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteTokuteiKankeiHjnNmTotugou() {

        QHM_TokuteiKankeiHjnNmTotugou qHM_TokuteiKankeiHjnNmTotugou = new QHM_TokuteiKankeiHjnNmTotugou();

        String strSql = $DELETE_FROM(qHM_TokuteiKankeiHjnNmTotugou);

        exDBEntityManager.createJPQL(strSql).bind(qHM_TokuteiKankeiHjnNmTotugou).executeUpdate();
    }
}
