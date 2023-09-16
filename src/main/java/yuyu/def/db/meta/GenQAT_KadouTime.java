package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.type.UserType_C_EigyoubiKbn;
import yuyu.def.db.type.UserType_C_KadouTimeSiteiKbn;
import yuyu.def.db.type.UserType_C_KadouTimeYoubiKbn;

/**
 * 稼働時間テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_KadouTime extends AbstractExDBTable<AT_KadouTime> {

    public GenQAT_KadouTime() {
        this("AT_KadouTime");
    }

    public GenQAT_KadouTime(String pAlias) {
        super("AT_KadouTime", AT_KadouTime.class, pAlias);
    }

    public String AT_KadouTime() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeGroupCd = new ExDBFieldString<>("kadouTimeGroupCd", this);

    public final ExDBFieldString<AT_KadouTime, C_KadouTimeYoubiKbn> kadouTimeYoubiKbn = new ExDBFieldString<>("kadouTimeYoubiKbn", this, UserType_C_KadouTimeYoubiKbn.class);

    public final ExDBFieldString<AT_KadouTime, C_EigyoubiKbn> eigyoubiKbn = new ExDBFieldString<>("eigyoubiKbn", this, UserType_C_EigyoubiKbn.class);

    public final ExDBFieldString<AT_KadouTime, C_KadouTimeSiteiKbn> kadouTimeSiteiKbn = new ExDBFieldString<>("kadouTimeSiteiKbn", this, UserType_C_KadouTimeSiteiKbn.class);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeFrom1 = new ExDBFieldString<>("kadouTimeFrom1", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeTo1 = new ExDBFieldString<>("kadouTimeTo1", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeFrom2 = new ExDBFieldString<>("kadouTimeFrom2", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeTo2 = new ExDBFieldString<>("kadouTimeTo2", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeFrom3 = new ExDBFieldString<>("kadouTimeFrom3", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeTo3 = new ExDBFieldString<>("kadouTimeTo3", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeFrom4 = new ExDBFieldString<>("kadouTimeFrom4", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeTo4 = new ExDBFieldString<>("kadouTimeTo4", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeFrom5 = new ExDBFieldString<>("kadouTimeFrom5", this);

    public final ExDBFieldString<AT_KadouTime, String> kadouTimeTo5 = new ExDBFieldString<>("kadouTimeTo5", this);
}
