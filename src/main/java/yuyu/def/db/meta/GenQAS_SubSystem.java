package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AS_SubSystem;

/**
 * サブシステム基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_SubSystem extends AbstractExDBTable<AS_SubSystem> {

    public GenQAS_SubSystem() {
        this("AS_SubSystem");
    }

    public GenQAS_SubSystem(String pAlias) {
        super("AS_SubSystem", AS_SubSystem.class, pAlias);
    }

    public String AS_SubSystem() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_SubSystem, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AS_SubSystem, String> subSystemNm = new ExDBFieldString<>("subSystemNm", this);

    public final ExDBFieldNumber<AS_SubSystem, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<AS_SubSystem, String> linkImage = new ExDBFieldString<>("linkImage", this);

    public final ExDBFieldString<AS_SubSystem, String> hyoudaiImage = new ExDBFieldString<>("hyoudaiImage", this);
}
