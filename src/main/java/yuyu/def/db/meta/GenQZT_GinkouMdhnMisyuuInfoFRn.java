package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFRn;

/**
 * 銀行窓販未収情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GinkouMdhnMisyuuInfoFRn extends AbstractExDBTable<ZT_GinkouMdhnMisyuuInfoFRn> {

    public GenQZT_GinkouMdhnMisyuuInfoFRn() {
        this("ZT_GinkouMdhnMisyuuInfoFRn");
    }

    public GenQZT_GinkouMdhnMisyuuInfoFRn(String pAlias) {
        super("ZT_GinkouMdhnMisyuuInfoFRn", ZT_GinkouMdhnMisyuuInfoFRn.class, pAlias);
    }

    public String ZT_GinkouMdhnMisyuuInfoFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnyobiv63 = new ExDBFieldString<>("zrnyobiv63", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrndatakbn = new ExDBFieldString<>("zrndatakbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrndatasakuseiymd = new ExDBFieldString<>("zrndatasakuseiymd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnhknkaisyacd = new ExDBFieldString<>("zrnhknkaisyacd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnhknsyuruicd = new ExDBFieldString<>("zrnhknsyuruicd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnsyonosyuban = new ExDBFieldString<>("zrnsyonosyuban", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnsyonoedaban = new ExDBFieldString<>("zrnsyonoedaban", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnmisyuutatekaekbn = new ExDBFieldString<>("zrnmisyuutatekaekbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnmisyuutatekaeym = new ExDBFieldString<>("zrnmisyuutatekaeym", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnmisyuukg = new ExDBFieldString<>("zrnmisyuukg", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnbnkaisuu = new ExDBFieldString<>("zrnbnkaisuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnmisyuujiyuu = new ExDBFieldString<>("zrnmisyuujiyuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnjikaidatakousinymd = new ExDBFieldString<>("zrnjikaidatakousinymd", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnyobiv28 = new ExDBFieldString<>("zrnyobiv28", this);

    public final ExDBFieldString<ZT_GinkouMdhnMisyuuInfoFRn, String> zrnkosyaareav40 = new ExDBFieldString<>("zrnkosyaareav40", this);
}
