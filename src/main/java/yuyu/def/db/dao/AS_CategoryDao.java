package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_Category;

/**
 * カテゴリ基幹テーブル ( AS_Category ) アクセス用の DAO クラスです。
 */
public class AS_CategoryDao extends AbstractDao<AS_Category> {

    protected AS_CategoryDao() {
        super(AS_Category.class);
    }

    public AS_Category getAS_Category(String pCategoryId) {
        AS_Category condEntity = new AS_Category();
        condEntity.setCategoryId(pCategoryId);
        return selectOne(condEntity);
    }
}
