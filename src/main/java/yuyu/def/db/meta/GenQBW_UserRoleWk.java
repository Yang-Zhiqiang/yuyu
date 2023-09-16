package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BW_UserRoleWk;

/**
 * ユーザーロールワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_UserRoleWk extends AbstractExDBTable<BW_UserRoleWk> {

    public GenQBW_UserRoleWk() {
        this("BW_UserRoleWk");
    }

    public GenQBW_UserRoleWk(String pAlias) {
        super("BW_UserRoleWk", BW_UserRoleWk.class, pAlias);
    }

    public String BW_UserRoleWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_UserRoleWk, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<BW_UserRoleWk, String> roleCd = new ExDBFieldString<>("roleCd", this);
}
