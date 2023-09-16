package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;

/**
 * ＩＤカードＦ役職テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IdCardYakusyokuRn extends AbstractExDBTable<ZT_IdCardYakusyokuRn> {

    public GenQZT_IdCardYakusyokuRn() {
        this("ZT_IdCardYakusyokuRn");
    }

    public GenQZT_IdCardYakusyokuRn(String pAlias) {
        super("ZT_IdCardYakusyokuRn", ZT_IdCardYakusyokuRn.class, pAlias);
    }

    public String ZT_IdCardYakusyokuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnidkbn = new ExDBFieldString<>("zrnidkbn", this);

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnidcd = new ExDBFieldString<>("zrnidcd", this);

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnyakusyokuhatureiymd = new ExDBFieldString<>("zrnyakusyokuhatureiymd", this);

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnyakusyokuhatureino = new ExDBFieldString<>("zrnyakusyokuhatureino", this);

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnyakusyokuhatureisosikicd = new ExDBFieldString<>("zrnyakusyokuhatureisosikicd", this);

    public final ExDBFieldString<ZT_IdCardYakusyokuRn, String> zrnyakusyokucd = new ExDBFieldString<>("zrnyakusyokucd", this);
}
