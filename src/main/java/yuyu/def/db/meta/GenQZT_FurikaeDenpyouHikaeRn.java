package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeRn;

/**
 * 振替伝票（控）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FurikaeDenpyouHikaeRn extends AbstractExDBTable<ZT_FurikaeDenpyouHikaeRn> {

    public GenQZT_FurikaeDenpyouHikaeRn() {
        this("ZT_FurikaeDenpyouHikaeRn");
    }

    public GenQZT_FurikaeDenpyouHikaeRn(String pAlias) {
        super("ZT_FurikaeDenpyouHikaeRn", ZT_FurikaeDenpyouHikaeRn.class, pAlias);
    }

    public String ZT_FurikaeDenpyouHikaeRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmksyoruicd = new ExDBFieldString<>("zrnkytkmksyoruicd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmktyouhyousksymd = new ExDBFieldString<>("zrnkytkmktyouhyousksymd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmksystemkbn = new ExDBFieldString<>("zrnkytkmksystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmktorihikino = new ExDBFieldString<>("zrnkytkmktorihikino", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmktorihikinoedano = new ExDBFieldString<>("zrnkytkmktorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmkseifukukbn = new ExDBFieldString<>("zrnkytkmkseifukukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmkfuridenhassoukbn = new ExDBFieldString<>("zrnkytkmkfuridenhassoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkytkmkyobi = new ExDBFieldString<>("zrnkytkmkyobi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnsystemkbn = new ExDBFieldString<>("zrnsystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikinoc8 = new ExDBFieldString<>("zrntorihikinoc8", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikinoedano = new ExDBFieldString<>("zrntorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjhikaeinjikm = new ExDBFieldString<>("zrnkjhikaeinjikm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikiymdgengokbn = new ExDBFieldString<>("zrntorihikiymdgengokbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikinen = new ExDBFieldString<>("zrntorihikinen", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikituki = new ExDBFieldString<>("zrntorihikituki", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrntorihikibi = new ExDBFieldString<>("zrntorihikibi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkanjyoukbn = new ExDBFieldString<>("zrnkanjyoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkanjyoukbnnm = new ExDBFieldString<>("zrnkanjyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjtantoukanm = new ExDBFieldString<>("zrnkjtantoukanm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjtantoucd = new ExDBFieldString<>("zrnkjtantoucd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjsystemnm = new ExDBFieldString<>("zrnkjsystemnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikurikosikingaku = new ExDBFieldString<>("zrnkarikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikurikosikingaku = new ExDBFieldString<>("zrnkasikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrndenpyoukbnnm = new ExDBFieldString<>("zrndenpyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkarikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkarikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikurikosigkkingaku = new ExDBFieldString<>("zrnkarikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkasikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikurikosigkkingaku = new ExDBFieldString<>("zrnkasikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjtekiyou1 = new ExDBFieldString<>("zrnkjtekiyou1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjtekiyou2 = new ExDBFieldString<>("zrnkjtekiyou2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjtekiyou3 = new ExDBFieldString<>("zrnkjtekiyou3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkarikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkaritekiyoukm1 = new ExDBFieldString<>("zrnkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikingaku1 = new ExDBFieldString<>("zrnkarikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasitekiyoukm1 = new ExDBFieldString<>("zrnkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikingaku1 = new ExDBFieldString<>("zrnkasikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkaritekiyoukm1 = new ExDBFieldString<>("zrnkjkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasitekiyoukm1 = new ExDBFieldString<>("zrnkjkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkarikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkaritekiyoukm2 = new ExDBFieldString<>("zrnkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikingaku2 = new ExDBFieldString<>("zrnkarikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasitekiyoukm2 = new ExDBFieldString<>("zrnkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikingaku2 = new ExDBFieldString<>("zrnkasikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkaritekiyoukm2 = new ExDBFieldString<>("zrnkjkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasitekiyoukm2 = new ExDBFieldString<>("zrnkjkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkarikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkaritekiyoukm3 = new ExDBFieldString<>("zrnkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikingaku3 = new ExDBFieldString<>("zrnkarikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasitekiyoukm3 = new ExDBFieldString<>("zrnkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikingaku3 = new ExDBFieldString<>("zrnkasikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkaritekiyoukm3 = new ExDBFieldString<>("zrnkjkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasitekiyoukm3 = new ExDBFieldString<>("zrnkjkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkarikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkaritekiyoukm4 = new ExDBFieldString<>("zrnkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkarikingaku4 = new ExDBFieldString<>("zrnkarikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasitekiyoukm4 = new ExDBFieldString<>("zrnkasitekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkasikingaku4 = new ExDBFieldString<>("zrnkasikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkaritekiyoukm4 = new ExDBFieldString<>("zrnkjkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeRn, String> zrnkjkasitekiyoukm4 = new ExDBFieldString<>("zrnkjkasitekiyoukm4", this);
}
