package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;

/**
 * 継続Ｐ翌月充当予定ワークテーブル(IW_KhKzkPYokuJyuutouYoteiWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhKzkPYokuJyuutouYoteiWkDao extends AbstractDao<IW_KhKzkPYokuJyuutouYoteiWk> {

    public IW_KhKzkPYokuJyuutouYoteiWkDao() {
        super(IW_KhKzkPYokuJyuutouYoteiWk.class);
    }

    public IW_KhKzkPYokuJyuutouYoteiWk getKhKzkPYokuJyuutouYoteiWk(String pSyono) {
        IW_KhKzkPYokuJyuutouYoteiWk iW_KhKzkPYokuJyuutouYoteiWk =  new IW_KhKzkPYokuJyuutouYoteiWk( pSyono);
        return this.selectOne(iW_KhKzkPYokuJyuutouYoteiWk);
    }
}
