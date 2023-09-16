package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;

/**
 * 普保Ⅱ選択情報反映結果テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SntkInfoHaneiKekkaTr extends AbstractExDBTable<ZT_SntkInfoHaneiKekkaTr> {

    public GenQZT_SntkInfoHaneiKekkaTr() {
        this("ZT_SntkInfoHaneiKekkaTr");
    }

    public GenQZT_SntkInfoHaneiKekkaTr(String pAlias) {
        super("ZT_SntkInfoHaneiKekkaTr", ZT_SntkInfoHaneiKekkaTr.class, pAlias);
    }

    public String ZT_SntkInfoHaneiKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinfono = new ExDBFieldString<>("ztrsntkinfono", this);

    public final ExDBFieldNumber<ZT_SntkInfoHaneiKekkaTr, Integer> ztrrenno = new ExDBFieldNumber<>("ztrrenno", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinfotourokusyskbn = new ExDBFieldString<>("ztrsntkinfotourokusyskbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrhuho2kyknokbn = new ExDBFieldString<>("ztrhuho2kyknokbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrhuho2kykno = new ExDBFieldString<>("ztrhuho2kykno", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinfofsegkbn = new ExDBFieldString<>("ztrsntkinfofsegkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinfofkojinkbn = new ExDBFieldString<>("ztrsntkinfofkojinkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrdakuhiketnaiyouarihyj = new ExDBFieldString<>("ztrdakuhiketnaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrkktnaiyouarihyj = new ExDBFieldString<>("ztrkktnaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrkijinaiyouarihyj = new ExDBFieldString<>("ztrkijinaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrmrarihyj = new ExDBFieldString<>("ztrmrarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrkoudosyougaiarihyj = new ExDBFieldString<>("ztrkoudosyougaiarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrtorikaijoarihyj = new ExDBFieldString<>("ztrtorikaijoarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinjotourokuerrkbn = new ExDBFieldString<>("ztrsntkinjotourokuerrkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrnayosehumeihyj = new ExDBFieldString<>("ztrnayosehumeihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaTr, String> ztrsntkinjohaneikekkayobi01 = new ExDBFieldString<>("ztrsntkinjohaneikekkayobi01", this);
}
