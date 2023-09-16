package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyoukenTkListShTy extends AbstractExDBTable<ZT_SyoukenTkListShTy> {

    public GenQZT_SyoukenTkListShTy() {
        this("ZT_SyoukenTkListShTy");
    }

    public GenQZT_SyoukenTkListShTy(String pAlias) {
        super("ZT_SyoukenTkListShTy", ZT_SyoukenTkListShTy.class, pAlias);
    }

    public String ZT_SyoukenTkListShTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztysyoruicd = new ExDBFieldString<>("ztysyoruicd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztytyouhyouymd = new ExDBFieldString<>("ztytyouhyouymd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyhassoukbn = new ExDBFieldString<>("ztyhassoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyatesakitantnm = new ExDBFieldString<>("ztyatesakitantnm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyhozonkkn = new ExDBFieldString<>("ztyhozonkkn", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztytyouhyouymdwa = new ExDBFieldString<>("ztytyouhyouymdwa", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyyobiv26 = new ExDBFieldString<>("ztyyobiv26", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztykyknmkj = new ExDBFieldString<>("ztykyknmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyhhknnmkj = new ExDBFieldString<>("ztyhhknnmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztysyorinm = new ExDBFieldString<>("ztysyorinm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztysyorisyouninsyacd = new ExDBFieldString<>("ztysyorisyouninsyacd", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztysyorisyouninsyanm = new ExDBFieldString<>("ztysyorisyouninsyanm", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo1 = new ExDBFieldString<>("ztyjigosagyounaiyo1", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo2 = new ExDBFieldString<>("ztyjigosagyounaiyo2", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo3 = new ExDBFieldString<>("ztyjigosagyounaiyo3", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo4 = new ExDBFieldString<>("ztyjigosagyounaiyo4", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo5 = new ExDBFieldString<>("ztyjigosagyounaiyo5", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo6 = new ExDBFieldString<>("ztyjigosagyounaiyo6", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo7 = new ExDBFieldString<>("ztyjigosagyounaiyo7", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo8 = new ExDBFieldString<>("ztyjigosagyounaiyo8", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo9 = new ExDBFieldString<>("ztyjigosagyounaiyo9", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo10 = new ExDBFieldString<>("ztyjigosagyounaiyo10", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo11 = new ExDBFieldString<>("ztyjigosagyounaiyo11", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo12 = new ExDBFieldString<>("ztyjigosagyounaiyo12", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo13 = new ExDBFieldString<>("ztyjigosagyounaiyo13", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo14 = new ExDBFieldString<>("ztyjigosagyounaiyo14", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo15 = new ExDBFieldString<>("ztyjigosagyounaiyo15", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyjigosagyounaiyo16 = new ExDBFieldString<>("ztyjigosagyounaiyo16", this);

    public final ExDBFieldString<ZT_SyoukenTkListShTy, String> ztyyobiv31 = new ExDBFieldString<>("ztyyobiv31", this);
}
