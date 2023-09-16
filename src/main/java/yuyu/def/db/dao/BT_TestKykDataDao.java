package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_TestKykData;

/**
 * テスト用契約データ抽出テーブル(BT_TestKykDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TestKykDataDao extends AbstractDao<BT_TestKykData> {

    public BT_TestKykDataDao() {
        super(BT_TestKykData.class);
    }

    public BT_TestKykData getTestKykData(String pUniqueId) {
        BT_TestKykData bT_TestKykData =  new BT_TestKykData();
        bT_TestKykData.setUniqueId(pUniqueId);
        return this.selectOne(bT_TestKykData);
    }
}
