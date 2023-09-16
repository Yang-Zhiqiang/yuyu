package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.db.entity.HT_SkUriageData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_UriagekekkaKbn;

/**
 * 新契約売上データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkUriageData extends AbstractExDBTable<HT_SkUriageData> {

    public GenQHT_SkUriageData() {
        this("HT_SkUriageData");
    }

    public GenQHT_SkUriageData(String pAlias) {
        super("HT_SkUriageData", HT_SkUriageData.class, pAlias);
    }

    public String HT_SkUriageData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkUriageData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<HT_SkUriageData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkUriageData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_SkUriageData, Integer> authorikaisuu = new ExDBFieldNumber<>("authorikaisuu", this);

    public final ExDBFieldString<HT_SkUriageData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<HT_SkUriageData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<HT_SkUriageData> uriagegk = new ExDBFieldBizCurrency<>("uriagegk", this);

    public final ExDBFieldString<HT_SkUriageData, BizDate> uriageymd = new ExDBFieldString<>("uriageymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkUriageData, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldString<HT_SkUriageData, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkUriageData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkUriageData, C_AuthoriKbn> authorikbn = new ExDBFieldString<>("authorikbn", this, UserType_C_AuthoriKbn.class);

    public final ExDBFieldString<HT_SkUriageData, String> uriageseikyuutorihikicd = new ExDBFieldString<>("uriageseikyuutorihikicd", this);

    public final ExDBFieldString<HT_SkUriageData, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<HT_SkUriageData, String> creditkaiinnokami6keta = new ExDBFieldString<>("creditkaiinnokami6keta", this);

    public final ExDBFieldString<HT_SkUriageData, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);

    public final ExDBFieldString<HT_SkUriageData, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<HT_SkUriageData, String> fukusuukameitennokey = new ExDBFieldString<>("fukusuukameitennokey", this);

    public final ExDBFieldString<HT_SkUriageData, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<HT_SkUriageData, BizDate> carddatasousinymd = new ExDBFieldString<>("carddatasousinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkUriageData, String> uriageseikyuuerrorcd = new ExDBFieldString<>("uriageseikyuuerrorcd", this);

    public final ExDBFieldString<HT_SkUriageData, C_UriagekekkaKbn> uriagekekkakbn = new ExDBFieldString<>("uriagekekkakbn", this, UserType_C_UriagekekkaKbn.class);

    public final ExDBFieldString<HT_SkUriageData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkUriageData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkUriageData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
