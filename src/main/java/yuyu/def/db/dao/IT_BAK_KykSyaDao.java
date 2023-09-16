package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KykSya;

/**
 * 契約者バックアップテーブル(IT_BAK_KykSyaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykSyaDao extends AbstractDao<IT_BAK_KykSya> {

    public IT_BAK_KykSyaDao() {
        super(IT_BAK_KykSya.class);
    }

    @Deprecated
    public IT_BAK_KykSya getBAKKykSya(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_KykSya iT_BAK_KykSya =  new IT_BAK_KykSya();
        iT_BAK_KykSya.setSyono(pSyono);
        iT_BAK_KykSya.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KykSya);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykSya> selectAll() {
        return super.selectAll();
    }
}
