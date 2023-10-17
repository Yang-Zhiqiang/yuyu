package yuyu.batch.biz.bzmaster.bzuseridkanrenwksks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QBW_UserIdKanrenWk;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 業務共通 マスタ取込 ユーザーID関連ワークテーブル作成DAOクラスです。
 */
public class BzUserIdKanrenWkSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    void lockUserIdKanrenWk() {

        String strSql = "lock table BW_UserIdKanrenWk_Z in exclusive mode";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();

    }

    void deleteUserIdKanrenWk() {

        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk("qBW_UserIdKanrenWk");

        String strSql = $DELETE_FROM(qBW_UserIdKanrenWk);

        exDBEntityManager.createJPQL(strSql).bind(qBW_UserIdKanrenWk).executeUpdate();
    }
}
