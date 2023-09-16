package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriTy;

/**
 * 消込送信Ｆ（口振）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinKouhuriTy extends AbstractExDBTable<ZT_KesikomiSousinKouhuriTy> {

    public GenQZT_KesikomiSousinKouhuriTy() {
        this("ZT_KesikomiSousinKouhuriTy");
    }

    public GenQZT_KesikomiSousinKouhuriTy(String pAlias) {
        super("ZT_KesikomiSousinKouhuriTy", ZT_KesikomiSousinKouhuriTy.class, pAlias);
    }

    public String ZT_KesikomiSousinKouhuriTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmsousinrenno = new ExDBFieldString<>("ztykskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmkamokucd = new ExDBFieldString<>("ztykskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztysuitoukbn = new ExDBFieldString<>("ztysuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztysuitousosikicd = new ExDBFieldString<>("ztysuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhasseidenymd = new ExDBFieldString<>("ztyhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykarikanjyono = new ExDBFieldString<>("ztykarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkkakusyounyuuryokuymd1 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyiktannaidantaizaikeikbn = new ExDBFieldString<>("ztyiktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfanniskcd = new ExDBFieldString<>("ztykskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydantaiannaijyuutouym1 = new ExDBFieldString<>("ztydantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyannaino1 = new ExDBFieldString<>("ztyannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztybonusharaihyouji1 = new ExDBFieldString<>("ztybonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfkzhurikaebankcd = new ExDBFieldString<>("ztykskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfhurikaeymd = new ExDBFieldString<>("ztykskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydairitenuketukeno1 = new ExDBFieldString<>("ztydairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyzaikeihrkkaisuukbn1 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynoukinhyouno = new ExDBFieldString<>("ztynoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfcreditkaisyacd = new ExDBFieldString<>("ztykskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykinyuukikankbn = new ExDBFieldString<>("ztykinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyyobiv18 = new ExDBFieldString<>("ztyyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfsyoriymd = new ExDBFieldString<>("ztykskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfdenymd = new ExDBFieldString<>("ztykskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydenatesakicd = new ExDBFieldString<>("ztydenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmftaisyakukbn = new ExDBFieldString<>("ztykskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhutuuhokenkamokucd = new ExDBFieldString<>("ztyhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinKouhuriTy, Long> ztydengk = new ExDBFieldNumber<>("ztydengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztytabakariknjykskmdatakbn = new ExDBFieldString<>("ztytabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfryousyuuymd = new ExDBFieldString<>("ztykskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyryousyuuhm = new ExDBFieldString<>("ztyryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkkakusyounyuuryokuymd2 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfsyono = new ExDBFieldString<>("ztykskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkhoukokuhyoutantouka = new ExDBFieldString<>("ztynkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkhoukokuhyoukihyouymd = new ExDBFieldString<>("ztynkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkhoukokuhyoubunkaino = new ExDBFieldString<>("ztynkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynkkakusyounyuuryokuno = new ExDBFieldString<>("ztynkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfdantaicd = new ExDBFieldString<>("ztykskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydantaiannaijyuutouym2 = new ExDBFieldString<>("ztydantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztybonusharaihyouji2 = new ExDBFieldString<>("ztybonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyannaino2 = new ExDBFieldString<>("ztyannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydantaipkbn = new ExDBFieldString<>("ztydantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydantainyuukinymd = new ExDBFieldString<>("ztydantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfjyuutouym = new ExDBFieldString<>("ztykskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztysuitouymd = new ExDBFieldString<>("ztysuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztynyuuryokuhouhoukbn = new ExDBFieldString<>("ztynyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfnyknaiyoukbn = new ExDBFieldString<>("ztykskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykzhurikaekykhndnkhyouji = new ExDBFieldString<>("ztykzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfdairitencd = new ExDBFieldString<>("ztykskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztydairitenuketukeno2 = new ExDBFieldString<>("ztydairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyikkatudantaicd = new ExDBFieldString<>("ztyikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyikkatuannaihikisariym = new ExDBFieldString<>("ztyikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyikkatuannaino = new ExDBFieldString<>("ztyikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyzaikeihrkkaisuukbn2 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyzaikeikyksyano = new ExDBFieldString<>("ztyzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhasseisosikicd = new ExDBFieldString<>("ztyhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyteikeisakikaisyacd = new ExDBFieldString<>("ztyteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmfbankcd = new ExDBFieldString<>("ztykskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztysuitousyorisosikicd = new ExDBFieldString<>("ztysuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyaitekanjyouyomikaekbn = new ExDBFieldString<>("ztyaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztycreditcardhrkskmkbn = new ExDBFieldString<>("ztycreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztylastteiseiymd = new ExDBFieldString<>("ztylastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmkanryouymd = new ExDBFieldString<>("ztykskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmteiseino = new ExDBFieldString<>("ztykskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztykskmkanryousijihyouji = new ExDBFieldString<>("ztykskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyuketuketencd = new ExDBFieldString<>("ztyuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztycvscd = new ExDBFieldString<>("ztycvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhurikomiyousinyuukinkbn = new ExDBFieldString<>("ztyhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhurikomiyousiokyksmno = new ExDBFieldString<>("ztyhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyhurikomiyousikakuninno = new ExDBFieldString<>("ztyhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyegsyokuinhurikomiymd = new ExDBFieldString<>("ztyegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyvitkaiinno = new ExDBFieldString<>("ztyvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriTy, String> ztyyobiv74 = new ExDBFieldString<>("ztyyobiv74", this);
}
