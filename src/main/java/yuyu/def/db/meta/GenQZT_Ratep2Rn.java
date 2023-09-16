package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_Ratep2Rn;

/**
 * Ｐレートテーブル２（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Ratep2Rn extends AbstractExDBTable<ZT_Ratep2Rn> {

    public GenQZT_Ratep2Rn() {
        this("ZT_Ratep2Rn");
    }

    public GenQZT_Ratep2Rn(String pAlias) {
        super("ZT_Ratep2Rn", ZT_Ratep2Rn.class, pAlias);
    }

    public String ZT_Ratep2Rn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnyoteiriritu = new ExDBFieldString<>("zrnyoteiriritu", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnpmenkbn = new ExDBFieldString<>("zrnpmenkbn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnhhknsei = new ExDBFieldString<>("zrnhhknsei", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnkeiyakujihhknnen = new ExDBFieldString<>("zrnkeiyakujihhknnen", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_Ratep2Rn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldNumber<ZT_Ratep2Rn, Double> zrnprate = new ExDBFieldNumber<>("zrnprate", this);

    public final ExDBFieldNumber<ZT_Ratep2Rn, Double> zrnpdatesrate = new ExDBFieldNumber<>("zrnpdatesrate", this);
}
