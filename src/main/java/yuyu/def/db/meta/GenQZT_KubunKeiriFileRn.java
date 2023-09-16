package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KubunKeiriFileRn;

/**
 * 区分経理ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KubunKeiriFileRn extends AbstractExDBTable<ZT_KubunKeiriFileRn> {

    public GenQZT_KubunKeiriFileRn() {
        this("ZT_KubunKeiriFileRn");
    }

    public GenQZT_KubunKeiriFileRn(String pAlias) {
        super("ZT_KubunKeiriFileRn", ZT_KubunKeiriFileRn.class, pAlias);
    }

    public String ZT_KubunKeiriFileRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnonlinesyorikbn = new ExDBFieldString<>("zrnonlinesyorikbn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnyobiv28 = new ExDBFieldString<>("zrnyobiv28", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnsuitoubumoncd = new ExDBFieldString<>("zrnsuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_KubunKeiriFileRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnkizokusegment = new ExDBFieldString<>("zrnkizokusegment", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnaitesegment = new ExDBFieldString<>("zrnaitesegment", this);

    public final ExDBFieldString<ZT_KubunKeiriFileRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);
}
