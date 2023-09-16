package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_HhknSya;

/**
 * 被保険者バックアップテーブル(IT_BAK_HhknSyaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HhknSyaDao extends AbstractDao<IT_BAK_HhknSya> {

    public IT_BAK_HhknSyaDao() {
        super(IT_BAK_HhknSya.class);
    }

    @Deprecated
    public IT_BAK_HhknSya getBAKHhknSya(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_HhknSya iT_BAK_HhknSya =  new IT_BAK_HhknSya();
        iT_BAK_HhknSya.setSyono(pSyono);
        iT_BAK_HhknSya.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_HhknSya);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HhknSya> selectAll() {
        return super.selectAll();
    }
}
