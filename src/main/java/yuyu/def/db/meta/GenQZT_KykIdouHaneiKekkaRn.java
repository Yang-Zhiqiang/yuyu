package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;

/**
 * 普保Ⅱ契約異動反映結果テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KykIdouHaneiKekkaRn extends AbstractExDBTable<ZT_KykIdouHaneiKekkaRn> {

    public GenQZT_KykIdouHaneiKekkaRn() {
        this("ZT_KykIdouHaneiKekkaRn");
    }

    public GenQZT_KykIdouHaneiKekkaRn(String pAlias) {
        super("ZT_KykIdouHaneiKekkaRn", ZT_KykIdouHaneiKekkaRn.class, pAlias);
    }

    public String ZT_KykIdouHaneiKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnhuho2kyknokbn = new ExDBFieldString<>("zrnhuho2kyknokbn", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnhuho2kykno = new ExDBFieldString<>("zrnhuho2kykno", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnkyknaiyouhaneierrkbn = new ExDBFieldString<>("zrnkyknaiyouhaneierrkbn", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrntsnkijyuntyoukahyj = new ExDBFieldString<>("zrntsnkijyuntyoukahyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnhhknnayosehumeihyj = new ExDBFieldString<>("zrnhhknnayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnkyknayosehumeihyj = new ExDBFieldString<>("zrnkyknayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrnnkuktnayosehumeihyj = new ExDBFieldString<>("zrnnkuktnayosehumeihyj", this);

    public final ExDBFieldString<ZT_KykIdouHaneiKekkaRn, String> zrntjtidouhaneikekkayobi01 = new ExDBFieldString<>("zrntjtidouhaneikekkayobi01", this);
}
