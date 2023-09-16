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
import yuyu.def.db.entity.HT_BosUketorinin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;

/**
 * 募集受取人テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosUketorinin extends AbstractExDBTable<HT_BosUketorinin> {

    public GenQHT_BosUketorinin() {
        this("HT_BosUketorinin");
    }

    public GenQHT_BosUketorinin(String pAlias) {
        super("HT_BosUketorinin", HT_BosUketorinin.class, pAlias);
    }

    public String HT_BosUketorinin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosUketorinin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosUketorinin, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<HT_BosUketorinin, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<HT_BosUketorinin, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<HT_BosUketorinin, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<HT_BosUketorinin, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<HT_BosUketorinin, C_KjkhukaKbn> uktnmkjkhukakbn = new ExDBFieldString<>("uktnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_BosUketorinin, C_Tdk> ukttdk = new ExDBFieldString<>("ukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_BosUketorinin, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_BosUketorinin, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosUketorinin, C_TsindousiteiKbn> ukttsindousiteikbn = new ExDBFieldString<>("ukttsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_BosUketorinin, String> uktyno = new ExDBFieldString<>("uktyno", this);

    public final ExDBFieldString<HT_BosUketorinin, String> uktadr1kj = new ExDBFieldString<>("uktadr1kj", this);

    public final ExDBFieldString<HT_BosUketorinin, String> uktadr2kj = new ExDBFieldString<>("uktadr2kj", this);

    public final ExDBFieldString<HT_BosUketorinin, String> uktadr3kj = new ExDBFieldString<>("uktadr3kj", this);

    public final ExDBFieldString<HT_BosUketorinin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosUketorinin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
