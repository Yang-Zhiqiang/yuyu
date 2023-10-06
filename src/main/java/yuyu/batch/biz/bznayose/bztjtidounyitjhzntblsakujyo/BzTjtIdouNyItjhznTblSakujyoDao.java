package yuyu.batch.biz.bznayose.bztjtidounyitjhzntblsakujyo;

import javax.inject.Inject;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 当日異動内容一時保存TBL削除DAOクラスです。
 */
public class BzTjtIdouNyItjhznTblSakujyoDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void deleteByTableid(String pTableid) {
        String strSql = $DELETE_FROM + pTableid;

        exDBEntityManager.createJPQL(strSql).executeUpdate();
    }

    public Long getCountByTableid(String pTableid) {

        String jpql = $SELECT + $COUNT + " (*) " + $FROM + pTableid;

        return exDBEntityManager.createJPQL(jpql).getSingleResult();
    }
}
