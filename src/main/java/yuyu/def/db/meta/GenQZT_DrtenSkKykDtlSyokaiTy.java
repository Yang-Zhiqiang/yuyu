package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;

/**
 * 代理店失効契約明細照会用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenSkKykDtlSyokaiTy extends AbstractExDBTable<ZT_DrtenSkKykDtlSyokaiTy> {

    public GenQZT_DrtenSkKykDtlSyokaiTy() {
        this("ZT_DrtenSkKykDtlSyokaiTy");
    }

    public GenQZT_DrtenSkKykDtlSyokaiTy(String pAlias) {
        super("ZT_DrtenSkKykDtlSyokaiTy", ZT_DrtenSkKykDtlSyokaiTy.class, pAlias);
    }

    public String ZT_DrtenSkKykDtlSyokaiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztysakuseiym = new ExDBFieldString<>("ztysakuseiym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztytntusycd = new ExDBFieldString<>("ztytntusycd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztykykymwareki4keta = new ExDBFieldString<>("ztykykymwareki4keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyatesakinm = new ExDBFieldString<>("ztyatesakinm", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhassinka = new ExDBFieldString<>("ztyhassinka", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztytelno15keta = new ExDBFieldString<>("ztytelno15keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztybsyymwareki4keta = new ExDBFieldString<>("ztybsyymwareki4keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztytntusynm = new ExDBFieldString<>("ztytntusynm", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztykydatkikbnkj = new ExDBFieldString<>("ztykydatkikbnkj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztykyknmkj20 = new ExDBFieldString<>("ztykyknmkj20", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyskymdwareki = new ExDBFieldString<>("ztyskymdwareki", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhrkkaisuukj = new ExDBFieldString<>("ztyhrkkaisuukj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhrkkeirokj = new ExDBFieldString<>("ztyhrkkeirokj", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiTy, Long> ztyp11keta = new ExDBFieldNumber<>("ztyp11keta", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiTy, Long> ztyskhr = new ExDBFieldNumber<>("ztyskhr", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyjizensyoukaiyouhyj = new ExDBFieldString<>("ztyjizensyoukaiyouhyj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztytntusygyouhaiinfo = new ExDBFieldString<>("ztytntusygyouhaiinfo", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhrkkeirobtjhmidasi = new ExDBFieldString<>("ztyhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhrkkeirobtjh = new ExDBFieldString<>("ztyhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyhknsyuruimei = new ExDBFieldString<>("ztyhknsyuruimei", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztybkofccd = new ExDBFieldString<>("ztybkofccd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztydbskyoteiymd = new ExDBFieldString<>("ztydbskyoteiymd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyminyukaisuu = new ExDBFieldString<>("ztyminyukaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvitkaiinno = new ExDBFieldString<>("ztyvitkaiinno", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvitkykym = new ExDBFieldString<>("ztyvitkykym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvitskymd = new ExDBFieldString<>("ztyvitskymd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvithrkkaisuu = new ExDBFieldString<>("ztyvithrkkaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvithrkkeiro = new ExDBFieldString<>("ztyvithrkkeiro", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiTy, Long> ztyzkomivitriyoury = new ExDBFieldNumber<>("ztyzkomivitriyoury", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvitnyknkaisuu = new ExDBFieldString<>("ztyvitnyknkaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyvitbikou = new ExDBFieldString<>("ztyvitbikou", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiTy, String> ztyyobiv25 = new ExDBFieldString<>("ztyyobiv25", this);
}
