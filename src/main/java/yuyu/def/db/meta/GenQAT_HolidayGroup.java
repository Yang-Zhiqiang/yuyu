package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.type.UserType_C_SysSiyouKbn;

/**
 * 休日グループテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_HolidayGroup extends AbstractExDBTable<AT_HolidayGroup> {

    public GenQAT_HolidayGroup() {
        this("AT_HolidayGroup");
    }

    public GenQAT_HolidayGroup(String pAlias) {
        super("AT_HolidayGroup", AT_HolidayGroup.class, pAlias);
    }

    public String AT_HolidayGroup() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_HolidayGroup, String> holidayGroupCd = new ExDBFieldString<>("holidayGroupCd", this);

    public final ExDBFieldString<AT_HolidayGroup, String> holidayGroupNm = new ExDBFieldString<>("holidayGroupNm", this);

    public final ExDBFieldString<AT_HolidayGroup, String> holidayGroupDescription = new ExDBFieldString<>("holidayGroupDescription", this);

    public final ExDBFieldString<AT_HolidayGroup, C_SysSiyouKbn> sysSiyouKbn = new ExDBFieldString<>("sysSiyouKbn", this, UserType_C_SysSiyouKbn.class);
}
