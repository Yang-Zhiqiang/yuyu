package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeTy;

/**
 * 消込送信Ｆ（振替）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinHurikaeTy extends AbstractExDBTable<ZT_KesikomiSousinHurikaeTy> {

    public GenQZT_KesikomiSousinHurikaeTy() {
        this("ZT_KesikomiSousinHurikaeTy");
    }

    public GenQZT_KesikomiSousinHurikaeTy(String pAlias) {
        super("ZT_KesikomiSousinHurikaeTy", ZT_KesikomiSousinHurikaeTy.class, pAlias);
    }

    public String ZT_KesikomiSousinHurikaeTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmsousinrenno = new ExDBFieldString<>("ztykskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmkamokucd = new ExDBFieldString<>("ztykskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztysuitoukbn = new ExDBFieldString<>("ztysuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztysuitousosikicd = new ExDBFieldString<>("ztysuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhasseidenymd = new ExDBFieldString<>("ztyhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykarikanjyono = new ExDBFieldString<>("ztykarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkkakusyounyuuryokuymd1 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyiktannaidantaizaikeikbn = new ExDBFieldString<>("ztyiktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfanniskcd = new ExDBFieldString<>("ztykskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydantaiannaijyuutouym1 = new ExDBFieldString<>("ztydantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyannaino1 = new ExDBFieldString<>("ztyannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztybonusharaihyouji1 = new ExDBFieldString<>("ztybonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfkzhurikaebankcd = new ExDBFieldString<>("ztykskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfhurikaeymd = new ExDBFieldString<>("ztykskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydairitenuketukeno1 = new ExDBFieldString<>("ztydairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyzaikeihrkkaisuukbn1 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynoukinhyouno = new ExDBFieldString<>("ztynoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfcreditkaisyacd = new ExDBFieldString<>("ztykskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykinyuukikankbn = new ExDBFieldString<>("ztykinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyyobiv18 = new ExDBFieldString<>("ztyyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfsyoriymd = new ExDBFieldString<>("ztykskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfdenymd = new ExDBFieldString<>("ztykskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydenatesakicd = new ExDBFieldString<>("ztydenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmftaisyakukbn = new ExDBFieldString<>("ztykskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhutuuhokenkamokucd = new ExDBFieldString<>("ztyhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinHurikaeTy, Long> ztydengk = new ExDBFieldNumber<>("ztydengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztytabakariknjykskmdatakbn = new ExDBFieldString<>("ztytabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfryousyuuymd = new ExDBFieldString<>("ztykskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyryousyuuhm = new ExDBFieldString<>("ztyryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkkakusyounyuuryokuymd2 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfsyono = new ExDBFieldString<>("ztykskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkhoukokuhyoutantouka = new ExDBFieldString<>("ztynkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkhoukokuhyoukihyouymd = new ExDBFieldString<>("ztynkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkhoukokuhyoubunkaino = new ExDBFieldString<>("ztynkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynkkakusyounyuuryokuno = new ExDBFieldString<>("ztynkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfdantaicd = new ExDBFieldString<>("ztykskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydantaiannaijyuutouym2 = new ExDBFieldString<>("ztydantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztybonusharaihyouji2 = new ExDBFieldString<>("ztybonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyannaino2 = new ExDBFieldString<>("ztyannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydantaipkbn = new ExDBFieldString<>("ztydantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydantainyuukinymd = new ExDBFieldString<>("ztydantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfjyuutouym = new ExDBFieldString<>("ztykskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztysuitouymd = new ExDBFieldString<>("ztysuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztynyuuryokuhouhoukbn = new ExDBFieldString<>("ztynyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfnyknaiyoukbn = new ExDBFieldString<>("ztykskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykzhurikaekykhndnkhyouji = new ExDBFieldString<>("ztykzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfdairitencd = new ExDBFieldString<>("ztykskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztydairitenuketukeno2 = new ExDBFieldString<>("ztydairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyikkatudantaicd = new ExDBFieldString<>("ztyikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyikkatuannaihikisariym = new ExDBFieldString<>("ztyikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyikkatuannaino = new ExDBFieldString<>("ztyikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyzaikeihrkkaisuukbn2 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyzaikeikyksyano = new ExDBFieldString<>("ztyzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhasseisosikicd = new ExDBFieldString<>("ztyhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyteikeisakikaisyacd = new ExDBFieldString<>("ztyteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmfbankcd = new ExDBFieldString<>("ztykskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztysuitousyorisosikicd = new ExDBFieldString<>("ztysuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyaitekanjyouyomikaekbn = new ExDBFieldString<>("ztyaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztycreditcardhrkskmkbn = new ExDBFieldString<>("ztycreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztylastteiseiymd = new ExDBFieldString<>("ztylastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmkanryouymd = new ExDBFieldString<>("ztykskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmteiseino = new ExDBFieldString<>("ztykskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztykskmkanryousijihyouji = new ExDBFieldString<>("ztykskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyuketuketencd = new ExDBFieldString<>("ztyuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztycvscd = new ExDBFieldString<>("ztycvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhurikomiyousinyuukinkbn = new ExDBFieldString<>("ztyhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhurikomiyousiokyksmno = new ExDBFieldString<>("ztyhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyhurikomiyousikakuninno = new ExDBFieldString<>("ztyhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyegsyokuinhurikomiymd = new ExDBFieldString<>("ztyegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyvitkaiinno = new ExDBFieldString<>("ztyvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeTy, String> ztyyobiv74 = new ExDBFieldString<>("ztyyobiv74", this);
}
