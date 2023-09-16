package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NiGamenModeJyoutaiKbn;
import yuyu.def.db.entity.AT_UserSettei;
import yuyu.def.db.type.UserType_C_NiGamenModeJyoutaiKbn;

/**
 * ユーザー設定テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_UserSettei extends AbstractExDBTable<AT_UserSettei> {

    public GenQAT_UserSettei() {
        this("AT_UserSettei");
    }

    public GenQAT_UserSettei(String pAlias) {
        super("AT_UserSettei", AT_UserSettei.class, pAlias);
    }

    public String AT_UserSettei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_UserSettei, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_UserSettei, C_NiGamenModeJyoutaiKbn> niGamenModKbn = new ExDBFieldString<>("niGamenModKbn", this, UserType_C_NiGamenModeJyoutaiKbn.class);
}
