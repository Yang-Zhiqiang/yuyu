package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_SkipKey;

/**
 * スキップキーテーブル(BT_SkipKeyDao) アクセス用の DAO クラスです。<br />
 */
public class BT_SkipKeyDao extends AbstractDao<BT_SkipKey> {

    public BT_SkipKeyDao() {
        super(BT_SkipKey.class);
    }

    public BT_SkipKey getSkipKey(String pRecoverysikibetukey){
        BT_SkipKey bT_SkipKey =  new BT_SkipKey();
        bT_SkipKey.setRecoverysikibetukey(pRecoverysikibetukey);
        return this.selectOne(bT_SkipKey);
    }
}
