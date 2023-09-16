package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_MyMenu;

/**
 * マイメニューマスタ(AT_MyMenu) テーブルアクセス用の DAO クラスです。
 */
public class AT_MyMenuDao extends AbstractDao<AT_MyMenu> {

    protected AT_MyMenuDao() {
        super(AT_MyMenu.class);
    }

    public List<AT_MyMenu> getMyMenuByUserId(String pUserId) {
        AT_MyMenu condEntity = new AT_MyMenu();
        condEntity.setUserId(pUserId);
        return select(condEntity);
    }

}
