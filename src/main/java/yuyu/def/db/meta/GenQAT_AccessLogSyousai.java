package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_AccessLogSyousai;

/**
 * アクセスログ詳細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_AccessLogSyousai extends AbstractExDBTable<AT_AccessLogSyousai> {

    public GenQAT_AccessLogSyousai() {
        this("AT_AccessLogSyousai");
    }

    public GenQAT_AccessLogSyousai(String pAlias) {
        super("AT_AccessLogSyousai", AT_AccessLogSyousai.class, pAlias);
    }

    public String AT_AccessLogSyousai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_AccessLogSyousai, String> logId = new ExDBFieldString<>("logId", this);

    public final ExDBFieldNumber<AT_AccessLogSyousai, Long> syousaiEdaNo = new ExDBFieldNumber<>("syousaiEdaNo", this);

    public final ExDBFieldString<AT_AccessLogSyousai, String> logSyousaiData = new ExDBFieldString<>("logSyousaiData", this);
}
