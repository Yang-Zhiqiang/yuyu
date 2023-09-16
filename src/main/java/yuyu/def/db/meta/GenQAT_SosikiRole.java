package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_SosikiRole;

/**
 * 組織ロールテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_SosikiRole extends AbstractExDBTable<AT_SosikiRole> {

    public GenQAT_SosikiRole() {
        this("AT_SosikiRole");
    }

    public GenQAT_SosikiRole(String pAlias) {
        super("AT_SosikiRole", AT_SosikiRole.class, pAlias);
    }

    public String AT_SosikiRole() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_SosikiRole, String> tanmatusettisosikicd = new ExDBFieldString<>("tanmatusettisosikicd", this);

    public final ExDBFieldString<AT_SosikiRole, String> roleCd = new ExDBFieldString<>("roleCd", this);
}
