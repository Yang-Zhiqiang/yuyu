package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.classification.C_YoyakuKbn;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HolidayPtn;
import yuyu.def.db.type.UserType_C_LegalHolidayKbn;
import yuyu.def.db.type.UserType_C_YoyakuKbn;

/**
 * 休日予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_HolidayYoyaku extends AbstractExDBTable<AT_HolidayYoyaku> {

    public GenQAT_HolidayYoyaku() {
        this("AT_HolidayYoyaku");
    }

    public GenQAT_HolidayYoyaku(String pAlias) {
        super("AT_HolidayYoyaku", AT_HolidayYoyaku.class, pAlias);
    }

    public String AT_HolidayYoyaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_HolidayYoyaku, String> holidayGroupCd = new ExDBFieldString<>("holidayGroupCd", this);

    public final ExDBFieldString<AT_HolidayYoyaku, String> holidayCd = new ExDBFieldString<>("holidayCd", this);

    public final ExDBFieldString<AT_HolidayYoyaku, C_LegalHolidayKbn> legalHolidayKbn = new ExDBFieldString<>("legalHolidayKbn", this, UserType_C_LegalHolidayKbn.class);

    public final ExDBFieldString<AT_HolidayYoyaku, BizDate> tekiyouYmdFrom = new ExDBFieldString<>("tekiyouYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<AT_HolidayYoyaku, BizDate> tekiyouYmdTo = new ExDBFieldString<>("tekiyouYmdTo", this, BizDateType.class);

    public final ExDBFieldString<AT_HolidayYoyaku, C_HolidayPtn> holidayPattern = new ExDBFieldString<>("holidayPattern", this, UserType_C_HolidayPtn.class);

    public final ExDBFieldString<AT_HolidayYoyaku, String> holidayPatternParam = new ExDBFieldString<>("holidayPatternParam", this);

    public final ExDBFieldString<AT_HolidayYoyaku, String> holidayPatternNm = new ExDBFieldString<>("holidayPatternNm", this);

    public final ExDBFieldString<AT_HolidayYoyaku, String> holidayPatternDescription = new ExDBFieldString<>("holidayPatternDescription", this);

    public final ExDBFieldString<AT_HolidayYoyaku, C_YoyakuKbn> yoyakuKbn = new ExDBFieldString<>("yoyakuKbn", this, UserType_C_YoyakuKbn.class);
}
