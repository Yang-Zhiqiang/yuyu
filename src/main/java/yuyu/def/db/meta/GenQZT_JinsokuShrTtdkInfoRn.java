package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;

/**
 * 迅速支払手続情報テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_JinsokuShrTtdkInfoRn extends AbstractExDBTable<ZT_JinsokuShrTtdkInfoRn> {

    public GenQZT_JinsokuShrTtdkInfoRn() {
        this("ZT_JinsokuShrTtdkInfoRn");
    }

    public GenQZT_JinsokuShrTtdkInfoRn(String pAlias) {
        super("ZT_JinsokuShrTtdkInfoRn", ZT_JinsokuShrTtdkInfoRn.class, pAlias);
    }

    public String ZT_JinsokuShrTtdkInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyorisosikicd = new ExDBFieldString<>("zrnsyorisosikicd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnhknknshrsntkno = new ExDBFieldString<>("zrnhknknshrsntkno", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyoruiukeymd = new ExDBFieldString<>("zrnsyoruiukeymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyoruikeikaeigyoubisuu = new ExDBFieldString<>("zrnsyoruikeikaeigyoubisuu", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyorikeikaeigyoubisuu = new ExDBFieldString<>("zrnsyorikeikaeigyoubisuu", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrntoritugisosikicd = new ExDBFieldString<>("zrntoritugisosikicd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrntanmatusyuruikbn = new ExDBFieldString<>("zrntanmatusyuruikbn", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);
}
