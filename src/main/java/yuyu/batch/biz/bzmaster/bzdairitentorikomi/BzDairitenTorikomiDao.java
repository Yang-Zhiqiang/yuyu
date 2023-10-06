package yuyu.batch.biz.bzmaster.bzdairitentorikomi;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_Dairiten;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（代理店マスタ）DAOクラスです。
 */
public class BzDairitenTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateDairiten() {

        String strSql = "delete from BM_Dairiten";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteDairiten() {
        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten();

        String strSql = $DELETE_FROM(qBM_Dairiten);

        exDBEntityManager.createJPQL(strSql).bind(qBM_Dairiten).executeUpdate();
    }
}
