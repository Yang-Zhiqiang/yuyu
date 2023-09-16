package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_BAK_HengakuUnit;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額ユニットバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_HengakuUnit extends AbstractExDBTable<IT_BAK_HengakuUnit> {

    public GenQIT_BAK_HengakuUnit() {
        this("IT_BAK_HengakuUnit");
    }

    public GenQIT_BAK_HengakuUnit(String pAlias) {
        super("IT_BAK_HengakuUnit", IT_BAK_HengakuUnit.class, pAlias);
    }

    public String IT_BAK_HengakuUnit() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, BizDate> unitkouryokuhasseiymd = new ExDBFieldString<>("unitkouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HengakuUnit, BizDate> unitkouryokuendymd = new ExDBFieldString<>("unitkouryokuendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HengakuUnit, BizNumber> unitsuu = new ExDBFieldString<>("unitsuu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_BAK_HengakuUnit, Integer> fundhaibunwariai = new ExDBFieldNumber<>("fundhaibunwariai", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_HengakuUnit, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
