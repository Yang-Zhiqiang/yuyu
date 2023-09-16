package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_Kouza;

/**
 * 口座バックアップテーブル(IT_BAK_KouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KouzaDao extends AbstractDao<IT_BAK_Kouza> {

    public IT_BAK_KouzaDao() {
        super(IT_BAK_Kouza.class);
    }

    @Deprecated
    public IT_BAK_Kouza getBAKKouza(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_Kouza iT_BAK_Kouza =  new IT_BAK_Kouza();
        iT_BAK_Kouza.setSyono(pSyono);
        iT_BAK_Kouza.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_Kouza);
    }

    @Override
    @Deprecated
    public List<IT_BAK_Kouza> selectAll() {
        return super.selectAll();
    }
}
