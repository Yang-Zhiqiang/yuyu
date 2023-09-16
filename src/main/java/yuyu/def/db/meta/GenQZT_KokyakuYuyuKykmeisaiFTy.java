package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KokyakuYuyuKykmeisaiFTy extends AbstractExDBTable<ZT_KokyakuYuyuKykmeisaiFTy> {

    public GenQZT_KokyakuYuyuKykmeisaiFTy() {
        this("ZT_KokyakuYuyuKykmeisaiFTy");
    }

    public GenQZT_KokyakuYuyuKykmeisaiFTy(String pAlias) {
        super("ZT_KokyakuYuyuKykmeisaiFTy", ZT_KokyakuYuyuKykmeisaiFTy.class, pAlias);
    }

    public String ZT_KokyakuYuyuKykmeisaiFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyhrkmnenkansanp = new ExDBFieldNumber<>("ztyhrkmnenkansanp", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyengyousekihosyous = new ExDBFieldNumber<>("ztyyengyousekihosyous", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysymtymd = new ExDBFieldString<>("ztysymtymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyukeiyakukigou = new ExDBFieldString<>("ztysyukeiyakukigou", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysykykratesedaikbn = new ExDBFieldString<>("ztysykykratesedaikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyjyudkaigomehrtkarihyj = new ExDBFieldString<>("ztyjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztypmentokuyakukbn = new ExDBFieldString<>("ztypmentokuyakukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv158 = new ExDBFieldString<>("ztyyobiv158", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyknkyknm18 = new ExDBFieldString<>("ztyknkyknm18", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykyksyanen3 = new ExDBFieldString<>("ztykyksyanen3", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykykjikyksyanen = new ExDBFieldString<>("ztykykjikyksyanen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytuusinsakihumeihyj = new ExDBFieldString<>("ztytuusinsakihumeihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykihontikucd = new ExDBFieldString<>("ztykihontikucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytodouhukencd = new ExDBFieldString<>("ztytodouhukencd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysikutyousoncd5 = new ExDBFieldString<>("ztysikutyousoncd5", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykjadr62 = new ExDBFieldString<>("ztykjadr62", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytelno = new ExDBFieldString<>("ztytelno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztydai2telno = new ExDBFieldString<>("ztydai2telno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyknhhknmei = new ExDBFieldString<>("ztyknhhknmei", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhhknnen = new ExDBFieldString<>("ztyhhknnen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykykjihhknnen = new ExDBFieldString<>("ztykykjihhknnen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztymannenreikykhyj = new ExDBFieldString<>("ztymannenreikykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykyksyhhknsydouituhyouji = new ExDBFieldString<>("ztykyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykykjyutikbn = new ExDBFieldString<>("ztykykjyutikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytorihikikaisiymd = new ExDBFieldString<>("ztytorihikikaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztypowerfulhyj = new ExDBFieldString<>("ztypowerfulhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztylargehyj = new ExDBFieldString<>("ztylargehyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyouhinbunruikbn = new ExDBFieldString<>("ztysyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyouhnnmkbn = new ExDBFieldString<>("ztysyouhnnmkbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhknnmcd = new ExDBFieldString<>("ztyhknnmcd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytkbthsyukiknmanryouym = new ExDBFieldString<>("ztytkbthsyukiknmanryouym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyldownym = new ExDBFieldString<>("ztyldownym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhrkmanryouym = new ExDBFieldString<>("ztyhrkmanryouym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztymankiym = new ExDBFieldString<>("ztymankiym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, BizNumber> ztysykykyoteiriritu = new ExDBFieldString<>("ztysykykyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyrserieshyj = new ExDBFieldString<>("ztyrserieshyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyinfoteikyoutsghyj = new ExDBFieldString<>("ztyinfoteikyoutsghyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztynaimitukykhyj = new ExDBFieldString<>("ztynaimitukykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztykasitukenaimituhyj = new ExDBFieldString<>("ztykasitukenaimituhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuiarihyj = new ExDBFieldString<>("ztyttdktyuuiarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetkacd1 = new ExDBFieldString<>("ztyttdktyuuisetkacd1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetymd1 = new ExDBFieldString<>("ztyttdktyuuisetymd1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetkbn1 = new ExDBFieldString<>("ztyttdktyuuisetkbn1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetkacd2 = new ExDBFieldString<>("ztyttdktyuuisetkacd2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetymd2 = new ExDBFieldString<>("ztyttdktyuuisetymd2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuuisetkbn2 = new ExDBFieldString<>("ztyttdktyuuisetkbn2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyttdktyuui3kenijyouhyj = new ExDBFieldString<>("ztyttdktyuui3kenijyouhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztystknsetkykhyj = new ExDBFieldString<>("ztystknsetkykhyj", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenharaikomip = new ExDBFieldNumber<>("ztyyenharaikomip", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenkihons = new ExDBFieldNumber<>("ztyyenkihons", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyensibous = new ExDBFieldNumber<>("ztyyensibous", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysyuunoukeirokbn = new ExDBFieldString<>("ztysyuunoukeirokbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztycalckijyunymd = new ExDBFieldString<>("ztycalckijyunymd", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztytumitatedzndk = new ExDBFieldNumber<>("ztytumitatedzndk", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytumitatedzndkhunouhyj = new ExDBFieldString<>("ztytumitatedzndkhunouhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztydairitenatkihyj = new ExDBFieldString<>("ztydairitenatkihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou1sisyacd = new ExDBFieldString<>("ztytantou1sisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou1sibucd = new ExDBFieldString<>("ztytantou1sibucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou1kojincd = new ExDBFieldString<>("ztytantou1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou1tantoukaisiymd = new ExDBFieldString<>("ztytantou1tantoukaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou1tantousyakbn = new ExDBFieldString<>("ztytantou1tantousyakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou2sisyacd = new ExDBFieldString<>("ztytantou2sisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou2sibucd = new ExDBFieldString<>("ztytantou2sibucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou2kojincd = new ExDBFieldString<>("ztytantou2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou2tantoukaisiymd = new ExDBFieldString<>("ztytantou2tantoukaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytantou2tantousyakbn = new ExDBFieldString<>("ztytantou2tantousyakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysikijikbn = new ExDBFieldString<>("ztysikijikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou1sosikicd = new ExDBFieldString<>("ztyteikyou1sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou1kojincd = new ExDBFieldString<>("ztyteikyou1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou1tantoukbn = new ExDBFieldString<>("ztyteikyou1tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou2sosikicd = new ExDBFieldString<>("ztyteikyou2sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou2kojincd = new ExDBFieldString<>("ztyteikyou2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikyou2tantoukbn = new ExDBFieldString<>("ztyteikyou2tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyadrsyokansisyacd = new ExDBFieldString<>("ztyadrsyokansisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki1sosikicd = new ExDBFieldString<>("ztyhyukjsaki1sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki1kojincd = new ExDBFieldString<>("ztyhyukjsaki1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki1tantoukbn = new ExDBFieldString<>("ztyhyukjsaki1tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki2sosikicd = new ExDBFieldString<>("ztyhyukjsaki2sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki2kojincd = new ExDBFieldString<>("ztyhyukjsaki2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhyukjsaki2tantoukbn = new ExDBFieldString<>("ztyhyukjsaki2tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyinfotysytymd = new ExDBFieldString<>("ztyinfotysytymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhouteityotikuhknhyj = new ExDBFieldString<>("ztyhouteityotikuhknhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztydrctservicekbn = new ExDBFieldString<>("ztydrctservicekbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyhksuhngktkbtknjgnkbn = new ExDBFieldString<>("ztyhksuhngktkbtknjgnkbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztymkhyouyenhknhentkarihyj = new ExDBFieldString<>("ztymkhyouyenhknhentkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyenkhrikmtkarihyj = new ExDBFieldString<>("ztyyenkhrikmtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztystigihrikmtkarihyj = new ExDBFieldString<>("ztystigihrikmtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyenshrgksitihsyutkhyj = new ExDBFieldString<>("ztyyenshrgksitihsyutkhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, BizNumber> ztysiteituukaharaikomip = new ExDBFieldString<>("ztysiteituukaharaikomip", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyhrktuukaharaikomip = new ExDBFieldNumber<>("ztyhrktuukaharaikomip", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, BizNumber> ztysiteituukakihonsx2 = new ExDBFieldString<>("ztysiteituukakihonsx2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, BizNumber> ztysiteituukasibous = new ExDBFieldString<>("ztysiteituukasibous", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyteikisiharaiarihyj = new ExDBFieldString<>("ztyteikisiharaiarihyj", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenteikishrkngk = new ExDBFieldNumber<>("ztyyenteikishrkngk", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, BizNumber> ztysiteituukateikishrkngk = new ExDBFieldString<>("ztysiteituukateikishrkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv98 = new ExDBFieldString<>("ztyyobiv98", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenkihonhijynbris = new ExDBFieldNumber<>("ztyyenkihonhijynbris", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenkihonitijibarais = new ExDBFieldNumber<>("ztyyenkihonitijibarais", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenkihonhijynbrip = new ExDBFieldNumber<>("ztyyenkihonhijynbrip", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFTy, Long> ztyyenkihonitijibaraip = new ExDBFieldNumber<>("ztyyenkihonitijibaraip", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytrkkzk1trkarihyj = new ExDBFieldString<>("ztytrkkzk1trkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztytrkkzk2trkarihyj = new ExDBFieldString<>("ztytrkkzk2trkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyno7keta = new ExDBFieldString<>("ztyyno7keta", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv241 = new ExDBFieldString<>("ztyyobiv241", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv26 = new ExDBFieldString<>("ztyyobiv26", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv250x2 = new ExDBFieldString<>("ztyyobiv250x2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFTy, String> ztyyobiv50 = new ExDBFieldString<>("ztyyobiv50", this);
}
