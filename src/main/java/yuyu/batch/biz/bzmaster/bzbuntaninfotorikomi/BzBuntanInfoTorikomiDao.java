package yuyu.batch.biz.bzmaster.bzbuntaninfotorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QBT_BuntanInfo;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（分担情報テーブル）DAOクラスです。
 */
public class BzBuntanInfoTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateBuntanInfo() {
        String strSql = "delete from BT_BuntanInfo";
        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteBuntanInfo() {
        QBT_BuntanInfo qBT_BuntanInfo = new QBT_BuntanInfo();

        String strSql = $DELETE_FROM(qBT_BuntanInfo);

        exDBEntityManager.createJPQL(strSql).bind(qBT_BuntanInfo).executeUpdate();
    }
}
