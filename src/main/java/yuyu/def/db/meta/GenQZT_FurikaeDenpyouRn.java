package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FurikaeDenpyouRn;

/**
 * 振替伝票テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FurikaeDenpyouRn extends AbstractExDBTable<ZT_FurikaeDenpyouRn> {

    public GenQZT_FurikaeDenpyouRn() {
        this("ZT_FurikaeDenpyouRn");
    }

    public GenQZT_FurikaeDenpyouRn(String pAlias) {
        super("ZT_FurikaeDenpyouRn", ZT_FurikaeDenpyouRn.class, pAlias);
    }

    public String ZT_FurikaeDenpyouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmksyoruicd = new ExDBFieldString<>("zrnkytkmksyoruicd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmktyouhyousksymd = new ExDBFieldString<>("zrnkytkmktyouhyousksymd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmksystemkbn = new ExDBFieldString<>("zrnkytkmksystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmktorihikino = new ExDBFieldString<>("zrnkytkmktorihikino", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmktorihikinoedano = new ExDBFieldString<>("zrnkytkmktorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmkseifukukbn = new ExDBFieldString<>("zrnkytkmkseifukukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmkfuridenhassoukbn = new ExDBFieldString<>("zrnkytkmkfuridenhassoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkytkmkyobi = new ExDBFieldString<>("zrnkytkmkyobi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnsystemkbn = new ExDBFieldString<>("zrnsystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikinoc8 = new ExDBFieldString<>("zrntorihikinoc8", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikinoedano = new ExDBFieldString<>("zrntorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjhikaeinjikm = new ExDBFieldString<>("zrnkjhikaeinjikm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikiymdgengokbn = new ExDBFieldString<>("zrntorihikiymdgengokbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikinen = new ExDBFieldString<>("zrntorihikinen", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikituki = new ExDBFieldString<>("zrntorihikituki", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrntorihikibi = new ExDBFieldString<>("zrntorihikibi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkanjyoukbn = new ExDBFieldString<>("zrnkanjyoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkanjyoukbnnm = new ExDBFieldString<>("zrnkanjyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjtantoukanm = new ExDBFieldString<>("zrnkjtantoukanm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjtantoucd = new ExDBFieldString<>("zrnkjtantoucd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjsystemnm = new ExDBFieldString<>("zrnkjsystemnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikurikosikingaku = new ExDBFieldString<>("zrnkarikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikurikosikingaku = new ExDBFieldString<>("zrnkasikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrndenpyoukbnnm = new ExDBFieldString<>("zrndenpyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkarikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkarikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikurikosigkkingaku = new ExDBFieldString<>("zrnkarikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasikurikosigkhyjkm = new ExDBFieldString<>("zrnkjkasikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikurikosigkkingaku = new ExDBFieldString<>("zrnkasikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjtekiyou1 = new ExDBFieldString<>("zrnkjtekiyou1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjtekiyou2 = new ExDBFieldString<>("zrnkjtekiyou2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjtekiyou3 = new ExDBFieldString<>("zrnkjtekiyou3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkarikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasikanjyoukamokunm1 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkaritekiyoukm1 = new ExDBFieldString<>("zrnkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikingaku1 = new ExDBFieldString<>("zrnkarikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasitekiyoukm1 = new ExDBFieldString<>("zrnkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikingaku1 = new ExDBFieldString<>("zrnkasikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkaritekiyoukm1 = new ExDBFieldString<>("zrnkjkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasitekiyoukm1 = new ExDBFieldString<>("zrnkjkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkarikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasikanjyoukamokunm2 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkaritekiyoukm2 = new ExDBFieldString<>("zrnkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikingaku2 = new ExDBFieldString<>("zrnkarikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasitekiyoukm2 = new ExDBFieldString<>("zrnkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikingaku2 = new ExDBFieldString<>("zrnkasikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkaritekiyoukm2 = new ExDBFieldString<>("zrnkjkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasitekiyoukm2 = new ExDBFieldString<>("zrnkjkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkarikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasikanjyoukamokunm3 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkaritekiyoukm3 = new ExDBFieldString<>("zrnkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikingaku3 = new ExDBFieldString<>("zrnkarikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasitekiyoukm3 = new ExDBFieldString<>("zrnkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikingaku3 = new ExDBFieldString<>("zrnkasikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkaritekiyoukm3 = new ExDBFieldString<>("zrnkjkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasitekiyoukm3 = new ExDBFieldString<>("zrnkjkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkarikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkarikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasikanjyoukamokunm4 = new ExDBFieldString<>("zrnkjkasikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkaritekiyoukm4 = new ExDBFieldString<>("zrnkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkarikingaku4 = new ExDBFieldString<>("zrnkarikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasitekiyoukm4 = new ExDBFieldString<>("zrnkasitekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkasikingaku4 = new ExDBFieldString<>("zrnkasikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkaritekiyoukm4 = new ExDBFieldString<>("zrnkjkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouRn, String> zrnkjkasitekiyoukm4 = new ExDBFieldString<>("zrnkjkasitekiyoukm4", this);
}
