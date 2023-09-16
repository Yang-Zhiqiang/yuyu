package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_UriageKekkaTr;

/**
 * 売上結果Ｆテーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_UriageKekkaTr extends AbstractExDBTable<ZT_UriageKekkaTr> {

    public GenQZT_UriageKekkaTr() {
        this("ZT_UriageKekkaTr");
    }

    public GenQZT_UriageKekkaTr(String pAlias) {
        super("ZT_UriageKekkaTr", ZT_UriageKekkaTr.class, pAlias);
    }

    public String ZT_UriageKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrauthorikbn = new ExDBFieldString<>("ztrauthorikbn", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztruriageseikyuutorihikicd = new ExDBFieldString<>("ztruriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztryobiv14 = new ExDBFieldString<>("ztryobiv14", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztruriagetaisyouym = new ExDBFieldString<>("ztruriagetaisyouym", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztruriageymd6keta = new ExDBFieldString<>("ztruriageymd6keta", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrcreditkigyoucd = new ExDBFieldString<>("ztrcreditkigyoucd", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrcreditkessaiyouno = new ExDBFieldString<>("ztrcreditkessaiyouno", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrsyono = new ExDBFieldString<>("ztrsyono", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrrecordno = new ExDBFieldString<>("ztrrecordno", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztryobiv3 = new ExDBFieldString<>("ztryobiv3", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrcardyuukoukigen = new ExDBFieldString<>("ztrcardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_UriageKekkaTr, Long> ztrseikyuukngk = new ExDBFieldNumber<>("ztrseikyuukngk", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztryobiv5 = new ExDBFieldString<>("ztryobiv5", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrcreditkaiinnokami6keta = new ExDBFieldString<>("ztrcreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztryobiv6 = new ExDBFieldString<>("ztryobiv6", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrcreditkaiinnosimo4keta = new ExDBFieldString<>("ztrcreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztruriageseikyuuerrorcd = new ExDBFieldString<>("ztruriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrhurikaekekkacd = new ExDBFieldString<>("ztrhurikaekekkacd", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztrfukusuukameitennokey = new ExDBFieldString<>("ztrfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_UriageKekkaTr, String> ztryobiv1 = new ExDBFieldString<>("ztryobiv1", this);
}
