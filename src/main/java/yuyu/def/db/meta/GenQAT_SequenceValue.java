package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_SequenceValue;

/**
 * 連番値管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_SequenceValue extends AbstractExDBTable<AT_SequenceValue> {

    public GenQAT_SequenceValue() {
        this("AT_SequenceValue");
    }

    public GenQAT_SequenceValue(String pAlias) {
        super("AT_SequenceValue", AT_SequenceValue.class, pAlias);
    }

    public String AT_SequenceValue() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_SequenceValue, String> id = new ExDBFieldString<>("id", this);

    public final ExDBFieldString<AT_SequenceValue, String> keys = new ExDBFieldString<>("keys", this);

    public final ExDBFieldNumber<AT_SequenceValue, Long> currentValue = new ExDBFieldNumber<>("currentValue", this);
}
