package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_MqBatchSosiki;

/**
 * ＭＱ用バッチ処理担当組織マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_MqBatchSosiki extends AbstractExDBTable<BM_MqBatchSosiki> {

    public GenQBM_MqBatchSosiki() {
        this("BM_MqBatchSosiki");
    }

    public GenQBM_MqBatchSosiki(String pAlias) {
        super("BM_MqBatchSosiki", BM_MqBatchSosiki.class, pAlias);
    }

    public String BM_MqBatchSosiki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_MqBatchSosiki, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<BM_MqBatchSosiki, String> sosikicd = new ExDBFieldString<>("sosikicd", this);
}
