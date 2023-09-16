package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileRn;

/**
 * 新契約会計取引ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKaikeiTorihikiFileRn extends AbstractExDBTable<ZT_SkKaikeiTorihikiFileRn> {

    public GenQZT_SkKaikeiTorihikiFileRn() {
        this("ZT_SkKaikeiTorihikiFileRn");
    }

    public GenQZT_SkKaikeiTorihikiFileRn(String pAlias) {
        super("ZT_SkKaikeiTorihikiFileRn", ZT_SkKaikeiTorihikiFileRn.class, pAlias);
    }

    public String ZT_SkKaikeiTorihikiFileRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnlen = new ExDBFieldString<>("zrnlen", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnsimekirikbn = new ExDBFieldString<>("zrnsimekirikbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnkaisyakantorihikikbn = new ExDBFieldString<>("zrnkaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntukekaekbn = new ExDBFieldString<>("zrntukekaekbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntablekosuu = new ExDBFieldString<>("zrntablekosuu", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnsuitoubumon = new ExDBFieldString<>("zrnsuitoubumon", this);

    public final ExDBFieldNumber<ZT_SkKaikeiTorihikiFileRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrntekiyoucd = new ExDBFieldString<>("zrntekiyoucd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileRn, String> zrnmeisaikanryoukbn = new ExDBFieldString<>("zrnmeisaikanryoukbn", this);
}
