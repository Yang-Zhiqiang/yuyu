package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KadouTimeSiteiKbn;

/**
 * 特定日稼働時間テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_TokuteibiKadouTime extends AbstractExDBTable<AT_TokuteibiKadouTime> {

    public GenQAT_TokuteibiKadouTime() {
        this("AT_TokuteibiKadouTime");
    }

    public GenQAT_TokuteibiKadouTime(String pAlias) {
        super("AT_TokuteibiKadouTime", AT_TokuteibiKadouTime.class, pAlias);
    }

    public String AT_TokuteibiKadouTime() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeGroupCd = new ExDBFieldString<>("kadouTimeGroupCd", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, BizDate> kadouTimeSiteiYmd = new ExDBFieldString<>("kadouTimeSiteiYmd", this, BizDateType.class);

    public final ExDBFieldString<AT_TokuteibiKadouTime, C_KadouTimeSiteiKbn> kadouTimeSiteiKbn = new ExDBFieldString<>("kadouTimeSiteiKbn", this, UserType_C_KadouTimeSiteiKbn.class);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeFrom1 = new ExDBFieldString<>("kadouTimeFrom1", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeTo1 = new ExDBFieldString<>("kadouTimeTo1", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeFrom2 = new ExDBFieldString<>("kadouTimeFrom2", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeTo2 = new ExDBFieldString<>("kadouTimeTo2", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeFrom3 = new ExDBFieldString<>("kadouTimeFrom3", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeTo3 = new ExDBFieldString<>("kadouTimeTo3", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeFrom4 = new ExDBFieldString<>("kadouTimeFrom4", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeTo4 = new ExDBFieldString<>("kadouTimeTo4", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeFrom5 = new ExDBFieldString<>("kadouTimeFrom5", this);

    public final ExDBFieldString<AT_TokuteibiKadouTime, String> kadouTimeTo5 = new ExDBFieldString<>("kadouTimeTo5", this);
}
