package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.db.entity.AT_Holiday;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HolidayPtn;
import yuyu.def.db.type.UserType_C_LegalHolidayKbn;

/**
 * 休日テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_Holiday extends AbstractExDBTable<AT_Holiday> {

    public GenQAT_Holiday() {
        this("AT_Holiday");
    }

    public GenQAT_Holiday(String pAlias) {
        super("AT_Holiday", AT_Holiday.class, pAlias);
    }

    public String AT_Holiday() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_Holiday, String> holidayGroupCd = new ExDBFieldString<>("holidayGroupCd", this);

    public final ExDBFieldString<AT_Holiday, String> holidayCd = new ExDBFieldString<>("holidayCd", this);

    public final ExDBFieldString<AT_Holiday, C_LegalHolidayKbn> legalHolidayKbn = new ExDBFieldString<>("legalHolidayKbn", this, UserType_C_LegalHolidayKbn.class);

    public final ExDBFieldString<AT_Holiday, BizDate> tekiyouYmdFrom = new ExDBFieldString<>("tekiyouYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<AT_Holiday, BizDate> tekiyouYmdTo = new ExDBFieldString<>("tekiyouYmdTo", this, BizDateType.class);

    public final ExDBFieldString<AT_Holiday, C_HolidayPtn> holidayPattern = new ExDBFieldString<>("holidayPattern", this, UserType_C_HolidayPtn.class);

    public final ExDBFieldString<AT_Holiday, String> holidayPatternParam = new ExDBFieldString<>("holidayPatternParam", this);

    public final ExDBFieldString<AT_Holiday, String> holidayPatternNm = new ExDBFieldString<>("holidayPatternNm", this);

    public final ExDBFieldString<AT_Holiday, String> holidayPatternDescription = new ExDBFieldString<>("holidayPatternDescription", this);
}
