package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿累計額訂正テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HjybruikeigakuTeisei extends AbstractExDBTable<BT_HjybruikeigakuTeisei> {

    public GenQBT_HjybruikeigakuTeisei() {
        this("BT_HjybruikeigakuTeisei");
    }

    public GenQBT_HjybruikeigakuTeisei(String pAlias) {
        super("BT_HjybruikeigakuTeisei", BT_HjybruikeigakuTeisei.class, pAlias);
    }

    public String BT_HjybruikeigakuTeisei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HjybruikeigakuTeisei, String> hjybruigkteiseitantositucd = new ExDBFieldString<>("hjybruigkteiseitantositucd", this);

    public final ExDBFieldString<BT_HjybruikeigakuTeisei, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldBizCurrency<BT_HjybruikeigakuTeisei> kasikatateiseigk = new ExDBFieldBizCurrency<>("kasikatateiseigk", this);

    public final ExDBFieldBizCurrency<BT_HjybruikeigakuTeisei> karikatateiseigk = new ExDBFieldBizCurrency<>("karikatateiseigk", this);
}
