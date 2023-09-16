package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyoukenTkListShRn;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyoukenTkListShRn extends AbstractExDBTable<ZT_SyoukenTkListShRn> {

    public GenQZT_SyoukenTkListShRn() {
        this("ZT_SyoukenTkListShRn");
    }

    public GenQZT_SyoukenTkListShRn(String pAlias) {
        super("ZT_SyoukenTkListShRn", ZT_SyoukenTkListShRn.class, pAlias);
    }

    public String ZT_SyoukenTkListShRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnsyoruicd = new ExDBFieldString<>("zrnsyoruicd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrntyouhyouymd = new ExDBFieldString<>("zrntyouhyouymd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnhassoukbn = new ExDBFieldString<>("zrnhassoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnatesakitantnm = new ExDBFieldString<>("zrnatesakitantnm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnhozonkkn = new ExDBFieldString<>("zrnhozonkkn", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrntyouhyouymdwa = new ExDBFieldString<>("zrntyouhyouymdwa", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnyobiv26 = new ExDBFieldString<>("zrnyobiv26", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnkyknmkj = new ExDBFieldString<>("zrnkyknmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnhhknnmkj = new ExDBFieldString<>("zrnhhknnmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnsyorinm = new ExDBFieldString<>("zrnsyorinm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnsyorisyouninsyacd = new ExDBFieldString<>("zrnsyorisyouninsyacd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnsyorisyouninsyanm = new ExDBFieldString<>("zrnsyorisyouninsyanm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo1 = new ExDBFieldString<>("zrnjigosagyounaiyo1", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo2 = new ExDBFieldString<>("zrnjigosagyounaiyo2", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo3 = new ExDBFieldString<>("zrnjigosagyounaiyo3", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo4 = new ExDBFieldString<>("zrnjigosagyounaiyo4", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo5 = new ExDBFieldString<>("zrnjigosagyounaiyo5", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo6 = new ExDBFieldString<>("zrnjigosagyounaiyo6", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo7 = new ExDBFieldString<>("zrnjigosagyounaiyo7", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo8 = new ExDBFieldString<>("zrnjigosagyounaiyo8", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo9 = new ExDBFieldString<>("zrnjigosagyounaiyo9", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo10 = new ExDBFieldString<>("zrnjigosagyounaiyo10", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo11 = new ExDBFieldString<>("zrnjigosagyounaiyo11", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo12 = new ExDBFieldString<>("zrnjigosagyounaiyo12", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo13 = new ExDBFieldString<>("zrnjigosagyounaiyo13", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo14 = new ExDBFieldString<>("zrnjigosagyounaiyo14", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo15 = new ExDBFieldString<>("zrnjigosagyounaiyo15", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnjigosagyounaiyo16 = new ExDBFieldString<>("zrnjigosagyounaiyo16", this);

    public final ExDBFieldString<ZT_SyoukenTkListShRn, String> zrnyobiv31 = new ExDBFieldString<>("zrnyobiv31", this);
}
