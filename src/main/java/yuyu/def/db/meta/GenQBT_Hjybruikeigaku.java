package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿累計額テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_Hjybruikeigaku extends AbstractExDBTable<BT_Hjybruikeigaku> {

    public GenQBT_Hjybruikeigaku() {
        this("BT_Hjybruikeigaku");
    }

    public GenQBT_Hjybruikeigaku(String pAlias) {
        super("BT_Hjybruikeigaku", BT_Hjybruikeigaku.class, pAlias);
    }

    public String BT_Hjybruikeigaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_Hjybruikeigaku, String> hjybtantositucd = new ExDBFieldString<>("hjybtantositucd", this);

    public final ExDBFieldString<BT_Hjybruikeigaku, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_Hjybruikeigaku, BizDateYM> denym = new ExDBFieldString<>("denym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<BT_Hjybruikeigaku> karikatakmkkeigk = new ExDBFieldBizCurrency<>("karikatakmkkeigk", this);

    public final ExDBFieldBizCurrency<BT_Hjybruikeigaku> kasikatakmkkeigk = new ExDBFieldBizCurrency<>("kasikatakmkkeigk", this);

    public final ExDBFieldBizCurrency<BT_Hjybruikeigaku> karikataruigk = new ExDBFieldBizCurrency<>("karikataruigk", this);

    public final ExDBFieldBizCurrency<BT_Hjybruikeigaku> kasikataruigk = new ExDBFieldBizCurrency<>("kasikataruigk", this);
}
