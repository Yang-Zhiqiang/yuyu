package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * 支払履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiRireki extends AbstractExDBTable<JT_SiRireki> {

    public GenQJT_SiRireki() {
        this("JT_SiRireki");
    }

    public GenQJT_SiRireki(String pAlias) {
        super("JT_SiRireki", JT_SiRireki.class, pAlias);
    }

    public String JT_SiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiRireki, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SiRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiRireki, String> shrsikibetukey = new ExDBFieldString<>("shrsikibetukey", this);

    public final ExDBFieldNumber<JT_SiRireki, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SiRireki, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JT_SiRireki, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiRireki, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiRireki> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldString<JT_SiRireki, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);

    public final ExDBFieldString<JT_SiRireki, C_UmuKbn> torikesiflg = new ExDBFieldString<>("torikesiflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiRireki, BizDate> torikesiymd = new ExDBFieldString<>("torikesiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiRireki, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiRireki, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
