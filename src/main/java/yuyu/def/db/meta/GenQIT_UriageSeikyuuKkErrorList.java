package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;

/**
 * 売上請求結果エラーリストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_UriageSeikyuuKkErrorList extends AbstractExDBTable<IT_UriageSeikyuuKkErrorList> {

    public GenQIT_UriageSeikyuuKkErrorList() {
        this("IT_UriageSeikyuuKkErrorList");
    }

    public GenQIT_UriageSeikyuuKkErrorList(String pAlias) {
        super("IT_UriageSeikyuuKkErrorList", IT_UriageSeikyuuKkErrorList.class, pAlias);
    }

    public String IT_UriageSeikyuuKkErrorList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, BizDate> uriagenengappi = new ExDBFieldString<>("uriagenengappi", this, BizDateType.class);

    public final ExDBFieldNumber<IT_UriageSeikyuuKkErrorList, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_UriageSeikyuuKkErrorList> credituriagegk = new ExDBFieldBizCurrency<>("credituriagegk", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> uriageseikyuuerrorcd = new ExDBFieldString<>("uriageseikyuuerrorcd", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, C_AuthoriKbn> authorikbn = new ExDBFieldString<>("authorikbn", this, UserType_C_AuthoriKbn.class);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IT_UriageSeikyuuKkErrorList, C_CreditUriageSeikyuuKbn> credituriageseikyuukbn = new ExDBFieldString<>("credituriageseikyuukbn", this, UserType_C_CreditUriageSeikyuuKbn.class);
}
