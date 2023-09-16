package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserRoleRireki;

/**
 * ユーザーロール履歴テーブル(AT_UserRoleRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class AT_UserRoleRirekiDao extends AbstractDao<AT_UserRoleRireki> {

    public AT_UserRoleRirekiDao() {
        super(AT_UserRoleRireki.class);
    }

    public AT_UserRoleRireki getUserRoleRireki(String pUniqueId){
        AT_UserRoleRireki aT_UserRoleRireki =  new AT_UserRoleRireki();
        aT_UserRoleRireki.setUniqueId(pUniqueId);
        return this.selectOne(aT_UserRoleRireki);
    }
}
