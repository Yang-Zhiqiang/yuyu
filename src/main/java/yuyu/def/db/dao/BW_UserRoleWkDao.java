package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BW_UserRoleWk;

/**
 * ユーザーロールワークテーブル(BW_UserRoleWkDao) アクセス用の DAO クラスです。<br />
 */
public class BW_UserRoleWkDao extends AbstractDao<BW_UserRoleWk> {

    public BW_UserRoleWkDao() {
        super(BW_UserRoleWk.class);
    }

    public BW_UserRoleWk getUserRoleWk(String pUserId, String pRoleCd) {
        BW_UserRoleWk bW_UserRoleWk =  new BW_UserRoleWk();
        bW_UserRoleWk.setUserId(pUserId);
        bW_UserRoleWk.setRoleCd(pRoleCd);
        return this.selectOne(bW_UserRoleWk);
    }


    public List<BW_UserRoleWk> getUserRoleWksByUserId(String pUserId) {
        BW_UserRoleWk bW_UserRoleWk = new BW_UserRoleWk();
        bW_UserRoleWk.setUserId(pUserId);
        return this.select(bW_UserRoleWk);
    }
}
