package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * マイナス売上契約明細リストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_MinusUriageKykDtlList extends AbstractExDBTable<IT_MinusUriageKykDtlList> {

    public GenQIT_MinusUriageKykDtlList() {
        this("IT_MinusUriageKykDtlList");
    }

    public GenQIT_MinusUriageKykDtlList(String pAlias) {
        super("IT_MinusUriageKykDtlList", IT_MinusUriageKykDtlList.class, pAlias);
    }

    public String IT_MinusUriageKykDtlList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, BizDate> uriagenengappi = new ExDBFieldString<>("uriagenengappi", this, BizDateType.class);

    public final ExDBFieldNumber<IT_MinusUriageKykDtlList, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_MinusUriageKykDtlList> credituriagegk = new ExDBFieldBizCurrency<>("credituriagegk", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_MinusUriageKykDtlList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
