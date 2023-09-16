package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_FileHozon;

/**
 * ファイル保存テーブル(AT_FileHozon) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_FileHozonDao extends AbstractDao<AT_FileHozon> {

    protected AT_FileHozonDao() {
        super(AT_FileHozon.class);
    }

    public AT_FileHozon getAT_FileHozon(String pUniqueId) {

        AT_FileHozon hozon = new AT_FileHozon();
        hozon.setUniqueId(pUniqueId);

        return selectOne(hozon);
    }
}
