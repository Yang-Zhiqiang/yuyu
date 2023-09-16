package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;

/**
 * 消込送信Ｆ（クレ払）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinCreditTy extends AbstractExDBTable<ZT_KesikomiSousinCreditTy> {

    public GenQZT_KesikomiSousinCreditTy() {
        this("ZT_KesikomiSousinCreditTy");
    }

    public GenQZT_KesikomiSousinCreditTy(String pAlias) {
        super("ZT_KesikomiSousinCreditTy", ZT_KesikomiSousinCreditTy.class, pAlias);
    }

    public String ZT_KesikomiSousinCreditTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmsousinrenno = new ExDBFieldString<>("ztykskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmkamokucd = new ExDBFieldString<>("ztykskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztysuitoukbn = new ExDBFieldString<>("ztysuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztysuitousosikicd = new ExDBFieldString<>("ztysuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhasseidenymd = new ExDBFieldString<>("ztyhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykarikanjyono = new ExDBFieldString<>("ztykarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkkakusyounyuuryokuymd1 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyiktannaidantaizaikeikbn = new ExDBFieldString<>("ztyiktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfanniskcd = new ExDBFieldString<>("ztykskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydantaiannaijyuutouym1 = new ExDBFieldString<>("ztydantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyannaino1 = new ExDBFieldString<>("ztyannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztybonusharaihyouji1 = new ExDBFieldString<>("ztybonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfkzhurikaebankcd = new ExDBFieldString<>("ztykskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfhurikaeymd = new ExDBFieldString<>("ztykskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydairitenuketukeno1 = new ExDBFieldString<>("ztydairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyzaikeihrkkaisuukbn1 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynoukinhyouno = new ExDBFieldString<>("ztynoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfcreditkaisyacd = new ExDBFieldString<>("ztykskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykinyuukikankbn = new ExDBFieldString<>("ztykinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyyobiv18 = new ExDBFieldString<>("ztyyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfsyoriymd = new ExDBFieldString<>("ztykskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfdenymd = new ExDBFieldString<>("ztykskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydenatesakicd = new ExDBFieldString<>("ztydenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmftaisyakukbn = new ExDBFieldString<>("ztykskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhutuuhokenkamokucd = new ExDBFieldString<>("ztyhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinCreditTy, Long> ztydengk = new ExDBFieldNumber<>("ztydengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztytabakariknjykskmdatakbn = new ExDBFieldString<>("ztytabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfryousyuuymd = new ExDBFieldString<>("ztykskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyryousyuuhm = new ExDBFieldString<>("ztyryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkkakusyounyuuryokuymd2 = new ExDBFieldString<>("ztynkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfsyono = new ExDBFieldString<>("ztykskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkhoukokuhyoutantouka = new ExDBFieldString<>("ztynkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkhoukokuhyoukihyouymd = new ExDBFieldString<>("ztynkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkhoukokuhyoubunkaino = new ExDBFieldString<>("ztynkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynkkakusyounyuuryokuno = new ExDBFieldString<>("ztynkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfdantaicd = new ExDBFieldString<>("ztykskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydantaiannaijyuutouym2 = new ExDBFieldString<>("ztydantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztybonusharaihyouji2 = new ExDBFieldString<>("ztybonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyannaino2 = new ExDBFieldString<>("ztyannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydantaipkbn = new ExDBFieldString<>("ztydantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydantainyuukinymd = new ExDBFieldString<>("ztydantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfjyuutouym = new ExDBFieldString<>("ztykskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztysuitouymd = new ExDBFieldString<>("ztysuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztynyuuryokuhouhoukbn = new ExDBFieldString<>("ztynyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfnyknaiyoukbn = new ExDBFieldString<>("ztykskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykzhurikaekykhndnkhyouji = new ExDBFieldString<>("ztykzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfdairitencd = new ExDBFieldString<>("ztykskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztydairitenuketukeno2 = new ExDBFieldString<>("ztydairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyikkatudantaicd = new ExDBFieldString<>("ztyikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyikkatuannaihikisariym = new ExDBFieldString<>("ztyikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyikkatuannaino = new ExDBFieldString<>("ztyikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyzaikeihrkkaisuukbn2 = new ExDBFieldString<>("ztyzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyzaikeikyksyano = new ExDBFieldString<>("ztyzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhasseisosikicd = new ExDBFieldString<>("ztyhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyteikeisakikaisyacd = new ExDBFieldString<>("ztyteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmfbankcd = new ExDBFieldString<>("ztykskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztysuitousyorisosikicd = new ExDBFieldString<>("ztysuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyaitekanjyouyomikaekbn = new ExDBFieldString<>("ztyaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztycreditcardhrkskmkbn = new ExDBFieldString<>("ztycreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztylastteiseiymd = new ExDBFieldString<>("ztylastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmkanryouymd = new ExDBFieldString<>("ztykskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmteiseino = new ExDBFieldString<>("ztykskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztykskmkanryousijihyouji = new ExDBFieldString<>("ztykskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyuketuketencd = new ExDBFieldString<>("ztyuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztycvscd = new ExDBFieldString<>("ztycvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhurikomiyousinyuukinkbn = new ExDBFieldString<>("ztyhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhurikomiyousiokyksmno = new ExDBFieldString<>("ztyhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyhurikomiyousikakuninno = new ExDBFieldString<>("ztyhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyegsyokuinhurikomiymd = new ExDBFieldString<>("ztyegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyvitkaiinno = new ExDBFieldString<>("ztyvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditTy, String> ztyyobiv74 = new ExDBFieldString<>("ztyyobiv74", this);
}
