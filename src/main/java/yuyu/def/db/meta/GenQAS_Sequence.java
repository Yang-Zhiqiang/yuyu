package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 連番管理基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_Sequence extends AbstractExDBTable<AS_Sequence> {

    public GenQAS_Sequence() {
        this("AS_Sequence");
    }

    public GenQAS_Sequence(String pAlias) {
        super("AS_Sequence", AS_Sequence.class, pAlias);
    }

    public String AS_Sequence() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_Sequence, String> id = new ExDBFieldString<>("id", this);

    public final ExDBFieldString<AS_Sequence, String> name = new ExDBFieldString<>("name", this);

    public final ExDBFieldNumber<AS_Sequence, Long> startWith = new ExDBFieldNumber<>("startWith", this);

    public final ExDBFieldNumber<AS_Sequence, Integer> increase = new ExDBFieldNumber<>("increase", this);

    public final ExDBFieldNumber<AS_Sequence, Long> maxValue = new ExDBFieldNumber<>("maxValue", this);

    public final ExDBFieldNumber<AS_Sequence, Integer> cacheSize = new ExDBFieldNumber<>("cacheSize", this);

    public final ExDBFieldString<AS_Sequence, C_UmuKbn> padding = new ExDBFieldString<>("padding", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<AS_Sequence, Integer> length = new ExDBFieldNumber<>("length", this);
}
