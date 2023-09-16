package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;

/**
 * 会計取引ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KaikeiTorihikiFileRn extends AbstractExDBTable<ZT_KaikeiTorihikiFileRn> {

    public GenQZT_KaikeiTorihikiFileRn() {
        this("ZT_KaikeiTorihikiFileRn");
    }

    public GenQZT_KaikeiTorihikiFileRn(String pAlias) {
        super("ZT_KaikeiTorihikiFileRn", ZT_KaikeiTorihikiFileRn.class, pAlias);
    }

    public String ZT_KaikeiTorihikiFileRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnlen = new ExDBFieldString<>("zrnlen", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnsimekirikbn = new ExDBFieldString<>("zrnsimekirikbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnkaisyakantorihikikbn = new ExDBFieldString<>("zrnkaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntukekaekbn = new ExDBFieldString<>("zrntukekaekbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntablekosuu = new ExDBFieldString<>("zrntablekosuu", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnsuitoubumon = new ExDBFieldString<>("zrnsuitoubumon", this);

    public final ExDBFieldNumber<ZT_KaikeiTorihikiFileRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrntekiyoucd = new ExDBFieldString<>("zrntekiyoucd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileRn, String> zrnmeisaikanryoukbn = new ExDBFieldString<>("zrnmeisaikanryoukbn", this);
}
