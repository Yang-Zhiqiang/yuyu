package yuyu.batch.biz.bzinterf.bzrenkeihenkanfilerenkeijyusin;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 連携項目変換処理（ファイル連携方式受信）DAOクラスです。
 */
public class BzRenkeiHenkanFileRenkeiJyusinDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateByTableid(String pTableid) {
        String strSql = "truncate table " + pTableid;
        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteByTableid(String pTableid) {

        String strSql = $DELETE_FROM + pTableid;

        exDBEntityManager.createJPQL(strSql).executeUpdate();
    }

    public Long getCountByTableid(String pTableid) {

        String jpql = $SELECT  + $COUNT + " (*) " + $FROM +  pTableid  ;

        return exDBEntityManager.createJPQL(jpql).getSingleResult();
    }
}
