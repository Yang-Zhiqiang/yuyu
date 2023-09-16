package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_Kouza;

/**
 * 口座テーブル(IT_KouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KouzaDao extends AbstractDao<IT_Kouza> {

    public IT_KouzaDao() {
        super(IT_Kouza.class);
    }

    @Deprecated
    public IT_Kouza getKouza(String pSyono){
        IT_Kouza iT_Kouza =  new IT_Kouza();
        iT_Kouza.setSyono(pSyono);
        return this.selectOne(iT_Kouza);
    }

    @Override
    @Deprecated
    public List<IT_Kouza> selectAll() {
        return super.selectAll();
    }
}
