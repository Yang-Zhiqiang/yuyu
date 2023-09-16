package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_SubSystem;

/**
 * サブシステム基幹テーブル ( AS_SubSystem ) アクセス用の DAO クラスです。
 */
public class AS_SubSystemDao extends AbstractDao<AS_SubSystem> {

    protected AS_SubSystemDao() {
        super(AS_SubSystem.class);
    }

    public AS_SubSystem getAS_SubSystem(String pSubSystemId) {
        AS_SubSystem condEntity = new AS_SubSystem();
        condEntity.setSubSystemId(pSubSystemId);
        return selectOne(condEntity);
    }

}