package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.classification.C_MqOnlineStatusKbn;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.type.UserType_C_MqEmgcyStopStatusKbn;
import yuyu.def.db.type.UserType_C_MqOnlineStatusKbn;

/**
 * ＭＱ情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_MqInfo extends AbstractExDBTable<AT_MqInfo> {

    public GenQAT_MqInfo() {
        this("AT_MqInfo");
    }

    public GenQAT_MqInfo(String pAlias) {
        super("AT_MqInfo", AT_MqInfo.class, pAlias);
    }

    public String AT_MqInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_MqInfo, String> serverType = new ExDBFieldString<>("serverType", this);

    public final ExDBFieldString<AT_MqInfo, C_MqOnlineStatusKbn> mqOnlineStatus = new ExDBFieldString<>("mqOnlineStatus", this, UserType_C_MqOnlineStatusKbn.class);

    public final ExDBFieldString<AT_MqInfo, C_MqEmgcyStopStatusKbn> mqEmgcyStopStatus = new ExDBFieldString<>("mqEmgcyStopStatus", this, UserType_C_MqEmgcyStopStatusKbn.class);

    public final ExDBFieldString<AT_MqInfo, String> rkmAtesaki = new ExDBFieldString<>("rkmAtesaki", this);

    public final ExDBFieldString<AT_MqInfo, String> contextPath = new ExDBFieldString<>("contextPath", this);
}
