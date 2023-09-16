package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_BosyuuninRn;

/**
 * 募集人ＰＲＴ用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_BosyuuninRn extends AbstractExDBTable<ZT_BosyuuninRn> {

    public GenQZT_BosyuuninRn() {
        this("ZT_BosyuuninRn");
    }

    public GenQZT_BosyuuninRn(String pAlias) {
        super("ZT_BosyuuninRn", ZT_BosyuuninRn.class, pAlias);
    }

    public String ZT_BosyuuninRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuuninnm = new ExDBFieldString<>("zrnbosyuuninnm", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnkanjibosyuuninnm = new ExDBFieldString<>("zrnkanjibosyuuninnm", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnitakuymd = new ExDBFieldString<>("zrnitakuymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitencd1 = new ExDBFieldString<>("zrndairitencd1", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitencd2 = new ExDBFieldString<>("zrndairitencd2", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitencd3 = new ExDBFieldString<>("zrndairitencd3", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitenkanrisskcd1 = new ExDBFieldString<>("zrndairitenkanrisskcd1", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitenkanrisskcd2 = new ExDBFieldString<>("zrndairitenkanrisskcd2", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndairitenkanrisskcd3 = new ExDBFieldString<>("zrndairitenkanrisskcd3", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuukbn = new ExDBFieldString<>("zrnbosyuukbn", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuunintourokuymd = new ExDBFieldString<>("zrnbosyuunintourokuymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuuninkahikbn = new ExDBFieldString<>("zrnbosyuuninkahikbn", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuuningyouhaiymd = new ExDBFieldString<>("zrnbosyuuningyouhaiymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnhengakutourokuymd = new ExDBFieldString<>("zrnhengakutourokuymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnhengakumassyouymd = new ExDBFieldString<>("zrnhengakumassyouymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuuseiymd = new ExDBFieldString<>("zrnbosyuuseiymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnitakukaiyakuymd = new ExDBFieldString<>("zrnitakukaiyakuymd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrndaihyoubosyuunincd = new ExDBFieldString<>("zrndaihyoubosyuunincd", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnbosyuutourokuno = new ExDBFieldString<>("zrnbosyuutourokuno", this);

    public final ExDBFieldString<ZT_BosyuuninRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);
}
