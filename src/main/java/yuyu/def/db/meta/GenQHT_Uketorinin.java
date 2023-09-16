package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_Uketorinin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;

/**
 * 受取人テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Uketorinin extends AbstractExDBTable<HT_Uketorinin> {

    public GenQHT_Uketorinin() {
        this("HT_Uketorinin");
    }

    public GenQHT_Uketorinin(String pAlias) {
        super("HT_Uketorinin", HT_Uketorinin.class, pAlias);
    }

    public String HT_Uketorinin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Uketorinin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_Uketorinin, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<HT_Uketorinin, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<HT_Uketorinin, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<HT_Uketorinin, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<HT_Uketorinin, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<HT_Uketorinin, C_KjkhukaKbn> uktnmkjkhukakbn = new ExDBFieldString<>("uktnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_Uketorinin, C_Tdk> ukttdk = new ExDBFieldString<>("ukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_Uketorinin, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_Uketorinin, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Uketorinin, C_TsindousiteiKbn> ukttsindousiteikbn = new ExDBFieldString<>("ukttsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_Uketorinin, String> uktyno = new ExDBFieldString<>("uktyno", this);

    public final ExDBFieldString<HT_Uketorinin, String> uktadr1kj = new ExDBFieldString<>("uktadr1kj", this);

    public final ExDBFieldString<HT_Uketorinin, String> uktadr2kj = new ExDBFieldString<>("uktadr2kj", this);

    public final ExDBFieldString<HT_Uketorinin, String> uktadr3kj = new ExDBFieldString<>("uktadr3kj", this);

    public final ExDBFieldString<HT_Uketorinin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Uketorinin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
