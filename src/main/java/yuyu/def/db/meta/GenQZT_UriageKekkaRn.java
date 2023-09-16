package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_UriageKekkaRn;

/**
 * 売上結果Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_UriageKekkaRn extends AbstractExDBTable<ZT_UriageKekkaRn> {

    public GenQZT_UriageKekkaRn() {
        this("ZT_UriageKekkaRn");
    }

    public GenQZT_UriageKekkaRn(String pAlias) {
        super("ZT_UriageKekkaRn", ZT_UriageKekkaRn.class, pAlias);
    }

    public String ZT_UriageKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnauthorikbn = new ExDBFieldString<>("zrnauthorikbn", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnuriageseikyuutorihikicd = new ExDBFieldString<>("zrnuriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnuriagetaisyouym = new ExDBFieldString<>("zrnuriagetaisyouym", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnuriageymd6keta = new ExDBFieldString<>("zrnuriageymd6keta", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrncreditkigyoucd = new ExDBFieldString<>("zrncreditkigyoucd", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnrecordno = new ExDBFieldString<>("zrnrecordno", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_UriageKekkaRn, Long> zrnseikyuukngk = new ExDBFieldNumber<>("zrnseikyuukngk", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrncreditkaiinnokami6keta = new ExDBFieldString<>("zrncreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrncreditkaiinnosimo4keta = new ExDBFieldString<>("zrncreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnuriageseikyuuerrorcd = new ExDBFieldString<>("zrnuriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnhurikaekekkacd = new ExDBFieldString<>("zrnhurikaekekkacd", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnfukusuukameitennokey = new ExDBFieldString<>("zrnfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_UriageKekkaRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);
}
