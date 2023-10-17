package yuyu.batch.biz.bzmaster.bzsosikitorikomi;

import javax.inject.Inject;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import yuyu.def.db.meta.QAM_Sosiki;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（組織マスタ）DAOクラスです。
 */
public class BzSosikiTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateSosiki() {

        String strSql = "delete from AM_Sosiki";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteSosiki() {

        QAM_Sosiki qAM_Sosiki = new QAM_Sosiki();

        String strSql = $DELETE_FROM(qAM_Sosiki);

        exDBEntityManager.createJPQL(strSql).bind(qAM_Sosiki).executeUpdate();
    }
}
