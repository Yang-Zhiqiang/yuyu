package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_UriageSousinRn;

/**
 * 売上送信Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_UriageSousinRn extends AbstractExDBTable<ZT_UriageSousinRn> {

    public GenQZT_UriageSousinRn() {
        this("ZT_UriageSousinRn");
    }

    public GenQZT_UriageSousinRn(String pAlias) {
        super("ZT_UriageSousinRn", ZT_UriageSousinRn.class, pAlias);
    }

    public String ZT_UriageSousinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnauthorikbn = new ExDBFieldString<>("zrnauthorikbn", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnuriageseikyuuymd = new ExDBFieldString<>("zrnuriageseikyuuymd", this);

    public final ExDBFieldNumber<ZT_UriageSousinRn, Long> zrnrsgaku = new ExDBFieldNumber<>("zrnrsgaku", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnfukusuukameitennokey = new ExDBFieldString<>("zrnfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnrecordno = new ExDBFieldString<>("zrnrecordno", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnuriagetaisyouym = new ExDBFieldString<>("zrnuriagetaisyouym", this);

    public final ExDBFieldString<ZT_UriageSousinRn, String> zrnyobiv33 = new ExDBFieldString<>("zrnyobiv33", this);
}
