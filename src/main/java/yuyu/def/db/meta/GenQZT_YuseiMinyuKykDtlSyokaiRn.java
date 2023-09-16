package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiRn;

/**
 * 郵政未入契約明細照会用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_YuseiMinyuKykDtlSyokaiRn extends AbstractExDBTable<ZT_YuseiMinyuKykDtlSyokaiRn> {

    public GenQZT_YuseiMinyuKykDtlSyokaiRn() {
        this("ZT_YuseiMinyuKykDtlSyokaiRn");
    }

    public GenQZT_YuseiMinyuKykDtlSyokaiRn(String pAlias) {
        super("ZT_YuseiMinyuKykDtlSyokaiRn", ZT_YuseiMinyuKykDtlSyokaiRn.class, pAlias);
    }

    public String ZT_YuseiMinyuKykDtlSyokaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnsakuseiym = new ExDBFieldString<>("zrnsakuseiym", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrntntusycd = new ExDBFieldString<>("zrntntusycd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnpjyuutouyymmwareki4keta = new ExDBFieldString<>("zrnpjyuutouyymmwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnkykymwareki4keta = new ExDBFieldString<>("zrnkykymwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnatesakinm = new ExDBFieldString<>("zrnatesakinm", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnminyuujyutuymdyofuri = new ExDBFieldString<>("zrnminyuujyutuymdyofuri", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnminyuujyutuymdyofuriigi = new ExDBFieldString<>("zrnminyuujyutuymdyofuriigi", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhassinka = new ExDBFieldString<>("zrnhassinka", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrntelno15keta = new ExDBFieldString<>("zrntelno15keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnbsyymwareki4keta = new ExDBFieldString<>("zrnbsyymwareki4keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrntntusynm = new ExDBFieldString<>("zrntntusynm", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnkydatkikbnkj = new ExDBFieldString<>("zrnkydatkikbnkj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnkyknmkj20 = new ExDBFieldString<>("zrnkyknmkj20", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhrkkaisuukj = new ExDBFieldString<>("zrnhrkkaisuukj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhrkkeirokj = new ExDBFieldString<>("zrnhrkkeirokj", this);

    public final ExDBFieldNumber<ZT_YuseiMinyuKykDtlSyokaiRn, Long> zrnp11keta = new ExDBFieldNumber<>("zrnp11keta", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnknkimnyuuryukj = new ExDBFieldString<>("zrnknkimnyuuryukj", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnjikaiminyuuji = new ExDBFieldString<>("zrnjikaiminyuuji", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrntntusygyouhaiinfo = new ExDBFieldString<>("zrntntusygyouhaiinfo", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhrkkeirobtjhmidasi = new ExDBFieldString<>("zrnhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhrkkeirobtjh = new ExDBFieldString<>("zrnhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnhknsyuruimei = new ExDBFieldString<>("zrnhknsyuruimei", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnbkofccd = new ExDBFieldString<>("zrnbkofccd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrndbskyoteiymd = new ExDBFieldString<>("zrndbskyoteiymd", this);

    public final ExDBFieldString<ZT_YuseiMinyuKykDtlSyokaiRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);
}
