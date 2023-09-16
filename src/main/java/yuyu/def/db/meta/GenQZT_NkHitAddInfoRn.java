package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitAddInfoRn;

/**
 * 年金配当所要額追加情報反映テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitAddInfoRn extends AbstractExDBTable<ZT_NkHitAddInfoRn> {

    public GenQZT_NkHitAddInfoRn() {
        this("ZT_NkHitAddInfoRn");
    }

    public GenQZT_NkHitAddInfoRn(String pAlias) {
        super("ZT_NkHitAddInfoRn", ZT_NkHitAddInfoRn.class, pAlias);
    }

    public String ZT_NkHitAddInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitAddInfoRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkHitAddInfoRn, String> zrnratekbn = new ExDBFieldString<>("zrnratekbn", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnkariwariate4nenmae = new ExDBFieldNumber<>("zrnkariwariate4nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnkariwariate3nenmae = new ExDBFieldNumber<>("zrnkariwariate3nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnkariwariate2nenmae = new ExDBFieldNumber<>("zrnkariwariate2nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnkariwariate1nenmae = new ExDBFieldNumber<>("zrnkariwariate1nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_NkHitAddInfoRn, String> zrnyobiv40 = new ExDBFieldString<>("zrnyobiv40", this);
}
