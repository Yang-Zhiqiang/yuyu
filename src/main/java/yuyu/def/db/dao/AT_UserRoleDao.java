package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.meta.QAT_UserRole;

/**
 *
 */
public class AT_UserRoleDao extends AbstractDao<AT_UserRole> {

    protected AT_UserRoleDao() {
        super(AT_UserRole.class);
    }

    public long getCountUsersByRoleCd(String pRoleCd) {
        QAT_UserRole qUserRole = new QAT_UserRole();
        return em.createJPQL(
            $SELECT + $COUNT_DISTINCT(qUserRole.userId) +
            $FROM   + qUserRole.AT_UserRole() +
            $WHERE  + qUserRole.roleCd.eq(pRoleCd)
            ).bind(qUserRole).<Long>getSingleResult();
    }
}
