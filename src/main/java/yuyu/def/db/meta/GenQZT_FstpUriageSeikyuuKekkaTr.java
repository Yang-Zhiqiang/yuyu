package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;

/**
 * 初回保険料売上請求結果テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FstpUriageSeikyuuKekkaTr extends AbstractExDBTable<ZT_FstpUriageSeikyuuKekkaTr> {

    public GenQZT_FstpUriageSeikyuuKekkaTr() {
        this("ZT_FstpUriageSeikyuuKekkaTr");
    }

    public GenQZT_FstpUriageSeikyuuKekkaTr(String pAlias) {
        super("ZT_FstpUriageSeikyuuKekkaTr", ZT_FstpUriageSeikyuuKekkaTr.class, pAlias);
    }

    public String ZT_FstpUriageSeikyuuKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrauthorikbn = new ExDBFieldString<>("ztrauthorikbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztruriageseikyuutorihikicd = new ExDBFieldString<>("ztruriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztryobiv14 = new ExDBFieldString<>("ztryobiv14", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztruriagetaisyouym = new ExDBFieldString<>("ztruriagetaisyouym", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztruriageymd6keta = new ExDBFieldString<>("ztruriageymd6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrcreditkigyoucd = new ExDBFieldString<>("ztrcreditkigyoucd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrcreditkessaiyouno = new ExDBFieldString<>("ztrcreditkessaiyouno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrsyono = new ExDBFieldString<>("ztrsyono", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrrecordno = new ExDBFieldString<>("ztrrecordno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztryobiv3 = new ExDBFieldString<>("ztryobiv3", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrcardyuukoukigen = new ExDBFieldString<>("ztrcardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_FstpUriageSeikyuuKekkaTr, Long> ztrseikyuukngk = new ExDBFieldNumber<>("ztrseikyuukngk", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztryobiv5 = new ExDBFieldString<>("ztryobiv5", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrcreditkaiinnokami6keta = new ExDBFieldString<>("ztrcreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztryobiv6 = new ExDBFieldString<>("ztryobiv6", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrcreditkaiinnosimo4keta = new ExDBFieldString<>("ztrcreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztruriageseikyuuerrorcd = new ExDBFieldString<>("ztruriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrhurikaekekkacd = new ExDBFieldString<>("ztrhurikaekekkacd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztrfukusuukameitennokey = new ExDBFieldString<>("ztrfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuKekkaTr, String> ztryobiv1 = new ExDBFieldString<>("ztryobiv1", this);
}
