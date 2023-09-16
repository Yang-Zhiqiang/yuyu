package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhKesikomiData;

/**
 * 消込データテーブル(IT_KhKesikomiDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhKesikomiDataDao extends AbstractDao<IT_KhKesikomiData> {

    public IT_KhKesikomiDataDao() {
        super(IT_KhKesikomiData.class);
    }

    public IT_KhKesikomiData getKhKesikomiData(String pNyuukinkakusyouno, String pSyono) {
        IT_KhKesikomiData iT_KhKesikomiData =  new IT_KhKesikomiData( pNyuukinkakusyouno,  pSyono);
        return this.selectOne(iT_KhKesikomiData);
    }

}
