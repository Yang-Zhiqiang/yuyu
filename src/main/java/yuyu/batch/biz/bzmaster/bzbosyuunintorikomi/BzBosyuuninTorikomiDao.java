package yuyu.batch.biz.bzmaster.bzbosyuunintorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_Bosyuunin;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（募集人マスタ）DAOクラスです。
 */
public class BzBosyuuninTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateBosyuunin() {

        String sql = "delete from BM_Bosyuunin";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteBosyuunin() {
        QBM_Bosyuunin qBM_Bosyuunin = new QBM_Bosyuunin();

        String strSql = $DELETE_FROM(qBM_Bosyuunin);

        exDBEntityManager.createJPQL(strSql).bind(qBM_Bosyuunin).executeUpdate();
    }
}
