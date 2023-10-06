package yuyu.batch.biz.bzmaster.bzginkoutorikomi;
import javax.inject.Inject;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBM_Ginkou;

/**
 * マスタ取込（銀行マスタ）DAOクラスです。
 */
public class BzGinkouTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateGinkou() {

        String sql = "delete from BM_Ginkou";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteGinkou() {
        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();

        String strSql = $DELETE_FROM(qBM_Ginkou);

        exDBEntityManager.createJPQL(strSql).bind(qBM_Ginkou).executeUpdate();
    }
}
