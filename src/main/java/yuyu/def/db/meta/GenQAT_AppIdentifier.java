package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_AppIdentifier;

/**
 * アプリケーション識別子管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_AppIdentifier extends AbstractExDBTable<AT_AppIdentifier> {

    public GenQAT_AppIdentifier() {
        this("AT_AppIdentifier");
    }

    public GenQAT_AppIdentifier(String pAlias) {
        super("AT_AppIdentifier", AT_AppIdentifier.class, pAlias);
    }

    public String AT_AppIdentifier() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_AppIdentifier, String> identifier = new ExDBFieldString<>("identifier", this);

    public final ExDBFieldString<AT_AppIdentifier, String> touchTime = new ExDBFieldString<>("touchTime", this);
}
