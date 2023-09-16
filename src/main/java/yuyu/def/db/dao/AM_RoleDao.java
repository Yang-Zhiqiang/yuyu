package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AM_Role;

/**
 * ロールマスタ(AM_Role) テーブルアクセス用の DAO クラスです。
 */
public class AM_RoleDao extends AbstractDao<AM_Role> {

    protected AM_RoleDao() {
        super(AM_Role.class);
    }

    public AM_Role getAM_Role(String pRoleCd){

        AM_Role role = new AM_Role();
        role.setRoleCd(pRoleCd);

        return selectOne(role);
    }
}
