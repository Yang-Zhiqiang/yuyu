package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SinninTouhyouRn;

/**
 * 信任投票データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SinninTouhyouRn extends AbstractExDBTable<ZT_SinninTouhyouRn> {

    public GenQZT_SinninTouhyouRn() {
        this("ZT_SinninTouhyouRn");
    }

    public GenQZT_SinninTouhyouRn(String pAlias) {
        super("ZT_SinninTouhyouRn", ZT_SinninTouhyouRn.class, pAlias);
    }

    public String ZT_SinninTouhyouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnhokenkbn = new ExDBFieldString<>("zrnhokenkbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnkyknaiyoukbn = new ExDBFieldString<>("zrnkyknaiyoukbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnhokenkbnnys = new ExDBFieldString<>("zrnhokenkbnnys", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsakuinmeinonys = new ExDBFieldString<>("zrnsakuinmeinonys", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsyainnm = new ExDBFieldString<>("zrnsyainnm", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnkanjisyainnm = new ExDBFieldString<>("zrnkanjisyainnm", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsyainseiymd = new ExDBFieldString<>("zrnsyainseiymd", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnkanjitsinkaiadr = new ExDBFieldString<>("zrnkanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsouhuhunoukbn = new ExDBFieldString<>("zrnsouhuhunoukbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnnaimitureigaihyj = new ExDBFieldString<>("zrnnaimitureigaihyj", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsyuukinsisya = new ExDBFieldString<>("zrnsyuukinsisya", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsyuukintntusycd = new ExDBFieldString<>("zrnsyuukintntusycd", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnokyakusamano = new ExDBFieldString<>("zrnokyakusamano", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnnaibukojincd = new ExDBFieldString<>("zrnnaibukojincd", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnhokenkbnsyainno = new ExDBFieldString<>("zrnhokenkbnsyainno", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnsakuinmeinosyainno = new ExDBFieldString<>("zrnsakuinmeinosyainno", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnprivacyhogoyouhyj = new ExDBFieldString<>("zrnprivacyhogoyouhyj", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnkaigaitokoukykhyj = new ExDBFieldString<>("zrnkaigaitokoukykhyj", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnnaibukbn = new ExDBFieldString<>("zrnnaibukbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnkyktsnatkitkyktrkjtkbn = new ExDBFieldString<>("zrnkyktsnatkitkyktrkjtkbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnalcardhkkbn = new ExDBFieldString<>("zrnalcardhkkbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnbsydrtenkbn = new ExDBFieldString<>("zrnbsydrtenkbn", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnvitkaiinno = new ExDBFieldString<>("zrnvitkaiinno", this);

    public final ExDBFieldString<ZT_SinninTouhyouRn, String> zrnyobiv60 = new ExDBFieldString<>("zrnyobiv60", this);
}
