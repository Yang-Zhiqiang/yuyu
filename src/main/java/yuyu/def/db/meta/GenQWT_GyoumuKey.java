package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_GyoumuKey;

/**
 * 業務キーテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_GyoumuKey extends AbstractExDBTable<WT_GyoumuKey> {

    public GenQWT_GyoumuKey() {
        this("WT_GyoumuKey");
    }

    public GenQWT_GyoumuKey(String pAlias) {
        super("WT_GyoumuKey", WT_GyoumuKey.class, pAlias);
    }

    public String WT_GyoumuKey() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_GyoumuKey, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_GyoumuKey, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);

    public final ExDBFieldString<WT_GyoumuKey, String> tokenId = new ExDBFieldString<>("tokenId", this);

    public final ExDBFieldString<WT_GyoumuKey, String> createTime = new ExDBFieldString<>("createTime", this);
}
