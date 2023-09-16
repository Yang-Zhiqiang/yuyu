package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 死亡仮受付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SibouKariuketsuke extends AbstractExDBTable<JT_SibouKariuketsuke> {

    public GenQJT_SibouKariuketsuke() {
        this("JT_SibouKariuketsuke");
    }

    public GenQJT_SibouKariuketsuke(String pAlias) {
        super("JT_SibouKariuketsuke", JT_SibouKariuketsuke.class, pAlias);
    }

    public String JT_SibouKariuketsuke() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SibouKariuketsuke, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SibouKariuketsuke, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SibouKariuketsuke, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SibouKariuketsuke, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JT_SibouKariuketsuke, C_UmuKbn> torikesiflg = new ExDBFieldString<>("torikesiflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SibouKariuketsuke, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SibouKariuketsuke, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SibouKariuketsuke, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SibouKariuketsuke, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
