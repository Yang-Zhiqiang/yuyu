package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CfKbn;
import yuyu.def.classification.C_HasseiRiyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuCf;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_CfKbn;
import yuyu.def.db.type.UserType_C_HasseiRiyuuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額ＣＦテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HengakuCf extends AbstractExDBTable<IT_HengakuCf> {

    public GenQIT_HengakuCf() {
        this("IT_HengakuCf");
    }

    public GenQIT_HengakuCf(String pAlias) {
        super("IT_HengakuCf", IT_HengakuCf.class, pAlias);
    }

    public String IT_HengakuCf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HengakuCf, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HengakuCf, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HengakuCf, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HengakuCf, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<IT_HengakuCf, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_HengakuCf, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_HengakuCf, C_CfKbn> cfkbn = new ExDBFieldString<>("cfkbn", this, UserType_C_CfKbn.class);

    public final ExDBFieldString<IT_HengakuCf, C_HasseiRiyuuKbn> hasseiriyuukbn = new ExDBFieldString<>("hasseiriyuukbn", this, UserType_C_HasseiRiyuuKbn.class);

    public final ExDBFieldString<IT_HengakuCf, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);
}
