package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_PasswordRireki;

/**
 * パスワード履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_PasswordRireki extends AbstractExDBTable<AT_PasswordRireki> {

    public GenQAT_PasswordRireki() {
        this("AT_PasswordRireki");
    }

    public GenQAT_PasswordRireki(String pAlias) {
        super("AT_PasswordRireki", AT_PasswordRireki.class, pAlias);
    }

    public String AT_PasswordRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_PasswordRireki, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_PasswordRireki, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_PasswordRireki, String> password = new ExDBFieldString<>("password", this);
}
