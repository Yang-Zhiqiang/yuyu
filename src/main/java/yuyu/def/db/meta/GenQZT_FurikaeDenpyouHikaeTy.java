package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeTy;

/**
 * 振替伝票（控）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FurikaeDenpyouHikaeTy extends AbstractExDBTable<ZT_FurikaeDenpyouHikaeTy> {

    public GenQZT_FurikaeDenpyouHikaeTy() {
        this("ZT_FurikaeDenpyouHikaeTy");
    }

    public GenQZT_FurikaeDenpyouHikaeTy(String pAlias) {
        super("ZT_FurikaeDenpyouHikaeTy", ZT_FurikaeDenpyouHikaeTy.class, pAlias);
    }

    public String ZT_FurikaeDenpyouHikaeTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmksyoruicd = new ExDBFieldString<>("ztykytkmksyoruicd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmktyouhyousksymd = new ExDBFieldString<>("ztykytkmktyouhyousksymd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmksystemkbn = new ExDBFieldString<>("ztykytkmksystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmktorihikino = new ExDBFieldString<>("ztykytkmktorihikino", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmktorihikinoedano = new ExDBFieldString<>("ztykytkmktorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmkseifukukbn = new ExDBFieldString<>("ztykytkmkseifukukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmkfuridenhassoukbn = new ExDBFieldString<>("ztykytkmkfuridenhassoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykytkmkyobi = new ExDBFieldString<>("ztykytkmkyobi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztysystemkbn = new ExDBFieldString<>("ztysystemkbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikinoc8 = new ExDBFieldString<>("ztytorihikinoc8", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikinoedano = new ExDBFieldString<>("ztytorihikinoedano", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjhikaeinjikm = new ExDBFieldString<>("ztykjhikaeinjikm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikiymdgengokbn = new ExDBFieldString<>("ztytorihikiymdgengokbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikinen = new ExDBFieldString<>("ztytorihikinen", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikituki = new ExDBFieldString<>("ztytorihikituki", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztytorihikibi = new ExDBFieldString<>("ztytorihikibi", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykanjyoukbn = new ExDBFieldString<>("ztykanjyoukbn", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykanjyoukbnnm = new ExDBFieldString<>("ztykanjyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjtantoukanm = new ExDBFieldString<>("ztykjtantoukanm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjtantoucd = new ExDBFieldString<>("ztykjtantoucd", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjsystemnm = new ExDBFieldString<>("ztykjsystemnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikurikosikingaku = new ExDBFieldString<>("ztykarikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikurikosikingaku = new ExDBFieldString<>("ztykasikurikosikingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztydenpyoukbnnm = new ExDBFieldString<>("ztydenpyoukbnnm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkarikurikosigkhyjkm = new ExDBFieldString<>("ztykjkarikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikurikosigkkingaku = new ExDBFieldString<>("ztykarikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasikurikosigkhyjkm = new ExDBFieldString<>("ztykjkasikurikosigkhyjkm", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikurikosigkkingaku = new ExDBFieldString<>("ztykasikurikosigkkingaku", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjtekiyou1 = new ExDBFieldString<>("ztykjtekiyou1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjtekiyou2 = new ExDBFieldString<>("ztykjtekiyou2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjtekiyou3 = new ExDBFieldString<>("ztykjtekiyou3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkarikanjyoukamokunm1 = new ExDBFieldString<>("ztykjkarikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasikanjyoukamokunm1 = new ExDBFieldString<>("ztykjkasikanjyoukamokunm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykaritekiyoukm1 = new ExDBFieldString<>("ztykaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikingaku1 = new ExDBFieldString<>("ztykarikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasitekiyoukm1 = new ExDBFieldString<>("ztykasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikingaku1 = new ExDBFieldString<>("ztykasikingaku1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkaritekiyoukm1 = new ExDBFieldString<>("ztykjkaritekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasitekiyoukm1 = new ExDBFieldString<>("ztykjkasitekiyoukm1", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkarikanjyoukamokunm2 = new ExDBFieldString<>("ztykjkarikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasikanjyoukamokunm2 = new ExDBFieldString<>("ztykjkasikanjyoukamokunm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykaritekiyoukm2 = new ExDBFieldString<>("ztykaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikingaku2 = new ExDBFieldString<>("ztykarikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasitekiyoukm2 = new ExDBFieldString<>("ztykasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikingaku2 = new ExDBFieldString<>("ztykasikingaku2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkaritekiyoukm2 = new ExDBFieldString<>("ztykjkaritekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasitekiyoukm2 = new ExDBFieldString<>("ztykjkasitekiyoukm2", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkarikanjyoukamokunm3 = new ExDBFieldString<>("ztykjkarikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasikanjyoukamokunm3 = new ExDBFieldString<>("ztykjkasikanjyoukamokunm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykaritekiyoukm3 = new ExDBFieldString<>("ztykaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikingaku3 = new ExDBFieldString<>("ztykarikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasitekiyoukm3 = new ExDBFieldString<>("ztykasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikingaku3 = new ExDBFieldString<>("ztykasikingaku3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkaritekiyoukm3 = new ExDBFieldString<>("ztykjkaritekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasitekiyoukm3 = new ExDBFieldString<>("ztykjkasitekiyoukm3", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkarikanjyoukamokunm4 = new ExDBFieldString<>("ztykjkarikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasikanjyoukamokunm4 = new ExDBFieldString<>("ztykjkasikanjyoukamokunm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykaritekiyoukm4 = new ExDBFieldString<>("ztykaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykarikingaku4 = new ExDBFieldString<>("ztykarikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasitekiyoukm4 = new ExDBFieldString<>("ztykasitekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykasikingaku4 = new ExDBFieldString<>("ztykasikingaku4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkaritekiyoukm4 = new ExDBFieldString<>("ztykjkaritekiyoukm4", this);

    public final ExDBFieldString<ZT_FurikaeDenpyouHikaeTy, String> ztykjkasitekiyoukm4 = new ExDBFieldString<>("ztykjkasitekiyoukm4", this);
}
