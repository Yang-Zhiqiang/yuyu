package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiRn;

/**
 * 代理店失効契約明細照会用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenSkKykDtlSyokaiRn extends AbstractExDBTable<ZT_DrtenSkKykDtlSyokaiRn> {

    public GenQZT_DrtenSkKykDtlSyokaiRn() {
        this("ZT_DrtenSkKykDtlSyokaiRn");
    }

    public GenQZT_DrtenSkKykDtlSyokaiRn(String pAlias) {
        super("ZT_DrtenSkKykDtlSyokaiRn", ZT_DrtenSkKykDtlSyokaiRn.class, pAlias);
    }

    public String ZT_DrtenSkKykDtlSyokaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnsakuseiym = new ExDBFieldString<>("zrnsakuseiym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrntntusycd = new ExDBFieldString<>("zrntntusycd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnkykymwareki4keta = new ExDBFieldString<>("zrnkykymwareki4keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnatesakinm = new ExDBFieldString<>("zrnatesakinm", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhassinka = new ExDBFieldString<>("zrnhassinka", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrntelno15keta = new ExDBFieldString<>("zrntelno15keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnbsyymwareki4keta = new ExDBFieldString<>("zrnbsyymwareki4keta", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrntntusynm = new ExDBFieldString<>("zrntntusynm", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnkydatkikbnkj = new ExDBFieldString<>("zrnkydatkikbnkj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnkyknmkj20 = new ExDBFieldString<>("zrnkyknmkj20", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnskymdwareki = new ExDBFieldString<>("zrnskymdwareki", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhrkkaisuukj = new ExDBFieldString<>("zrnhrkkaisuukj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhrkkeirokj = new ExDBFieldString<>("zrnhrkkeirokj", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiRn, Long> zrnp11keta = new ExDBFieldNumber<>("zrnp11keta", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiRn, Long> zrnskhr = new ExDBFieldNumber<>("zrnskhr", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnjizensyoukaiyouhyj = new ExDBFieldString<>("zrnjizensyoukaiyouhyj", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrntntusygyouhaiinfo = new ExDBFieldString<>("zrntntusygyouhaiinfo", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhrkkeirobtjhmidasi = new ExDBFieldString<>("zrnhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhrkkeirobtjh = new ExDBFieldString<>("zrnhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnhknsyuruimei = new ExDBFieldString<>("zrnhknsyuruimei", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnbkofccd = new ExDBFieldString<>("zrnbkofccd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrndbskyoteiymd = new ExDBFieldString<>("zrndbskyoteiymd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnminyukaisuu = new ExDBFieldString<>("zrnminyukaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvitkaiinno = new ExDBFieldString<>("zrnvitkaiinno", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvitkykym = new ExDBFieldString<>("zrnvitkykym", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvitskymd = new ExDBFieldString<>("zrnvitskymd", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvithrkkaisuu = new ExDBFieldString<>("zrnvithrkkaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvithrkkeiro = new ExDBFieldString<>("zrnvithrkkeiro", this);

    public final ExDBFieldNumber<ZT_DrtenSkKykDtlSyokaiRn, Long> zrnzkomivitriyoury = new ExDBFieldNumber<>("zrnzkomivitriyoury", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvitnyknkaisuu = new ExDBFieldString<>("zrnvitnyknkaisuu", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnvitbikou = new ExDBFieldString<>("zrnvitbikou", this);

    public final ExDBFieldString<ZT_DrtenSkKykDtlSyokaiRn, String> zrnyobiv25 = new ExDBFieldString<>("zrnyobiv25", this);
}
