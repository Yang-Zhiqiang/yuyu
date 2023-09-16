package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;

/**
 * 特定関係法人マスタテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TokuteiKankeiHoujinRn extends AbstractExDBTable<ZT_TokuteiKankeiHoujinRn> {

    public GenQZT_TokuteiKankeiHoujinRn() {
        this("ZT_TokuteiKankeiHoujinRn");
    }

    public GenQZT_TokuteiKankeiHoujinRn(String pAlias) {
        super("ZT_TokuteiKankeiHoujinRn", ZT_TokuteiKankeiHoujinRn.class, pAlias);
    }

    public String ZT_TokuteiKankeiHoujinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnmeisaibangou = new ExDBFieldString<>("zrnmeisaibangou", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnmarukinhyouji = new ExDBFieldString<>("zrnmarukinhyouji", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrntkhjnkjdrtennm = new ExDBFieldString<>("zrntkhjnkjdrtennm", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrndairitenbetutuuban = new ExDBFieldString<>("zrndairitenbetutuuban", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnkanjitokuteikankeinm = new ExDBFieldString<>("zrnkanjitokuteikankeinm", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrntokuteikankeihoujinnm = new ExDBFieldString<>("zrntokuteikankeihoujinnm", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnkousinymd = new ExDBFieldString<>("zrnkousinymd", this);

    public final ExDBFieldString<ZT_TokuteiKankeiHoujinRn, String> zrnyobiv79 = new ExDBFieldString<>("zrnyobiv79", this);
}
