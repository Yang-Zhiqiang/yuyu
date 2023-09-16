package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.type.UserType_C_RirekiSyuruiKbn;

/**
 * ユーザーロール履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_UserRoleRireki extends AbstractExDBTable<AT_UserRoleRireki> {

    public GenQAT_UserRoleRireki() {
        this("AT_UserRoleRireki");
    }

    public GenQAT_UserRoleRireki(String pAlias) {
        super("AT_UserRoleRireki", AT_UserRoleRireki.class, pAlias);
    }

    public String AT_UserRoleRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_UserRoleRireki, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_UserRoleRireki, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_UserRoleRireki, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<AT_UserRoleRireki, C_RirekiSyuruiKbn> rirekiSyuruiKbn = new ExDBFieldString<>("rirekiSyuruiKbn", this, UserType_C_RirekiSyuruiKbn.class);
}
