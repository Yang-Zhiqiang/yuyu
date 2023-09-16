package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_TeikikinKouza;

/**
 * 定期金支払口座テーブル(IT_TeikikinKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TeikikinKouzaDao extends AbstractDao<IT_TeikikinKouza> {

    public IT_TeikikinKouzaDao() {
        super(IT_TeikikinKouza.class);
    }

    @Deprecated
    public IT_TeikikinKouza getTeikikinKouza(String pSyono){
        IT_TeikikinKouza iT_TeikikinKouza =  new IT_TeikikinKouza();
        iT_TeikikinKouza.setSyono(pSyono);
        return this.selectOne(iT_TeikikinKouza);
    }

    @Override
    @Deprecated
    public List<IT_TeikikinKouza> selectAll() {
        return super.selectAll();
    }
}
