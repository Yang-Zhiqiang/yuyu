package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_FileSansyoKaisu;

/**
 * ファイル参照回数テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileSansyoKaisu extends AbstractExDBTable<AT_FileSansyoKaisu> {

    public GenQAT_FileSansyoKaisu() {
        this("AT_FileSansyoKaisu");
    }

    public GenQAT_FileSansyoKaisu(String pAlias) {
        super("AT_FileSansyoKaisu", AT_FileSansyoKaisu.class, pAlias);
    }

    public String AT_FileSansyoKaisu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileSansyoKaisu, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldNumber<AT_FileSansyoKaisu, Integer> sansyoucount = new ExDBFieldNumber<>("sansyoucount", this);
}
