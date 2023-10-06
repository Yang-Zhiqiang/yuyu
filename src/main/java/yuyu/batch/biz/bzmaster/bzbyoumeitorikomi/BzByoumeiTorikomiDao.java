package yuyu.batch.biz.bzmaster.bzbyoumeitorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QJM_Byoumei;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（病名マスタ）DAOクラスです。
 */
public class BzByoumeiTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateByoumei() {

        String sql = "delete from JM_Byoumei";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteByoumei() {
        QJM_Byoumei qJM_Byoumei = new QJM_Byoumei();

        String strSql = $DELETE_FROM(qJM_Byoumei);

        exDBEntityManager.createJPQL(strSql).bind(qJM_Byoumei).executeUpdate();
    }
}
