package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 口座返金通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KouzaHnknTuuti extends AbstractExDBTable<IT_KouzaHnknTuuti> {

    public GenQIT_KouzaHnknTuuti() {
        this("IT_KouzaHnknTuuti");
    }

    public GenQIT_KouzaHnknTuuti(String pAlias) {
        super("IT_KouzaHnknTuuti", IT_KouzaHnknTuuti.class, pAlias);
    }

    public String IT_KouzaHnknTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<IT_KouzaHnknTuuti, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, BizDate> hurikomiymd = new ExDBFieldString<>("hurikomiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KouzaHnknTuuti> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, C_KrkriyuuKbn> krkriyuukbn = new ExDBFieldString<>("krkriyuukbn", this, UserType_C_KrkriyuuKbn.class);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KouzaHnknTuuti> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KouzaHnknTuuti, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_KouzaHnknTuuti, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KouzaHnknTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
