package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_MqBatchSosiki;

/**
 * ＭＱ用バッチ処理担当組織マスタ(BM_MqBatchSosikiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_MqBatchSosikiDao extends AbstractDao<BM_MqBatchSosiki> {

    public BM_MqBatchSosikiDao() {
        super(BM_MqBatchSosiki.class);
    }

    public BM_MqBatchSosiki getMqBatchSosiki(String pKinouId) {
        BM_MqBatchSosiki bM_MqBatchSosiki =  new BM_MqBatchSosiki();
        bM_MqBatchSosiki.setKinouId(pKinouId);
        return this.selectOne(bM_MqBatchSosiki);
    }
}
