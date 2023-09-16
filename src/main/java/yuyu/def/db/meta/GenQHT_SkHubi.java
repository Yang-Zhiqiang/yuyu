package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_RnrkskhaneiKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.type.UserType_C_RnrkskhaneiKbn;

/**
 * 新契約不備テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkHubi extends AbstractExDBTable<HT_SkHubi> {

    public GenQHT_SkHubi() {
        this("HT_SkHubi");
    }

    public GenQHT_SkHubi(String pAlias) {
        super("HT_SkHubi", HT_SkHubi.class, pAlias);
    }

    public String HT_SkHubi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkHubi, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkHubi, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldString<HT_SkHubi, String> jimutetuzukinm = new ExDBFieldString<>("jimutetuzukinm", this);

    public final ExDBFieldString<HT_SkHubi, C_RnrkskhaneiKbn> rnrkskhaneikbn = new ExDBFieldString<>("rnrkskhaneikbn", this, UserType_C_RnrkskhaneiKbn.class);

    public final ExDBFieldString<HT_SkHubi, String> utdskknnm1kj = new ExDBFieldString<>("utdskknnm1kj", this);

    public final ExDBFieldString<HT_SkHubi, String> utdskknnm2kj = new ExDBFieldString<>("utdskknnm2kj", this);

    public final ExDBFieldString<HT_SkHubi, String> tuutisakitantounmkj = new ExDBFieldString<>("tuutisakitantounmkj", this);

    public final ExDBFieldString<HT_SkHubi, String> tuutikyokasyanmkj = new ExDBFieldString<>("tuutikyokasyanmkj", this);

    public final ExDBFieldString<HT_SkHubi, String> commentarea = new ExDBFieldString<>("commentarea", this);

    public final ExDBFieldString<HT_SkHubi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
