package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;

/**
 * 普保Ⅱ契約異動反映結果テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KykIdouHaneiKekkaTr extends AbstractExDBTable<ZT_KykIdouHaneiKekkaTr> {

    public GenQZT_KykIdouHaneiKekkaTr() {
        this("ZT_KykIdouHaneiKekkaTr");
    }

    public GenQZT_KykIdouHaneiKekkaTr(String pAlias) {
        super("ZT_KykIdouHaneiKekkaTr", ZT_KykIdouHaneiKekkaTr.class, pAlias);
    }

    public String ZT_KykIdouHaneiKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrhuho2kyknokbn = new ExDBFieldString<>("ztrhuho2kyknokbn", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrhuho2kykno = new ExDBFieldString<>("ztrhuho2kykno", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrkyknaiyouhaneierrkbn = new ExDBFieldString<>("ztrkyknaiyouhaneierrkbn", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrtsnkijyuntyoukahyj = new ExDBFieldString<>("ztrtsnkijyuntyoukahyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrhhknnayosehumeihyj = new ExDBFieldString<>("ztrhhknnayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrkyknayosehumeihyj = new ExDBFieldString<>("ztrkyknayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrnkuktnayosehumeihyj = new ExDBFieldString<>("ztrnkuktnayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaTr, String> ztrtjtidouhaneikekkayobi01 = new ExDBFieldString<>("ztrtjtidouhaneikekkayobi01", this);
}
