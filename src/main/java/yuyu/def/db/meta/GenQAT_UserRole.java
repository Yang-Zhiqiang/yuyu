package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_UserRole;

/**
 * ユーザーロールテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_UserRole extends AbstractExDBTable<AT_UserRole> {

    public GenQAT_UserRole() {
        this("AT_UserRole");
    }

    public GenQAT_UserRole(String pAlias) {
        super("AT_UserRole", AT_UserRole.class, pAlias);
    }

    public String AT_UserRole() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_UserRole, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_UserRole, String> roleCd = new ExDBFieldString<>("roleCd", this);
}
