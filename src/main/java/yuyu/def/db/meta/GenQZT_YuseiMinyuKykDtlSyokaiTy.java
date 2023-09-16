package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiTy;

/**
 * 郵政未入契約明細照会用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_YuseiMinyuKykDtlSyokaiTy extends AbstractExDBTable<ZT_YuseiMinyuKykDtlSyokaiTy> {

    public GenQZT_YuseiMinyuKykDtlSyokaiTy() {
        this("ZT_YuseiMinyuKykDtlSyokaiTy");
    }

    public GenQZT_YuseiMinyuKykDtlSyokaiTy(String pAlias) {
        super("ZT_YuseiMinyuKykDtlSyokaiTy", ZT_YuseiMinyuKykDtlSyokaiTy.class, pAlias);
    }

    public String ZT_YuseiMinyuKykDtlSyokaiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztysakuseiym = new ExDBFieldString<>("ztysakuseiym", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztytntusycd = new ExDBFieldString<>("ztytntusycd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztypjyuutouyymmwareki4keta = new ExDBFieldString<>("ztypjyuutouyymmwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztykykymwareki4keta = new ExDBFieldString<>("ztykykymwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyatesakinm = new ExDBFieldString<>("ztyatesakinm", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyminyuujyutuymdyofuri = new ExDBFieldString<>("ztyminyuujyutuymdyofuri", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyminyuujyutuymdyofuriigi = new ExDBFieldString<>("ztyminyuujyutuymdyofuriigi", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhassinka = new ExDBFieldString<>("ztyhassinka", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztytelno15keta = new ExDBFieldString<>("ztytelno15keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztybsyymwareki4keta = new ExDBFieldString<>("ztybsyymwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztytntusynm = new ExDBFieldString<>("ztytntusynm", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztykydatkikbnkj = new ExDBFieldString<>("ztykydatkikbnkj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztykyknmkj20 = new ExDBFieldString<>("ztykyknmkj20", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhrkkaisuukj = new ExDBFieldString<>("ztyhrkkaisuukj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhrkkeirokj = new ExDBFieldString<>("ztyhrkkeirokj", this);

    public final ExDBFieldNumber<ZT_YuseiMinyuKykDtlSyokaiTy, Long> ztyp11keta = new ExDBFieldNumber<>("ztyp11keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyknkimnyuuryukj = new ExDBFieldString<>("ztyknkimnyuuryukj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyjikaiminyuuji = new ExDBFieldString<>("ztyjikaiminyuuji", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztytntusygyouhaiinfo = new ExDBFieldString<>("ztytntusygyouhaiinfo", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhrkkeirobtjhmidasi = new ExDBFieldString<>("ztyhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhrkkeirobtjh = new ExDBFieldString<>("ztyhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyhknsyuruimei = new ExDBFieldString<>("ztyhknsyuruimei", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztybkofccd = new ExDBFieldString<>("ztybkofccd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztydbskyoteiymd = new ExDBFieldString<>("ztydbskyoteiymd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);
}
