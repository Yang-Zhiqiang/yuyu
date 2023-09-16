package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiUkt;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Hkuktsyu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_UktKbn;

/**
 * 支払受取人テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiUkt extends AbstractExDBTable<JT_SiUkt> {

    public GenQJT_SiUkt() {
        this("JT_SiUkt");
    }

    public GenQJT_SiUkt(String pAlias) {
        super("JT_SiUkt", JT_SiUkt.class, pAlias);
    }

    public String JT_SiUkt() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiUkt, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiUkt, C_Hkuktsyu> hkuktsyu = new ExDBFieldString<>("hkuktsyu", this, UserType_C_Hkuktsyu.class);

    public final ExDBFieldNumber<JT_SiUkt, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<JT_SiUkt, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<JT_SiUkt, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<JT_SiUkt, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiUkt, C_Tdk> ukttdk = new ExDBFieldString<>("ukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<JT_SiUkt, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<JT_SiUkt, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiUkt, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiUkt, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiUkt, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiUkt, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
