package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_TorikomiRelation;

/**
 * 取込関連テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_TorikomiRelation extends AbstractExDBTable<WT_TorikomiRelation> {

    public GenQWT_TorikomiRelation() {
        this("WT_TorikomiRelation");
    }

    public GenQWT_TorikomiRelation(String pAlias) {
        super("WT_TorikomiRelation", WT_TorikomiRelation.class, pAlias);
    }

    public String WT_TorikomiRelation() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_TorikomiRelation, String> iwfImageId = new ExDBFieldString<>("iwfImageId", this);

    public final ExDBFieldString<WT_TorikomiRelation, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);
}
