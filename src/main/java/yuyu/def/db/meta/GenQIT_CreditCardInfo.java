package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_CreditCardInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;

/**
 * クレカ情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_CreditCardInfo extends AbstractExDBTable<IT_CreditCardInfo> {

    public GenQIT_CreditCardInfo() {
        this("IT_CreditCardInfo");
    }

    public GenQIT_CreditCardInfo(String pAlias) {
        super("IT_CreditCardInfo", IT_CreditCardInfo.class, pAlias);
    }

    public String IT_CreditCardInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_CreditCardInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_CreditCardInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_CreditCardInfo, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_CreditCardInfo, BizDateYM> credityuukoukakym = new ExDBFieldString<>("credityuukoukakym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_CreditCardInfo, C_Yuukoukakkekka> credityuukoukakkekka = new ExDBFieldString<>("credityuukoukakkekka", this, UserType_C_Yuukoukakkekka.class);

    public final ExDBFieldString<IT_CreditCardInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_CreditCardInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_CreditCardInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
