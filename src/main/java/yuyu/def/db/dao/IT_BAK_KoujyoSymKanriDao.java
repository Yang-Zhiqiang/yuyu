package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KoujyoSymKanri;

/**
 * 控除証明書管理バックアップテーブル(IT_BAK_KoujyoSymKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KoujyoSymKanriDao extends AbstractDao<IT_BAK_KoujyoSymKanri> {

    public IT_BAK_KoujyoSymKanriDao() {
        super(IT_BAK_KoujyoSymKanri.class);
    }

    @Deprecated
    public IT_BAK_KoujyoSymKanri getBAKKoujyoSymKanri(String pSyono,
         String pTrkssikibetukey,
         String pNendo){
        IT_BAK_KoujyoSymKanri iT_BAK_KoujyoSymKanri =  new IT_BAK_KoujyoSymKanri();
        iT_BAK_KoujyoSymKanri.setSyono(pSyono);
        iT_BAK_KoujyoSymKanri.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KoujyoSymKanri.setNendo(pNendo);
        return this.selectOne(iT_BAK_KoujyoSymKanri);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KoujyoSymKanri> selectAll() {
        return super.selectAll();
    }
}
