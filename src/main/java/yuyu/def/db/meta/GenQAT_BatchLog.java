package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.type.UserType_C_LogLevelKbn;

/**
 * バッチログテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_BatchLog extends AbstractExDBTable<AT_BatchLog> {

    public GenQAT_BatchLog() {
        this("AT_BatchLog");
    }

    public GenQAT_BatchLog(String pAlias) {
        super("AT_BatchLog", AT_BatchLog.class, pAlias);
    }

    public String AT_BatchLog() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_BatchLog, String> batchJobId = new ExDBFieldString<>("batchJobId", this);

    public final ExDBFieldNumber<AT_BatchLog, Integer> batchLogEdaNo = new ExDBFieldNumber<>("batchLogEdaNo", this);

    public final ExDBFieldString<AT_BatchLog, String> logOutputTime = new ExDBFieldString<>("logOutputTime", this);

    public final ExDBFieldString<AT_BatchLog, C_LogLevelKbn> logLevelKbn = new ExDBFieldString<>("logLevelKbn", this, UserType_C_LogLevelKbn.class);

    public final ExDBFieldString<AT_BatchLog, String> logNaiyou = new ExDBFieldString<>("logNaiyou", this);
}
