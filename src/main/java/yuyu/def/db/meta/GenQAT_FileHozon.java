package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_FileHozon;

/**
 * ファイル保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileHozon extends AbstractExDBTable<AT_FileHozon> {

    public GenQAT_FileHozon() {
        this("AT_FileHozon");
    }

    public GenQAT_FileHozon(String pAlias) {
        super("AT_FileHozon", AT_FileHozon.class, pAlias);
    }

    public String AT_FileHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileHozon, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_FileHozon, byte[]> fileContents = new ExDBFieldString<>("fileContents", this);
}
