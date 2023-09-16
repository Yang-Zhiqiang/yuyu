package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_FileRireki;

/**
 * ファイル履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileRireki extends AbstractExDBTable<AT_FileRireki> {

    public GenQAT_FileRireki() {
        this("AT_FileRireki");
    }

    public GenQAT_FileRireki(String pAlias) {
        super("AT_FileRireki", AT_FileRireki.class, pAlias);
    }

    public String AT_FileRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileRireki, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_FileRireki, String> historyId = new ExDBFieldString<>("historyId", this);

    public final ExDBFieldString<AT_FileRireki, String> fileNm = new ExDBFieldString<>("fileNm", this);

    public final ExDBFieldNumber<AT_FileRireki, Long> fileSize = new ExDBFieldNumber<>("fileSize", this);

    public final ExDBFieldString<AT_FileRireki, byte[]> fileContents = new ExDBFieldString<>("fileContents", this);

    public final ExDBFieldString<AT_FileRireki, String> tourokuTime = new ExDBFieldString<>("tourokuTime", this);

    public final ExDBFieldNumber<AT_FileRireki, Integer> fileNmSuffix = new ExDBFieldNumber<>("fileNmSuffix", this);
}
