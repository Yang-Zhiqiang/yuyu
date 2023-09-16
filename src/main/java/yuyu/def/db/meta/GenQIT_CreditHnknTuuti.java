package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_ShrriyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * クレカ返金通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_CreditHnknTuuti extends AbstractExDBTable<IT_CreditHnknTuuti> {

    public GenQIT_CreditHnknTuuti() {
        this("IT_CreditHnknTuuti");
    }

    public GenQIT_CreditHnknTuuti(String pAlias) {
        super("IT_CreditHnknTuuti", IT_CreditHnknTuuti.class, pAlias);
    }

    public String IT_CreditHnknTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_CreditHnknTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<IT_CreditHnknTuuti, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, C_ShrriyuuKbn> shrriyuukbn = new ExDBFieldString<>("shrriyuukbn", this, UserType_C_ShrriyuuKbn.class);

    public final ExDBFieldString<IT_CreditHnknTuuti, BizDate> uriageseikyuuymd = new ExDBFieldString<>("uriageseikyuuymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_CreditHnknTuuti> hnkngk = new ExDBFieldBizCurrency<>("hnkngk", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, C_KrkriyuuKbn> krkriyuukbn = new ExDBFieldString<>("krkriyuukbn", this, UserType_C_KrkriyuuKbn.class);

    public final ExDBFieldString<IT_CreditHnknTuuti, BizDate> uriageymd = new ExDBFieldString<>("uriageymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_CreditHnknTuuti> uriagegk = new ExDBFieldBizCurrency<>("uriagegk", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_CreditHnknTuuti, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_CreditHnknTuuti, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, C_UmuKbn> hnkntaisyouinjiflg = new ExDBFieldString<>("hnkntaisyouinjiflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_CreditHnknTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
