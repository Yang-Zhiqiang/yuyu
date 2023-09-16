package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_UserIdKanren;

/**
 * ユーザーＩＤ関連テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_UserIdKanren extends AbstractExDBTable<AT_UserIdKanren> {

    public GenQAT_UserIdKanren() {
        this("AT_UserIdKanren");
    }

    public GenQAT_UserIdKanren(String pAlias) {
        super("AT_UserIdKanren", AT_UserIdKanren.class, pAlias);
    }

    public String AT_UserIdKanren() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_UserIdKanren, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<AT_UserIdKanren, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<AT_UserIdKanren, String> userId = new ExDBFieldString<>("userId", this);
}
