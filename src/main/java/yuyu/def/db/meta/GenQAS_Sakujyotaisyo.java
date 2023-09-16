package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.classification.C_SakujyoKbn;
import yuyu.def.classification.C_SakujyoKeyKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.type.UserType_C_NengappiKbn;
import yuyu.def.db.type.UserType_C_SakujyoKbn;
import yuyu.def.db.type.UserType_C_SakujyoKeyKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 削除対象基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_Sakujyotaisyo extends AbstractExDBTable<AS_Sakujyotaisyo> {

    public GenQAS_Sakujyotaisyo() {
        this("AS_Sakujyotaisyo");
    }

    public GenQAS_Sakujyotaisyo(String pAlias) {
        super("AS_Sakujyotaisyo", AS_Sakujyotaisyo.class, pAlias);
    }

    public String AS_Sakujyotaisyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_Sakujyotaisyo, String> sakujyoTableId = new ExDBFieldString<>("sakujyoTableId", this);

    public final ExDBFieldString<AS_Sakujyotaisyo, C_SakujyoKbn> sakujyoKbn = new ExDBFieldString<>("sakujyoKbn", this, UserType_C_SakujyoKbn.class);

    public final ExDBFieldString<AS_Sakujyotaisyo, String> sakujyoKey = new ExDBFieldString<>("sakujyoKey", this);

    public final ExDBFieldString<AS_Sakujyotaisyo, C_SakujyoKeyKbn> sakujyoKeyKbn = new ExDBFieldString<>("sakujyoKeyKbn", this, UserType_C_SakujyoKeyKbn.class);

    public final ExDBFieldNumber<AS_Sakujyotaisyo, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldString<AS_Sakujyotaisyo, C_NengappiKbn> nengappiKbn = new ExDBFieldString<>("nengappiKbn", this, UserType_C_NengappiKbn.class);

    public final ExDBFieldString<AS_Sakujyotaisyo, C_UmuKbn> dataTaihiKbn = new ExDBFieldString<>("dataTaihiKbn", this, UserType_C_UmuKbn.class);
}
