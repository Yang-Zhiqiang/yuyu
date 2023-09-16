package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.type.UserType_C_AccessLogSyubetuKbn;

/**
 * アクセスログテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_AccessLog extends AbstractExDBTable<AT_AccessLog> {

    public GenQAT_AccessLog() {
        this("AT_AccessLog");
    }

    public GenQAT_AccessLog(String pAlias) {
        super("AT_AccessLog", AT_AccessLog.class, pAlias);
    }

    public String AT_AccessLog() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_AccessLog, String> logId = new ExDBFieldString<>("logId", this);

    public final ExDBFieldNumber<AT_AccessLog, Long> timeStamp = new ExDBFieldNumber<>("timeStamp", this);

    public final ExDBFieldString<AT_AccessLog, String> syoriUserId = new ExDBFieldString<>("syoriUserId", this);

    public final ExDBFieldString<AT_AccessLog, String> ipAddress = new ExDBFieldString<>("ipAddress", this);

    public final ExDBFieldString<AT_AccessLog, String> sessionId = new ExDBFieldString<>("sessionId", this);

    public final ExDBFieldString<AT_AccessLog, String> transactionId = new ExDBFieldString<>("transactionId", this);

    public final ExDBFieldString<AT_AccessLog, C_AccessLogSyubetuKbn> logKindCd = new ExDBFieldString<>("logKindCd", this, UserType_C_AccessLogSyubetuKbn.class);

    public final ExDBFieldString<AT_AccessLog, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AT_AccessLog, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AT_AccessLog, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AT_AccessLog, String> tanmatuType = new ExDBFieldString<>("tanmatuType", this);

    public final ExDBFieldString<AT_AccessLog, String> butsuriSosikiCd = new ExDBFieldString<>("butsuriSosikiCd", this);

    public final ExDBFieldString<AT_AccessLog, String> ronriSosikiCd = new ExDBFieldString<>("ronriSosikiCd", this);

    public final ExDBFieldString<AT_AccessLog, String> tanmatuJyoutaiHyouji = new ExDBFieldString<>("tanmatuJyoutaiHyouji", this);

    public final ExDBFieldString<AT_AccessLog, String> logData = new ExDBFieldString<>("logData", this);

    public final ExDBFieldNumber<AT_AccessLog, Long> syousaiKensuu = new ExDBFieldNumber<>("syousaiKensuu", this);
}
