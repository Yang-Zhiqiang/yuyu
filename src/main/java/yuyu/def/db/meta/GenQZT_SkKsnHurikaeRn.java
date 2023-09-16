package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKsnHurikaeRn;

/**
 * 新契約決算用振替伝票テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKsnHurikaeRn extends AbstractExDBTable<ZT_SkKsnHurikaeRn> {

    public GenQZT_SkKsnHurikaeRn() {
        this("ZT_SkKsnHurikaeRn");
    }

    public GenQZT_SkKsnHurikaeRn(String pAlias) {
        super("ZT_SkKsnHurikaeRn", ZT_SkKsnHurikaeRn.class, pAlias);
    }

    public String ZT_SkKsnHurikaeRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmksyoruicd = new ExDBFieldString<>("zrnkytkmksyoruicd", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmktyouhyousksymd = new ExDBFieldString<>("zrnkytkmktyouhyousksymd", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmksystemkbn = new ExDBFieldString<>("zrnkytkmksystemkbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmktorihikino = new ExDBFieldString<>("zrnkytkmktorihikino", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmktorihikinoedano = new ExDBFieldString<>("zrnkytkmktorihikinoedano", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmkseifukukbn = new ExDBFieldString<>("zrnkytkmkseifukukbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmkfuridenhassoukbn = new ExDBFieldString<>("zrnkytkmkfuridenhassoukbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkytkmkyobi = new ExDBFieldString<>("zrnkytkmkyobi", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnsystemkbn = new ExDBFieldString<>("zrnsystemkbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikinoc8 = new ExDBFieldString<>("zrntorihikinoc8", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikinoedano = new ExDBFieldString<>("zrntorihikinoedano", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjhikaeinjikm = new ExDBFieldString<>("zrnkjhikaeinjikm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikiymdgengokbn = new ExDBFieldString<>("zrntorihikiymdgengokbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikinen = new ExDBFieldString<>("zrntorihikinen", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikituki = new ExDBFieldString<>("zrntorihikituki", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrntorihikibi = new ExDBFieldString<>("zrntorihikibi", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkanjyoukbn = new ExDBFieldString<>("zrnkanjyoukbn", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkanjyoukbnnm = new ExDBFieldString<>("zrnkanjyoukbnnm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjtantoukanm = new ExDBFieldString<>("zrnkjtantoukanm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjtantoucd = new ExDBFieldString<>("zrnkjtantoucd", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjsystemnm = new ExDBFieldString<>("zrnkjsystemnm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikurikosikingaku = new ExDBFieldString<>("zrnkarikurikosikingaku", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikurikosikingaku = new ExDBFieldString<>("zrnkasikurikosikingaku", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrndenpyoukbnnm = new ExDBFieldString<>("zrndenpyoukbnnm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkarikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkarikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikurikosigkkingaku = new ExDBFieldString<>("zrnkarikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkasikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikurikosigkkingaku = new ExDBFieldString<>("zrnkasikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjtekiyou1 = new ExDBFieldString<>("zrnkjtekiyou1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjtekiyou2 = new ExDBFieldString<>("zrnkjtekiyou2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjtekiyou3 = new ExDBFieldString<>("zrnkjtekiyou3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkarikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkaritekiyoukm1 = new ExDBFieldString<>("zrnkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikingaku1 = new ExDBFieldString<>("zrnkarikingaku1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasitekiyoukm1 = new ExDBFieldString<>("zrnkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikingaku1 = new ExDBFieldString<>("zrnkasikingaku1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkaritekiyoukm1 = new ExDBFieldString<>("zrnkjkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasitekiyoukm1 = new ExDBFieldString<>("zrnkjkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkarikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkaritekiyoukm2 = new ExDBFieldString<>("zrnkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikingaku2 = new ExDBFieldString<>("zrnkarikingaku2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasitekiyoukm2 = new ExDBFieldString<>("zrnkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikingaku2 = new ExDBFieldString<>("zrnkasikingaku2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkaritekiyoukm2 = new ExDBFieldString<>("zrnkjkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasitekiyoukm2 = new ExDBFieldString<>("zrnkjkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkarikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkaritekiyoukm3 = new ExDBFieldString<>("zrnkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikingaku3 = new ExDBFieldString<>("zrnkarikingaku3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasitekiyoukm3 = new ExDBFieldString<>("zrnkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikingaku3 = new ExDBFieldString<>("zrnkasikingaku3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkaritekiyoukm3 = new ExDBFieldString<>("zrnkjkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasitekiyoukm3 = new ExDBFieldString<>("zrnkjkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkarikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkaritekiyoukm4 = new ExDBFieldString<>("zrnkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkarikingaku4 = new ExDBFieldString<>("zrnkarikingaku4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasitekiyoukm4 = new ExDBFieldString<>("zrnkasitekiyoukm4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkasikingaku4 = new ExDBFieldString<>("zrnkasikingaku4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkaritekiyoukm4 = new ExDBFieldString<>("zrnkjkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_SkKsnHurikaeRn, String> zrnkjkasitekiyoukm4 = new ExDBFieldString<>("zrnkjkasitekiyoukm4", this);
}
