package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_CreditCard;

/**
 * クレジットカードテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_CreditCard extends AbstractExDBTable<IT_CreditCard> {

    public GenQIT_CreditCard() {
        this("IT_CreditCard");
    }

    public GenQIT_CreditCard(String pAlias) {
        super("IT_CreditCard", IT_CreditCard.class, pAlias);
    }

    public String IT_CreditCard() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_CreditCard, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_CreditCard, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_CreditCard, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_CreditCard, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_CreditCard, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_CreditCard, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_CreditCard, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_CreditCard, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_CreditCard, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_CreditCard, String> creditmeiginmkn = new ExDBFieldString<>("creditmeiginmkn", this);

    public final ExDBFieldString<IT_CreditCard, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_CreditCard, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_CreditCard, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
