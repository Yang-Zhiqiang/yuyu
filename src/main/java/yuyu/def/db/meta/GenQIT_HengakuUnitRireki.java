package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額ユニット履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HengakuUnitRireki extends AbstractExDBTable<IT_HengakuUnitRireki> {

    public GenQIT_HengakuUnitRireki() {
        this("IT_HengakuUnitRireki");
    }

    public GenQIT_HengakuUnitRireki(String pAlias) {
        super("IT_HengakuUnitRireki", IT_HengakuUnitRireki.class, pAlias);
    }

    public String IT_HengakuUnitRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HengakuUnitRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<IT_HengakuUnitRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, BizDate> unitkouryokuhasseiymd = new ExDBFieldString<>("unitkouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HengakuUnitRireki, BizDate> unitkouryokuendymd = new ExDBFieldString<>("unitkouryokuendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HengakuUnitRireki, BizNumber> unitsuu = new ExDBFieldString<>("unitsuu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_HengakuUnitRireki, Integer> fundhaibunwariai = new ExDBFieldNumber<>("fundhaibunwariai", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HengakuUnitRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
