package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;

/**
 * 契約受取人テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KykUkt extends AbstractExDBTable<IT_KykUkt> {

    public GenQIT_KykUkt() {
        this("IT_KykUkt");
    }

    public GenQIT_KykUkt(String pAlias) {
        super("IT_KykUkt", IT_KykUkt.class, pAlias);
    }

    public String IT_KykUkt() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KykUkt, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KykUkt, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KykUkt, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<IT_KykUkt, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<IT_KykUkt, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_KykUkt, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IT_KykUkt, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<IT_KykUkt, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<IT_KykUkt, C_KjkhukaKbn> uktnmkjkhukakbn = new ExDBFieldString<>("uktnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_KykUkt, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykUkt, C_Tdk> ukttdk = new ExDBFieldString<>("ukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_KykUkt, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<IT_KykUkt, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KykUkt, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KykUkt, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KykUkt, String> uktyno = new ExDBFieldString<>("uktyno", this);

    public final ExDBFieldString<IT_KykUkt, String> uktadr1kj = new ExDBFieldString<>("uktadr1kj", this);

    public final ExDBFieldString<IT_KykUkt, String> uktadr2kj = new ExDBFieldString<>("uktadr2kj", this);

    public final ExDBFieldString<IT_KykUkt, String> uktadr3kj = new ExDBFieldString<>("uktadr3kj", this);
}
