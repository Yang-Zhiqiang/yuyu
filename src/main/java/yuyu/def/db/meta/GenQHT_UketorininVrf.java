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
import yuyu.def.db.entity.HT_UketorininVrf;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;

/**
 * 受取人ベリファイテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_UketorininVrf extends AbstractExDBTable<HT_UketorininVrf> {

    public GenQHT_UketorininVrf() {
        this("HT_UketorininVrf");
    }

    public GenQHT_UketorininVrf(String pAlias) {
        super("HT_UketorininVrf", HT_UketorininVrf.class, pAlias);
    }

    public String HT_UketorininVrf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_UketorininVrf, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_UketorininVrf, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<HT_UketorininVrf, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<HT_UketorininVrf, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<HT_UketorininVrf, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<HT_UketorininVrf, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<HT_UketorininVrf, C_KjkhukaKbn> uktnmkjkhukakbn = new ExDBFieldString<>("uktnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_UketorininVrf, C_Tdk> ukttdk = new ExDBFieldString<>("ukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_UketorininVrf, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_UketorininVrf, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_UketorininVrf, C_TsindousiteiKbn> ukttsindousiteikbn = new ExDBFieldString<>("ukttsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_UketorininVrf, String> uktyno = new ExDBFieldString<>("uktyno", this);

    public final ExDBFieldString<HT_UketorininVrf, String> uktadr1kj = new ExDBFieldString<>("uktadr1kj", this);

    public final ExDBFieldString<HT_UketorininVrf, String> uktadr2kj = new ExDBFieldString<>("uktadr2kj", this);

    public final ExDBFieldString<HT_UketorininVrf, String> uktadr3kj = new ExDBFieldString<>("uktadr3kj", this);

    public final ExDBFieldString<HT_UketorininVrf, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_UketorininVrf, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
