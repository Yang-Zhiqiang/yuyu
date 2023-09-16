package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataRn;

/**
 * 初回保険料売上請求データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FstpUriageSeikyuuDataRn extends AbstractExDBTable<ZT_FstpUriageSeikyuuDataRn> {

    public GenQZT_FstpUriageSeikyuuDataRn() {
        this("ZT_FstpUriageSeikyuuDataRn");
    }

    public GenQZT_FstpUriageSeikyuuDataRn(String pAlias) {
        super("ZT_FstpUriageSeikyuuDataRn", ZT_FstpUriageSeikyuuDataRn.class, pAlias);
    }

    public String ZT_FstpUriageSeikyuuDataRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnauthorikbn = new ExDBFieldString<>("zrnauthorikbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnuriageseikyuutorihikicd = new ExDBFieldString<>("zrnuriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnuriagetaisyouym = new ExDBFieldString<>("zrnuriagetaisyouym", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnuriageymd6keta = new ExDBFieldString<>("zrnuriageymd6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrncreditkigyoucd = new ExDBFieldString<>("zrncreditkigyoucd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnrecordno = new ExDBFieldString<>("zrnrecordno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_FstpUriageSeikyuuDataRn, Long> zrnseikyuukngk11keta = new ExDBFieldNumber<>("zrnseikyuukngk11keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrncreditkaiinnokami6keta = new ExDBFieldString<>("zrncreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrncreditkaiinnosimo4keta = new ExDBFieldString<>("zrncreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnuriageseikyuuerrorcd = new ExDBFieldString<>("zrnuriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnhurikaekekkacd = new ExDBFieldString<>("zrnhurikaekekkacd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnfukusuukameitennokey = new ExDBFieldString<>("zrnfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);
}
