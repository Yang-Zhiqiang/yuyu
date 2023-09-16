package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaRn;

/**
 * 初回保険料売上請求結果テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FstpUriageSeikyuuKekkaRn extends AbstractExDBTable<ZT_FstpUriageSeikyuuKekkaRn> {

    public GenQZT_FstpUriageSeikyuuKekkaRn() {
        this("ZT_FstpUriageSeikyuuKekkaRn");
    }

    public GenQZT_FstpUriageSeikyuuKekkaRn(String pAlias) {
        super("ZT_FstpUriageSeikyuuKekkaRn", ZT_FstpUriageSeikyuuKekkaRn.class, pAlias);
    }

    public String ZT_FstpUriageSeikyuuKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnauthorikbn = new ExDBFieldString<>("zrnauthorikbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnuriageseikyuutorihikicd = new ExDBFieldString<>("zrnuriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnuriagetaisyouym = new ExDBFieldString<>("zrnuriagetaisyouym", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnuriageymd6keta = new ExDBFieldString<>("zrnuriageymd6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrncreditkigyoucd = new ExDBFieldString<>("zrncreditkigyoucd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnrecordno = new ExDBFieldString<>("zrnrecordno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_FstpUriageSeikyuuKekkaRn, Long> zrnseikyuukngk = new ExDBFieldNumber<>("zrnseikyuukngk", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrncreditkaiinnokami6keta = new ExDBFieldString<>("zrncreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrncreditkaiinnosimo4keta = new ExDBFieldString<>("zrncreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnuriageseikyuuerrorcd = new ExDBFieldString<>("zrnuriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnhurikaekekkacd = new ExDBFieldString<>("zrnhurikaekekkacd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnfukusuukameitennokey = new ExDBFieldString<>("zrnfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);
}
