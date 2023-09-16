package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriRn;

/**
 * 新契約決算用区分経理Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKsnKubunKeiriRn extends AbstractExDBTable<ZT_SkKsnKubunKeiriRn> {

    public GenQZT_SkKsnKubunKeiriRn() {
        this("ZT_SkKsnKubunKeiriRn");
    }

    public GenQZT_SkKsnKubunKeiriRn(String pAlias) {
        super("ZT_SkKsnKubunKeiriRn", ZT_SkKsnKubunKeiriRn.class, pAlias);
    }

    public String ZT_SkKsnKubunKeiriRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnkaikeitani = new ExDBFieldString<>("zrnkaikeitani", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnsystemkbnnum = new ExDBFieldString<>("zrnsystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrntorihikiymd = new ExDBFieldString<>("zrntorihikiymd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrntorihikinon7 = new ExDBFieldString<>("zrntorihikinon7", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnnyuuryokubasyo = new ExDBFieldString<>("zrnnyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnnyuuryokusyacd = new ExDBFieldString<>("zrnnyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnsyoriymdn = new ExDBFieldString<>("zrnsyoriymdn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnkessankbn = new ExDBFieldString<>("zrnkessankbn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnonlinesyorikbn = new ExDBFieldString<>("zrnonlinesyorikbn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnyobiv28 = new ExDBFieldString<>("zrnyobiv28", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnkanjyoukbnn = new ExDBFieldString<>("zrnkanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrntaisyakukbnn = new ExDBFieldString<>("zrntaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnkanjyoukamokucdn = new ExDBFieldString<>("zrnkanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnsuitoubumoncd = new ExDBFieldString<>("zrnsuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_SkKsnKubunKeiriRn, Long> zrnkingaku = new ExDBFieldNumber<>("zrnkingaku", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnkizokusegment = new ExDBFieldString<>("zrnkizokusegment", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnaitesegment = new ExDBFieldString<>("zrnaitesegment", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);
}
