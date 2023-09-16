package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitAddInfoTy;

/**
 * 年金配当所要額追加情報反映テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitAddInfoTy extends AbstractExDBTable<ZT_NkHitAddInfoTy> {

    public GenQZT_NkHitAddInfoTy() {
        this("ZT_NkHitAddInfoTy");
    }

    public GenQZT_NkHitAddInfoTy(String pAlias) {
        super("ZT_NkHitAddInfoTy", ZT_NkHitAddInfoTy.class, pAlias);
    }

    public String ZT_NkHitAddInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitAddInfoTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkHitAddInfoTy, String> ztyratekbn = new ExDBFieldString<>("ztyratekbn", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztykariwariate4nenmae = new ExDBFieldNumber<>("ztykariwariate4nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztykariwariate3nenmae = new ExDBFieldNumber<>("ztykariwariate3nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztykariwariate2nenmae = new ExDBFieldNumber<>("ztykariwariate2nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztykariwariate1nenmae = new ExDBFieldNumber<>("ztykariwariate1nenmae", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkHitAddInfoTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_NkHitAddInfoTy, String> ztyyobiv40 = new ExDBFieldString<>("ztyyobiv40", this);
}
