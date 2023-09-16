package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiRn;

/**
 * 新契約決算用会計取引Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKsnKaikeiTorihikiRn extends AbstractExDBTable<ZT_SkKsnKaikeiTorihikiRn> {

    public GenQZT_SkKsnKaikeiTorihikiRn() {
        this("ZT_SkKsnKaikeiTorihikiRn");
    }

    public GenQZT_SkKsnKaikeiTorihikiRn(String pAlias) {
        super("ZT_SkKsnKaikeiTorihikiRn", ZT_SkKsnKaikeiTorihikiRn.class, pAlias);
    }

    public String ZT_SkKsnKaikeiTorihikiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnlen = new ExDBFieldString<>("zrnlen", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnsimekirikbn = new ExDBFieldString<>("zrnsimekirikbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnkaisyakantorihikikbn = new ExDBFieldString<>("zrnkaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntukekaekbn = new ExDBFieldString<>("zrntukekaekbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntablekosuu = new ExDBFieldString<>("zrntablekosuu", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnsuitoubumon = new ExDBFieldString<>("zrnsuitoubumon", this);

    public final ExDBFieldNumber<ZT_SkKsnKaikeiTorihikiRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrntekiyoucd = new ExDBFieldString<>("zrntekiyoucd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiRn, String> zrnmeisaikanryoukbn = new ExDBFieldString<>("zrnmeisaikanryoukbn", this);
}
