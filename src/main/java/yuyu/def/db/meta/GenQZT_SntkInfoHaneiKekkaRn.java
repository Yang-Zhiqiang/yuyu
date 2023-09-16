package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;

/**
 * 普保Ⅱ選択情報反映結果テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SntkInfoHaneiKekkaRn extends AbstractExDBTable<ZT_SntkInfoHaneiKekkaRn> {

    public GenQZT_SntkInfoHaneiKekkaRn() {
        this("ZT_SntkInfoHaneiKekkaRn");
    }

    public GenQZT_SntkInfoHaneiKekkaRn(String pAlias) {
        super("ZT_SntkInfoHaneiKekkaRn", ZT_SntkInfoHaneiKekkaRn.class, pAlias);
    }

    public String ZT_SntkInfoHaneiKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinfono = new ExDBFieldString<>("zrnsntkinfono", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnrenno = new ExDBFieldString<>("zrnrenno", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinfotourokusyskbn = new ExDBFieldString<>("zrnsntkinfotourokusyskbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnhuho2kyknokbn = new ExDBFieldString<>("zrnhuho2kyknokbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnhuho2kykno = new ExDBFieldString<>("zrnhuho2kykno", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinfofsegkbn = new ExDBFieldString<>("zrnsntkinfofsegkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinfofkojinkbn = new ExDBFieldString<>("zrnsntkinfofkojinkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrndakuhiketnaiyouarihyj = new ExDBFieldString<>("zrndakuhiketnaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnkktnaiyouarihyj = new ExDBFieldString<>("zrnkktnaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnkijinaiyouarihyj = new ExDBFieldString<>("zrnkijinaiyouarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnkoudosyougaiarihyj = new ExDBFieldString<>("zrnkoudosyougaiarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrntorikaijoarihyj = new ExDBFieldString<>("zrntorikaijoarihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinjotourokuerrkbn = new ExDBFieldString<>("zrnsntkinjotourokuerrkbn", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnnayosehumeihyj = new ExDBFieldString<>("zrnnayosehumeihyj", this);

    public final ExDBFieldString<ZT_SntkInfoHaneiKekkaRn, String> zrnsntkinjohaneikekkayobi01 = new ExDBFieldString<>("zrnsntkinjohaneikekkayobi01", this);
}
