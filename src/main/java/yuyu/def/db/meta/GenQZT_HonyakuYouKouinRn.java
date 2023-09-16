package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;

/**
 * 翻訳用行員Ｆ用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HonyakuYouKouinRn extends AbstractExDBTable<ZT_HonyakuYouKouinRn> {

    public GenQZT_HonyakuYouKouinRn() {
        this("ZT_HonyakuYouKouinRn");
    }

    public GenQZT_HonyakuYouKouinRn(String pAlias) {
        super("ZT_HonyakuYouKouinRn", ZT_HonyakuYouKouinRn.class, pAlias);
    }

    public String ZT_HonyakuYouKouinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_HonyakuYouKouinRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_HonyakuYouKouinRn, String> zrnkouincd = new ExDBFieldString<>("zrnkouincd", this);

    public final ExDBFieldString<ZT_HonyakuYouKouinRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);
}
