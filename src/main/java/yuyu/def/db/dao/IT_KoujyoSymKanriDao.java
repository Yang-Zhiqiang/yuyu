package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KoujyoSymKanri;

/**
 * 控除証明書管理テーブル(IT_KoujyoSymKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KoujyoSymKanriDao extends AbstractDao<IT_KoujyoSymKanri> {

    public IT_KoujyoSymKanriDao() {
        super(IT_KoujyoSymKanri.class);
    }

    @Deprecated
    public IT_KoujyoSymKanri getKoujyoSymKanri(String pSyono,
         String pNendo){
        IT_KoujyoSymKanri iT_KoujyoSymKanri =  new IT_KoujyoSymKanri();
        iT_KoujyoSymKanri.setSyono(pSyono);
        iT_KoujyoSymKanri.setNendo(pNendo);
        return this.selectOne(iT_KoujyoSymKanri);
    }

    @Override
    @Deprecated
    public List<IT_KoujyoSymKanri> selectAll() {
        return super.selectAll();
    }
}
