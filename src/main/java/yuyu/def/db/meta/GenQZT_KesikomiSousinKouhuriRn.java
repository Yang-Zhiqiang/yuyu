package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriRn;

/**
 * 消込送信Ｆ（口振）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinKouhuriRn extends AbstractExDBTable<ZT_KesikomiSousinKouhuriRn> {

    public GenQZT_KesikomiSousinKouhuriRn() {
        this("ZT_KesikomiSousinKouhuriRn");
    }

    public GenQZT_KesikomiSousinKouhuriRn(String pAlias) {
        super("ZT_KesikomiSousinKouhuriRn", ZT_KesikomiSousinKouhuriRn.class, pAlias);
    }

    public String ZT_KesikomiSousinKouhuriRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmsousinrenno = new ExDBFieldString<>("zrnkskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmkamokucd = new ExDBFieldString<>("zrnkskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnsuitoukbn = new ExDBFieldString<>("zrnsuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnsuitousosikicd = new ExDBFieldString<>("zrnsuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhasseidenymd = new ExDBFieldString<>("zrnhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkarikanjyono = new ExDBFieldString<>("zrnkarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkkakusyounyuuryokuymd1 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrniktannaidantaizaikeikbn = new ExDBFieldString<>("zrniktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfanniskcd = new ExDBFieldString<>("zrnkskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndantaiannaijyuutouym1 = new ExDBFieldString<>("zrndantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnannaino1 = new ExDBFieldString<>("zrnannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnbonusharaihyouji1 = new ExDBFieldString<>("zrnbonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfkzhurikaebankcd = new ExDBFieldString<>("zrnkskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfhurikaeymd = new ExDBFieldString<>("zrnkskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndairitenuketukeno1 = new ExDBFieldString<>("zrndairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnzaikeihrkkaisuukbn1 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnoukinhyouno = new ExDBFieldString<>("zrnnoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfcreditkaisyacd = new ExDBFieldString<>("zrnkskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkinyuukikankbn = new ExDBFieldString<>("zrnkinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnyobiv18 = new ExDBFieldString<>("zrnyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfsyoriymd = new ExDBFieldString<>("zrnkskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfdenymd = new ExDBFieldString<>("zrnkskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndenatesakicd = new ExDBFieldString<>("zrndenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmftaisyakukbn = new ExDBFieldString<>("zrnkskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhutuuhokenkamokucd = new ExDBFieldString<>("zrnhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinKouhuriRn, Long> zrndengk = new ExDBFieldNumber<>("zrndengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrntabakariknjykskmdatakbn = new ExDBFieldString<>("zrntabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfryousyuuymd = new ExDBFieldString<>("zrnkskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnryousyuuhm = new ExDBFieldString<>("zrnryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkkakusyounyuuryokuymd2 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfsyono = new ExDBFieldString<>("zrnkskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkhoukokuhyoutantouka = new ExDBFieldString<>("zrnnkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkhoukokuhyoukihyouymd = new ExDBFieldString<>("zrnnkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkhoukokuhyoubunkaino = new ExDBFieldString<>("zrnnkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnkkakusyounyuuryokuno = new ExDBFieldString<>("zrnnkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfdantaicd = new ExDBFieldString<>("zrnkskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndantaiannaijyuutouym2 = new ExDBFieldString<>("zrndantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnbonusharaihyouji2 = new ExDBFieldString<>("zrnbonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnannaino2 = new ExDBFieldString<>("zrnannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndantaipkbn = new ExDBFieldString<>("zrndantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndantainyuukinymd = new ExDBFieldString<>("zrndantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfjyuutouym = new ExDBFieldString<>("zrnkskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnsuitouymd = new ExDBFieldString<>("zrnsuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnnyuuryokuhouhoukbn = new ExDBFieldString<>("zrnnyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfnyknaiyoukbn = new ExDBFieldString<>("zrnkskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkzhurikaekykhndnkhyouji = new ExDBFieldString<>("zrnkzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfdairitencd = new ExDBFieldString<>("zrnkskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrndairitenuketukeno2 = new ExDBFieldString<>("zrndairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnikkatudantaicd = new ExDBFieldString<>("zrnikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnikkatuannaihikisariym = new ExDBFieldString<>("zrnikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnikkatuannaino = new ExDBFieldString<>("zrnikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnzaikeihrkkaisuukbn2 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnzaikeikyksyano = new ExDBFieldString<>("zrnzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhasseisosikicd = new ExDBFieldString<>("zrnhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnteikeisakikaisyacd = new ExDBFieldString<>("zrnteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmfbankcd = new ExDBFieldString<>("zrnkskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnsuitousyorisosikicd = new ExDBFieldString<>("zrnsuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnaitekanjyouyomikaekbn = new ExDBFieldString<>("zrnaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrncreditcardhrkskmkbn = new ExDBFieldString<>("zrncreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnlastteiseiymd = new ExDBFieldString<>("zrnlastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmkanryouymd = new ExDBFieldString<>("zrnkskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmteiseino = new ExDBFieldString<>("zrnkskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnkskmkanryousijihyouji = new ExDBFieldString<>("zrnkskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnuketuketencd = new ExDBFieldString<>("zrnuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrncvscd = new ExDBFieldString<>("zrncvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhurikomiyousinyuukinkbn = new ExDBFieldString<>("zrnhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhurikomiyousiokyksmno = new ExDBFieldString<>("zrnhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnhurikomiyousikakuninno = new ExDBFieldString<>("zrnhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnegsyokuinhurikomiymd = new ExDBFieldString<>("zrnegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnvitkaiinno = new ExDBFieldString<>("zrnvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinKouhuriRn, String> zrnyobiv74 = new ExDBFieldString<>("zrnyobiv74", this);
}
