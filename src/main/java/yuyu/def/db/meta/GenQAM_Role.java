package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.type.UserType_C_SysSiyouKbn;

/**
 * ロールマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_Role extends AbstractExDBTable<AM_Role> {

    public GenQAM_Role() {
        this("AM_Role");
    }

    public GenQAM_Role(String pAlias) {
        super("AM_Role", AM_Role.class, pAlias);
    }

    public String AM_Role() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_Role, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<AM_Role, String> roleNm = new ExDBFieldString<>("roleNm", this);

    public final ExDBFieldString<AM_Role, String> roleSetumei = new ExDBFieldString<>("roleSetumei", this);

    public final ExDBFieldString<AM_Role, C_SysSiyouKbn> sysSiyouKbn = new ExDBFieldString<>("sysSiyouKbn", this, UserType_C_SysSiyouKbn.class);
}
