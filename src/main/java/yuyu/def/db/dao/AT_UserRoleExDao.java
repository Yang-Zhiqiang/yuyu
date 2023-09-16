package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserRole;

/**
 * ユーザーマスタ(AM_User) テーブルアクセス用の DAO クラスです。
 */
public class AT_UserRoleExDao extends AbstractDao<AT_UserRole> {

    protected AT_UserRoleExDao() {
        super(AT_UserRole.class);
    }

}