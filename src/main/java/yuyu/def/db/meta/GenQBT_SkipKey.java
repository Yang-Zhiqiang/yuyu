package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_SkipKey;

/**
 * スキップキーテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SkipKey extends AbstractExDBTable<BT_SkipKey> {

    public GenQBT_SkipKey() {
        this("BT_SkipKey");
    }

    public GenQBT_SkipKey(String pAlias) {
        super("BT_SkipKey", BT_SkipKey.class, pAlias);
    }

    public String BT_SkipKey() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SkipKey, String> recoverysikibetukey = new ExDBFieldString<>("recoverysikibetukey", this);

    public final ExDBFieldString<BT_SkipKey, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<BT_SkipKey, String> tableid = new ExDBFieldString<>("tableid", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterid = new ExDBFieldString<>("recoveryfilterid", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterkey1 = new ExDBFieldString<>("recoveryfilterkey1", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterkey2 = new ExDBFieldString<>("recoveryfilterkey2", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterkey3 = new ExDBFieldString<>("recoveryfilterkey3", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterkey4 = new ExDBFieldString<>("recoveryfilterkey4", this);

    public final ExDBFieldString<BT_SkipKey, String> recoveryfilterkey5 = new ExDBFieldString<>("recoveryfilterkey5", this);
}
