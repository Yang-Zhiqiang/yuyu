package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_TeikikinKouza;

/**
 * 定期金支払口座バックアップテーブル(IT_BAK_TeikikinKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TeikikinKouzaDao extends AbstractDao<IT_BAK_TeikikinKouza> {

    public IT_BAK_TeikikinKouzaDao() {
        super(IT_BAK_TeikikinKouza.class);
    }

    @Deprecated
    public IT_BAK_TeikikinKouza getBAKTeikikinKouza(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_TeikikinKouza iT_BAK_TeikikinKouza =  new IT_BAK_TeikikinKouza();
        iT_BAK_TeikikinKouza.setSyono(pSyono);
        iT_BAK_TeikikinKouza.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_TeikikinKouza);
    }

    @Override
    @Deprecated
    public List<IT_BAK_TeikikinKouza> selectAll() {
        return super.selectAll();
    }
}
