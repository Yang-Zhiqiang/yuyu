package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_CreditTrkhouKbn;

/**
 * クレジットカード情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_CreditCardJyouhou extends AbstractExDBTable<HT_CreditCardJyouhou> {

    public GenQHT_CreditCardJyouhou() {
        this("HT_CreditCardJyouhou");
    }

    public GenQHT_CreditCardJyouhou(String pAlias) {
        super("HT_CreditCardJyouhou", HT_CreditCardJyouhou.class, pAlias);
    }

    public String HT_CreditCardJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_CreditCardJyouhou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_CreditCardJyouhou, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<HT_CreditCardJyouhou, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<HT_CreditCardJyouhou, C_CreditTrkhouKbn> credittrkhoukbn = new ExDBFieldString<>("credittrkhoukbn", this, UserType_C_CreditTrkhouKbn.class);

    public final ExDBFieldString<HT_CreditCardJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_CreditCardJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
