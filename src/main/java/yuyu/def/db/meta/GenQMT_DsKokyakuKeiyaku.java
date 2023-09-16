package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSyomenTtdkHyouji;
import yuyu.def.db.type.UserType_C_MukouHyj;

/**
 * ＤＳ顧客契約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsKokyakuKeiyaku extends AbstractExDBTable<MT_DsKokyakuKeiyaku> {

    public GenQMT_DsKokyakuKeiyaku() {
        this("MT_DsKokyakuKeiyaku");
    }

    public GenQMT_DsKokyakuKeiyaku(String pAlias) {
        super("MT_DsKokyakuKeiyaku", MT_DsKokyakuKeiyaku.class, pAlias);
    }

    public String MT_DsKokyakuKeiyaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, BizDate> dskykkanyuuymd = new ExDBFieldString<>("dskykkanyuuymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, BizDate> dskykhenkouymd = new ExDBFieldString<>("dskykhenkouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, C_MukouHyj> dskykmukouhyj = new ExDBFieldString<>("dskykmukouhyj", this, UserType_C_MukouHyj.class);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, BizDate> dskykmukouymd = new ExDBFieldString<>("dskykmukouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsKokyakuKeiyaku, C_DsSyomenTtdkHyouji> pplessrenjidssymenttdkhyj = new ExDBFieldString<>("pplessrenjidssymenttdkhyj", this, UserType_C_DsSyomenTtdkHyouji.class);
}
