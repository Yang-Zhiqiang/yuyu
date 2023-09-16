package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HozonHousiki;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.type.UserType_C_HozonHousiki;

/**
 * ファイル履歴管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileRirekiKanri extends AbstractExDBTable<AT_FileRirekiKanri> {

    public GenQAT_FileRirekiKanri() {
        this("AT_FileRirekiKanri");
    }

    public GenQAT_FileRirekiKanri(String pAlias) {
        super("AT_FileRirekiKanri", AT_FileRirekiKanri.class, pAlias);
    }

    public String AT_FileRirekiKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileRirekiKanri, String> historyId = new ExDBFieldString<>("historyId", this);

    public final ExDBFieldString<AT_FileRirekiKanri, C_HozonHousiki> hozonHousiki = new ExDBFieldString<>("hozonHousiki", this, UserType_C_HozonHousiki.class);

    public final ExDBFieldString<AT_FileRirekiKanri, String> hozonSaki = new ExDBFieldString<>("hozonSaki", this);

    public final ExDBFieldString<AT_FileRirekiKanri, String> namingPattern = new ExDBFieldString<>("namingPattern", this);

    public final ExDBFieldString<AT_FileRirekiKanri, String> rirekiSakujyoJyouken = new ExDBFieldString<>("rirekiSakujyoJyouken", this);
}
