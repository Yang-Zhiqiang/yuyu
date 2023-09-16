package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditRn;

/**
 * 消込送信Ｆ（クレ払）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinCreditRn extends AbstractExDBTable<ZT_KesikomiSousinCreditRn> {

    public GenQZT_KesikomiSousinCreditRn() {
        this("ZT_KesikomiSousinCreditRn");
    }

    public GenQZT_KesikomiSousinCreditRn(String pAlias) {
        super("ZT_KesikomiSousinCreditRn", ZT_KesikomiSousinCreditRn.class, pAlias);
    }

    public String ZT_KesikomiSousinCreditRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmsousinrenno = new ExDBFieldString<>("zrnkskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmkamokucd = new ExDBFieldString<>("zrnkskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnsuitoukbn = new ExDBFieldString<>("zrnsuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnsuitousosikicd = new ExDBFieldString<>("zrnsuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhasseidenymd = new ExDBFieldString<>("zrnhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkarikanjyono = new ExDBFieldString<>("zrnkarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkkakusyounyuuryokuymd1 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrniktannaidantaizaikeikbn = new ExDBFieldString<>("zrniktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfanniskcd = new ExDBFieldString<>("zrnkskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndantaiannaijyuutouym1 = new ExDBFieldString<>("zrndantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnannaino1 = new ExDBFieldString<>("zrnannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnbonusharaihyouji1 = new ExDBFieldString<>("zrnbonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfkzhurikaebankcd = new ExDBFieldString<>("zrnkskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfhurikaeymd = new ExDBFieldString<>("zrnkskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndairitenuketukeno1 = new ExDBFieldString<>("zrndairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnzaikeihrkkaisuukbn1 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnoukinhyouno = new ExDBFieldString<>("zrnnoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfcreditkaisyacd = new ExDBFieldString<>("zrnkskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkinyuukikankbn = new ExDBFieldString<>("zrnkinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnyobiv18 = new ExDBFieldString<>("zrnyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfsyoriymd = new ExDBFieldString<>("zrnkskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfdenymd = new ExDBFieldString<>("zrnkskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndenatesakicd = new ExDBFieldString<>("zrndenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmftaisyakukbn = new ExDBFieldString<>("zrnkskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhutuuhokenkamokucd = new ExDBFieldString<>("zrnhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinCreditRn, Long> zrndengk = new ExDBFieldNumber<>("zrndengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrntabakariknjykskmdatakbn = new ExDBFieldString<>("zrntabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfryousyuuymd = new ExDBFieldString<>("zrnkskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnryousyuuhm = new ExDBFieldString<>("zrnryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkkakusyounyuuryokuymd2 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfsyono = new ExDBFieldString<>("zrnkskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkhoukokuhyoutantouka = new ExDBFieldString<>("zrnnkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkhoukokuhyoukihyouymd = new ExDBFieldString<>("zrnnkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkhoukokuhyoubunkaino = new ExDBFieldString<>("zrnnkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnkkakusyounyuuryokuno = new ExDBFieldString<>("zrnnkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfdantaicd = new ExDBFieldString<>("zrnkskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndantaiannaijyuutouym2 = new ExDBFieldString<>("zrndantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnbonusharaihyouji2 = new ExDBFieldString<>("zrnbonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnannaino2 = new ExDBFieldString<>("zrnannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndantaipkbn = new ExDBFieldString<>("zrndantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndantainyuukinymd = new ExDBFieldString<>("zrndantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfjyuutouym = new ExDBFieldString<>("zrnkskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnsuitouymd = new ExDBFieldString<>("zrnsuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnnyuuryokuhouhoukbn = new ExDBFieldString<>("zrnnyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfnyknaiyoukbn = new ExDBFieldString<>("zrnkskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkzhurikaekykhndnkhyouji = new ExDBFieldString<>("zrnkzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfdairitencd = new ExDBFieldString<>("zrnkskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrndairitenuketukeno2 = new ExDBFieldString<>("zrndairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnikkatudantaicd = new ExDBFieldString<>("zrnikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnikkatuannaihikisariym = new ExDBFieldString<>("zrnikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnikkatuannaino = new ExDBFieldString<>("zrnikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnzaikeihrkkaisuukbn2 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnzaikeikyksyano = new ExDBFieldString<>("zrnzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhasseisosikicd = new ExDBFieldString<>("zrnhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnteikeisakikaisyacd = new ExDBFieldString<>("zrnteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmfbankcd = new ExDBFieldString<>("zrnkskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnsuitousyorisosikicd = new ExDBFieldString<>("zrnsuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnaitekanjyouyomikaekbn = new ExDBFieldString<>("zrnaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrncreditcardhrkskmkbn = new ExDBFieldString<>("zrncreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnlastteiseiymd = new ExDBFieldString<>("zrnlastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmkanryouymd = new ExDBFieldString<>("zrnkskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmteiseino = new ExDBFieldString<>("zrnkskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnkskmkanryousijihyouji = new ExDBFieldString<>("zrnkskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnuketuketencd = new ExDBFieldString<>("zrnuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrncvscd = new ExDBFieldString<>("zrncvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhurikomiyousinyuukinkbn = new ExDBFieldString<>("zrnhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhurikomiyousiokyksmno = new ExDBFieldString<>("zrnhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnhurikomiyousikakuninno = new ExDBFieldString<>("zrnhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnegsyokuinhurikomiymd = new ExDBFieldString<>("zrnegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnvitkaiinno = new ExDBFieldString<>("zrnvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinCreditRn, String> zrnyobiv74 = new ExDBFieldString<>("zrnyobiv74", this);
}
