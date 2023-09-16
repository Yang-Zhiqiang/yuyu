package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.def.db.type.UserType_C_MqEmgcyStopStatusKbn;

/**
 * システム制御情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_SystemControlInfo extends AbstractExDBTable<AT_SystemControlInfo> {

    public GenQAT_SystemControlInfo() {
        this("AT_SystemControlInfo");
    }

    public GenQAT_SystemControlInfo(String pAlias) {
        super("AT_SystemControlInfo", AT_SystemControlInfo.class, pAlias);
    }

    public String AT_SystemControlInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_SystemControlInfo, String> systemCtrlInfo = new ExDBFieldString<>("systemCtrlInfo", this);

    public final ExDBFieldString<AT_SystemControlInfo, C_MqEmgcyStopStatusKbn> mqEmgcyStopStatus = new ExDBFieldString<>("mqEmgcyStopStatus", this, UserType_C_MqEmgcyStopStatusKbn.class);

    public final ExDBFieldString<AT_SystemControlInfo, String> onlineStatus = new ExDBFieldString<>("onlineStatus", this);
}
