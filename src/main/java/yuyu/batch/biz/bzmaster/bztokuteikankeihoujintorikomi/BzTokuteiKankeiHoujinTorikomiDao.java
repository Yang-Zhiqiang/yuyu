package yuyu.batch.biz.bzmaster.bztokuteikankeihoujintorikomi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QHM_TokuteiKankeiHoujin;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（特定関係法人マスタ）DAOクラスです。
 */
public class BzTokuteiKankeiHoujinTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateTokuteiKankeiHoujin() {

        String strSql = "delete from HM_TokuteiKankeiHoujin";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteTokuteiKankeiHoujin() {
        QHM_TokuteiKankeiHoujin qHM_TokuteiKankeiHoujin = new QHM_TokuteiKankeiHoujin();

        String strSql = $DELETE_FROM(qHM_TokuteiKankeiHoujin);

        exDBEntityManager.createJPQL(strSql).bind(qHM_TokuteiKankeiHoujin).executeUpdate();
    }
}
