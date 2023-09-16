package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_SosikiRole;

/**
 * 組織ロールテーブル(AT_SosikiRoleDao) アクセス用の DAO クラスです。<br />
 */
public class AT_SosikiRoleDao extends AbstractDao<AT_SosikiRole> {

    public AT_SosikiRoleDao() {
        super(AT_SosikiRole.class);
    }

    public AT_SosikiRole getSosikiRole(String pTanmatusettisosikicd,
        String pRoleCd){
        AT_SosikiRole aT_SosikiRole =  new AT_SosikiRole();
        aT_SosikiRole.setTanmatusettisosikicd(pTanmatusettisosikicd);
        aT_SosikiRole.setRoleCd(pRoleCd);
        return this.selectOne(aT_SosikiRole);
    }

    public List<AT_SosikiRole> getSosikiRolesByTanmatusettisosikicd(String pTanmatusettisosikicd) {

        AT_SosikiRole aT_SosikiRole = new AT_SosikiRole();
        aT_SosikiRole.setTanmatusettisosikicd(pTanmatusettisosikicd);
        return this.select(aT_SosikiRole);
    }
}
