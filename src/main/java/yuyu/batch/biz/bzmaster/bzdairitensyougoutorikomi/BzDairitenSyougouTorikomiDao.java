package yuyu.batch.biz.bzmaster.bzdairitensyougoutorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_DairitenSyougou;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（代理店法人商号マスタ）DAOクラスです。
 */
public class BzDairitenSyougouTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateDairitenSyougou() {

        String strSql = "delete from BM_DairitenSyougou";
        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteDairitenSyougou() {
        QBM_DairitenSyougou qBM_DairitenSyougou = new QBM_DairitenSyougou();

        String strSql = $DELETE_FROM(qBM_DairitenSyougou);

        exDBEntityManager.createJPQL(strSql).bind(qBM_DairitenSyougou).executeUpdate();
    }
}
