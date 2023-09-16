package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;

/**
 * 売上請求データ収納管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_UriageSkDataSyuKnr extends AbstractExDBTable<IT_UriageSkDataSyuKnr> {

    public GenQIT_UriageSkDataSyuKnr() {
        this("IT_UriageSkDataSyuKnr");
    }

    public GenQIT_UriageSkDataSyuKnr(String pAlias) {
        super("IT_UriageSkDataSyuKnr", IT_UriageSkDataSyuKnr.class, pAlias);
    }

    public String IT_UriageSkDataSyuKnr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, BizDate> uriagenengappi = new ExDBFieldString<>("uriagenengappi", this, BizDateType.class);

    public final ExDBFieldNumber<IT_UriageSkDataSyuKnr, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, BizDate> credituriagekekkahaneiymd = new ExDBFieldString<>("credituriagekekkahaneiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, Boolean> credituragskkkmhnkkchkzmflg = new ExDBFieldString<>("credituragskkkmhnkkchkzmflg", this, BooleanType.class);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_UriageSkDataSyuKnr, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
