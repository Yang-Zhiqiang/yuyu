package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjyblist;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿リスト用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_Hjyblist extends AbstractExDBTable<BT_Hjyblist> {

    public GenQBT_Hjyblist() {
        this("BT_Hjyblist");
    }

    public GenQBT_Hjyblist(String pAlias) {
        super("BT_Hjyblist", BT_Hjyblist.class, pAlias);
    }

    public String BT_Hjyblist() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_Hjyblist, String> hjybtantositucd = new ExDBFieldString<>("hjybtantositucd", this);

    public final ExDBFieldString<BT_Hjyblist, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_Hjyblist, String> syorisyokantantcd = new ExDBFieldString<>("syorisyokantantcd", this);

    public final ExDBFieldString<BT_Hjyblist, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<BT_Hjyblist> karikatagk = new ExDBFieldBizCurrency<>("karikatagk", this);

    public final ExDBFieldBizCurrency<BT_Hjyblist> kasikatagk = new ExDBFieldBizCurrency<>("kasikatagk", this);
}
