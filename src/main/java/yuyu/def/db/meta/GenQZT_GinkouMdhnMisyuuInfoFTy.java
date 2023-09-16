package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;

/**
 * 銀行窓販未収情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GinkouMdhnMisyuuInfoFTy extends AbstractExDBTable<ZT_GinkouMdhnMisyuuInfoFTy> {

    public GenQZT_GinkouMdhnMisyuuInfoFTy() {
        this("ZT_GinkouMdhnMisyuuInfoFTy");
    }

    public GenQZT_GinkouMdhnMisyuuInfoFTy(String pAlias) {
        super("ZT_GinkouMdhnMisyuuInfoFTy", ZT_GinkouMdhnMisyuuInfoFTy.class, pAlias);
    }

    public String ZT_GinkouMdhnMisyuuInfoFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyyobiv63 = new ExDBFieldString<>("ztyyobiv63", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztydatakbn = new ExDBFieldString<>("ztydatakbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztydatasakuseiymd = new ExDBFieldString<>("ztydatasakuseiymd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyhknkaisyacd = new ExDBFieldString<>("ztyhknkaisyacd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyhknsyuruicd = new ExDBFieldString<>("ztyhknsyuruicd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztysyonosyuban = new ExDBFieldString<>("ztysyonosyuban", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztysyonoedaban = new ExDBFieldString<>("ztysyonoedaban", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztymisyuutatekaekbn = new ExDBFieldString<>("ztymisyuutatekaekbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztymisyuutatekaeym = new ExDBFieldString<>("ztymisyuutatekaeym", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztymisyuukg = new ExDBFieldString<>("ztymisyuukg", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztybnkaisuu = new ExDBFieldString<>("ztybnkaisuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztymisyuujiyuu = new ExDBFieldString<>("ztymisyuujiyuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyjikaidatakousinymd = new ExDBFieldString<>("ztyjikaidatakousinymd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztyyobiv28 = new ExDBFieldString<>("ztyyobiv28", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFTy, String> ztykosyaareav40 = new ExDBFieldString<>("ztykosyaareav40", this);
}
