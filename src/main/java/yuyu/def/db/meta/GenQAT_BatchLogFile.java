package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_BatchLogFile;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * バッチログファイルテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_BatchLogFile extends AbstractExDBTable<AT_BatchLogFile> {

    public GenQAT_BatchLogFile() {
        this("AT_BatchLogFile");
    }

    public GenQAT_BatchLogFile(String pAlias) {
        super("AT_BatchLogFile", AT_BatchLogFile.class, pAlias);
    }

    public String AT_BatchLogFile() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_BatchLogFile, String> batchJobId = new ExDBFieldString<>("batchJobId", this);

    public final ExDBFieldString<AT_BatchLogFile, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_BatchLogFile, BizDate> batchSyoriYmd = new ExDBFieldString<>("batchSyoriYmd", this, BizDateType.class);
}
