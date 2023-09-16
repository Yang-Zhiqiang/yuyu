package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileRn;

/**
 * 新契約区分経理ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKubunKeiriFileRn extends AbstractExDBTable<ZT_SkKubunKeiriFileRn> {

    public GenQZT_SkKubunKeiriFileRn() {
        this("ZT_SkKubunKeiriFileRn");
    }

    public GenQZT_SkKubunKeiriFileRn(String pAlias) {
        super("ZT_SkKubunKeiriFileRn", ZT_SkKubunKeiriFileRn.class, pAlias);
    }

    public String ZT_SkKubunKeiriFileRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnonlinesyorikbn = new ExDBFieldString<>("zrnonlinesyorikbn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnyobiv28 = new ExDBFieldString<>("zrnyobiv28", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnsuitoubumoncd = new ExDBFieldString<>("zrnsuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_SkKubunKeiriFileRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnkizokusegment = new ExDBFieldString<>("zrnkizokusegment", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnaitesegment = new ExDBFieldString<>("zrnaitesegment", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);
}
