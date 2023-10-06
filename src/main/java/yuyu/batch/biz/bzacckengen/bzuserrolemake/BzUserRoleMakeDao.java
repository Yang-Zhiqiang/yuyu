package yuyu.batch.biz.bzacckengen.bzuserrolemake;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * ユーザー権限自動反映処理DAOクラスです。
 */
public class BzUserRoleMakeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void lockUserWk() {

        String strSql = "lock table BW_UserWk_Z in exclusive mode";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();

    }

    public void lockUserRoleWk() {

        String strSql = "lock table BW_UserRoleWk_Z in exclusive mode";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }
}
