package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.type.UserType_C_OrderStatusuKbn;

/**
 * バッチ予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_BatchOrder extends AbstractExDBTable<AS_BatchOrder> {

    public GenQAS_BatchOrder() {
        this("AS_BatchOrder");
    }

    public GenQAS_BatchOrder(String pAlias) {
        super("AS_BatchOrder", AS_BatchOrder.class, pAlias);
    }

    public String AS_BatchOrder() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_BatchOrder, String> batchJobId = new ExDBFieldString<>("batchJobId", this);

    public final ExDBFieldString<AS_BatchOrder, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AS_BatchOrder, C_OrderStatusuKbn> orderStatus = new ExDBFieldString<>("orderStatus", this, UserType_C_OrderStatusuKbn.class);

    public final ExDBFieldString<AS_BatchOrder, String> orderTime = new ExDBFieldString<>("orderTime", this);
}
