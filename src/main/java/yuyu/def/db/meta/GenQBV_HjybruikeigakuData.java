package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 補助簿累計額情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBV_HjybruikeigakuData extends AbstractExDBTable<BV_HjybruikeigakuData> {

    public GenQBV_HjybruikeigakuData() {
        this("BV_HjybruikeigakuData");
    }

    public GenQBV_HjybruikeigakuData(String pAlias) {
        super("BV_HjybruikeigakuData", BV_HjybruikeigakuData.class, pAlias);
    }

    public String BV_HjybruikeigakuData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BV_HjybruikeigakuData, String> hjybtantositucd = new ExDBFieldString<>("hjybtantositucd", this);

    public final ExDBFieldString<BV_HjybruikeigakuData, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BV_HjybruikeigakuData, BizDateYM> denym = new ExDBFieldString<>("denym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<BV_HjybruikeigakuData> kasikataruigk = new ExDBFieldBizCurrency<>("kasikataruigk", this);

    public final ExDBFieldBizCurrency<BV_HjybruikeigakuData> karikataruigk = new ExDBFieldBizCurrency<>("karikataruigk", this);

    public final ExDBFieldBizCurrency<BV_HjybruikeigakuData> kasikatateiseigk = new ExDBFieldBizCurrency<>("kasikatateiseigk", this);

    public final ExDBFieldBizCurrency<BV_HjybruikeigakuData> karikatateiseigk = new ExDBFieldBizCurrency<>("karikatateiseigk", this);

    public final ExDBFieldString<BV_HjybruikeigakuData, C_UmuKbn> hjybruigkteiseiumukbn = new ExDBFieldString<>("hjybruigkteiseiumukbn", this, UserType_C_UmuKbn.class);
}
