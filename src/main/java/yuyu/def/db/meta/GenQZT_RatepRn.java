package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_RatepRn;

/**
 * Ｐレートテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RatepRn extends AbstractExDBTable<ZT_RatepRn> {

    public GenQZT_RatepRn() {
        this("ZT_RatepRn");
    }

    public GenQZT_RatepRn(String pAlias) {
        super("ZT_RatepRn", ZT_RatepRn.class, pAlias);
    }

    public String ZT_RatepRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_RatepRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnyoteiriritu = new ExDBFieldString<>("zrnyoteiriritu", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnpmenkbn = new ExDBFieldString<>("zrnpmenkbn", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnhhknsei = new ExDBFieldString<>("zrnhhknsei", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnkeiyakujihhknnen = new ExDBFieldString<>("zrnkeiyakujihhknnen", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_RatepRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldNumber<ZT_RatepRn, Double> zrnprate = new ExDBFieldNumber<>("zrnprate", this);

    public final ExDBFieldNumber<ZT_RatepRn, Double> zrnpdatesrate = new ExDBFieldNumber<>("zrnpdatesrate", this);
}
