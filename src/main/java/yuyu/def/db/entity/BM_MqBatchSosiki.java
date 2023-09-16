package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_MqBatchSosiki;

/**
 * ＭＱ用バッチ処理担当組織マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_MqBatchSosiki} の JavaDoc を参照してください。<br />
 * @see     GenBM_MqBatchSosiki<br />
 * @see     PKBM_MqBatchSosiki<br />
 * @see     QBM_MqBatchSosiki<br />
 * @see     GenQBM_MqBatchSosiki<br />
 */
@Entity
public class BM_MqBatchSosiki extends GenBM_MqBatchSosiki {

    private static final long serialVersionUID = 1L;

    public BM_MqBatchSosiki() {
    }

    public BM_MqBatchSosiki(String pKinouId) {
        super(pKinouId);
    }



}

