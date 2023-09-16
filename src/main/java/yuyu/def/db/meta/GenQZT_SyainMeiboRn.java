package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyainMeiboRn;

/**
 * 社員名簿Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyainMeiboRn extends AbstractExDBTable<ZT_SyainMeiboRn> {

    public GenQZT_SyainMeiboRn() {
        this("ZT_SyainMeiboRn");
    }

    public GenQZT_SyainMeiboRn(String pAlias) {
        super("ZT_SyainMeiboRn", ZT_SyainMeiboRn.class, pAlias);
    }

    public String ZT_SyainMeiboRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnhokenkbn = new ExDBFieldString<>("zrnhokenkbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnsyainmeibokbn = new ExDBFieldString<>("zrnsyainmeibokbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnsyainnm = new ExDBFieldString<>("zrnsyainnm", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnkanjisyainnm = new ExDBFieldString<>("zrnkanjisyainnm", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnsyainseiymd = new ExDBFieldString<>("zrnsyainseiymd", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnkanjitsinkaiadr = new ExDBFieldString<>("zrnkanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnsouhuhunoukbn = new ExDBFieldString<>("zrnsouhuhunoukbn", this);

    public final ExDBFieldNumber<ZT_SyainMeiboRn, Long> zrnsyainmeibos = new ExDBFieldNumber<>("zrnsyainmeibos", this);

    public final ExDBFieldNumber<ZT_SyainMeiboRn, Long> zrnsyainmeibop = new ExDBFieldNumber<>("zrnsyainmeibop", this);

    public final ExDBFieldNumber<ZT_SyainMeiboRn, Long> zrnsyainmeibosyouyop = new ExDBFieldNumber<>("zrnsyainmeibosyouyop", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnyofuritysytzumihyouji = new ExDBFieldString<>("zrnyofuritysytzumihyouji", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnnayosekihontikucd = new ExDBFieldString<>("zrnnayosekihontikucd", this);

    public final ExDBFieldString<ZT_SyainMeiboRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);
}
