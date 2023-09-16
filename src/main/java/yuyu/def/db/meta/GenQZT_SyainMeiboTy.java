package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyainMeiboTy;

/**
 * 社員名簿Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyainMeiboTy extends AbstractExDBTable<ZT_SyainMeiboTy> {

    public GenQZT_SyainMeiboTy() {
        this("ZT_SyainMeiboTy");
    }

    public GenQZT_SyainMeiboTy(String pAlias) {
        super("ZT_SyainMeiboTy", ZT_SyainMeiboTy.class, pAlias);
    }

    public String ZT_SyainMeiboTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyhokenkbn = new ExDBFieldString<>("ztyhokenkbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztysyainmeibokbn = new ExDBFieldString<>("ztysyainmeibokbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztysyainnm = new ExDBFieldString<>("ztysyainnm", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztykanjisyainnm = new ExDBFieldString<>("ztykanjisyainnm", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztysyainseiymd = new ExDBFieldString<>("ztysyainseiymd", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztykanjitsinkaiadr = new ExDBFieldString<>("ztykanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztysouhuhunoukbn = new ExDBFieldString<>("ztysouhuhunoukbn", this);

    public final ExDBFieldNumber<ZT_SyainMeiboTy, Long> ztysyainmeibos = new ExDBFieldNumber<>("ztysyainmeibos", this);

    public final ExDBFieldNumber<ZT_SyainMeiboTy, Long> ztysyainmeibop = new ExDBFieldNumber<>("ztysyainmeibop", this);

    public final ExDBFieldNumber<ZT_SyainMeiboTy, Long> ztysyainmeibosyouyop = new ExDBFieldNumber<>("ztysyainmeibosyouyop", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyyofuritysytzumihyouji = new ExDBFieldString<>("ztyyofuritysytzumihyouji", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztynayosekihontikucd = new ExDBFieldString<>("ztynayosekihontikucd", this);

    public final ExDBFieldString<ZT_SyainMeiboTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);
}
