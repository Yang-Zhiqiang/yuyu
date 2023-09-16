package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeRn;

/**
 * 消込送信Ｆ（振替）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KesikomiSousinHurikaeRn extends AbstractExDBTable<ZT_KesikomiSousinHurikaeRn> {

    public GenQZT_KesikomiSousinHurikaeRn() {
        this("ZT_KesikomiSousinHurikaeRn");
    }

    public GenQZT_KesikomiSousinHurikaeRn(String pAlias) {
        super("ZT_KesikomiSousinHurikaeRn", ZT_KesikomiSousinHurikaeRn.class, pAlias);
    }

    public String ZT_KesikomiSousinHurikaeRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmsousinrenno = new ExDBFieldString<>("zrnkskmsousinrenno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmkamokucd = new ExDBFieldString<>("zrnkskmkamokucd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnsuitoukbn = new ExDBFieldString<>("zrnsuitoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnsuitousosikicd = new ExDBFieldString<>("zrnsuitousosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhasseidenymd = new ExDBFieldString<>("zrnhasseidenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkarikanjyono = new ExDBFieldString<>("zrnkarikanjyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkkakusyounyuuryokuymd1 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrniktannaidantaizaikeikbn = new ExDBFieldString<>("zrniktannaidantaizaikeikbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfanniskcd = new ExDBFieldString<>("zrnkskmfanniskcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndantaiannaijyuutouym1 = new ExDBFieldString<>("zrndantaiannaijyuutouym1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnannaino1 = new ExDBFieldString<>("zrnannaino1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnbonusharaihyouji1 = new ExDBFieldString<>("zrnbonusharaihyouji1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfkzhurikaebankcd = new ExDBFieldString<>("zrnkskmfkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfhurikaeymd = new ExDBFieldString<>("zrnkskmfhurikaeymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndairitenuketukeno1 = new ExDBFieldString<>("zrndairitenuketukeno1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnzaikeihrkkaisuukbn1 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn1", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnoukinhyouno = new ExDBFieldString<>("zrnnoukinhyouno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfcreditkaisyacd = new ExDBFieldString<>("zrnkskmfcreditkaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkinyuukikankbn = new ExDBFieldString<>("zrnkinyuukikankbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnyobiv18 = new ExDBFieldString<>("zrnyobiv18", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfsyoriymd = new ExDBFieldString<>("zrnkskmfsyoriymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfdenymd = new ExDBFieldString<>("zrnkskmfdenymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndenatesakicd = new ExDBFieldString<>("zrndenatesakicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmftaisyakukbn = new ExDBFieldString<>("zrnkskmftaisyakukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhutuuhokenkamokucd = new ExDBFieldString<>("zrnhutuuhokenkamokucd", this);

    public final ExDBFieldNumber<ZT_KesikomiSousinHurikaeRn, Long> zrndengk = new ExDBFieldNumber<>("zrndengk", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrntabakariknjykskmdatakbn = new ExDBFieldString<>("zrntabakariknjykskmdatakbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfryousyuuymd = new ExDBFieldString<>("zrnkskmfryousyuuymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnryousyuuhm = new ExDBFieldString<>("zrnryousyuuhm", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkkakusyounyuuryokuymd2 = new ExDBFieldString<>("zrnnkkakusyounyuuryokuymd2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfsyono = new ExDBFieldString<>("zrnkskmfsyono", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkhoukokuhyoutantouka = new ExDBFieldString<>("zrnnkhoukokuhyoutantouka", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkhoukokuhyoukihyouymd = new ExDBFieldString<>("zrnnkhoukokuhyoukihyouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkhoukokuhyoubunkaino = new ExDBFieldString<>("zrnnkhoukokuhyoubunkaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnkkakusyounyuuryokuno = new ExDBFieldString<>("zrnnkkakusyounyuuryokuno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfdantaicd = new ExDBFieldString<>("zrnkskmfdantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndantaiannaijyuutouym2 = new ExDBFieldString<>("zrndantaiannaijyuutouym2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnbonusharaihyouji2 = new ExDBFieldString<>("zrnbonusharaihyouji2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnannaino2 = new ExDBFieldString<>("zrnannaino2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndantaipkbn = new ExDBFieldString<>("zrndantaipkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndantainyuukinymd = new ExDBFieldString<>("zrndantainyuukinymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfjyuutouym = new ExDBFieldString<>("zrnkskmfjyuutouym", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnsuitouymd = new ExDBFieldString<>("zrnsuitouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnnyuuryokuhouhoukbn = new ExDBFieldString<>("zrnnyuuryokuhouhoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfnyknaiyoukbn = new ExDBFieldString<>("zrnkskmfnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkzhurikaekykhndnkhyouji = new ExDBFieldString<>("zrnkzhurikaekykhndnkhyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfdairitencd = new ExDBFieldString<>("zrnkskmfdairitencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrndairitenuketukeno2 = new ExDBFieldString<>("zrndairitenuketukeno2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnikkatudantaicd = new ExDBFieldString<>("zrnikkatudantaicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnikkatuannaihikisariym = new ExDBFieldString<>("zrnikkatuannaihikisariym", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnikkatuannaino = new ExDBFieldString<>("zrnikkatuannaino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnzaikeihrkkaisuukbn2 = new ExDBFieldString<>("zrnzaikeihrkkaisuukbn2", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnzaikeikyksyano = new ExDBFieldString<>("zrnzaikeikyksyano", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhasseisosikicd = new ExDBFieldString<>("zrnhasseisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnteikeisakikaisyacd = new ExDBFieldString<>("zrnteikeisakikaisyacd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmfbankcd = new ExDBFieldString<>("zrnkskmfbankcd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnsuitousyorisosikicd = new ExDBFieldString<>("zrnsuitousyorisosikicd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnaitekanjyouyomikaekbn = new ExDBFieldString<>("zrnaitekanjyouyomikaekbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrncreditcardhrkskmkbn = new ExDBFieldString<>("zrncreditcardhrkskmkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnlastteiseiymd = new ExDBFieldString<>("zrnlastteiseiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmkanryouymd = new ExDBFieldString<>("zrnkskmkanryouymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmteiseino = new ExDBFieldString<>("zrnkskmteiseino", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnkskmkanryousijihyouji = new ExDBFieldString<>("zrnkskmkanryousijihyouji", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnuketuketencd = new ExDBFieldString<>("zrnuketuketencd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrncvscd = new ExDBFieldString<>("zrncvscd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhurikomiyousinyuukinkbn = new ExDBFieldString<>("zrnhurikomiyousinyuukinkbn", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhurikomiyousiokyksmno = new ExDBFieldString<>("zrnhurikomiyousiokyksmno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnhurikomiyousikakuninno = new ExDBFieldString<>("zrnhurikomiyousikakuninno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnegsyokuinhurikomiymd = new ExDBFieldString<>("zrnegsyokuinhurikomiymd", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnvitkaiinno = new ExDBFieldString<>("zrnvitkaiinno", this);

    public final ExDBFieldString<ZT_KesikomiSousinHurikaeRn, String> zrnyobiv74 = new ExDBFieldString<>("zrnyobiv74", this);
}
