package yuyu.batch.biz.bzmaster.bzkouintorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_Kouin;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（行員マスタ）DAOクラスです。
 */
public class BzKouinTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateKouin() {

        String strSql = "delete from BM_Kouin";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteKouin() {
        QBM_Kouin qBM_Kouin = new QBM_Kouin();

        String strSql = $DELETE_FROM(qBM_Kouin);

        exDBEntityManager.createJPQL(strSql).bind(qBM_Kouin).executeUpdate();
    }
}
