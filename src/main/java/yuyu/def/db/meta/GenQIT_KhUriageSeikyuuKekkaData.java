package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;

/**
 * 売上請求結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhUriageSeikyuuKekkaData extends AbstractExDBTable<IT_KhUriageSeikyuuKekkaData> {

    public GenQIT_KhUriageSeikyuuKekkaData() {
        this("IT_KhUriageSeikyuuKekkaData");
    }

    public GenQIT_KhUriageSeikyuuKekkaData(String pAlias) {
        super("IT_KhUriageSeikyuuKekkaData", IT_KhUriageSeikyuuKekkaData.class, pAlias);
    }

    public String IT_KhUriageSeikyuuKekkaData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, BizDate> uriagenengappi = new ExDBFieldString<>("uriagenengappi", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhUriageSeikyuuKekkaData, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> recordno = new ExDBFieldString<>("recordno", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, C_AuthoriKbn> authorikbn = new ExDBFieldString<>("authorikbn", this, UserType_C_AuthoriKbn.class);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> uriageseikyuutorihikicd = new ExDBFieldString<>("uriageseikyuutorihikicd", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> credityuukoukigen = new ExDBFieldString<>("credityuukoukigen", this);

    public final ExDBFieldBizCurrency<IT_KhUriageSeikyuuKekkaData> credituriagegk = new ExDBFieldBizCurrency<>("credituriagegk", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> creditkaiinnokami6keta = new ExDBFieldString<>("creditkaiinnokami6keta", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> uriageseikyuuerrorcd = new ExDBFieldString<>("uriageseikyuuerrorcd", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> fukusuukameitennokey = new ExDBFieldString<>("fukusuukameitennokey", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhUriageSeikyuuKekkaData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
